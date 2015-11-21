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

	private String salarios = "#Salários\r\n" + 
			"# Cargo, valor fixo, porcentagem\r\n" + 
			"#\r\n" + 
			"Atendente, 150, 1%\r\n" + 
			"Garçom, 200, 7%\r\n" + 
			"Cozinheiro, 350, 5%\r\n" + 
			"Auxiliar de cozinha, 100, 3%\r\n" + 
			"Gerente, 300, 3%";
	
	@Test
	public void LeSetores() throws IOException {
		Database base = new Database();
		base.carregaMesas(new BufferedReader(new StringReader(setores)));
		
		Assert.assertEquals(31, base.getTodasMesas().size());
	}
	
	@Test
	public void LeSalários() throws IOException {
		Database base = new Database();
		base.carregaSalarios(new BufferedReader(new StringReader(salarios)));
		
		Assert.assertEquals(150, base.getSalarioFixoPara(Atendente.class), 0);
		Assert.assertEquals(0.01, base.getSalarioVariavelPara(Atendente.class), 0);
		
		Assert.assertEquals(200, base.getSalarioFixoPara(Garcom.class), 0);
		Assert.assertEquals(0.07, base.getSalarioVariavelPara(Garcom.class), 0);
		
		Assert.assertEquals(350, base.getSalarioFixoPara(Cozinheiro.class), 0);
		Assert.assertEquals(0.05, base.getSalarioVariavelPara(Cozinheiro.class), 0);

		Assert.assertEquals(100, base.getSalarioFixoPara(AuxiliarCozinha.class), 0);
		Assert.assertEquals(0.03, base.getSalarioVariavelPara(AuxiliarCozinha.class), 0);

		Assert.assertEquals(300, base.getSalarioFixoPara(Gerente.class), 0);
		Assert.assertEquals(0.03, base.getSalarioVariavelPara(Gerente.class), 0);
	}
	
}
