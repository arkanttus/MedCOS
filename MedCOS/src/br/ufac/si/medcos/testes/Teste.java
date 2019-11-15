package br.ufac.si.medcos.testes;

import br.ufac.si.medcos.entidades.Consulta;
import br.ufac.si.medcos.gerentes.ConsultaGerente;
import br.ufac.si.medcos.gerentes.Gerente;

public class Teste
{

	public static void main(String[] args)
	{
		ConsultaGerente g = new ConsultaGerente();
		
		for(Consulta c : g.recuperarTodosPorPacienteContendo("Bruno"))
		{
			System.out.println("ID " + c.getId());
		}
		g.encerrar();
	}

}
