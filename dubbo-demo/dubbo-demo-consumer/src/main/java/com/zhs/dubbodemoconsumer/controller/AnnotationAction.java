package com.zhs.dubbodemoconsumer.controller;

import com.zhs.demodubboapi.service.AnnotationService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("anon")
public class AnnotationAction {

    @DubboReference
    private AnnotationService annotationService;

    @GetMapping("say")
    public String doSayHello(String name) {
        return annotationService.sayHello(name);
    }
}