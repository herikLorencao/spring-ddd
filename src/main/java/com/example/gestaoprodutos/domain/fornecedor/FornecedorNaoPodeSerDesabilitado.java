package com.example.gestaoprodutos.domain.fornecedor;

public class FornecedorNaoPodeSerDesabilitado extends RuntimeException {

	public FornecedorNaoPodeSerDesabilitado(Fornecedor fornecedor) {
		super("O fornecedor " + fornecedor.getDescricao() + "não pode ser desabilitado já que possui produtos ativos");
	}
}
