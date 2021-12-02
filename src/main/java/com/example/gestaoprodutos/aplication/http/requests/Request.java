package com.example.gestaoprodutos.aplication.http.requests;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Request<T> {
	@Autowired
	private final ModelMapper modelMapper = new ModelMapper();

	public T get(Class<?> clazz) {
		return ( T ) modelMapper.map( this, clazz );
	}
}
