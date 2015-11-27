package restaurant.funcionarios;

import operações.OperaçõesCozinheiro;
import restaurant.Database;
import restaurant.Pedido;

public class Cozinheiro extends Funcionario implements OperaçõesCozinheiro {

	public Cozinheiro(String nome, int código, Database bancoDeDados) {
		super(nome, código, bancoDeDados);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void iniciarPreparação() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizarPreparação() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void receberPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		
	}

}
