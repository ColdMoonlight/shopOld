package com.atguigu.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.bean.AppuserInfo;
import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.Msg;
import com.atguigu.bean.UserAccount;
import com.atguigu.bean.UserWork;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.AppuserInfoService;
import com.atguigu.service.GroupDisplayService;
import com.atguigu.service.UserAccountService;
import com.atguigu.service.UserWorkService;
import com.atguigu.utils.DateUtil;
import com.atguigu.utils.UUIDUtils;


//@Controller
@RestController
@RequestMapping("/appuserInfo")
public class AppuserInfoController {
	
	@Autowired
	AppuserInfoService appuserInfoService;
	
	@Autowired
	UserAccountService userAccountService;
	
	@Autowired
	GroupDisplayService groupDisplayService;
	
	@Autowired
	UserWorkService userWorkService;
	 
	/**0.1	useOn
	 * 无udid登陆查看列表
	 * @param idfa
	 * @return
	 */
	@RequestMapping(value="/appHomeOff",method=RequestMethod.POST)
//	@ResponseBody
	public Msg getAppHomeOff(@RequestBody AppuserInfo appuserInfo){
		
		//3接收参数信息信息	查询状态为1的任务(1为发布状态)
		GroupDisplay groupDisplayReq = new GroupDisplay();
		groupDisplayReq.setGroupState(1);//0仅发布(后台可见)	1上架	0完成	2下架
		List<GroupDisplay> groupDisplayResList = groupDisplayService.getGroupDisplayByConditionsORderBy(groupDisplayReq);
		//返回查看的信息参数
		return Msg.success().add("resMsg", "当前可做任务查询成功")
				.add("groupDisplayResList", groupDisplayResList);
	}
	
	/**1.0	useOn
	 * udid登陆
	 * @param udid,idfa
	 * @return
	 */
	@RequestMapping(value="/appuserLogin",method=RequestMethod.POST)
	public Msg cheakAppuserInfo(@RequestBody AppuserInfo appuserInfoIn) {
//		//接收参数信息信息
		AppuserInfo appuserInfoReq = new AppuserInfo();
		String appuserInfoUdid = appuserInfoIn.getAppuserUdid();
//		String appuserInfoIdfa = appuserInfo.getAppuserIdfa();
		appuserInfoReq.setAppuserUdid(appuserInfoUdid);
		if(appuserInfoUdid==null||appuserInfoUdid.isEmpty()){
			return Msg.success().add("resMsg", "无udid用户,登录失败");
		}else{
			List<AppuserInfo> appuserInfoResList = appuserInfoService.getAppuserInfoByConditions(appuserInfoReq);
			if(appuserInfoResList.size()>0){
				AppuserInfo appuserInfoOne = appuserInfoResList.get(0);
				String token = appuserInfoOne.getAppuserName();
				return Msg.success().add("resMsg", "此udid为老用户,再次登陆成功").add("token", token);
			}else{
				//新用户
				//初始化本udid的appUser对象
				AppuserInfo insertAppUserRes = insertAppUser(appuserInfoIn);
				String token = insertAppUserRes.getAppuserName();
				//初始化本udid的appUserAccount对象
				int insertappUserAccountRes = insertUserAccount(insertAppUserRes);
				return Msg.success().add("resMsg", "此udid为新用户,账户初始化完毕，登陆成功").add("token", token);
			}
		}
	}
	
