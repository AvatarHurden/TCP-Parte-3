package restaurant.funcionarios;

import opera��es.Opera��esCozinheiro;
import restaurant.Database;
import restaurant.Pedido;

public class Cozinheiro extends Funcionario implements Opera��esCozinheiro {

	public Cozinheiro(String nome, int c�digo, Database bancoDeDados) {
		super(nome, c�digo, bancoDeDados);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void iniciarPrepara��o() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarPrepara��o() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receberPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

}
