package br.com.engi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="fato_fatura_contrat")
public class FatoFaturaContrat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7377712224236469124L;
	
	@Id
	@Column(name="nr_insc_contratante")
	private Integer nrInscContratante;
	
	@Id
	@Column(name="cd_contratante")
	private Integer cdContratante;
	
	@Id
	@Column(name="nr_fatura")
	private Integer nrFatura;
	
	@Column(name="nm_contratante")
	private String  nmContratante;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_emissao")
	private Date    dtEmissao;
	
	@Column(name="vl_total")
	private BigDecimal vlTotal;
	
	public FatoFaturaContrat() {
		super();
	}
	
	public FatoFaturaContrat(Integer nrInscContratante, Integer cdContratante,
			Integer nrFatura, String nmContratante, Date dtEmissao,
			BigDecimal vlTotal) {
		super();
		this.nrInscContratante = nrInscContratante;
		this.cdContratante = cdContratante;
		this.nrFatura = nrFatura;
		this.nmContratante = nmContratante;
		this.dtEmissao = dtEmissao;
		this.vlTotal = vlTotal;
	}

	public Integer getNrInscContratante() {
		return nrInscContratante;
	}

	public void setNrInscContratante(Integer nrInscContratante) {
		this.nrInscContratante = nrInscContratante;
	}

	public Integer getCdContratante() {
		return cdContratante;
	}

	public void setCdContratante(Integer cdContratante) {
		this.cdContratante = cdContratante;
	}

	public Integer getNrFatura() {
		return nrFatura;
	}

	public void setNrFatura(Integer nrFatura) {
		this.nrFatura = nrFatura;
	}

	public String getNmContratante() {
		return nmContratante;
	}

	public void setNmContratante(String nmContratante) {
		this.nmContratante = nmContratante;
	}

	public Date getDtEmissao() {
		return dtEmissao;
	}

	public void setDtEmissao(Date dtEmissao) {
		this.dtEmissao = dtEmissao;
	}

	public BigDecimal getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(BigDecimal vlTotal) {
		this.vlTotal = vlTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cdContratante == null) ? 0 : cdContratante.hashCode());
		result = prime * result
				+ ((dtEmissao == null) ? 0 : dtEmissao.hashCode());
		result = prime * result
				+ ((nmContratante == null) ? 0 : nmContratante.hashCode());
		result = prime * result
				+ ((nrFatura == null) ? 0 : nrFatura.hashCode());
		result = prime
				* result
				+ ((nrInscContratante == null) ? 0 : nrInscContratante
						.hashCode());
		result = prime * result + ((vlTotal == null) ? 0 : vlTotal.hashCode());
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
		FatoFaturaContrat other = (FatoFaturaContrat) obj;
		if (cdContratante == null) {
			if (other.cdContratante != null)
				return false;
		} else if (!cdContratante.equals(other.cdContratante))
			return false;
		if (dtEmissao == null) {
			if (other.dtEmissao != null)
				return false;
		} else if (!dtEmissao.equals(other.dtEmissao))
			return false;
		if (nmContratante == null) {
			if (other.nmContratante != null)
				return false;
		} else if (!nmContratante.equals(other.nmContratante))
			return false;
		if (nrFatura == null) {
			if (other.nrFatura != null)
				return false;
		} else if (!nrFatura.equals(other.nrFatura))
			return false;
		if (nrInscContratante == null) {
			if (other.nrInscContratante != null)
				return false;
		} else if (!nrInscContratante.equals(other.nrInscContratante))
			return false;
		if (vlTotal == null) {
			if (other.vlTotal != null)
				return false;
		} else if (!vlTotal.equals(other.vlTotal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FatoFaturaContrat [nrInscContratante=" + nrInscContratante
				+ ", cdContratante=" + cdContratante + ", nrFatura=" + nrFatura
				+ ", nmContratante=" + nmContratante + ", dtEmissao="
				+ dtEmissao + ", vlTotal=" + vlTotal + "]";
	}
	
}
