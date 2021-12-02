package com.example.gestaoprodutos.infra.http;

import com.example.gestaoprodutos.domain.recursos.DadosPaginacao;
import com.example.gestaoprodutos.domain.recursos.OrdemPaginacao;
import com.example.gestaoprodutos.domain.recursos.Pagina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;

public class PaginacaoUtil {

	private PaginacaoUtil() {
	}

	public static DadosPaginacao montarPaginacao( Pageable pageInfo ) {
		if( !pageInfo.getSort().isSorted() )
			return new DadosPaginacao( pageInfo.getPageNumber(), pageInfo.getPageSize() );

		var camposOrdenados = new ArrayList<String>();
		OrdemPaginacao ordemPaginacao = null;

		for( Sort.Order order : pageInfo.getSort() ) {
			ordemPaginacao = order.getDirection().isAscending() ? OrdemPaginacao.ASC : OrdemPaginacao.DESC;
			camposOrdenados.add( order.getProperty() );
		}

		return new DadosPaginacao( pageInfo.getPageNumber(), pageInfo.getPageSize(), ordemPaginacao, camposOrdenados );
	}

	public static Pageable getPageable( DadosPaginacao dadosPaginacao ) {
		if( dadosPaginacao.getOrdem() == null )
			return PageRequest.of( dadosPaginacao.getPagina(), dadosPaginacao.getTamanho() );

		var direcao = dadosPaginacao.getOrdem().equals( OrdemPaginacao.ASC ) ? Sort.Direction.ASC : Sort.Direction.DESC;

		return PageRequest.of( dadosPaginacao.getPagina(), dadosPaginacao.getTamanho(), direcao, dadosPaginacao.getParametros().toArray( String[]::new ) );
	}

	public static <T> Page<T> getPage( Pagina<T> pagina, Pageable pageInfo ) {
		return new PageImpl<>( pagina.getElementos(), pageInfo, pagina.getTotalElementos() );
	}
}
