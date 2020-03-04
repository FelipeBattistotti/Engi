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
@Table(name="atividade_codigo_fonte")
@SequenceGenerator(name="sequenceAtividadeCodigoFonte", sequenceName="seq_atividade_codigo_fonte")
public class AtividadeCodigoFonte implements Serializable {
	
	private static final long serialVersionUID = 5965565027710922306L;
	
	@Id
	@GeneratedValue(generator="sequenceAtividadeCodigoFonte")
	@Column(name="cod_atividade_codigo_fonte")
	private Integer codigo;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_atividade")
	private Atividade atividade;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_codigo_fonte")
	private CodigoFonte codigoFonte;
	
	public AtividadeCodigoFonte() {
		super();
	}
	
	public AtividadeCodigoFonte(Integer codigo) {
		super();
		this.codigo = codigo;
	}
	
	public AtividadeCodigoFonte(Integer codigo, Atividade atividade, CodigoFonte codigoFonte) {
		super();
		this.codigo = codigo;
		this.atividade = atividade;
		this.codigoFonte = codigoFonte;
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
		result = prime * result
				+ ((atividade == null) ? 0 : atividade.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((codigoFonte == null) ? 0 : codigoFonte.hashCode());
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
		AtividadeCodigoFonte other = (AtividadeCodigoFonte) obj;
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
		if (codigoFonte == null) {
			if (other.codigoFonte != null)
				return false;
		} else if (!codigoFonte.equals(other.codigoFonte))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "AtividadeCodigoFonte [codigo=" + codigo + ", atividade="
				+ atividade + ", codigoFonte=" + codigoFonte + "]";
	}
	
}