package restaurant.funcionarios;

import opera��es.Opera��esAuxiliar;
import restaurant.Database;

public class AuxiliarCozinha extends Funcionario implements Opera��esAuxiliar {

	public AuxiliarCozinha(String nome, int c�digo, Database bancoDeDados) {
		super(nome, c�digo, bancoDeDados);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void liberarMesa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checarMesasParaLimpeza() {
		// TODO Auto-generated method stub
		
	}

}
