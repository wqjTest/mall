package com.atongmu.mall.mall.service;

import com.atongmu.mall.common.util.exception.UserExceptionDefine;
import com.atongmu.mall.common.util.general.IdGen;
import com.atongmu.mall.mall.dao.MallCommodityCommentsDao;
import com.atongmu.mall.mall.entity.MallCommodityComments;
import com.atongmu.mall.mall.entity.User;
import com.atongmu.mall.mall.util.OrderUtil;
import com.atongmu.mall.mall.util.UserUtils;
import io.micrometer.core.instrument.Meter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: mall
 * @description: 商城商品评论列表
 * @author: Hus
 * @create: 2018-12-20 14:05
 */
@Service
@Transactional(readOnly = true)
public class MallCommodityCommentsService {

    @Resource
    private MallCommodityCommentsDao mallCommodityCommentsDao;

    @Resource
    private UserUtils userUtils;

    public List<MallCommodityComments> listCommodityComments(String commodityId) {
        return mallCommodityCommentsDao.listCommodityComments(commodityId);
    }

    @Transactional(readOnly = false)
    public void save(MallCommodityComments mallCommodityComments) {
        User user = null;
        try {
            user = userUtils.getUserById(mallCommodityComments.getPersonId());
        } catch (UserExceptionDefine e) {
        }
        mallCommodityComments.setId(IdGen.uuid());
        mallCommodityComments.setCreateDate(LocalDateTime.now());
        mallCommodityComments.setCreateBy(user.getId());
        mallCommodityComments.setUpdateDate(LocalDateTime.now());
        mallCommodityComments.setUpdateBy(user.getId());
        mallCommodityComments.setDelFlag(0);
        mallCommodityCommentsDao.save(mallCommodityComments);
    }

    @Transactional(readOnly = false)
    public void delete(String id) {
        mallCommodityCommentsDao.delete(id);
    }

}