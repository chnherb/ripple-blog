package com.huangbo.controller;

import com.huangbo.dto.ResponseDTO;
import com.huangbo.entity.MarkDown;
import com.huangbo.service.MarkDownService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/api/md")
public class MarkDownController {

    @Autowired
    private MarkDownService markDownService;


    @RequestMapping("/{id}")
    @ResponseBody
    public ResponseDTO findById(@PathVariable(value = "id") Integer id) {
        ResponseDTO responseDTO = new ResponseDTO();
        MarkDown markDown = null;
        try{
            markDown = markDownService.findById(id);
        }catch(Exception e){
            log.error("fail to get markdown, id = [{}]. ", id, e);
            responseDTO.setCode(500);
            responseDTO.setMsg("获取markdown失败");
            return responseDTO;
        }

        responseDTO.setCode(200);
        responseDTO.setData(markDown);
        return responseDTO;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResponseDTO insertMarkDown(@RequestBody MarkDown markDown) {
        ResponseDTO responseDTO = new ResponseDTO();
        int res = -1;
        try {
            res = markDownService.insertMarkDown(markDown);
        } catch (Exception e) {
            log.error("fail to insert md, md=[{}]. ", markDown, e);
            responseDTO.setCode(500);
            responseDTO.setMsg("提交数据失败");
        }
        responseDTO.setCode(res == 1 ? 200 : 500);
        responseDTO.setData(res);
        responseDTO.setMsg(res == 1 ? "提交数据成功！" : "提交数据失败");
        return responseDTO;
    }

    @RequestMapping("/update")
    @ResponseBody
    public ResponseDTO updateById(@RequestBody MarkDown markDown) {
        ResponseDTO responseDTO = new ResponseDTO();
        int res = -1;
        try{
            res = markDownService.updateMarkDown(markDown);
        }catch(Exception e){
            log.error("fail to update markdown, md = [{}]. ", markDown, e);
            responseDTO.setCode(500);
            responseDTO.setMsg("更新markdown失败");
            return responseDTO;
        }

        responseDTO.setCode(res == 1 ? 200 : 500);
        responseDTO.setData(res);
        responseDTO.setMsg(res == 1 ? "更新数据成功" : "更新数据失败");
        return responseDTO;
    }

    @RequestMapping("/query")
    @ResponseBody
    public ResponseDTO query(@RequestBody Map<String, Integer> params) {
        ResponseDTO responseDTO = new ResponseDTO();
        if (null == params || null == params.get("skip") || null == params.get("limit")){
            responseDTO.setCode(500);
            responseDTO.setMsg("参数错误");
        }
        int skip = params.get("skip");
        int limit = params.get("limit");
        List<MarkDown> markDownList = null;
        try{
            markDownList = markDownService.query(skip, limit);
        }catch(Exception e){
            log.error("fail to query markdown list, skip = [{}], limit = [{}] ", skip, limit, e);
            responseDTO.setCode(500);
            responseDTO.setMsg("获取列表失败");
            return responseDTO;
        }

        responseDTO.setCode(markDownList.size() > 0 ? 200 : 500);
        responseDTO.setData(markDownList);
        responseDTO.setMsg(markDownList.size() > 0 ? "获取列表成功" : "获取列表失败");
        return responseDTO;
    }
}
