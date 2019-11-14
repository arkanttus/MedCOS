package br.ufac.si.medcos.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import br.ufac.si.medcos.entidades.Funcionario;
import br.ufac.si.medcos.entidades.Pergunta;

@Entity
@Table(name="moldes")
@NamedQueries({
	@NamedQuery(name="Molde.todos", 
		query="SELECT a FROM Molde a"), 
	@NamedQuery(name="Molde.todosPorCriacao", 
		query="SELECT a FROM Molde a ORDER BY a.criacao DESC"),
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
    @Temporal(TemporalType.TIMESTAMP)
    private Date criacao;
    
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name="moldes_perguntas", joinColumns=@JoinColumn(name="molde"), 
    inverseJoinColumns=@JoinColumn(name="pergunta"))
    private List<Pergunta> perguntas;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="moldes_responsaveis", joinColumns=@JoinColumn(name="molde"), 
    inverseJoinColumns=@JoinColumn(name="funcionario"))
    private List<Funcionario> responsaveis;
    
    public Molde() 
    {
    	this.perguntas = new ArrayList<Pergunta>();
		this.responsaveis = new ArrayList<Funcionario>();
    }
    
	public Molde(String descricao, Date criacao)
	{
		super();
		this.descricao = descricao;
		this.criacao = criacao;
		this.perguntas = new ArrayList<Pergunta>();
		this.responsaveis = new ArrayList<Funcionario>();
	}

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

	public List<Pergunta> getPerguntas()
	{
		return perguntas;
	}

	public void adicionarPergunta(Pergunta p)
	{
		this.perguntas.add(p);
	}

	public void removerPergunta(Pergunta p)
	{
		this.perguntas.remove(p);
	}

	public void setPerguntas(ArrayList<Pergunta> perguntas)
	{
		this.perguntas = perguntas;
	}

	public List<Funcionario> getResponsaveis()
	{
		return responsaveis;
	}

	public void adicionarResponsavel(Funcionario f)
	{
		this.responsaveis.add(f);
	}

	public void removerResponsavel(Funcionario f)
	{
		this.responsaveis.remove(f);
	}

	public void setResponsaveis(ArrayList<Funcionario> responsaveis)
	{
		this.responsaveis = responsaveis;
	}
}