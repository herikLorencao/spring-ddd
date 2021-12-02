package com.example.gestaoprodutos.domain.produto;

import com.example.gestaoprodutos.domain.Situacao;
import com.example.gestaoprodutos.domain.fornecedor.Fornecedor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Produto {
	private Long codigo;
	private String descricao;
	private Situacao situacao;
	private LocalDate dataFabricacao;
	private LocalDate dataValidade;
	private Fornecedor fornecedor;

	public Produto( Long codigo, String descricao, Situacao situacao, LocalDate dataFabricacao, LocalDate dataValidade, Fornecedor fornecedor ) {
		if (!datasFabricacaoValidadeSaoValidas(dataFabricacao, dataValidade))
			throw new DatasDoProdutoInvalidas( this );

		this.codigo = codigo;
		this.descricao = descricao;
		this.situacao = situacao;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
		this.fornecedor = fornecedor;
	}

	public void desabilitar() {
		situacao = Situacao.INATIVO;
	}

	private boolean datasFabricacaoValidadeSaoValidas(LocalDate dataFabricacao, LocalDate dataValidade) {
		return dataFabricacao.isBefore( dataValidade );
	}
}
