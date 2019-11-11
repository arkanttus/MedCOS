package br.ufac.si.medcos.gerentes;

import java.util.List;

import br.ufac.si.medcos.entidades.Consulta;

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
	public List<Consulta> recuperarTodosProximas()
	{
		return em.createNamedQuery("Consulta.todosProximas").getResultList();
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
}