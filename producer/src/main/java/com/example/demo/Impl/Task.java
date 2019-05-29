package com.example.demo.Impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.net.ServerSocket;
@Component
public class Task {
    @Async
    public void sayOne(){
         System.out.println("sayOne---");
    }
    @Async
    public void sayTwo(){
        System.out.println("sayTwo---");
    }
    @Async
    public void sayThree(){
        System.out.println("sayThree---");
    }
}


