package com.atongmu.mall.student.entity;

import java.io.Serializable;

/**
 * @program: mall
 * @description: 学生信息
 * @author: Hus
 * @create: 2018-12-20 17:25
 */
public class KigStudent implements Serializable{

    private static final long serialVersionUID = -1376739400772133234L;

    private String personName;
    private Integer integral;
    private String photo1;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }
}