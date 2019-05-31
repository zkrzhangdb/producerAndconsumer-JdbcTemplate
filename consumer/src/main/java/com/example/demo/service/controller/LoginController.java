package com.example.demo.service.controller;

        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.context.annotation.RequestScope;
@Controller
public class LoginController {
    @RequestMapping("/login")
    public  String  login(){
        return  "login";
    }
}