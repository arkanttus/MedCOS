package br.ufac.si.medcos.entidades;

import javax.persistence.*;

import br.ufac.si.medcos.entidades.Pergunta;

@Entity
@Table(name="respostas")
@NamedQueries({
	@NamedQuery(name="Resposta.todos", 
		query="SELECT a FROM Resposta a"), 
	@NamedQuery(name="Resposta.todosPorConteudo", 
		query="SELECT a FROM Resposta a ORDER BY a.conteudo")
})
public class Resposta
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, length=40)
    private String conteudo;
    
    @ManyToOne()
    @JoinColumn(name="pergunta", nullable=false)
    private Pergunta pergunta;
    
    @ManyToOne()
    @JoinColumn(name="paciente", nullable=false)
    private Paciente paciente;
    
    @ManyToOne()
    @JoinColumn(name="anamnese", nullable=false)
    private Anamnese anamnese;

    public Resposta() {}
    
	public Resposta(String conteudo, Pergunta pergunta, Paciente paciente, Anamnese anamnese)
	{
		super();
		this.conteudo = conteudo;
		this.pergunta = pergunta;
		this.paciente = paciente;
		this.anamnese = anamnese;
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getConteudo()
	{
		return conteudo;
	}

	public void setConteudo(String conteudo)
	{
		this.conteudo = conteudo;
	}

	public Pergunta getPergunta()
	{
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta)
	{
		this.pergunta = pergunta;
	}

	public Paciente getPaciente()
	{
		return paciente;
	}

	public void setPaciente(Paciente paciente)
	{
		this.paciente = paciente;
	}

	public Anamnese getAnamnese()
	{
		return anamnese;
	}

	public void setAnamnese(Anamnese anamnese)
	{
		this.anamnese = anamnese;
	}

	public String toString()  
	{
		return "Resposta [id=" + id + ", conteudo=" + conteudo + ", pergunta=" + pergunta + ", paciente=" + paciente.getId()
				+ ", anamnese=" + anamnese.getId() + "]";
	}
}