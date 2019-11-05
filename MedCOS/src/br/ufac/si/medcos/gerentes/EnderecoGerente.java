package br.ufac.si.medcos.gerentes;

import java.util.List;
import br.ufac.si.medcos.entidades.Endereco;

public class EnderecoGerente extends Gerente
{
    @SuppressWarnings("unchecked")
    public List<Endereco> recuperarTodos()
    {
	return em.createNamedQuery("Endereco.todos").getResultList();
    }
}