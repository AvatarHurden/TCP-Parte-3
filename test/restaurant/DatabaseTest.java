package restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Assert;
import org.junit.Test;

public class DatabaseTest extends Database {

	private String setores = "# total de Setores\r\n" + 
			"5\r\n" + 
			"# Nome do setor, numero de mesas, configura��oo de cada mesa\r\n" + 
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

	private String salarios = "#Sal�rios\r\n" + 
			"# Cargo, valor fixo, porcentagem\r\n" + 
			"#\r\n" + 
			"Atendente, 150, 1%\r\n" + 
			"Gar�om, 200, 7%\r\n" + 
			"Cozinheiro, 350, 5%\r\n" + 
			"Auxiliar de cozinha, 100, 3%\r\n" + 
			"Gerente, 300, 3%";
	
	private String cardapio = "#Cardapio\r\n" + 
			"# \r\n" + 
			"# c�digo, nome, custo, valor de venda, tempo de preparo (minutos), ingredientes\r\n" + 
			"\r\n" + 
			"#Entradas\r\n" + 
			"1. Lingui�a com cebola - 13,00 - 17,00 - 10 - 1 cebola, 2 lingui�as, 2 p�es \r\n" + 
			"2. Jil� com queijo - 9,00 - 12,00 - 12 - 5 jil�s, 50g de queijo canastra, 2 p�es\r\n" + 
			"3. Camar�es M�dios de Cativeiro - 20,00 - 26,00 - 13 - 6 camar�es m�dios, 1 molho de folhas verdes\r\n" + 
			"4. Camembert Empanado, Mix de Folhas e Coulie de Amora - 15,00 - 20,00 - 10 - 50g de queijo camembert, 1 molho de folhas mix, 50g de amoras\r\n" + 
			"5. Carpaccio de File� Mignon com Azeite e Grana Padano - 25,00 - 32,50 - 8 - 100g de fil� mignon, 30g de queijo grana padano, 100g de crostine, 1 molho de r�cula \r\n" + 
			"\r\n" + 
			"#Saladas\r\n" + 
			"5. Salada Caprese - 15,00 - 20,00 - 9 - 1 tomate italiano, 2 mozarela de b�fala, 1 molho de manjeric�o, 30g de queijo grana padano, 2 molhos de folhas mix\r\n" + 
			"6. Salada de Folhas, Queijos e Figos Secos - 13,00 - 17,00 - 8 - 1 molho de alface mimosa, 1 molho de r�cula, 30g de queijo grana padano, 10g de nozes, 20g de figos secos, 1 mozarela de b�fala\r\n" + 
			"7. Salada de R�culas Novas - 10,00 - 13,00 - 8 - 2 molhos de r�cula, 1 por��o de confit de cebola roxa, 30g de queijo brie, 10g de nozes \r\n" + 
			"\r\n" + 
			"#Sopas\r\n" + 
			"8. Chinesa - 10,00 - 13,00 - 15 - 100g de miss�, 100g de pernil su�no, 50g de champignon, 1 cenoura, 1 molho de acelga, 100g de macarr�o\r\n" + 
			"9. Finlandesa - 8,00 - 11,00 - 11 - 1 por��o de couve-flor, 1 batata, 1 cenoura, 50g de ervilha, 100g de vagem, 100ml de creme de mesa\r\n" + 
			"10. Sopa de cenoura - 5,00 - 6,5 - 5 - 250ml de caldo de cenoura \r\n" + 
			"11. Sopa de Batata Salsa - 7,00 - 10,00 - 10 - 2 batatas salsa, 250ml de caldo de carne\r\n" + 
			" \r\n" + 
			"#Pratos Principais\r\n" + 
			"12. Costelinha da Sinh� - 55,00 - 71,50 - 20 - 200g de costela de porco, 100g de arroz, 100g de feij�o, 1 mandioca, 1 molho de couve\r\n" + 
			"13. Mexid�o Metido a Besta - 60,00 - 78,00 - 13 - 150g de arroz, 150g de feij�o, 200g de filet mignon\r\n" + 
			"14. Lombo Assado da Panela - 45,00 - 58,5 - 20 - 200g de lombo de porco, 150g de arroz, 150g de feij�o, 50g de farinha de mandioca, 1 molho de couve, 2 batatas\r\n" + 
			"15. Frango Jeca - 40,00 - 52,00 - 17 - 2 sobrecoxas de frango, 100ml de creme de leite, 100g de milho verde\r\n" + 
			"16. Frango com Quiabo - 50,00 - 65,00 - 14 - 2 sobrecoxas de frango, 2 coxinhas de asa, 150g de arroz, 150g de feij�o, 100g de fub� de milho, 1 por��o de quiabo, 1 molho de couve, 1 chuchu\r\n" + 
			"17. Fil� Grelhado com Penne Rigatte e Molho de queijo - 48,00 - 63,00 - 10 - 150g de fil� mignon, 200g de penne, 100g de queijo gruyere, 100ml de nata, 50g de queijo grana padano\r\n" + 
			"18. Entrecot Premium com Batatas Perfumadas - 58,00 - 75,5 - 12 - 350g de fil� da costela, 3 batatas\r\n" + 
			"19. Carreteiro de Perdiz com Arroz Negro e Manteiga de Foie Gras - 70,00 - 91,00 - 17 - 150g de arroz negro, 1 perdiz, 1 lingui�a calabresa, 100ml de cacha�a, 50g de manteiga de foie gras \r\n" + 
			"20. Robalo Oliva e Ervas - 60,00 - 78,00 - 15 -1 fil� de robalo, 2 cenouras, 3 batatas doces\r\n" + 
			"\r\n" + 
			"#Sobremesas \r\n" + 
			"21. Doce de ab�bora com coco - 8,00 - 10,5 - 6 - 1 ab�bora, 100g de coco, 50g de a��car\r\n" + 
			"22. Torta da Tia Vilica  - 15,00 - 65,00 - 10 - 50g de margarina, 80g de a��car, 100ml de creme de leite, 20 ml de leite condensado, 100g de biscoito maizena, 50g de chocolate\r\n" + 
			"23. Petit Gateau de Chocolate - 10,00 - 13 - 7 - 100g de chocolate, 50g de farinha de trigo, 100ml de sorvete de creme\r\n" + 
			"24. Torta Tiramissu - 12,00 - 16,00 - 8 - 200g de biscoito champagne, 100ml de caf�, 100g de queijo mascarpone, 50g de cacau\r\n" + 
			"25. Sorvete de Creme com Calda de Chocolate - 8,00 - 11,00 - 2 - 100ml de sorvete de creme, 50g de chocolateo amargo, 30g de castanha\r\n" + 
			"\r\n" + 
			"#Bebidas\r\n" + 
			"26. Limonada refrescante - 9,00 - 3 lim�es, 50ml de leite\r\n" + 
			"27. Suco de abacaxi com gengibre - 8,00 - 1 abacaxi, 30g de gengibre\r\n" + 
			"28. �gua com g�s - 3,50\r\n" + 
			"29. �gua t�nica - 5,00\r\n" + 
			"30. Cerveja - 7,00\r\n" + 
			"31. Refrigerante - 5,00\r\n" + 
			"32. Vinho tinto - 10,00\r\n" + 
			"33. Vinho branco - 10,00 \r\n" + 
			"34. Espumante - 15,00";
	
	@Test
	public void LeSetores() throws IOException {
		Database base = new Database();
		base.carregaMesas(new BufferedReader(new StringReader(setores)));
		
		Assert.assertEquals(31, base.getTodasMesas().size());
	}
	
	@Test
	public void LeSal�rios() throws IOException {
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
	
	@Test
	public void LeCardapio() throws IOException {
		Database base = new Database();
		base.carregaCardapio(new BufferedReader(new StringReader(cardapio)));
		
		Assert.assertEquals(34, base.getCardapio().size());
	}
	
}
