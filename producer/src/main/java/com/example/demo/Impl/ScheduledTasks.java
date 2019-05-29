package com.example.demo.Impl;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Component
public class ScheduledTasks {
    @Scheduled(fixedRate = 5000)
    public   void  getCuurentDate(){
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前时间:"+localDateTime);
    }
}
