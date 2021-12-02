package com.example.gestaoprodutos.aplication.http.controller;

import com.example.gestaoprodutos.aplication.http.requests.ProdutoRequest;
import com.example.gestaoprodutos.domain.produto.Produto;
import com.example.gestaoprodutos.domain.produto.ProdutoService;
import com.example.gestaoprodutos.infra.http.PaginacaoUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping( "/produtos" )
public class ProdutoController {

	private final ProdutoService produtoService;
	private final ModelMapper mapper;

	@Autowired
	public ProdutoController( ProdutoService produtoService, ModelMapper mapper ) {
		this.produtoService = produtoService;
		this.mapper = mapper;
	}

	@GetMapping( "/{id}" )
	public ResponseEntity<Produto> buscarPorCodigo( @PathVariable Long id ) {
		var produto = produtoService.buscarPorCodigo( id );
		return ResponseEntity.ok( produto );
	}

	@GetMapping
	public Page<Produto> listar( Pageable pageInfo ) {
		var dadosPaginacao = PaginacaoUtil.montarPaginacao( pageInfo );
		var produtos = produtoService.listarAtivos( dadosPaginacao );
		return PaginacaoUtil.getPage( produtos, pageInfo );
	}

	@PostMapping
	public ResponseEntity<Produto> cadastrar( @RequestBody ProdutoRequest produtoRequest, UriComponentsBuilder uriBuilder ) {
		var produto = mapper.map( produtoRequest, Produto.class );
		var codigo = produtoService.cadastrar( produto );
		var uri = uriBuilder.path( "/produtos/{id}" ).buildAndExpand( codigo ).toUri();
		return ResponseEntity.created( uri ).body( produto );
	}
}
