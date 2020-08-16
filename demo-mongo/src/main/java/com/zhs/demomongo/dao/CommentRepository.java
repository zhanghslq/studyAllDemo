package com.zhs.demomongo.dao;

import com.zhs.demomongo.po.Article;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author: zhs
 * @date: 2020/4/28 22:27
 */
public interface CommentRepository extends MongoRepository<Article,String> {
}
