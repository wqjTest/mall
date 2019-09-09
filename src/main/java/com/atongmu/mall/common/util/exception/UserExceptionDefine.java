package com.atongmu.mall.common.util.exception;

/**
 * @program: mall
 * @description: 用户异常处理
 * @author: Hus
 * @create: 2018-12-19 13:48
 */
public class UserExceptionDefine extends Throwable {

    /**
     *
     */
    private static final long serialVersionUID = 6044363852319867769L;

    public UserExceptionDefine(String msg) {
        super(msg);
    }

}