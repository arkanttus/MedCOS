package br.ufac.si.medcos.testes;

import java.util.Calendar;
import java.util.Date;

import br.ufac.si.medcos.gerentes.ConsultaGerente;
import br.ufac.si.medcos.gerentes.Gerente;
import br.ufac.si.medcos.entidades.*;

public class TesteAgendarConsulta 
{
	public TesteAgendarConsulta(Gerente g, Date date)
	{
		ConsultaGerente cg = new ConsultaGerente();
		
		Funcionario f1 = (Funcionario) g.recuperar(Funcionario.class, 1);
		Funcionario f2 = (Funcionario) g.recuperar(Funcionario.class, 2);
		Paciente p = (Paciente) g.recuperar(Paciente.class, 1);
		Medico med1 = (Medico) g.recuperar(Medico.class, 3);
		Medico med2 = (Medico) g.recuperar(Medico.class, 4);
		
		
		//Consultas
		System.out.println("\n=> Criando consultas...");

		Consulta c1 = new Consulta("Dor na cabeça e na perna", date, "", "Pendente", p, med1);
		c1.adicionarResponsavel(f1);
		g.adicionar(c1);
		
		Consulta c2 = new Consulta("Dor no estômago", date, "Paciente em estado severo, requer urgência", "Pendente", p, med2);
		c2.adicionarResponsavel(f2);
		g.adicionar(c2);
		
		System.out.println("\n\nConsultas:");
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
		new TesteAgendarConsulta(new Gerente(), Calendar.getInstance().getTime());
	}
}
