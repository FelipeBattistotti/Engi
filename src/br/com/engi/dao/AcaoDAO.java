package br.com.engi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.engi.model.Acao;
import br.com.engi.util.DAOException;

public class AcaoDAO extends DAO<Acao> {

	@Override
	public void salvar(Acao model) throws DAOException {
		sessao.saveOrUpdate(model);
	}

	@Override
	public void excluir(Acao model) throws DAOException {
		sessao.delete(model);
	}

	@Override
	public Acao obterPorId(Acao filtro) throws DAOException {
		return (Acao) sessao.get(Acao.class, filtro.getCodigo());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Acao> pesquisar(Acao filtros) throws DAOException {
		Criteria criteria = sessao.createCriteria(Acao.class);
		criteria.add(Restrictions.eq("usuario", filtros.getUsuario()));
		return criteria.list();
	}
}
