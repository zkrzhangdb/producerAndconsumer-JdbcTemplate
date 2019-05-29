package com.example.demo.service.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.service.RedisService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Reference(version = "${demo.service.version}")
    private RedisService redisService  ;
    @RequestMapping("/addRedis/{name}")
    public  String  redis(@PathVariable(value = "name") String name){
      return    redisService.addAndgetKey(name) ;

    }



}
