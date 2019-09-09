package com.atongmu.mall.mall.entity;

import java.io.Serializable;

/**
 * @program: mall
 * @description: 首页轮播图片
 * @author: Hus
 * @create: 2018-12-19 14:06
 */
public class MallHomeRecommend implements Serializable{

    private static final long serialVersionUID = -9186017855501600336L;

    private String imageUrl;
    private String content;
    private String contentType;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

}