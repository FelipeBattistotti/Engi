package br.com.engi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.engi.model.Conta;
import br.com.engi.model.Usuario;
import br.com.engi.util.DAOException;

public class ContaDAO extends DAO<Conta> {

	@Override
	public void salvar(Conta model) throws DAOException {
		sessao.saveOrUpdate(model);
	}

	@Override
	public void excluir(Conta model) throws DAOException {
		sessao.delete(model);
	}

	@Override
	public Conta obterPorId(Conta filtro) throws DAOException {
		// sempre a classe (entity) e o valor da PK
		// DownCast or UpCasting estou descendo na arvore de heranca
		// o get retorna uma instancia de Object mas eu quero reduzir issop
		// para Conta
		return (Conta) sessao.get(Conta.class, filtro.getCodigo());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Conta> pesquisar(Conta filtros) throws DAOException {
		// SELECT * FROM CONTA
		Criteria criteria = sessao.createCriteria(Conta.class);
		
		// where usuario = ?
		criteria.add(Restrictions.eq("usuario", filtros.getUsuario()));
		
		return criteria.list();
	}
	
	public Conta buscarFavorita(Usuario u){
		// SELECT * FROM CONTA
		Criteria criteria = sessao.createCriteria(Conta.class);
		
		// where usuario = ?
		criteria.add(Restrictions.eq("usuario", u));
		criteria.add(Restrictions.eq("favorita", true));
		
		return (Conta) criteria.uniqueResult();
	}

}


















