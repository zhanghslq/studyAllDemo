package com.zhs.dubbodemoprovider.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.zhs.demodubboapi.service.DemoService;

@Service(version = "2.0.1")
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}