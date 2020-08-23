package com.example.springbootdemo.project.common.commoninsert.service;

import com.alibaba.druid.sql.visitor.functions.Char;
import com.example.springbootdemo.project.common.commoninsert.domain.CommonInsert;
import com.example.springbootdemo.project.common.commoninsert.domain.InsertField;
import com.example.springbootdemo.project.common.commoninsert.mapper.CommonInsertMapper;
import com.example.springbootdemo.project.common.commonquery.pojo.CommonQuery;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

@Service
public class CommonInsertServiceImpl implements ICommonInsertService {
    @Resource
    CommonInsertMapper commonInsertMapper;
    @Override
    public int execute(String url, Map<String, String> conditions) {
        if (StringUtils.isEmpty(url)){
            throw new RuntimeException("请求url有误，请检查参数");
        }
        CommonInsert commonInsert = commonInsertMapper.selectCommonInsertByUrl(url);
        if (conditions.size()>0){
            //数据库中获取插入接口实例
            if (commonInsert==null){
                throw new NullPointerException(String.format("未找到url:%s",url));
            }
            String sql = assembleSQL(commonInsert,conditions);
            System.out.println(sql);
//            return commonInsertMapper.executeInsert(sql);
        }
        throw new RuntimeException("没有获取到参数，请至少传入一个参数");
    }


    /**
     * 组装SQL
     * @param commonInsert 新增实例
     * @param condistions 传递参数
     * @return 返回sql
     */
    private String assembleSQL(CommonInsert commonInsert, Map<String,String> condistions){
        SQL sql = new SQL();
        //获取表名
        String table = commonInsert.getCommonInsertTable();
        //插入的表
        sql.INSERT_INTO(table);
        //组装values
        sql = assembleFieldValue(sql,commonInsert,condistions);
        Iterator<Map.Entry<String, String>> iterator = condistions.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            String fieldkey = fieldConversionProperty(Arrays.asList(entry.getKey()),true).get(0);
            String value = entry.getValue();
            sql.VALUES(fieldkey,value);
        }
        return sql.toString();
    }

    private SQL assembleFieldValue(SQL sql,CommonInsert commonInsert, Map<String,String> condistions){
        InsertField insertField;
        //字段集合
        List<InsertField> insertFieldList = new ArrayList<>();
        String[] fieldArrs = commonInsert.getCommonInsertField().split(",");
        for (String fieldArr:fieldArrs) {
            insertField = new InsertField();
            insertField.setFieldName(fieldArr.substring(0,fieldArr.indexOf(":")));
            insertField.setFieldType(fieldArr.substring(fieldArr.indexOf(":")+1));
            insertFieldList.add(insertField);
        }
        //校验合法
        Iterator<Map.Entry<String, String>> iterator = condistions.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, String> entry = iterator.next();
            String fieldkey = fieldConversionProperty(Arrays.asList(entry.getKey()),true).get(0);

            String value = entry.getValue();
        }

        return sql;
    }

    /**
     * 字段名与属性名转换
     * @param list 字段名或属性名集合
     * @param isField 为true则属性名转字段名，为false则字段名转属性名
     * @return 转换后的列表
     */
    private List<String> fieldConversionProperty(List<String> list,boolean isField){
        List<String> newList = new ArrayList<>();
        if (isField){
            for (int i = 0; i < list.size(); i++) {
                String field = list.get(i);
                char[] propchar = field.toCharArray();
                for (int j = 0; j < propchar.length; j++) {
                    if (Character.isUpperCase(propchar[j])){
                        propchar[j] = Character.toLowerCase(propchar[j]);
                        propchar = insertArr(j,'_',propchar);
                    }
                }
                newList.add(new String(propchar));
            }
        }else {
            for (int i = 0; i < list.size(); i++) {
                String[] fieldsplit = list.get(i).split("_");
                StringBuffer newProperty = new StringBuffer();
                newProperty.append(fieldsplit[0]);
                for (int j = 1; j < fieldsplit.length; j++) {
                    char[] temp = fieldsplit[j].toCharArray();
                    temp[0]=Character.toUpperCase(temp[0]);
                    newProperty.append(new String(temp));
                }
                newList.add(newProperty.toString());
            }
        }
        return newList;
    }


    public char[] insertArr(int index,char value,char[] arr){
        char[] resultArr = new char[arr.length+1];
        System.arraycopy(arr,0,resultArr,0,index);
        resultArr[index]=value;
        System.arraycopy(arr,index,resultArr,index+1,arr.length-index);
        return resultArr;
    }
}
