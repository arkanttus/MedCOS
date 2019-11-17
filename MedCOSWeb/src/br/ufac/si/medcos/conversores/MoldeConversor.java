package br.ufac.si.medcos.conversores;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.convert.*;

import br.ufac.si.medcos.controladores.MoldeControlador;
import br.ufac.si.medcos.entidades.Molde;
import br.ufac.si.medcos.gerentes.MoldeGerente;

@FacesConverter(value="moldeConversor", forClass=Molde.class)
public class MoldeConversor implements Converter 
{
	private MoldeGerente mg;
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) 
	{
		if(value == null || value.isEmpty())
			return null;
		
		if(mg == null)
		{
			ELContext elContext = context.getELContext();
			ELResolver elResolver = elContext.getELResolver();
			mg = ((MoldeControlador) elResolver.getValue(elContext, null, "moldeControlador")).getGerente();
		}
		
		return mg.recuperar(Molde.class, Integer.valueOf(value));
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) 
	{
		if(value == null || !(value instanceof Molde))
			return "";
		
		return String.valueOf(((Molde)value).getId());
	}
}