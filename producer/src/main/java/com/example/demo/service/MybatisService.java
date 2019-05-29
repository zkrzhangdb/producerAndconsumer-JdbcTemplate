package com.example.demo.service;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface MybatisService {
    public  void insert(String name ,Integer age);

    public User findUserByName(String name);
}

