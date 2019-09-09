package com.atongmu.mall.common.util.general;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @program: mall
 * @description: 时间工具类
 * @author: Hus
 * @create: 2018-12-11 15:54
 */
public class DateUtil {

    public static String dateFormat(){
        return "";
    }

    public static String timeFormat(){
        return "";
    }

    public static String dateTimeFormat(){
        return "";
    }

    public static LocalDate dateParse(){
        return LocalDate.now();
    }

    public static LocalTime timeParse(){
        return LocalTime.now();
    }

    public static LocalDateTime dateTimeParse(){
        return LocalDateTime.now();
    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        int a = Integer.parseInt("12");
        System.out.println(localDate);
        System.out.println(localTime);
    }

}