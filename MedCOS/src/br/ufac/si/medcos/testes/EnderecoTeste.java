package br.ufac.si.medcos.testes;

import br.ufac.si.medcos.gerentes.*;
import br.ufac.si.medcos.entidades.*;
import java.util.*;

public class EnderecoTeste
{
    public static void main(String[] args)
    {
	Gerente g = new Gerente();
	Paciente p = new Paciente();
	p.setNome("Bruno");
	p.setCpf("123123");
	p.setDataNascimento(new Date("2000-05-03"));
	p.setEstadoCivil("SOlteiro");
	p.setFone("53434");
	p.setEmail("asdas@gmail.com");
	p.setProfissao("pedreiro");
	p.setObs("  ");
	
	g.adicionar(p);
	g.encerrar();
    }
}