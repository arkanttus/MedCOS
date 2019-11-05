package br.ufac.si.medcos.testes;

import br.ufac.si.academico.gerentes.*;
import br.ufac.si.academico.entidades.*;
import java.util.*;

public class AlunoTeste {

	public static void main(String[] args) {
		AlunoGerente ag = new AlunoGerente();
		CursoGerente cg = new CursoGerente();
		Aluno a1, a2, a3, a4, a5;
		Curso c1, c2, c3, c4;
		List<Aluno> alunos;
		
		c1 = cg.recuperar(1);
		c2 = cg.recuperar(2);
		c3 = cg.recuperar(3);
		c4 = cg.recuperar(30);
		
		a1 = new Aluno(123, "Migael", "Rua A", "", "123", "M", c1);
		a2 = new Aluno(124, "Sabyo", "Rua B", "", "321", "M", c2);
		a3 = new Aluno(125, "Caguin", "Rua C", "", "3212", "M", c3);
		a4 = new Aluno(171, "Maria", "Rua M", "", "456", "M", c4);
		a5 = new Aluno(126, "Ruberto", "Rua E", "", "632", "M", c4);
		
		ag.adicionar(a1);
		ag.adicionar(a2);
		ag.adicionar(a3);
		ag.adicionar(a4);
		ag.adicionar(a5);
				
				
		alunos = ag.recuperarTodos();	
		System.out.println("Listando alunos...");
		for (Aluno aluno : alunos) 
		{
			System.out.println(aluno); // EXIGIU REESCRITA DO toString
		}
		
		alunos = ag.recuperarTodosPorNome();	
		System.out.println("Listando alunos, por nome...");
		for (Aluno aluno : alunos) 
		{
			System.out.println(aluno);
		}
		
		alunos = ag.recuperarTodosPorNomeContendo("r");	
		System.out.println("Listando alunos, por nome, contendo 'r'...");
		for (Aluno aluno : alunos) 
		{
			System.out.println(aluno);
		}	
		
		cg.encerrar();
	}
}