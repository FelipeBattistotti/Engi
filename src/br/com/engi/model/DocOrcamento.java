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
@Table(name="doc_orcamento")
@SequenceGenerator(name="sequenceDocOrcamento", sequenceName="seq_doc_orcamento")
public class DocOrcamento implements Serializable {
	
	private static final long serialVersionUID = 7049453849215245683L;
	
	@Id
	@GeneratedValue(generator="sequenceDocOrcamento")
	@Column(name="cod_doc_orcamento")
	private Integer codigo;
	
	@Column(name="des_titulo")
	private String titulo;
	
	@Column(name="des_link_tdn")
	private String linkTDN;
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy="docOrcamento",fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<TagOrc> tagList;
	
	public DocOrcamento() {
		super();
	}

	public DocOrcamento(Integer codigo) {
		super();
		this.codigo = codigo;
	}
	
	public DocOrcamento(Integer codigo, String titulo, String linkTDN, List<TagOrc> tagList) {
		super();
		this.codigo  = codigo;
		this.titulo  = titulo;
		this.linkTDN = linkTDN;
		this.tagList = tagList;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getLinkTDN() {
		return linkTDN;
	}
	public void setLinkTDN(String linkTDN) {
		this.linkTDN = linkTDN;
	}
	
	public List<TagOrc> getTagList() {
		return tagList;
	}
	public void setTagList(List<TagOrc> tagList) {
		this.tagList = tagList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((linkTDN == null) ? 0 : linkTDN.hashCode());
		result = prime * result + ((tagList == null) ? 0 : tagList.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
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
		DocOrcamento other = (DocOrcamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (linkTDN == null) {
			if (other.linkTDN != null)
				return false;
		} else if (!linkTDN.equals(other.linkTDN))
			return false;
		if (tagList == null) {
			if (other.tagList != null)
				return false;
		} else if (!tagList.equals(other.tagList))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "DocOrcamento [codigo=" + codigo + ", titulo=" + titulo
				+ ", linkTDN=" + linkTDN + ", tagList=" + tagList + "]";
	}
	
}