package restaurant.funcionarios;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

import operações.OperaçõesCozinheiro;
import restaurant.Database;
import restaurant.Item;
import restaurant.Mesa;
import restaurant.Pedido;

public class Cozinheiro extends Funcionario implements OperaçõesCozinheiro {

	private Queue<Mesa> filaDePreparação, filaDePedidos;
	
	public Cozinheiro(String nome, int código, Database bancoDeDados) {
		super(nome, código, bancoDeDados);
		
		filaDePedidos = new ArrayDeque<>();
		filaDePreparação = new ArrayDeque<>();
	}

	@Override
	public void iniciarPreparação() {
		Mesa mesa = filaDePedidos.poll();
		if (mesa == null)
			return;
		
		filaDePreparação.add(mesa);
	}

	@Override
	public void finalizarPreparação() {
		Mesa m = filaDePreparação.peek();
		if (m == null)
			return;
		
		List<Item> itens = m.getPedido().getItens();
		itens.remove(0);
		if (itens.isEmpty())
			filaDePreparação.poll();
	}

	@Override
	public void receberPedido(Pedido pedido) {
		filaDePedidos.add(pedido.getMesa());
	}

}
