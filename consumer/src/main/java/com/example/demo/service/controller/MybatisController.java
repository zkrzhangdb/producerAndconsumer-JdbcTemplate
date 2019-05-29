
package com.example.demo.service.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.entity.User;
import com.example.demo.service.MybatisService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisController {

    @Reference(version="${demo.service.version}")
    private MybatisService mybatisService;

    @RequestMapping("/find/{name}")
    public User findByName(@PathVariable(value = "name") String name ){
        return    mybatisService.findUserByName(name);
    }

    @RequestMapping("/insert/{name}")
    public String insert(@PathVariable(value = "name") String name ){
    mybatisService.insert(name,16);

        return "添加用户成功";
    }


    @RequestMapping("/findall")
    public List<User> findAll( ){
        return mybatisService.findAllUsers();
    }


}


