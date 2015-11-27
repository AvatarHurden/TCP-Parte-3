package restaurant.funcionarios;

import operações.OperaçõesGerente;
import restaurant.Database;
import restaurant.Turno;

public class Gerente extends Funcionario implements OperaçõesGerente {

	public Gerente(String nome, int código, Database bancoDeDados) {
		super(nome, código, bancoDeDados);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void iniciarTurno() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean finalizarTurno() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void checarRelatorioDeGastos(Turno turno) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checarFolhaPagamento() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checarEstoque() {
		// TODO Auto-generated method stub
		
	}

}
