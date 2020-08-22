package com.example.springbootdemo.project.commonquery.controller;

import com.example.springbootdemo.project.commonquery.service.ICommonQueryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/commonQuery")
public class CommonQueryController {
    @Autowired
    ICommonQueryService commonQueryService;
    @ResponseBody
    @PostMapping("{url}")
    public List<Map<String, Object>> test(@PathVariable("url")String url, Map<String,String> conditions){
        List<Map<String, Object>> result = commonQueryService.execute(url,conditions);
        return result;
    }
}
