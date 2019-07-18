package com.huangbo.controller;

import com.huangbo.entity.User;
import com.huangbo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAuthor")
    @ResponseBody
    public User getAuthor(){
        return userService.findById("huangbo");
    }
}
