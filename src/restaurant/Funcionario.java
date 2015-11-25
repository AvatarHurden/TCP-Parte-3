package restaurant;

public abstract class Funcionario {

	private String nome;
	private int c�digo;
	
	private Database bancoDeDados;

	public Funcionario(String nome, int c�digo, Database bancoDeDados) {
		this.nome = nome;
		this.c�digo = c�digo;
		this.bancoDeDados = bancoDeDados;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getC�digo() {
		return c�digo;
	}

	public void setC�digo(int c�digo) {
		this.c�digo = c�digo;
	}

	public Database getBancoDeDados() {
		return bancoDeDados;
	}

	public void setBancoDeDados(Database bancoDeDados) {
		this.bancoDeDados = bancoDeDados;
	}
	
}
