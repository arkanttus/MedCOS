package br.ufac.si.medcos.controladores;

import java.util.ArrayList;
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
	private AnamneseGerente ag;
	private Paciente paciente;
	private Anamnese anamnese;
	private Molde molde;
	private String termo;
	
	public PacienteControlador()
	{
		termo = "";
		pg = new PacienteGerente();
		ag = new AnamneseGerente();
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
	
	public Anamnese getAnamnese()
	{
		return anamnese;
	}

	public void setAnamnese(Anamnese anamnese)
	{
		this.anamnese = anamnese;
	}

	public Molde getMolde()
	{
		return molde;
	}

	public void setMolde(Molde molde)
	{
		this.molde = molde;
	}
	
	public List<Paciente> getPacientes()
	{
		return pg.recuperarTodosPorNome();
	}
	
	public List<Paciente> getPacientesContendo()
	{
		return pg.recuperarTodosPorNomeContendo(termo);
	}
	
	public List<Anamnese> getAnamnesesRecentes()
	{
		return ag.recuperarMaisRecentesPorPaciente(paciente);
	}
	
	public PacienteGerente getGerente()
	{
		return pg;
	}
	
	public AnamneseGerente getGerenteAnamnese()
	{
		return ag;
	}
	
	//====================// Rotas //====================//
	//Nova anamnese
	public void novaAnamnese()
	{
		anamnese = new Anamnese(Calendar.getInstance().getTime(), paciente, molde);
		for(Pergunta p : molde.getPerguntas())
		{
			Resposta r = new Resposta("", p, paciente, anamnese);
			anamnese.adicionarResposta(r);
		}
		paciente.adicionarAnamnese(anamnese);
		
		molde = new Molde();
	}
	
	//Excluir anamnese
	public void excluirAnamnese()
	{
		paciente.removerAnamnese(anamnese);
		anamnese = null;
	}
	
	//Inserção de novo paciente
	public String adicionar()  
	{
		this.paciente = new Paciente();
		this.anamnese = null;
		return "adicionarPaciente";
	}
	
	//Salvando nova consulta
	public String salvarInclusao()
	{
		pg.adicionar(paciente);
		return "pacientes";
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
		
		List<Anamnese> anamneses = paciente.getAnamneses();
		this.anamnese = anamneses.size() > 0 ? anamneses.get(0) : null;
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
