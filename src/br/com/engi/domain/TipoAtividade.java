package br.com.engi.domain;

public enum TipoAtividade {
	
	/**
	 * Documento de Orçamento
	 */
	DOC_ORC("Doc Orc"),
	
	/**
	 * Documento de Engenharia
	 */
	DOC_ENG("Doc Eng"),
	
	/**
	 * Código Fonte
	 */
	COD_FONTE("Cod Fonte"),
	
	/**
	 * Tabela
	 */
	TABELA("Tabela"),
	
	/**
	 * Sugestão Contexto
	 */
	SUGESTAO("Sugestão");
	
	private String descricao;
	
	private TipoAtividade(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
	public String toString() {
		return descricao;
	}
	
}