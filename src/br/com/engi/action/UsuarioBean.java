package br.com.engi.action;

import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.engi.model.Conta;
import br.com.engi.model.Usuario;
import br.com.engi.negocio.ContaRN;
import br.com.engi.negocio.UsuarioRN;
import br.com.engi.util.ContextoUtil;
import br.com.engi.util.RNException;

@ManagedBean
@RequestScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private String confirmaSenha;
	
	private transient List<Usuario> lista;
	
	/**
	 * Informa qual pagina deve ser exibida após operação de SAVE
	 * 
	 * Para novos usuarios: 	usuarioSucesso
	 * Para edição de usuarios:	admin/principal
	 */
	private String destinoSalvar;
	
	// mais gets e sets
	private Conta conta = new Conta();

	public String novo(){
		usuario = new Usuario();
		usuario.setAtivo(true);
		destinoSalvar = "usuarioSucesso";
		return "usuario";
	}
	

	public String editar(){
		System.out.println("*editar()");
		// Campo calculado.
		confirmaSenha = usuario.getSenha();
		
		// origem da requisição é /admin/principal
		return "/publico/usuario";
	}
	
	public String salvar(){
		FacesContext contexto = FacesContext.getCurrentInstance();
		try {
		
			if(!usuario.getSenha().equals(confirmaSenha)){
				contexto.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas diferentes", ""));
				return "usuario";
			}
			
			UsuarioRN urn = new UsuarioRN();
			urn.salvar(usuario);
			
			// salva a conta do usuario recem criado
			if(conta.getDescricao() != null){
				conta.setUsuario(usuario);
				
				ContaRN crn = new ContaRN();
				crn.salvar(conta);
			}
			
		} catch (RNException e) {
			ContextoUtil.apresentarErroDeNegocio(e);
			return null;
		}
		
		return destinoSalvar;
	}

	public void excluir(){
		try {
			UsuarioRN rn = new UsuarioRN();
			rn.excluir(usuario);
			lista = null;
		} catch (RNException e) {
			FacesContext.getCurrentInstance().addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							e.getMessage(), ""));
		}
	}

	public List<Usuario> getLista() {
		if(lista == null){
			UsuarioRN rn = new UsuarioRN();
			try {
				lista = rn.pesquisar(new Usuario());
			} catch (RNException e) {
				FacesContext.getCurrentInstance().addMessage(null, 
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								e.getMessage(), ""));
			}
		}
		
		return lista;
	}
	
	public void ativar(){
		if(usuario.isAtivo()){
			usuario.setAtivo(false);
		} else {
			usuario.setAtivo(true);
		}
	}
	
	public String atribuiPermissao(Usuario usuario, String permissao) {

		this.usuario = usuario;

		Set<String> permissoes = this.usuario.getPermissao();

		if (permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}
		return null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}


	public Conta getConta() {
		return conta;
	}


	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
