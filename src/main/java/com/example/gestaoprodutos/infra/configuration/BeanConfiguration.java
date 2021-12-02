package com.example.gestaoprodutos.infra.configuration;

import com.example.gestaoprodutos.GestaoProdutosApplication;
import com.example.gestaoprodutos.aplication.http.requests.FornecedorRequest;
import com.example.gestaoprodutos.domain.fornecedor.Fornecedor;
import com.example.gestaoprodutos.domain.fornecedor.FornecedorRepository;
import com.example.gestaoprodutos.domain.fornecedor.FornecedorService;
import com.example.gestaoprodutos.domain.produto.ProdutoRepository;
import com.example.gestaoprodutos.domain.produto.ProdutoService;
import com.example.gestaoprodutos.infra.database.jpa.FornecedorEntityRepository;
import com.example.gestaoprodutos.infra.database.jpa.ProdutoEntityRepository;
import com.example.gestaoprodutos.infra.database.repositories.FornecedorDatabaseRepository;
import com.example.gestaoprodutos.infra.database.repositories.ProdutoDatabaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( basePackageClasses = GestaoProdutosApplication.class )
public class BeanConfiguration {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	public ProdutoRepository produtoRepository( ProdutoEntityRepository produtoEntityRepository, ModelMapper modelMapper ) {
		return new ProdutoDatabaseRepository( produtoEntityRepository, modelMapper );
	}

	@Bean
	public FornecedorRepository fornecedorRepository( FornecedorEntityRepository fornecedorEntityRepository, ModelMapper modelMapper ) {
		return new FornecedorDatabaseRepository( fornecedorEntityRepository, modelMapper );
	}

	@Bean
	public ProdutoService produtoService( ProdutoRepository produtoRepository ) {
		return new ProdutoService( produtoRepository );
	}

	@Bean
	public FornecedorService fornecedorService( FornecedorRepository fornecedorRepository ) {
		return new FornecedorService( fornecedorRepository );
	}

}
