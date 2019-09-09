package com.atongmu.mall.student.service;

import com.atongmu.mall.student.dao.KigStudentRelationDao;
import com.atongmu.mall.student.entity.KigStudentRelation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: mall
 * @description: 家长信息Service
 * @author: Hus
 * @create: 2018-12-20 17:23
 */
@Service
@Transactional(readOnly = true)
public class KigStudentRelationService {

    @Resource
    private KigStudentRelationDao kigStudentRelationDao;

    public KigStudentRelation getRelation(String id) {
        return kigStudentRelationDao.getRelation(id);
    }

}