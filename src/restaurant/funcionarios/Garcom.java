package restaurant.funcionarios;

import opera��es.Opera��esGar�om;
import restaurant.Database;

public class Garcom extends Funcionario implements Opera��esGar�om {

	public Garcom(String nome, int c�digo, Database bancoDeDados) {
		super(nome, c�digo, bancoDeDados);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void atualizarPedido(int c�digoMesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fecharMesa(int c�digoMesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abrirPedido() {
		// TODO Auto-generated method stub
		
	}

}
