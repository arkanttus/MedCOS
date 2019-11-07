package br.ufac.si.medcos.entidades;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

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
    private Date data;
    
    @ManyToOne()
    @JoinColumn(name="paciente", nullable=false)
    private Paciente paciente;
    
    @ManyToOne()
    @JoinColumn(name="molde", nullable=false)
    private Molde molde;
    
    @OneToMany(mappedBy="anamnese", orphanRemoval=true)
    private ArrayList<Resposta> respostas;
    
    @ManyToMany()
    @JoinTable(name="anmneses_responsaveis", joinColumns=@JoinColumn(name="anamnese"), 
    inverseJoinColumns=@JoinColumn(name="funcionario"))
    private ArrayList<Funcionario> responsaveis;

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

    public ArrayList<Resposta> getRespostas()
    {
	return respostas;
    }

    public void setRespostas(ArrayList<Resposta> respostas)
    {
	this.respostas = respostas;
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