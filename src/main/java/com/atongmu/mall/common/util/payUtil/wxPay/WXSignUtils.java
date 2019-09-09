package com.atongmu.mall.common.util.payUtil.wxPay;

import java.util.*;

/**
 * 微信支付签名
 * @author iYjrg_xiebin
 * @date 2015年11月25日下午4:47:07
 */
public class WXSignUtils {
	//http://mch.weixin.qq.com/wiki/doc/api/index.php?chapter=4_3
	//商户Key：改成公司申请的即可
	//32位密码设置地址：http://www.sexauth.com/  jdex1hvufnm1sdcb0e81t36k0d0f15nc
	private static String Key = "MQFTlWiIdi0uHioILtN8N3aBhbfyvvtT";

	/**
	 * 微信支付签名算法sign
	 * @param characterEncoding
	 * @param parameters
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static String createSign(String characterEncoding,SortedMap<Object,Object> parameters){
		StringBuffer sb = new StringBuffer();
		Set es = parameters.entrySet();//所有参与传参的参数按照accsii排序（升序）
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String)entry.getKey();
			Object v = entry.getValue();
			if(null != v && !"".equals(v)
					&& !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		sb.append("key=" + Key);
		//System.out.println("字符串拼接后是："+sb.toString());
		String sign = MD5Util.MD5Encode(sb.toString(), characterEncoding).toUpperCase();
		return sign;
	}

	public  static boolean verifyWeixinNotify(Map<Object, Object> map) {
		SortedMap<Object, Object> parameterMap = new TreeMap<Object, Object>();
		String sign = (String) map.get("sign");
		for (Object keyValue : map.keySet()) {
			if(!keyValue.toString().equals("sign")){
				parameterMap.put(keyValue.toString(), map.get(keyValue));
			}
		}
		String createSign =createSign("UTF-8", parameterMap);
		if(createSign.equals(sign)){
			return true;
		}else{
			return false;
		}

	}



}
