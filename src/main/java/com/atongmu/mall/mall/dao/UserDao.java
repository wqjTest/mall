package com.atongmu.mall.mall.dao;

import com.atongmu.mall.mall.entity.User;
import org.apache.ibatis.annotations.Mapper;

import javax.validation.constraints.NotNull;

/**
 * @program: mall
 * @description: 用户DAO
 * @author: Hus
 * @create: 2018-12-19 13:50
 */
@Mapper
public interface UserDao {

    User getUserByTokenId(String tokenId);

    User getUserById(String sourceId);

}