package br.ufac.si.medcos.testes;

import br.ufac.si.medcos.entidades.Consulta;
import br.ufac.si.medcos.gerentes.ConsultaGerente;

public class Teste
{

	public static void main(String[] args)
	{
		ConsultaGerente g = new ConsultaGerente();
		for(Consulta c : g.recuperarTodosProximas())
		{
			System.out.println(c.getDataHora());
		}
		
		g.encerrar();
	}

}
