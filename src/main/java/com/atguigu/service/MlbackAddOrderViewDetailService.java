package com.atguigu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.atguigu.bean.MlbackAddOrderViewDetail;
import com.atguigu.dao.MlbackAddOrderViewDetailMapper;

@Service
public class MlbackAddOrderViewDetailService {
	
	
	@Autowired
	MlbackAddOrderViewDetailMapper mlbackAddOrderViewDetailMapper;
	
	/**
	 * @author Shinelon
	 * @param mlbackAddOrderViewDetail
	 * @exception add方法用户信息是否存在
	 * 
	 * */
	public int insertSelective(MlbackAddOrderViewDetail mlbackAddOrderViewDetail) {
		int intReslut = mlbackAddOrderViewDetailMapper.insertSelective(mlbackAddOrderViewDetail);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 删除本条信息
	 * 
	 * */
	public int deleteByPrimaryKey(int addcartviewdetailId) {
		int  intReslut = mlbackAddOrderViewDetailMapper.deleteByPrimaryKey(addcartviewdetailId);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部用户信息
	 * 
	 * */
	public List<MlbackAddOrderViewDetail> selectMlbackAddOrderViewDetailByTime(MlbackAddOrderViewDetail mlbackAddOrderViewDetail) {
		List<MlbackAddOrderViewDetail>  mlbackProductViewDetailList = mlbackAddOrderViewDetailMapper.selectMlbackAddOrderViewDetailByTime(mlbackAddOrderViewDetail);
		return mlbackProductViewDetailList;
	}

	/**
	 * @author Shinelon
	 * @param 
	 * @exception 通过oitemid查询是否本条已经被添加了
	 * 
	 * */
	public List<MlbackAddOrderViewDetail> selectMlbackAddOrderViewDetailByoItemid(MlbackAddOrderViewDetail mlbackAddOrderViewDetailReq) {
		List<MlbackAddOrderViewDetail>  mlbackProductViewDetailList = mlbackAddOrderViewDetailMapper.selectMlbackAddOrderViewDetailByoItemid(mlbackAddOrderViewDetailReq);
		return mlbackProductViewDetailList;
	}

}
