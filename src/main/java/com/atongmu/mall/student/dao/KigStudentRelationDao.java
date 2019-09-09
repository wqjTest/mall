package com.atongmu.mall.student.dao;

import com.atongmu.mall.student.entity.KigStudentRelation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @program: mall
 * @description: 家长信息Dao
 * @author: Hus
 * @create: 2018-12-20 17:22
 */
@Mapper
public interface KigStudentRelationDao {

    KigStudentRelation getRelation(String id);

}