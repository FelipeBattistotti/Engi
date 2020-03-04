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
@Table(name="tag_tabela")
@SequenceGenerator(name="sequenceTagTabela", sequenceName="seq_tag_tabela")
public class TagTabela implements Serializable {
	
	private static final long serialVersionUID = -8918526472335805234L;
	
	@Id
	@GeneratedValue(generator="sequenceTagTabela")
	@Column(name="cod_tag_tabela")
	private Integer codigo;
	
	@Column(name="des_tag_tabela")
	private String descricao;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_tabela")
	private Tabela tabela;
	
	public TagTabela() {
		super();
	}
	
	public TagTabela(Integer codigo) {
		super();
		this.codigo = codigo;
	}
	
	public TagTabela(Integer codigo, String descricao, Tabela tabela) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.tabela = tabela;
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
	
	public Tabela getTabela() {
		return tabela;
	}
	public void setTabela(Tabela tabela) {
		this.tabela = tabela;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((tabela == null) ? 0 : tabela.hashCode());
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
		TagTabela other = (TagTabela) obj;
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
		if (tabela == null) {
			if (other.tabela != null)
				return false;
		} else if (!tabela.equals(other.tabela))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "TagTabela [codigo=" + codigo + ", descricao=" + descricao
				+ ", tabela=" + tabela + "]";
	}
	
}