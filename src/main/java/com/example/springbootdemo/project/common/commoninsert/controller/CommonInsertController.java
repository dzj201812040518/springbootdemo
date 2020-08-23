package com.example.springbootdemo.project.common.commoninsert.controller;

import com.example.springbootdemo.framework.web.domain.AjaxResult;
import com.example.springbootdemo.project.common.commoninsert.service.ICommonInsertService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 万能新增接口控制层
 * @author xiaojie
 */
@Controller
@RequestMapping("/commonInsert")
public class CommonInsertController {
    @Resource
    ICommonInsertService commonInsertService;
    @ResponseBody
    @PostMapping("{url}")
    public AjaxResult queryOne(@PathVariable("url")String url, @RequestParam Map<String,String> conditions){
        try {
            return AjaxResult.success(commonInsertService.execute(url,conditions));
        }catch (RuntimeException e){
            return AjaxResult.error(e.getMessage());
        }
    }
}
