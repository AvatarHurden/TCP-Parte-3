package restaurant.funcionarios;

import java.sql.Date;

import opera��es.Opera��esAtendente;
import restaurant.Database;
import restaurant.Mesa;
import restaurant.Turno;

public class Atendente extends Funcionario implements Opera��esAtendente {

	public Atendente(String nome, int c�digo, Database bancoDeDados) {
		super(nome, c�digo, bancoDeDados);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checarMesasLivres(int n�meroClientes) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void ocuparMesa(Mesa mesa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean reservarMesa(Turno turno, int n�meroClientes) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void cancelarReservaMesa(Mesa mesa, Date date) {
		
		// TODO Auto-generated method stub
		
	}

}
