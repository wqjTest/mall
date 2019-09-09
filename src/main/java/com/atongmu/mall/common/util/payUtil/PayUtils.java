package com.atongmu.mall.common.util.payUtil;

import com.atongmu.mall.common.util.general.Global;
import com.atongmu.mall.common.util.general.MathUtil;
import com.atongmu.mall.common.util.payUtil.alipay.AlipayConfig;
import com.atongmu.mall.common.util.payUtil.alipay.OrderUtils;
import com.atongmu.mall.common.util.payUtil.wxPay.*;
import com.atongmu.mall.common.util.sign.RSA;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @program: mall
 * @description: 支付宝微信支付订生成
 * @author: Hus
 * @create: 2018-12-27 10:48
 */
public class PayUtils {

    /**
     * 创建支付订单
     *
     * */
    public static PayResult createPayOrder(String payType, String orderCode, BigDecimal price){
        PayResult payResult = new PayResult();
        if(Global.ALIPAY_NAME.equals(payType)){
            payResult = PayUtils.createALiPayOrder(orderCode, price);
        } else {
            payResult = PayUtils.createWXPayOrder(orderCode, price);
        }
        return payResult;
    }

    /**
     * 创建支付宝支付订单
     *
     * */
    @SuppressWarnings("Duplicates")
    private static PayResult createALiPayOrder(String orderCode, BigDecimal price){

        PayResult result = new PayResult();

        //支付宝回调接口
        String reUrl = Global.ALIPAY_CALLBACK_URL;
        String orderInfo = OrderUtils.getOrderInfo(
                "阿童目商场", "商品",
                price.toEngineeringString(), reUrl, orderCode);

        String sign = RSA.sign(orderInfo, AlipayConfig.ali_private_key, "utf-8");
        try {
            //仅需对sign 做URL编码
            sign = URLEncoder.encode(sign, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            result.setPayType("");
            result.setAliData("");
            result.setStatus("success");
            result.setMessage("");
            return result;
        }

        // 完整的符合支付宝参数规范的订单信息
        final String payInfo = orderInfo + "&sign=\"" + sign + "\"&" + "sign_type=\"RSA\"";

        // 返回支付宝订单号
        result.setPayType(Global.ALIPAY_NAME);
        result.setAliData(payInfo);
        result.setStatus("success");
        result.setMessage("");
        return result;
    }

    /**
     * 创建微信支付订单
     * */
    @SuppressWarnings("Duplicates")
    private static PayResult createWXPayOrder(String orderCode, BigDecimal price){

        PayResult result = new PayResult();

        InetAddress netAddress = null;
        String ip = "127.0.0.1";
        try {
            netAddress = InetAddress.getLocalHost();
            ip = netAddress.getHostAddress();
        } catch (UnknownHostException e) {
            //results.put("status", "fail");
            //results.put("message", "订单生成失败");
            //return results;
        }
        /// 微信支付成功回调接口
        String reUrl = Global.WXPAY_CALLBACK_URL;
        String appid = WeiXinConfig.appid;
        String mch_id = WeiXinConfig.mch_id;
        String nonce_str = RandCharsUtils.getRandomString(16);
        String body = "阿童目商城";
        String detail = "商品";
        String attach = "";
        String out_trade_no = orderCode;
        int total_fee = MathUtil.priceTimesQuantity(price,100).intValue();
        String spbill_create_ip = ip;
        String time_start = RandCharsUtils.timeStart();
        String time_expire = RandCharsUtils.timeExpire();
        String notify_url = reUrl;
        String trade_type = "APP";

        //参数：开始生成签名
        SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
        parameters.put("appid", appid);
        parameters.put("mch_id", mch_id);
        parameters.put("nonce_str", nonce_str);
        parameters.put("body", body);
        parameters.put("nonce_str", nonce_str);
        parameters.put("detail", detail);
        parameters.put("attach", attach);
        parameters.put("out_trade_no", out_trade_no);
        parameters.put("total_fee", total_fee);
        parameters.put("time_start", time_start);
        parameters.put("time_expire", time_expire);
        parameters.put("notify_url", notify_url);
        parameters.put("trade_type", trade_type);
        parameters.put("spbill_create_ip", spbill_create_ip);
        String sign = WXSignUtils.createSign("UTF-8", parameters);

        Unifiedorder unifiedorder = new Unifiedorder();
        unifiedorder.setAppid(appid);
        unifiedorder.setMch_id(mch_id);
        unifiedorder.setNonce_str(nonce_str);
        unifiedorder.setSign(sign);
        unifiedorder.setBody(body);
        unifiedorder.setDetail(detail);
        unifiedorder.setAttach(attach);
        unifiedorder.setOut_trade_no(out_trade_no);
        unifiedorder.setTotal_fee(total_fee);
        unifiedorder.setSpbill_create_ip(spbill_create_ip);
        unifiedorder.setTime_start(time_start);
        unifiedorder.setTime_expire(time_expire);
        unifiedorder.setNotify_url(notify_url);
        unifiedorder.setTrade_type(trade_type);

        // 构造xml参数
        String xmlInfo = HttpXmlUtils.xmlInfo(unifiedorder);
        String wxUrl = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        String method = "POST";
        String weixinPost = HttpXmlUtils.httpsRequest(wxUrl, method, xmlInfo).toString();

        UnifiedorderResult rItem = new UnifiedorderResult();
        rItem = ParseXMLUtils.jdomParseXml(weixinPost);

        if (rItem.getPrepay_id() == null || rItem.getPrepay_id().equals("")) {
            result.setPayType("");
            result.setWexData("");
            result.setStatus("success");
            result.setMessage("");
            return result;
        }
        Date date = new Date();
        java.sql.Timestamp dateTime = new java.sql.Timestamp(date.getTime());
        SortedMap<Object, Object> parameter2s = new TreeMap<Object, Object>();
        parameter2s.put("appid", rItem.getAppid());
        parameter2s.put("noncestr", rItem.getNonce_str());
        parameter2s.put("package", "Sign=WXPay");
        parameter2s.put("partnerid", rItem.getMch_id());
        parameter2s.put("prepayid", rItem.getPrepay_id());
        long sqlLastTime = dateTime.getTime();
        parameter2s.put("timestamp", sqlLastTime);
        String sign2 = WXSignUtils.createSign("UTF-8", parameter2s);

        //返回给调用者
        WeChatPayResult item = new WeChatPayResult();
        item.setAppid(rItem.getAppid());
        item.setPartnerid(rItem.getMch_id());
        item.setPackageDesc("Sign=WXPay");
        item.setNoncestr(rItem.getNonce_str());
        item.setTimestamp(sqlLastTime);
        item.setPrepayid(rItem.getPrepay_id());
        item.setSign(sign2);

        result.setPayType(Global.WXPAY_NAME);
        result.setWexData(item);
        result.setStatus("success");
        result.setMessage("");
        return result;
    }

}