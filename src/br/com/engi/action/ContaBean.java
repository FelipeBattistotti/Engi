package br.com.engi.action;

import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.StreamedContent;

import br.com.engi.model.Conta;
import br.com.engi.negocio.ContaRN;
import br.com.engi.util.ContextoBean;
import br.com.engi.util.ContextoUtil;
import br.com.engi.util.RNException;
import br.com.engi.util.RelatorioUtil;

@ManagedBean
@RequestScoped
public class ContaBean {

	private Conta selecionada = new Conta();
	private List<Conta> lista = null;

	private StreamedContent	arquivoRetorno;
	private int				tipoRelatorio;

	public void salvar() {
		try {
			ContextoBean cb = ContextoUtil.getContextoBean();
	
			selecionada.setUsuario(cb.getUsuarioLogado());
			ContaRN crn = new ContaRN();
			crn.salvar(selecionada);
			lista = null;
			selecionada = new Conta();
		} catch (RNException e) {
			ContextoUtil.apresentarErroDeNegocio(e);
		}
	}
	
	public void excluir() {
		try {
			ContaRN crn = new ContaRN();
			crn.excluir(selecionada);
			selecionada = new Conta();
			lista = null;
		} catch (RNException e) {
			ContextoUtil.apresentarErroDeNegocio(e);
		}
	}

	public List<Conta> getLista() {
		if(lista == null){
			try {
				ContextoBean cb = ContextoUtil.getContextoBean();
				ContaRN crn = new ContaRN();
				lista = crn.pesquisar(new Conta(cb.getUsuarioLogado()));
			} catch (RNException e) {
				ContextoUtil.apresentarErroDeNegocio(e);
			}
		}
		return lista;
	}
	
	public void tornarFavorita(){
		try {
			ContaRN crn = new ContaRN();
			crn.tornarFavorita(selecionada);
			selecionada = new Conta();
		} catch (RNException e) {
			ContextoUtil.apresentarErroDeNegocio(e);
		}
	}

	public Conta getSelecionada() {
		return selecionada;
	}

	public void setSelecionada(Conta selecionada) {
		this.selecionada = selecionada;
	}


	public void setLista(List<Conta> lista) {
		this.lista = lista;
	}

	public StreamedContent getArquivoRetorno() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		ContextoBean contextoBean = ContextoUtil.getContextoBean();
		
		String usuario = contextoBean.getUsuarioLogado().getLogin();
		String nomeRelatorioJasper = "contas";
		String nomeRelatorioSaida = usuario + "_contas";
		
		RelatorioUtil relatorioUtil = new RelatorioUtil();
		HashMap<String, Object> parametrosRelatorio = new HashMap<>();
		parametrosRelatorio.put("codUsuario", contextoBean.getUsuarioLogado().getCodigo());
		parametrosRelatorio.put("nmUsuario", contextoBean.getUsuarioLogado().getNome());
		
		try {
			this.arquivoRetorno = relatorioUtil.geraRelatorio(parametrosRelatorio, 
															  nomeRelatorioJasper, 
															  nomeRelatorioSaida, 
															  tipoRelatorio);
		} catch (Exception e) {
			context.addMessage(null, new FacesMessage(e.getMessage()));
			return null;
		} 
		
		return arquivoRetorno;
	}

	public void setArquivoRetorno(StreamedContent arquivoRetorno) {
		this.arquivoRetorno = arquivoRetorno;
	}

	public int getTipoRelatorio() {
		return tipoRelatorio;
	}

	public void setTipoRelatorio(int tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}
}