	/**1.1	useOn
	 * appuser初始化
	 * @param udid,idfa
	 * @return
	 * */
	private AppuserInfo insertAppUser(AppuserInfo appuserInfo) {
//		//0接收参数信息信息
		String appuserInfoUdid = appuserInfo.getAppuserUdid();
		String appuserInfoIdfa = appuserInfo.getAppuserIdfa();
		//创建对象
		AppuserInfo appuserInfoInsert = new AppuserInfo();
//		appuserInfo.setAppuserId(null);							//用户IDappuser_id
		appuserInfoInsert.setAppuserIp("");						//用户IPappuser_ip	VARCHAR(64)
		appuserInfoInsert.setAppuserMobile("");					//用户手机号appuser_mobile	VARCHAR(64)
		String appuserName = UUIDUtils.getId();
		appuserName= appuserName.substring(0,12);
		appuserInfoInsert.setAppuserName(appuserName);			//用户昵称appuser_name	VARCHAR(64) NOT NULL
		appuserInfoInsert.setAppuserIdfa(appuserInfoIdfa);		//用户idfa appuser_idfa		VARCHAR(128) NOT NULL
		appuserInfoInsert.setAppuserUdid(appuserInfoUdid);		//用户udid	appuser_udid		VARCHAR(128)
		String nowTime = DateUtil.strTime14s();
		appuserInfoInsert.setAppuserCreatetime(nowTime);		//用户注册时间appuser_createtime		VARCHAR(128) NOT NULL
		appuserInfoInsert.setAppuserLasttime(nowTime);			//用户最后登陆的时间appuser_lasttime	VARCHAR(128) NOT NULL
		appuserInfoInsert.setAppuserSparethree("1");
		int intResult = appuserInfoService.insertSelective(appuserInfoInsert);
		if(intResult==1){
			//成功返回
			return appuserInfoInsert;
		}else{
			//失败返回
			return appuserInfoInsert;
		}
	}
	
	/**1.2	useOn
	 * userAccount初始化
	 * @param AppuserInfo
	 * @return
	 * */
	private int insertUserAccount(AppuserInfo insertAppUserReq) {
//		//0接收参数信息信息
		String udid = insertAppUserReq.getAppuserUdid();
		String username = insertAppUserReq.getAppuserName();
		//2初始化UserAccount信息
		UserAccount userAccount = new UserAccount();
//		userAccount.setUserAccountid(null);				//资金账户IDuser_accountid				INT(16)			NOT NULL
		userAccount.setUserAccountUserid(udid);			//资金账户的用户ID(udid)user_account_userid		VARCHAR(64)		NOT NULL
		userAccount.setUserAccountUsername(username);	//资金账户昵称user_account_username	VARCHAR(64)		NOT NULL
		userAccount.setUserAccNowmoney("0.00");			//账户余额user_acc_nowmoney			VARCHAR(64) 	NOT NULL
		userAccount.setUserAccAllmoney("0.00");			//累计收入user_acc_allmoney			VARCHAR(64)		NOT NULL
		userAccount.setUserAccTodayin("0.00");			//进入收入user_acc_todayIn		VARCHAR(64)		NOT NULL
		userAccount.setUserAccAllout("0.00");			//全部提现金额user_acc_allout			VARCHAR(64)		NOT NULL
		userAccount.setUserAccIfalipay("0");			//是否绑定支付宝user_acc_ifalipay		VARCHAR(8)		NOT NULL
		userAccount.setUserAlipayname("");		//֧支付账号user_alipayname			VARCHAR(128)	NOT NULL
		userAccount.setUserAlipaypeople("");	//֧支付姓名user_alipaypeople 		VARCHAR(128)	NOT NULL
		userAccount.setUserAccOutTimes(0);			//备用字段1appuser_sparetwo			INT(16)
		userAccount.setUserAccOutTodayIf(0);		//备用字段2appuser_sparetwo			INT(16)
		userAccount.setUserAccOuting("0.00");			//备用字段3appuser_Outing				VARCHAR(128)
//		userAccount.setUserAccSparefour("0");			//备用字段4appuser_sparefour			VARCHAR(128)
		int insertUAccRes = userAccountService.insertSelective(userAccount);
		return insertUAccRes;
	}
	
