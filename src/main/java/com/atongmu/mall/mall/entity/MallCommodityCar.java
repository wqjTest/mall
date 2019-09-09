/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.atongmu.mall.mall.entity;

import com.atongmu.mall.common.util.baseEntity.BaseEntity;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 商城用户购物车Entity
 * @author hus
 * @version 2017-11-06
 */
@Data
public class MallCommodityCar extends BaseEntity implements Serializable{

	private static final long serialVersionUID = -7702109870270547032L;

	private String userId;		// 用户ID
	private String commodityId;		// 商品ID
	private String commodityImage;		// 商品图片
	private String commodityName;		// 商品名称
	private BigDecimal commodityPrice;		// 商品价格
	private BigDecimal price;		// 价格
	private Integer number;		// 数量

	public MallCommodityCar() {
		super();
	}
}