package br.ufac.si.medcos.testes;

import java.util.Calendar;
import java.util.Date;
import br.ufac.si.medcos.entidades.*;
import br.ufac.si.medcos.gerentes.Gerente;
import br.ufac.si.medcos.gerentes.MoldeGerente;

public class TesteMoldes 
{
	public TesteMoldes(Gerente g, Date date)
	{
		MoldeGerente mg = new MoldeGerente();
		
		Funcionario f1 = (Funcionario) g.recuperar(Funcionario.class, 1);
		Funcionario f2 = (Funcionario) g.recuperar(Funcionario.class, 2);
		
		//Moldes de anamneses
		System.out.println("\n=> Criando moldes...");

		Molde m1 = new Molde("Molde A", date);
		m1.adicionarPergunta(new Pergunta("Você gosta de bacon?", 1));
		m1.adicionarPergunta(new Pergunta("Você gosta de pizza?", 1));
		m1.adicionarPergunta(new Pergunta("Você tem alergia a carne de porco?", 1));
		m1.adicionarPergunta(new Pergunta("Quando foi a última vez que comeu porco?", 2));
		m1.adicionarResponsavel(f1);
		g.adicionar(m1);
		
		Molde m2 = new Molde("Molde B", date);
		m2.adicionarPergunta(new Pergunta("Você tem hipertensão?", 1));
		m2.adicionarPergunta(new Pergunta("Você tem diabetes?", 1));
		m2.adicionarResponsavel(f2);
		g.adicionar(m2);
		
		System.out.println("\n\nMoldes:");
		for(Molde m : mg.recuperarTodos())
		{
			System.out.println(m);
			for(Pergunta per : m.getPerguntas())
				System.out.println(per);
			System.out.println();
		}
		
		mg.encerrar();
	}
	
	public static void main(String[] args) 
	{
		new TesteMoldes(new Gerente(), Calendar.getInstance().getTime());
	}
}
