package br.ufac.si.medcos.entidades;

import javax.persistence.*;

@Entity
@Table(name="enderecos")
@NamedQueries({
	@NamedQuery(name="Endereco.todos", 
		query="SELECT a FROM Endereco a")
})
public class Endereco
{
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, length=40)
    private String logradouro;
    @Column(nullable=false, length=40)
    private String bairro;
    @Column(nullable=false, length=40)
    private String cidade;
    @Column(nullable=false, length=40)
    private String estado;
    @Column(nullable=false, length=9)
    private String cep;
    @Column(nullable=false)
    private Integer numero;

    public Endereco() {}
    
	public Endereco(String logradouro, String bairro, String cidade, String estado, String cep, Integer numero)
	{
		super();
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
		this.numero = numero;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getLogradouro()
	{
		return logradouro;
	}

	public void setLogradouro(String logradouro)
	{
		this.logradouro = logradouro;
	}

	public String getBairro()
	{
		return bairro;
	}

	public void setBairro(String bairro)
	{
		this.bairro = bairro;
	}

	public String getCidade()
	{
		return cidade;
	}

	public void setCidade(String cidade)
	{
		this.cidade = cidade;
	}

	public String getEstado()
	{
		return estado;
	}

	public void setEstado(String estado)
	{
		this.estado = estado;
	}

	public String getCep()
	{
		return cep;
	}

	public void setCep(String cep)
	{
		this.cep = cep;
	}

	public Integer getNumero()
	{
		return numero;
	}

	public void setNumero(Integer numero)
	{
		this.numero = numero;
	}
	
	public String toString() 
	{
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", estado=" + estado + ", cep=" + cep + ", numero=" + numero + "]";
	}
}