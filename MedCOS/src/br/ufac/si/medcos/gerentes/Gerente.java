package br.ufac.si.medcos.gerentes;

import javax.persistence.*;

import br.ufac.si.medcos.entidades.Usuario;
import br.ufac.si.medcos.utils.Funcoes;

public class Gerente
{
	protected EntityManagerFactory emf;
	protected EntityManager em;

	public Gerente()
	{
		emf = Persistence.createEntityManagerFactory("MedCOS");
		em = emf.createEntityManager();
	}

	public void adicionar(Object obj)
	{
		em.getTransaction().begin();
		em.persist(obj);
		em.getTransaction().commit();
	}

	public Object recuperar(Class<?> classe, int id)
	{
		return em.find(classe, id);
	}

	public void atualizar(Object obj)
	{
		em.getTransaction().begin();
		em.merge(obj);
		em.getTransaction().commit();
	}

	public void remover(Object obj)
	{
		em.getTransaction().begin();
		em.remove(obj);
		em.getTransaction().commit();
	}

	public void encerrar()
	{
		em.close();
		emf.close();
	}
	
	public Usuario recuperarUsuarioPorCredencial(String cpf, String senha)
	{
		try
		{
			return (Usuario) em.createNamedQuery("Usuario.porCredencial").setParameter("cpf", cpf).setParameter("senha", Funcoes.md5(senha)).getSingleResult();
		}
		catch(NoResultException nre)
		{
			return null;
		}
	}
}