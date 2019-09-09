package com.atongmu.mall.common.util.general;

import java.math.BigDecimal;

/**
 * @program: mall
 * @description: 数学计算工具
 * @author: Hus
 * @create: 2018-12-27 09:02
 */
public class MathUtil {

    //NumberFormat currency = NumberFormat.getCurrencyInstance(); //建立货币格式化引用
    //NumberFormat percent = NumberFormat.getPercentInstance();  //建立百分比格式化引用
    //percent.setMaximumFractionDigits(3); //百分比小数点最多3位

    /**
     * 价格计算
     * @param price
     * @param number
     * @return BigDecimal
     *
     * */
    public static BigDecimal priceTimesQuantity(BigDecimal price, int number){
        BigDecimal num = new BigDecimal(String.valueOf(number));
        return price.multiply(num); //相乘;
    }

    /**
     * 价格计算
     * @param price
     * @param number
     * @return BigDecimal
     *
     * */
    public static BigDecimal priceAdd(BigDecimal price, BigDecimal totalPrice){
        return totalPrice.add(price); //相加
    }

}