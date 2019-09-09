package com.atongmu.mall.common.util.payUtil.alipay;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”
 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */
public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088421545378269";
	
	// 支付宝的公钥，无需修改该值
	public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCh1uPkLdRviiQhMPBVzOqvrybtckef1dgsoLZbTKj09Si23ndqYhtWahd8ntFLmSQr5QLE5slY8Fdd5psL0mcaZK1aZvmB5NLsjK/UVch3MxHAxfa+IobopuEDTo6eLMTUb+v5G9NvEqDRzgBqq8n8/DQVx5+ELFPxmhDw/iM1/wIDAQAB";
	public static String ali_private_key ="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKHW4+Qt1G+KJCEw8FXM6q+vJu1yR5/V2CygtltMqPT1KLbed2piG1ZqF3ye0UuZJCvlAsTmyVjwV13mmwvSZxpkrVpm+YHk0uyMr9RVyHczEcDF9r4ihuim4QNOjp4sxNRv6/kb028SoNHOAGqryfz8NBXHn4QsU/GaEPD+IzX/AgMBAAECgYABhg1lM41Bc5J9gYFxvVkkSEjciWvlNFUxrl2pJGKe08QLXLLRHJVXTe5krPYZeRqfEyvggK+6l6Cq8KXbCaMQ17WeFlnGbVvYJy3kgzQctt3tZhvmhg6wmXZKYlZH2RhV2MzKxlWjJHKY9xxXUSpdKhPAH8Q1d2fsAV79xxWyQQJBANUakp+pvXVb2IlD5rzKJ+DYcvgsQ3Fy7tvRm+F6KJnYNgteBLvTVaNeBoUJjn8h1yb7mg75AGNt3+3Nd7VQ9eECQQDCap5M+FA0b2W9spdBmlmz4GcZLjXVgGjtIOTiOU8/CUWLtLe+2BHuVOD7P7T2b5VCyt0CyAakObXbJl5In+ffAkADqHod3YcQDayQ5qZ+VSYMGQsYMYJS3zs0cMuxOiyaP3jmBw4jv0P4EvQfsoNMsWMFG0qQuTuFeWxfo6hLZ4FhAkEAkVXiwOdgDdK42/aF3CTmqfE3ITvKQrCbv6i3ceYlt5nWw3l1YtVjkichiLE3NoJzslq0nT+qt1ns+MbV9LSVQQJBAM5j6IudBgUWESTkYamAfzU5OWQAQW6PktJzgHfVGt03XnPfqf3bqS95ZO2FfdNk9757IO9ICXX4fcM/buDjX+k=";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	// 调试用，创建TXT日志文件夹路径
	public static String log_path = "c:\\";

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "RSA";

	// 签名方式 不需修改
	public static String Seller = "jinbo.dong@atongmu.net";

	// 接口名称 服务地址Service
	public static String service = "create_direct_pay_by_user";

	// 支付类型 暂时支持取1，商品购买
	public static String payment_type = "1";

	//防钓鱼时间戳 通过时间戳查询接口获取的加密支付宝系统时间戳。如果已申请开通防钓鱼时间戳验证，则此字段必填。
	public static String anti_phishing_key = "";

	//客户端IP 用户在创建交易时，该用户当前所使用机器的IP。如果商户申请后台开通防钓鱼IP地址检查选项，此字段必填，校验用。
	public static String exter_invoke_ip = "";

}