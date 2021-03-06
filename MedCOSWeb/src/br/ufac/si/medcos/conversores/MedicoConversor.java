package br.ufac.si.medcos.conversores;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.convert.*;

import br.ufac.si.medcos.controladores.MedicoControlador;
import br.ufac.si.medcos.entidades.Medico;
import br.ufac.si.medcos.gerentes.MedicoGerente;

@FacesConverter(value="medicoConversor", forClass=Medico.class)
public class MedicoConversor implements Converter 
{
	MedicoGerente mg;
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) 
	{
		if(value == null || value.isEmpty())
			return null;
		
		if(mg == null)
		{
			ELContext elContext = context.getELContext();
			ELResolver elResolver = elContext.getELResolver();
			mg = ((MedicoControlador) elResolver.getValue(elContext, null, "medicoControlador")).getGerente();
		}
		
		return mg.recuperar(Medico.class, Integer.valueOf(value));
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) 
	{
		if(value == null || !(value instanceof Medico))
			return "";
		
		return String.valueOf(((Medico)value).getId());
	}
}