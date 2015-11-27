package restaurant.funcionarios;

import operações.OperaçõesAuxiliar;
import restaurant.Database;

public class AuxiliarCozinha extends Funcionario implements OperaçõesAuxiliar {

	public AuxiliarCozinha(String nome, int código, Database bancoDeDados) {
		super(nome, código, bancoDeDados);
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
