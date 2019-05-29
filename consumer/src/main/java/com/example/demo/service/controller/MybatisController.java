
package com.example.demo.service.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.entity.User;
import com.example.demo.service.MybatisService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Reference(version="${demo.service.version}")
    private MybatisService mybatisService;

    @RequestMapping("/find/{name}")
    public User findByName(@PathVariable(value = "name") String name ){
        return    mybatisService.findUserByName(name);
    }



}


