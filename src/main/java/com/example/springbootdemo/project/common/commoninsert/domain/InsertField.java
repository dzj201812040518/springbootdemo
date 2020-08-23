package com.example.springbootdemo.project.common.commoninsert.domain;

import java.io.Serializable;

/**
 * 要插入的字段
 * @author xiaojie
 */
public class InsertField implements Serializable {
    private static final long serialVersionUID = 2219110794506986760L;
    /**
     * 字段名
     */
    private String fieldName;
    /**
     * 字段值
     */
    private String fieldValue;
    /**
     * 字段类型
     */
    private String fieldType;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public InsertField() {
    }

    public InsertField(String fieldName, String fieldValue, String fieldType) {
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
        this.fieldType = fieldType;
    }
}
