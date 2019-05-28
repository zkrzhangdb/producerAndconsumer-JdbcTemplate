package com.example.demo.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.service.TestService;

@Service(version = "${demo.service.version}")
public class TestServiceImpl implements TestService {
    @Override
    public String test(String name) {
        return name;
    }
}




