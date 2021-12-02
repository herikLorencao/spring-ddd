package com.example.gestaoprodutos.domain.fornecedor;

public class CNPJInvalido extends RuntimeException {

	public CNPJInvalido( String cnpj ) {
		super( "O valor do CNPJ " + cnpj + " não segue o padrão XX.XXX.XXX/000X-XX" );
	}
}
