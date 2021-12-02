package com.example.gestaoprodutos.infra.database.repositories;

import com.example.gestaoprodutos.domain.fornecedor.Fornecedor;
import com.example.gestaoprodutos.domain.fornecedor.FornecedorRepository;
import com.example.gestaoprodutos.domain.recursos.DadosPaginacao;
import com.example.gestaoprodutos.domain.recursos.Pagina;
import com.example.gestaoprodutos.infra.database.entities.FornecedorData;
import com.example.gestaoprodutos.infra.database.jpa.FornecedorEntityRepository;
import com.example.gestaoprodutos.infra.http.PaginacaoUtil;
import org.hibernate.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FornecedorDatabaseRepository implements FornecedorRepository {

	private final FornecedorEntityRepository repository;
	private final ModelMapper modelMapper;

	@Autowired
	public FornecedorDatabaseRepository( FornecedorEntityRepository repository, ModelMapper modelMapper ) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	@Override
	public Fornecedor buscar( Long id ) {
		var fornecedorData = repository.findById( id ).orElseThrow( () -> new ObjectNotFoundException( id, Fornecedor.class.getSimpleName() ) );
		return modelMapper.map( fornecedorData, Fornecedor.class );
	}

	@Override
	public Long cadastrar( Fornecedor fornecedor ) {
		return persistirFornecedor( fornecedor );
	}

	@Override
	public Fornecedor alterar( Fornecedor fornecedor ) {
		persistirFornecedor( fornecedor );
		return fornecedor;
	}

	@Override
	public Pagina<Fornecedor> listar( DadosPaginacao paginacao ) {
		var pageInfo = PaginacaoUtil.getPageable( paginacao );
		var paginaBanco = repository.findAll( pageInfo );
		var fornecedores = paginaBanco.getContent().stream().map( fornecedorData -> modelMapper.map( fornecedorData, Fornecedor.class ) ).toList();
		return new Pagina<>( paginaBanco.getTotalPages(), paginaBanco.getTotalElements(), fornecedores );
	}

	private Long persistirFornecedor( Fornecedor fornecedor ) {
		var fornecedorData = modelMapper.map( fornecedor, FornecedorData.class );
		var fornecedorSalvo = repository.save( fornecedorData );
		return fornecedorSalvo.getId();
	}
}
