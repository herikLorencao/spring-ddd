package com.example.gestaoprodutos.domain.produto;

public class DatasDoProdutoInvalidas extends RuntimeException {

	public DatasDoProdutoInvalidas( Produto produto ) {
		super( "A data de fabricação do produto " + produto.getDescricao() + " não pode ser maior ou igual a sua data de validade" );
	}
}
