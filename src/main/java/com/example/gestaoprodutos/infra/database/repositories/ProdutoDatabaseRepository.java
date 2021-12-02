package com.example.gestaoprodutos.infra.database.repositories;

import com.example.gestaoprodutos.domain.produto.Produto;
import com.example.gestaoprodutos.domain.produto.ProdutoRepository;
import com.example.gestaoprodutos.domain.Situacao;
import com.example.gestaoprodutos.domain.recursos.DadosPaginacao;
import com.example.gestaoprodutos.domain.recursos.Pagina;
import com.example.gestaoprodutos.infra.database.entities.ProdutoData;
import com.example.gestaoprodutos.infra.database.jpa.ProdutoEntityRepository;
import com.example.gestaoprodutos.infra.http.PaginacaoUtil;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoDatabaseRepository implements ProdutoRepository {

	private final ProdutoEntityRepository repository;
	private final ModelMapper modelMapper;

	@Autowired
	public ProdutoDatabaseRepository( ProdutoEntityRepository repository, ModelMapper modelMapper ) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Produto buscarPorCodigo( Long codigo ) {
		var produtoData = repository.findById( codigo ).orElseThrow( () -> new ObjectNotFoundException( codigo, Produto.class.getSimpleName() ) );
		return modelMapper.map( produtoData, Produto.class );
	}

	@Override
	public Long cadastrar( Produto produto ) {
		var produtoSalvo = persistirProduto( produto );
		return produtoSalvo.getCodigo();
	}

	@Override
	public Produto alterar( Produto produto ) {
		return persistirProduto( produto );
	}

	@Override
	public Pagina<Produto> listarAtivos( DadosPaginacao paginacao ) {
		var pageInfo = PaginacaoUtil.getPageable( paginacao );
		var paginaBanco = repository.findAllBySituacao( Situacao.ATIVO, pageInfo );
		var produtos = paginaBanco.getContent().stream().map( produtoData -> modelMapper.map( produtoData, Produto.class ) ).toList();
		return new Pagina<>( paginaBanco.getTotalPages(), paginaBanco.getTotalElements(), produtos );
	}

	private Produto persistirProduto( Produto produto ) {
		var produtoData = modelMapper.map( produto, ProdutoData.class );
		var produtoDataSalvo = repository.save( produtoData );
		return modelMapper.map( produtoDataSalvo, Produto.class );
	}
}
