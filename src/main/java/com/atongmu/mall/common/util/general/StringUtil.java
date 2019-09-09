package com.atongmu.mall.common.util.general;


import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @program: mall
 * @description: 字符串工具类
 * @author: Hus
 * @create: 2018-12-11 15:41
 */
public class StringUtil extends StringUtils{

    public static String imagePathTransform(String url){
        if(StringUtils.isBlank(url)) {
            return "";
        }
        if(url.startsWith("/backwork")){
            return "http://app.atongmu.net:10010" + url;
        } else {
            return "http" + Global.CDN + url;
        }
    }

    /**
     * 替换HTML中的<img>标签
     *
     * */
    public static String replaceHtml_img(String context) {
        return context.replaceAll("/backwork", Global.WEB_SERVER);
    }

}