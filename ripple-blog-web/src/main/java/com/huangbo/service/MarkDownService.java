package com.huangbo.service;

import com.huangbo.entity.User;
import com.huangbo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarkDownService {

    @Autowired
    UserMapper userMapper;
    public User findById(String mis){
        return userMapper.findById(mis);
    }

}
