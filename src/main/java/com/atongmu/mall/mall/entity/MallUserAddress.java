package com.atongmu.mall.mall.entity;

import java.io.Serializable;

/**
 * @program: mall
 * @description: 商城用户地址
 * @author: Hus
 * @create: 2018-12-21 11:06
 */
public class MallUserAddress implements Serializable {

    private static final long serialVersionUID = 6874298996519062280L;

    private String id;
    private String userId;		// 用户ID
    private String userName;		// 收货名称
    private String userPhone;		// 收货电话
    private String province;		// 省
    private String city;		// 市
    private String districtCounty;		// 区县
    private String address;		// 详细地址
    private String defaultFlag;		// 默认地址标记1.默认0.非默认
    private String flag; // 地址标； 家/公司/学校

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrictCounty() {
        return districtCounty;
    }

    public void setDistrictCounty(String districtCounty) {
        this.districtCounty = districtCounty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "MallUserAddress [id=" + id + ", userId=" + userId + ", userName=" + userName + ", userPhone="
				+ userPhone + ", province=" + province + ", city=" + city + ", districtCounty=" + districtCounty
				+ ", address=" + address + ", defaultFlag=" + defaultFlag + ", flag=" + flag + "]";
	}
}