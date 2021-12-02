package com.example.gestaoprodutos.domain.fornecedor;

import com.example.gestaoprodutos.domain.produto.Produto;
import com.example.gestaoprodutos.domain.Situacao;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Fornecedor {

	private Long codigo;
	private String descricao;
	private CNPJ cnpj;
	private Situacao situacao;
	private List<Produto> produtos = new ArrayList<>();

	public void desabilitar() throws FornecedorNaoPodeSerDesabilitado {
		var existemProdutosAtivos = this.produtos.stream().anyMatch( produto -> produto.getSituacao().equals( Situacao.ATIVO ) );

		if( existemProdutosAtivos )
			throw new FornecedorNaoPodeSerDesabilitado( this );

		situacao = Situacao.INATIVO;
	}
}
