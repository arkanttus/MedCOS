package br.ufac.si.medcos.conversores;

import java.util.List;

import javax.el.ELContext;
import javax.el.ELResolver;
import javax.faces.component.*;
import javax.faces.context.*;
import javax.faces.convert.*;

import br.ufac.si.medcos.controladores.PacienteControlador;
import br.ufac.si.medcos.entidades.Anamnese;
import br.ufac.si.medcos.gerentes.AnamneseGerente;

@FacesConverter(value="anamneseConversor", forClass=Anamnese.class)
public class AnamneseConversor implements Converter 
{
	private AnamneseGerente ag;
	private PacienteControlador pc;
	
	public Object getAsObject(FacesContext context, UIComponent component, String value) 
	{
		if(value == null || value.isEmpty())
			return null;
		
		if(ag == null)
		{
			ELContext elContext = context.getELContext();
			ELResolver elResolver = elContext.getELResolver();
			pc = ((PacienteControlador) elResolver.getValue(elContext, null, "pacienteControlador"));
			ag = pc.getGerenteAnamnese();
		}
		
		List<Anamnese> anamneses = pc.getPaciente().getAnamneses();
		int chave = Integer.valueOf(value);
		if(anamneses.size() > chave)
			return anamneses.get(chave);
		
		return ag.recuperar(Anamnese.class, chave);
	}

	public String getAsString(FacesContext context, UIComponent component, Object value) 
	{
		if(value == null || !(value instanceof Anamnese))
			return "";
		
		return String.valueOf(((Anamnese)value).getId());
	}
}