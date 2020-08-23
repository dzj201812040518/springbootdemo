package com.example.springbootdemo.project.common.commonquery.service;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.project.common.commonquery.mapper.CommonQueryMapper;
import com.example.springbootdemo.project.common.commonquery.pojo.CommonQuery;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 万能查询接口业务实现层
 * @author xiaojie
 */
@Service
public class CommonQueryServiceImpl implements ICommonQueryService{
    @Resource
    CommonQueryMapper commonQueryMapper;


    @Override
    public List<Map<String, Object>> execute(String url, Map<String, String> conditions) throws RuntimeException{
        if (StringUtils.isEmpty(url)){
            throw new RuntimeException("请求url有误，请检查参数");
        }
        CommonQuery commonQuery = commonQueryMapper.selectCommonQueryByUrl(url);
        if (commonQuery==null){
            throw new NullPointerException(String.format("未找到url:%s",url));
        }
        String sql = assembleSQL(commonQuery,conditions);
        return commonQueryMapper.executeQuery(nowToCurrentSystemTime(sql));
    }

    @Override
    public Map<String, List<Map<String, Object>>> executeAll(String requests) throws UnsupportedEncodingException,RuntimeException {
        Map<String, List<Map<String, Object>>> results = new HashMap<String, List<Map<String, Object>>>();
        //解码
        String data = URLDecoder.decode(requests,"UTF-8");
        for (Object object:JSONObject.parseArray(data)) {
            Map<String,Object> json = (Map<String,Object>)object;
            //加入结果集
            results.put((String) json.get("url"),execute((String) json.get("url"), (Map<String, String>) json.get("condition")));
        }
        return results;
    }

    /**
     * 组装sql
     * @param commonQuery 查询接口实例
     * @param condistions 传递参数
     * @return 返回sql语句
     */
    private String assembleSQL(CommonQuery commonQuery,Map<String,String> condistions){
        SQL sql = new SQL();
        String sqlbody = commonQuery.getCommonQuerySql();
        //拼接主体SQL
        sql.SELECT("*").FROM("("+sqlbody+") temp ");
        //拼接SQL条件
        if (!StringUtils.isEmpty(condistions)){
            if (condistions.size()>0){
                String sqlcondition = conditionSpecification(commonQuery.getCommonQueryConditions());
                if (!StringUtils.isEmpty(sqlcondition)){
                    //获取传递参数
                    Iterator<Map.Entry<String, String>> iterator = condistions.entrySet().iterator();
                    while (iterator.hasNext()){
                        Map.Entry<String, String> entry = iterator.next();
                        String key = entry.getKey();
                        String value = entry.getValue();
                        sqlcondition = sqlcondition.replaceAll("\\{"+key+"}",value);
                    }
                    //将没有传过来的SQL过滤掉
                    sqlcondition = dynamicConditions(sqlcondition);
                    if (!StringUtils.isEmpty(sqlcondition)){
                        sql.WHERE(sqlcondition);
                    }
                }
            }
        }
        //拼接SQL附加条件
        String sqladdition = StringUtils.isEmpty(commonQuery.getCommonQueryAdditional())?"":" "+commonQuery.getCommonQueryAdditional();
        return sql.toString().concat(sqladdition);
    }

    /**
     * SQL条件过滤
     * @author xiaojie
     * @param conditions SQL条件
     * @return 返回参数为不为空的的SQL条件
     */
    private String dynamicConditions(String conditions){
        String elements = conditions.replaceAll(" OR ",", OR ").replaceAll(" AND ",", AND ");
        StringBuffer result = new StringBuffer();
        List<String> conditionList = new ArrayList<String>(Arrays.asList(elements.split(",")));
        for (String condition:conditionList) {
            if (condition.indexOf("{")<0){
                result.append(condition);
            }
        }
        String res = result.toString().trim();
        if (res.startsWith("AND")){
            res = res.substring(3);
        }else if(res.startsWith("OR")){
            res = res.substring(2);
        }
        return res;
    }

    /**
     * 万能SQL日期处理，将NOW()函数替换为当前服务器时间
     * @param sql sql语句
     * @return 处理后的sql语句
     */
    private String nowToCurrentSystemTime(String sql){
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        String currentSystemTime = dateFormat.format(calendar.getTime());
        return sql.replaceAll("NOW\\(\\)",String.format("TIMESTAMP('%s')",currentSystemTime));
    }

    /**
     * sql条件规范，会将所有字符小写，将关键字转大写，关键字需要维护
     * @param conditions sql条件
     * @return  规范好的sql条件
     */
    private String conditionSpecification(String conditions){
        if (!StringUtils.isEmpty(conditions)){
            List<String> keywordList = Arrays.asList("and","or","not","in","like");
            conditions = conditions.toLowerCase();
            for (String keyword:keywordList) {
                conditions =  conditions.replaceAll(keyword.toLowerCase(),keyword.toUpperCase());
            }
        }
        return conditions;
    }
}
