package restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

	private Map<Integer, Mesa> mapaDeMesas;
	private Map<Class<? extends Funcionario>, Double> salariosFixo;
	private Map<Class<? extends Funcionario>, Double> salariosVariavel;
	
	public Database() {
		mapaDeMesas = new HashMap<>();
		salariosFixo = new HashMap<>();
		salariosVariavel = new HashMap<>();
	}
	
	public void carregaMesas(BufferedReader inputStream) throws IOException {
		
		inputStream.readLine(); // Linha de comentário
		int numSetores = Integer.parseInt(inputStream.readLine());
		inputStream.readLine(); // Linha de comentário
		int totalMesas = 0;
		
		for (int i = 0; i < numSetores; i++) {
			String nomeSetor = inputStream.readLine();
			int numMesas = Integer.parseInt(inputStream.readLine());
			for (int j = 0; j < numMesas; j++) {
				Mesa m = new Mesa(totalMesas++, nomeSetor, Integer.parseInt(inputStream.readLine()));
				mapaDeMesas.put(totalMesas, m);
			}
		}
	}

	public void carregaSalarios(BufferedReader inputStream) throws IOException {
		inputStream.readLine(); // Linha de comentário
		inputStream.readLine(); // Linha de comentário
		inputStream.readLine(); // Linha de comentário
		
		String line;
		while ((line = inputStream.readLine()) != null) {
			String[] parts = line.split(", ");

			Class<? extends Funcionario> classe = converteNome(parts[0]);
			Double fixo = Double.parseDouble(parts[1]);
			Double variavel = Double.parseDouble(parts[2].replaceAll("%", "")) / 100;
			
			salariosFixo.put(classe, fixo);
			salariosVariavel.put(classe, variavel);
		}
	}
	
	private Class<? extends Funcionario> converteNome(String nome) {
		Class<? extends Funcionario> classe = null;
		switch (nome) {
		case "Atendente":
			classe = Atendente.class;
			break;
		case "Garçom":
			classe = Garcom.class;
			break;
		case "Cozinheiro":
			classe = Cozinheiro.class;
			break;
		case "Auxiliar de cozinha":
			classe = AuxiliarCozinha.class;
			break;
		case "Gerente":
			classe = Gerente.class;
			break;
		default:
			break;
		}
		
		return classe;
	}

	
	public List<Mesa> getTodasMesas() {
		return new ArrayList<Mesa>(mapaDeMesas.values());
	}

	public double getSalarioFixoPara(Class<? extends Funcionario> classe) {
		return salariosFixo.get(classe);
	}
	
	public double getSalarioVariavelPara(Class<? extends Funcionario> classe) {
		return salariosVariavel.get(classe);
	}
	
}
