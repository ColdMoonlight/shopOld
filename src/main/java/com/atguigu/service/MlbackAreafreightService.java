package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackAreafreight;
import com.atguigu.bean.MlbackCategory;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.UserWork;
import com.atguigu.dao.MlbackAdminMapper;
import com.atguigu.dao.MlbackAreafreightMapper;
import com.atguigu.dao.MlbackCategoryMapper;
import com.atguigu.dao.MlbackProductMapper;


@Service
public class MlbackAreafreightService {
	
	
	@Autowired
	MlbackAreafreightMapper mlbackAreafreightMapper;

	/**1
	 * @author Shinelon
	 * @param MlbackProduct
	 * @exception 查看全部的地址信息
	 * 
	 * */
	public List<MlbackAreafreight> selectMlbackAreafreightAll() {
		List<MlbackAreafreight>  mlbackAreafreightList = mlbackAreafreightMapper.selectMlbackAreafreightGetAll();
		return mlbackAreafreightList;
	}
	
	/**2
	 * @author Shinelon
	 * @param MlbackProduct
	 * @exception add方法用户信息是否存在
	 * 
	 * */
	public int insertSelective(MlbackAreafreight mlbackAreafreight) {
		int intReslut = mlbackAreafreightMapper.insertSelective(mlbackAreafreight);
		return intReslut;
	}
	
	/**3
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部用户信息
	 * 
	 * */
	public List<MlbackAreafreight> selectMlbackAreafreightByAreafreightCountryEnglish(MlbackAreafreight mlbackAreafreight) {
		List<MlbackAreafreight>  mlbackAreafreightList = mlbackAreafreightMapper.selectMlbackAreafreightByAreafreightCountryEnglish(mlbackAreafreight);
		return mlbackAreafreightList;
	}
	
	/**3
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部用户信息
	 * 
	 * */
	public List<MlbackAreafreight> selectMlbackAreafreightById(MlbackAreafreight mlbackAreafreight) {
		List<MlbackAreafreight>  mlbackAreafreightList = mlbackAreafreightMapper.selectMlbackAreafreightById(mlbackAreafreight);
		return mlbackAreafreightList;
	}
	/**3
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部用户信息
	 * 
	 * */
	public List<MlbackAreafreight> selectMlbackAreafreightByEng(MlbackAreafreight mlbackAreafreight) {
		List<MlbackAreafreight>  mlbackAreafreightList = mlbackAreafreightMapper.selectMlbackAreafreightByEng(mlbackAreafreight);
		return mlbackAreafreightList;
	}
	
	
	/**4
	 * @author Shinelon
	 * @param 
	 * @exception 删除本条信息
	 * 
	 * */
	public int deleteByPrimaryKey(int areafreightId) {
		// TODO Auto-generated method stub
		int  intReslut = mlbackAreafreightMapper.deleteByPrimaryKey(areafreightId);
		return intReslut;
	}

	/**5
	 * @author Shinelon
	 * @param 
	 * @exception 更新本条信息
	 * 
	 * */
	public int updateByPrimaryKeySelective(MlbackAreafreight mlbackAreafreight) {
		// TODO Auto-generated method stub
		int  intReslut = mlbackAreafreightMapper.updateByPrimaryKeySelective(mlbackAreafreight);
		return intReslut;
	}
	
}
