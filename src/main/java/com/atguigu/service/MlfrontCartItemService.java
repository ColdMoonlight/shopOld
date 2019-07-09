package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackCategory;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlfrontCart;
import com.atguigu.bean.MlfrontCartItem;
import com.atguigu.bean.MlfrontUser;
import com.atguigu.bean.MlfrontUserTemporary;
import com.atguigu.bean.UserWork;
import com.atguigu.dao.MlbackAdminMapper;
import com.atguigu.dao.MlbackCategoryMapper;
import com.atguigu.dao.MlbackProductMapper;
import com.atguigu.dao.MlfrontCartItemMapper;
import com.atguigu.dao.MlfrontCartMapper;
import com.atguigu.dao.MlfrontUserMapper;
import com.atguigu.dao.MlfrontUserTemporaryMapper;


@Service
public class MlfrontCartItemService {
	
	
	@Autowired
	MlfrontCartItemMapper mlfrontCartItemMapper;
	
	/**
	 * @author Shinelon
	 * @param MlfrontCart
	 * @exception add方法用户信息是否存在
	 * 
	 * */
	public int insertSelective(MlfrontCartItem mlfrontCartItem) {
		int intReslut = mlfrontCartItemMapper.insertSelective(mlfrontCartItem);
		return intReslut;
	}

	/**
	 * @author Shinelon
	 * @param 
	 * @exception 删除本条信息
	 * 
	 * */
	public int deleteByPrimaryKey(int cartitemId) {
		int  intReslut = mlfrontCartItemMapper.deleteByPrimaryKey(cartitemId);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新本条信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(MlfrontCartItem mlfrontCartItem) {
		// TODO Auto-generated method stub
		int  intReslut = mlfrontCartItemMapper.updateByPrimaryKeySelective(mlfrontCartItem);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部用户信息
	 * 
	 * */
	public List<MlfrontCartItem> selectMlfrontCartItemGetAll() {
		List<MlfrontCartItem>  mlfrontCartItemList = mlfrontCartItemMapper.selectMlfrontCartItemGetAll();
		return mlfrontCartItemList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部用户信息
	 * 
	 * */
	public List<MlfrontCartItem> selectMlfrontCartItemOne(MlfrontCartItem mlfrontCartItem) {
		List<MlfrontCartItem>  mlfrontCartItemList = mlfrontCartItemMapper.selectMlfrontCartItemOne(mlfrontCartItem);
		return mlfrontCartItemList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部用户信息
	 * 
	 * */
	public List<MlfrontCartItem> selectMlfrontCartItemById(MlfrontCartItem mlfrontCartItem) {
		List<MlfrontCartItem>  mlfrontCartItemList = mlfrontCartItemMapper.selectMlfrontCartItemById(mlfrontCartItem);
		return mlfrontCartItemList;
	}

}
