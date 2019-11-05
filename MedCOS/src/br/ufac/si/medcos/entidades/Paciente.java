package br.ufac.si.medcos.entidades;

import java.util.ArrayList;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="pacientes")
@NamedQueries({
	@NamedQuery(name="Paciente.todos", 
		query="SELECT a FROM Paciente a"), 
	@NamedQuery(name="Paciente.todosPorNome", 
		query="SELECT a FROM Paciente a ORDER BY a.nome"),
	@NamedQuery(name="Paciente.todosPorNomeContendo", 
		query="SELECT a FROM Paciente a WHERE a.nome LIKE :termo ORDER BY a.nome")		
})
public class Paciente
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, length=70)
    private String nome;
    @Column(nullable=false, length=14)
    private String cpf;
    @Column(nullable=false, length=10)
    private Date dataNascimento;
    @Column(nullable=false, length=20)
    private String estadoCivil;
    @Column(nullable=false, length=12)
    private String fone;
    @Column(nullable=false, length=20)
    private String email;
    @Column(nullable=false, length=25)
    private String profissao;
    @Column(nullable=false, length=30)
    private String obs;
    
    @ManyToOne()
    @JoinColumn(name="endereco", nullable=false)
    private Endereco endereco;
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="consulta")
    private ArrayList<Consulta> consultas;
    
    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="anamnese")
    private ArrayList<Anamnese> anamneses;

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

    public String getEstadoCivil()
    {
	return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil)
    {
	this.estadoCivil = estadoCivil;
    }

    public String getFone()
    {
	return fone;
    }

    public void setFone(String fone)
    {
	this.fone = fone;
    }

    public String getEmail()
    {
	return email;
    }

    public void setEmail(String email)
    {
	this.email = email;
    }

    public String getProfissao()
    {
	return profissao;
    }

    public void setProfissao(String profissao)
    {
	this.profissao = profissao;
    }

    public String getObs()
    {
	return obs;
    }

    public void setObs(String obs)
    {
	this.obs = obs;
    }

    public Endereco getEndereco()
    {
	return endereco;
    }

    public void setEndereco(Endereco endereco)
    {
	this.endereco = endereco;
    }

    public ArrayList<Consulta> getConsultas()
    {
	return consultas;
    }

    public void setConsultas(ArrayList<Consulta> consultas)
    {
	this.consultas = consultas;
    }

    public ArrayList<Anamnese> getAnamneses()
    {
	return anamneses;
    }

    public void setAnamneses(ArrayList<Anamnese> anamneses)
    {
	this.anamneses = anamneses;
    }
}