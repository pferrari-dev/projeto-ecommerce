package ecommerce.model;

import util.Cores;

public class ProdutoEntrega extends Ecommerce {

	private final int prazo = 30;

	public ProdutoEntrega(int identificador, int tipo, String titular)
	{
		super(identificador, tipo, titular);
	}

	public int getPrazo() {
		return prazo;
	}


	public void visualizar()
	{
		super.visualizar();
		System.out.println("         Tipo de Envio: Entrega");
		System.out.println(Cores.TEXT_GREEN + "         Prazo de entrega: " + this.prazo + " dias.\n" + Cores.TEXT_RESET );
	}
}