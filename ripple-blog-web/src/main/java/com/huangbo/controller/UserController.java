package com.huangbo.controller;

import com.huangbo.dto.ResponseDTO;
import com.huangbo.entity.User;
import com.huangbo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/getAuthor")
    @ResponseBody
    public ResponseDTO getAuthor(){
        ResponseDTO responseDTO = new ResponseDTO();
        User user = null;
        try {
            user = userService.findById("huangbo");
        } catch (Exception e){
            log.error("fail to get userInfo. ", e);
            responseDTO.setCode(500);
            responseDTO.setMsg("获取用户数据失败");
            return responseDTO;
        }
        responseDTO.setCode(200);
        responseDTO.setData(user);
        return responseDTO;
    }
}
