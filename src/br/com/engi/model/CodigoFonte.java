package br.com.engi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="codigo_fonte")
@SequenceGenerator(name="sequenceCodigoFonte", sequenceName="seq_codigo_fonte")
public class CodigoFonte implements Serializable {
	
	private static final long serialVersionUID = 5233985169960422883L;
	
	@Id
	@GeneratedValue(generator="sequenceCodigoFonte")
	@Column(name="cod_codigo_fonte")
	private Integer codigo;
	
	@Column(name="nm_codigo_fonte")
	private String nomeCodigoFonte;
	
	@Column(name="tip_extensao")
	private Integer tipoExtensao;
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy="codigoFonte",fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<TagCodigoFonte> tagCodigoFonteList;
	
	public CodigoFonte() {
		super();
	}
	
	public CodigoFonte(Integer codigo) {
		super();
		this.codigo = codigo;
	}
	
	public CodigoFonte(Integer codigo, String nomeCodigoFonte, Integer tipoExtensao, List<TagCodigoFonte> tagCodigoFonteList) {
		super();
		this.codigo = codigo;
		this.nomeCodigoFonte = nomeCodigoFonte;
		this.tipoExtensao = tipoExtensao;
		this.tagCodigoFonteList = tagCodigoFonteList;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNomeCodigoFonte() {
		return nomeCodigoFonte;
	}
	public void setNomeCodigoFonte(String nomeCodigoFonte) {
		this.nomeCodigoFonte = nomeCodigoFonte;
	}
	
	public Integer getTipoExtensao() {
		return tipoExtensao;
	}
	public void setTipoExtensao(Integer tipoExtensao) {
		this.tipoExtensao = tipoExtensao;
	}
	
	public List<TagCodigoFonte> getTagCodigoFonteList() {
		return tagCodigoFonteList;
	}
	public void setTagCodigoFonteList(List<TagCodigoFonte> tagCodigoFonteList) {
		this.tagCodigoFonteList = tagCodigoFonteList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((nomeCodigoFonte == null) ? 0 : nomeCodigoFonte.hashCode());
		result = prime
				* result
				+ ((tagCodigoFonteList == null) ? 0 : tagCodigoFonteList
						.hashCode());
		result = prime * result
				+ ((tipoExtensao == null) ? 0 : tipoExtensao.hashCode());
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
		CodigoFonte other = (CodigoFonte) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nomeCodigoFonte == null) {
			if (other.nomeCodigoFonte != null)
				return false;
		} else if (!nomeCodigoFonte.equals(other.nomeCodigoFonte))
			return false;
		if (tagCodigoFonteList == null) {
			if (other.tagCodigoFonteList != null)
				return false;
		} else if (!tagCodigoFonteList.equals(other.tagCodigoFonteList))
			return false;
		if (tipoExtensao == null) {
			if (other.tipoExtensao != null)
				return false;
		} else if (!tipoExtensao.equals(other.tipoExtensao))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "CodigoFonte [codigo=" + codigo + ", nomeCodigoFonte="
				+ nomeCodigoFonte + ", tipoExtensao=" + tipoExtensao
				+ ", tagCodigoFonteList=" + tagCodigoFonteList + "]";
	}
	
}