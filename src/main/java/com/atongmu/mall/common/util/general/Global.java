package com.atongmu.mall.common.util.general;

/**
 * @program: mall
 * @description: 公共常量
 * @author: Hus
 * @create: 2018-12-21 09:26
 */
public class Global {

    // CDN https 加速域名
    public final static String CDN = "https://image.atongmu.net";

    // ATM https 服务入口地址
    public final static String ATM_SERVER = "https://www.atongmu.net:8443/backwork";

    // ATM http 服务入口地址
    public final static String WEB_SERVER = "http://www.atongmu.net:10010/backwork";

    // 支付宝支付回调接口相对地址
    public final static String ALIPAY_CALLBACK_URL = ATM_SERVER + "/mall/mallManagement/restPayReceiveAPayNotify";

    // 微信支付回调接口相对地址
    public final static String WXPAY_CALLBACK_URL = ATM_SERVER + "/mall/mallManagement/restPayReceiveWeiXinNotify";

    // 微信支付
    public final static String WXPAY_NAME = "wxpay";

    // 支付宝支付
    public final static String ALIPAY_NAME = "alipay";

    public static final String ELECTRONIC = "electronic";

    public static final String PAPER = "paper";

    public static final String PERSON = "person";

    public static final String COMPANY = "company";

}