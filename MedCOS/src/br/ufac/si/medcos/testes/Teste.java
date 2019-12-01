package br.ufac.si.medcos.testes;

import java.util.Calendar;
import java.util.Date;

import br.ufac.si.medcos.gerentes.Gerente;

public class Teste
{
	public static void main(String[] args)
	{
		Date date = Calendar.getInstance().getTime();
		Gerente g = new Gerente();

		new TesteUsuarios(g, date);
		new TesteMoldes(g, date);
		new TestePacientes(g, date);
		new TesteAnamneses(g, date);
		new TesteAgendarConsulta(g, date);
		new TesteGerenciarConsulta(g, date);
		
		g.encerrar();
	}

}
