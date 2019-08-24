package com.huangbo.mapper;

import com.huangbo.entity.MarkDown;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MarkDownMapper {

    MarkDown findById(int id);

    int insertMarkDown(MarkDown markDown);

    int updateMarkDown(MarkDown markDown);

    int deleteMarkDown(int id);

    List<MarkDown> query(int skip, int limit);
}
