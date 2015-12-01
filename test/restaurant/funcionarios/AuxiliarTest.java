package restaurant.funcionarios;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import restaurant.Database;
import restaurant.Mesa;
import restaurant.Status;

public class AuxiliarTest {

	private Database base;
	
	@Before
	public void inicializa() {
		base = new Database();
		List<Mesa> mesas = base.getTodasMesas();
		
		mesas.get(0).setStatus(Status.LIMPAR);
		mesas.get(1).setStatus(Status.LIMPAR);
		mesas.get(2).setStatus(Status.LIMPAR);
		mesas.get(3).setStatus(Status.LIMPAR);
	}
	
	@Test
	public void testchecarMesasParaLimpeza() {
		AuxiliarCozinha auxiliar = new AuxiliarCozinha("Pedro", 0, base);
		
		auxiliar.checarMesasParaLimpeza();
		
		List<Mesa> mesas = auxiliar.getMesasParaLimpeza();
		Assert.assertEquals(4, mesas.size());
		Assert.assertEquals(base.getTodasMesas().get(0), mesas.get(0));
		Assert.assertEquals(base.getTodasMesas().get(1), mesas.get(1));
		Assert.assertEquals(base.getTodasMesas().get(2), mesas.get(2));
		Assert.assertEquals(base.getTodasMesas().get(3), mesas.get(3));
	}

	@Test
	public void testliberarMesa() {
		AuxiliarCozinha auxiliar = new AuxiliarCozinha("Pedro", 0, base);
		
		auxiliar.checarMesasParaLimpeza();
		auxiliar.liberarMesa();
		
		Assert.assertEquals(Status.LIVRE, base.getTodasMesas().get(0).getStatus());
		
		List<Mesa> mesas = auxiliar.getMesasParaLimpeza();
		Assert.assertEquals(3, mesas.size());
		
		Assert.assertEquals(base.getTodasMesas().get(1), mesas.get(0));
		Assert.assertEquals(base.getTodasMesas().get(2), mesas.get(1));
		Assert.assertEquals(base.getTodasMesas().get(3), mesas.get(2));
		
	}
	
}
