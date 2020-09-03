package com.zhs.demoes;

import com.zhs.demoes.entity.DocBean;
import com.zhs.demoes.service.IElasticService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;

@SpringBootTest
class DemoEsApplicationTests {

    @Autowired
    private IElasticService iElasticService;
    @Test
    void contextLoads() {
        Iterator<DocBean> all = iElasticService.findAll();
        while (all.hasNext()){
            System.out.println(all.next());
        }


    }

}
