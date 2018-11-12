package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    @ResponseBody
    public String register(User user){
        userService.register(user);
        return "register success";
    }

    @RequestMapping("/login")
    @ResponseBody
    public String login(User user){

        User login = userService.login(user);
        if(login!=null){
            return "100";
        }else{
            return "101";
        }
    }


    @RequestMapping("/update")
    @ResponseBody
    public String update(User user){
        userService.motify(user);
        return "ok!!!";
    }
}
