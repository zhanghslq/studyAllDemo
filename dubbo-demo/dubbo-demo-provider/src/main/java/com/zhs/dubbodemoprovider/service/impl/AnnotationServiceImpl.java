package com.zhs.dubbodemoprovider.service.impl;

import com.zhs.demodubboapi.service.AnnotationService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

/**
 * dubbo升级带来的换了注解，原来service注解已经过时
 * @author EDZ
 */
@DubboService
public class AnnotationServiceImpl implements AnnotationService {
    @Override
    public String sayHello(String name) {
        return "annotation: hello, " + name;
    }
}