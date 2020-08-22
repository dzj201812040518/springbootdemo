package com.example.springbootdemo.project.commonquery.mapper;

import com.example.springbootdemo.project.commonquery.pojo.CommonQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommonQueryMapper {
    int deleteByPrimaryKey(Long commonQueryId);

    int insert(CommonQuery record);

    int insertSelective(CommonQuery record);

    CommonQuery selectByPrimaryKey(Long commonQueryId);

    int updateByPrimaryKeySelective(CommonQuery record);

    int updateByPrimaryKey(CommonQuery record);

    /**
     * 执行SQL
     * @param sql sql语句
     * @return  返回结果集
     */
    List<Map<String,Object>> executeQuery(@Param("sql")String sql);

    /**
     * 根据URL获取查询接口
     * @param url
     * @return
     */
    CommonQuery selectCommonQueryByUrl(@Param("url")String url);
}