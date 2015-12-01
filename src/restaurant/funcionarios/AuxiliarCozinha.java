package restaurant.funcionarios;

import java.util.List;

import opera��es.Opera��esAuxiliar;
import restaurant.Database;
import restaurant.Mesa;
import restaurant.Status;

public class AuxiliarCozinha extends Funcionario implements Opera��esAuxiliar {

	private List<Mesa> mesasParaLimpar;
	
	public AuxiliarCozinha(String nome, int c�digo, Database bancoDeDados) {
		super(nome, c�digo, bancoDeDados);
	}

	@Override
	public void liberarMesa() {
		if (mesasParaLimpar != null && !mesasParaLimpar.isEmpty()) {
			mesasParaLimpar.get(0).setStatus(Status.LIVRE);
			mesasParaLimpar.remove(0);
		}
	}

	@Override
	public void checarMesasParaLimpeza() {
		mesasParaLimpar = getBancoDeDados().getMesasComStatus(Status.LIMPAR);
	}
	
	public List<Mesa> getMesasParaLimpeza() {
		return mesasParaLimpar;
	}

}
