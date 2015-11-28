package restaurant.funcionarios;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import opera��es.Opera��esCozinheiro;
import restaurant.Database;
import restaurant.Item;
import restaurant.Mesa;
import restaurant.Pedido;

public class Cozinheiro extends Funcionario implements Opera��esCozinheiro {

	private Queue<Mesa> filaDePrepara��o, filaDePedidos;
	
	public Cozinheiro(String nome, int c�digo, Database bancoDeDados) {
		super(nome, c�digo, bancoDeDados);
		
		filaDePedidos = new ArrayDeque<>();
		filaDePrepara��o = new ArrayDeque<>();
	}

	@Override
	public void iniciarPrepara��o() {
		Mesa mesa = filaDePedidos.poll();
		if (mesa == null)
			return;
		
		filaDePrepara��o.add(mesa);
	}

	@Override
	public void finalizarPrepara��o() {
		Mesa m = filaDePrepara��o.peek();
		if (m == null)
			return;
		
		List<Item> itens = m.getPedido().getItens();
		itens.remove(0);
		if (itens.isEmpty())
			filaDePrepara��o.poll();
	}

	@Override
	public void receberPedido(Pedido pedido) {
		filaDePedidos.add(pedido.getMesa());
	}

}
