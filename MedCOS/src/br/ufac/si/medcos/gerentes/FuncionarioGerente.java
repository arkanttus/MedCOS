package br.ufac.si.medcos.gerentes;

import java.util.List;

import br.ufac.si.medcos.entidades.Funcionario;

public class FuncionarioGerente extends Gerente
{
	@SuppressWarnings("unchecked")
	public List<Funcionario> recuperarTodos()
	{
		return em.createNamedQuery("Funcionario.todos").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> recuperarTodosPorNome()
	{
		return em.createNamedQuery("Funcionario.todosPorNome").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Funcionario> recuperarTodosPorNomeContendo(String termo)
	{
		return em.createNamedQuery("Funcionario.todosPorNomeContendo").setParameter("termo", "%"+termo+"%").getResultList();
	}
}