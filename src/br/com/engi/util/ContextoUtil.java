package br.com.engi.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

public class ContextoUtil {

	/**
	 * M�todo que obtem a instancia de contextoBean do escopo de sessao
	 * @return
	 */
	public static ContextoBean getContextoBean() {
		// Primeiro pegamos o contexto do JSF
		FacesContext context = FacesContext.getCurrentInstance();
		
		// Com o contexto do JSF, conseguimos ter acesso ao contexto externo
		ExternalContext external = context.getExternalContext();
		
		// Com o contexto externo, temos acesso ao objeto session
		HttpSession session = (HttpSession) external.getSession(true);

		// Da sessao obtemos o objeto que desejamos: contextoBean
		ContextoBean contextoBean = (ContextoBean) session.getAttribute("contextoBean");
		
		return contextoBean;
	}

	public static void apresentarErroDeNegocio(RNException e) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						e.getMessage(), ""));
	}
}


















