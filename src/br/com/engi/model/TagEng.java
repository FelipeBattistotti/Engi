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
@Table(name="tag_doc_engenharia")
@SequenceGenerator(name="sequenceTagDocOrcamento", sequenceName="seq_tag_doc_engenharia")
public class TagEng implements Serializable {
	
	private static final long serialVersionUID = -4741453382950610810L;
	
	@Id
	@GeneratedValue(generator="sequenceTagDocOrcamento")
	@Column(name="cod_tag_doc_engenharia")
	private Integer codigo;
	
	@Column(name="des_tag_doc_engenharia")
	private String descricao;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_doc_engenharia")
	private DocEngenharia docEngenharia;

	public TagEng() {
		super();
	}

	public TagEng(Integer codigo) {
		super();
		this.codigo = codigo;
	}

	public TagEng(Integer codigo, String descricao, DocEngenharia docEngenharia) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.docEngenharia = docEngenharia;
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

	public DocEngenharia getDocEngenharia() {
		return docEngenharia;
	}

	public void setDocEngenharia(DocEngenharia docEngenharia) {
		this.docEngenharia = docEngenharia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((docEngenharia == null) ? 0 : docEngenharia.hashCode());
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
		TagEng other = (TagEng) obj;
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
		if (docEngenharia == null) {
			if (other.docEngenharia != null)
				return false;
		} else if (!docEngenharia.equals(other.docEngenharia))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TagEng [codigo=" + codigo + ", descricao=" + descricao
				+ ", docEngenharia=" + docEngenharia + "]";
	}
	
}