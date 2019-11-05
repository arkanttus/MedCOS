package br.ufac.si.medcos.entidades;

import javax.persistence.*;

@Entity
@Table(name="procedimentos")
@NamedQueries({
	@NamedQuery(name="Procedimento.todos", 
		query="SELECT a FROM Procedimento a"), 
	@NamedQuery(name="Procedimento.todosPorNome", 
		query="SELECT a FROM Procedimento a ORDER BY a.nome"),
	@NamedQuery(name="Procedimento.todosPorNomeContendo", 
		query="SELECT a FROM Procedimento a WHERE a.nome LIKE :termo ORDER BY a.nome")		
})
public class Procedimento
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, length=20)
    private String nome;
    @Column(nullable=false, length=70)
    private String descricao;
    @Column(nullable=false, length=10)
    private String tipo;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="consulta", nullable=false)
    private Consulta consulta;

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

    public String getDescricao()
    {
	return descricao;
    }

    public void setDescricao(String descricao)
    {
	this.descricao = descricao;
    }

    public String getTipo()
    {
	return tipo;
    }

    public void setTipo(String tipo)
    {
	this.tipo = tipo;
    }

    public Consulta getConsulta()
    {
	return consulta;
    }

    public void setConsulta(Consulta consulta)
    {
	this.consulta = consulta;
    }
}