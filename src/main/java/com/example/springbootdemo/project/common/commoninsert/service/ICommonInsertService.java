package com.example.springbootdemo.project.common.commoninsert.service;

import java.util.Map;

public interface ICommonInsertService {
    /**
     * 执行插入接口
     * @param url 请求url
     * @param conditions 请求参数
     * @return 返回影响行数
     */
    int execute(String url, Map<String,String> conditions);
}
