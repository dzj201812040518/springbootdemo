package com.example.springbootdemo.project.common.commonquery.controller;

import com.example.springbootdemo.framework.web.domain.AjaxResult;
import com.example.springbootdemo.project.common.commonquery.service.ICommonQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/commonQuery")
public class CommonQueryController {
    @Autowired
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
        String errormsg = "";
        try {
            return AjaxResult.success(commonQueryService.executeAll(requests));
        } catch (UnsupportedEncodingException | RuntimeException e) {
            errormsg = e.getMessage();
        }
        return AjaxResult.error(errormsg);

    }

    @RequestMapping(value = "test",method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
