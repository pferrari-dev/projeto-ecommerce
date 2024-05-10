package ecommerce.model;

import util.Cores;

public class ProdutoRetirada extends Ecommerce
{

	private String dia;

	public ProdutoRetirada(int identificador, int tipo, String titular, String dia)
	{
		super(identificador, tipo, titular);
		this.dia = dia;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public void visualizar()
	{
		super.visualizar();
		System.out.println("         Tipo de Envio: Retirada");
		System.out.println(Cores.TEXT_GREEN + "         Dia de Retirada: " + this.dia + Cores.TEXT_RESET);
	}
}