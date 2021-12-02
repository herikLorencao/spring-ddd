package com.example.gestaoprodutos.infra.database.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table( name = "fornecedor" )
public class FornecedorData {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id", nullable = false )
	private Long id;

	@Column( name = "codigo" )
	private Long codigo;

	@Column( name = "descricao" )
	private String descricao;

	@Column( name = "cnpj" )
	private String cnpj;

	@OneToMany(mappedBy = "fornecedor")
	private List<ProdutoData> produtos;

	@Override
	public boolean equals( Object o ) {
		if( this == o )
			return true;
		if( o == null || Hibernate.getClass( this ) != Hibernate.getClass( o ) )
			return false;
		FornecedorData that = ( FornecedorData ) o;
		return id != null && Objects.equals( id, that.id );
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
