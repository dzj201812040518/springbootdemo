package com.example.springbootdemo.project.student.domain;

import java.io.Serializable;

/**
 * 学生表(Student)实体类
 *
 * @author xiaojie xiaojie
 * @since 2020-08-22 13:33:19
 */
public class Student implements Serializable {
    private static final long serialVersionUID = -81361763297673458L;
    /**
     * 学生编号
     */
    private String sId;
    /**
     * 学生姓名
     */
    private String sName;
    /**
     * 出生年月
     */
    private String sBirth;
    /**
     * 学生性别
     */
    private String sSex;


    public String getSId() {
        return sId;
    }

    public void setSId(String sId) {
        this.sId = sId;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getSBirth() {
        return sBirth;
    }

    public void setSBirth(String sBirth) {
        this.sBirth = sBirth;
    }

    public String getSSex() {
        return sSex;
    }

    public void setSSex(String sSex) {
        this.sSex = sSex;
    }

}