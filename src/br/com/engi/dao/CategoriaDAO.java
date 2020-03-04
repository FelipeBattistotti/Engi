package br.com.engi.dao;

import java.util.List;

import org.hibernate.Query;

import br.com.engi.model.Categoria;
import br.com.engi.util.DAOException;

public class CategoriaDAO extends DAO<Categoria> {

	@Override
	public void salvar(Categoria model) throws DAOException {}
	
	// POR NÃO PODER ALTERAR A ASSINATURA DE UM METODO HERDADO 
	// OPTAMOS PELA CRIACAO DE UM NOVO METODO SALVAR
	public Categoria salvarCategoria(Categoria model) throws DAOException {
					   // merge: mescla objeto da sessao do JSF com 
					   // 		 objeto da sessao do Hibernate
		Categoria merged = (Categoria) sessao.merge(model);
		sessao.flush();
		sessao.clear();
		return merged;
	}
	

	@Override
	public void excluir(Categoria model) throws DAOException {
		model = obterPorId(model);
		sessao.delete(model);
		sessao.flush();
		sessao.clear();
	}

	@Override
	public Categoria obterPorId(Categoria filtro) throws DAOException {
		return (Categoria) sessao.get(Categoria.class, filtro.getCodigo());
	}

	@Override
	public List<Categoria> pesquisar(Categoria filtros) throws DAOException {
		// hql ==  HOBERNATE QUERY LANGUAGE
		String hql = "select c from Categoria c where c.pai is null and c.usuario = :usuario";
		Query query = sessao.createQuery(hql);
		
		// aqui se refere ao codigo do usuario
		query.setInteger("usuario", filtros.getUsuario().getCodigo());
		
		return query.list();
	}

}

















