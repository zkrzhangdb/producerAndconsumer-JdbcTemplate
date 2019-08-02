package com.example.demo.service;

import com.example.demo.entity.Code;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BatisService {
    @Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
    int insert(@Param("name") String  name, @Param("age") Integer age);


    @Select("SELECT * FROM USER WHERE NAME = #{name}")
    User findByName(@Param("name") String name);


    // @Results({
    //         @Result(property = "name", column = "name"),
    //         @Result(property = "age", column = "age")
    // })
    // @Select("SELECT id, name, age FROM user")
    // List<User> findAll();



    @Results({
            @Result(property = "codeType", column = "code_type"),
            @Result(property = "ccode", column = "c_code"),
            @Result(property = "cname", column = "c_name"),
            @Result(property = "isvalid", column = "is_valid"),
            @Result(property = "remark", column = "remark")
    })
    // @Select("select code_type ,c_code ,c_name ,is_valid ,remark  from t_code")
    @Select("select code_type ,c_code ,c_name ,is_valid ,remark   FROM user a ,t_code b  WHERE a.`name` = b.CODE_TYPE and   a.name =#{tname}")
    List<Code> findAll(@Param("tname") String  name );


}
