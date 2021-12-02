package com.example.gestaoprodutos.aplication.http.responses;

import com.example.gestaoprodutos.domain.fornecedor.Fornecedor;
import com.example.gestaoprodutos.domain.Situacao;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProdutoResponse {
	private Long codigo;
	private String descricao;
	private Situacao situacao;
	private LocalDate dataFabricacao;
	private LocalDate dataValidade;
	private Fornecedor fornecedor;
}
