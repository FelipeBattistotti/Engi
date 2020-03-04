package br.com.engi.domain;

/**
 * Enum: São tipos com valores pré-definidos
 */
public enum SituacaoCheque {

	/**
	 * Baixado
	 */
	B("Baixado"),
	
	/**
	 * Cancelado
	 */
	C("Cancelado"),
	
	/**
	 * Não emitido
	 */
	N("Não emitido");
	
	private String descricao;

	/**
	 * O Construtor é privado, logo NUNCA se criara new Enum()
	 * @param descricao
	 */
	private SituacaoCheque(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return descricao;
	}
}
