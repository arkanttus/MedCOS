package br.ufac.si.medcos.testes;

import br.ufac.si.medcos.gerentes.*;
import br.ufac.si.medcos.entidades.*;
import java.util.*;

public class EnderecoTeste
{
    public static void main(String[] args)
    {
	EnderecoGerente eg = new EnderecoGerente();
	Endereco e1 = new Endereco();
	e1.setBairro("Morada do Sol");
	e1.setCidade("Rio Branco");
	e1.setEstado("Acre");
	e1.setCep("69901-127");
	e1.setLogradouro("Rua Marte");
	e1.setNumero(434);
	
	eg.adicionar(e1);
	
	ArrayList<Endereco> ends = (ArrayList<Endereco>) eg.recuperarTodos();
	for (Endereco end : ends)
	{
	    System.out.println(end); // EXIGIU REESCRITA DO toString
	}

	eg.encerrar();
    }
}