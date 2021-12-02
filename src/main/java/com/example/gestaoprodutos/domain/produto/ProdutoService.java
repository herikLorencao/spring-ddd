package com.example.gestaoprodutos.domain.produto;

import com.example.gestaoprodutos.domain.recursos.DadosPaginacao;
import com.example.gestaoprodutos.domain.recursos.Pagina;

public class ProdutoService {

	private final ProdutoRepository produtoRepository;

	public ProdutoService( ProdutoRepository produtoRepository ) {
		this.produtoRepository = produtoRepository;
	}

	public Produto buscarPorCodigo( Long codigo ) {
		return produtoRepository.buscarPorCodigo( codigo );
	}

	public Pagina<Produto> listarAtivos( DadosPaginacao dadosPaginacao ) {
		return produtoRepository.listarAtivos( dadosPaginacao );
	}

	public Long cadastrar( Produto produto ) {
		return produtoRepository.cadastrar( produto );
	}

	public Produto alterar( Produto produto ) {
		return produtoRepository.alterar( produto );
	}

	public void remover( Produto produto ) {
		produto.desabilitar();
		produtoRepository.alterar( produto );
	}
}
