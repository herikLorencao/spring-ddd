package com.example.gestaoprodutos.domain.fornecedor;

import com.example.gestaoprodutos.domain.recursos.DadosPaginacao;
import com.example.gestaoprodutos.domain.recursos.Pagina;

import java.util.List;

public class FornecedorService {

	private final FornecedorRepository fornecedorRepository;

	public FornecedorService( FornecedorRepository fornecedorRepository ) {
		this.fornecedorRepository = fornecedorRepository;
	}

	public Fornecedor buscar( Long id ) {
		return fornecedorRepository.buscar( id );
	}

	public Pagina<Fornecedor> listarAtivos( DadosPaginacao dadosPaginacao ) {
		return fornecedorRepository.listar( dadosPaginacao );
	}

	public Long cadastrar( Fornecedor fornecedor ) {
		return fornecedorRepository.cadastrar( fornecedor );
	}

	public Fornecedor alterar( Fornecedor fornecedor ) throws FornecedorNaoPodeSerDesabilitado {
		fornecedor.desabilitar();
		return fornecedorRepository.alterar( fornecedor );
	}

	public void remover( Fornecedor fornecedor ) {
		fornecedor.desabilitar();
		fornecedorRepository.alterar( fornecedor );
	}
}
