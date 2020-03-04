package br.com.engi.action;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.engi.model.Cheque;
import br.com.engi.model.Conta;
import br.com.engi.negocio.ChequeRN;
import br.com.engi.util.ContextoBean;
import br.com.engi.util.ContextoUtil;
import br.com.engi.util.MensagemUtil;
import br.com.engi.util.RNException;

@ManagedBean
@RequestScoped
public class ChequeBean {
	
	private Cheque selecionado = new Cheque();
	private List<Cheque> lista = null;
	private Integer chequeInicial;
	private Integer chequeFinal;
	
	public void salvar() {
		// Pegamos o contexto do JSF
		FacesContext context = FacesContext.getCurrentInstance();
		
		// Pegamos o contextoUtil da Sessao
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		
		// pegamos a conta que esta ativa
		Conta conta = contextoBean.getContaAtiva();
		
		int totalCheques = 0;
		if (chequeInicial == null || chequeFinal == null) {
			context.addMessage(null, new FacesMessage(MensagemUtil.getMensagem("cheque_erro_sequencia")));
			
		} else if (chequeFinal.intValue() < chequeInicial.intValue()) {
			context.addMessage(null, new FacesMessage(MensagemUtil.getMensagem("cheque_erro_inicial_final", chequeInicial, chequeFinal)));
			
		} else {
			ChequeRN chequeRN = new ChequeRN();
			
			try {
				// Vai ao banco salvar sequencia de cheques
				totalCheques = chequeRN.salvarSequencia(conta, chequeInicial, chequeFinal);
			} catch (RNException e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar cheque: " + e.getMessage(), null));
				return;
			}
			
			// Mensagem de sucesso
			context.addMessage(null, new FacesMessage(MensagemUtil.getMensagem("cheque_info_cadastro", chequeFinal, totalCheques,120)));
			lista = null;
		}
	}
	
	public void excluir() {
		ChequeRN chequeRN = new ChequeRN();
		try {
			chequeRN.excluir(selecionado);
		} catch (RNException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, MensagemUtil.getMensagem("cheque_erro_excluir"), null));
			return;
		}
		
		lista = null;
	}
	
	public void cancelar() {
		ChequeRN chequeRN = new ChequeRN();
		try {
			chequeRN.cancelarCheque(selecionado);
		} catch (RNException e) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, MensagemUtil.getMensagem("cheque_erro_cancelar"), null));
			return;
		}
		
		lista = null;
	}

	public Cheque getSelecionado() {
		return selecionado;
	}

	public void setSelecionado(Cheque selecionado) {
		this.selecionado = selecionado;
	}

	public List<Cheque> getLista() {
		if (lista == null) {
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			Conta conta = contextoBean.getContaAtiva();
			
			ChequeRN chequeRN = new ChequeRN();
			Cheque chequeAux = new Cheque();
			chequeAux.setConta(conta);
			try {
				lista = chequeRN.pesquisar(chequeAux);
			} catch (RNException e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao listar cheques: " + e.getMessage(), null));
				return null;
			}
		}		
		
		return lista;
	}

	public void setLista(List<Cheque> lista) {
		this.lista = lista;
	}

	public Integer getChequeInicial() {
		return chequeInicial;
	}

	public void setChequeInicial(Integer chequeInicial) {
		this.chequeInicial = chequeInicial;
	}

	public Integer getChequeFinal() {
		return chequeFinal;
	}

	public void setChequeFinal(Integer chequeFinal) {
		this.chequeFinal = chequeFinal;
	}
		
}
