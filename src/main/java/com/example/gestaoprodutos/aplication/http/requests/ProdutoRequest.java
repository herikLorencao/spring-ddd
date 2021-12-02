package com.example.gestaoprodutos.aplication.http.requests;

import com.example.gestaoprodutos.domain.fornecedor.Fornecedor;
import com.example.gestaoprodutos.domain.Situacao;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class ProdutoRequest {
	private Long codigo;
	private String descricao;
	private Situacao situacao;
	private LocalDate dataFabricacao;
	private LocalDate dataValidade;
	private Fornecedor fornecedor;
}
