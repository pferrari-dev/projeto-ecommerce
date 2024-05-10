package ecommerce.controller;

import java.util.ArrayList;

import ecommerce.model.Ecommerce;
import ecommerce.repository.EcommerceRepository;

public class EcommerceController implements EcommerceRepository
{

	
	ArrayList<Ecommerce> tipos = new ArrayList<Ecommerce>();
	int numero = 0;
	
	public int genNumero() {
		return (++numero);
	}
	
	public Ecommerce buscarNaCollection(int identificador) {
		for (var elemento : tipos)
		{
			if (elemento.getIdentificador() == identificador)
				return elemento;
		}
		return null;
	}
	
	@Override
	public void listarTodos() {
		for (var elemento : tipos) {
			elemento.visualizar();
		}
	}

	@Override
	public void Cadastrar(Ecommerce ecommerce) {
		tipos.add(ecommerce);
		System.out.println("\nO produto "  + ecommerce.getIdentificador() + " foi criado com sucesso");
	}

	@Override
	public void Atualizar(Ecommerce ecommerce) {
		
		
	}

	@Override
	public void Deletar(int numero)
	{
		var produto = buscarNaCollection(numero);
		
		if (produto != null)
		{
			tipos.remove(produto);
			System.out.println("O produto " + produto.getIdentificador() + " foi deletado com sucesso!");
		}
		else
			System.out.println("O produto não foi encontrado!");
			
	}

}
