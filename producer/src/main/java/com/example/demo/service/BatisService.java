package com.example.demo.service;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BatisService {
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String  name, @Param("age") Integer age);


    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);


    @Results({
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })
    @Select("SELECT name, age FROM user")
    List<User> findAll();



}
