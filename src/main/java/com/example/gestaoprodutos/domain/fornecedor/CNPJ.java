package com.example.gestaoprodutos.domain.fornecedor;

import lombok.Getter;

@Getter
public class CNPJ {

	private final String valor;

	public CNPJ( String valor ) {
//		var validacaoCNPJ = "/\\d{2}\\.\\d{3}\\.\\d{3}/000\\{1,2}\\-\\d{2}/g";
//
//		if( !valor.matches( validacaoCNPJ ) )
//			throw new CNPJInvalido( valor );

		this.valor = valor;
	}
}
