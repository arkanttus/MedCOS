package br.ufac.si.medcos.conversores;

import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.convert.*;

import br.ufac.si.medcos.entidades.Paciente;
import br.ufac.si.medcos.gerentes.PacienteGerente;

@FacesConverter(value="pacienteConversor", forClass=Paciente.class)
public class PacienteConversor implements Converter 
{
	PacienteGerente pg = new PacienteGerente();
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) 
	{
		if(value == null || value.isEmpty())
			return null;
		
		return pg.recuperar(Paciente.class, Integer.valueOf(value));
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) 
	{
		if(value == null || !(value instanceof Paciente))
			return "";
		
		return String.valueOf(((Paciente)value).getId());
	}
}