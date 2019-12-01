package br.ufac.si.medcos.gerentes;

import java.util.List;

import br.ufac.si.medcos.entidades.Anamnese;
import br.ufac.si.medcos.entidades.Consulta;
import br.ufac.si.medcos.entidades.Medico;

public class ConsultaGerente extends Gerente
{
	@SuppressWarnings("unchecked")
	public List<Consulta> recuperarTodos()
	{
		return em.createNamedQuery("Consulta.todos").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Consulta> recuperarTodosPorDataHora()
	{
		return em.createNamedQuery("Consulta.todosPorDataHora").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Consulta> recuperarTodosPorPacienteContendo(String termo)
	{
		return em.createNamedQuery("Consulta.todosPorPacienteContendo").setParameter("termo", "%"+termo+"%").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Consulta> recuperarTodosProximas()
	{
		return em.createNamedQuery("Consulta.todosProximas").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Consulta> recuperarTodosProximasDoMedico(Medico m)
	{
		return em.createNamedQuery("Consulta.todosProximasDoMedico").setParameter("id", m).getResultList();
	}
	
	public long contarAtendidas()
	{
		return (Long) em.createNamedQuery("Consulta.contarAtendidas").getSingleResult();
	}
	
	public long contarPendentes()
	{
		return (Long) em.createNamedQuery("Consulta.contarPendentes").getSingleResult();
	}
	
	public long contarMedicosAtendendo()
	{
		return (Long) em.createNamedQuery("Consulta.contarMedicosAtendendo").getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Consulta> recuperarMaisRecentesPorMedico(Medico m, String termo)
	{
		return em.createNamedQuery("Consulta.maisRecentesPorMedicoContendo").setParameter("id", m).setParameter("termo", "%"+termo+"%").getResultList();
	}
}