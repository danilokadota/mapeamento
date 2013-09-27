package teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mapeamento.Cliente;
import mapeamento.Pedido;

public class AdicionaPedidoCliente {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("k21_mapeamento_banco");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		
		Cliente cliente = new Cliente();
		cliente.setNome("daniel kadota");
		
		Pedido pedido = new Pedido();
		pedido.setData(Calendar.getInstance());
		pedido.setCliente(cliente);
		
		manager.persist(cliente);
		manager.persist(pedido);
		
		manager.getTransaction().commit();
		manager.close();
		factory.close();

	}

}
