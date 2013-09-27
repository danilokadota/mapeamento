package teste;

import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mapeamento.Fatura;
import mapeamento.Ligacao;

public class AdicionaLigacaoFatura {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_mapeamento_banco");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		
		Ligacao ligacao1 = new Ligacao();
		ligacao1.setDuracao(324);

		Ligacao ligacao2 = new Ligacao();
		ligacao2.setDuracao(234);
		
		Fatura fatura = new Fatura();
		fatura.setVacimento(new GregorianCalendar(2013, 9, 27 ));
		
		fatura.getLigacoes().add(ligacao1);
		fatura.getLigacoes().add(ligacao2);
		
		ligacao1.setFatura(fatura);
		ligacao2.setFatura(fatura);
		
		manager.persist(fatura);
		manager.persist(ligacao1);
		manager.persist(ligacao2);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}

}
