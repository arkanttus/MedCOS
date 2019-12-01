package br.ufac.si.medcos.testes;

import java.util.Calendar;
import java.util.Date;

import br.ufac.si.medcos.gerentes.AnamneseGerente;
import br.ufac.si.medcos.gerentes.Gerente;
import br.ufac.si.medcos.entidades.*;

public class TesteAnamneses 
{
	public TesteAnamneses(Gerente g, Date date)
	{
		AnamneseGerente ag = new AnamneseGerente();
		
		Paciente p = (Paciente) g.recuperar(Paciente.class, 1);
		Molde m1 = (Molde) g.recuperar(Molde.class, 1);
		Molde m2 = (Molde) g.recuperar(Molde.class, 2);
		Funcionario f1 = (Funcionario) g.recuperar(Funcionario.class, 1);
		Funcionario f2 = (Funcionario) g.recuperar(Funcionario.class, 2);
		
		//Anamneses
		System.out.println("\n=> Criando anamneses...");
		
		Anamnese ap1 = new Anamnese(date, p, m1);
		ap1.adicionarResposta(new Resposta("Sim", m1.getPerguntas().get(0), p, ap1));
		ap1.adicionarResposta(new Resposta("Sim", m1.getPerguntas().get(1), p, ap1));
		ap1.adicionarResposta(new Resposta("Não", m1.getPerguntas().get(2), p, ap1));
		ap1.adicionarResposta(new Resposta("Há duas semanas", m1.getPerguntas().get(3), p, ap1));
		
		ap1.adicionarResponsavel(f1);
		g.adicionar(ap1);
		
		Anamnese ap2 = new Anamnese(date, p, m2);
		ap2.adicionarResposta(new Resposta("Não", m2.getPerguntas().get(0), p, ap2));
		ap2.adicionarResposta(new Resposta("Não", m2.getPerguntas().get(1), p, ap2));
		
		ap2.adicionarResponsavel(f2);
		g.adicionar(ap2);
		
		System.out.println("\n\nAnamneses:");
		for(Anamnese a : ag.recuperarTodos())
		{
			System.out.println(a);
			for(Resposta r : a.getRespostas())
				System.out.println(r);
			System.out.println();
		}
		
		ag.encerrar();
	}
	
	public static void main(String[] args) 
	{
		new TesteAnamneses(new Gerente(), Calendar.getInstance().getTime());
	}
}
