package br.com.engi.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
@SequenceGenerator(name="sequenceCliente", sequenceName="seq_cliente")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = -6374819791996910815L;
	
	@Id
	@GeneratedValue(generator="sequenceCliente")
	@Column(name="cod_cliente")
	private Integer codigo;
	
	@Column(name="nm_cliente")
	private String nomeCliente;
	
	public Cliente() {
		super();
	}
	
	public Cliente(Integer codigo) {
		super();
		this.codigo = codigo;
	}
	
	public Cliente(Integer codigo, String nomeCliente) {
		super();
		this.codigo = codigo;
		this.nomeCliente = nomeCliente;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((nomeCliente == null) ? 0 : nomeCliente.hashCode());
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
		Cliente other = (Cliente) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (nomeCliente == null) {
			if (other.nomeCliente != null)
				return false;
		} else if (!nomeCliente.equals(other.nomeCliente))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nomeCliente=" + nomeCliente
				+ "]";
	}
	
}