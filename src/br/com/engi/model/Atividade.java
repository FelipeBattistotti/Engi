package br.com.engi.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="atividade")
@SequenceGenerator(name="sequenceAtividade", sequenceName="seq_atividade")
public class Atividade implements Serializable {
	
	private static final long serialVersionUID = 4013609671444744966L;
	
	@Id
	@GeneratedValue(generator="sequenceAtividade")
	@Column(name="cod_atividade")
	private Integer codigo;
	
	@Column(name="des_codigo_projeto")
	private String codigoProjeto;
	
	/**
	 * 1 - Desenvolvedor
	 * 2 - Analista de Sistemas
	 * 3 - Analista de Negócio
	 */
	@Column(name="cod_funcao")
	private Integer funcao;
	
	/**
	 * 1 - Incluir
	 * 2 - Alterar
	 * 3 - Aprovar
	 * 4 - Não Aprovar
	 * 5 - Sugestão
	 */
	@Column(name="cod_acao")
	private Integer acao;
	
	/**
	 * 1 - Doc Engenharia
	 * 2 - Doc Orçamento
	 */
	@Column(name="cod_tip_doc")
	private Integer tipoDocumento;
	
	@Column(name="des_sugestao")
	private String sugestao;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_usuario")
	private Usuario usuario;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_midia")
	private Midia midia;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_doc_engenharia")
	private DocEngenharia docEngenharia;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="cod_doc_orcamento")
	private DocOrcamento docOrcamento;
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy="atividade",fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<AtividadeCodigoFonte> atividadeCodigoFonteList;
	
	@OneToMany(cascade={CascadeType.PERSIST, CascadeType.REMOVE}, mappedBy="atividade",fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<AtividadeTabela> atividadeTabelaList;
	
	/**
	 * DOC_ORC
	 * DOC_ENG
	 * COD_FONTE
	 * TABELA
	 */
	private String tipo;
	
	public Atividade() {
		super();
	}
	
	public Atividade(Integer codigo) {
		super();
		this.codigo = codigo;
	}
	
	public Atividade(Integer codigo, String codigoProjeto, Integer funcao,
			Integer acao, Integer tipoDocumento, String sugestao,
			Usuario usuario, Midia midia, DocEngenharia docEngenharia,
			DocOrcamento docOrcamento,
			List<AtividadeCodigoFonte> atividadeCodigoFonteList,
			List<AtividadeTabela> atividadeTabelaList, String tipo) {
		super();
		this.codigo = codigo;
		this.codigoProjeto = codigoProjeto;
		this.funcao = funcao;
		this.acao = acao;
		this.tipoDocumento = tipoDocumento;
		this.sugestao = sugestao;
		this.usuario = usuario;
		this.midia = midia;
		this.docEngenharia = docEngenharia;
		this.docOrcamento = docOrcamento;
		this.atividadeCodigoFonteList = atividadeCodigoFonteList;
		this.atividadeTabelaList = atividadeTabelaList;
		this.tipo = tipo;
	}
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public String getCodigoProjeto() {
		return codigoProjeto;
	}
	public void setCodigoProjeto(String codigoProjeto) {
		this.codigoProjeto = codigoProjeto;
	}
	
	public Integer getFuncao() {
		return funcao;
	}
	public void setFuncao(Integer funcao) {
		this.funcao = funcao;
	}
	
	public Integer getAcao() {
		return acao;
	}
	public void setAcao(Integer acao) {
		this.acao = acao;
	}
	
	public Integer getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(Integer tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public String getSugestao() {
		return sugestao;
	}
	public void setSugestao(String sugestao) {
		this.sugestao = sugestao;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Midia getMidia() {
		return midia;
	}
	public void setMidia(Midia midia) {
		this.midia = midia;
	}
	
	public DocEngenharia getDocEngenharia() {
		return docEngenharia;
	}
	public void setDocEngenharia(DocEngenharia docEngenharia) {
		this.docEngenharia = docEngenharia;
	}
	
	public DocOrcamento getDocOrcamento() {
		return docOrcamento;
	}
	public void setDocOrcamento(DocOrcamento docOrcamento) {
		this.docOrcamento = docOrcamento;
	}
	
	public List<AtividadeCodigoFonte> getAtividadeCodigoFonteList() {
		return atividadeCodigoFonteList;
	}
	public void setAtividadeCodigoFonteList(
			List<AtividadeCodigoFonte> atividadeCodigoFonteList) {
		this.atividadeCodigoFonteList = atividadeCodigoFonteList;
	}
	
	public List<AtividadeTabela> getAtividadeTabelaList() {
		return atividadeTabelaList;
	}
	public void setAtividadeTabelaList(List<AtividadeTabela> atividadeTabelaList) {
		this.atividadeTabelaList = atividadeTabelaList;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acao == null) ? 0 : acao.hashCode());
		result = prime
				* result
				+ ((atividadeCodigoFonteList == null) ? 0
						: atividadeCodigoFonteList.hashCode());
		result = prime
				* result
				+ ((atividadeTabelaList == null) ? 0 : atividadeTabelaList
						.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result
				+ ((codigoProjeto == null) ? 0 : codigoProjeto.hashCode());
		result = prime * result
				+ ((docEngenharia == null) ? 0 : docEngenharia.hashCode());
		result = prime * result
				+ ((docOrcamento == null) ? 0 : docOrcamento.hashCode());
		result = prime * result + ((funcao == null) ? 0 : funcao.hashCode());
		result = prime * result + ((midia == null) ? 0 : midia.hashCode());
		result = prime * result
				+ ((sugestao == null) ? 0 : sugestao.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result
				+ ((tipoDocumento == null) ? 0 : tipoDocumento.hashCode());
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
		Atividade other = (Atividade) obj;
		if (acao == null) {
			if (other.acao != null)
				return false;
		} else if (!acao.equals(other.acao))
			return false;
		if (atividadeCodigoFonteList == null) {
			if (other.atividadeCodigoFonteList != null)
				return false;
		} else if (!atividadeCodigoFonteList
				.equals(other.atividadeCodigoFonteList))
			return false;
		if (atividadeTabelaList == null) {
			if (other.atividadeTabelaList != null)
				return false;
		} else if (!atividadeTabelaList.equals(other.atividadeTabelaList))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (codigoProjeto == null) {
			if (other.codigoProjeto != null)
				return false;
		} else if (!codigoProjeto.equals(other.codigoProjeto))
			return false;
		if (docEngenharia == null) {
			if (other.docEngenharia != null)
				return false;
		} else if (!docEngenharia.equals(other.docEngenharia))
			return false;
		if (docOrcamento == null) {
			if (other.docOrcamento != null)
				return false;
		} else if (!docOrcamento.equals(other.docOrcamento))
			return false;
		if (funcao == null) {
			if (other.funcao != null)
				return false;
		} else if (!funcao.equals(other.funcao))
			return false;
		if (midia == null) {
			if (other.midia != null)
				return false;
		} else if (!midia.equals(other.midia))
			return false;
		if (sugestao == null) {
			if (other.sugestao != null)
				return false;
		} else if (!sugestao.equals(other.sugestao))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (tipoDocumento == null) {
			if (other.tipoDocumento != null)
				return false;
		} else if (!tipoDocumento.equals(other.tipoDocumento))
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
		return "Atividade [codigo=" + codigo + ", codigoProjeto="
				+ codigoProjeto + ", funcao=" + funcao + ", acao=" + acao
				+ ", tipoDocumento=" + tipoDocumento + ", sugestao=" + sugestao
				+ ", usuario=" + usuario + ", midia=" + midia
				+ ", docEngenharia=" + docEngenharia + ", docOrcamento="
				+ docOrcamento + ", atividadeCodigoFonteList="
				+ atividadeCodigoFonteList + ", atividadeTabelaList="
				+ atividadeTabelaList + ", tipo=" + tipo + "]";
	}
	
}