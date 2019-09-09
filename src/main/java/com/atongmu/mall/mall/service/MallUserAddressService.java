package com.atongmu.mall.mall.service;

import com.atongmu.mall.common.util.general.IdGen;
import com.atongmu.mall.mall.dao.MallUserAddressDao;
import com.atongmu.mall.mall.entity.MallUserAddress;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: mall
 * @description: 商城用户地址Service
 * @author: Hus
 * @create: 2018-12-21 11:08
 */
@Service
@Transactional(readOnly = true)
public class MallUserAddressService {

    @Resource
    private MallUserAddressDao mallUserAddressDao;

    public List<MallUserAddress> listUserAddress(String userId) {
        return mallUserAddressDao.listUserAddress(userId);
    }

    /**
     * @param userId
     * @param addressId
     * @return
     */
    public MallUserAddress get(String userId, String addressId) {
    	MallUserAddress entity = this.mallUserAddressDao.getByUserIdAndAddressId(userId, addressId);
    	if (entity == null) {
    		entity = new MallUserAddress();
    	}
    	return entity;
    }

    @Transactional
    public MallUserAddress save(MallUserAddress entity) {
    	Assert.notNull(entity, "entity must not be null");
    	if (StringUtils.isBlank(entity.getId())) {
    		// insert
    		entity.setId(IdGen.uuid());
    		this.mallUserAddressDao.insert(entity);
    	} else {
    		// update
    		this.mallUserAddressDao.update(entity);
    	}
    	return entity;
    }
    
    @Transactional
    public int delete(MallUserAddress entity) {
    	this.mallUserAddressDao.delete(entity);
    	return 1;
    }

}