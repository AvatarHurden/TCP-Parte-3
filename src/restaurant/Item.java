package restaurant;

import java.util.List;

public class Item {

	private int codigo;
	private String nome, tipo;
	private double custo, preço, preparo;
	
	private List<Ingrediente> receita;
	
	public Item(String tipo, int codigo, String nome, double custo, double preço,
			double preparo, String ingredientes) {
		this.codigo = codigo;
		this.nome = nome;
		this.custo = custo;
		this.preparo = preparo;
		this.preço = preparo;
		this.codigo = codigo;
		
		receita = parseIngredientes(ingredientes);
	}
	
	private List<Ingrediente> parseIngredientes(String ingredientes) {
		return null;
		// TODO
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

	public double getCusto() {
		return custo;
	}

	public double getPreço() {
		return preço;
	}

	public double getPreparo() {
		return preparo;
	}

	public List<Ingrediente> getIngredientes() {
		return receita;
	}

}
