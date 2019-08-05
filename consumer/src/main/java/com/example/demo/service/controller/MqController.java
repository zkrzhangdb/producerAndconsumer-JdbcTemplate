package com.example.demo.service.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.service.MqService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MqController {
    @Reference(version = "${demo.service.version}")
    private MqService mqService;

    @RequestMapping("/send")
    public  String send(){
        mqService.sendMq();
        return  "成功！";
    }
}
