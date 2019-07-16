package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackCategory;
import com.atguigu.bean.MlbackCoupon;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlbackReviewImg;
import com.atguigu.bean.MlfrontUser;
import com.atguigu.bean.UserWork;
import com.atguigu.dao.MlbackAdminMapper;
import com.atguigu.dao.MlbackCategoryMapper;
import com.atguigu.dao.MlbackCouponMapper;
import com.atguigu.dao.MlbackReviewImgMapper;
import com.atguigu.dao.MlbackProductMapper;
import com.atguigu.dao.MlbackReviewImgMapper;
import com.atguigu.dao.MlfrontUserMapper;


@Service
public class MlbackReviewImgService {
	
	@Autowired
	MlbackReviewImgMapper mlbackReviewImgMapper;
	
	/**
	 * @author Shinelon
	 * @param MlbackReviewImg
	 * @exception add方法MlbackReviewImg
	 * 
	 * */
	public int insertSelective(MlbackReviewImg mlbackReviewImg) {
		int intReslut = mlbackReviewImgMapper.insertSelective(mlbackReviewImg);
		return intReslut;
	}

	/**
	 * @author Shinelon
	 * @param MlbackReviewImg
	 * @exception 删除本条MlbackReviewImg
	 * 
	 * */
	public int deleteByPrimaryKey(int productimgId) {
		// TODO Auto-generated method stub
		int  intReslut = mlbackReviewImgMapper.deleteByPrimaryKey(productimgId);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新本条MlbackReviewImg
	 * 
	 * */
	public int updateByPrimaryKeySelective(MlbackReviewImg mlbackReviewImg) {
		// TODO Auto-generated method stub
		int  intReslut = mlbackReviewImgMapper.updateByPrimaryKeySelective(mlbackReviewImg);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部MlbackReviewImg信息
	 * 
	 * */
	public List<MlbackReviewImg> selectMlbackReviewImgGetAll() {
		List<MlbackReviewImg>  MlbackReviewImgList = mlbackReviewImgMapper.selectMlbackReviewImgGetAll();
		return MlbackReviewImgList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部MlbackReviewImg信息
	 * 
	 * */
	public List<MlbackReviewImg> selectMlbackReviewImgByReviewId(Integer reviewimgId) {
		List<MlbackReviewImg>  MlbackReviewImgList = mlbackReviewImgMapper.selectMlbackReviewImgByReviewId(reviewimgId);
		return MlbackReviewImgList;
	}

	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部MlbackReviewImg信息
	 * 
	 * */
	public List<MlbackReviewImg> selectMlbackReviewImgByRIdAndImgSort(MlbackReviewImg mlbackReviewImg) {
		List<MlbackReviewImg>  MlbackReviewImgList = mlbackReviewImgMapper.selectMlbackReviewImgByRIdAndImgSort(mlbackReviewImg);
		return MlbackReviewImgList;
	}
	
}
