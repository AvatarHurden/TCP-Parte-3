package restaurant.funcionarios;

import java.sql.Date;

import operações.OperaçõesAtendente;
import restaurant.Database;
import restaurant.Mesa;
import restaurant.Turno;

public class Atendente extends Funcionario implements OperaçõesAtendente {

	public Atendente(String nome, int código, Database bancoDeDados) {
		super(nome, código, bancoDeDados);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checarMesasLivres(int númeroClientes) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ocuparMesa(Mesa mesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean reservarMesa(Turno turno, int númeroClientes) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cancelarReservaMesa(Mesa mesa, Date date) {
		
		// TODO Auto-generated method stub
		
	}

}
