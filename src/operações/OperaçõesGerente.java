package operações;

import restaurant.Turno;

public interface OperaçõesGerente {

	public void iniciarTurno();
	public boolean finalizarTurno();
	public void checarRelatorioDeGastos(Turno turno);
	public void checarFolhaPagamento();
	public void checarEstoque();
	
}
