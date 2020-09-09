package com.zhs.demomongo.service;

import com.zhs.demomongo.dao.CommentRepository;
import com.zhs.demomongo.po.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @author: zhs
 * @date: 2020/4/28 22:28
 */
@Service
public class ArticleService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private MongoTemplate mongoTemplate;


    public void save(Article article){
        commentRepository.save(article);
    }


    public void query(){

    }

}
