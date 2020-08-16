package com.zhs.demomongo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author: zhs
 * @date: 2020/4/28 22:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "article")
public class Article {
    @Id
    private Long id;
    @Field
    private String content;

    private Long userId;
}
