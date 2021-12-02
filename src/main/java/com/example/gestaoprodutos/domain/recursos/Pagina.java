package com.example.gestaoprodutos.domain.recursos;

import lombok.Getter;

import java.util.List;

@Getter
public class Pagina<T> {
	private final Integer totalPaginas;
	private final Long totalElementos;
	private final List<T> elementos;

	public Pagina( Integer totalPaginas, Long totalElementos, List<T> elementos ) {
		this.totalPaginas = totalPaginas;
		this.totalElementos = totalElementos;
		this.elementos = elementos;
	}
}
