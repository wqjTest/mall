package com.atongmu.mall.mall.web;

import com.atongmu.mall.common.util.baseEntity.ResultResponse;
import com.atongmu.mall.common.util.general.StringUtil;
import com.atongmu.mall.mall.entity.*;
import com.atongmu.mall.mall.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @program: mall
 * @description: 商城商品控制器
 * @author: Hus
 * @create: 2018-12-19 14:20
 */
@Controller
@RequestMapping(path = {"commodity"})
public class MallCommodityController {

    @Resource
    private MallCommodityService mallCommodityService;

    @Resource
    private MallCommodityImageService commodityImageService;

    @Resource
    private MallCommodityDescriptionService commodityDescriptionService;

    @Resource
    private MallCommodityCommentsService commodityCommentsService;

    @Resource
    private MallCommodityTypeService mallCommodityTypeService;

    /**
     * 商城首页数据获取
     * @param request
     * @param response
     * @param param
     * @return
     * */
    @RequestMapping(path = {"listCommodityOfIndex"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResultResponse listCommodityOfIndex(HttpServletRequest request, HttpServletResponse response,
                                               @RequestBody ReqParam param){
        ResultResponse resultResponse = null;
        MallCommodity filter = new MallCommodity();
        filter.setStatus("1");
        List<MallCommodity> listCommodity
                = mallCommodityService.listCommodityOfIndex(filter);
        if(listCommodity.size() > 0){
            resultResponse = new ResultResponse(listCommodity, "ZERO");
        }else{
            resultResponse = new ResultResponse(listCommodity, "SUCCESS");
        }
        return resultResponse;
    }

    /**
     * 商城查看商品详情
     * @param commodityId
     * @param request
     * @param response
     * @param model
     * */
    @RequestMapping(path = {"{commodityId}"}, method = RequestMethod.GET)
    public String getCommodity(@PathVariable(required = true, value = "commodityId") String commodityId,
                                       HttpServletRequest request, HttpServletResponse response, Model model){
        MallCommodity mallCommodity = mallCommodityService.getCommodity(commodityId);
        List<MallCommodityImage> imgs = commodityImageService.listCommodityImg(commodityId);
        if(imgs.size() <= 0){
            MallCommodityImage mallCommodityImage = new MallCommodityImage();
            mallCommodityImage.setImageUrl(mallCommodity.getCommodityImage());
            imgs.add(mallCommodityImage);
        }
        MallCommodityDescription description
                = commodityDescriptionService.getCommodityDescription("1", commodityId);
        if(description != null){
            description.setDescriptionContent(StringUtil.replaceHtml_img(description.getDescriptionContent()));
        }
        model.addAttribute("commodity", mallCommodity);
        model.addAttribute("imgs", imgs);
        model.addAttribute("description", description);
        return "mall/details";
    }

    /**
     * 商城详情页面获取评论数据
     * @param request
     * @param response
     * @param param
     */
    @RequestMapping(path = {"commodityComments"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResultResponse commodityComments(HttpServletRequest request, HttpServletResponse response,
                                            @RequestBody ReqParam param){
        ResultResponse resultResponse = null;
        List<MallCommodityComments> commodityComments
                = commodityCommentsService.listCommodityComments(param.getCommodityId());
        if(commodityComments.size() > 0){
            resultResponse = new ResultResponse(commodityComments, "SUCCESS");
        }else{
            MallCommodityComments comments = new MallCommodityComments();
            comments.setCreateDate(LocalDateTime.now());
            comments.setId("1");
            comments.setRemarks("东西质量不错哦！");
            comments.setPersonName("胡**爸爸");
            commodityComments.add(comments);
            resultResponse = new ResultResponse(commodityComments, "ZERO");
        }
        return resultResponse;
    }

    /**
     * 商城商品分类列表
     *
     * */
    @RequestMapping(path = {"listCommodityType"}, method = RequestMethod.GET)
    public String listCommodityType(HttpServletRequest request, HttpServletResponse response, Model model){
        List<MallCommodityType> commodityTypes = mallCommodityTypeService.listCommodityType(new MallCommodityType());
        model.addAttribute("commodityTypes", commodityTypes);
        return "mall/classify";
    }

    /**
     * 商城根据商城分类获取商品
     *
     * */
    @RequestMapping(path = {"listCommodityByType"}, method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ResultResponse listCommodityType(HttpServletRequest request, HttpServletResponse response,
                                            @RequestBody ReqParam param){
        List<MallCommodity> commodity = mallCommodityService.listCommodityByType(param.getCommodityType());
        ResultResponse resultResponse = new ResultResponse(commodity, "");
        return resultResponse;
    }

    /**
     * 商城根据商城分类获取商品
     *
     * */
    @RequestMapping(path = {"listCommodityByType"}, method = RequestMethod.GET)
    public String listCommodityType(MallCommodity mallCommodity, HttpServletRequest request,
                                    HttpServletResponse response, Model model){
        List<MallCommodity> commodity = mallCommodityService.listCommodityByType(mallCommodity.getCommodityType());
        model.addAttribute("typeName",
                mallCommodityTypeService.getCommodityTypeName(mallCommodity.getCommodityType()));
        model.addAttribute("listGood", commodity);
        return "mall/classifyShow";
    }

}