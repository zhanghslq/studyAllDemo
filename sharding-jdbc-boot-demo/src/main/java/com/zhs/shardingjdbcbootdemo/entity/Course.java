package com.zhs.shardingjdbcbootdemo.entity;

import lombok.Data;

/**
 * @author: zhs
 * @since: 2020/9/27 13:00
 */
@Data
public class Course {
    private Long cid;
    private String cname;

    private String cstatus;
}
