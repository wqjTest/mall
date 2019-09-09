package com.atongmu.mall.student.entity;

import java.io.Serializable;

/**
 * @program: mall
 * @description: 家长信息实体类
 * @author: Hus
 * @create: 2018-12-20 17:22
 */
public class KigStudentRelation implements Serializable{

    private static final long serialVersionUID = 6495479673083573412L;

    private String studentId;
    private String personName;
    private String relation;
    private String photo1;

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getPhoto1() {
        return photo1;
    }

    public void setPhoto1(String photo1) {
        this.photo1 = photo1;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}