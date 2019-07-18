package com.huangbo.mapper;

import com.huangbo.entity.User;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Select;


@Repository
public interface UserMapper {

    User findById(String mis);
}
