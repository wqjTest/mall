package com.atongmu.mall.common.util.payUtil.wxPay;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ParseXMLUtils {

	/**
	 * 1、DOM解析
	 */
	@SuppressWarnings("rawtypes")
	public static void beginXMLParse(String xml){
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element rootElt = doc.getRootElement(); // 获取根节点smsReport
			//System.out.println("根节点是："+rootElt.getName());
			Iterator iters = rootElt.elementIterator("sendResp"); // 获取根节点下的子节点sms
			while (iters.hasNext()) {
				Element recordEle1 = (Element) iters.next();
				Iterator iter = recordEle1.elementIterator("sms");
				while (iter.hasNext()) {
					Element recordEle = (Element) iter.next();
					String phone = recordEle.elementTextTrim("phone"); // 拿到sms节点下的子节点stat值
					String smsID = recordEle.elementTextTrim("smsID"); // 拿到sms节点下的子节点stat值
					//System.out.println(phone+":"+smsID);
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 2、DOM4j解析XML（支持xpath）
	 * 解析的时候自动去掉CDMA
	 * @param xml
	 */
	public static void xpathParseXml(String xml){
		try {
			StringReader read = new StringReader(xml);
			SAXReader saxReader = new SAXReader();
			Document doc = saxReader.read(read);
			String xpath ="/xml/appid";
			System.out.print(doc.selectSingleNode(xpath).getText());
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 3、JDOM解析XML
	 * 解析的时候自动去掉CDMA
	 * @param xml
	 */
	@SuppressWarnings("unchecked")
	public static UnifiedorderResult jdomParseXml(String xml){
		UnifiedorderResult result=new UnifiedorderResult();
		try {
			StringReader read = new StringReader(xml);
			// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
			InputSource source = new InputSource(read);
			// 创建一个新的SAXBuilder
			SAXBuilder sb = new SAXBuilder();
			// 通过输入源构造一个Document
			org.jdom.Document doc;
			doc = (org.jdom.Document) sb.build(source);
			org.jdom.Element root = doc.getRootElement();// 指向根节点
			List<org.jdom.Element> list = root.getChildren();
			if(list!=null&&list.size()>0){
				for (org.jdom.Element element : list) {
					if(element.getName().equals("appid"))
					{
						result.setAppid(element.getText());
					}
					if(element.getName().equals("mch_id"))
					{
						result.setMch_id(element.getText());
					}
					if(element.getName().equals("device_info"))
					{
						result.setDevice_info(element.getText());
					}
					if(element.getName().equals("nonce_str"))
					{
						result.setNonce_str(element.getText());
					}
					if(element.getName().equals("sign"))
					{
						result.setSign(element.getText());
					}
					if(element.getName().equals("result_code"))
					{
						result.setResult_code(element.getText());
					}
					if(element.getName().equals("err_code"))
					{
						result.setErr_code(element.getText());
					}
					if(element.getName().equals("err_code_des"))
					{
						result.setErr_code_des(element.getText());
					}
					if(element.getName().equals("trade_type"))
					{
						result.setTrade_type(element.getText());
					}
					if(element.getName().equals("prepay_id"))
					{
						result.setPrepay_id(element.getText());
					}
					if(element.getName().equals("code_url"))
					{
						result.setCode_url(element.getText());
					}
					if(element.getName().equals("return_code"))
					{
						result.setReturn_code(element.getText());
					}
					if(element.getName().equals("return_msg"))
					{
						result.setReturn_msg(element.getText());
					}
					//System.out.println("key是："+element.getName()+"，值是："+element.getText());
					/*try{
						methodName =  element.getName();
						Method m = v.getClass().getMethod("set" + methodName, new Class[] { String.class });
						if(parseInt(methodName)){
							m.invoke(v, new Object[] { Integer.parseInt(element.getText()) });
						}else{
							m.invoke(v, new Object[] { element.getText() });
						}
					}catch(Exception ex){
						ex.printStackTrace();
					}*/
				}
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return  result;
	}


	/**
	 * 3、JDOM解析XML
	 * 解析的时候自动去掉CDMA
	 * @param xml
	 */
	@SuppressWarnings("unchecked")
	public static Map<Object, Object> jdomParseXmlMap(String xml){
		Map<Object, Object> result=new LinkedMap();
		try {
			StringReader read = new StringReader(xml);
			// 创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
			InputSource source = new InputSource(read);
			// 创建一个新的SAXBuilder
			SAXBuilder sb = new SAXBuilder();
			// 通过输入源构造一个Document
			org.jdom.Document doc;
			doc = (org.jdom.Document) sb.build(source);
			org.jdom.Element root = doc.getRootElement();// 指向根节点
			List<org.jdom.Element> list = root.getChildren();
			if(list!=null && list.size()>0){
				for (org.jdom.Element element : list) {
					result.put(element.getName(),element.getText());
					//System.out.println("key是："+element.getName()+"，值是："+element.getText());
					/*try{
						methodName =  element.getName();
						Method m = v.getClass().getMethod("set" + methodName, new Class[] { String.class });
						if(parseInt(methodName)){
							m.invoke(v, new Object[] { Integer.parseInt(element.getText()) });
						}else{
							m.invoke(v, new Object[] { element.getText() });
						}
					}catch(Exception ex){
						ex.printStackTrace();
					}*/
				}
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return  result;
	}

	public static boolean parseInt(String key){
		if(!StringUtils.isEmpty(key)){
			if(key.equals("total_fee") || key.equals("cash_fee") || key.equals("coupon_fee")
					|| key.equals("coupon_count") || key.equals("coupon_fee_0")){
				return true;
			}
		}
		return false;
	}

}