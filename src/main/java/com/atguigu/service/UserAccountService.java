package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.AppuserInfo;
import com.atguigu.bean.Department;
import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.UserAccount;
import com.atguigu.dao.AppuserInfoMapper;
import com.atguigu.dao.DepartmentMapper;
import com.atguigu.dao.UserAccountMapper;

@Service
public class UserAccountService {
	
	@Autowired
	private UserAccountMapper userAccountMapper;

	/**1.0	useOn
	 * @author Shinelon
	 * @param userAccount
	 * @exception 给本用户新建一个资金账户
	 * */
	public int insertSelective(UserAccount userAccount) {
		int  intReslut = userAccountMapper.insertSelective(userAccount);
		return intReslut;
	}
	
	/**2.0	useOn
	 * @author Shinelon
	 * @param udid
	 * @exception 查询该用户的资金账户
	 * */
	public List<UserAccount> getUserAccountByConditions(UserAccount userAccount) {
		List<UserAccount>  userAccountListALl = userAccountMapper.getUserAccountByConditions(userAccount);
		return userAccountListALl;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询账号是否存在
	 * 
	 * */
	
//	public List<AppuserInfo> getAppuserInfoAll() {
//		// TODO Auto-generated method stub
//		List<AppuserInfo>  appuserInfoListALl = appuserInfoMapper.getAppuserInfoAll();
//		return appuserInfoListALl;
//	}
	
	
	
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询账号是否存在
	 * 
	 * */
//	public int deleteByPrimaryKey(int taskId) {
//		// TODO Auto-generated method stub
//		int  intReslut = groupDisplayMapper.deleteByPrimaryKey(taskId);
//		return intReslut;
//	}


	public int updateByPrimaryKeySelective(UserAccount userAccount) {
		// TODO Auto-generated method stub
		int  intReslut = userAccountMapper.updateByPrimaryKeySelective(userAccount);
		return intReslut;
	}

}
