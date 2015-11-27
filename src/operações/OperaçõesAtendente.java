package operações;

import java.sql.Date;

import restaurant.Mesa;
import restaurant.Turno;

public interface OperaçõesAtendente {

	public boolean checarMesasLivres(int númeroClientes);
	public void ocuparMesa(Mesa mesa);
	public boolean reservarMesa(Turno turno, int númeroClientes);
	public void cancelarReservaMesa(Mesa mesa, Date date);
	
}
