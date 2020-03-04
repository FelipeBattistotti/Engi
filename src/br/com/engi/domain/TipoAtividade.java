package br.com.engi.domain;

public enum TipoAtividade {
	
	/**
	 * Documento de Or�amento
	 */
	DOC_ORC("Doc Orc"),
	
	/**
	 * Documento de Engenharia
	 */
	DOC_ENG("Doc Eng"),
	
	/**
	 * C�digo Fonte
	 */
	COD_FONTE("Cod Fonte"),
	
	/**
	 * Tabela
	 */
	TABELA("Tabela"),
	
	/**
	 * Sugest�o Contexto
	 */
	SUGESTAO("Sugest�o");
	
	private String descricao;
	
	private TipoAtividade(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
	
}