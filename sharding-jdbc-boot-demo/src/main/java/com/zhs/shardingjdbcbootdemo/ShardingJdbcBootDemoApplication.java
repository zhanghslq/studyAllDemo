package com.zhs.shardingjdbcbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.zhs.shardingjdbcbootdemo.mapper")
@SpringBootApplication
public class ShardingJdbcBootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcBootDemoApplication.class, args);
    }

}
