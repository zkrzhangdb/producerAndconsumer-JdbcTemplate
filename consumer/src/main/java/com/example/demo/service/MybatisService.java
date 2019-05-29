package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface MybatisService {
    public  void insert(String name ,Integer age);
    public User findUserByName(String name);
    public List<User> findAllUsers();

}

