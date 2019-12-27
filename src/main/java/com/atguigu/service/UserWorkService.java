package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.UserAccount;
import com.atguigu.bean.UserWork;
import com.atguigu.dao.GroupDisplayMapper;
import com.atguigu.dao.UserAccountMapper;
import com.atguigu.dao.UserWorkMapper;
import com.atguigu.utils.AmountUtil;

@Service
public class UserWorkService {
	
	@Autowired
	private UserAccountMapper userAccountMapper;
	
	@Autowired
	private UserWorkMapper userWorkMapper;
	
	@Autowired
	private GroupDisplayMapper groupDisplayMapper;
	

	/**
	 * @author Shinelon
	 * @param 
	 * @exception 获取当前任务
	 * 
	 * */
	public List<UserWork> getUserWorkByConditions(UserWork userWork) {
		List<UserWork>  userWorkListALl = userWorkMapper.getUserWorkByConditions(userWork);
		return userWorkListALl;
	}
	/**
	 * @author Shinelon
	 * @param 
	 * @exception ����һ�����û��ȹص�������Ϣ
	 * */
	public int insertSelective(UserWork userWork) {
		// TODO Auto-generated method stub
		int  intReslut = userWorkMapper.insertSelective(userWork);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 领取任务
	 * */
	public int insertSelectiveTrans(UserWork userWork) {
		//接参数
		//读取udid信息
		int groupDisplayId= userWork.getUserworkGroupdisplayId();
		//封装查询对象
		GroupDisplay groupDisplay = new GroupDisplay();
		groupDisplay.setGroupId(groupDisplayId);
		List<GroupDisplay> groupDisplayList = groupDisplayMapper.getGroupDisplayByConditions(groupDisplay);
		GroupDisplay groupDisplayOne= groupDisplayList.get(0);
		String outPrice = groupDisplayOne.getGroupOutprice();
		userWork.setUserworkPrice(outPrice);
		int nowNum =groupDisplayOne.getGroupNownum();
		if(nowNum>0){
			nowNum--;
			//准备更新对象,更新后的信息
			GroupDisplay groupDisplayUpdate = new GroupDisplay();
			groupDisplayUpdate.setGroupId(groupDisplayId);
			groupDisplayUpdate.setGroupNownum(nowNum);
			if(nowNum==0){
				groupDisplayUpdate.setGroupState(2);//更改发布任务状态未2,(手机不可见)
			}
			try {
				int	intReslut = userWorkMapper.insertSelective(userWork);
				int updateRes = groupDisplayMapper.updateByPrimaryKeySelective(groupDisplayUpdate);
			}catch (Exception e){
				e.printStackTrace();
				return 2;
			}
			return 1;
		}else{
 			return 2;
		}
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 删除本条任务
	 * 
	 * */
	public int deleteByPrimaryKey(int taskId) {
		// TODO Auto-generated method stub
		int  intReslut = userWorkMapper.deleteByPrimaryKey(taskId);
		return intReslut;
	}

	/**
	 * @author Shinelon
	 * @param 
	 * @exception 通过主键更新本条任务
	 * 
	 * */
	public int updateByPrimaryKeySelective(UserWork userWork) {
		// TODO Auto-generated method stub
		int  intReslut = userWorkMapper.updateByPrimaryKeySelective(userWork);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 再次领取任务
	 * 
	 * */
	public int updateByPrimaryKeySelectiveNext(UserWork userWork) {
		//接受参数
		//读取任务ID
		int groupDisplayId= userWork.getUserworkGroupdisplayId();
		//封装参数信息
		GroupDisplay groupDisplay = new GroupDisplay();
		groupDisplay.setGroupId(groupDisplayId);
		List<GroupDisplay> groupDisplayList = groupDisplayMapper.getGroupDisplayByConditions(groupDisplay);
		GroupDisplay groupDisplayOne= groupDisplayList.get(0);
		int nowNum =groupDisplayOne.getGroupNownum();
		if(nowNum>0){
			nowNum--;
			//准备需要更新的参数
			GroupDisplay groupDisplayUpdate = new GroupDisplay();
			groupDisplayUpdate.setGroupId(groupDisplayId);
			groupDisplayUpdate.setGroupNownum(nowNum);
			try {
				int	intReslut = userWorkMapper.updateByPrimaryKeySelective(userWork);
				int updateRes = groupDisplayMapper.updateByPrimaryKeySelective(groupDisplayUpdate);
			}catch (Exception e){
				e.printStackTrace();
				return 2;
			}
			return 1;
		}else{
			return 2;
		}
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 放弃领取中的任务
	 * 
	 * */
	public int updateByPrimaryKeySelectiveTransGiveUp(UserWork userWork) {
		//获取参数
		//获取任务id
		int groupDisplayId= userWork.getUserworkGroupdisplayId();
		//封装查询
		GroupDisplay groupDisplay = new GroupDisplay(); 
		groupDisplay.setGroupId(groupDisplayId);
		List<GroupDisplay> groupDisplayList = groupDisplayMapper.getGroupDisplayByConditions(groupDisplay);
		GroupDisplay groupDisplayOne= groupDisplayList.get(0);
		int nowNum =groupDisplayOne.getGroupNownum();
		if(nowNum>0){
			nowNum++;
			//封装查询
			GroupDisplay groupDisplayUpdate = new GroupDisplay();
			groupDisplayUpdate.setGroupId(groupDisplayId);
			groupDisplayUpdate.setGroupNownum(nowNum);
			try {
				int	intReslut = userWorkMapper.updateByPrimaryKeySelective(userWork);
				int updateRes = groupDisplayMapper.updateByPrimaryKeySelective(groupDisplayUpdate);
			}catch (Exception e){
				e.printStackTrace();
				return 2;
			}
			return 1;
		}else{
			return 2;
		}
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 更新本条任务完成状态,账户的金额状态
	 * 
	 * */
	public int updateByPrimaryKeySelectiveTrans(UserWork userWork) {
		
		//1.0获取参数
		String udid = userWork.getUserworkUdid();
		String idfa  =userWork.getUserworkIdfa();
		int userWorkId = userWork.getUserworkId();
		String receivetime = userWork.getUserworkReceivetime();
		
		//2.0封装参数信息
		//本次金额
		String price = userWork.getUserworkPrice();
		String priceCent = AmountUtil.DollarToCent(price);
		int priceCentInt = Integer.parseInt(priceCent);
		//3.0查询本条任务
		//3.1查回本udid的账号
		UserAccount userAccount = new UserAccount();
		userAccount.setUserAccountUserid(udid);
		List<UserAccount> userAccountResList = userAccountMapper.getUserAccountByConditions(userAccount);
		UserAccount userAccountOne = userAccountResList.get(0);
		int userAccountid = userAccountOne.getUserAccountid();
		//3.2.1取出今日收入+本次收入
		String userAccTodayin = userAccountOne.getUserAccTodayin();//2.5 str
		String userAccTodayinCent = AmountUtil.DollarToCent(userAccTodayin);//250 str
		int userAccTodayinCentInt = Integer.parseInt(userAccTodayinCent);//250 int
		userAccTodayinCentInt=userAccTodayinCentInt + priceCentInt;//450 int
		String userAccTodayinCentStr2 = userAccTodayinCentInt +"";//450 str
		String userAccTodayinAfter = AmountUtil.Cent2Dollar(userAccTodayinCentStr2);
		//3.2.2取出总收入+本次收入
		String userAccNowmoney = userAccountOne.getUserAccNowmoney();
		String userAccNowmoneyCent = AmountUtil.DollarToCent(userAccNowmoney);//250 str
		int userAccNowmoneyCentInt = Integer.parseInt(userAccNowmoneyCent);//250 int
		userAccNowmoneyCentInt=userAccNowmoneyCentInt + priceCentInt;//450 int
		String userAccNowmoneyCentStr2 = userAccNowmoneyCentInt +"";//450 str
		String userAccNowmoneyAfter = AmountUtil.Cent2Dollar(userAccNowmoneyCentStr2);
		//3.2.3取出总收入+本次收入
		String userAccAllmoney = userAccountOne.getUserAccAllmoney();
		String userAccAllmoneyCent = AmountUtil.DollarToCent(userAccAllmoney);//250 str
		int userAccAllmoneyCentInt = Integer.parseInt(userAccAllmoneyCent);//250 int
		userAccAllmoneyCentInt=userAccAllmoneyCentInt + priceCentInt;//450 int
		String userAccAllmoneyCentStr2 = userAccAllmoneyCentInt +"";//450 str
		String userAccAllmoneyAfter = AmountUtil.Cent2Dollar(userAccAllmoneyCentStr2);
		//4.0更改该udid下本条任务的状态(2完成)
		//4.1准备任务表更新的参数对象
		UserWork userWorkFinally  = new UserWork();
		userWorkFinally.setUserworkId(userWorkId);
		userWorkFinally.setUserworkUdid(udid);
		String stateAfter = userWork.getUserworkState();
		userWorkFinally.setUserworkState(stateAfter);
		userWorkFinally.setUserworkReceivetime(receivetime);
		//4.2准备账户表更新的参数对象
		UserAccount userAccountReq = new UserAccount();
		userAccountReq.setUserAccountid(userAccountid);
		userAccountReq.setUserAccTodayin(userAccTodayinAfter);
		userAccountReq.setUserAccNowmoney(userAccNowmoneyAfter);
		userAccountReq.setUserAccAllmoney(userAccAllmoneyAfter);
		//5.0更新
		int  intReslut = userWorkMapper.updateByPrimaryKeySelective(userWorkFinally);
		int updateRes = userAccountMapper.updateByPrimaryKeySelective(userAccountReq);
		return updateRes;
	}
}
