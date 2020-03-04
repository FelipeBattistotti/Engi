package br.com.engi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ForeignKey;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import br.com.engi.domain.SituacaoCheque;

@Entity
@Table
public class Cheque implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2181418654915165707L;

	@EmbeddedId
	private ChequeId chequeId;

	@ManyToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "conta", referencedColumnName = "cod_conta", insertable = false, updatable = false)
	@ForeignKey(name = "fk_cheque_conta")
	private Conta conta;

	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;

	@Column(nullable = false, precision = 1)
	@Enumerated(EnumType.STRING)
	private SituacaoCheque situacao;

	@OneToOne(fetch = FetchType.LAZY)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "lancamento", referencedColumnName = "codigo", nullable = true)
	@ForeignKey(name = "fk_cheque_lancamento")
	private Lancamento lancamento;

	public Cheque() {
		// TODO Auto-generated constructor stub
	}

	public Cheque(ChequeId chequeId) {
		super();
		this.chequeId = chequeId;
	}

	public ChequeId getChequeId() {
		return chequeId;
	}

	public void setChequeId(ChequeId chequeId) {
		this.chequeId = chequeId;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public SituacaoCheque getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoCheque situacao) {
		this.situacao = situacao;
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((chequeId == null) ? 0 : chequeId.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result
				+ ((dataCadastro == null) ? 0 : dataCadastro.hashCode());
		result = prime * result
				+ ((lancamento == null) ? 0 : lancamento.hashCode());
		result = prime * result
				+ ((situacao == null) ? 0 : situacao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Cheque))
			return false;
		Cheque other = (Cheque) obj;
		if (chequeId == null) {
			if (other.chequeId != null)
				return false;
		} else if (!chequeId.equals(other.chequeId))
			return false;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (dataCadastro == null) {
			if (other.dataCadastro != null)
				return false;
		} else if (!dataCadastro.equals(other.dataCadastro))
			return false;
		if (lancamento == null) {
			if (other.lancamento != null)
				return false;
		} else if (!lancamento.equals(other.lancamento))
			return false;
		if (situacao == null) {
			if (other.situacao != null)
				return false;
		} else if (!situacao.equals(other.situacao))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Cheque [chequeId=" + chequeId + ", conta=" + conta
				+ ", dataCadastro=" + dataCadastro + ", situacao=" + situacao
				+ ", lancamento=" + lancamento + "]";
	}

}
