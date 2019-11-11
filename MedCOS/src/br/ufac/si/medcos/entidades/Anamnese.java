package br.ufac.si.medcos.entidades;

import java.util.List;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

import br.ufac.si.medcos.entidades.Funcionario;

@Entity
@Table(name="anamneses")
@NamedQueries({
	@NamedQuery(name="Anamnese.todos", 
		query="SELECT a FROM Anamnese a"), 
	@NamedQuery(name="Anamnese.todosPorData", 
		query="SELECT a FROM Anamnese a ORDER BY a.data")
})
public class Anamnese
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, length=19)
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    
    @ManyToOne()
    @JoinColumn(name="paciente", nullable=false)
    private Paciente paciente;
    
    @ManyToOne()
    @JoinColumn(name="molde", nullable=false)
    private Molde molde;
    
    @OneToMany(mappedBy="anamnese", cascade=CascadeType.REMOVE, orphanRemoval=true)
    private List<Resposta> respostas;
    
    @ManyToMany(cascade=CascadeType.REMOVE)
    @JoinTable(name="anmneses_responsaveis", joinColumns=@JoinColumn(name="anamnese"), 
    inverseJoinColumns=@JoinColumn(name="funcionario"))
    private List<Funcionario> responsaveis;

    public Anamnese() {}
	
	public Anamnese(Date data, Paciente paciente, Molde molde)
	{
		super();
		this.data = data;
		this.paciente = paciente;
		this.molde = molde;
		this.respostas = new ArrayList<Resposta>();
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

	public Date getData()
	{
		return data;
	}

	public void setData(Date data)
	{
		this.data = data;
	}

	public Paciente getPaciente()
	{
		return paciente;
	}

	public void setPaciente(Paciente paciente)
	{
		this.paciente = paciente;
	}

	public Molde getMolde()
	{
		return molde;
	}

	public void setMolde(Molde molde)
	{
		this.molde = molde;
	}

	public List<Resposta> getRespostas()
	{
		return respostas;
	}

	public void adicionarResposta(Resposta r)
	{
		this.respostas.add(r);
	}

	public void removerResposta(Resposta r)
	{
		this.respostas.remove(r);
	}

	public void setRespostas(List<Resposta> respostas)
	{
		this.respostas = respostas;
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

	public void setResponsaveis(List<Funcionario> responsaveis)
	{
		this.responsaveis = responsaveis;
	}
}