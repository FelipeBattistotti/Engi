package br.com.engi.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.OrderBy;

@Entity
public class Categoria {

	@Id
	@GeneratedValue
	private Integer codigo;

	@ManyToOne
	@JoinColumn(name="categoria_pai", nullable=true)
	private Categoria pai;

	@ManyToOne
	@JoinColumn(name="usuario")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Usuario usuario;

	private String descricao;

	private int fator;

	/**
	 * Assim que pesquisar o registro pai, irá trazer junto
	 * todos os filhos
	 */
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	@JoinColumn(name="categoria_pai", updatable=false)
	@OrderBy(clause="descricao asc") // Os filhos vem ordenados ascendente
	private List<Categoria> filhos;	 // por descricao

	public Categoria() {
	}

	public Categoria(Categoria pai, Usuario usuario, String descricao, int fator) {
		super();
		this.pai = pai;
		this.usuario = usuario;
		this.descricao = descricao;
		this.fator = fator;
	}
	
	public Categoria(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	public Categoria(Integer codigo) {
		super();
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Categoria getPai() {
		return pai;
	}

	public void setPai(Categoria pai) {
		this.pai = pai;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getFator() {
		return fator;
	}

	public void setFator(int fator) {
		this.fator = fator;
	}

	public List<Categoria> getFilhos() {
		return filhos;
	}

	public void setFilhos(List<Categoria> filhos) {
		this.filhos = filhos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Categoria)) {
			return false;
		}
		Categoria other = (Categoria) obj;
		if (codigo == null) {
			if (other.codigo != null) {
				return false;
			}
		} else if (!codigo.equals(other.codigo)) {
			return false;
		}
		return true;
	}
}
