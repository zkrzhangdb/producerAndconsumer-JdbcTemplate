package com.example.demo.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserServiceNew;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "${demo.service.version}")
public class UserServiceNewImpl  implements UserServiceNew {
    @Autowired
    private UserMapper userMapper;
    public  User findUser(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }



}
