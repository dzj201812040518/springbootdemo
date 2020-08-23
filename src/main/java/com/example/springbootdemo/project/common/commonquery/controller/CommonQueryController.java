package com.example.springbootdemo.project.common.commonquery.controller;
import com.example.springbootdemo.framework.web.domain.AjaxResult;
import com.example.springbootdemo.project.common.commonquery.service.ICommonQueryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * 万能查询接口控制层
 * @author xiaojie
 */
@Controller
@RequestMapping("/commonQuery")
public class CommonQueryController {
    @Resource
    ICommonQueryService commonQueryService;
    @ResponseBody
    @PostMapping("{url}")
    public AjaxResult queryOne(@PathVariable("url")String url, @RequestParam Map<String,String> conditions){
        try {
            return AjaxResult.success(commonQueryService.execute(url,conditions));
        }catch (RuntimeException e){
            return AjaxResult.error(e.getMessage());
        }
    }

    @ResponseBody
    @PostMapping("map")
    public AjaxResult queryAll(@RequestParam String requests){
        try {
            return AjaxResult.success(commonQueryService.executeAll(requests));
        } catch (UnsupportedEncodingException | RuntimeException e) {
            return AjaxResult.error(e.getMessage());
        }


    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
