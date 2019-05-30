package com.example.demo.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserServiceNew;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Service(version = "${demo.service.version}")
public class UserServiceNewImpl  implements UserServiceNew {
    @Autowired
    private UserMapper userMapper;
    public  User findUser(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> getUserByPage(Map<String, Object> map){
        return userMapper.getUserByPage(map);
    }


    public  int  delUserById(Integer id){
        return userMapper.delUserById(id);

    }






}
