package restaurant.funcionarios;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import restaurant.Database;
import restaurant.Item;
import restaurant.Pedido;

public class CozinheiroTest {
	
	private Database base;
	
	private Pedido pedido1, pedido2;
	
	@Before
	public void inicializa() {
		base = new Database();

		pedido1 = new Pedido(base.getTodasMesas().get(0));
		pedido1.getItens().add(new Item("Prato Principal", 10, "Prato Principal 1", 3, 4, 10, "1 kg de sopa"));
		pedido1.getItens().add(new Item("Entrada", 2, "Entrada 2", 3, 4, 4, "2 kg de sopa"));
		pedido1.getItens().add(new Item("Salada", 1, "Salada 1", 3, 4, 1, "2 kg de sopa"));
		pedido1.getItens().add(new Item("Entrada", 1, "Entrada 1", 3, 4, 6, "2 kg de sopa"));
		pedido1.getItens().add(new Item("Prato Principal", 13, "Prato Principal 2", 3, 4, 8, "1 kg de sopa"));
		pedido1.getItens().add(new Item("Sopa", 3, "Sopa 2", 3, 4, 30, "1 kg de sopa"));
		
		pedido2 = new Pedido(base.getTodasMesas().get(1));
		pedido2.getItens().add(new Item("salada", 13, "Salada", 5, 10, 1, "1 kg de folha"));
	}
	
	@Test
	public void testOrdenaPedido() {
		Cozinheiro cozinheiro = new Cozinheiro("Pedro", 2, base);
		
		cozinheiro.receberPedido(pedido1);
		cozinheiro.iniciarPreparação();
		
		Pedido pedido = cozinheiro.getPedidoEmPreparação();
		
		assertEquals(pedido1, pedido);
		
		List<Item> ordenados = pedido.getItens();
		assertEquals("Sopa 2", ordenados.get(0).getNome());
		assertEquals("Entrada 1", ordenados.get(1).getNome());
		assertEquals("Entrada 2", ordenados.get(2).getNome());
		assertEquals("Prato Principal 1", ordenados.get(3).getNome());
		assertEquals("Prato Principal 2", ordenados.get(4).getNome());
		assertEquals("Salada 1", ordenados.get(5).getNome());
	}
	
	@Test
	public void testFinalizaPreparaçãoUmItem() {
		Cozinheiro cozinheiro = new Cozinheiro("Pedro", 1, base);
		
		cozinheiro.receberPedido(pedido2);
		cozinheiro.iniciarPreparação();
		
		assertEquals(true, cozinheiro.finalizarPreparação());
	}
	
	@Test
	public void testFinalizaPreparaçãoVáriosItem() {
		Cozinheiro cozinheiro = new Cozinheiro("Pedro", 1, base);
		
		cozinheiro.receberPedido(pedido1);
		cozinheiro.iniciarPreparação();
		
		assertEquals(false, cozinheiro.finalizarPreparação());
		assertEquals(false, cozinheiro.finalizarPreparação());
		assertEquals(false, cozinheiro.finalizarPreparação());
		assertEquals(false, cozinheiro.finalizarPreparação());
		assertEquals(false, cozinheiro.finalizarPreparação());
		assertEquals(true, cozinheiro.finalizarPreparação());
		
		assertEquals(true, pedido1.getItens().isEmpty());
	}

}
