package br.ufac.si.medcos.controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import br.ufac.si.medcos.gerentes.*;
import br.ufac.si.medcos.sessao.SessionContext;
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
	
	public void adicionarProcedimento()
	{
		consulta.adicionarProcedimento("", "", "");
	}
	
	public void removerProcedimento(Procedimento p)
	{
		consulta.removerProcedimento(p);
	}

	public List<Consulta> getConsultasProximas()
	{
		Usuario usuario = SessionContext.getInstance().getUsuarioLogado();
		try
		{
			Funcionario f = (Funcionario)usuario;
			return cg.recuperarTodosProximas();
		}
		catch(ClassCastException cce)
		{
			Medico m = (Medico) usuario;
			return cg.recuperarTodosProximasDoMedico(m);
		}
	}
	
	public List<Consulta> getConsultas()
	{
		return cg.recuperarTodosPorDataHora();
	}
	
	public List<Consulta> getConsultasContendo()
	{
		Usuario usuario = SessionContext.getInstance().getUsuarioLogado();
		try
		{
			Funcionario f = (Funcionario)usuario;
			return cg.recuperarTodosPorPacienteContendo(termo);
		}
		catch(ClassCastException cce)
		{
			Medico m = (Medico) usuario;
			return cg.recuperarMaisRecentesPorMedico(m, termo);
		}
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
	
	private void filtrarProcedimentos()
	{
		ArrayList<Procedimento> procedimentos = new ArrayList<Procedimento>();
		for(Procedimento p : consulta.getProcedimentos())
			if(!p.getDescricao().isEmpty())
				procedimentos.add(p);
				
		consulta.setProcedimentos(procedimentos);
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
			consulta.adicionarResponsavel((Funcionario) SessionContext.getInstance().getUsuarioLogado());
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
			filtrarProcedimentos();
			consulta.adicionarResponsavel((Funcionario) SessionContext.getInstance().getUsuarioLogado());
			cg.atualizar(consulta);
			return "index";
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage("formConsulta:dataHora", new FacesMessage("A data e horário não podem ser antes de agora."));
			return null;
		}
	}
	
	//Atendimentp de consulta
	public String atender(Consulta consulta)
	{
		this.consulta = consulta;
		return "atenderConsulta";
	}
	
	//Salvando consulta atendimento
	public String salvarAtendimento()
	{
		consulta.setStatus("Atendida");
		filtrarProcedimentos();
		cg.atualizar(consulta);
		return "consultas";
	}
	
	//Salvando consulta cancelada
	public void cancelar(Consulta consulta)
	{
		consulta.setStatus("Cancelada");
		cg.atualizar(consulta);
	}
}
