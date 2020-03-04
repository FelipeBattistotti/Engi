package br.com.engi.vo;

import br.com.engi.model.Acao;


/**
 * VO --> Visual Object
 * Padrão é: NomePojo+VO --> para casos onde se terá
 * 							 campos calculados, que não estejam
 * 							 presentes na classe inicial, ou mesmo
 * 							 quando de uma consulta SQL complexa
 * 							 que resulte em um numero x de campos
 * 							 das tabelas que compoem a consulta.
 */
public class AcaoVO {

	private Acao acao = new Acao();
	private float ultimoPreco;
	private float total;

	public Acao getAcao() {
		return acao;
	}

	public void setAcao(Acao acao) {
		this.acao = acao;
	}

	public float getUltimoPreco() {
		return ultimoPreco;
	}

	public void setUltimoPreco(float ultimoPreco) {
		this.ultimoPreco = ultimoPreco;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

}
