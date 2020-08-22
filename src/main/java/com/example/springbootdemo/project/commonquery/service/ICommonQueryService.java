package com.example.springbootdemo.project.commonquery.service;

import java.util.List;
import java.util.Map;

public interface ICommonQueryService {
    /**
     * 执行sql
     * @param url 请求URL
     * @param conditions 传递参数
     * @return 返回结果集
     */
    List<Map<String,Object>> execute(String url,Map<String,String> conditions);
}
