package br.ufac.si.medcos.gerentes;

import java.util.List;

import br.ufac.si.medcos.entidades.Molde;

public class MoldeGerente extends Gerente
{
	@SuppressWarnings("unchecked")
	public List<Molde> recuperarTodos()
	{
		return em.createNamedQuery("Molde.todos").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Molde> recuperarTodosPorCriacao()
	{
		return em.createNamedQuery("Molde.todosPorCriacao").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Molde> recuperarTodosPorDescricao()
	{
		return em.createNamedQuery("Molde.todosPorDescricao").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Molde> recuperarTodosPorDescricaoContendo(String termo)
	{
		return em.createNamedQuery("Molde.todosPorDescricaoContendo").setParameter("termo", "%"+termo+"%").getResultList();
	}
	
	public Molde recuperarMaisRecente()
	{
		return (Molde) em.createNamedQuery("Molde.maisRecente").getSingleResult();
	}
}