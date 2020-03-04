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
@Table(name="atividade_tabela")
@SequenceGenerator(name="sequenceAtividadeTabela", sequenceName="seq_atividade_tabela")
public class AtividadeTabela implements Serializable {
	
	private static final long serialVersionUID = -5492643334605693381L;
	
	@Id
	@GeneratedValue(generator="sequenceAtividadeTabela")
	@Column(name="cod_atividade_tabela")
	private Integer codigo;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_atividade")
	private Atividade atividade;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_tabela")
	private Tabela tabela;
	
	public AtividadeTabela() {
		super();
	}
	
	public AtividadeTabela(Integer codigo) {
		super();
		this.codigo = codigo;
	}
	
	public AtividadeTabela(Integer codigo, Atividade atividade, Tabela tabela) {
		super();
		this.codigo = codigo;
		this.atividade = atividade;
		this.tabela = tabela;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
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
		result = prime * result
				+ ((atividade == null) ? 0 : atividade.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		AtividadeTabela other = (AtividadeTabela) obj;
		if (atividade == null) {
			if (other.atividade != null)
				return false;
		} else if (!atividade.equals(other.atividade))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
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
		return "AtividadeTabela [codigo=" + codigo + ", atividade=" + atividade
				+ ", tabela=" + tabela + "]";
	}
	
}