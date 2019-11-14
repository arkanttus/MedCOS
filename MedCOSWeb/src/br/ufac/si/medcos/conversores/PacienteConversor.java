package br.ufac.si.medcos.conversores;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.convert.*;

import br.ufac.si.medcos.controladores.PacienteControlador;
import br.ufac.si.medcos.entidades.Paciente;
import br.ufac.si.medcos.gerentes.PacienteGerente;

@FacesConverter(value="pacienteConversor", forClass=Paciente.class)
public class PacienteConversor implements Converter 
{
	private PacienteGerente pg;
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) 
	{
		if(value == null || value.isEmpty())
			return null;
		
		if(pg == null)
		{
			ELContext elContext = context.getELContext();
			ELResolver elResolver = elContext.getELResolver();
			pg = ((PacienteControlador) elResolver.getValue(elContext, null, "pacienteControlador")).getGerente();
		}
		
		return pg.recuperar(Paciente.class, Integer.valueOf(value));
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) 
	{
		if(value == null || !(value instanceof Paciente))
			return "";
		
		return String.valueOf(((Paciente)value).getId());
	}
}