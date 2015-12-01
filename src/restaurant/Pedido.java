package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

	private Mesa mesa;
	private List<Item> itens;
	
	public Pedido(Mesa mesa) {
		this.mesa = mesa;
		
		this.itens = new ArrayList<>();
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
	public Mesa getMesa() {
		return mesa;
	}
	
}
