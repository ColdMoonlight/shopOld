package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackCategory;
import com.atguigu.bean.MlbackCoupon;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlfrontReview;
import com.atguigu.bean.MlfrontUser;
import com.atguigu.bean.UserWork;
import com.atguigu.dao.MlbackAdminMapper;
import com.atguigu.dao.MlbackCategoryMapper;
import com.atguigu.dao.MlbackCouponMapper;
import com.atguigu.dao.MlbackProductMapper;
import com.atguigu.dao.MlfrontReviewMapper;
import com.atguigu.dao.MlfrontUserMapper;


@Service
public class MlfrontReviewService {
	
	@Autowired
	MlfrontReviewMapper mlfrontReviewMapper;
	
	/**
	 * @author Shinelon
	 * @param mlfrontReview
	 * @exception add方法mlfrontReview
	 * */
	public int insertSelective(MlfrontReview mlfrontReview) {
		int intReslut = mlfrontReviewMapper.insertSelective(mlfrontReview);
		return intReslut;
	}

	/**
	 * @author Shinelon
	 * @param mlfrontReview
	 * @exception 删除本条mlfrontReview
	 * */
	public int deleteByPrimaryKey(int reviewId) {
		// TODO Auto-generated method stub
		int  intReslut = mlfrontReviewMapper.deleteByPrimaryKey(reviewId);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新本条mlfrontReview
	 * */
	public int updateByPrimaryKeySelective(MlfrontReview mlfrontReview) {
		// TODO Auto-generated method stub
		int  intReslut = mlfrontReviewMapper.updateByPrimaryKeySelective(mlfrontReview);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param MlfrontUser
	 * @exception 查看mlfrontReview是否存在
	 * */
	public List<MlfrontReview> selectMlfrontReviewById(MlfrontReview mlfrontReview) {
		List<MlfrontReview>  mlbackCouponList = mlfrontReviewMapper.selectMlfrontReviewById(mlfrontReview);
		return mlbackCouponList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部mlfrontReview信息
	 * */
	public List<MlfrontReview> selectMlfrontReviewGetAll() {
		List<MlfrontReview>  mlbackCouponList = mlfrontReviewMapper.selectMlfrontReviewGetAll();
		return mlbackCouponList;
	}

}
