package br.ufac.si.medcos.testes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import br.ufac.si.medcos.gerentes.Gerente;
import br.ufac.si.medcos.gerentes.PacienteGerente;
import br.ufac.si.medcos.entidades.*;

public class TestePacientes 
{
	public TestePacientes(Gerente g, Date date)
	{
		PacienteGerente pg = new PacienteGerente();
		
		//Pacientes
		System.out.println("\n=> Criando pacientes...");
		
		Paciente p = new Paciente("Paciente de Souza", "123432123-22", date, "Solteiro", "999973421", "psouza@gmail.com", "Pedreiro", "", new Endereco("Rua da Plata", "Bairreiro", "Rio Branco", "Acre", "69901422", 433), new ArrayList<Consulta>(), new ArrayList<Anamnese>());
		g.adicionar(p);
		
		pg.encerrar();
	}
	
	public static void main(String[] args) 
	{
		new TestePacientes(new Gerente(), Calendar.getInstance().getTime());
	}
}
