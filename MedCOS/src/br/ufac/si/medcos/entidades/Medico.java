package br.ufac.si.medcos.entidades;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="medicos")
@NamedQueries({
	@NamedQuery(name="Medico.todos", 
		query="SELECT a FROM Medico a"), 
	@NamedQuery(name="Medico.todosPorNome", 
        	query="SELECT a FROM Medico a ORDER BY a.nome"),
        @NamedQuery(name="Medico.todosPorNomeContendo", 
        	query="SELECT a FROM Medico a WHERE a.nome LIKE :termo ORDER BY a.nome")
})
public class Medico
{
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Integer id;
    @Column(nullable=false, length=70)
    private String nome;
    @Column(nullable=false, length=14)
    private String cpf;
    @Column(nullable=false, length=10)
    private Date dataNascimento;
    @Column(nullable=false, length=1)
    private Boolean ativo;
    @Column(nullable=false, length=10)
    private String crm;
    @Column(nullable=true, length=50)
    private String especialidade;

    public Medico() {}
    
	public Medico(String nome, String cpf, Date dataNascimento, Boolean ativo, String crm, String especialidade)
	{
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.ativo = ativo;
		this.crm = crm;
		this.especialidade = especialidade;
	}

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