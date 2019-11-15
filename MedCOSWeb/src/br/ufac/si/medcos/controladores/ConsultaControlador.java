package br.ufac.si.medcos.controladores;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import br.ufac.si.medcos.gerentes.*;
import br.ufac.si.medcos.entidades.*;

@ManagedBean(name="consultaControlador")
@SessionScoped
public class ConsultaControlador
{
	private ConsultaGerente cg;
	private Consulta consulta;
	private String termo;
	
	public ConsultaControlador()
	{
		cg = new ConsultaGerente();
		termo = "";
	}
	
	public Consulta getConsulta()
	{
		return consulta;
	}
	public void setConsulta(Consulta consulta)
	{
		this.consulta = consulta;
	}

	public String getTermo()
	{
		return termo;
	}

	public void setTermo(String termo)
	{
		this.termo = termo;
	}

	public List<Consulta> getConsultasProximas()
	{
		return cg.recuperarTodosProximas();
	}
	
	public List<Consulta> getConsultas()
	{
		return cg.recuperarTodosPorDataHora();
	}
	
	public List<Consulta> getConsultasContendo()
	{
		return cg.recuperarTodosPorPacienteContendo(termo);
	}
	
	public long getConsultasPendentes()
	{
		return cg.contarPendentes();
	}
	
	public long getConsultasAtendidas()
	{
		return cg.contarAtendidas();
	}
	
	public long getMedicosAtendendo()
	{
		return cg.contarMedicosAtendendo();
	}
	
	//====================// Rotas //====================//
	
	//Inserção de nova consulta
	public String adicionar()  
	{
		this.consulta = new Consulta();
		return "adicionarConsulta";
	}
	
	//Salvando nova consulta
	public String salvarInclusao()
	{
		Calendar cal = Calendar.getInstance();
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
		}
	}
	
	//Edição de consulta
	public String editar(Consulta consulta)
	{
		this.consulta = consulta;
		return "editarConsulta";
	}
	
	//Salvando consulta editada
	public String salvarEdicao()
	{
		Calendar cal = Calendar.getInstance();
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
		}
	}
	
	//Salvando consulta cancelada
	public void cancelar(Consulta consulta)
	{
		consulta.setStatus("Cancelada");
		cg.atualizar(consulta);
	}
}
