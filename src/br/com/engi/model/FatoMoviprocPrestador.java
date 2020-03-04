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
@Table(name="fato_moviproc_prestador")
public class FatoMoviprocPrestador implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6938321696785330044L;
	
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
	@Column(name="cd_esp_amb")
	private Integer cdEspAmb;
	
	@Id
	@Column(name="cd_grupo_proc_amb")
	private Integer cdGrupoProcAmb;
	
	@Id
	@Column(name="cd_procedimento")
	private Integer cdProcedimento;
	
	@Id
	@Column(name="dv_procedimento")
	private Integer dvProcedimento;
	
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name="dt_realizacao")
	private Date    dtRealizacao;
	
	@Id
	@Column(name="vl_principal")
	private BigDecimal vlPrincipal;
	
	@Column(name="nm_prestador")
	private String  nmPrestador;
	
	public FatoMoviprocPrestador() {
		super();
	}

	public FatoMoviprocPrestador(Integer cdUnidade, Integer cdPrestador,
			Integer cdTransacao, String nrSerieDocOrigina, Integer cdEspAmb,
			Integer cdGrupoProcAmb, Integer cdProcedimento,
			Integer dvProcedimento, Date dtRealizacao, BigDecimal vlPrincipal,
			String nmPrestador) {
		super();
		this.cdUnidade = cdUnidade;
		this.cdPrestador = cdPrestador;
		this.cdTransacao = cdTransacao;
		this.nrSerieDocOrigina = nrSerieDocOrigina;
		this.cdEspAmb = cdEspAmb;
		this.cdGrupoProcAmb = cdGrupoProcAmb;
		this.cdProcedimento = cdProcedimento;
		this.dvProcedimento = dvProcedimento;
		this.dtRealizacao = dtRealizacao;
		this.vlPrincipal = vlPrincipal;
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

	public Integer getCdEspAmb() {
		return cdEspAmb;
	}

	public void setCdEspAmb(Integer cdEspAmb) {
		this.cdEspAmb = cdEspAmb;
	}

	public Integer getCdGrupoProcAmb() {
		return cdGrupoProcAmb;
	}

	public void setCdGrupoProcAmb(Integer cdGrupoProcAmb) {
		this.cdGrupoProcAmb = cdGrupoProcAmb;
	}

	public Integer getCdProcedimento() {
		return cdProcedimento;
	}

	public void setCdProcedimento(Integer cdProcedimento) {
		this.cdProcedimento = cdProcedimento;
	}

	public Integer getDvProcedimento() {
		return dvProcedimento;
	}

	public void setDvProcedimento(Integer dvProcedimento) {
		this.dvProcedimento = dvProcedimento;
	}

	public Date getDtRealizacao() {
		return dtRealizacao;
	}

	public void setDtRealizacao(Date dtRealizacao) {
		this.dtRealizacao = dtRealizacao;
	}

	public BigDecimal getVlPrincipal() {
		return vlPrincipal;
	}

	public void setVlPrincipal(BigDecimal vlPrincipal) {
		this.vlPrincipal = vlPrincipal;
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
				+ ((cdEspAmb == null) ? 0 : cdEspAmb.hashCode());
		result = prime * result
				+ ((cdGrupoProcAmb == null) ? 0 : cdGrupoProcAmb.hashCode());
		result = prime * result
				+ ((cdPrestador == null) ? 0 : cdPrestador.hashCode());
		result = prime * result
				+ ((cdProcedimento == null) ? 0 : cdProcedimento.hashCode());
		result = prime * result
				+ ((cdTransacao == null) ? 0 : cdTransacao.hashCode());
		result = prime * result
				+ ((cdUnidade == null) ? 0 : cdUnidade.hashCode());
		result = prime * result
				+ ((dtRealizacao == null) ? 0 : dtRealizacao.hashCode());
		result = prime * result
				+ ((dvProcedimento == null) ? 0 : dvProcedimento.hashCode());
		result = prime * result
				+ ((nmPrestador == null) ? 0 : nmPrestador.hashCode());
		result = prime
				* result
				+ ((nrSerieDocOrigina == null) ? 0 : nrSerieDocOrigina
						.hashCode());
		result = prime * result
				+ ((vlPrincipal == null) ? 0 : vlPrincipal.hashCode());
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
		FatoMoviprocPrestador other = (FatoMoviprocPrestador) obj;
		if (cdEspAmb == null) {
			if (other.cdEspAmb != null)
				return false;
		} else if (!cdEspAmb.equals(other.cdEspAmb))
			return false;
		if (cdGrupoProcAmb == null) {
			if (other.cdGrupoProcAmb != null)
				return false;
		} else if (!cdGrupoProcAmb.equals(other.cdGrupoProcAmb))
			return false;
		if (cdPrestador == null) {
			if (other.cdPrestador != null)
				return false;
		} else if (!cdPrestador.equals(other.cdPrestador))
			return false;
		if (cdProcedimento == null) {
			if (other.cdProcedimento != null)
				return false;
		} else if (!cdProcedimento.equals(other.cdProcedimento))
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
		if (dvProcedimento == null) {
			if (other.dvProcedimento != null)
				return false;
		} else if (!dvProcedimento.equals(other.dvProcedimento))
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
		if (vlPrincipal == null) {
			if (other.vlPrincipal != null)
				return false;
		} else if (!vlPrincipal.equals(other.vlPrincipal))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FatoMoviprocPrestador [cdUnidade=" + cdUnidade
				+ ", cdPrestador=" + cdPrestador + ", cdTransacao="
				+ cdTransacao + ", nrSerieDocOrigina=" + nrSerieDocOrigina
				+ ", cdEspAmb=" + cdEspAmb + ", cdGrupoProcAmb="
				+ cdGrupoProcAmb + ", cdProcedimento=" + cdProcedimento
				+ ", dvProcedimento=" + dvProcedimento + ", dtRealizacao="
				+ dtRealizacao + ", vlPrincipal=" + vlPrincipal
				+ ", nmPrestador=" + nmPrestador + "]";
	}
	
}
