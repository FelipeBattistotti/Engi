package br.com.engi.negocio;

import java.util.List;

import br.com.engi.dao.CategoriaDAO;
import br.com.engi.model.Categoria;
import br.com.engi.model.Usuario;
import br.com.engi.util.DAOException;
import br.com.engi.util.RNException;

public class CategoriaRN extends RN<Categoria> {
	
	public CategoriaRN() {
		super(new CategoriaDAO());
	}

	// n�o podemos alterar a assinatura de um metodo herdado, por isso 
	// n�o podemos alterar o metodo para retornar uma categoria
	// pois em IRN o metodo salvar � void
	@Override
	public void salvar(Categoria categoria) throws RNException {
		try {
			if(categoria.getPai() == null){
				throw new RNException("A categoria "+categoria.getDescricao()+" deve ter um pai.");
			}
			
			// Caso a categoria estive-se como receita e mudasse para despesa por ex.
			boolean mudouFator = categoria.getPai().getFator() != categoria.getFator();
			
			categoria.setFator(categoria.getPai().getFator());
			
			// qual o tipo do atributo dao --> DAO muito generico
			// DownCasting --> converter o dao para CategoriaDAO
			categoria = ((CategoriaDAO)dao).salvarCategoria(categoria);
			
			if(mudouFator){
				categoria = obterPorId(categoria);
				replicarFator(categoria, categoria.getFator());
			}
			
		} catch (DAOException e) {
			throw new RNException("Ops, n�o foi poss�vel salvar a categoria, contate o suporte.....");
		}
		
	}

	private void replicarFator(Categoria categoria, int fator) throws RNException {
		try {
			if (categoria.getFilhos() != null) {
				for (Categoria filho : categoria.getFilhos()) {
					filho.setFator(fator);
					((CategoriaDAO)dao).salvarCategoria(filho); // e sim este
					
					replicarFator(filho, fator);
				}
			}		
		} catch (DAOException e) {
			throw new RNException("ops n�o foi possivel replicar o fator...");
		}
	}

	@Override
	public void excluir(Categoria model) throws RNException {
		try {
			dao.excluir(model);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}
	public void excluir(Usuario us) throws RNException {
		List<Categoria> categoriasDoUsuario = pesquisar(new Categoria(us));
		
		for (Categoria categoria : categoriasDoUsuario) {
			excluir(categoria);
		}
	}

	@Override
	public Categoria obterPorId(Categoria filtro) throws RNException {
		try {
			return dao.obterPorId(filtro);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}

	@Override
	public List<Categoria> pesquisar(Categoria filtros) throws RNException {
		try {
			return dao.pesquisar(filtros);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}

	/**
	 * M�todo a ser chamado sempre da CRIA��O de um Usuario
	 * criando as categorias PADR�ES para um novo usuario
	 * @param usuario
	 */
	public void salvaEstruturaPadrao(Usuario usuario) {

		try {
			CategoriaDAO cDAO = (CategoriaDAO) dao;
			
			/*
			 * As categorias serao classificadas como:
			 * 
			 *  - Despesas (negativo) � uma sa�da de caixa
			 *  - Receita  (positivo) � uma entrada de caixa
			 */
			
			// Aqui � o �nico lugar que se cria uma categoria SEM PAI
			Categoria despesas = new Categoria(null, usuario, "DESPESAS", -1);
		
			// AP�S SALVAR O PAI
			despesas = cDAO.salvarCategoria(despesas);
			
			// cria as filhas default do sistema
			cDAO.salvarCategoria(new Categoria(despesas, usuario, "Moradia", -1));
			cDAO.salvarCategoria(new Categoria(despesas, usuario, "Alimenta��o", -1));
			cDAO.salvarCategoria(new Categoria(despesas, usuario, "Vestu�rio", -1));
			cDAO.salvarCategoria(new Categoria(despesas, usuario, "Deslocamento", -1));
			cDAO.salvarCategoria(new Categoria(despesas, usuario, "Cuidados Pessoais", -1));
			cDAO.salvarCategoria(new Categoria(despesas, usuario, "Educa��o", -1));
			cDAO.salvarCategoria(new Categoria(despesas, usuario, "Sa�de", -1));
			cDAO.salvarCategoria(new Categoria(despesas, usuario, "Lazer", -1));
			cDAO.salvarCategoria(new Categoria(despesas, usuario, "Despesas Financeiras", -1));
			
			
			Categoria receitas = new Categoria(null, usuario, "RECEITAS", 1);
			receitas = cDAO.salvarCategoria(receitas);
			cDAO.salvarCategoria(new Categoria(receitas, usuario, "Sal�rio", 1));
			cDAO.salvarCategoria(new Categoria(receitas, usuario, "Restitui��es", 1));
			cDAO.salvarCategoria(new Categoria(receitas, usuario, "Rendimento", 1));
			
		} catch (DAOException e) {
			e.printStackTrace();
		}
	}
}
