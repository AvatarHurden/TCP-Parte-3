package restaurant.funcionarios;

import operações.OperaçõesGarçom;
import restaurant.Database;

public class Garcom extends Funcionario implements OperaçõesGarçom {

	public Garcom(String nome, int código, Database bancoDeDados) {
		super(nome, código, bancoDeDados);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void atualizarPedido(int códigoMesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fecharMesa(int códigoMesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abrirPedido() {
		// TODO Auto-generated method stub
		
	}

}
