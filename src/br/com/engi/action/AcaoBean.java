package br.com.engi.action;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.engi.model.Acao;
import br.com.engi.negocio.AcaoRN;
import br.com.engi.util.ContextoBean;
import br.com.engi.util.ContextoUtil;
import br.com.engi.util.RNException;
import br.com.engi.util.YahooFinanceUtil;
import br.com.engi.vo.AcaoVO;

@ManagedBean(name = "acaoBean")
@RequestScoped
public class AcaoBean {

	private AcaoVO selecionada = new AcaoVO();
	private List<AcaoVO> lista = null;
	private String linkCodigoAcao	= null;

	public void salvar() {
		try {
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			AcaoRN acaoRN = new AcaoRN();
			Acao acao = this.selecionada.getAcao();
			acao.setSigla(acao.getSigla().toUpperCase());
			acao.setUsuario(contextoBean.getUsuarioLogado());
			acaoRN.salvar(acao);
			
			this.selecionada = new AcaoVO();
			this.lista = null;
		} catch (RNException e) {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	public void excluir() {
		try {
			AcaoRN acaoRN = new AcaoRN();
			acaoRN.excluir(this.selecionada.getAcao());
			
			this.selecionada = new AcaoVO();
			this.lista = null;
		} catch (RNException e) {
			FacesContext.getCurrentInstance()
			.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), ""));
		}
	}

	public List<AcaoVO> getLista() {
		FacesContext context = FacesContext.getCurrentInstance();
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		AcaoRN acaoRN = new AcaoRN();
		try {
			if (this.lista == null) {
				this.lista = acaoRN.listarAcaoVirtual(contextoBean.getUsuarioLogado());
			}
		} catch (RNException e) {
			context.addMessage(null, new FacesMessage(e.getMessage()));
		}
		return this.lista;
	}

	public String getLinkCodigoAcao() {
		AcaoRN acaoRN = new AcaoRN();
		if (this.selecionada != null) {
			this.linkCodigoAcao = acaoRN.montaLinkAcao(this.selecionada.getAcao());
		} else {
			this.linkCodigoAcao = YahooFinanceUtil.INDICE_BOVESPA;
		}
		return this.linkCodigoAcao;
	}

	public AcaoVO getSelecionada() {
		return this.selecionada;
	}

	public void setLinkCodigoAcao(String linkCodigoAcao) {
		this.linkCodigoAcao = linkCodigoAcao;
	}

	public void setLista(List<AcaoVO> lista) {
		this.lista = lista;
	}

	public void setSelecionada(AcaoVO selecionada) {
		this.selecionada = selecionada;
	}
}
