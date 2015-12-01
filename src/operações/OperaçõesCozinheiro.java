package operações;

import restaurant.Pedido;

public interface OperaçõesCozinheiro {

	public void iniciarPreparação();
	public boolean finalizarPreparação();
	public void receberPedido(Pedido pedido);
	
}
