package restaurant.funcionarios;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import operações.OperaçõesCozinheiro;
import restaurant.Database;
import restaurant.Item;
import restaurant.Pedido;

public class Cozinheiro extends Funcionario implements OperaçõesCozinheiro {

	private Queue<Pedido> filaDePreparação, filaDePedidos;
	
	public Cozinheiro(String nome, int código, Database bancoDeDados) {
		super(nome, código, bancoDeDados);
		
		filaDePedidos = new ArrayDeque<>();
		filaDePreparação = new ArrayDeque<>();
	}

	@Override
	public void iniciarPreparação() {
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
		
		filaDePreparação.add(pedido);
	}

	@Override
	public boolean finalizarPreparação() {
		Pedido m = filaDePreparação.peek();
		if (m == null)
			return false;
		
		List<Item> itens = m.getItens();
		itens.remove(0);
		
		if (itens.isEmpty()) {
			filaDePreparação.poll();
			return true;
		} else
			return false;
	}

	@Override
	public void receberPedido(Pedido pedido) {
		filaDePedidos.add(pedido);
	}
	
	public Pedido getPedidoEmPreparação() {
		if (filaDePreparação.isEmpty())
			return null;
		else
			return filaDePreparação.peek();
	}

}
