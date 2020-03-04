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
@Table(name="campo_tabela")
@SequenceGenerator(name="sequenceCampoTabela", sequenceName="seq_campo_tabela")
public class CampoTabela implements Serializable {
	
	private static final long serialVersionUID = 5702164101187890175L;
	
	@Id
	@GeneratedValue(generator="sequenceCampoTabela")
	@Column(name="cod_campo_tabela")
	private Integer codigo;
	
	@Column(name="nm_campo_tabela")
	private String nomeCampoTabela;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_tabela")
	private Tabela tabela;
	
	public CampoTabela() {
		super();
	}
	
	public CampoTabela(Integer codigo) {
		super();
		this.codigo = codigo;
	}
	
	public CampoTabela(Integer codigo, String nomeCampoTabela, Tabela tabela) {
		super();
		this.codigo = codigo;
		this.nomeCampoTabela = nomeCampoTabela;
		this.tabela = tabela;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNomeCampoTabela() {
		return nomeCampoTabela;
	}
	public void setNomeCampoTabela(String nomeCampoTabela) {
		this.nomeCampoTabela = nomeCampoTabela;
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
				+ ((nomeCampoTabela == null) ? 0 : nomeCampoTabela.hashCode());
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
		CampoTabela other = (CampoTabela) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nomeCampoTabela == null) {
			if (other.nomeCampoTabela != null)
				return false;
		} else if (!nomeCampoTabela.equals(other.nomeCampoTabela))
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
		return "CampoTabela [codigo=" + codigo + ", nomeCampoTabela="
				+ nomeCampoTabela + ", tabela=" + tabela + "]";
	}
	
}