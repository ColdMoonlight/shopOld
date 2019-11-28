package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.MlbackAddPayinfoViewDetail;
import com.atguigu.dao.MlbackAddPayinfoViewDetailMapper;

@Service
public class MlbackAddPayinfoViewDetailService {
	
	
	@Autowired
	MlbackAddPayinfoViewDetailMapper mlbackAddPayinfoViewDetailMapper;
	
	/**
	 * @author Shinelon
	 * @param mlbackAddPayinfoViewDetail
	 * @exception add方法用户信息是否存在
	 * 
	 * */
	public int insertSelective(MlbackAddPayinfoViewDetail mlbackAddPayinfoViewDetail) {
		int intReslut = mlbackAddPayinfoViewDetailMapper.insertSelective(mlbackAddPayinfoViewDetail);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 删除本条信息
	 * 
	 * */
	public int deleteByPrimaryKey(int addcartviewdetailId) {
		int  intReslut = mlbackAddPayinfoViewDetailMapper.deleteByPrimaryKey(addcartviewdetailId);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部用户信息
	 * 
	 * */
	public List<MlbackAddPayinfoViewDetail> selectMlbackAddPayinfoViewDetailByTime(MlbackAddPayinfoViewDetail mlbackAddPayinfoViewDetail) {
		List<MlbackAddPayinfoViewDetail>  mlbackAddPayinfoViewDetailList = mlbackAddPayinfoViewDetailMapper.selectMlbackAddPayinfoViewDetailByTime(mlbackAddPayinfoViewDetail);
		return mlbackAddPayinfoViewDetailList;
	}

	public List<MlbackAddPayinfoViewDetail> selectMlbackAddPayinfoViewDetailByPayinfoid(MlbackAddPayinfoViewDetail mlbackAddPayinfoViewDetailReq) {
		List<MlbackAddPayinfoViewDetail>  mlbackAddPayinfoViewDetailList = mlbackAddPayinfoViewDetailMapper.selectMlbackAddPayinfoViewDetailByPayinfoid(mlbackAddPayinfoViewDetailReq);
		return mlbackAddPayinfoViewDetailList;
	}

}
