package br.ufac.si.medcos.testes;

import java.util.Calendar;
import java.util.Date;

import br.ufac.si.medcos.gerentes.ConsultaGerente;
import br.ufac.si.medcos.gerentes.Gerente;
import br.ufac.si.medcos.entidades.*;

public class TesteGerenciarConsulta 
{
	public TesteGerenciarConsulta(Gerente g, Date date)
	{
		ConsultaGerente cg = new ConsultaGerente();
		
		Funcionario f2 = (Funcionario) g.recuperar(Funcionario.class, 2);
		Consulta c1 = (Consulta) g.recuperar(Consulta.class, 1);
		Consulta c2 = (Consulta) g.recuperar(Consulta.class, 2);
		
		//Atendendo uma consulta
		System.out.println("\n=> Atendendo a consulta...");
		
		c2.setStatus("Atendida");
		c2.adicionarProcedimento("Endoscopia", "Solicitado endoscopia com o uso de anestésicos", "Exame");
		c2.adicionarProcedimento("Dipirona", "Uso de dipirona 3 vezes por dia, até que a dor suma.", "Medicamento");
		g.atualizar(c2);
		
		//Cancelando a consulta 
		System.out.println("\n=> Cancelando a consulta...");
		
		c1.setStatus("Cancelada");
		c1.adicionarResponsavel(f2);
		g.atualizar(c1);
		
		System.out.println("\n\nConsultas pós-modificação:");
		for(Consulta c : cg.recuperarTodos())
		{
			System.out.println(c);
			for(Procedimento proc : c.getProcedimentos())
				System.out.println(proc);
			System.out.println();
		}
		
		cg.encerrar();
	}
	
	public static void main(String[] args) 
	{
		new TesteGerenciarConsulta(new Gerente(), Calendar.getInstance().getTime());
	}
}
