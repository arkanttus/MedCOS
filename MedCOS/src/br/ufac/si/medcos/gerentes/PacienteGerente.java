package br.ufac.si.medcos.gerentes;

import java.util.List;

import br.ufac.si.medcos.entidades.Paciente;

public class PacienteGerente extends Gerente
{
	@SuppressWarnings("unchecked")
	public List<Paciente> recuperarTodos()
	{
		return em.createNamedQuery("Paciente.todos").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Paciente> recuperarTodosPorNome()
	{
		return em.createNamedQuery("Paciente.todosPorNome").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Paciente> recuperarTodosPorNomeContendo(String termo)
	{
		return em.createNamedQuery("Paciente.todosPorNomeContendo").setParameter("termo", "%"+termo+"%").getResultList();
	}
}