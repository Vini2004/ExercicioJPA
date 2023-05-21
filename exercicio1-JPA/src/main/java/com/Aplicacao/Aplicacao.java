package com.Aplicacao;

import com.DAO.ProdutoDAO;
import com.Models.Produto;

public class Aplicacao {

	public static void main(String[] args) {
		ProdutoDAO dao = new ProdutoDAO();

		// cadastrar um novo produto
		//Produto produto1 = new Produto("Camiseta", 119.90, 5);
		//dao.cadastrar(produto1);
		
		// atualiza um produto existente
		
		//Produto produto = dao.buscarPorId((long) 4);
		//produto.setNome("Shorts");
		//dao.atualizar(produto);
		
		// excluir um produto existente
		//Produto produto2 = dao.buscarPorId((long) 4); // buscar o produto com id = 2
		//dao.excluir(produto2);



	}

}
