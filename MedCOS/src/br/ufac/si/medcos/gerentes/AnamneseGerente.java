package br.ufac.si.medcos.gerentes;

import java.util.List;

import br.ufac.si.medcos.entidades.Anamnese;
import br.ufac.si.medcos.entidades.Paciente;

public class AnamneseGerente extends Gerente
{
	@SuppressWarnings("unchecked")
	public List<Anamnese> recuperarTodos()
	{
		return em.createNamedQuery("Anamnese.todos").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Anamnese> recuperarTodosPorData()
	{
		return em.createNamedQuery("Anamnese.todosPorData").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Anamnese> recuperarMaisRecentesPorPaciente(Paciente p)
	{
		return em.createNamedQuery("Anamnese.maisRecentesPorPaciente").setParameter("id", p.getId()).getResultList();
	}
}