package com.example.springbootdemo.project.commonquery.service;

import com.example.springbootdemo.project.commonquery.mapper.CommonQueryMapper;
import com.example.springbootdemo.project.commonquery.pojo.CommonQuery;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
public class CommonQueryServiceImpl implements ICommonQueryService{
    @Resource
    CommonQueryMapper commonQueryMapper;


    @Override
    public List<Map<String, Object>> execute(String url, Map<String, String> conditions) {
        CommonQuery commonQuery = commonQueryMapper.selectCommonQueryByUrl(url);
        if (commonQuery==null){
            throw new NullPointerException(String.format("找不到此方法:%s",url));
        }
        String sql = assembleSQL(commonQuery,conditions);
        return commonQueryMapper.executeQuery(sql);
//        return null;
    }

    /**
     * 组装sql
     * @param commonQuery 查询接口实例
     * @param condistions 传递参数
     * @return 返回sql语句
     */
    private static String assembleSQL(CommonQuery commonQuery,Map<String,String> condistions){
        SQL sql = new SQL();
        String sqlbody = commonQuery.getCommonQuerySql();
        //加入主体SQL
        sql.SELECT("*").FROM("("+sqlbody+") temp");
        //获取数据库中SQL条件
        String sqlcondition = commonQuery.getCommonQueryConditions();
        //获取数据库中SQL附加条件
        String sqladdition = commonQuery.getCommonQueryAdditional();
        if (sqlcondition!=null&&!sqladdition.equals("")){
            //获取传递参数
            Iterator<Map.Entry<String, String>> iterator = condistions.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> entry = iterator.next();
                String key = entry.getKey();
                String value = entry.getValue();
                sqlcondition = sqlcondition.replaceAll("\\{"+key+"}",value);
            }
            //将没有传过来的SQL过滤掉
            sqladdition = dynamicConditions(sqladdition);
            sql.WHERE(sqlcondition);
        }
        return sql.toString().concat(sqladdition!=null&&!sqladdition.equals("")?sqladdition:"");
    }


    private static String dynamicConditions(String conditions){
        return conditions;
    }
}
