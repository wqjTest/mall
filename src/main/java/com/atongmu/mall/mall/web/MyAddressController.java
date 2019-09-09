package com.atongmu.mall.mall.web;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.atongmu.mall.common.util.general.StringUtil;
import com.atongmu.mall.mall.entity.MallUserAddress;
import com.atongmu.mall.mall.service.MallUserAddressService;

@Controller
@RequestMapping("address/{userId}")
public class MyAddressController {
	
	private static final Logger LOG = LoggerFactory.getLogger(MyAddressController.class);
	
	@Resource
	private MallUserAddressService mallUserAddressService;

	/**
	 * 收货地址列表
	 */
	@RequestMapping(path = { "list" }, method = RequestMethod.GET)
	public String listAddress(@PathVariable(value = "userId", required = true) String userId,
			HttpServletRequest request, HttpServletResponse response, Model model) {
		
		//LOG.debug("userId : %s", userId);
		List<MallUserAddress> addressList = mallUserAddressService.listUserAddress(userId);
		model.addAttribute("addressList", addressList);
		return "mall/my-setupaddress";
	}
	
	@RequestMapping(path = { "toedit" }, method = RequestMethod.GET)
	public String editAddress(@PathVariable(value = "userId", required = true) String userId,
			@RequestParam(value = "addressId", required = false) String addressId, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		//LOG.debug("userId : %s; addressId : %s", userId, addressId);
		if (StringUtil.isNotBlank(addressId)) {
			MallUserAddress address = new MallUserAddress();
			model.addAttribute("data", address);
			return "mall/my-add-address";
		}
		
		MallUserAddress address = mallUserAddressService.get(userId, addressId);
		model.addAttribute("data", address);
		return "mall/my-add-address";
	}
	
	@RequestMapping(path = { "save" }, method = RequestMethod.GET)
	public String saveAddress(@PathVariable(value = "userId", required = true) String userId,
			@RequestParam(value = "name", required = false) String name, 
			@RequestParam(value = "phone", required = false) String phone, 
			@RequestParam(value = "jaddress", required = false) String jaddress, 
			@RequestParam(value = "address", required = false) String address, 
			@RequestParam(value = "flag", required = false) String flag, 
			@RequestParam(value = "defaultFlag", required = false) String defaultFlag, 
			@RequestParam(value = "addressId", required = false) String addressId,
			HttpServletRequest request,
			HttpServletResponse response, Model model) {
		
		//LOG.debug("userId : %s; addressId : %s", userId, addressId);
		//LOG.debug("jaddress : %s; address : %s", jaddress, address);
		MallUserAddress entity = new MallUserAddress();
		
		if (StringUtils.isNotBlank(jaddress)) {
			List<String> jaddrList = Arrays.asList(jaddress.split(" "));
			if (jaddrList.size() > 0) {
				entity.setProvince(jaddrList.get(0));
			}
			if (jaddrList.size() > 1) {
				entity.setCity(jaddrList.get(1));
			}
			if (jaddrList.size() > 2) {
				entity.setDistrictCounty(jaddrList.get(2));
			}
		}
		
		
		entity.setId(addressId);
		entity.setUserId(userId);
		entity.setUserName(name);
		entity.setUserPhone(phone);
		entity.setAddress(address);
		entity.setFlag(flag);
		entity.setDefaultFlag(defaultFlag);
		//LOG.debug("entity : ", entity);
		
		this.mallUserAddressService.save(entity);
		
		return String.format("redirect:/address/%s/list", userId);
	}
}
