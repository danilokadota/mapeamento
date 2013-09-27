package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mapeamento.Estado;
import mapeamento.Governador;

public class AdicionaEstadoGovernador {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_mapeamento_banco");
		
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		Governador governador = new Governador();
		governador.setNome("danilo kadota");
		
		Estado estado = new Estado();
		estado.setNome("são paulo");
		estado.setGovernador(governador);
		
		
		manager.persist(governador);
		manager.persist(estado);
		manager.getTransaction().commit();
		manager.close();
		factory.close();

	}

}
