package opera��es;

import restaurant.Turno;

public interface Opera��esGerente {

	public void iniciarTurno();
	public boolean finalizarTurno();
	public void checarRelatorioDeGastos(Turno turno);
	public void checarFolhaPagamento();
	public void checarEstoque();
	
}
