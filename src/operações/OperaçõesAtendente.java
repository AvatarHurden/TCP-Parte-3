package opera��es;

import java.sql.Date;

import restaurant.Mesa;
import restaurant.Turno;

public interface Opera��esAtendente {

	public boolean checarMesasLivres(int n�meroClientes);
	public void ocuparMesa(Mesa mesa);
	public boolean reservarMesa(Turno turno, int n�meroClientes);
	public void cancelarReservaMesa(Mesa mesa, Date date);
	
}
