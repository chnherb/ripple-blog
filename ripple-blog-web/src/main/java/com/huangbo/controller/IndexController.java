package com.huangbo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @RequestMapping("")
    @ResponseBody
    public String Index(){
        return "hello, This is RippleBlog.";
    }

}
