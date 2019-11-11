package br.ufac.si.medcos.controladores;

import java.util.List;
import javax.faces.bean.*;
import br.ufac.si.medcos.gerentes.*;
import br.ufac.si.medcos.entidades.*;

@ManagedBean(name="consultaControlador")
@SessionScoped
public class ConsultaControlador
{
	private ConsultaGerente cg;
	private PacienteGerente pg;
	private MedicoGerente mg;
	private Consulta consulta;
	
	public ConsultaControlador()
	{
		cg = new ConsultaGerente();
		pg = new PacienteGerente();
		mg = new MedicoGerente();
	}
	
	public Consulta getConsulta()
	{
		return consulta;
	}
	public void setConsulta(Consulta consulta)
	{
		this.consulta = consulta;
	}
	
	public List<Consulta> getConsultasProximas()
	{
		return cg.recuperarTodosProximas();
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
	
	public String adicionar()
	{
		this.consulta = new Consulta();
		return "adicionarConsulta";
	}
	
	public String salvarInclusao()
	{
		consulta.setObs("");
		consulta.setSintomas("");
		consulta.setStatus("Pendente");
		cg.adicionar(consulta);
		return "index";
	}
	
	public String editar(Consulta consulta)
	{
		this.consulta = consulta;
		return "editarConsulta";
	}
	
	public String cancelar(Consulta consulta)
	{
		this.consulta = consulta;
		return "cancelarConsulta";
	}
	
	public List<Paciente> getPacientes()
	{
		return pg.recuperarTodosPorNome();
	}
	
	public List<Medico> getMedicos()
	{
		return mg.recuperarTodosPorNome();
	}
}
