package restaurant.funcionarios;

import opera��es.Opera��esGerente;
import restaurant.Database;
import restaurant.Estoque;
import restaurant.Turno;

public class Gerente extends Funcionario implements Opera��esGerente {

	private Estoque estoque;
	
	public Gerente(String nome, int c�digo, Database bancoDeDados, Estoque estoque) {
		super(nome, c�digo, bancoDeDados);
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
