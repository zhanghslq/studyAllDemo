package com.zhs.demoes.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "book")
public class Book {
	@Id
	private Integer bookId;
	private String name;
}