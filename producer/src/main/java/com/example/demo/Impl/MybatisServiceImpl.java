

package com.example.demo.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.entity.User;
import com.example.demo.service.BatisService;
import com.example.demo.service.MybatisService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version ="${demo.service.version}" )
@Mapper
public class MybatisServiceImpl  implements MybatisService {
   @Autowired
   private BatisService batisService;

   public  void insert(String  name ,Integer age){
       batisService.insert(name,age);
    }


    public User findUserByName(String name){
        User user=
        batisService.findByName(name);
        return   user;
    }





}
