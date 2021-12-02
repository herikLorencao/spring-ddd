package com.example.gestaoprodutos.domain.recursos;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DadosPaginacao {
	private final Integer pagina;
	private final Integer tamanho;
	private final OrdemPaginacao ordem;
	private final List<String> parametros;

	public DadosPaginacao(Integer pagina, Integer tamanho) {
		this.pagina = pagina;
		this.tamanho = tamanho;
		this.ordem = null;
		this.parametros = new ArrayList<>();
	}

	public DadosPaginacao( Integer pagina, Integer tamanho, OrdemPaginacao ordem, List<String> parametros ) {
		this.pagina = pagina;
		this.tamanho = tamanho;
		this.ordem = ordem;
		this.parametros = parametros;
	}
}
