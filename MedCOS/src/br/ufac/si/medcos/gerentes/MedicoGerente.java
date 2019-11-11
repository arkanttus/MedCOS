package br.ufac.si.medcos.gerentes;

import java.util.List;

import br.ufac.si.medcos.entidades.Medico;

public class MedicoGerente extends Gerente
{
	@SuppressWarnings("unchecked")
	public List<Medico> recuperarTodos()
	{
		return em.createNamedQuery("Medico.todos").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Medico> recuperarTodosPorNome()
	{
		return em.createNamedQuery("Medico.todosPorNome").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Medico> recuperarTodosPorNomeContendo(String termo)
	{
		return em.createNamedQuery("Medico.todosPorNomeContendo").setParameter("termo", "%"+termo+"%").getResultList();
	}
}