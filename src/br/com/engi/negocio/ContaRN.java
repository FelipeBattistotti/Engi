package br.com.engi.negocio;

import java.util.Date;
import java.util.List;

import br.com.engi.dao.ContaDAO;
import br.com.engi.model.Conta;
import br.com.engi.model.Usuario;
import br.com.engi.util.DAOException;
import br.com.engi.util.RNException;

public class ContaRN extends RN<Conta> {

	public ContaRN() {
		super(new ContaDAO());
	}
	
	
	@Override
	public void salvar(Conta model) throws RNException {
		try {
			model.setDataCadastro(new Date());
			dao.salvar(model);
		} catch (DAOException e) {
			throw new RNException("Não foi possivel salvar a conta, tente mais tarde");
		}
	}

	@Override
	public void excluir(Conta model) throws RNException {
		try {
			dao.excluir(model);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}

	@Override
	public Conta obterPorId(Conta filtro) throws RNException {
		try {
			return dao.obterPorId(filtro);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}

	@Override
	public List<Conta> pesquisar(Conta filtros) throws RNException {
		try {
			return dao.pesquisar(filtros);
		} catch (DAOException e) {
			throw new RNException(e);
		}
	}

	
	public void tornarFavorita(Conta contaFavorita) throws RNException{
//		ContaDAO cDao = (ContaDAO) dao;	// Downcasting
//		Conta c = cDao.buscarFavorita(contaFavorita.getUsuario());
		Conta c = buscarFavorita(contaFavorita.getUsuario());
		
		
		// ALT + Shift + M
		
		//Caso encontre, deve-se "desfavoritar" a mesma
		if(c != null){
			c.setFavorita(false);
			salvar(c);
		}
		
		// torna a conta que veio da tela como favorita
		contaFavorita.setFavorita(true);
		salvar(contaFavorita);
	}

	public Conta buscarFavorita(Usuario usuario) {
		return ((ContaDAO) dao).buscarFavorita(usuario);
	}
	
	
}















