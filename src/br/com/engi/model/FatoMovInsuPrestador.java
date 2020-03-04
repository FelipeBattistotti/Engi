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
@Table(name="fato_mov_insu_prestador")
public class FatoMovInsuPrestador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7932884873961907970L;
	
	@Id
	@Column(name="cd_unidade")
	private Integer cdUnidade;
	
	@Id
	@Column(name="cd_prestador")
	private Integer cdPrestador;
	
	@Id
	@Column(name="cd_transacao")
	private Integer cdTransacao;
	
	@Id
	@Column(name="nr_serie_doc_origina")
	private String  nrSerieDocOrigina;
	
	@Id
	@Column(name="cd_tipo_insumo")
	private Integer cdTipoInsumo;
	
	@Id
	@Column(name="cd_insumo")
	private Integer cdInsumo;
	
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name="dt_realizacao")
	private Date    dtRealizacao;
	
	@Id
	@Column(name="vl_insumo")
	private BigDecimal vlInsumo;
	
	@Column(name="nm_prestador")
	private String  nmPrestador;
	
	public FatoMovInsuPrestador() {
		super();
	}

	public FatoMovInsuPrestador(Integer cdUnidade, Integer cdPrestador,
			Integer cdTransacao, String nrSerieDocOrigina,
			Integer cdTipoInsumo, Integer cdInsumo, Date dtRealizacao,
			BigDecimal vlInsumo, String nmPrestador) {
		super();
		this.cdUnidade = cdUnidade;
		this.cdPrestador = cdPrestador;
		this.cdTransacao = cdTransacao;
		this.nrSerieDocOrigina = nrSerieDocOrigina;
		this.cdTipoInsumo = cdTipoInsumo;
		this.cdInsumo = cdInsumo;
		this.dtRealizacao = dtRealizacao;
		this.vlInsumo = vlInsumo;
		this.nmPrestador = nmPrestador;
	}

	public Integer getCdUnidade() {
		return cdUnidade;
	}

	public void setCdUnidade(Integer cdUnidade) {
		this.cdUnidade = cdUnidade;
	}

	public Integer getCdPrestador() {
		return cdPrestador;
	}

	public void setCdPrestador(Integer cdPrestador) {
		this.cdPrestador = cdPrestador;
	}

	public Integer getCdTransacao() {
		return cdTransacao;
	}

	public void setCdTransacao(Integer cdTransacao) {
		this.cdTransacao = cdTransacao;
	}

	public String getNrSerieDocOrigina() {
		return nrSerieDocOrigina;
	}

	public void setNrSerieDocOrigina(String nrSerieDocOrigina) {
		this.nrSerieDocOrigina = nrSerieDocOrigina;
	}

	public Integer getCdTipoInsumo() {
		return cdTipoInsumo;
	}

	public void setCdTipoInsumo(Integer cdTipoInsumo) {
		this.cdTipoInsumo = cdTipoInsumo;
	}

	public Integer getCdInsumo() {
		return cdInsumo;
	}

	public void setCdInsumo(Integer cdInsumo) {
		this.cdInsumo = cdInsumo;
	}

	public Date getDtRealizacao() {
		return dtRealizacao;
	}

	public void setDtRealizacao(Date dtRealizacao) {
		this.dtRealizacao = dtRealizacao;
	}

	public BigDecimal getVlInsumo() {
		return vlInsumo;
	}

	public void setVlInsumo(BigDecimal vlInsumo) {
		this.vlInsumo = vlInsumo;
	}

	public String getNmPrestador() {
		return nmPrestador;
	}

	public void setNmPrestador(String nmPrestador) {
		this.nmPrestador = nmPrestador;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cdInsumo == null) ? 0 : cdInsumo.hashCode());
		result = prime * result
				+ ((cdPrestador == null) ? 0 : cdPrestador.hashCode());
		result = prime * result
				+ ((cdTipoInsumo == null) ? 0 : cdTipoInsumo.hashCode());
		result = prime * result
				+ ((cdTransacao == null) ? 0 : cdTransacao.hashCode());
		result = prime * result
				+ ((cdUnidade == null) ? 0 : cdUnidade.hashCode());
		result = prime * result
				+ ((dtRealizacao == null) ? 0 : dtRealizacao.hashCode());
		result = prime * result
				+ ((nmPrestador == null) ? 0 : nmPrestador.hashCode());
		result = prime
				* result
				+ ((nrSerieDocOrigina == null) ? 0 : nrSerieDocOrigina
						.hashCode());
		result = prime * result
				+ ((vlInsumo == null) ? 0 : vlInsumo.hashCode());
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
		FatoMovInsuPrestador other = (FatoMovInsuPrestador) obj;
		if (cdInsumo == null) {
			if (other.cdInsumo != null)
				return false;
		} else if (!cdInsumo.equals(other.cdInsumo))
			return false;
		if (cdPrestador == null) {
			if (other.cdPrestador != null)
				return false;
		} else if (!cdPrestador.equals(other.cdPrestador))
			return false;
		if (cdTipoInsumo == null) {
			if (other.cdTipoInsumo != null)
				return false;
		} else if (!cdTipoInsumo.equals(other.cdTipoInsumo))
			return false;
		if (cdTransacao == null) {
			if (other.cdTransacao != null)
				return false;
		} else if (!cdTransacao.equals(other.cdTransacao))
			return false;
		if (cdUnidade == null) {
			if (other.cdUnidade != null)
				return false;
		} else if (!cdUnidade.equals(other.cdUnidade))
			return false;
		if (dtRealizacao == null) {
			if (other.dtRealizacao != null)
				return false;
		} else if (!dtRealizacao.equals(other.dtRealizacao))
			return false;
		if (nmPrestador == null) {
			if (other.nmPrestador != null)
				return false;
		} else if (!nmPrestador.equals(other.nmPrestador))
			return false;
		if (nrSerieDocOrigina == null) {
			if (other.nrSerieDocOrigina != null)
				return false;
		} else if (!nrSerieDocOrigina.equals(other.nrSerieDocOrigina))
			return false;
		if (vlInsumo == null) {
			if (other.vlInsumo != null)
				return false;
		} else if (!vlInsumo.equals(other.vlInsumo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FatoMovInsuPrestador [cdUnidade=" + cdUnidade
				+ ", cdPrestador=" + cdPrestador + ", cdTransacao="
				+ cdTransacao + ", nrSerieDocOrigina=" + nrSerieDocOrigina
				+ ", cdTipoInsumo=" + cdTipoInsumo + ", cdInsumo=" + cdInsumo
				+ ", dtRealizacao=" + dtRealizacao + ", vlInsumo=" + vlInsumo
				+ ", nmPrestador=" + nmPrestador + "]";
	}
	
}
