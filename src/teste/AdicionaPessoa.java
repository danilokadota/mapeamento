package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mapeamento.Pessoa;
import mapeamento.PessoaFisica;
import mapeamento.PessoaJuridica;

public class AdicionaPessoa {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_mapeamento_banco");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("danilo");
		
		PessoaFisica pessoa2 = new PessoaFisica();
		pessoa2.setNome("davi");
		pessoa2.setCpf("1231231313");
		
		PessoaJuridica pessoa3 = new PessoaJuridica();
		pessoa3.setNome("daniel");
		pessoa3.setCnpj("54687675765");
		
		manager.persist(pessoa1);
		manager.persist(pessoa2);
		manager.persist(pessoa3);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();

	}

}
