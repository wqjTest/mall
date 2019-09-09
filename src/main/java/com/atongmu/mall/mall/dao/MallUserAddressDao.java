package com.atongmu.mall.mall.dao;

import com.atongmu.mall.mall.entity.MallUserAddress;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @program: mall
 * @description: 商城用户地址Dao
 * @author: Hus
 * @create: 2018-12-21 11:07
 */
@Mapper
public interface MallUserAddressDao {

    List<MallUserAddress> listUserAddress(String userId);

    MallUserAddress getByUserIdAndAddressId(String userId, String addressId);

    public void insert(MallUserAddress entity);

    public void update(MallUserAddress entity);

    public void delete(MallUserAddress entity);

}