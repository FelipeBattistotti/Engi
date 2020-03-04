package br.com.engi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="conta_bancaria")
@SequenceGenerator(name="sequenceDeConta", sequenceName="seq_conta_bancaria")
public class Conta implements Serializable{

	private static final long serialVersionUID = 5176065747670270006L;

	
	@Id
	// Desta forma não usamos a sequence padrão do hibernate
	// mas sim informamos uma sequence especifica para o campo
	// codigo da tabela conta.
	@GeneratedValue(generator="sequenceDeConta")
	@Column(name="cod_conta")
	private Integer codigo;

	@Column(name="des_conta")
	private String descricao;

	@Column(name="dat_cadastro", nullable=false, updatable=false)
	private Date dataCadastro;

	@Column(name="saldo_inicial")
	private float saldoInicial;

	private boolean favorita;

	/*
	 * FetchType.LAZY  --> Padrão, só carrego os dados de usuario quando 
	 * 					   forem solicitados
	 * 
	 * FetchType.EAGER --> Retorna os dados de usuario junto com a consulta
	 * 					   da classe principal
	 * 
	 * Na hora da consulta fara Inner Join caso o atributo seja obrigatorio
	 * 							Left  Join caso o atributo seja opcional
	 * 
	 */
	@ManyToOne	// Muitas Contas para UM usuario
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name="cod_usuario", nullable= false)
	private Usuario usuario;
	
	// Construtor default
	public Conta() {}
	
	// construtor que recebe uma instancia de usuario como parametro
	public Conta(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	// ALT+SFHIF+ S
	// aqui um construtor que recebe o codigo
	public Conta(Integer codigo) {
		super();
		this.codigo = codigo;
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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public float getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(float saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	public boolean isFavorita() {
		return favorita;
	}

	public void setFavorita(boolean favorita) {
		this.favorita = favorita;
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
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + (favorita ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(saldoInicial);
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Conta)) {
			return false;
		}
		Conta other = (Conta) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		if (dataCadastro == null) {
			if (other.dataCadastro != null) {
				return false;
			}
		} else if (!dataCadastro.equals(other.dataCadastro)) {
			return false;
		}
		if (descricao == null) {
			if (other.descricao != null) {
				return false;
			}
		} else if (!descricao.equals(other.descricao)) {
			return false;
		}
		if (favorita != other.favorita) {
			return false;
		}
		if (Float.floatToIntBits(saldoInicial) != Float
				.floatToIntBits(other.saldoInicial)) {
			return false;
		}
		if (usuario == null) {
			if (other.usuario != null) {
				return false;
			}
		} else if (!usuario.equals(other.usuario)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Conta ["
				+ (codigo != null ? "codigo=" + codigo + ", " : "")
				+ (descricao != null ? "descricao=" + descricao + ", " : "")
				+ (dataCadastro != null ? "dataCadastro=" + dataCadastro + ", "
						: "") + "saldoInicial=" + saldoInicial + ", favorita="
				+ favorita + ", "
				+ (usuario != null ? "usuario=" + usuario : "") + "]";
	}

}
