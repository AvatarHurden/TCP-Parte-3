package restaurant;

import org.junit.Assert;
import org.junit.Test;

import restaurant.funcionarios.Atendente;
import restaurant.funcionarios.AuxiliarCozinha;
import restaurant.funcionarios.Cozinheiro;
import restaurant.funcionarios.Garcom;
import restaurant.funcionarios.Gerente;

public class DatabaseTest extends Database {

	@Test
	public void inicializaCorretamente() {
		Database base = new Database();
		
		Assert.assertEquals(31, base.getTodasMesas().size());
		Assert.assertEquals(12, base.getCardapio().size());

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
