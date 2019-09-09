package com.atongmu.mall.mall.service;

import com.atongmu.mall.mall.dao.UserDao;
import com.atongmu.mall.mall.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * @program: mall
 * @description: 用户Service
 * @author: Hus
 * @create: 2018-12-19 13:50
 */
@Service
@Transactional(readOnly = true)
public class UserService {

    @Resource
    private UserDao userDao;

    public User getUserByTokenId(String tokenId){
        return userDao.getUserByTokenId(tokenId);
    }

    public User getUserById(String sourceId) {
        return userDao.getUserById(sourceId);
    }

}