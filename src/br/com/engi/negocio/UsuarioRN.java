package br.com.engi.negocio;

import java.util.List;

import br.com.engi.dao.UsuarioDAO;
import br.com.engi.model.Conta;
import br.com.engi.model.Usuario;
import br.com.engi.util.DAOException;
import br.com.engi.util.RNException;

public class UsuarioRN extends RN<Usuario> {

	public UsuarioRN() {
		super(new UsuarioDAO());
	}
	

	@Override
	public void salvar(Usuario model) throws RNException {

		if(model.getCodigo() == null){
			Usuario u = buscarPorLogin(model.getLogin());
			if(u != null){
				throw new RNException("J� existe um usu�rio com o login informado");
			}
			try {
				// Na cria��o adiciona-se a permiss�o padr�o
				model.getPermissao().add("ROLE_USUARIO");
				
				dao.salvar(model);
				
				// aqui criamos a estrutura padr�o das categorias
				// para um NOVO usuario
				CategoriaRN crn = new CategoriaRN();
				crn.salvaEstruturaPadrao(model);
				
			} catch (DAOException e) {
				throw new RNException("N�o foi poss�vel inserir chame o suporte");
			}
		} else {
			try {
				((UsuarioDAO) dao).atualizar(model);
			} catch (DAOException e) {
				throw new RNException("N�o foi poss�vel alterar chame o suporte");
			}
		}
	}

	@Override
	public void excluir(Usuario model) throws RNException {
		try {

			ContaRN crn = new ContaRN();
			
			List<Conta> contasDoUsuario = crn.pesquisar(new Conta(model));
			
			// Se nao for vazio, 
			if(!contasDoUsuario.isEmpty()){
throw new RNException("N�o � poss�vel excluir este usuario, o mesmo "
		+ "possui contas ativas.");
			}

			dao.excluir(model);
		} catch (DAOException e) {
			// converti uma DAO em RN Exception
			throw new RNException("N�o foi possivel excluir o usuario.. Contate o suporte");
		}
	}

	@Override
	public Usuario obterPorId(Usuario filtro) throws RNException {
		try {
			return dao.obterPorId(filtro);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}

	@Override
	public List<Usuario> pesquisar(Usuario filtros) throws RNException {
		try {
			return dao.pesquisar(filtros);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}

	public Usuario buscarPorLogin(String login){
		// DownCasting: dao � muito generico e nao sabe dos m�todos
		//			    especificos de UsuarioDAO
		UsuarioDAO userDao = (UsuarioDAO) dao;  
		return userDao.buscarPorLogin(login);
//		return ((UsuarioDAO) dao).buscarPorLogin(login);
	}
}











