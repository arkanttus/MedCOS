package br.ufac.si.medcos.testes;

import java.util.Calendar;

import br.ufac.si.medcos.entidades.Funcionario;
import br.ufac.si.medcos.entidades.Medico;
import br.ufac.si.medcos.gerentes.Gerente;
import br.ufac.si.medcos.gerentes.MedicoGerente;
import br.ufac.si.medcos.utils.Funcoes;

public class Teste
{

	public static void main(String[] args)
	{
		Gerente g = new Gerente();
		Funcionario f = new Funcionario("Funcionario da Silva", "0", Funcoes.md5("123"), Calendar.getInstance().getTime(), "", "Ativo", 1);
		
		g.adicionar(f);
		g.encerrar();
	}

}
