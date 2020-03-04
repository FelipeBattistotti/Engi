package br.com.engi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="midia")
@SequenceGenerator(name="sequenceMidia", sequenceName="seq_midia")
public class Midia implements Serializable {
	
	private static final long serialVersionUID = -5783004963558002848L;
	
	@Id
	@GeneratedValue(generator="sequenceMidia")
	@Column(name="cod_midia")
	private Integer codigo;
	
	@Column(name="des_sigla")
	private String descricao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dat_inicio")
	private Date dtInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dat_fim")
	private Date dtFim;
	
	public Midia() {
		super();
	}
	
	public Midia(Integer codigo) {
		super();
		this.codigo = codigo;
	}
	
	public Midia(Integer codigo, String descricao, Date dtInicio, Date dtFim) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.dtInicio = dtInicio;
		this.dtFim = dtFim;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Date getDtInicio() {
		return dtInicio;
	}
	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}
	
	public Date getDtFim() {
		return dtFim;
	}
	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((dtFim == null) ? 0 : dtFim.hashCode());
		result = prime * result
				+ ((dtInicio == null) ? 0 : dtInicio.hashCode());
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
		Midia other = (Midia) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (dtFim == null) {
			if (other.dtFim != null)
				return false;
		} else if (!dtFim.equals(other.dtFim))
			return false;
		if (dtInicio == null) {
			if (other.dtInicio != null)
				return false;
		} else if (!dtInicio.equals(other.dtInicio))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Midia [codigo=" + codigo + ", descricao=" + descricao
				+ ", dtInicio=" + dtInicio + ", dtFim=" + dtFim + "]";
	}
	
}