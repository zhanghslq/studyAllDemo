package com.zhs.demoes;

import com.zhs.demoes.dao.BookRepository;
import com.zhs.demoes.dao.DocBeanRepository;
import com.zhs.demoes.entity.Book;
import com.zhs.demoes.entity.DocBean;
import com.zhs.demoes.service.IElasticService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

import java.util.Iterator;

@SpringBootTest
class DemoEsApplicationTests {

    @Autowired
    private IElasticService iElasticService;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Autowired
    private DocBeanRepository elasticRepository;

    @Autowired
    private BookRepository bookRepository;


    @Test
    void contextLoads() {
        Iterator<DocBean> all = iElasticService.findAll();
        while (all.hasNext()){
            System.out.println(all.next());
        }
    }

    @Test
    public void testCreateIndex(){
        Book book = new Book();
        book.setBookId(1);
        book.setName("新华词典");
        bookRepository.save(book);
    }

}