	/**2.1	useOn
	 * 含udid的任务页面
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="/appHomeOn",method=RequestMethod.POST)
//	@ResponseBody
	public Msg getAppHomeOn(@RequestBody AppuserInfo appuserInfo){
		//获取传入的udid
		String udid = appuserInfo.getAppuserUdid();
		String idfa = appuserInfo.getAppuserIdfa();
		//1,用udid,查询用户对象appuserInfo
		AppuserInfo appuserInfoReq = new AppuserInfo();
		appuserInfoReq.setAppuserUdid(udid);
		List<AppuserInfo> appuserInfoRes = appuserInfoService.getAppuserInfoByConditions(appuserInfoReq);
		if(appuserInfoRes.size()>0){
			AppuserInfo appuserInfoOne = appuserInfoRes.get(0);
			
			//2,用udid查userAccount余额,今日收入,总额
			UserAccount userAccountReq = new UserAccount();
			userAccountReq.setUserAccountUserid(udid);
			List<UserAccount> userAccountRes = userAccountService.getUserAccountByConditions(userAccountReq);
			UserAccount userAccountOne = userAccountRes.get(0);
			
			//3,查询有没有进行中的任务
			GroupDisplay groupDisplayReq = new GroupDisplay();
			groupDisplayReq.setGroupState(1);	//0仅发布(未上架) 0仅发布	1上架	0完成	2下架
//			List<GroupDisplay> groupDisplayResList = groupDisplayService.getGroupDisplayByConditions(groupDisplayReq);
			List<GroupDisplay> groupDisplayResList = groupDisplayService.getGroupDisplayByConditionsORderBy(groupDisplayReq);
			
			//4,用udid,查看是否有进行中0，开始下载1，完结2的任务
			UserWork userWorkReq = new UserWork();
			userWorkReq.setUserworkUdid(appuserInfoReq.getAppuserUdid());
			userWorkReq.setUserworkIdfa(idfa);
			userWorkReq.setUserworkState("0");		//0仅下载	1试玩中	2完成		3超时
			List<UserWork> userWorkRes0 = userWorkService.getUserWorkByConditions(userWorkReq);
			
			userWorkReq.setUserworkState("1");		//0仅下载	1试玩中	2完成		3超时
			List<UserWork> userWorkRes1 = userWorkService.getUserWorkByConditions(userWorkReq);
			
			userWorkReq.setUserworkState("2");		//0仅下载	1试玩中	2完成		3超时
			List<UserWork> userWorkRes2 = userWorkService.getUserWorkByConditions(userWorkReq);
			
			int runWork = 3;
			int runWorkss = 0;
			if(userWorkRes2.size()>0){
				runWork = 2;	//有0仅仅下载的任务
			}

			UserWork userWorkResOne = null;
			List<GroupDisplay> groupDisplayResList2 = new ArrayList<GroupDisplay>();
//			List<GroupDisplay> groupDisplayResList3 = new ArrayList<GroupDisplay>();
			
			for(GroupDisplay groupDisplayk:groupDisplayResList){
				groupDisplayResList2.add(groupDisplayk);
			}
			if(runWork==2){//有2完成的任务
				runWorkss = 1;
				//此idfa下有没有2完成的任务
				List<Integer> IdList = new ArrayList<Integer>();
				for(int i=0;i<userWorkRes2.size();i++){
					IdList.add(userWorkRes2.get(i).getUserworkGroupdisplayId());
				}
				//获取已完成任务的任务id
				for(int i=0;i<IdList.size();i++){
					int id = IdList.get(i);
					int lsize = groupDisplayResList.size();
					int k=0;
					for(int j = 0;j<lsize;j++){
						GroupDisplay groupDisplayDet = groupDisplayResList.get(k);
						k++;
						int groupid = groupDisplayDet.getGroupId();
						if(groupid==id){
							groupDisplayResList2.remove(groupDisplayDet);
							j--;
							lsize--;
						}
					}
				}
				userWorkResOne = null;
			}
			if(userWorkRes0.size()>0){
				runWork = 0;	//有0仅仅下载的任务
			}
			if(userWorkRes1.size()>0){
				runWork = 1;	//有1试玩中的任务
			}
			if(runWork==0){
				runWorkss = 1;
				userWorkResOne = userWorkRes0.get(0);
				//此idfa下有没有0进行中的任务
				int groupdisplayId = userWorkResOne.getUserworkGroupdisplayId();
				
				for(GroupDisplay groupDisplayDet:groupDisplayResList){
					int groupid = groupDisplayDet.getGroupId();
					if(groupid==groupdisplayId){
						groupDisplayResList2.remove(groupDisplayDet);
					}
				}
			}else if(runWork==1){
				runWorkss = 1;
				userWorkResOne = userWorkRes1.get(0);
				//此idfa下有没有1试玩中的任务
				int groupdisplayId = userWorkResOne.getUserworkGroupdisplayId();
				for(GroupDisplay groupDisplayDet:groupDisplayResList){
					int groupid = groupDisplayDet.getGroupId();
					if(groupid==groupdisplayId){
						groupDisplayResList2.remove(groupDisplayDet);
					}
				}
			}
			if(runWorkss==0){
				groupDisplayResList2 = groupDisplayResList;
			}
			GroupDisplay groupDisplayOne =null;
			if(userWorkResOne!=null){
				Integer groupid = userWorkResOne.getUserworkGroupdisplayId();
				GroupDisplay groupDisplayOneReq = new GroupDisplay();
				groupDisplayOneReq.setGroupId(groupid);
				List<GroupDisplay> groupDisplayList = groupDisplayService.getGroupDisplayByConditions(groupDisplayOneReq);
				groupDisplayOne = groupDisplayList.get(0);
			}
			
			//遍历结果list如果没开始,替换名字和图标
			List<GroupDisplay> groupDisplayListUnBeginList = new ArrayList<GroupDisplay>();
			if(groupDisplayResList2.size()>0){
				int num = groupDisplayResList2.size();
				for(int i=0;i<num;i++ ){
					GroupDisplay groupDisplayIfBegin =groupDisplayResList2.get(i);
					//取出开始时间
					String startTime = groupDisplayIfBegin.getGroupStarttime();
					//获取系统时间
					String nowTime = DateUtil.strTime14s();
					
					DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					try {
						Date d1 = (Date) dateFormat.parse(startTime);
						Date d2 = (Date) dateFormat.parse(nowTime);
						if(d1.after(d2)){
							//未开始状态
							System.out.println(startTime+"在"+nowTime+"之后");
							//移除本条
							groupDisplayResList2.remove(i);
							i--;
							num--;
							//替换图片，替换名字
							groupDisplayIfBegin.setGroupPimageurl("http://47.92.171.86:8080/ShareNum/static/img/xx01.png");
							groupDisplayIfBegin.setGroupTaskName("XX应用");
							
							startTime= startTime.substring(10, startTime.length()-3);
							groupDisplayIfBegin.setGroupReqexplain("今日"+startTime+"开始");
							groupDisplayListUnBeginList.add(groupDisplayIfBegin);
							//return Msg.fail().add("resMsg", "未到任务时间开启，请耐心等待");
						}
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println("方法——compareDate（{}，{}）异常"+startTime+","+nowTime);
						return Msg.fail().add("resMsg", "查询异常");
					}
				}
			}
			if(!(groupDisplayListUnBeginList.size()>0)){
				groupDisplayListUnBeginList = null;
			}
			return Msg.success().add("resMsg", "含udid登陆成功")
					.add("appuserInfoOn", appuserInfoOne)
					.add("userAccountOn", userAccountOne)
					.add("userWorkResOn", userWorkResOne)
					.add("groupDisplayOne", groupDisplayOne)
					.add("groupDisplayResList", groupDisplayResList2)
					.add("groupDisplayListUnBeginList", groupDisplayListUnBeginList);
		}else{
			return Msg.fail().add("resMsg", "查不到该udid对象登陆成功");
		}
	}

	/**3.1	useOn
	 * 含udid个人
	 * @param idfa
	 * @return
	 */
	@RequestMapping(value="/personalCenterOn",method=RequestMethod.POST)
	@ResponseBody
	public Msg getpersonalCenterOn(@RequestBody AppuserInfo appuserInfo){
		String idfa = appuserInfo.getAppuserIdfa();
		String udid = appuserInfo.getAppuserUdid();
		//1用udid查询appuser对象
		AppuserInfo appuserInfoReq = new AppuserInfo();
		appuserInfoReq.setAppuserUdid(udid);
		List<AppuserInfo> appuserInfoResList = appuserInfoService.getAppuserInfoByConditions(appuserInfoReq);
		if(appuserInfoResList.size()>0){
			
			AppuserInfo appuserInfoOne = appuserInfoResList.get(0);
			
			//2用udid查询userAccount对象
			UserAccount userAccountReq = new UserAccount();
			userAccountReq.setUserAccountUserid(udid);
			List<UserAccount> userAccountResList = userAccountService.getUserAccountByConditions(userAccountReq);
			UserAccount userAccountOne =userAccountResList.get(0);
			return Msg.success().add("resMsg", "个人账户信息查询完毕")
					.add("appuserInfo", appuserInfoOne)
					.add("userAccount", userAccountOne);
		}else{
			return Msg.fail().add("resMsg", "个人账户信息查询失败");
		}
	}
}
