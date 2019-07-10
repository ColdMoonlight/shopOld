package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.MoneyOut;
import com.atguigu.bean.SysUser;
import com.atguigu.bean.UserAccount;
import com.atguigu.dao.MoneyOutMapper;
import com.atguigu.dao.SysUserMapper;
import com.atguigu.dao.UserAccountMapper;
import com.atguigu.utils.AmountUtil;
import com.atguigu.utils.DateUtil;


@Service
public class MoneyOutService {
	
	
	@Autowired
	SysUserMapper sysUserMapper;
	
	@Autowired
	MoneyOutMapper moneyOutMapper;
	
	@Autowired
	UserAccountMapper userAccountMapper;

	/**
	 * @author Shinelon
	 * @param SysUser
	 * @exception �������Ա�û����󣬲�ѯ�˺��Ƿ����
	 * 
	 * */
	public List<MoneyOut> getMoneyOutByConditions(MoneyOut moneyOut) {
		// TODO Auto-generated method stub
		List<MoneyOut> moneyOutList = moneyOutMapper.getMoneyOutByConditions(moneyOut);
		return moneyOutList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception ��ѯ�˺��Ƿ����
	 * 
	 * */
	public List<SysUser> selectSysUserGetAll() {
		// TODO Auto-generated method stub
		List<SysUser>  SysUserList = sysUserMapper.selectSysUserGetAll();
		return SysUserList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception ��ѯ�˺��Ƿ����
	 * 
	 * */
	public int insertSelective(MoneyOut moneyOut) {
		// TODO Auto-generated method stub
		int  intReslut = moneyOutMapper.insertSelective(moneyOut);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception ��������
	 * 
	 * */
	public int insertSelectiveTrans(MoneyOut moneyOut) {
		//1.0��ȡ������Ϣ
		String udid = moneyOut.getMoneyoutUdid();
		Integer oneTimes = moneyOut.getMoneyoutSparetwo();
		String priceOnce = moneyOut.getMoneyoutPriceOnce();
		String priceOnceCent = AmountUtil.DollarToCent(priceOnce);//250 str
		int priceOnceCentInt = Integer.parseInt(priceOnceCent);//250 int
				
		//2.0��ر����˺�
		UserAccount userAccount = new UserAccount();
		userAccount.setUserAccountUserid(udid);
		List<UserAccount> userAccountList = userAccountMapper.getUserAccountByConditions(userAccount);
		UserAccount userAccountOne = userAccountList.get(0);
		int accId = userAccountOne.getUserAccountid();
		//2.1ԭ�����ܶ�
		String allout = userAccountOne.getUserAccAllout();
		String alloutCent = AmountUtil.DollarToCent(allout);//250 str
		int alloutCentInt = Integer.parseInt(alloutCent);//250 int
//		alloutCentInt=alloutCentInt + priceOnceCentInt;//450 int
//		String alloutCentIntStr2 = alloutCentInt +"";//450 str
//		String alloutAfter = AmountUtil.Cent2Dollar(alloutCentIntStr2);
		
		//������ȡ��
		String accOuting = userAccountOne.getUserAccOuting();
		String accOutingCent = AmountUtil.DollarToCent(accOuting);//250 str
		int accOutingCentInt = Integer.parseInt(accOutingCent);//250 int
		//+��������
		accOutingCentInt=accOutingCentInt + priceOnceCentInt;//450 int
		String accOutingCentIntStr2 = accOutingCentInt +"";//450 str
		String accOutingAfter = AmountUtil.Cent2Dollar(accOutingCentIntStr2);
		
		
		//2.2������ȡ��
		String allmoney = userAccountOne.getUserAccAllmoney();
		String allmoneyCent = AmountUtil.DollarToCent(allmoney);//250 str
		int allmoneyCentInt = Integer.parseInt(allmoneyCent);//250 int
		
		
		//���after = ������allmoneyCentInt - ������alloutAfter-������accOutingAfter
		int nowMoneyInt=0;
		nowMoneyInt=allmoneyCentInt - alloutCentInt-accOutingCentInt;//450 int
		String nowMoneyIntStr2 = nowMoneyInt +"";//450 str
		String nowMoneyAfter = AmountUtil.Cent2Dollar(nowMoneyIntStr2);
		
		UserAccount userAccountUpdateReq = new UserAccount();
		userAccountUpdateReq.setUserAccountid(accId);
		userAccountUpdateReq.setUserAccOuting(accOutingAfter);
		userAccountUpdateReq.setUserAccNowmoney(nowMoneyAfter);
		userAccountUpdateReq.setUserAccOutTimes(oneTimes);
		userAccountUpdateReq.setUserAccOutTodayIf(1);
		
		MoneyOut MoneyOutInt = new MoneyOut();
		MoneyOutInt.setMoneyoutId(null);
		moneyOut.setMoneyoutAccountid(accId);
		MoneyOutInt.setMoneyoutUdid(udid);
		MoneyOutInt.setMoneyoutPriceOnce(priceOnce);
		String nowTime = DateUtil.strTime14s();
		moneyOut.setMoneyoutApplybegintime(nowTime);
		moneyOut.setMoneyoutApplyState("0");
		
		//�˻�����,������-������-�����У�д�����
		try{
			int updateRes = userAccountMapper.updateByPrimaryKeySelective(userAccountUpdateReq);
			int  intReslut = moneyOutMapper.insertSelective(moneyOut);
		}catch(Exception e){
			e.printStackTrace();
			return 2;
		}
		return 1;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception ��ѯ�˺��Ƿ����
	 * 
	 * */
	public int updateByPrimaryKeySelectiveTrans(MoneyOut moneyOut) {
		//1.0��ȡ������Ϣid,��udid
		String udid = moneyOut.getMoneyoutUdid();
		
		
		//2.0��ر����˺�
		UserAccount userAccount = new UserAccount();
		userAccount.setUserAccountUserid(udid);
		List<UserAccount> userAccountList = userAccountMapper.getUserAccountByConditions(userAccount);
		UserAccount userAccountOne = userAccountList.get(0);
		int accId = userAccountOne.getUserAccountid();
		
		String UserAccOuting = userAccountOne.getUserAccOuting();
		
		int  intReslut = moneyOutMapper.updateByPrimaryKeySelective(moneyOut);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception �����ļ�
	 * 
	 * */
	public int updateByPrimaryKeySelective(MoneyOut moneyOut) {
		//1.0��ȡ������Ϣid,��udid
		int  intReslut = moneyOutMapper.updateByPrimaryKeySelective(moneyOut);
		return intReslut;
	}
}
