package br.com.engi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fato_vlbenef_fatura")
public class FatoVlbenefFatura implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4729794101901011201L;
	
	@Id
	@Column(name="cd_modalidade")
	private Integer cdModalidade; //cd_modalidade
	
	@Id
	@Column(name="cd_contratante")
	private Integer cdContratante; //cd_contratante
	
	@Id
	@Column(name="nr_ter_adesao")
	private Integer nrTerAdesao; //nr_ter_adesao
	
	@Id
	@Column(name="aa_referencia")
	private Integer aaReferencia; //aa_referencia
	
	@Id
	@Column(name="mm_referencia")
	private Integer mmReferencia; //mm_referencia
	
	@Id
	@Column(name="nr_sequencia")
	private Integer nrSequencia; //nr_sequencia
	
	@Id
	@Column(name="cd_usuario")
	private Integer cdUsuario; //cd_usuario
	
	@Id
	@Column(name="nr_faixa_etaria")
	private Integer nrFaixaEtaria; //nr_faixa_etaria
	
	@Id
	@Column(name="vl_usuario")
	private BigDecimal vlUsuario; //vl_usuario
	
	@Id
	@Column(name="nr_fatura")
	private Integer nrFatura; //nr_fatura
	
	@Id
	@Column(name="vl_total")
	private BigDecimal vlTotal; //vl_total
	
	@Column(name="lg_sexo")
	private String lgSexo; //lg_sexo
	
	@Column(name="nm_contratante")
	private String nmContratante; //nm_contratante
	
	@Column(name="in_tipo_pessoa")
	private String inTipoPessoa; //in_tipo_pessoa

	public FatoVlbenefFatura() {
		super();
	}

	public FatoVlbenefFatura(Integer cdModalidade, Integer cdContratante,
			Integer nrTerAdesao, Integer aaReferencia, Integer mmReferencia,
			Integer nrSequencia, Integer cdUsuario, Integer nrFaixaEtaria,
			BigDecimal vlUsuario, Integer nrFatura, BigDecimal vlTotal,
			String lgSexo, String nmContratante, String inTipoPessoa) {
		super();
		this.cdModalidade = cdModalidade;
		this.cdContratante = cdContratante;
		this.nrTerAdesao = nrTerAdesao;
		this.aaReferencia = aaReferencia;
		this.mmReferencia = mmReferencia;
		this.nrSequencia = nrSequencia;
		this.cdUsuario = cdUsuario;
		this.nrFaixaEtaria = nrFaixaEtaria;
		this.vlUsuario = vlUsuario;
		this.nrFatura = nrFatura;
		this.vlTotal = vlTotal;
		this.lgSexo = lgSexo;
		this.nmContratante = nmContratante;
		this.inTipoPessoa = inTipoPessoa;
	}

	public Integer getCdModalidade() {
		return cdModalidade;
	}

	public void setCdModalidade(Integer cdModalidade) {
		this.cdModalidade = cdModalidade;
	}

	public Integer getCdContratante() {
		return cdContratante;
	}

	public void setCdContratante(Integer cdContratante) {
		this.cdContratante = cdContratante;
	}

	public Integer getNrTerAdesao() {
		return nrTerAdesao;
	}

	public void setNrTerAdesao(Integer nrTerAdesao) {
		this.nrTerAdesao = nrTerAdesao;
	}

	public Integer getAaReferencia() {
		return aaReferencia;
	}

	public void setAaReferencia(Integer aaReferencia) {
		this.aaReferencia = aaReferencia;
	}

	public Integer getMmReferencia() {
		return mmReferencia;
	}

	public void setMmReferencia(Integer mmReferencia) {
		this.mmReferencia = mmReferencia;
	}

	public Integer getNrSequencia() {
		return nrSequencia;
	}

	public void setNrSequencia(Integer nrSequencia) {
		this.nrSequencia = nrSequencia;
	}

	public Integer getCdUsuario() {
		return cdUsuario;
	}

	public void setCdUsuario(Integer cdUsuario) {
		this.cdUsuario = cdUsuario;
	}

	public Integer getNrFaixaEtaria() {
		return nrFaixaEtaria;
	}

	public void setNrFaixaEtaria(Integer nrFaixaEtaria) {
		this.nrFaixaEtaria = nrFaixaEtaria;
	}

	public BigDecimal getVlUsuario() {
		return vlUsuario;
	}

	public void setVlUsuario(BigDecimal vlUsuario) {
		this.vlUsuario = vlUsuario;
	}

	public Integer getNrFatura() {
		return nrFatura;
	}

	public void setNrFatura(Integer nrFatura) {
		this.nrFatura = nrFatura;
	}

	public BigDecimal getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(BigDecimal vlTotal) {
		this.vlTotal = vlTotal;
	}

	public String getLgSexo() {
		return lgSexo;
	}

	public void setLgSexo(String lgSexo) {
		this.lgSexo = lgSexo;
	}

	public String getNmContratante() {
		return nmContratante;
	}

	public void setNmContratante(String nmContratante) {
		this.nmContratante = nmContratante;
	}

	public String getInTipoPessoa() {
		return inTipoPessoa;
	}

	public void setInTipoPessoa(String inTipoPessoa) {
		this.inTipoPessoa = inTipoPessoa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aaReferencia == null) ? 0 : aaReferencia.hashCode());
		result = prime * result
				+ ((cdContratante == null) ? 0 : cdContratante.hashCode());
		result = prime * result
				+ ((cdModalidade == null) ? 0 : cdModalidade.hashCode());
		result = prime * result
				+ ((cdUsuario == null) ? 0 : cdUsuario.hashCode());
		result = prime * result
				+ ((inTipoPessoa == null) ? 0 : inTipoPessoa.hashCode());
		result = prime * result + ((lgSexo == null) ? 0 : lgSexo.hashCode());
		result = prime * result
				+ ((mmReferencia == null) ? 0 : mmReferencia.hashCode());
		result = prime * result
				+ ((nmContratante == null) ? 0 : nmContratante.hashCode());
		result = prime * result
				+ ((nrFaixaEtaria == null) ? 0 : nrFaixaEtaria.hashCode());
		result = prime * result
				+ ((nrFatura == null) ? 0 : nrFatura.hashCode());
		result = prime * result
				+ ((nrSequencia == null) ? 0 : nrSequencia.hashCode());
		result = prime * result
				+ ((nrTerAdesao == null) ? 0 : nrTerAdesao.hashCode());
		result = prime * result + ((vlTotal == null) ? 0 : vlTotal.hashCode());
		result = prime * result
				+ ((vlUsuario == null) ? 0 : vlUsuario.hashCode());
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
		FatoVlbenefFatura other = (FatoVlbenefFatura) obj;
		if (aaReferencia == null) {
			if (other.aaReferencia != null)
				return false;
		} else if (!aaReferencia.equals(other.aaReferencia))
			return false;
		if (cdContratante == null) {
			if (other.cdContratante != null)
				return false;
		} else if (!cdContratante.equals(other.cdContratante))
			return false;
		if (cdModalidade == null) {
			if (other.cdModalidade != null)
				return false;
		} else if (!cdModalidade.equals(other.cdModalidade))
			return false;
		if (cdUsuario == null) {
			if (other.cdUsuario != null)
				return false;
		} else if (!cdUsuario.equals(other.cdUsuario))
			return false;
		if (inTipoPessoa == null) {
			if (other.inTipoPessoa != null)
				return false;
		} else if (!inTipoPessoa.equals(other.inTipoPessoa))
			return false;
		if (lgSexo == null) {
			if (other.lgSexo != null)
				return false;
		} else if (!lgSexo.equals(other.lgSexo))
			return false;
		if (mmReferencia == null) {
			if (other.mmReferencia != null)
				return false;
		} else if (!mmReferencia.equals(other.mmReferencia))
			return false;
		if (nmContratante == null) {
			if (other.nmContratante != null)
				return false;
		} else if (!nmContratante.equals(other.nmContratante))
			return false;
		if (nrFaixaEtaria == null) {
			if (other.nrFaixaEtaria != null)
				return false;
		} else if (!nrFaixaEtaria.equals(other.nrFaixaEtaria))
			return false;
		if (nrFatura == null) {
			if (other.nrFatura != null)
				return false;
		} else if (!nrFatura.equals(other.nrFatura))
			return false;
		if (nrSequencia == null) {
			if (other.nrSequencia != null)
				return false;
		} else if (!nrSequencia.equals(other.nrSequencia))
			return false;
		if (nrTerAdesao == null) {
			if (other.nrTerAdesao != null)
				return false;
		} else if (!nrTerAdesao.equals(other.nrTerAdesao))
			return false;
		if (vlTotal == null) {
			if (other.vlTotal != null)
				return false;
		} else if (!vlTotal.equals(other.vlTotal))
			return false;
		if (vlUsuario == null) {
			if (other.vlUsuario != null)
				return false;
		} else if (!vlUsuario.equals(other.vlUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FatoVlbenefFatura [cdModalidade=" + cdModalidade
				+ ", cdContratante=" + cdContratante + ", nrTerAdesao="
				+ nrTerAdesao + ", aaReferencia=" + aaReferencia
				+ ", mmReferencia=" + mmReferencia + ", nrSequencia="
				+ nrSequencia + ", cdUsuario=" + cdUsuario + ", nrFaixaEtaria="
				+ nrFaixaEtaria + ", vlUsuario=" + vlUsuario + ", nrFatura="
				+ nrFatura + ", vlTotal=" + vlTotal + ", lgSexo=" + lgSexo
				+ ", nmContratante=" + nmContratante + ", inTipoPessoa="
				+ inTipoPessoa + "]";
	}

}
