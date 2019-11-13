package br.ufac.si.medcos.entidades;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="funcionarios")
@NamedQueries({
	@NamedQuery(name="Funcionario.todos", query="SELECT a FROM Funcionario a"),
	@NamedQuery(name="Funcionario.todosPorNome", query="SELECT a FROM Funcionario a ORDER BY a.nome")
})
public class Funcionario
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    @Column(nullable=false, length=70)
	private String nome;
    @Column(nullable=false, length=14)
    private String cpf;
    @Column(nullable=false, length=10)
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    @Column(nullable=true, length=20)
    private String funcao;
    @Column(nullable=false, length=10)
    private String status;
    @Column(nullable=false)
    private Integer permissao;
    
    public Funcionario() {}

	public Funcionario(String nome, String cpf, Date dataNascimento, String funcao, String status, Integer permissao)
	{
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.funcao = funcao;
		this.status = status;
		this.permissao = permissao;
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

	public String getFuncao()
	{
		return funcao;
	}

	public void setFuncao(String funcao)
	{
		this.funcao = funcao;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public Integer getPermissao()
	{
		return permissao;
	}

	public void setPermissao(Integer permissao)
	{
		this.permissao = permissao;
	}
}
