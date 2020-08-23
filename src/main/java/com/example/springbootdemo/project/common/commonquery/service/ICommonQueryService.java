package com.example.springbootdemo.project.common.commonquery.service;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

/**
 * 万能查询接口业务层
 * @author xiaojie
 */
public interface ICommonQueryService {
    /**
     * 执行sql
     * @param url 请求url
     * @param conditions 传递参数
     * @return 结果集
     * @throws RuntimeException 当URL不正确时抛出异常
     */
    List<Map<String,Object>> execute(String url,Map<String,String> conditions) throws RuntimeException;

    /**
     * 执行多个SQL
     * @param requests  请求编码
     * @return 结果集
     * @throws UnsupportedEncodingException 编码失败时会抛出异常
     * @throws RuntimeException 找不到请求url时会抛出异常
     */
    Map<String,List<Map<String,Object>>> executeAll(String requests) throws UnsupportedEncodingException,RuntimeException;
}
