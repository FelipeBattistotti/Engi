package br.com.engi.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * Classe que representa a chave primaria de cheque
 * 
 * @Embeddable --> Siginifica que será embutida em outra classe
 */
@Embeddable
public class ChequeId implements Serializable{

	private static final long serialVersionUID = 3242329360912801192L;

	private Integer cheque;

	private Integer conta;

	public Integer getCheque() {
		return cheque;
	}

	public void setCheque(Integer cheque) {
		this.cheque = cheque;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cheque == null) ? 0 : cheque.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ChequeId)) {
			return false;
		}
		ChequeId other = (ChequeId) obj;
		if (cheque == null) {
			if (other.cheque != null) {
				return false;
			}
		} else if (!cheque.equals(other.cheque)) {
			return false;
		}
		if (conta == null) {
			if (other.conta != null) {
				return false;
			}
		} else if (!conta.equals(other.conta)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ChequeID [" + (cheque != null ? "cheque=" + cheque + ", " : "")
				+ (conta != null ? "conta=" + conta : "") + "]";
	}

}
