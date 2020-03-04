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
@Table(name="chamado")
@SequenceGenerator(name="sequenceChamado", sequenceName="seq_chamado")
public class Chamado implements Serializable {
	
	private static final long serialVersionUID = -4774556552781908056L;
	
	@Id
	@GeneratedValue(generator="sequenceChamado")
	@Column(name="cod_chamado")
	private Integer codigo;
	
	@Column(name="des_codigo_chamado")
	private String codigoChamado;
	
	@Column(name="des_erro")
	private String erro;
	
	@Column(name="nm_analista_identificador")
	private String analistaIdentificador;
	
	@Column(name="cod_status")
	private Integer status;
	
	@Column(name="cod_criticidade")
	private Integer criticidade;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_midia")
	private Midia midia;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_cliente")
	private Cliente cliente;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_usuario")
	private Usuario usuario;
	
	public Chamado() {
		super();
	}
	
	public Chamado(Integer codigo) {
		super();
		this.codigo = codigo;
	}
	
	public Chamado(Integer codigo, String codigoChamado, String erro,
			String analistaIdentificador, Integer status, Integer criticidade,
			Midia midia, Cliente cliente, Usuario usuario) {
		super();
		this.codigo = codigo;
		this.codigoChamado = codigoChamado;
		this.erro = erro;
		this.analistaIdentificador = analistaIdentificador;
		this.status = status;
		this.criticidade = criticidade;
		this.midia = midia;
		this.cliente = cliente;
		this.usuario = usuario;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigoChamado() {
		return codigoChamado;
	}
	public void setCodigoChamado(String codigoChamado) {
		this.codigoChamado = codigoChamado;
	}
	
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	
	public String getAnalistaIdentificador() {
		return analistaIdentificador;
	}
	public void setAnalistaIdentificador(String analistaIdentificador) {
		this.analistaIdentificador = analistaIdentificador;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getCriticidade() {
		return criticidade;
	}
	public void setCriticidade(Integer criticidade) {
		this.criticidade = criticidade;
	}
	
	public Midia getMidia() {
		return midia;
	}
	public void setMidia(Midia midia) {
		this.midia = midia;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((analistaIdentificador == null) ? 0 : analistaIdentificador
						.hashCode());
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((codigoChamado == null) ? 0 : codigoChamado.hashCode());
		result = prime * result
				+ ((criticidade == null) ? 0 : criticidade.hashCode());
		result = prime * result + ((erro == null) ? 0 : erro.hashCode());
		result = prime * result + ((midia == null) ? 0 : midia.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		Chamado other = (Chamado) obj;
		if (analistaIdentificador == null) {
			if (other.analistaIdentificador != null)
				return false;
		} else if (!analistaIdentificador.equals(other.analistaIdentificador))
			return false;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (codigoChamado == null) {
			if (other.codigoChamado != null)
				return false;
		} else if (!codigoChamado.equals(other.codigoChamado))
			return false;
		if (criticidade == null) {
			if (other.criticidade != null)
				return false;
		} else if (!criticidade.equals(other.criticidade))
			return false;
		if (erro == null) {
			if (other.erro != null)
				return false;
		} else if (!erro.equals(other.erro))
			return false;
		if (midia == null) {
			if (other.midia != null)
				return false;
		} else if (!midia.equals(other.midia))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Chamado [codigo=" + codigo + ", codigoChamado=" + codigoChamado
				+ ", erro=" + erro + ", analistaIdentificador="
				+ analistaIdentificador + ", status=" + status
				+ ", criticidade=" + criticidade + ", midia=" + midia
				+ ", cliente=" + cliente + ", usuario=" + usuario + "]";
	}
	
}