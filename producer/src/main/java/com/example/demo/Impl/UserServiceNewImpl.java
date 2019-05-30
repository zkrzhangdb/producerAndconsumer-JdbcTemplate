package com.example.demo.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserServiceNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.List;
import java.util.Map;

@Service(version = "${demo.service.version}")
public class UserServiceNewImpl  implements UserServiceNew {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;

    public  User findUser(Integer id){
        return userMapper.selectByPrimaryKey(id);
    }

    public List<User> getUserByPage(Map<String, Object> map){
        return userMapper.getUserByPage(map);
    }


    public  int  delUserById(Integer id){
        return userMapper.delUserById(id);

    }

    public  int  saveUser(User user){
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        int save = userMapper.saveUser(user);
        if(save > 0) {
            int userTotle = userMapper.getUserCount();
            redisTemplate.opsForValue().set("userTotle",userTotle);//存入缓存
        }
        return save;

    }


    public  int  updateUser(User user){
        int update = userMapper.updateUser(user);
        return  update;
    }

    @Override
    public int getUserCount() {
        return userMapper.getUserCount();
    }


}
