package restaurant;

public abstract class Funcionario {

	private String nome;
	private int código;
	
	private Database bancoDeDados;

	public Funcionario(String nome, int código, Database bancoDeDados) {
		this.nome = nome;
		this.código = código;
		this.bancoDeDados = bancoDeDados;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCódigo() {
		return código;
	}

	public void setCódigo(int código) {
		this.código = código;
	}

	public Database getBancoDeDados() {
		return bancoDeDados;
	}

	public void setBancoDeDados(Database bancoDeDados) {
		this.bancoDeDados = bancoDeDados;
	}
	
}
