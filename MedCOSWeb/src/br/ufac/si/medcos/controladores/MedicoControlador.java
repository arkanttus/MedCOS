package br.ufac.si.medcos.controladores;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import br.ufac.si.medcos.gerentes.*;
import br.ufac.si.medcos.entidades.*;

@ManagedBean(name="medicoControlador")
@SessionScoped
public class MedicoControlador
{
	private MedicoGerente mg;
	private Medico medico;
	private String termo;
	
	public MedicoControlador()
	{
		mg = new MedicoGerente();
	}
	
	public Medico getMedico()
	{
		return medico;
	}

	public void setMedico(Medico medico)
	{
		this.medico = medico;
	}

	public String getTermo()
	{
		return termo;
	}

	public void setTermo(String termo)
	{
		this.termo = termo;
	}
	
	public List<Medico> getMedicos()
	{
		return mg.recuperarTodosPorNome();
	}
	
	public List<Medico> getMedicosContendo()
	{
		return mg.recuperarTodosPorNomeContendo(termo);
	}
	
	public MedicoGerente getGerente()
	{
		return mg;
	}
	
	//====================// Rotas //====================//
	
	//Inserção de novo medico
	public String adicionar()  
	{
		this.medico = new Medico();
		return "adicionarMedico";
	}
	
	//Salvando nova consulta
	public String salvarInclusao()
	{
		mg.adicionar(medico);
		return "medicos";
		/*Calendar cal = Calendar.getInstance();
		Date agora = cal.getTime();
		
		if(consulta.getDataHora().compareTo(agora) > 0)
		{
			consulta.setObs("");
			consulta.setSintomas("");
			consulta.setStatus("Pendente");
			cg.adicionar(consulta);
			return "index";
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage("formConsulta:dataHora", new FacesMessage("A data e horário não podem ser antes de agora."));
			return null;
		}*/
	}
	
	//Edição de medico
	public String editar(Medico medico)
	{
		this.medico = medico;
		return "editarMedico";
	}
	
	//Salvando medico editado
	public String salvarEdicao()
	{
		mg.atualizar(medico);
		return "medicos";
		/*Calendar cal = Calendar.getInstance();
		Date agora = cal.getTime();
		
		if(consulta.getDataHora().compareTo(agora) > 0)
		{
			cg.atualizar(consulta);
			return "index";
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage("formConsulta:dataHora", new FacesMessage("A data e horário não podem ser antes de agora."));
			return null;
		}*/
	}
	
	//Excluir medico
	public void excluir(Medico medico)
	{
		mg.remover(medico);
	}
}
