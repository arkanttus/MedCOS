package br.ufac.si.medcos.entidades;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="usuarios")
@DiscriminatorColumn(name="tipo")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQueries({
    @NamedQuery(name="Usuario.porCredencial", 
    	query="SELECT u FROM Usuario u WHERE u.cpf LIKE :cpf AND u.senha = :senha AND status = 'Ativo'")
})
public abstract class Usuario
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false, length=70)
	private String nome;
	@Column(nullable=false, length=70)
	private String senha;
    @Column(nullable=false, length=14)
    private String cpf;
    @Column(nullable=false, length=10)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(nullable=false, length=10)
    private String status;
    
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
	
	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
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

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}
}
