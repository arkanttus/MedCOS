package br.ufac.si.medcos.entidades;

import java.util.Date;

import javax.persistence.*;

@Entity
@DiscriminatorValue("medico")
@NamedQueries({
	@NamedQuery(name="Medico.todos", 
		query="SELECT a FROM Medico a"), 
	@NamedQuery(name="Medico.todosPorNome", 
    	query="SELECT a FROM Medico a ORDER BY a.nome"),
    @NamedQuery(name="Medico.todosPorNomeContendo", 
    	query="SELECT a FROM Medico a WHERE a.nome LIKE :termo ORDER BY a.nome")
})
public class Medico extends Usuario
{
    @Column(nullable=true, length=10)
    private String crm;
    @Column(nullable=true, length=50)
    private String especialidade;

    public Medico() {}

	public Medico(String nome, String cpf, Date dataNascimento, String status, String crm, String especialidade)
	{
		super();
		this.setNome(nome);
		this.setCpf(cpf);
		this.setDataNascimento(dataNascimento);
		this.setStatus(status);
		this.crm = crm;
		this.especialidade = especialidade;
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
	
	public boolean equals(Object obj)
	{
		if(obj == null || !(obj instanceof Medico))
			return false;

		Medico other = (Medico) obj;
		if(getId() == other.getId())
			return true;
		
		return false;
	}
}