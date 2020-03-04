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
@Table(name="tabela")
@SequenceGenerator(name="sequenceTabela", sequenceName="seq_tabela")
public class Tabela implements Serializable {
	
	private static final long serialVersionUID = -5326413632455786351L;
	
	@Id
	@GeneratedValue(generator="sequenceTabela")
	@Column(name="cod_tabela")
	private Integer codigo;
	
	@Column(name="nm_tabela")
	private String nomeTabela;
	
	@Column(name="des_tabela")
	private String descricaoTabela;
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy="tabela",fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<CampoTabela> campoTabelaList;
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy="tabela",fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<TagTabela> tagTabelaList;
	
	public Tabela() {
		super();
	}
	
	public Tabela(Integer codigo) {
		super();
		this.codigo = codigo;
	}
	
	public Tabela(Integer codigo, String nomeTabela, String descricaoTabela,
			List<CampoTabela> campoTabelaList, List<TagTabela> tagTabelaList) {
		super();
		this.codigo = codigo;
		this.nomeTabela = nomeTabela;
		this.descricaoTabela = descricaoTabela;
		this.campoTabelaList = campoTabelaList;
		this.tagTabelaList = tagTabelaList;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNomeTabela() {
		return nomeTabela;
	}
	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}
	
	public String getDescricaoTabela() {
		return descricaoTabela;
	}
	public void setDescricaoTabela(String descricaoTabela) {
		this.descricaoTabela = descricaoTabela;
	}
	
	public List<CampoTabela> getCampoTabelaList() {
		return campoTabelaList;
	}
	public void setCampoTabelaList(List<CampoTabela> campoTabelaList) {
		this.campoTabelaList = campoTabelaList;
	}
	
	public List<TagTabela> getTagTabelaList() {
		return tagTabelaList;
	}
	public void setTagTabelaList(List<TagTabela> tagTabelaList) {
		this.tagTabelaList = tagTabelaList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((campoTabelaList == null) ? 0 : campoTabelaList.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((descricaoTabela == null) ? 0 : descricaoTabela.hashCode());
		result = prime * result
				+ ((nomeTabela == null) ? 0 : nomeTabela.hashCode());
		result = prime * result
				+ ((tagTabelaList == null) ? 0 : tagTabelaList.hashCode());
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
		Tabela other = (Tabela) obj;
		if (campoTabelaList == null) {
			if (other.campoTabelaList != null)
				return false;
		} else if (!campoTabelaList.equals(other.campoTabelaList))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descricaoTabela == null) {
			if (other.descricaoTabela != null)
				return false;
		} else if (!descricaoTabela.equals(other.descricaoTabela))
			return false;
		if (nomeTabela == null) {
			if (other.nomeTabela != null)
				return false;
		} else if (!nomeTabela.equals(other.nomeTabela))
			return false;
		if (tagTabelaList == null) {
			if (other.tagTabelaList != null)
				return false;
		} else if (!tagTabelaList.equals(other.tagTabelaList))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Tabela [codigo=" + codigo + ", nomeTabela=" + nomeTabela
				+ ", descricaoTabela=" + descricaoTabela + ", campoTabelaList="
				+ campoTabelaList + ", tagTabelaList=" + tagTabelaList + "]";
	}
	
}