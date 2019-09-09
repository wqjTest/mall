package com.atongmu.mall.mall.web;

import com.atongmu.mall.common.util.exception.UserExceptionDefine;
import com.atongmu.mall.common.util.general.StringUtil;
import com.atongmu.mall.mall.entity.MallCommodityType;
import com.atongmu.mall.mall.entity.MallHomeRecommend;
import com.atongmu.mall.mall.entity.User;
import com.atongmu.mall.mall.service.MallCommodityTypeService;
import com.atongmu.mall.mall.service.MallHomeRecommendService;
import com.atongmu.mall.mall.util.UserUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: mall
 * @description: 商城主页面控制器
 * @author: Hus
 * @create: 2018-12-18 08:58
 */
@Controller
@RequestMapping("home")
public class MallHomeController {

    @Resource
    private UserUtils userUtils;

    @Resource
    private MallHomeRecommendService mallHomeRecommendService;

    @Resource
    private MallCommodityTypeService mallCommodityTypeService;

    private String imageById;

    /**
     * 主页映射地址
     * */
    @RequestMapping(path={"index"}, method = RequestMethod.GET)
    public String homeIndex(@RequestParam(value = "tokenId", required = false)String tokenId,
                            @RequestParam(value = "userId", required = false)String userId,
                            HttpServletRequest request, HttpServletResponse response, Model model){
        User user = null;
        if(StringUtil.isNotBlank(tokenId)){
            try {
                user = userUtils.getUserByTokenId(tokenId);
            } catch (UserExceptionDefine e) {
                model.addAttribute("errorMessage", e.getMessage());
                return "mall/index";
            }
        } else {
            try {
                user = userUtils.getUserById(userId);
            } catch (UserExceptionDefine e) {
                model.addAttribute("errorMessage", e.getMessage());
                return "mall/index";
            }
        }
        model.addAttribute("userId", user.getSourceId());
        model.addAttribute("listRecommend",
                mallHomeRecommendService.listRecommend(new MallHomeRecommend()));
        MallCommodityType typeFilter = new MallCommodityType();
        typeFilter.setTypeSort(4);
        model.addAttribute("listType",
                mallCommodityTypeService.listCommodityType(typeFilter));
        return "mall/index";
    }

    @RequestMapping(path = {"listGood"}, method = RequestMethod.GET)
    public String listGood(@RequestParam(value = "tokenId", required = true)String tokenId,
                            HttpServletRequest request, HttpServletResponse response, Model model){
        User user = null;
        try {
            user = userUtils.getUserByTokenId(tokenId);
        } catch (UserExceptionDefine e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "mall/index";
        }
        model.addAttribute("listRecommend",
                mallHomeRecommendService.listRecommend(new MallHomeRecommend()));
        return "mall/index";
    }

}