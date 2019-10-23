package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackAreafreight;
import com.atguigu.bean.MlbackCategory;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlbackShipEmail;
import com.atguigu.bean.UserWork;
import com.atguigu.dao.MlbackAdminMapper;
import com.atguigu.dao.MlbackAreafreightMapper;
import com.atguigu.dao.MlbackCategoryMapper;
import com.atguigu.dao.MlbackProductMapper;
import com.atguigu.dao.MlbackShipEmailMapper;


@Service
public class MlbackShipEmailService {
	
	
	@Autowired
	MlbackShipEmailMapper mlbackShipEmailMapper;

	/**1
	 * @author Shinelon
	 * @param MlbackShipEmail
	 * @exception 查看全部的地址信息
	 * 
	 * */
	public int insertSelective(MlbackShipEmail mlbackShipEmail) {
		int intReslut = mlbackShipEmailMapper.insertSelective(mlbackShipEmail);
		return intReslut;
	}
	
	/**2
	 * @author Shinelon
	 * @param 
	 * @exception 删除本条信息
	 * 
	 * */
	public int deleteByPrimaryKey(int showareaId) {
		// TODO Auto-generated method stub
		int  intReslut = mlbackShipEmailMapper.deleteByPrimaryKey(showareaId);
		return intReslut;
	}
	
	
	/**3
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部用户信息
	 * */
	public int updateByPrimaryKeySelective(MlbackShipEmail mlbackShipEmail) {
		// TODO Auto-generated method stub
		int  intReslut = mlbackShipEmailMapper.updateByPrimaryKeySelective(mlbackShipEmail);
		return intReslut;
	}
	
	/**4
	 * @author Shinelon
	 * @param MlbackProduct
	 * @exception add方法用户信息是否存在
	 * */
	public List<MlbackShipEmail> selectMlbackShipEmailAll() {
		List<MlbackShipEmail>  mlbackShipEmailList = mlbackShipEmailMapper.selectMlbackShipEmailGetAll();
		return mlbackShipEmailList;
	}
	
	/**5
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部用户信息
	 * 
	 * */
	public List<MlbackShipEmail> selectMlbackShipEmailById(MlbackShipEmail mlbackShipEmail) {
		List<MlbackShipEmail>  mlbackShipEmailList = mlbackShipEmailMapper.selectMlbackShipEmailById(mlbackShipEmail);
		return mlbackShipEmailList;
	}
	
}
