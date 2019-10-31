package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.MlPaypalShipAddress;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackCategory;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlfrontUser;
import com.atguigu.bean.UserWork;
import com.atguigu.dao.MlPaypalShipAddressMapper;
import com.atguigu.dao.MlbackAdminMapper;
import com.atguigu.dao.MlbackCategoryMapper;
import com.atguigu.dao.MlbackProductMapper;
import com.atguigu.dao.MlfrontUserMapper;


@Service
public class MlPaypalShipAddressService {
	
	
	@Autowired
	MlPaypalShipAddressMapper mlPaypalShipAddresstMapper;
	
	
	
	/**
	 * @author Shinelon
	 * @param MlPaypalShipAddress
	 * @exception add方法用户信息是否存在
	 * 
	 * */
	public int insertSelective(MlPaypalShipAddress mlPaypalShipAddress) {
		int intReslut = mlPaypalShipAddresstMapper.insertSelective(mlPaypalShipAddress);
		return intReslut;
	}

	/**
	 * @author Shinelon
	 * @param 
	 * @exception 删除本条信息
	 * 
	 * */
	public int deleteByPrimaryKey(int shippingaddressId) {
		int  intReslut = mlPaypalShipAddresstMapper.deleteByPrimaryKey(shippingaddressId);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新本条信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(MlPaypalShipAddress mlPaypalShipAddress) {
		int  intReslut = mlPaypalShipAddresstMapper.updateByPrimaryKeySelective(mlPaypalShipAddress);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param MlPaypalShipAddress
	 * @exception 查看用户信息是否存在
	 * 
	 * */
	public MlPaypalShipAddress selectMlPaypalShipAddressByPayinfoid(MlPaypalShipAddress mlPaypalShipAddress) {
		MlPaypalShipAddress  mlPaypalShipAddressRes = mlPaypalShipAddresstMapper.selectMlPaypalShipAddressByPayinfoid(mlPaypalShipAddress);
		return mlPaypalShipAddressRes;
	}

}
