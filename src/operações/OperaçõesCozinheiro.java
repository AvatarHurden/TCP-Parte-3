package operações;

import restaurant.Pedido;

public interface OperaçõesCozinheiro {

	public void iniciarPreparação();
	public void finalizarPreparação();
	public void receberPedido(Pedido pedido);
	
}
