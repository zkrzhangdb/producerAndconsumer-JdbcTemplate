package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;
import java.util.Map;

public interface UserServiceNew {

    public User findUser(Integer id);

    List<User> getUserByPage(Map<String, Object> map);

    public  int  delUserById(Integer id);

    public  int  saveUser(User user);


    public  int  updateUser(User user);


    public  int  getUserCount();
}
