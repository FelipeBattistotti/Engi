package br.com.engi.dao;

import java.util.List;

import org.hibernate.Query;

import br.com.engi.model.Usuario;
import br.com.engi.util.DAOException;

public class UsuarioDAO extends DAO<Usuario> {

	@Override
	public void salvar(Usuario model) throws DAOException {
		sessao.save(model);
	}
	
	// Override apenas para métodos HERDADOS
	public void atualizar(Usuario usuario) throws DAOException {
		
		// Quando vem da tela de cadastro/edição de usuarios nao se tem as permissoes
		if(usuario.getPermissao() == null || usuario.getPermissao().size() ==0){
			Usuario usPerm = obterPorId(usuario);
			usuario.setPermissao(usPerm.getPermissao());

			// remove objeto da sessao para evitar duplicidade de objetos
			// com o mesmo identificador ao se executar o sessao.update...
			sessao.evict(usPerm);
		}
		
		sessao.update(usuario);
	}

	@Override
	public void excluir(Usuario model) throws DAOException {
		sessao.delete(model);
	}

	@Override
	public Usuario obterPorId(Usuario filtro) throws DAOException {
		// Método get espera uma classe e uma INSTANCIA DA PK
		return (Usuario) sessao.get(Usuario.class, filtro.getCodigo());
	}

	@Override
	public List<Usuario> pesquisar(Usuario filtros) throws DAOException {
		// retorna uma lista de usuarios (Select * from usuarios)
		// por ser list generico. Não sabe que vai retornar um List<Usuario>
		// por isso da warning. Mas nós temos certeza pelo fato
		// de estarmos setando Usuario.class
		return sessao.createCriteria(Usuario.class).list();
	}
	
	public Usuario buscarPorLogin(String login){
		String hql = "select u from Usuario u where u.login = :login";
		Query consulta = sessao.createQuery(hql);
		consulta.setString("login", login);
		
		return (Usuario) consulta.uniqueResult();
	}

}

















