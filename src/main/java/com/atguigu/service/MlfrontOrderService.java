package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackAreafreight;
import com.atguigu.bean.MlbackCategory;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlfrontOrder;
import com.atguigu.bean.UserWork;
import com.atguigu.dao.MlbackAdminMapper;
import com.atguigu.dao.MlbackAreafreightMapper;
import com.atguigu.dao.MlbackCategoryMapper;
import com.atguigu.dao.MlbackProductMapper;
import com.atguigu.dao.MlfrontOrderMapper;


@Service
public class MlfrontOrderService {
	
	
	@Autowired
	MlfrontOrderMapper mlfrontOrderMapper;

	/**1
	 * @author Shinelon
	 * @param MlfrontOrder
	 * @exception add方法用户信息是否存在
	 * 
	 * */
	public int insertSelective(MlfrontOrder mlfrontOrder) {
		int intReslut = mlfrontOrderMapper.insertSelective(mlfrontOrder);
		return intReslut;
	}
	
	/**2
	 * @author Shinelon
	 * @param 
	 * @exception 删除本条信息
	 * 
	 * */
	public int deleteByPrimaryKey(int orderId) {
		// TODO Auto-generated method stub
		int  intReslut = mlfrontOrderMapper.deleteByPrimaryKey(orderId);
		return intReslut;
	}

	/**3
	 * @author Shinelon
	 * @param 
	 * @exception 更新本条信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(MlfrontOrder mlfrontOrder) {
		// TODO Auto-generated method stub
		int  intReslut = mlfrontOrderMapper.updateByPrimaryKeySelective(mlfrontOrder);
		return intReslut;
	}
	
	/**4
	 * @author Shinelon
	 * @param MlfrontOrder
	 * @exception 查看全部的地址信息
	 * 
	 * */
	public List<MlfrontOrder> selectMlfrontOrderAll() {
		List<MlfrontOrder>  mlfrontOrderList = mlfrontOrderMapper.selectMlfrontOrderGetAll();
		return mlfrontOrderList;
	}
	
	/**5
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部用户信息
	 * 
	 * */
	public List<MlfrontOrder> selectMlfrontOrderById(MlfrontOrder mlfrontOrder) {
		List<MlfrontOrder>  mlfrontOrderList = mlfrontOrderMapper.selectMlfrontOrderById(mlfrontOrder);
		return mlfrontOrderList;
	}

	public List<MlfrontOrder> selectMlfrontOrderByDate(MlfrontOrder mlfrontOrder) {
		// TODO Auto-generated method stub
		List<MlfrontOrder>  mlfrontOrderList = mlfrontOrderMapper.selectMlfrontOrderByDate(mlfrontOrder);
		return mlfrontOrderList;
	}

	public List<MlfrontOrder> selectMlfrontOrderByUidAndStatus(MlfrontOrder mlfrontOrder) {
		List<MlfrontOrder>  mlfrontOrderList = mlfrontOrderMapper.selectMlfrontOrderByUidAndStatus(mlfrontOrder);
		return mlfrontOrderList;
	}
	
	public List<MlfrontOrder> selectMlfrontOrderByUidOnly(MlfrontOrder mlfrontOrder) {
		List<MlfrontOrder>  mlfrontOrderList = mlfrontOrderMapper.selectMlfrontOrderByUidOnly(mlfrontOrder);
		return mlfrontOrderList;
	}

	public List<MlfrontOrder> selectOrderListByUidAndStatus(MlfrontOrder mlfrontOrder) {
		List<MlfrontOrder>  mlfrontOrderList = mlfrontOrderMapper.selectOrderListByUidAndStatus(mlfrontOrder);
		return mlfrontOrderList;
	}
	
}
