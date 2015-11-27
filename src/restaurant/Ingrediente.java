package restaurant;

public class Ingrediente {

	private String nome, determinador;
	private int quantidade;
	
	public Ingrediente(String nome, int quantidade, String determinador) {
		this.nome = nome;
		this.determinador = determinador;
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getNome() {
		return nome;
	}

	public String getDeterminador() {
		return determinador;
	}
}
