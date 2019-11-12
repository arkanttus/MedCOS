package br.ufac.si.medcos.testes;

import br.ufac.si.medcos.gerentes.*;
import br.ufac.si.medcos.entidades.*;
import java.util.*;

public class EnderecoTeste
{
	public static void main(String[] args)
	{
		Gerente g = new Gerente();
		Endereco e = new Endereco();
		e.setBairro("Morada do Sol");
		e.setCidade("Rio Branco");
		e.setEstado("Acre");
		e.setLogradouro("434");
		e.setNumero(434);
		e.setCep("123123");
		g.adicionar(e);

		Funcionario f = new Funcionario();
		f.setNome("Macilon");
		f.setCpf("1231231");
		f.setDataNascimento(new Date(2000, 5, 3));
		f.setPermissao(1);
		f.setAtivo(true);
		f.setEndereco(e);
		g.adicionar(f);

		Pergunta perg1 = new Pergunta("Você tem diabetes?", 1);
		Pergunta perg2 = new Pergunta("Você tem hipertensão?", 2);

		Molde mol = new Molde("Molde A", new Date(2019, 05, 03));
		mol.adicionarPergunta(perg1);
		mol.adicionarPergunta(perg2);
		g.adicionar(mol);

		Paciente p = new Paciente();
		p.setNome("Bruno");
		p.setCpf("123123");
		p.setDataNascimento(new Date(2000, 05, 03));
		p.setEstadoCivil("Solteiro");
		p.setFone("53434");
		p.setEmail("asdas@gmail.com");
		p.setProfissao("pedreiro");
		p.setObs("  ");
		p.setEndereco(e);
		g.adicionar(p);

		Anamnese ana = new Anamnese(new Date(2019, 05, 03), p, mol);
		ana.adicionarResponsavel(f);

		Resposta r1 = new Resposta("Não", perg1, p, ana);
		Resposta r2 = new Resposta("Sim", perg2, p, ana);
		ana.adicionarResposta(r1);
		ana.adicionarResposta(r2);
		g.adicionar(ana);

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 10);
		cal.set(Calendar.YEAR, 2000);
		Medico m = new Medico("Roberto", "4444", cal.getTime(), true, "13632-2", "");
		g.adicionar(m);

		g.encerrar();
	}
}