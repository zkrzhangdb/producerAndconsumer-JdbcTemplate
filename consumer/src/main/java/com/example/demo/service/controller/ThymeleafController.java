package com.example.demo.service.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.entity.Code;
import com.example.demo.entity.User;
import com.example.demo.service.MybatisService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Version;

import java.util.List;
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
    public  String  get(Model model){
        User user =mybatisService.findUserByName("张三");
        model.addAttribute("name",user.getName());
        model.addAttribute("age","<span style='color:red'>"+
                String.valueOf(user.getAge())+"</span>");
        return  "home";
    }

    @RequestMapping("getUser")
    public  String  getUser(Model model){
        User user =mybatisService.findUserByName("张三");
        model.addAttribute("member",user);
        return  "getUser";
    }


    @RequestMapping("getUserList")
    public  String  getUserList(Model model){
        List<Code> userList =mybatisService.findAllUsers("");
        model.addAttribute("userList",userList);
        return  "userList";
    }


}

