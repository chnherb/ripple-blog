package com.huangbo.service;

import com.huangbo.entity.MarkDown;
import com.huangbo.mapper.MarkDownMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkDownService {

    @Autowired
    MarkDownMapper markDownMapper;

    public MarkDown findById(int id) {
        return markDownMapper.findById(id);
    }

    public int insertMarkDown(MarkDown markDown) {
        return markDownMapper.insertMarkDown(markDown);
    }

    public int updateMarkDown(MarkDown markDown) {
        return markDownMapper.updateMarkDown(markDown);
    }

    public int deleteMarkDown(int id) {
        return markDownMapper.deleteMarkDown(id);
    }

    public List<MarkDown> query(int skip, int limit) {
        return markDownMapper.query(skip, limit);
    }
}
