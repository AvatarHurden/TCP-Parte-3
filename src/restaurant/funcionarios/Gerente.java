package restaurant.funcionarios;

import operações.OperaçõesGerente;
import restaurant.Database;
import restaurant.Estoque;
import restaurant.Turno;

public class Gerente extends Funcionario implements OperaçõesGerente {

	private Estoque estoque;
	
	public Gerente(String nome, int código, Database bancoDeDados, Estoque estoque) {
		super(nome, código, bancoDeDados);
		this.estoque = estoque;
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
