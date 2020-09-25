package com.zhs.demoes.dao;

import com.zhs.demoes.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author: zhs
 * @date: 2020/9/10 21:28
 */
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {
}
