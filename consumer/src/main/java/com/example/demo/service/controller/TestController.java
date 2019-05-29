package com.example.demo.service.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.service.TestService;
import com.example.demo.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Reference(version = "${demo.service.version}")
    private TestService  testService;
    @RequestMapping("/test/{name}")
    public  String  test(@PathVariable(value = "name") String name ){
        return   testService.test(name);
    }
    @Reference(version = "${demo.service.version}")
    private UserService userService;

    @RequestMapping("/add/{name}")
    public  String  addUser(@PathVariable(value = "name") String name ){
       userService.create(name,23);
        return  "添加用户成功，用户名:"+name;
    }


    @RequestMapping("/del/{name}")
    public  String  delUser(@PathVariable(value = "name") String name ){
        userService.deleteByName(name);
        return  "删除用户成功，用户名:"+name;
    }


    @RequestMapping("/find")
    public  String  findUser(){
       int a =   userService.getAllUsers();
        return "用户总量 : " +a;
    }


}
