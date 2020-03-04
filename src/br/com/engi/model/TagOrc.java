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
@Table(name="tag_doc_orcamento")
@SequenceGenerator(name="sequenceTagDocOrcamento", sequenceName="seq_tag_doc_orcamento")
public class TagOrc implements Serializable {
	
	private static final long serialVersionUID = -4741453382950610810L;
	
	@Id
	@GeneratedValue(generator="sequenceTagDocOrcamento")
	@Column(name="cod_tag_doc_orcamento")
	private Integer codigo;
	
	@Column(name="des_tag_doc_orcamento")
	private String descricao;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_doc_orcamento")
	private DocOrcamento docOrcamento;
	
	public TagOrc() {
		super();
	}
	
	public TagOrc(Integer codigo) {
		super();
		this.codigo = codigo;
	}

	public TagOrc(Integer codigo, String descricao, DocOrcamento docOrcamento) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.docOrcamento = docOrcamento;
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

	public DocOrcamento getDocOrcamento() {
		return docOrcamento;
	}

	public void setDocOrcamento(DocOrcamento docOrcamento) {
		this.docOrcamento = docOrcamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((docOrcamento == null) ? 0 : docOrcamento.hashCode());
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
		TagOrc other = (TagOrc) obj;
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
		if (docOrcamento == null) {
			if (other.docOrcamento != null)
				return false;
		} else if (!docOrcamento.equals(other.docOrcamento))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TagOrc [codigo=" + codigo + ", descricao=" + descricao
				+ ", docOrcamento=" + docOrcamento + "]";
	}
	
}