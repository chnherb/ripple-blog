package com.huangbo.mapper;

import com.huangbo.entity.User;
import org.springframework.stereotype.Repository;


@Repository
public interface MarkDownMapper {

    User findById(String mis);
}
