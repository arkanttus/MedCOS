package br.ufac.si.medcos.entidades;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("funcionario")
@NamedQueries({
	@NamedQuery(name="Funcionario.todos", query="SELECT a FROM Funcionario a"),
	@NamedQuery(name="Funcionario.todosPorNome", query="SELECT a FROM Funcionario a ORDER BY a.nome")
})
public class Funcionario extends Usuario
{
    @Column(nullable=true, length=20)
    private String funcao;
    @Column(nullable=true)
    private Integer permissao;
    
    public Funcionario() {}

	public Funcionario(String nome, String cpf, Date dataNascimento, String funcao, String status, Integer permissao)
	{
		super();
		this.setNome(nome);
		this.setCpf(cpf);
		this.setDataNascimento(dataNascimento);
		this.setStatus(status);
		this.funcao = funcao;
		this.permissao = permissao;
	}

	public String getFuncao()
	{
		return funcao;
	}

	public void setFuncao(String funcao)
	{
		this.funcao = funcao;
	}

	public Integer getPermissao()
	{
		return permissao;
	}

	public void setPermissao(Integer permissao)
	{
		this.permissao = permissao;
	}
}
