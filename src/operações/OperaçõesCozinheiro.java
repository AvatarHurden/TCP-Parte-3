package opera��es;

import restaurant.Pedido;

public interface Opera��esCozinheiro {

	public void iniciarPrepara��o();
	public void finalizarPrepara��o();
	public void receberPedido(Pedido pedido);
	
}
