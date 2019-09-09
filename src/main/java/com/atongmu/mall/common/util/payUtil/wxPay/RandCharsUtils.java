package com.atongmu.mall.common.util.payUtil.wxPay;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * nonce_str随即字符串
 * @author iYjrg_xiebin
 * @date 2015年11月25日下午5:10:32
 */
public class RandCharsUtils {
	private static SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

	public static String getRandomString(int length) { //length表示生成字符串的长度
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		int number = 0;
		for (int i = 0; i < length; i++) {
			number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}

	/// 密码生成器
	public static String getRandomPassword() { //length表示生成字符串的长度
		String uppercaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numbers = "0123456789";
		String lowercaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String specialCharacters = "!@#$&*";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		int number = 0;
		// 大写字母
		for (int i = 0; i < 2; i++) {
			number = random.nextInt(uppercaseLetters.length());
			sb.append(uppercaseLetters.charAt(number));
		}
		// 特殊符号
		number = random.nextInt(specialCharacters.length());
		sb.append(specialCharacters.charAt(number));
		// 小写字母
		for (int i = 0; i < 5; i++) {
			number = random.nextInt(lowercaseLetters.length());
			sb.append(lowercaseLetters.charAt(number));
		}
		// 数字符号
		for (int i = 0; i < 4; i++) {
			number = random.nextInt(numbers.length());
			sb.append(numbers.charAt(number));
		}
		return sb.toString();
	}

	/*
	 * 订单开始交易的时间
	 */
	public static String timeStart(){
		return df.format(new Date());
	}

	/*
	 * 订单开始交易的时间
	 */
	public static String timeExpire(){
		Calendar now=Calendar.getInstance();
		now.add(Calendar.MINUTE,30);
		return df.format(now.getTimeInMillis());
	}



}