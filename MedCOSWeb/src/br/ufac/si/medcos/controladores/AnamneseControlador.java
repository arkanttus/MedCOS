package br.ufac.si.medcos.controladores;

import java.util.List;

import javax.faces.bean.*;

import br.ufac.si.medcos.gerentes.*;
import br.ufac.si.medcos.entidades.*;

@ManagedBean(name="anamneseControlador")
@SessionScoped
public class AnamneseControlador
{
	private AnamneseGerente ag;
	private Anamnese anamnese;
	private String termo;
	
	public AnamneseControlador()
	{
		ag = new AnamneseGerente();
	}
	
	public Anamnese getAnamnese()
	{
		return anamnese;
	}

	public void setAnamnese(Anamnese anamnese)
	{
		this.anamnese = anamnese;
	}

	public String getTermo()
	{
		return termo;
	}

	public void setTermo(String termo)
	{
		this.termo = termo;
	}
	
	public List<Anamnese> getAnamnesesRecentes(Paciente paciente)
	{
		return ag.recuperarMaisRecentesPorPaciente(paciente);
	}
}
