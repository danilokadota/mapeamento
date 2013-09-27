package teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mapeamento.Usuario;

public class AdicionaUsuario {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_mapeamento_banco");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Usuario usuario = new Usuario();
		usuario.setEmail("danilokadota@gmail.com");
		usuario.setDataDeCadastro(Calendar.getInstance());
		
		manager.persist(usuario);
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}

}
