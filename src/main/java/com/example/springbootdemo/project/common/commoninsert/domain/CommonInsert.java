package com.example.springbootdemo.project.common.commoninsert.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * common_insert 万能新增接口实体层
 * @author xiaojie
 */
public class CommonInsert implements Serializable {
    /**
     * 新增接口id
     */
    private Long commonInsertId;

    /**
     * 请求URL
     */
    private String commonInsertUrl;

    /**
     * 新增字段
     */
    private String commonInsertField;

    /**
     * 插入表名
     */
    private String commonInsertTable;

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

    public Long getCommonInsertId() {
        return commonInsertId;
    }

    public void setCommonInsertId(Long commonInsertId) {
        this.commonInsertId = commonInsertId;
    }

    public String getCommonInsertUrl() {
        return commonInsertUrl;
    }

    public void setCommonInsertUrl(String commonInsertUrl) {
        this.commonInsertUrl = commonInsertUrl;
    }

    public String getCommonInsertField() {
        return commonInsertField;
    }

    public void setCommonInsertField(String commonInsertField) {
        this.commonInsertField = commonInsertField;
    }

    public String getCommonInsertTable() {
        return commonInsertTable;
    }

    public void setCommonInsertTable(String commonInsertTable) {
        this.commonInsertTable = commonInsertTable;
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