package br.com.engi.dao;

import java.util.List;

import br.com.engi.util.DAOException;

/**
 * Interface que define as assinaturas padr�es das DAOs do sistema
 * @param <T> - Entidade que ser� persistida/pesquisada
 */
public interface IDAO<T> {

	/**
	 * Assinatura padr�o para os m�todos Inserir/Alterar
	 * @param model - entidade a ser inserida/alterada
	 * @throws DAOException
	 */
	void salvar(T model) throws DAOException;
	
	/**
	 * Assinatura padr�o para o m�todo Excluir
	 * @param model - entidade a ser excluida
	 * @throws DAOException
	 */
	void excluir(T model) throws DAOException;
	
	/**
	 * Assinatura padr�o para o que busca um registro pela PK
	 * @param model - entidade contendo a PK populada
	 * @throws DAOException
	 */
	T obterPorId(T filtro) throws DAOException;

	/**
	 * Assinatura padr�o para o que pesquisa N registros
	 * de acordo com os filtros informados no <T> model
	 * @param model - entidade contendo a PK populada
	 * @throws DAOException
	 */
	List<T> pesquisar(T filtros) throws DAOException;
	
}













