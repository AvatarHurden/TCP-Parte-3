package restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;

public class DatabaseTest extends Database {

	private String setores = "# total de Setores\r\n" + 
			"5\r\n" + 
			"# Nome do setor, numero de mesas, configuraçãoo de cada mesa\r\n" + 
			"Azul\r\n" + 
			"5\r\n" + 
			"4\r\n" + 
			"4\r\n" + 
			"2\r\n" + 
			"2\r\n" + 
			"5\r\n" + 
			"Amarelo\r\n" + 
			"3\r\n" + 
			"2\r\n" + 
			"2\r\n" + 
			"2\r\n" + 
			"Vermelho\r\n" + 
			"8\r\n" + 
			"4\r\n" + 
			"4\r\n" + 
			"4\r\n" + 
			"4\r\n" + 
			"6\r\n" + 
			"6\r\n" + 
			"2\r\n" + 
			"2\r\n" + 
			"Verde\r\n" + 
			"10\r\n" + 
			"3\r\n" + 
			"3\r\n" + 
			"3\r\n" + 
			"4\r\n" + 
			"4\r\n" + 
			"5\r\n" + 
			"5\r\n" + 
			"5\r\n" + 
			"6\r\n" + 
			"6\r\n" + 
			"Rosa\r\n" + 
			"5\r\n" + 
			"3\r\n" + 
			"3\r\n" + 
			"3\r\n" + 
			"3\r\n" + 
			"3";

	@Test
	public void LeSetores() throws IOException {
		Database base = new Database();
		base.carregaMesas(new BufferedReader(new StringReader(setores)));
		
		Assert.assertEquals(31, base.getTodasMesas().size());
	}
	
}
