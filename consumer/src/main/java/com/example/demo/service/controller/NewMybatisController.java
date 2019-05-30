
package com.example.demo.service.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.entity.User;
import com.example.demo.service.MybatisService;
import com.example.demo.service.UserServiceNew;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NewMybatisController {

    @Reference(version="${demo.service.version}")
    private UserServiceNew userServiceNew;

    @RequestMapping("/findById/{id}")
    public User findByName(@PathVariable(value = "id")  Integer id ){

        return    userServiceNew.findUser(Integer.valueOf(id));
    }



}


