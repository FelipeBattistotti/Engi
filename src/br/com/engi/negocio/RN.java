package br.com.engi.negocio;

import br.com.engi.dao.IDAO;

/**
 * Classe Pai de todas as classes de neg�cio
 * 
 * @param <T> - Entidade a ser persistida/pesquisada
 */
public abstract class RN<T> implements IRN<T> {

	/**
	 * Atributo generico a TODAS as RNs para opera��es
	 * padr�es �s DAOs
	 */
	protected final IDAO<T> dao;
	
	/**
	 * Construtor para inicializar a instancia da DAO
	 */
	public RN(IDAO<T> dao) {
		super();
		this.dao = dao;
	}
}








