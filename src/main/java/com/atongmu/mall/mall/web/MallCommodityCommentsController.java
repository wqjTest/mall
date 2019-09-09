/**
 * Project Name: mall
 * Date: 2019/1/4 11:04
 * Copyright (c) 2019, www.atongmu.net All Rights Reserved.
 */
package com.atongmu.mall.mall.web;

import com.atongmu.mall.common.util.baseEntity.ResultResponse;
import com.atongmu.mall.mall.entity.MallCommodityComments;
import com.atongmu.mall.mall.entity.ReqParam;
import com.atongmu.mall.mall.service.MallCommodityCommentsService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @Description: 商城商品评论控制器
 * @Author: Hus
 * @Create: 2019-01-04 11:04
 */
@Controller
@RequestMapping(path = {"comments"})
public class MallCommodityCommentsController {

    @Resource
    private MallCommodityCommentsService mallCommodityCommentsService;

    @RequestMapping(path = {"index"}, method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpServletResponse response, Model model){
        return "mall/my-evaluate";
    }

    /**
    * @Description: 用户保存商品的评论
    * @Param: [param, request]
    * @return: ResultResponse
    * @Author: Hus
    * @Date: 2019/1/4
    */
    @RequestMapping(path = {"save"}, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultResponse save(@RequestBody ReqParam param, HttpServletRequest request){
        MallCommodityComments mallCommodityComments = new MallCommodityComments();
        mallCommodityComments.setPersonId(param.getUserId());
        mallCommodityComments.setPersonName("");
        mallCommodityComments.setRemarks(param.getLave());
        mallCommodityComments.setCommodityId(param.getCommodityId());
        mallCommodityComments.setCommentType(param.getCommentType());
        mallCommodityComments.setAnonymousFlag(param.getAnonymousFlag());
        mallCommodityCommentsService.save(mallCommodityComments);
        return new ResultResponse();
    }
}