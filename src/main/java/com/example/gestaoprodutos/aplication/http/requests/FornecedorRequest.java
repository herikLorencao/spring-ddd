package com.example.gestaoprodutos.aplication.http.requests;

import lombok.Getter;

@Getter
public class FornecedorRequest {
	private Long codigo;
	private String descricao;
	private String cnpj;
}
