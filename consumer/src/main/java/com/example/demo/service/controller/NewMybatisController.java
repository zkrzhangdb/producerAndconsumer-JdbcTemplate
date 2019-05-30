
package com.example.demo.service.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.example.demo.entity.User;
import com.example.demo.service.MybatisService;
import com.example.demo.service.UserServiceNew;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NewMybatisController {

    @Reference(version="${demo.service.version}")
    private UserServiceNew userServiceNew;

    @RequestMapping("/findById/{id}")
    public User findByName(@PathVariable(value = "id")  Integer id ){

        return    userServiceNew.findUser(Integer.valueOf(id));
    }

    @RequestMapping("/index")
    public String toIndex(@RequestParam(value = "curPage",required = false) Integer curPage, Model model){
        int pageSize = 6;//煤业显示数量
        if(curPage == null){
            curPage = 1;
        }
        //总数
        // int totle =  userServiceNew.getUserTotle();
        int totle=5;
        //计算分页
        int totlePage = totle / pageSize;
        //有可能有余数
        int left = totle % pageSize;
        if(left > 0) {
            totlePage +=1;
        }
        if(curPage < 1){
            curPage = 1;
        }
        if(curPage > totlePage){
            curPage = totlePage;
        }

        Map<String,Object> map = new HashMap<String,Object>();
        //计算查询的开始行
        int page = (curPage - 1) * pageSize;
        map.put("page",page);
        map.put("pageSize",pageSize);
        List<User> userList = userServiceNew.getUserByPage(map);
        model.addAttribute("userList",userList);
        model.addAttribute("curPage",curPage);
        model.addAttribute("totlePage",totlePage);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("totle",totle);
        System.out.println(userList);
        //跳转到模板页面
        return "index";
    }


    @RequestMapping("user/deleteUser")
    public  String  deleteUser(@RequestParam(value = "id")  Integer id ){
        userServiceNew.delUserById(1);
        return  "redirect:/index";
    }



}


