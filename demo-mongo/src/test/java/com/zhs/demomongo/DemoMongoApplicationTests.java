package com.zhs.demomongo;

import com.zhs.demomongo.dao.CommentRepository;
import com.zhs.demomongo.po.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootTest
class DemoMongoApplicationTests {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private CommentRepository commentRepository;
    @Test
    public void contextLoads() {
        commentRepository.save(new Article(3L,"test02333",4L));
    }
    @Test
    public void contextLoads2() {

        Query query = Query.query(Criteria.where("_id"));

        long comment = mongoTemplate.count(query, "comment");
        System.out.println(comment);
    }

    @Test
    public void testSave(){

        for (int i = 0; i < 90; i++) {
            Article article = new Article();
            article.setContent("测试啊哈哈"+i);
            article.setUserId(1L+i);
            article.setId(1L+i);
            commentRepository.save(article);
        }

    }
    @Test
    public void testDelete(){
        commentRepository.deleteById(1L);
    }

    @Test
    public void findAll(){
        List<Article> all = commentRepository.findAll();
        all.forEach(System.out::print);
    }

    @Test
    public void testFindAllWithPageAndSort(){
        Sort sort = Sort.by(Sort.Order.desc("id"));
        PageRequest pageRequest = PageRequest.of(0, 1, sort);
        Page<Article> page = commentRepository.findAll(pageRequest);
        List<Article> content = page.getContent();
        System.out.println(content);
    }

    @Test
    public void testFindByContent(){
        List<Article> list = commentRepository.findAllByContentLike("测试啊哈哈");
        list.forEach(System.out::println);
    }

}
