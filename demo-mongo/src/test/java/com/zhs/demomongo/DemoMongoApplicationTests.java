package com.zhs.demomongo;

import com.zhs.demomongo.dao.CommentRepository;
import com.zhs.demomongo.po.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

@SpringBootTest
class DemoMongoApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private CommentRepository commentRepository;
    @Test
    public void contextLoads() {
        commentRepository.save(new Article(1L,"test0",2L));
    }
    @Test
    public void contextLoads2() {

        Query query = Query.query(Criteria.where("_id"));

        long comment = mongoTemplate.count(query, "comment");
        System.out.println(comment);
    }

}
