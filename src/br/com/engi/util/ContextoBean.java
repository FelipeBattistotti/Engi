package br.com.engi.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import br.com.engi.model.Conta;
import br.com.engi.model.Usuario;
import br.com.engi.negocio.ContaRN;
import br.com.engi.negocio.UsuarioRN;


/**
 * Objetivo desta classe é conter os dados do usuario logado
 * armazendo em um único objeto tudo que possa ser necessario,
 * o qual estará em escopo de sessão.
 */
@ManagedBean(name = "contextoBean")
@SessionScoped
public class ContextoBean {

	/** Contem a instancia do usuario logado  */
	private Usuario usuarioLogado = null;
	
	/** Contem os dados da conta ativa */
	private Conta	contaAtiva	  = null;

	private Locale localizacao = null;
	private List<Locale> idiomas;

	public Usuario getUsuarioLogado() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext external = context.getExternalContext();
		String login = external.getRemoteUser();

		// Entrara no IF apenas na primeira chamada, depois sempre retorna o usuario
		if (usuarioLogado == null || !login.equals(usuarioLogado.getLogin())) {
			
			if (login != null) {
				UsuarioRN usuarioRN = new UsuarioRN();
				usuarioLogado = usuarioRN.buscarPorLogin(login);
				contaAtiva = null;
				
				/**
				 * 
				String[] info = this.usuarioLogado.getIdioma().split("_");
				Locale locale = new Locale(info[0], info[1]);
				context.getViewRoot().setLocale(locale);
				 */
			}
		}
		return usuarioLogado;
	}
	
	public void setUsuarioLogado(Usuario usuario) {
		usuarioLogado = usuario;
	}
	
	public Conta getContaAtiva() {
		// primeiro acesso a conta esta nula
		if (contaAtiva == null) {
			try {
				Usuario usuario = getUsuarioLogado();
	
				ContaRN contaRN = new ContaRN();
				contaAtiva = contaRN.buscarFavorita(usuario);

				// Caso usuario nao possua conta favorita
				if (contaAtiva == null) {
					// busca todas as contas do usuario
					List<Conta> contas = contaRN.pesquisar(new Conta(usuario));
					if (contas != null) {
						
						contaAtiva = contas.get(0);
						
//						// sai do loop apos encontrar primeira conta
//						for (Conta conta : contas) {
//							contaAtiva = conta;
//							break;
//						}
					}
				}
			} catch (RNException e) {
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								e.getMessage(), ""));
			}
		}
		return contaAtiva;
	}

	/**
	 * Mais a frente teremos o programa lancamento
	 * que ira fazer um lancamento em uma CONTA_ATIVA
	 * logo toda a vez que alteramos uma conta na combo
	 * devemos alterar-la na sessao.
	 */
	public void setContaAtiva(ValueChangeEvent event) {
		try {
			Integer codigo = (Integer) event.getNewValue();
			ContaRN contaRN = new ContaRN();
			
			contaAtiva = contaRN.obterPorId(new Conta(codigo));
		} catch (RNException e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							e.getMessage(), ""));
		}
	}
	
	public Locale getLocaleUsuario() {
		if (localizacao == null) {
			/**
			 * 
			Usuario usuario = getUsuarioLogado();
			String idioma = usuario.getIdioma();
			String[] info = idioma.split("_");
			localizacao = new Locale(info[0], info[1]);
			*/
		}		
		
		return localizacao;
	}
	
	
	/**
	 * Retorna uma lista de Locale (idiomas suportados pelo sistema, 
	 * definido no arquivo faces-config.xml)
	 */
	public List<Locale> getIdiomas() {
		FacesContext context = FacesContext.getCurrentInstance();
		Iterator<Locale> locales = context.getApplication().getSupportedLocales();
		idiomas = new ArrayList<Locale>();
		
		while(locales.hasNext()) {
			idiomas.add(locales.next());
		}
		
		return idiomas;
	}
	
	/**
	 * Altera o idioma default do usuario na base de dados
	 * para que sempre fique nesse idioma (até ser alterado)
	 */
	public void setIdiomaUsuario(String idioma) {
		UsuarioRN usuarioRN = new UsuarioRN();
		try {
			usuarioLogado = usuarioRN.obterPorId(getUsuarioLogado());
			//usuarioLogado.setIdioma(idioma);
			usuarioRN.salvar(usuarioLogado);
		} catch (RNException e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao setar o idioma: " + e.getMessage(), null));
			return;
		}

		// APÓS ter alterado o idioma do usuario
		// seta o novo idioma no locale da sessao
		String[] info = idioma.split("_");
		Locale locale = new Locale(info[0], info[1]);
		
		FacesContext context = FacesContext.getCurrentInstance();
		context.getViewRoot().setLocale(locale);		
	}
}













