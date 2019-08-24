package com.huangbo.service;

import com.huangbo.entity.MarkDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MarkDownServiceTest {

    @Autowired
    private MarkDownService markDownService;

    @Test
    public void insertMarkDown() {
        MarkDown markDown = new MarkDown();
        markDown.setTitle("test1");
        markDown.setContent("content2");
        System.out.println(markDown.getContent());
        int res = markDownService.insertMarkDown(markDown);
        System.out.println(res);
    }

    @Test
    public void deleteMarkDown() {
        int id = 9;
        int res = markDownService.deleteMarkDown(id);
        System.out.println(res);
    }

    @Test
    public void query(){
        int skip = 3;
        int limit = 5;
        List<MarkDown> list = markDownService.query(skip, limit);
        System.out.println(list.toString());
    }
}