package com.example.gestaoprodutos.infra.database.jpa;

import com.example.gestaoprodutos.domain.Situacao;
import com.example.gestaoprodutos.infra.database.entities.ProdutoData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoEntityRepository extends PagingAndSortingRepository<ProdutoData, Long> {
	Page<ProdutoData> findAllBySituacao( Situacao situacao, Pageable pageInfo );
}
