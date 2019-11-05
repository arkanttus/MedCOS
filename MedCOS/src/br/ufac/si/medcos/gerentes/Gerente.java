package br.ufac.si.medcos.gerentes;

import javax.persistence.*;

public abstract class Gerente
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

    public Object recuperar(long id)
    {
	return em.find(Object.class, id);
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
}