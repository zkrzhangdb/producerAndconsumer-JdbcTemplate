package com.example.demo.service;

import com.example.demo.entity.Code;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MybatisService {
    public  void insert(String name ,Integer age);

    public User findUserByName(String name);

    public List<Code> findAllUsers(String codename);


}

