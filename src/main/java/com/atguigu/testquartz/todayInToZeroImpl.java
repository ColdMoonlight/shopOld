package com.atguigu.testquartz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.atguigu.bean.UserAccount;
import com.atguigu.dao.UserAccountMapper;
import com.atguigu.dao.quartz.todayInToZero;
@Component
public class todayInToZeroImpl implements todayInToZero {
	
	
	@Autowired
	UserAccountMapper userAccountMapper;
	
//	@Scheduled(cron="0/15 * *  * * ? ")   //每5秒执行一次
	@Scheduled(cron="0 32 10 * * ? ")   //每5秒执行一次
	@Override
	public void todayInToZero() {
		//获取表中的所有资金账户,
		List<UserAccount> UserAccountList =getAll();
		System.out.println(UserAccountList.size());
		for(UserAccount userAccount:UserAccountList){
			String todayin = userAccount.getUserAccTodayin();
			//判断今日收入是否为0
			if(!("0.00".equals(todayin))){
				//不为0，重置
				UserAccount UserAccountReq = new UserAccount();
				Integer userAcountId= userAccount.getUserAccountid();
				UserAccountReq.setUserAccountid(userAcountId);
				UserAccountReq.setUserAccTodayin("0.00");
				userAccountMapper.updateByPrimaryKeySelective(UserAccountReq);
			}
		}
		List<UserAccount> UserAccountList2 =getAll();
		for(UserAccount userAccountAfter:UserAccountList2){
			String todayinAfter = userAccountAfter.getUserAccTodayin();
			System.out.println("hou:"+todayinAfter);
		}
	}


	private List<UserAccount> getAll() {
		// 查询所有账户对象信息
		List<UserAccount> UserAccountListAll = userAccountMapper.getAllUserAccount();
		return UserAccountListAll;
	}

}
