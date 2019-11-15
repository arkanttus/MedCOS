package br.ufac.si.medcos.controladores;

import java.util.List;

import javax.faces.bean.*;

import br.ufac.si.medcos.gerentes.*;
import br.ufac.si.medcos.entidades.*;

@ManagedBean(name="funcionarioControlador")
@SessionScoped
public class FuncionarioControlador
{
	private FuncionarioGerente fg;
	private Funcionario funcionario;
	private String termo;
	
	public FuncionarioControlador()
	{
		fg = new FuncionarioGerente();
	}
	
	public Funcionario getFuncionario()
	{
		return funcionario;
	}

	public String getTermo()
	{
		return termo;
	}

	public void setTermo(String termo)
	{
		this.termo = termo;
	}
	
	public void setFuncionario(Funcionario funcionario)
	{
		this.funcionario = funcionario;
	}
	
	public List<Funcionario> getFuncionarios()
	{
		return fg.recuperarTodosPorNome();
	}
	
	public List<Funcionario> getFuncionariosContendo()
	{
		return fg.recuperarTodosPorNomeContendo(termo);
	}
	
	//====================// Rotas //====================//
	
	//Inserção de novo funcionario
	public String adicionar()  
	{
		this.funcionario = new Funcionario();
		return "adicionarFuncionario";
	}
	
	//Salvando nova consulta
	public String salvarInclusao()
	{
		fg.adicionar(funcionario);
		return "index";
		/*Calendar cal = Calendar.getInstance();
		Date agora = cal.getTime();
		
		if(consulta.getDataHora().compareTo(agora) > 0)
		{
			consulta.setObs("");
			consulta.setSintomas("");
			consulta.setStatus("Pendente");
			cg.adicionar(consulta);
			return "index";
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage("formConsulta:dataHora", new FacesMessage("A data e horário não podem ser antes de agora."));
			return null;
		}*/
	}
	
	//Edição de funcionario
	public String editar(Funcionario funcionario)
	{
		this.funcionario = funcionario;
		return "editarFuncionario";
	}
	
	//Salvando funcionario editado
	public String salvarEdicao()
	{
		fg.atualizar(funcionario);
		return "funcionarios";
		/*Calendar cal = Calendar.getInstance();
		Date agora = cal.getTime();
		
		if(consulta.getDataHora().compareTo(agora) > 0)
		{
			cg.atualizar(consulta);
			return "index";
		}
		else
		{
			FacesContext.getCurrentInstance().addMessage("formConsulta:dataHora", new FacesMessage("A data e horário não podem ser antes de agora."));
			return null;
		}*/
	}
	
	//Excluir funcionario
	public void excluir(Funcionario funcionario)
	{
		fg.remover(funcionario);
	}
}
