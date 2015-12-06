package restaurant;

public class Estoque extends Ingrediente {

	private Database bancoDeDados;
	
	public Estoque(Database bancoDeDados, String nome, int quantidade, String determinador) {
	
		super(nome, quantidade, determinador);
		
		this.bancoDeDados = bancoDeDados;
	}
	
	
	
}
