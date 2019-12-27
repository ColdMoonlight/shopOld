package com.atguigu.testBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.UserAccount;
import com.atguigu.dao.GroupDisplayMapper;
import com.atguigu.dao.UserAccountMapper;
import com.atguigu.utils.DateUtil;
import com.atguigu.utils.UUIDUtils;

/**
 * 测试dao层的工作
 * @author lfy
 *推荐Spring的项目就可以使用Spring的单元测试，
 *1、导入SpringTest模块
 *2、@ContextConfiguration指定Spring配置文件的位
 *3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserAccountTest {
	
	
	@Autowired
	UserAccountMapper userAccountMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * userAccountMapper条件查询
	 */
	@Test
	public void testSearchByConditions(){
		
		UserAccount userAccount = new UserAccount();
		userAccount.setUserAccountUserid("udid");
		
		//查询全部信息
		List<UserAccount> userAccountListOne = userAccountMapper.getUserAccountByConditions(userAccount);
		System.out.println(userAccountListOne);
		System.out.println("userAccountListOne:"+userAccountListOne.size());
		System.out.println("条件查询完成");
	}
	
	
	
	/**
	 * appuserInfoMapper新增
	 */
	@Test
	public void testInsert(){
		
		//2、新增appUser信息
		UserAccount userAccount = new UserAccount();
		/*
		 * 账户IDuser_accountid
		 * 账户持有人IDuser_account_userid
		 * 账户持有人昵称user_account_username
		 * 账户余额user_acc_nowmoney
		 * 账户总收入user_acc_allmoney
		 * 账户今日收入user_acc_todayIn
		 * 账户已提现user_acc_allout
		 * 账户支付宝状态user_acc_ifalipay
		 * 支付宝账号user_alipayname
		 * 支付宝持有人user_alipaypeople
		 * 备用字段1user_acc_spareone
		 * 备用字段2user_acc_sparetwo
		 * 备用字段3user_acc_sparethree
		 * 备用字段4user_acc_sparefour
		 * */
//		userAccount.setUserAccountid(null);			//账户IDuser_accountid				INT(16)			NOT NULL
		userAccount.setUserAccountUserid("udid");	//账户持有人IDuser_account_userid		VARCHAR(64)		NOT NULL
		userAccount.setUserAccountUsername("昵称");	//账户持有人昵称user_account_username	VARCHAR(64)		NOT NULL
		userAccount.setUserAccNowmoney("0.00");		//账户余额user_acc_nowmoney			VARCHAR(64) 	NOT NULL
		userAccount.setUserAccAllmoney("0.00");		//账户总收入user_acc_allmoney			VARCHAR(64)		NOT NULL
		userAccount.setUserAccTodayin("0.00");		//账户今日收入user_acc_todayIn		VARCHAR(64)		NOT NULL
		userAccount.setUserAccAllout("0.00");		//账户已提现user_acc_allout			VARCHAR(64)		NOT NULL
		userAccount.setUserAccIfalipay("0");		//账户支付宝状态user_acc_ifalipay		VARCHAR(8)		NOT NULL
		userAccount.setUserAlipayname("文件信息");	//支付宝账号user_alipayname			VARCHAR(128)	NOT NULL
		userAccount.setUserAlipaypeople("张XX");		//支付宝持有人user_alipaypeople 		VARCHAR(128)	NOT NULL
		userAccount.setUserAccOutTimes(0);			//备用字段1appuser_spareone			INT(16)
		userAccount.setUserAccOutTodayIf(0);			//备用字段2appuser_sparetwo			INT(16)
		userAccount.setUserAccOuting("0");			//备用字段3appuser_sparethree			VARCHAR(128)
		userAccount.setUserAccSparefour("0");		//备用字段4appuser_sparefour			VARCHAR(128)
		userAccountMapper.insertSelective(userAccount);
	}



}
