package com.example.springbootdemo.framework.web.domain;

import com.example.springbootdemo.framework.constants.AjaxResultConstants;

import java.util.HashMap;

/**
 * 结果集
 * @author xiaojie
 */
public class AjaxResult extends HashMap<String,Object> {
    private static final long serialVersionUID = -568302335505206398L;

    private AjaxResult(int code, String msg, Object data) {
        this.put(AjaxResultConstants.AJAX_CODE_VAR,code);
        this.put(AjaxResultConstants.AJAX_MSG_VAR,msg);
        this.put(AjaxResultConstants.AJAX_DATA_VAR,data);
    }

    private AjaxResult(int code, String msg) {
        this.put(AjaxResultConstants.AJAX_CODE_VAR,code);
        this.put(AjaxResultConstants.AJAX_MSG_VAR,msg);
    }

    /**
     * 请求成功，默认消息
     * @param data 返回数据
     * @return 返回信息
     */
    public static AjaxResult success(Object data){

        return new AjaxResult(AjaxResultConstants.AJAX_SUCCESS_CODE, AjaxResultConstants.AJAX_SUCCESS_MSG,data);
    }

    /**
     * 请求失败，默认消息
     * @return 结果集
     */
    public static AjaxResult error(){
        return new AjaxResult(AjaxResultConstants.AJAX_FAIL_CODE,AjaxResultConstants.AJAX_FAIL_MSG);
    }

    /**
     * 请求失败，自定义消息
     * @param msg 消息
     * @return 结果集
     */
    public static AjaxResult error(String msg){
        return new AjaxResult(AjaxResultConstants.AJAX_FAIL_CODE,msg);
    }
}
