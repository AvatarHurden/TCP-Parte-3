package restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database {

	private Map<Integer, Mesa> mapaDeMesas;
	
	public Database() {
		mapaDeMesas = new HashMap<Integer, Mesa>();
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

	public List<Mesa> getTodasMesas() {
		return new ArrayList<Mesa>(mapaDeMesas.values());
	}

}
