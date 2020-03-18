package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.MlbackAbandonPurchase;
import com.atguigu.bean.MlbackSlide;
import com.atguigu.dao.MlbackAbandonPurchaseMapper;
import com.atguigu.dao.MlbackSlideMapper;


@Service
public class MlbackAbandonPurchaseService {
	
	
	@Autowired
	MlbackAbandonPurchaseMapper mlbackAbandonPurchaseMapper;
	
	/**
	 * @author Shinelon
	 * @param MlbackAbandonPurchase
	 * @exception add方法用户信息是否存在
	 * 
	 * */
	public int insertSelective(MlbackAbandonPurchase mlbackAbandonPurchase) {
		int intReslut = mlbackAbandonPurchaseMapper.insertSelective(mlbackAbandonPurchase);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 删除本条信息
	 * 
	 * */
	public int deleteByPrimaryKey(int slideId) {
		// TODO Auto-generated method stub
		int  intReslut = mlbackAbandonPurchaseMapper.deleteByPrimaryKey(slideId);
		return intReslut;
	}
	
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新本条信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(MlbackAbandonPurchase mlbackAbandonPurchase) {
		int  intReslut = mlbackAbandonPurchaseMapper.updateByPrimaryKeySelective(mlbackAbandonPurchase);
		return intReslut;
	}

	/**
	 * @author Shinelon
	 * @param MlbackAbandonPurchase
	 * @exception 查看用户信息是否存在
	 * 
	 * */
	public List<MlbackAbandonPurchase> selectMlbackAbandonPurchaseById(MlbackAbandonPurchase mlbackAbandonPurchase) {
		List<MlbackAbandonPurchase>  mlbackAbandonPurchaseList = mlbackAbandonPurchaseMapper.selectMlbackAbandonPurchaseById(mlbackAbandonPurchase);
		return mlbackAbandonPurchaseList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部用户信息
	 * 
	 * */
	public List<MlbackAbandonPurchase> selectMlbackAbandonPurchaseGetAll() {
		List<MlbackAbandonPurchase>  MlbackAbandonPurchaseList = mlbackAbandonPurchaseMapper.selectMlbackAbandonPurchaseGetAll();
		return MlbackAbandonPurchaseList;
	}

	public List<MlbackAbandonPurchase> selectMlbackAbandonPurchaseByStatus(MlbackAbandonPurchase mlbackAbandonPurchase) {
		List<MlbackAbandonPurchase>  MlbackAbandonPurchaseList = mlbackAbandonPurchaseMapper.selectMlbackAbandonPurchaseByStatus(mlbackAbandonPurchase);
		return MlbackAbandonPurchaseList;
	}
	
}
