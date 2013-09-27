package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mapeamento.Autor;
import mapeamento.Livro;

public class AdicionaLivroAutor {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_mapeamento_banco");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		Autor autor = new Autor();
		autor.setNome("davi kadota");
		
		Livro livro = new Livro();
		livro.setNome("harry");
		livro.getAutores().add(autor);
		
		manager.persist(autor);
		manager.persist(livro);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();

	}

}
