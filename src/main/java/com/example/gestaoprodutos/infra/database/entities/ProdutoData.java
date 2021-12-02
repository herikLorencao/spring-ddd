package com.example.gestaoprodutos.infra.database.entities;

import com.example.gestaoprodutos.domain.Situacao;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table( name = "produto" )
public class ProdutoData {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "codigo", nullable = false )
	private Long codigo;

	@Column( name = "descricao", nullable = false )
	private String descricao;

	@Enumerated( EnumType.STRING )
	private Situacao situacao;

	@Column( name = "data_fabricacao" )
	private LocalDate dataFabricacao;

	@Column( name = "data_validade" )
	private LocalDate dataValidade;

	@ManyToOne
	private FornecedorData fornecedor;

	@Override
	public boolean equals( Object o ) {
		if( this == o )
			return true;
		if( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) )
			return false;
		ProdutoData that = ( ProdutoData ) o;
		return codigo != null && Objects.equals( codigo, that.codigo );
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
