package br.com.engi.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.engi.model.Cheque;
import br.com.engi.util.DAOException;

public class ChequeDAO extends DAO<Cheque> {

	@Override
	public void salvar(Cheque cheque) throws DAOException {
		sessao.saveOrUpdate(cheque);
	}

	@Override
	public void excluir(Cheque cheque) throws DAOException {
		sessao.delete(cheque);
	}

	@Override
	public Cheque obterPorId(Cheque cheque) throws DAOException {
		return (Cheque) sessao.get(Cheque.class, cheque.getChequeId());
	}

	@Override
	public List<Cheque> pesquisar(Cheque filtros) throws DAOException {
		Criteria criteria = sessao.createCriteria(Cheque.class);
		criteria.add(Restrictions.eq("conta", filtros.getConta()));
		return criteria.list();
	}

}
