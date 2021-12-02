package com.example.gestaoprodutos.domain.produto;

import com.example.gestaoprodutos.domain.recursos.DadosPaginacao;
import com.example.gestaoprodutos.domain.recursos.Pagina;

public interface ProdutoRepository {
	Produto buscarPorCodigo( Long codigo );
	Long cadastrar( Produto produto );
	Produto alterar( Produto produto );
	Pagina<Produto> listarAtivos( DadosPaginacao paginacao );
}
