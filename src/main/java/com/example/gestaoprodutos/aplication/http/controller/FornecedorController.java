package com.example.gestaoprodutos.aplication.http.controller;

import com.example.gestaoprodutos.aplication.http.requests.FornecedorRequest;
import com.example.gestaoprodutos.domain.fornecedor.Fornecedor;
import com.example.gestaoprodutos.domain.fornecedor.FornecedorService;
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
@RequestMapping( "/fornecedores" )
public class FornecedorController {

	private final FornecedorService fornecedorService;
	private final ModelMapper mapper;

	@Autowired
	public FornecedorController( FornecedorService fornecedorService, ModelMapper mapper ) {
		this.fornecedorService = fornecedorService;
		this.mapper = mapper;
	}

	@GetMapping( "/{id}" )
	public ResponseEntity<Fornecedor> buscarPorCodigo( @PathVariable Long id ) {
		var fornecedor = fornecedorService.buscar( id );
		return ResponseEntity.ok( fornecedor );
	}

	@GetMapping
	public Page<Fornecedor> listar( Pageable pageInfo ) {
		var dadosPaginacao = PaginacaoUtil.montarPaginacao( pageInfo );
		var paginas = fornecedorService.listarAtivos( dadosPaginacao );
		return PaginacaoUtil.getPage(paginas, pageInfo);
	}

	@PostMapping
	public ResponseEntity<Fornecedor> cadastrar( @RequestBody FornecedorRequest fornecedorRequest, UriComponentsBuilder uriBuilder ) {
		var fornecedor = mapper.map( fornecedorRequest, Fornecedor.class );
		var codigo = fornecedorService.cadastrar( fornecedor );
		var uri = uriBuilder.path( "/produtos/{id}" ).buildAndExpand( codigo ).toUri();
		return ResponseEntity.created( uri ).body( fornecedor );
	}
}
