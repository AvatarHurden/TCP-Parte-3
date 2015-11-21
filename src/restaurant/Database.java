package restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Database {

	private Map<Integer, Mesa> mapaDeMesas;
	
	private Map<Class<? extends Funcionario>, Double> salariosFixo;
	private Map<Class<? extends Funcionario>, Double> salariosVariavel;
	
	private Map<Integer, Item> cardapio;
	
	public Database() {
		mapaDeMesas = new HashMap<>();
		salariosFixo = new HashMap<>();
		salariosVariavel = new HashMap<>();
		
		cardapio = new HashMap<>();
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

	public void carregaCardapio(BufferedReader inputStream) throws IOException {
		inputStream.readLine(); // Linha de comentário
		inputStream.readLine(); // Linha de comentário
		inputStream.readLine(); // Linha de comentário
		inputStream.readLine(); // Linha de comentário
		String tipo;
		while ((tipo = inputStream.readLine()) != null) {
			String itemString;
			while (!(itemString = inputStream.readLine().trim()).isEmpty()) {
				Item item = processaItem(itemString, tipo);
				cardapio.put(item.getCodigo(), item);
			}
		}
	}

	private Item processaItem(String item, String tipo) {
		System.out.println(item);
		System.out.println(Pattern.matches("(\\d*)\\. (.*) - (\\d*,\\d*) - (\\d*,\\d*) - (\\d*) - (.*)", item));
		Pattern pattern = Pattern.compile("(\\d*)\\. *(.*) *- *(\\d*(?:,\\d*)?) *- *(\\d*(?:,\\d*)?) *- *(\\d*) *- *(.*)");
		Matcher matcher = pattern.matcher(item);
		matcher.find();
		
		int codigo = Integer.parseInt(matcher.group(1));
		String nome = matcher.group(2);
		double custo = Double.parseDouble(matcher.group(3).replace(',', '.'));
		double preço = Double.parseDouble(matcher.group(4).replace(',', '.'));
		double preparo = Double.parseDouble(matcher.group(5).replace(',', '.'));
		String ingredientes = matcher.group(6);
		
		return new Item(tipo, codigo, nome, custo, preço, preparo, ingredientes);
	}
	
	public List<Item> getCardapio() {
		return new ArrayList<Item>(cardapio.values());
	}
	
}
