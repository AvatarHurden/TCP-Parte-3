package restaurant;

public class Item {

	private int codigo;
	
	public Item(String tipo, int codigo, String nome, double custo, double preço,
			double preparo, String ingredientes) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

}
