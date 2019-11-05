package br.ufac.si.medcos.entidades;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="funcionarios")
@NamedQueries({
	@NamedQuery(name="Funcionario.todos", query="SELECT a FROM Funcionario a")
})
public class Funcionario
{
    private Integer id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private String funcao;
    private Boolean ativo;
    private Integer permissao;
    private Endereco endereco;

    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public String getNome()
    {
	return nome;
    }

    public void setNome(String nome)
    {
	this.nome = nome;
    }

    public String getCpf()
    {
	return cpf;
    }

    public void setCpf(String cpf)
    {
	this.cpf = cpf;
    }

    public Date getDataNascimento()
    {
	return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento)
    {
	this.dataNascimento = dataNascimento;
    }

    public String getFuncao()
    {
	return funcao;
    }

    public void setFuncao(String funcao)
    {
	this.funcao = funcao;
    }

    public Boolean getAtivo()
    {
	return ativo;
    }

    public void setAtivo(Boolean ativo)
    {
	this.ativo = ativo;
    }

    public Integer getPermissao()
    {
	return permissao;
    }

    public void setPermissao(Integer permissao)
    {
	this.permissao = permissao;
    }

    public Endereco getEndereco()
    {
	return endereco;
    }

    public void setEndereco(Endereco endereco)
    {
	this.endereco = endereco;
    }
}
