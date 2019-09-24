package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.MlbackActShowPro;
import com.atguigu.bean.MlbackAddCartViewDetail;
import com.atguigu.bean.MlbackProductViewDetail;
import com.atguigu.dao.MlbackActShowProMapper;
import com.atguigu.dao.MlbackAddCartViewDetailMapper;
import com.atguigu.dao.MlbackProductViewDetailMapper;


@Service
public class MlbackAddCartViewDetailService {
	
	
	@Autowired
	MlbackAddCartViewDetailMapper mlbackAddCartViewDetailMapper;
	
	/**
	 * @author Shinelon
	 * @param mlbackAddCartViewDetail
	 * @exception add方法用户信息是否存在
	 * 
	 * */
	public int insertSelective(MlbackAddCartViewDetail mlbackAddCartViewDetail) {
		int intReslut = mlbackAddCartViewDetailMapper.insertSelective(mlbackAddCartViewDetail);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 删除本条信息
	 * 
	 * */
	public int deleteByPrimaryKey(int addcartviewdetailId) {
		int  intReslut = mlbackAddCartViewDetailMapper.deleteByPrimaryKey(addcartviewdetailId);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部用户信息
	 * 
	 * */
	public List<MlbackAddCartViewDetail> selectMlbackAddCartViewDetailByTime(MlbackAddCartViewDetail mlbackAddCartViewDetail) {
		List<MlbackAddCartViewDetail>  mlbackProductViewDetailList = mlbackAddCartViewDetailMapper.selectMlbackAddCartViewDetailByTime(mlbackAddCartViewDetail);
		return mlbackProductViewDetailList;
	}

}
