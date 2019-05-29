package com.example.demo.service.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.entity.User;
import com.example.demo.service.MybatisService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Version;

import java.util.Map;

@Controller
public class ThymeleafController {
    @RequestMapping("home")
    public  String  home(Map<String,Object> map){
        map.put("name","张三");
        map.put("age",23);
        return  "home";
    }

    @Reference(version="${demo.service.version}")
    private MybatisService mybatisService;

    @RequestMapping("get")
    public  String  get(Map<String,Object> map){
        User user =mybatisService.findUserByName("张三");
        map.put("name",user.getName());
        map.put("age",user.getAge());
        return  "home";
    }
}

