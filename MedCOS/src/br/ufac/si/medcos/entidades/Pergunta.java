package br.ufac.si.medcos.entidades;

import javax.persistence.*;

@Entity
@Table(name="perguntas")
@NamedQueries({
	@NamedQuery(name="Pergunta.todos", 
		query="SELECT a FROM Pergunta a"), 
	@NamedQuery(name="Pergunta.todosPorNome", 
		query="SELECT a FROM Pergunta a ORDER BY a.nome")
})
public class Pergunta
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, length=30)
    private String descricao;
    @Column(nullable=false, length=5)
    private Integer tipo;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="molde", nullable=false)
    private Molde molde;

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

    public Integer getTipo()
    {
	return tipo;
    }

    public void setTipo(Integer tipo)
    {
	this.tipo = tipo;
    }

    public Molde getMolde()
    {
	return molde;
    }

    public void setMolde(Molde molde)
    {
	this.molde = molde;
    }

}