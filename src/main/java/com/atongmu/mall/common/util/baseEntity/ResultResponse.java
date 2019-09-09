package com.atongmu.mall.common.util.baseEntity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: mall
 * @description: 统一返回类
 * @author: Hus
 * @create: 2018-12-12 17:03
 */
@Data
public class ResultResponse<T> implements Serializable{

    private static final long serialVersionUID = -8788393100374572557L;

    private Integer code;
    private String msg;
    private T data;

    /*
    * 成功
    * */
    public ResultResponse() {
        this.code = 0;
        this.msg = "success";
    }


    /*
    * 自定义
    * */
    public ResultResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    /*
    * 成功并返回有数据
    * */
    public ResultResponse(T data) {
        this.data = data;
        this.code = 0;
        this.msg = "success";
    }


    /*
    * 自定义带数据的返回
    * */
    public ResultResponse(T data, String msg) {
        this.data = data;
        this.code = 0;
        this.msg = msg;
    }

}