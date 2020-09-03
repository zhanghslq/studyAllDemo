package com.zhs.demoes.entity;

import lombok.Data;

@Data
public final class EsEntity<T> {

	private String id;
	private T data;


}