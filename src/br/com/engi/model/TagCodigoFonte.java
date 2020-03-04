package br.com.engi.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tag_codigo_fonte")
@SequenceGenerator(name="sequenceTagCodigoFonte", sequenceName="seq_tag_codigo_fonte")
public class TagCodigoFonte implements Serializable {
	
	private static final long serialVersionUID = 3032239646656376656L;
	
	@Id
	@GeneratedValue(generator="sequenceTagCodigoFonte")
	@Column(name="cod_tag_codigo_fonte")
	private Integer codigo;
	
	@Column(name="des_tag_codigo_fonte")
	private String descricao;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_codigo_fonte")
	private CodigoFonte codigoFonte;
	
	public TagCodigoFonte() {
		super();
	}
	
	public TagCodigoFonte(Integer codigo) {
		super();
		this.codigo = codigo;
	}
	
	public TagCodigoFonte(Integer codigo, String descricao, CodigoFonte codigoFonte) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.codigoFonte = codigoFonte;
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
	
	public CodigoFonte getCodigoFonte() {
		return codigoFonte;
	}
	public void setCodigoFonte(CodigoFonte codigoFonte) {
		this.codigoFonte = codigoFonte;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((codigoFonte == null) ? 0 : codigoFonte.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
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
		TagCodigoFonte other = (TagCodigoFonte) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (codigoFonte == null) {
			if (other.codigoFonte != null)
				return false;
		} else if (!codigoFonte.equals(other.codigoFonte))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "TagCodigoFonte [codigo=" + codigo + ", descricao=" + descricao
				+ ", codigoFonte=" + codigoFonte + "]";
	}
	
}