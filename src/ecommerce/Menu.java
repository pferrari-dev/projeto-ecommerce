package ecommerce;

import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce.controller.EcommerceController;
import ecommerce.model.Ecommerce;
import ecommerce.model.ProdutoEntrega;
import ecommerce.model.ProdutoRetirada;
import util.Cores;

public class Menu
{

	public static void main(String[] args)
	{
		EcommerceController ecommerce = new EcommerceController();


		Scanner leia = new Scanner(System.in);
		String cliente, dia;		
		int identificador, tipo, prazo;
		
		EcommerceController canetaController = new EcommerceController();
		
		int opcao;

		while (true)
		{

			
			System.out.println(Cores.TEXT_YELLOW_BOLD + "\n            LOJAS WING                  \n");
			System.out.println(Cores.TEXT_PURPLE_BOLD + "*****************************************************\n");
			System.out.println(Cores.TEXT_YELLOW + "\t\t 1 - Listar todos");
			System.out.println("\t 2 - Cadastrar");
			System.out.println(Cores.TEXT_GREEN + "\t\t 3 - Atualizar");
			System.out.println(Cores.TEXT_RED + "\t\t 4 - Deletar");
			System.out.println(Cores.TEXT_WHITE + "\t\t 5 - Sair\n");
			System.out.println(Cores.TEXT_PURPLE_BOLD + "*****************************************************");
			System.out.println(Cores.TEXT_BLUE_BOLD + "\n          Escolha a opção:" + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e)
			{
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao = 0;
			}

			if (opcao == 5)
			{
				System.out.println(Cores.TEXT_YELLOW_BOLD + "\n   E-COMMERCE - Fim do Programa, Muito Obrigado" + Cores.TEXT_RESET);
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao)
			{
				case 1:
					canetaController.listarTodos();;
					keyPress();
					break;
	
				case 2:
					System.out.println("Cadastrar\n");
					
					System.out.println("Digite o nome do Cliente: ");
					cliente = leia.nextLine();
					
					System.out.println("Digite a forma de acesso ao Produto: [1] - Entrega   [2] - Retirada");
					tipo = leia.nextInt();
					leia.nextLine();
					switch(tipo)
					{
						case 1 ->
						{
							identificador = canetaController.genNumero();
							canetaController.Cadastrar(new ProdutoEntrega(identificador, tipo, cliente));
							break ;
						}
						case 2 ->
						{
							identificador = canetaController.genNumero();
							
							System.out.println("Digite o melhor dia para a retirada do produto (Seg ~ Sex)");
							dia = leia.nextLine();
							canetaController.Cadastrar(new ProdutoRetirada(identificador, tipo, cliente, dia));
							break ;
						}						
					}
					keyPress();
					break;
	
				case 3:
					System.out.println("Atualizar\n\n");
					keyPress();
					break;
	
				case 4:
					System.out.println("Digite o número do produto que deseja deletar: ");
					identificador = leia.nextInt()
;					canetaController.Deletar(identificador);
					keyPress();
					break;
	
				default:
					System.out.println("\nOpção Inválida!\n");
					keyPress();
					break;
			}
		}
	}

	private static void keyPress()
	{

	}

	public static void sobre()    
	{
		System.out.println(Cores.TEXT_PURPLE_BOLD + "\n*****************************************************" + Cores.TEXT_RESET);
		System.out.println(Cores.TEXT_GREEN + "Projeto Desenvolvido por: Paloma Ferrari Wing ");
		System.out.println(Cores.TEXT_GREEN + "palomaferrari33@gmail.com");
		System.out.println(Cores.TEXT_GREEN + "github.com/pferrari33" + Cores.TEXT_RESET);
		System.out.println(Cores.TEXT_PURPLE_BOLD + "*****************************************************" + Cores.TEXT_RESET);
	}
}
