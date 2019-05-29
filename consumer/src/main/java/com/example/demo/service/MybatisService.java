package com.example.demo.service;

import com.example.demo.entity.User;

public interface MybatisService {
    public  void insert(String name ,Integer age);
    public User findUserByName(String name);
}

