package br.com.engi.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.engi.model.Categoria;
import br.com.engi.negocio.CategoriaRN;

@FacesConverter(forClass = Categoria.class)
public class CategoriaConverter implements Converter {

	/**
	 * Este método recebe um texto e retorna uma instancia
	 * ao qual este converter esta aplicado.... (forClass = Categoria.class)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && value.trim().length() > 0) {
			// AQUI pegamos o codigo de categoria
			Integer codigo = Integer.valueOf(value);
			try {
				CategoriaRN categoriaRN = new CategoriaRN();
				// retornamos uma instancia de acordo com o codigo informado
				return categoriaRN.obterPorId(new Categoria(codigo));
			} catch (Exception e) {
				throw new ConverterException("Não foi possível encontrar a categoria de código " + value + "." + e.getMessage());
			}
		}
		return null;
	}

	/**
	 * Recebe uma instancia de um objeto e retorna-o como texto
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Categoria categoria = (Categoria) value;
			// retornamos o codigo da categoria. Este sera seu VALUE
			return categoria.getCodigo().toString();
		}
		return "";
	}
}
