package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.Department;
import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.UserAccount;
import com.atguigu.dao.DepartmentMapper;
import com.atguigu.dao.UserAccountMapper;

@Service
public class UserAccountService {
	
	@Autowired
	private UserAccountMapper userAccountMapper;

	/**1.0	useOn
	 * @author Shinelon
	 * @param userAccount
	 * @exception �����û��½�һ���ʽ��˻�
	 * */
	public int insertSelective(UserAccount userAccount) {
		int  intReslut = userAccountMapper.insertSelective(userAccount);
		return intReslut;
	}
	
	/**2.0	useOn
	 * @author Shinelon
	 * @param udid
	 * @exception ��ѯ���û����ʽ��˻�
	 * */
	public List<UserAccount> getUserAccountByConditions(UserAccount userAccount) {
		List<UserAccount>  userAccountListALl = userAccountMapper.getUserAccountByConditions(userAccount);
		return userAccountListALl;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception ��ѯ�˺��Ƿ����
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
	 * @exception ��ѯ�˺��Ƿ����
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
