package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.MlPaypalStateprovince;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackCategory;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlfrontUser;
import com.atguigu.bean.UserWork;
import com.atguigu.dao.MlPaypalShipAddressMapper;
import com.atguigu.dao.MlPaypalStateprovinceMapper;
import com.atguigu.dao.MlbackAdminMapper;
import com.atguigu.dao.MlbackCategoryMapper;
import com.atguigu.dao.MlbackProductMapper;
import com.atguigu.dao.MlfrontUserMapper;


@Service
public class MlPaypalStateprovinceService {
	
	
	@Autowired
	MlPaypalStateprovinceMapper mlPaypalStateprovinceMapper;
	
	
	
	/**
	 * @author Shinelon
	 * @param MlPaypalStateprovince
	 * @exception add方法用户信息是否存在
	 * 
	 * */
	public int insertSelective(MlPaypalStateprovince mlPaypalStateprovince) {
		int intReslut = mlPaypalStateprovinceMapper.insertSelective(mlPaypalStateprovince);
		return intReslut;
	}

	/**
	 * @author Shinelon
	 * @param 
	 * @exception 删除本条信息
	 * 
	 * */
	public int deleteByPrimaryKey(int shippingaddressId) {
		int  intReslut = mlPaypalStateprovinceMapper.deleteByPrimaryKey(shippingaddressId);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新本条信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(MlPaypalStateprovince mlPaypalStateprovince) {
		int  intReslut = mlPaypalStateprovinceMapper.updateByPrimaryKeySelective(mlPaypalStateprovince);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param MlPaypalStateprovince
	 * @exception 查看用户信息是否存在
	 * 
	 * */
	public List<MlPaypalStateprovince> selectMlPaypalStateprovinceByCountryCode(MlPaypalStateprovince mlPaypalStateprovince) {
		List<MlPaypalStateprovince>  mlPaypalStateprovinceRes = mlPaypalStateprovinceMapper.selectMlPaypalStateprovinceByCountryCode(mlPaypalStateprovince);
		return mlPaypalStateprovinceRes;
	}

}
