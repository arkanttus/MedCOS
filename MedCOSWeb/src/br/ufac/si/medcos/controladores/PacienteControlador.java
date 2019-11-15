package br.ufac.si.medcos.controladores;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import br.ufac.si.medcos.gerentes.*;
import br.ufac.si.medcos.entidades.*;

@ManagedBean(name="pacienteControlador")
@SessionScoped
public class PacienteControlador
{
	private PacienteGerente pg;
	private Paciente paciente;
	private String termo;
	
	public PacienteControlador()
	{
		pg = new PacienteGerente();
	}
	
	public Paciente getPaciente()
	{
		return paciente;
	}

	public void setPaciente(Paciente paciente)
	{
		this.paciente = paciente;
	}

	public String getTermo()
	{
		return termo;
	}

	public void setTermo(String termo)
	{
		this.termo = termo;
	}
	
	public List<Paciente> getPacientes()
	{
		return pg.recuperarTodosPorNome();
	}
	
	public List<Paciente> getPacientesContendo()
	{
		return pg.recuperarTodosPorNomeContendo(termo);
	}
	
	public PacienteGerente getGerente()
	{
		return pg;
	}
	
	//====================// Rotas //====================//
	
	//Inserção de novo paciente
	public String adicionar()  
	{
		this.paciente = new Paciente();
		return "adicionarPaciente";
	}
	
	//Salvando nova consulta
	public String salvarInclusao()
	{
		pg.adicionar(paciente);
		return "index";
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
	
	//Edição de paciente
	public String editar(Paciente paciente)
	{
		this.paciente = paciente;
		return "editarPaciente";
	}
	
	//Salvando paciente editado
	public String salvarEdicao()
	{
		pg.atualizar(paciente);
		return "pacientes";
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
	
	//Excluir paciente
	public void excluir(Paciente paciente)
	{
		pg.remover(paciente);
	}
}
