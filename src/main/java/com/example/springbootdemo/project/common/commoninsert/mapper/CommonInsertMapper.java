package com.example.springbootdemo.project.common.commoninsert.mapper;

import com.example.springbootdemo.project.common.commoninsert.domain.CommonInsert;
import org.apache.ibatis.annotations.Param;


/**
 * 万能新增接口数据层
 * @author xiaojie
 */
public interface CommonInsertMapper {
    int deleteByPrimaryKey(Long commonInsertId);

    int insert(CommonInsert record);

    int insertSelective(CommonInsert record);

    CommonInsert selectByPrimaryKey(Long commonInsertId);

    int updateByPrimaryKeySelective(CommonInsert record);

    int updateByPrimaryKey(CommonInsert record);

    /**
     * 执行SQL
     * @param sql sql语句
     * @return  返回结果集
     */
    int executeInsert(@Param("sql")String sql);

    /**
     * 根据URL获取查询接口
     * @param url 请求url
     * @return 返回接口实例
     */
    CommonInsert selectCommonInsertByUrl(@Param("url")String url);
}