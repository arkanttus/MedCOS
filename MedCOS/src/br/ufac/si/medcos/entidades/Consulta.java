package br.ufac.si.medcos.entidades;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;

import br.ufac.si.medcos.entidades.Funcionario;

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

    @OneToMany(mappedBy="consulta", cascade=CascadeType.ALL, orphanRemoval=true)
    private List<Procedimento> procedimentos;
    
    @ManyToMany()
    @JoinTable(name="consultas_responsaveis", joinColumns=@JoinColumn(name="consulta"), 
    inverseJoinColumns=@JoinColumn(name="funcionario"))
    private List<Funcionario> responsaveis;
    
    public Consulta() {}
    
    public Consulta(String sintomas, Date dataHora, String obs, String status, Paciente paciente, Medico medico)
	{
		super();
		this.sintomas = sintomas;
		this.dataHora = dataHora;
		this.obs = obs;
		this.status = status;
		this.paciente = paciente;
		this.medico = medico;
		this.procedimentos = new ArrayList<Procedimento>();
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

	public List<Procedimento> getProcedimentos()
	{
		return procedimentos;
	}
	
	public void adicionarProcedimento(Procedimento p)
	{
		this.procedimentos.add(p);
	}
	
	public void removerProcedimento(Procedimento p)
	{
		this.procedimentos.remove(p);
	}

	public void setProcedimentos(List<Procedimento> procedimentos)
	{
		this.procedimentos = procedimentos;
	}

	public List<Funcionario> getResponsaveis()
	{
		return responsaveis;
	}

	public void setResponsaveis(List<Funcionario> responsaveis)
	{
		this.responsaveis = responsaveis;
	}
	
	public void adicionarResponsavel(Funcionario f)
	{
		this.responsaveis.add(f);
	}
	
	public void removerResponsavel(Funcionario f)
	{
		this.responsaveis.remove(f);
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