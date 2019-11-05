package br.ufac.si.medcos.entidades;

import javax.persistence.*;

@Entity
@Table(name="respostas")
@NamedQueries({
	@NamedQuery(name="Resposta.todos", 
		query="SELECT a FROM Resposta a"), 
	@NamedQuery(name="Resposta.todosPorNome", 
		query="SELECT a FROM Resposta a ORDER BY a.nome")
})
public class Resposta
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable=false, length=20)
    private String conteudo;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="pergunta", nullable=false)
    private Pergunta pergunta;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="paciente", nullable=false)
    private Paciente paciente;
    
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="anamnese", nullable=false)
    private Anamnese anamnese;

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
}