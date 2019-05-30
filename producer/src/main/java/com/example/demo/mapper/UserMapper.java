package com.example.demo.mapper;


        import
 com.example.demo.entity.User;

        import java.util.List;
        import java.util.Map;


public interface UserMapper {

    User selectByPrimaryKey(Integer id);
    List<User> getUserByPage(Map<String, Object> map);

    public  int  delUserById(Integer id);

}
