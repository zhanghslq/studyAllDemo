package com.zhs.dubbodemoprovider.service.impl;

import com.zhs.dubbodemoprovider.service.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}