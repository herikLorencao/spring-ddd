package com.example.gestaoprodutos.aplication.http.responses;

import com.example.gestaoprodutos.domain.fornecedor.CNPJ;
import lombok.Data;

@Data
public class FornecedorResponse {
	private Long codigo;
	private String descricao;
	private CNPJ cnpj;
}
