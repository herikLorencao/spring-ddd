package com.example.gestaoprodutos.domain.fornecedor;

import com.example.gestaoprodutos.domain.recursos.DadosPaginacao;
import com.example.gestaoprodutos.domain.recursos.Pagina;

public interface FornecedorRepository {

	Fornecedor buscar( Long id );

	Long cadastrar( Fornecedor fornecedor );

	Fornecedor alterar( Fornecedor fornecedor );

	Pagina<Fornecedor> listar( DadosPaginacao paginacao );
}
