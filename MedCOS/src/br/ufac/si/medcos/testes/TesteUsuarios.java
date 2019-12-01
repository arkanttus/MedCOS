package br.ufac.si.medcos.testes;

import java.util.Calendar;
import java.util.Date;

import br.ufac.si.medcos.entidades.Funcionario;
import br.ufac.si.medcos.entidades.Medico;
import br.ufac.si.medcos.gerentes.FuncionarioGerente;
import br.ufac.si.medcos.gerentes.Gerente;
import br.ufac.si.medcos.gerentes.MedicoGerente;
import br.ufac.si.medcos.utils.Funcoes;

public class TesteUsuarios 
{
	public TesteUsuarios(Gerente g, Date date)
	{
		FuncionarioGerente fg = new FuncionarioGerente();
		MedicoGerente mg = new MedicoGerente();
		
		//Funcionários
		System.out.println("\n=> Criando funcionários...");
		
		Funcionario f1 = new Funcionario("Funcionario da Silva", "12345678900", Funcoes.md5("123"), date, "", "Ativo", 1);
		Funcionario f2 = new Funcionario("Funcionario da Costa", "12345667811", Funcoes.md5("123"), date, "", "Ativo", 2);
		g.adicionar(f1);
		g.adicionar(f2);
		
		System.out.println("\n\nFuncionários:");
		for(Funcionario f : fg.recuperarTodos())
			System.out.println(f);
		
		//Médicos
		System.out.println("\n=> Criando médicos...");
		
		Medico med1 = new Medico("Medico de Oliveira", "12345678922", Funcoes.md5("123"), date, "Ativo", "143-0 AC", "Neurologista");
		Medico med2 = new Medico("Medico de Araújo", "65621242211", Funcoes.md5("123"), date, "Ativo", "122-0 AC", "Gastroenterologista");
		g.adicionar(med1);
		g.adicionar(med2);
		
		System.out.println("\n\nMédicos:");
		for(Medico m : mg.recuperarTodos())
			System.out.println(m);
	
		fg.encerrar();
		mg.encerrar();
	}
	
	public static void main(String args[])
	{
		new TesteUsuarios(new Gerente(), Calendar.getInstance().getTime());
	}
}
