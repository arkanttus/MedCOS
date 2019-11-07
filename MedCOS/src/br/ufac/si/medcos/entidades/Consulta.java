package br.ufac.si.medcos.entidades;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="consultas")
@NamedQueries({
	@NamedQuery(name="Consulta.todos", 
		query="SELECT a FROM Consulta a"), 
	@NamedQuery(name="Consulta.todosPorDataHora", 
		query="SELECT a FROM Consulta a ORDER BY a.dataHora"),
})
public class Consulta
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, length=100)
    private String sintomas;
    @Column(nullable=false, length=19)
    private Date dataHora;
    @Column(nullable=false, length=40)
    private String obs;
    @Column(nullable=false, length=20)
    private String status;
    
    @ManyToOne()
    @JoinColumn(name="paciente", nullable=false)
    private Paciente paciente;
    
    @ManyToOne()
    @JoinColumn(name="medico", nullable=false)
    private Medico medico;

    @OneToMany(mappedBy="consulta", orphanRemoval=true)
    private ArrayList<Procedimento> procedimentos;
    
    @ManyToMany()
    @JoinTable(name="consultas_responsaveis", joinColumns=@JoinColumn(name="consulta"), 
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

    public String getSintomas()
    {
	return sintomas;
    }

    public void setSintomas(String sintomas)
    {
	this.sintomas = sintomas;
    }

    public Date getDataHora()
    {
	return dataHora;
    }

    public void setDataHora(Date dataHora)
    {
	this.dataHora = dataHora;
    }

    public String getObs()
    {
	return obs;
    }

    public void setObs(String obs)
    {
	this.obs = obs;
    }

    public String getStatus()
    {
	return status;
    }

    public void setStatus(String status)
    {
	this.status = status;
    }

    public Paciente getPaciente()
    {
	return paciente;
    }

    public void setPaciente(Paciente paciente)
    {
	this.paciente = paciente;
    }

    public ArrayList<Procedimento> getProcedimentos()
    {
	return procedimentos;
    }

    public void setProcedimentos(ArrayList<Procedimento> procedimentos)
    {
	this.procedimentos = procedimentos;
    }

    public ArrayList<Funcionario> getResponsaveis()
    {
	return responsaveis;
    }

    public void setResponsaveis(ArrayList<Funcionario> responsaveis)
    {
	this.responsaveis = responsaveis;
    }

    public Medico getMedico()
    {
	return medico;
    }

    public void setMedico(Medico medico)
    {
	this.medico = medico;
    }
}