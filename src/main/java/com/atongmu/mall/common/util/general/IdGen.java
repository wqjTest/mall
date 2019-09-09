package com.atongmu.mall.common.util.general;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * @program: mall
 * @description: 唯一生成ID算法工具类
 * @author: Hus
 * @create: 2018-12-26 21:30
 */
public class IdGen {

    private static SecureRandom random = new SecureRandom();

    /**
     * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * 使用SecureRandom随机生成Long.
     */
    public static long randomLong() {
        return Math.abs(random.nextLong());
    }

}
