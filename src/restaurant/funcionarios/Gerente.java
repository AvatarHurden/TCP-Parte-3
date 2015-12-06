package restaurant.funcionarios;

import java.util.List;

import opera��es.Opera��esGerente;
import restaurant.Database;
import restaurant.Estoque;
import restaurant.Ingrediente;
import restaurant.Mesa;
import restaurant.Status;
import restaurant.Turno;

public class Gerente extends Funcionario implements Opera��esGerente {

	private Estoque estoque;
	
	private List<Ingrediente> IngredientesQtdZero ;
	
	
	public Gerente(String nome, int c�digo, Database bancoDeDados) {
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
		IngredientesQtdZero = getBancoDeDados().getIngredientesQtd(0);	
	}
	
	public List<Ingrediente> getIngredientesQtd() {
		return IngredientesQtdZero;

}
	
	
	
}
