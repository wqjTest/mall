package com.atongmu.mall.student.dao;

import com.atongmu.mall.student.entity.KigStudent;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: mall
 * @description: 学生信息Dao
 * @author: Hus
 * @create: 2018-12-20 17:24
 */
@Mapper
public interface KigStudentDao {

    KigStudent getStudent(String id);

}