package com.example.demo.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;


@Service(version ="${demo.service.version}" )
public class RedisServiceImpl implements RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public  String  addAndgetKey(String value){
        stringRedisTemplate.opsForValue().set("name",value);
        if(stringRedisTemplate.opsForValue().get("name").equals(value)){

            return  "redis添加成功";
        }else {
            return  "redis添加失败";
        }


    }



}
