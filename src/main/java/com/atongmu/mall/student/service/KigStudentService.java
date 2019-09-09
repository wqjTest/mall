package com.atongmu.mall.student.service;

import com.atongmu.mall.student.dao.KigStudentDao;
import com.atongmu.mall.student.entity.KigStudent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: mall
 * @description: 学生信息Service
 * @author: Hus
 * @create: 2018-12-20 17:25
 */
@Service
@Transactional(readOnly = true)
public class KigStudentService {

    @Resource
    private KigStudentDao kigStudentDao;

    public KigStudent getStudent(String id) {
        return kigStudentDao.getStudent(id);
    }
}
