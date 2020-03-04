package br.com.engi.domain;

/**
 * Enum: S�o tipos com valores pr�-definidos
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
	 * N�o emitido
	 */
	N("N�o emitido");
	
	private String descricao;

	/**
	 * O Construtor � privado, logo NUNCA se criara new Enum()
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
