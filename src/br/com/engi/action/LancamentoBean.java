package br.com.engi.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import br.com.engi.domain.SituacaoCheque;
import br.com.engi.model.Categoria;
import br.com.engi.model.Cheque;
import br.com.engi.model.ChequeId;
import br.com.engi.model.Conta;
import br.com.engi.model.Lancamento;
import br.com.engi.negocio.ChequeRN;
import br.com.engi.negocio.LancamentoRN;
import br.com.engi.util.ContextoBean;
import br.com.engi.util.ContextoUtil;
import br.com.engi.util.RNException;

@ManagedBean
@RequestScoped
public class LancamentoBean {

	private List<Lancamento> lista;
	private List<Double> saldos = new ArrayList<Double>();
	private float saldoGeral;
	private Lancamento editado = new Lancamento();
	
	private List<Lancamento> listaAteHoje;
	private List<Lancamento> listaFuturos;
	
	private Integer numeroCheque;
	
	public LancamentoBean() {
		novo();
	}

	public void novo() {
		editado = new Lancamento();
		editado.setData(new Date(System.currentTimeMillis()));
		numeroCheque = null;
	}
	
	public void editar() {
		Cheque cheque = editado.getCheque();
		if (cheque != null) {
			numeroCheque = cheque.getChequeId().getCheque();
		}
	}
	
	public void salvar() {
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		editado.setUsuario(contextoBean.getUsuarioLogado());
		editado.setConta(contextoBean.getContaAtiva());

		ChequeRN chequeRN = new ChequeRN();
		ChequeId chequeId = null;
		
		// O lancamento pode possuir um cheque
		if (numeroCheque != null) {
			chequeId = new ChequeId();
			chequeId.setConta(contextoBean.getContaAtiva().getCodigo());
			chequeId.setCheque(numeroCheque);
			Cheque chequeAux = new Cheque();
			chequeAux.setChequeId(chequeId);	
			Cheque cheque = null;
			try {
				cheque = chequeRN.obterPorId(chequeAux);
			} catch (RNException e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar cheque: " + e.getMessage(), null));
				return;
			}
			
			// Antes de baixar o cheque, valida-se se o mesmo existe
			// e não esteja cancelado...
			FacesContext context = FacesContext.getCurrentInstance();
			if (cheque == null) {
				context.addMessage(null, new FacesMessage("Cheque não cadastrado"));
				return;
			} else if (SituacaoCheque.C.equals(cheque.getSituacao())) {
				context.addMessage(null, new FacesMessage("Cheque já cancelado"));
				return;
			} else {
				editado.setCheque(cheque);
				try {
					// baixar o cheque, ou seja, alterar sua situação para Baixado
					chequeRN.baixarCheque(chequeId, editado);
				} catch (RNException e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao baixar cheque: " + e.getMessage(), null));
					return;
				}
			}
		}

		LancamentoRN lrn = new LancamentoRN();
		try {
			lrn.salvar(editado);
		} catch (RNException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao salvar lançamento: " + e.getMessage(), null));
			return;
		}
		
		novo();
		lista = null;
	}
	
	public void excluir() {
		LancamentoRN lancamentoRN = new LancamentoRN();
		try {
			editado = lancamentoRN.obterPorId(editado);
			lancamentoRN.excluir(editado);				
			
		} catch (RNException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao excluir lançamento: " + e.getMessage(), null));
			return;
		}
		lista = null;
	}

	public void mudouCheque(ValueChangeEvent event) {
		Integer chequeAnterior = (Integer) event.getOldValue();
		if (chequeAnterior != null) {
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			ChequeRN chequeRN = new ChequeRN();
			try {
				chequeRN.desvinculaLancamento(contextoBean.getContaAtiva(), chequeAnterior);
			} catch (RNException e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao mudar cheque: " + e.getMessage(), null));
				return;
			}
		}
	}
	
	public List<Lancamento> getLista() {
		if (lista == null) {
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			Conta conta = contextoBean.getContaAtiva();
			
			Calendar dataSaldo = new GregorianCalendar();
			dataSaldo.add(Calendar.MONTH, -1);
			dataSaldo.add(Calendar.DAY_OF_MONTH, -1);
			
			
			// Pega-se uma instancia de calendar com a data atual
			Calendar inicio = new GregorianCalendar();
			
			//tirando um mes da data atual
			inicio.add(Calendar.MONTH, -1);
			
			LancamentoRN lancamentoRN = new LancamentoRN();
			saldoGeral = lancamentoRN.saldo(conta, dataSaldo.getTime());
			try {
				lista = lancamentoRN.pesquisar(conta, inicio.getTime(), null);
			} catch (RNException e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao obter lançamentos: " + e.getMessage(), null));
				return null;
			}
			
			Categoria categoria = null;
			double saldo = saldoGeral;
			for (Lancamento lancamento : lista) {
				categoria = lancamento.getCategoria();
				saldo += (lancamento.getValor().floatValue() * categoria.getFator());
				saldos.add(saldo);
			}			
		}	
		
		return lista;
	}
	
	public List<Lancamento> getListaAteHoje() {
		if (listaAteHoje == null) {
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			Conta conta = contextoBean.getContaAtiva();
			
			Calendar hoje = new GregorianCalendar();
			
			LancamentoRN lancamentoRN = new LancamentoRN();
			try {
				listaAteHoje = lancamentoRN.pesquisar(conta, null, hoje.getTime());
			} catch (RNException e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao obter lançamentos até hoje: " + e.getMessage(), null));
				return null;
			}
			
		}
		
		return listaAteHoje;
	} 
	
	public List<Lancamento> getListaFuturos() {
		if (listaFuturos == null) {
			ContextoBean contextoBean = ContextoUtil.getContextoBean();
			Conta conta = contextoBean.getContaAtiva();
			
			Calendar amanha = new GregorianCalendar();
			amanha.add(Calendar.DAY_OF_MONTH, 1);
			
			LancamentoRN lancamentoRN = new LancamentoRN();
			try {
				listaFuturos = lancamentoRN.pesquisar(conta, amanha.getTime(), null);
			} catch (RNException e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao obter lançamentos futuros: " + e.getMessage(), null));
				return null;
			}
			
		}
		
		return listaFuturos;
	}

	public Lancamento getEditado() {
		return editado;
	}

	public void setEditado(Lancamento editado) {
		this.editado = editado;
	}

	public List<Double> getSaldos() {
		return saldos;
	}

	public void setSaldos(List<Double> saldos) {
		this.saldos = saldos;
	}

	public float getSaldoGeral() {
		return saldoGeral;
	}

	public void setSaldoGeral(float saldoGeral) {
		this.saldoGeral = saldoGeral;
	}

	public Integer getNumeroCheque() {
		return numeroCheque;
	}

	public void setNumeroCheque(Integer numeroCheque) {
		this.numeroCheque = numeroCheque;
	}
}
