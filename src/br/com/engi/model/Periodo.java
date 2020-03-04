package br.com.engi.model;

import java.io.Serializable;

public class Periodo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1282335243753613831L;
	
	private Integer nrMes;
	private Integer nrAno;
	private String  descPeriodo;
	
	public Periodo() {
		super();
	}

	public Periodo(Integer nrMes, Integer nrAno) {
		super();
		this.nrMes = nrMes;
		this.nrAno = nrAno;
	}

	public Periodo(Integer nrMes, Integer nrAno, String descPeriodo) {
		super();
		this.nrMes = nrMes;
		this.nrAno = nrAno;
		this.descPeriodo = descPeriodo;
	}

	public Integer getNrMes() {
		return nrMes;
	}

	public void setNrMes(Integer nrMes) {
		this.nrMes = nrMes;
	}

	public Integer getNrAno() {
		return nrAno;
	}

	public void setNrAno(Integer nrAno) {
		this.nrAno = nrAno;
	}

	public String getDescPeriodo() {
		return descPeriodo;
	}

	public void setDescPeriodo(String descPeriodo) {
		this.descPeriodo = descPeriodo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descPeriodo == null) ? 0 : descPeriodo.hashCode());
		result = prime * result + ((nrAno == null) ? 0 : nrAno.hashCode());
		result = prime * result + ((nrMes == null) ? 0 : nrMes.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Periodo other = (Periodo) obj;
		if (descPeriodo == null) {
			if (other.descPeriodo != null)
				return false;
		} else if (!descPeriodo.equals(other.descPeriodo))
			return false;
		if (nrAno == null) {
			if (other.nrAno != null)
				return false;
		} else if (!nrAno.equals(other.nrAno))
			return false;
		if (nrMes == null) {
			if (other.nrMes != null)
				return false;
		} else if (!nrMes.equals(other.nrMes))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Periodo [nrMes=" + nrMes + ", nrAno=" + nrAno
				+ ", descPeriodo=" + descPeriodo + "]";
	}
	
}