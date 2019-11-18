package br.ufac.si.medcos.controladores;

import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import br.ufac.si.medcos.gerentes.*;
import br.ufac.si.medcos.sessao.SessionContext;
import br.ufac.si.medcos.utils.Funcoes;
import br.ufac.si.medcos.entidades.*;

@ManagedBean(name="usuarioControlador")
@SessionScoped
public class UsuarioControlador
{
	private Gerente g;
	private Usuario usuario;
	private String senhaAtual, senhaNova, senhaConfirmada;
	
	public UsuarioControlador()
	{
		g = new Gerente();
		usuario = new Funcionario();
	}

	public Usuario getUsuario()
	{
		return usuario;
	}

	public void setUsuario(Usuario usuario)
	{
		this.usuario = usuario;
	}
	
	public String getSenhaAtual()
	{
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual)
	{
		this.senhaAtual = senhaAtual;
	}
	
	public String getSenhaNova()
	{
		return senhaNova;
	}

	public void setSenhaNova(String senhaNova)
	{
		this.senhaNova = senhaNova;
	}

	public String getSenhaConfirmada()
	{
		return senhaConfirmada;
	}

	public void setSenhaConfirmada(String senhaConfirmada)
	{
		this.senhaConfirmada = senhaConfirmada;
	}
	
	//====================// Rotas //====================//
	
	public String login()
	{
		Usuario user = g.recuperarUsuarioPorCredencial(usuario.getCpf(), usuario.getSenha());
		
		if(user == null)
		{
			FacesContext.getCurrentInstance().addMessage("formLogin:aviso", new FacesMessage("CPF ou senha incorreto(s)!"));
			return "";
		}

		this.usuario = user;
		SessionContext.getInstance().setAttribute("usuarioLogado", user);
		System.out.println("LOGOU CERTIN");
		return "/index.xhtml";
	}

	public String logout()
	{
		SessionContext.getInstance().encerrarSessao();
		return "/login.xhtml";
	}
	
	//Alteração de senha
	public void alterarSenha()
	{
		String senhaMD5 = Funcoes.md5(senhaAtual);
		boolean valido = true;
		if(!senhaMD5.equals(usuario.getSenha()))
		{
			FacesContext.getCurrentInstance().addMessage("formSenha:senhaAtual", new FacesMessage("Senha atual incorreta!"));
			valido = false;
		}
		
		if(!senhaNova.equals(senhaConfirmada))
		{
			FacesContext.getCurrentInstance().addMessage("formSenha:senhaNova", new FacesMessage("As senhas não coincidem!"));
			FacesContext.getCurrentInstance().addMessage("formSenha:senhaConfirmada", new FacesMessage("As senhas não coincidem!"));
			valido = false;
		}
		
		if(valido)
		{
			usuario.setSenha(senhaMD5);
			g.atualizar(usuario);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Senha atualizada com sucesso!"));
		}
	}
	
	//Atualizar perfil
	public String atualizarPerfil()
	{
		g.atualizar(usuario);
		return "index.xhtml";
	}
}
