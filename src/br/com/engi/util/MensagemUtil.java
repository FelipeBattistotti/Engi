package br.com.engi.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public class MensagemUtil {
	
	/**
	 * Retorna o valor de uma chave cadastrada no arquivo de properties...
	 * @param propriedade - chave a ser buscada....
	 * @return
	 */
	public static String getMensagem(String propriedade) {
		
		// Pegamos o contexto do JSF
		FacesContext context = FacesContext.getCurrentInstance();
		
		// com este temos acesso ao ResourceBundle e dele pegamos o recurso
		// registrado no faces-config.xml
		ResourceBundle bundle = context.getApplication().getResourceBundle(context, "msg");
		
		// de posso do ResourceBundle, pegamos a chave que se deseja
		return bundle.getString(propriedade);
	}
	
	// ... --> var-args OU argumentos variaveis (posso passar UM ou muitos...)
	// 	 	   SEMPRE serão o ÚLTIMO parametro e SOMENTE UM var-args por método
	//		   o var-args vira um ARRAY dentro do método TAMANHO FIXO
	public static String getMensagem(String propriedade, Object ...parametros) {
		
		// BUSCAMOS o valor da chave
		String mensagem = getMensagem(propriedade);
		
		// aplicamos os parametros aos (parametros da mensagem - {0} .. {1}...)	
		MessageFormat formatter = new MessageFormat(mensagem);
		
		// pega o primeiro valor do array e coloca no primeiro prm da mensagem....
		return formatter.format(parametros);
	}

}
