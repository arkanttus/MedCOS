package br.ufac.si.medcos.entidades;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="moldes")
@NamedQueries({
	@NamedQuery(name="Molde.todos", 
		query="SELECT a FROM Molde a"), 
	@NamedQuery(name="Molde.todosPorDescricao", 
		query="SELECT a FROM Molde a ORDER BY a.descricao"),
	@NamedQuery(name="Molde.todosPorDescricaoContendo", 
		query="SELECT a FROM Molde a WHERE a.descricao LIKE :termo ORDER BY a.descricao")		
})
public class Molde
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, length=20)
    private String descricao;
    @Column(nullable=false, length=10)
    private Date criacao;
    
    @ManyToMany(cascade=CascadeType.ALL)
    private ArrayList<Pergunta> perguntas;
    
    @ManyToMany(cascade=CascadeType.ALL)
    private ArrayList<Funcionario> responsaveis;
    
    public Integer getId()
    {
	return id;
    }

    public void setId(Integer id)
    {
	this.id = id;
    }

    public String getDescricao()
    {
	return descricao;
    }

    public void setDescricao(String descricao)
    {
	this.descricao = descricao;
    }

    public Date getCriacao()
    {
	return criacao;
    }

    public void setCriacao(Date criacao)
    {
	this.criacao = criacao;
    }

    public ArrayList<Pergunta> getPerguntas()
    {
	return perguntas;
    }

    public void setPerguntas(ArrayList<Pergunta> perguntas)
    {
	this.perguntas = perguntas;
    }

    public ArrayList<Funcionario> getResponsaveis()
    {
	return responsaveis;
    }

    public void setResponsaveis(ArrayList<Funcionario> responsaveis)
    {
	this.responsaveis = responsaveis;
    }
}