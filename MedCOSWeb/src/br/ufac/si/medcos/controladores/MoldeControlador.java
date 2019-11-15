package br.ufac.si.medcos.controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import br.ufac.si.medcos.gerentes.*;
import br.ufac.si.medcos.entidades.*;

@ManagedBean(name="moldeControlador")
@SessionScoped
public class MoldeControlador
{
	private MoldeGerente mg;
	private Molde molde;
	private String termo;
	
	public MoldeControlador()
	{
		mg = new MoldeGerente();
	}
	
	public Molde getMolde()
	{
		return molde;
	}

	public void setMolde(Molde molde)
	{
		this.molde = molde;
	}

	public String getTermo()
	{
		return termo;
	}

	public void setTermo(String termo)
	{
		this.termo = termo;
	}
	
	public List<Molde> getMoldes()
	{
		return mg.recuperarTodosPorCriacao();
	}
	
	public List<Molde> getMoldesContendo()
	{
		return mg.recuperarTodosPorDescricaoContendo(termo);
	}
	
	public MoldeGerente getGerente()
	{
		return mg;
	}
	
	public void adicionarPergunta()
	{
		Pergunta p = new Pergunta("", 1);
		molde.adicionarPergunta(p);
	}
	
	public void removerPergunta(Pergunta p)
	{
		molde.removerPergunta(p);
	}
	
	private void filtrarPerguntas()
	{
		ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
		for(Pergunta p : molde.getPerguntas())
			if(!p.getDescricao().isEmpty())
				perguntas.add(p);
				
		molde.setPerguntas(perguntas);
	}
	
	//====================// Rotas //====================//
	
	//Inserção de novo molde
	public String adicionar()  
	{
		this.molde = new Molde();
		this.molde.adicionarPergunta(new Pergunta("", 1));
		return "adicionarMolde";
	}
	
	//Salvando novo molde
	public String salvarInclusao()
	{
		if(molde.getDescricao().length() < 4 || molde.getDescricao().length() > 20)
		{
			FacesContext.getCurrentInstance().addMessage("formMolde:descricao", new FacesMessage("A descrição pode ter no mínimo 4 e no máximo 30 caracteres."));
			return null;
		}
		
		filtrarPerguntas();
		Calendar cal = Calendar.getInstance();
		molde.setCriacao(cal.getTime());
		mg.adicionar(molde);
		return "moldes";
	}
	
	//Edição de molde
	public String editar(Molde molde)
	{
		this.molde = molde;
		return "editarMolde";
	}
	
	//Salvando molde editado
	public String salvarEdicao()
	{
		if(molde.getDescricao().length() < 4 || molde.getDescricao().length() > 20)
		{
			FacesContext.getCurrentInstance().addMessage("formMolde:descricao", new FacesMessage("A descrição pode ter no mínimo 4 e no máximo 30 caracteres."));
			return null;
		}
		
		filtrarPerguntas();
		mg.atualizar(molde);
		return "moldes";
	}
	
	//Exclusão de molde
	public String excluir(Molde molde)
	{
		this.molde = molde;
		return "editarMolde";
	}
	
	//Excluir molde
	public String realizarExclusao(Molde molde)
	{
		mg.remover(molde);
		return "moldes";
	}
}
