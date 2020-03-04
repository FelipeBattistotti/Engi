package br.com.engi.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.annotations.OrderBy;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.engi.model.Conta;
import br.com.engi.model.Lancamento;
import br.com.engi.util.DAOException;

public class LancamentoDAO extends DAO<Lancamento> {

	@Override
	public void salvar(Lancamento model) throws DAOException {
		sessao.saveOrUpdate(model);
	}

	@Override
	public void excluir(Lancamento model) throws DAOException {
		sessao.delete(model);
	}

	@Override
	public Lancamento obterPorId(Lancamento filtro) throws DAOException {
		return (Lancamento) sessao.get(Lancamento.class, filtro.getCodigo());
	}

	@Override
	public List<Lancamento> pesquisar(Lancamento filtros) throws DAOException {
		return null;
	}
	
	public List<Lancamento> pesquisar(Conta c, Date dtInicio, Date dtFim) throws DAOException {
		
		Criteria criteria = sessao.createCriteria(Lancamento.class);
		
		if(dtInicio != null && dtFim != null){
			criteria.add(Restrictions.between("data", dtInicio, dtFim));
			
		} else if(dtInicio != null){
			// ge == Maior ou Igual a
			criteria.add(Restrictions.ge("data", dtInicio));
			
		} else if(dtFim != null){
			criteria.add(Restrictions.le("data", dtFim));
		}
		
		criteria.add(Restrictions.eq("conta", c));
		criteria.addOrder(Order.asc("data"));
		
		return criteria.list();
	}
	
	public float saldo(Conta conta, Date data) {
		StringBuffer sql = new StringBuffer();
		sql.append("select sum(l.valor * c.fator)");
		sql.append(" from LANCAMENTO l, CATEGORIA c");
		sql.append(" where l.categoria = c.codigo and l.conta = :conta and l.data <= :data");
		
		SQLQuery query = sessao.createSQLQuery(sql.toString());
		query.setParameter("conta", conta.getCodigo());
		query.setParameter("data", data);
		
		BigDecimal saldo = (BigDecimal) query.uniqueResult();
		
		if (saldo != null) {
			return saldo.floatValue();
		}
		
		return 0f;
	}
}

















