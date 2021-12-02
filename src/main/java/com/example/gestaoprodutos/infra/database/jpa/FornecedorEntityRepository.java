package com.example.gestaoprodutos.infra.database.jpa;

import com.example.gestaoprodutos.infra.database.entities.FornecedorData;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FornecedorEntityRepository extends PagingAndSortingRepository<FornecedorData, Long> {

}
