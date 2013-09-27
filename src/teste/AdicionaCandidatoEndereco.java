package teste;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mapeamento.Candidato;
import mapeamento.Endereco;

public class AdicionaCandidatoEndereco {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_mapeamento_banco");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Endereco endereco = new Endereco();
		endereco.setCidade("são paulo");
		endereco.setEstado("são paulo");
		endereco.setLougradouro("raiz amarela");
		endereco.setNumero(356);
		
		Candidato candidato = new Candidato();
		candidato.setNome("danilo kadota");
		candidato.setNascimento(new GregorianCalendar(1987, 8, 27));
		candidato.setEndereco(endereco);
		
		manager.persist(candidato);
		
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();

	}

}
