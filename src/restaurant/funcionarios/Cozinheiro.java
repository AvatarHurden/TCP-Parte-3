package restaurant.funcionarios;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import opera��es.Opera��esCozinheiro;
import restaurant.Database;
import restaurant.Item;
import restaurant.Pedido;

public class Cozinheiro extends Funcionario implements Opera��esCozinheiro {

	private Queue<Pedido> filaDePrepara��o, filaDePedidos;
	
	public Cozinheiro(String nome, int c�digo, Database bancoDeDados) {
		super(nome, c�digo, bancoDeDados);
		
		filaDePedidos = new ArrayDeque<>();
		filaDePrepara��o = new ArrayDeque<>();
	}

	@Override
	public void iniciarPrepara��o() {
		Pedido pedido = filaDePedidos.poll();
		if (pedido == null)
			return;
		
		List<Item> itens = pedido.getItens();
		
		itens.sort((item1, item2) -> {
			if (item1.getTipo().equals("Entrada") && item2.getTipo().equals("Prato Principal"))
				return -1;
			else if (item1.getTipo().equals("Prato Principal") && item2.getTipo().equals("Entrada"))
				return 1;
			else
				return - Double.compare(item1.getPreparo(), item2.getPreparo());
		}); 
		
		filaDePrepara��o.add(pedido);
	}

	@Override
	public boolean finalizarPrepara��o() {
		Pedido m = filaDePrepara��o.peek();
		if (m == null)
			return false;
		
		List<Item> itens = m.getItens();
		itens.remove(0);
		
		if (itens.isEmpty()) {
			filaDePrepara��o.poll();
			return true;
		} else
			return false;
	}

	@Override
	public void receberPedido(Pedido pedido) {
		filaDePedidos.add(pedido);
	}
	
	public Pedido getPedidoEmPrepara��o() {
		if (filaDePrepara��o.isEmpty())
			return null;
		else
			return filaDePrepara��o.peek();
	}

}
