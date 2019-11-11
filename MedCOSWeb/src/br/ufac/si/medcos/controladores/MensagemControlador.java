package br.ufac.si.medcos.controladores;

import java.util.List;
import javax.faces.bean.*;
import br.ufac.si.medcos.gerentes.*;
import br.ufac.si.medcos.entidades.*;

@ManagedBean(name="mensagemControlador")
@SessionScoped
public class MensagemControlador
{
	private String mensagem, titulo, cor;
	
	public MensagemControlador() {}
	
	public String getMensagem()
	{
		return mensagem;
	}

	public void setMensagem(String mensagem)
	{
		this.mensagem = mensagem;
	}

	public String getTitulo()
	{
		return titulo;
	}

	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}

	public String getCor()
	{
		return cor;
	}

	public void setCor(String cor)
	{
		this.cor = cor;
	}
}
