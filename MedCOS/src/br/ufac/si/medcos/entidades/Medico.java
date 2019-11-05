package br.ufac.si.medcos.entidades;

import java.util.Date;


public class Medico
{
    private Integer id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    private Boolean ativo;
    private String crm;
    private String especialidade;

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

    public Boolean getAtivo()
    {
	return ativo;
    }

    public void setAtivo(Boolean ativo)
    {
	this.ativo = ativo;
    }

    public String getCrm()
    {
	return crm;
    }

    public void setCrm(String crm)
    {
	this.crm = crm;
    }

    public String getEspecialidade()
    {
	return especialidade;
    }

    public void setEspecialidade(String especialidade)
    {
	this.especialidade = especialidade;
    }
}