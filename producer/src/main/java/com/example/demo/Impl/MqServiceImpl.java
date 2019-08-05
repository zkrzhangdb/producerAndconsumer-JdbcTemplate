package com.example.demo.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.mq.Sender;
import com.example.demo.service.MqService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version ="${demo.service.version}" )
public class MqServiceImpl implements MqService {
    @Autowired
    private Sender sender;
    @Override
    public void sendMq() {
        sender.send();
    }
}
