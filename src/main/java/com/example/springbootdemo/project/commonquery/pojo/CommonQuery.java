package com.example.springbootdemo.project.commonquery.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * common_query
 * @author 
 */
public class CommonQuery implements Serializable {
    /**
     * 查询接口id
     */
    private Long commonQueryId;

    /**
     * 请求URL
     */
    private String commonQueryUrl;

    /**
     * 查询SQL
     */
    private String commonQuerySql;

    /**
     * SQL条件
     */
    private String commonQueryConditions;

    /**
     * SQL条件之后的附加条件
     */
    private String commonQueryAdditional;

    /**
     * 删除标志（1删除）
     */
    private String delFlag;

    /**
     * 创建人
     */
    private String createby;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 更新人
     */
    private String updateby;

    /**
     * 更新时间
     */
    private Date updatetime;

    /**
     * 描述
     */
    private String description;

    private static final long serialVersionUID = 1L;

    public Long getCommonQueryId() {
        return commonQueryId;
    }

    public void setCommonQueryId(Long commonQueryId) {
        this.commonQueryId = commonQueryId;
    }

    public String getCommonQueryUrl() {
        return commonQueryUrl;
    }

    public void setCommonQueryUrl(String commonQueryUrl) {
        this.commonQueryUrl = commonQueryUrl;
    }

    public String getCommonQuerySql() {
        return commonQuerySql;
    }

    public void setCommonQuerySql(String commonQuerySql) {
        this.commonQuerySql = commonQuerySql;
    }

    public String getCommonQueryConditions() {
        return commonQueryConditions;
    }

    public void setCommonQueryConditions(String commonQueryConditions) {
        this.commonQueryConditions = commonQueryConditions;
    }

    public String getCommonQueryAdditional() {
        return commonQueryAdditional;
    }

    public void setCommonQueryAdditional(String commonQueryAdditional) {
        this.commonQueryAdditional = commonQueryAdditional;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}