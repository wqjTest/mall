package com.atongmu.mall.mall.web;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atongmu.mall.common.util.baseEntity.ResultResponse;
import com.atongmu.mall.common.util.general.StringUtil;
import com.atongmu.mall.mall.service.MallUserAddressService;
import com.atongmu.mall.student.entity.KigStudent;
import com.atongmu.mall.student.entity.KigStudentRelation;
import com.atongmu.mall.student.service.KigStudentRelationService;
import com.atongmu.mall.student.service.KigStudentService;

/**
 * @program: mall
 * @description: 我的界面
 * @author: Hus
 * @create: 2018-12-20 15:23
 */
@Controller
@RequestMapping(path = { "mine" })
public class MallMineController {

	@Resource
	private KigStudentService kigStudentService;

	@Resource
	private KigStudentRelationService kigStudentRelationService;

	@Resource
	private MallUserAddressService mallUserAddressService;

	@RequestMapping(path = { "mineIndex/{userId}" }, method = RequestMethod.GET)
	public String mineIndex(@PathVariable(value = "userId", required = true) String userId, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		KigStudentRelation relation = kigStudentRelationService.getRelation(userId);
		KigStudent student = kigStudentService.getStudent(relation.getStudentId());
		student.setPhoto1(StringUtil.imagePathTransform(student.getPhoto1()));
		model.addAttribute("student", student);
		return "mall/my";
	}
	
	@RequestMapping(path = { "index/{userId}" }, method = RequestMethod.GET)
	@ResponseBody
    public ResultResponse<KigStudent> index(@PathVariable(value = "userId", required = true) String userId) {
        KigStudentRelation relation = kigStudentRelationService.getRelation(userId);
        KigStudent student = kigStudentService.getStudent(relation.getStudentId());
        student.setPhoto1(StringUtil.imagePathTransform(student.getPhoto1()));
        
        ResultResponse<KigStudent> result = new ResultResponse<>();
        result.setData(student);
        return result;
    }

}