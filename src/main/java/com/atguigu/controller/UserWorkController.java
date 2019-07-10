package com.atguigu.controller;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.Msg;
import com.atguigu.bean.UserWork;
import com.atguigu.service.AppuserInfoService;
import com.atguigu.service.GroupDisplayService;
import com.atguigu.service.UserAccountService;
import com.atguigu.service.UserWorkService;
import com.atguigu.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;


//@Controller
@RestController
@RequestMapping("/userWork")
public class UserWorkController {
	
	@Autowired
	AppuserInfoService appuserInfoService;
	
	@Autowired
	UserAccountService userAccountService;
	
	@Autowired
	GroupDisplayService groupDisplayService;
	
	@Autowired
	UserWorkService userWorkService;
	
	/**0.0	useOn
	 * 查询单个任务细节
	 * @param idfa
	 * @return
	 */
	@RequestMapping(value="/appUserWorkStateAndGroupDisplayOneDet",method=RequestMethod.POST)
//	@ResponseBody
	public Msg appUserWorkStateAndGroupDisplayOneDet(@RequestBody UserWork UserWorkRIn){
		String userworkUdid = UserWorkRIn.getUserworkUdid();
		String userworkIdfa = UserWorkRIn.getUserworkIdfa();
		Integer userworkGroupdisplayId = UserWorkRIn.getUserworkGroupdisplayId();
		//文件信息
		//查找本条任务
		GroupDisplay groupDisplayReq = new GroupDisplay();
		groupDisplayReq.setGroupId(userworkGroupdisplayId);
		List<GroupDisplay> groupDisplayResList =groupDisplayService.getGroupDisplayByConditions(groupDisplayReq);
		GroupDisplay groupDisplayOne =groupDisplayResList.get(0);
		
		UserWork UserWork = new UserWork();
		UserWork.setUserworkUdid(userworkUdid); 
		UserWork.setUserworkGroupdisplayId(userworkGroupdisplayId);
		UserWork.setUserworkIdfa(userworkIdfa);
		//1.0查看该用户是否接了本条任务
		List<UserWork> userWorkResList = userWorkService.getUserWorkByConditions(UserWork);
		if(userWorkResList.size()>0){
			//1.1如果本条的状态是0  000
			UserWork userWorkOne = userWorkResList.get(0);
			String userworkState = userWorkOne.getUserworkState();
			int userworkId = userWorkOne.getUserworkId();
			if(("0").equals(userworkState)){
				//1.1.2有仅下载中的任务
				//获取系统当前时间，
				String userworkCreatetime = userWorkOne.getUserworkCreatetime();
				Long userworkCreatetimeLong = Long.valueOf(userworkCreatetime).longValue();
				Long nowTimeLong = System.currentTimeMillis();
				Long Xtimes = nowTimeLong - userworkCreatetimeLong;
				if(Xtimes>1000*60*30){
					//1.1.2.1距领取任务超过30分钟
					UserWork userWorkReq = new UserWork();
					userWorkReq.setUserworkId(userworkId);
					userWorkReq.setUserworkIdfa(userworkIdfa);
					userWorkReq.setUserworkGroupdisplayId(userworkGroupdisplayId);
					userWorkReq.setUserworkState("3");		//̬userwork_state	//0仅下载	1试玩中	2完成		3超时
					userWorkService.updateByPrimaryKeySelectiveTransGiveUp(userWorkReq);
					return Msg.success().add("resMsg", "距离上次仅下载,任务超过30分钟").add("UserWorkOne", userWorkReq).add("groupDisplayOne", groupDisplayOne);
				}else{
					//1.1.2.2距领取任务未超过30分钟
					int FreeTimes = DateUtil.getFreeTimes(userworkCreatetimeLong);
					String freeTimeStr = FreeTimes+"";
					userWorkOne.setUserworkUploadtime(freeTimeStr);			//任务剩余时间userwork_uploadtime
					return Msg.success().add("resMsg", "领取中").add("UserWorkOne", userWorkOne).add("groupDisplayOne", groupDisplayOne);
				}
			}else if(("1").equals(userworkState)){
				//1.1.3有仅下载中的任务
				String userworkCreatetime = userWorkOne.getUserworkCreatetime();
				Long userworkCreatetimeLong = Long.valueOf(userworkCreatetime).longValue();
				Long nowTimeLong = System.currentTimeMillis();
				Long Xtimes = nowTimeLong - userworkCreatetimeLong;
				if(Xtimes>1000*60*30){ 
					//1.1.3.1距领取任务超过30分钟
					UserWork userWorkReq = new UserWork();
					userWorkReq.setUserworkId(userworkId);
					userWorkReq.setUserworkIdfa(userworkIdfa);
					userWorkReq.setUserworkGroupdisplayId(userworkGroupdisplayId);
					userWorkReq.setUserworkState("3");		//̬userwork_state	//0仅下载	1试玩中	2完成		3超时
					userWorkService.updateByPrimaryKeySelectiveTransGiveUp(userWorkReq);
					return Msg.success().add("resMsg", "距离上次试玩,任务超过30分钟").add("UserWorkOne", userWorkReq).add("groupDisplayOne", groupDisplayOne);
				}else{
					//1.1.3.2距领取任务未超过30分钟
					int FreeTimes = DateUtil.getFreeTimes(userworkCreatetimeLong);
					String freeTimeStr = FreeTimes+"";
					userWorkOne.setUserworkUploadtime(freeTimeStr);			//任务剩余时间userwork_uploadtime
					return Msg.success().add("resMsg", "试玩中").add("UserWorkOne", userWorkOne).add("groupDisplayOne", groupDisplayOne);
				}
			}else if(("2").equals(userworkState)){
				//1.1.4此udid下的此idfa完成本任务
				return Msg.success().add("resMsg", "此任务已经完成").add("UserWorkOne", userWorkOne).add("groupDisplayOne", groupDisplayOne);
			}else if(("3").equals(userworkState)){
				//1.1.5此udid下的此idfa本任务超时
				return Msg.success().add("resMsg", "任务超时").add("UserWorkOne", null).add("groupDisplayOne", groupDisplayOne);
			}else{
				return Msg.success().add("resMsg", "任务放弃/超时").add("UserWorkOne", userWorkOne).add("groupDisplayOne", groupDisplayOne);
			}
		}else{
			//1.2此idfa没接过此任务
			return Msg.success().add("resMsg", "此用户没接到过此任务").add("UserWorkOne", null).add("groupDisplayOne", groupDisplayOne);
		}
	}
	
	/**2.0	useOn
	 * 开始试玩
	 * @param udid,idfa
	 * @return
	 */
	@RequestMapping(value="/ifWorkStart",method=RequestMethod.POST)
	@ResponseBody
	public Msg ifWorkStart(@RequestBody UserWork UserWorkRIn){
		
		//接收udid,任务id,判断是否开启了此任务
		Integer groupId = UserWorkRIn.getUserworkGroupdisplayId();
		
		GroupDisplay groupDisplay = new GroupDisplay();
		
		groupDisplay.setGroupId(groupId);
		
		List<GroupDisplay> groupDisplayList = groupDisplayService.getGroupDisplayByConditions(groupDisplay);
		if(groupDisplayList.size()>0){
			GroupDisplay groupDisplayOne = groupDisplayList.get(0);
			//取出开始时间
			String startTime = groupDisplayOne.getGroupStarttime();
			//获取系统时间
			String nowTime = DateUtil.strTime14s();
			
			DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				Date d1 = (Date) dateFormat.parse(startTime);
				Date d2 = (Date) dateFormat.parse(nowTime);
				if(d1.equals(d2)){
					System.out.println(startTime+"="+nowTime);
					//开始了返回成功
					return Msg.success().add("resMsg", "任务已经开始，可以进行了");
				}else if(d1.before(d2)){
					System.out.println(startTime+"在"+nowTime+"之前");
					//开始了返回成功
					return Msg.success().add("resMsg", "任务已经开始，可以进行了");
				}else if(d1.after(d2)){
					System.out.println(startTime+"在"+nowTime+"之后");
					//未开始状态
					return Msg.fail().add("resMsg", "未到任务时间开启，请耐心等待");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("方法——compareDate（{}，{}）异常"+startTime+","+nowTime);
				return Msg.fail().add("resMsg", "查询异常");
			}
			//跟系统时间比较
			return Msg.success().add("resMsg", "应该不会走这里");
		}else{
			return Msg.fail().add("resMsg", "无此任务");
		}
		
		//接收udid,任务id,判断是否开启了此任务
		
	}
	
	/**1.0	useOn
	 * 开始下载
	 * @param udid  groupDisplayId	userName
	 * @return
	 */
	@RequestMapping(value="/appUserGetWork",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAppUserGetWork(@RequestBody UserWork UserWorkRIn){
		String userworkUdid = UserWorkRIn.getUserworkUdid();
		String userworkIdfa = UserWorkRIn.getUserworkIdfa();
		Integer userworkGroupdisplayId = UserWorkRIn.getUserworkGroupdisplayId();
		
		//4,用udid,idfa下查看是否有开始下载0，试玩中1
		UserWork userWorkReq0 = new UserWork();
		userWorkReq0.setUserworkUdid(userworkUdid);
		userWorkReq0.setUserworkIdfa(userworkIdfa);
		userWorkReq0.setUserworkState("0");		//0仅下载	1试玩中	2完成		3超时
		List<UserWork> userWorkRes0 = userWorkService.getUserWorkByConditions(userWorkReq0);
		
		
		UserWork userWorkReq1 = new UserWork();
		userWorkReq1.setUserworkUdid(userworkUdid);
		userWorkReq1.setUserworkIdfa(userworkIdfa);
		userWorkReq1.setUserworkState("1");		//0仅下载	1试玩中	2完成		3超时
		List<UserWork> userWorkRes1 = userWorkService.getUserWorkByConditions(userWorkReq1);
		
		Integer userworkGroupdisplayId0 = 0;
		
		Integer userworkGroupdisplayId1 = 0;
		
		int ifHav = 0;
		if(userWorkRes0.size()>0){
			ifHav = 1;
			userworkGroupdisplayId0 =  userWorkRes0.get(0).getUserworkGroupdisplayId();
			if(userworkGroupdisplayId == userworkGroupdisplayId0){
				return Msg.success().add("resMsg", "任务领取成功/开始下载");
			}
		}else if(userWorkRes1.size()>0){
			ifHav = 1;
			userworkGroupdisplayId1 =  userWorkRes1.get(0).getUserworkGroupdisplayId();
			if(userworkGroupdisplayId == userworkGroupdisplayId1){
				return Msg.success().add("resMsg", "任务领取成功/开始下载");
			}
		}
		//查看本人时候有正在进行的任务
		if(ifHav>0){
			//有正在进行中的任务
			return Msg.fail().add("resMsg", "请先完成正在进行中的任务");
		}else{
			//没正在进行任务
			UserWork userWorkTree = new UserWork();
//			groupDisplay.setGroupId(null);						//任务IDuserwork_id
			//1封装查询参数
			userWorkTree.setUserworkGroupdisplayId(userworkGroupdisplayId);	//任务IDuserwork_groupdisplay_id
			userWorkTree.setUserworkUdid(userworkUdid);						//用户IDuserwork_udid
			userWorkTree.setUserworkIdfa(userworkIdfa);						//设备IDuserwork_idfa
			
			List<UserWork> userWorkResList = userWorkService.getUserWorkByConditions(userWorkTree);
			
			//查询本条任务多少钱
			GroupDisplay groupDisplay = new GroupDisplay();
			groupDisplay.setGroupId(userworkGroupdisplayId);
			
			List<GroupDisplay> groupDisplayList = groupDisplayService.getGroupDisplayByConditions(groupDisplay);
			GroupDisplay groupDisplayOne = groupDisplayList.get(0);
			String outMoney = groupDisplayOne.getGroupOutprice();
			int insertRes = 0;
			if(userWorkResList.size()>0){
				UserWork UserWorkOne = userWorkResList.get(0) ;
				UserWork UserWorkReq = new UserWork();
				int userWorkId = UserWorkOne.getUserworkId();
				UserWorkReq.setUserworkId(userWorkId);
				UserWorkReq.setUserworkState("0");	//̬userwork_state	//0仅下载	1试玩中	2完成		3超时
				long nowTimeBegin = System.currentTimeMillis();
				String nowTime = nowTimeBegin+"";						//系统时间转化stringֵ
				UserWorkReq.setUserworkCreatetime(nowTime);				//设置userwork_createtime
				int FreeTimes = DateUtil.getFreeTimes(nowTimeBegin);
				String freeTimeStr = FreeTimes+"";
				UserWorkReq.setUserworkUploadtime(freeTimeStr);			//任务剩余时间userwork_uploadtime
				UserWorkReq.setUserworkGroupdisplayId(userworkGroupdisplayId);
				//更新信息文件̬
				insertRes = userWorkService.updateByPrimaryKeySelectiveNext(UserWorkReq);		//这是再次进来,得更新超时的那条信息
			}else{
				//1之前没这条任务，第一次接insert
				UserWork userWork = new UserWork();
//				groupDisplay.setGroupId(null);								//任务IDuserwork_id
				userWork.setUserworkGroupdisplayId(userworkGroupdisplayId);	//本条任务IDuserwork_groupdisplay_id
				userWork.setUserworkUdid(userworkUdid);						//用户的IDuserwork_udid
				userWork.setUserworkIdfa(userworkIdfa);						//用户的本次设备idfauserwork_idfa
				long nowTimeBegin = System.currentTimeMillis();
				String nowTime = nowTimeBegin+"";							//时间戳Stringֵ
				userWork.setUserworkCreatetime(nowTime);					//放入userwork_createtime
				int FreeTimes = DateUtil.getFreeTimes(nowTimeBegin);
				String freeTimeStr = FreeTimes+"";
				userWork.setUserworkUploadtime(freeTimeStr);				//任务剩余时间userwork_uploadtime
				userWork.setUserworkState("0");								////̬userwork_state	//0仅下载	1试玩中	2完成		3超时
				userWork.setUserworkPrice(outMoney);							//价格信息userwork_price
				insertRes = userWorkService.insertSelectiveTrans(userWork);
			}
			if(insertRes==1){
				return Msg.success().add("resMsg", "任务领取成功/开始下载");
			}else{
				return Msg.fail().add("resMsg", "任务领取失败/开始下载");
			}
		}
	}
	
//	/**1.1	useOn
//	 * 开始下载
//	 * @param udid  groupDisplayId	userName
//	 * @return
//	 */
//	@RequestMapping(value="/appUserGetWork2",method=RequestMethod.POST)
//	@ResponseBody
//	public Msg getAppUserGetWork2(@RequestBody UserWork UserWorkRIn){
//		String userworkUdid = UserWorkRIn.getUserworkUdid();
//		String userworkIdfa = UserWorkRIn.getUserworkIdfa();
//		Integer userworkGroupdisplayId = UserWorkRIn.getUserworkGroupdisplayId();
//		
//		//4,用udid,idfa下查看是否有开始下载0，试玩中1
//		UserWork userWorkReq = new UserWork();
//		userWorkReq.setUserworkUdid(userworkUdid);
//		userWorkReq.setUserworkIdfa(userworkIdfa);
//		userWorkReq.setUserworkState("0");		//0仅下载	1试玩中	2完成		3超时
//		List<UserWork> userWorkRes0 = userWorkService.getUserWorkByConditions(userWorkReq);
//		
//		//如果正在进行中的本次传入的任务,直接
////		if(userWorkRes0.size()>0){
////			UserWork userWorkPD = userWorkRes0.get(0);
////			Integer kId = userWorkPD.getUserworkId();
////			if(kId == ){
////				
////			}
////		}
//		
//		userWorkReq.setUserworkState("1");		//0仅下载	1试玩中	2完成		3超时
//		List<UserWork> userWorkRes1 = userWorkService.getUserWorkByConditions(userWorkReq);
//		
//		int ifHav = 0;
//		if(userWorkRes0.size()>0){
//			ifHav = 1;
//		}else if(userWorkRes1.size()>0){
//			ifHav = 1;
//		}
//		//查看本人时候有正在进行的任务
//		if(ifHav>0){
//			//有正在进行中的任务
//			return Msg.fail().add("resMsg", "请先完成正在进行中的任务");//请先完成正在进行中的任务
//		}else{
//			//没正在进行任务
//			UserWork userWorkTree = new UserWork();
////			groupDisplay.setGroupId(null);						//任务IDuserwork_id
//			//1封装查询参数
//			userWorkTree.setUserworkGroupdisplayId(userworkGroupdisplayId);	//任务IDuserwork_groupdisplay_id
//			userWorkTree.setUserworkUdid(userworkUdid);						//用户IDuserwork_udid
//			userWorkTree.setUserworkIdfa(userworkIdfa);						//设备IDuserwork_idfa
//			
//			List<UserWork> userWorkResList = userWorkService.getUserWorkByConditions(userWorkTree);
//			
//			//查询本条任务多少钱
//			GroupDisplay groupDisplay = new GroupDisplay();
//			groupDisplay.setGroupId(userworkGroupdisplayId);
//			
//			List<GroupDisplay> groupDisplayList = groupDisplayService.getGroupDisplayByConditions(groupDisplay);
//			GroupDisplay groupDisplayOne = groupDisplayList.get(0);
//			String outMoney = groupDisplayOne.getGroupOutprice();
//			int insertRes = 0;
//			if(userWorkResList.size()>0){
//				UserWork UserWorkOne = userWorkResList.get(0) ;
//				UserWork UserWorkReq = new UserWork();
//				int userWorkId = UserWorkOne.getUserworkId();
//				UserWorkReq.setUserworkId(userWorkId);
//				UserWorkReq.setUserworkState("0");	//̬userwork_state	//0仅下载	1试玩中	2完成		3超时
//				long nowTimeBegin = System.currentTimeMillis();
//				String nowTime = nowTimeBegin+"";						//系统时间转化stringֵ
//				UserWorkReq.setUserworkCreatetime(nowTime);				//设置userwork_createtime
//				int FreeTimes = DateUtil.getFreeTimes(nowTimeBegin);
//				String freeTimeStr = FreeTimes+"";
//				UserWorkReq.setUserworkUploadtime(freeTimeStr);			//任务剩余时间userwork_uploadtime
//				UserWorkReq.setUserworkGroupdisplayId(userworkGroupdisplayId);
//				//更新信息文件̬
//				insertRes = userWorkService.updateByPrimaryKeySelectiveNext(UserWorkReq);		//这是再次进来,得更新超时的那条信息
//			}else{
//				//1之前没这条任务，第一次接insert
//				UserWork userWork = new UserWork();
////				groupDisplay.setGroupId(null);								//任务IDuserwork_id
//				userWork.setUserworkGroupdisplayId(userworkGroupdisplayId);	//本条任务IDuserwork_groupdisplay_id
//				userWork.setUserworkUdid(userworkUdid);						//用户的IDuserwork_udid
//				userWork.setUserworkIdfa(userworkIdfa);						//用户的本次设备idfauserwork_idfa
//				long nowTimeBegin = System.currentTimeMillis();
//				String nowTime = nowTimeBegin+"";							//时间戳Stringֵ
//				userWork.setUserworkCreatetime(nowTime);					//放入userwork_createtime
//				int FreeTimes = DateUtil.getFreeTimes(nowTimeBegin);
//				String freeTimeStr = FreeTimes+"";
//				userWork.setUserworkUploadtime(freeTimeStr);				//任务剩余时间userwork_uploadtime
//				userWork.setUserworkState("0");								////̬userwork_state	//0仅下载	1试玩中	2完成		3超时
//				userWork.setUserworkPrice(outMoney);							//价格信息userwork_price
//				insertRes = userWorkService.insertSelectiveTrans(userWork);
//			}
//			if(insertRes==1){
//				return Msg.success().add("resMsg", "任务领取成功/开始下载");
//			}else{
//				return Msg.fail().add("resMsg", "任务领取失败/开始下载");
//			}
//		}
//	}
	
	
	/**2.0	useOn
	 * 开始试玩
	 * @param udid,idfa
	 * @return
	 */
	@RequestMapping(value="/appUserWorkTryPlay",method=RequestMethod.POST)
	@ResponseBody
	public Msg appUserWorkTryPlay(@RequestBody UserWork UserWorkRIn) {
		String userworkUdid = UserWorkRIn.getUserworkUdid();
		String userworkIdfa = UserWorkRIn.getUserworkIdfa();
		Integer userworkGroupdisplayId = UserWorkRIn.getUserworkGroupdisplayId();
//		//准备参数信息
		UserWork userWork = new UserWork();
		userWork.setUserworkGroupdisplayId(userworkGroupdisplayId);	//设置任务IDuserwork_groupdisplay_id
		userWork.setUserworkUdid(userworkUdid);						//客户任务IDuserwork_udid
		userWork.setUserworkIdfa(userworkIdfa);						//设备idfaIDuserwork_idfa
		//1封装信息
		List<UserWork> userWorkResList = userWorkService.getUserWorkByConditions(userWork);
		//如果没有,直接告知先领取
		if(!(userWorkResList.size()>0)){
			return Msg.reBegin().add("resMsg", "请先完成正在进行中的任务");//请先领取前往下载
		}
		UserWork userWorkOne= userWorkResList.get(0);
		String uWordSate = userWorkOne.getUserworkState();
//		if("3".equals(uWordSate)){
//			return Msg.fail().add("resMsg", "任务超时,请重新领取任务/应该不会出现这种情况");
//		}else if("0".equals(uWordSate)){
//			return Msg.fail().add("resMsg", "不要作弊,请先试玩");
//		}
		int userWorkId = userWorkOne.getUserworkId();
		//2查看任务是否过期
		//2.1查看本任务当时的领取时间
		String earlyCreTime =userWorkOne.getUserworkCreatetime();
		long earlyCreTimeLong = Long.parseLong(earlyCreTime);
		//2.2此时的系统时间
		long nowTime = System.currentTimeMillis();
		//3时间差
		long XTime =nowTime - earlyCreTimeLong;
		UserWork userWorkBegin = new UserWork();
		if(XTime>(1000*60*30)){
			//任务超时
			userWorkBegin.setUserworkId(userWorkId);
			userWorkBegin.setUserworkGroupdisplayId(userworkGroupdisplayId);
			userWorkBegin.setUserworkState("3");	//̬userwork_state	//0仅下载	1试玩中	2完成		3超时
			int beginRes = userWorkService.updateByPrimaryKeySelectiveTransGiveUp(userWorkBegin);
			return Msg.fail().add("resMsg", "任务已经超时请重新领取");
		}else{
			//4未超时
			if(!"1".equals(uWordSate)){
				//4.1是第一次试玩
				userWorkBegin.setUserworkId(userWorkId);
				String nowTimeStr = nowTime+"";
				userWorkBegin.setUserworkStarttime(nowTimeStr);
				int FreeTimes = DateUtil.getFreeTimes(earlyCreTimeLong);
				String freeTimeStr = FreeTimes+"";
				userWork.setUserworkUploadtime(freeTimeStr);				//倒计时放入userwork_uploadtime
				userWorkBegin.setUserworkState("1");	//̬userwork_state	//0仅下载	1试玩中	2完成		3超时
				int beginRes = userWorkService.updateByPrimaryKeySelective(userWorkBegin);
				return Msg.success().add("resMsg", "开始试玩成功");
			}else{
				//4.2不是第一次试玩
				return Msg.success().add("resMsg", "再次开始试玩成功");
			}
		}
	}
	
	/**	useOn
	 * 3.0领取奖励
	 * @param uuid
	 * @return
	 */
	@RequestMapping(value="/appUserWorkIfWin",method=RequestMethod.POST)
	@ResponseBody
	public Msg appUserWorkIfWin(@RequestBody UserWork UserWorkRIn){
		String userworkUdid = UserWorkRIn.getUserworkUdid();
 		String userworkIdfa = UserWorkRIn.getUserworkIdfa();
		Integer userworkGroupdisplayId = UserWorkRIn.getUserworkGroupdisplayId();
//		//文件信息
		UserWork userWork = new UserWork();
		userWork.setUserworkGroupdisplayId(userworkGroupdisplayId);	//发布任务IDuserwork_groupdisplay_id
		userWork.setUserworkUdid(userworkUdid);						//用户任务记录IDuserwork_udid
		userWork.setUserworkIdfa(userworkIdfa);						//用户任务记录IDuserwork_udid
		//1查询该用户是否有本任务
		List<UserWork> userWorkResList = userWorkService.getUserWorkByConditions(userWork);
		//如果没有,直接告知领取
		if(!(userWorkResList.size()>0)){
			return Msg.reBegin().add("resMsg", "请先完成正在进行中的任务");//请先领取当前任务
		}
		//如果有,看进行的状态
		UserWork userWorkOne = userWorkResList.get(0);
		String uWordSate = userWorkOne.getUserworkState();
		if("3".equals(uWordSate)){
			return Msg.reBegin().add("resMsg", "任务超时,请重新领取任务");
		}else if("0".equals(uWordSate)){
			return Msg.fail().add("resMsg", "不要作弊,请先试玩");
		}else if("2".equals(uWordSate)){
			return Msg.fail().add("resMsg", "奖励不可重复领取");
		}
		int userWorkId = userWorkOne.getUserworkId();
		//2判断是否超时
		String earlyCreTime =userWorkOne.getUserworkCreatetime();
		long earlyCreTimeLong = Long.parseLong(earlyCreTime);
		//2.2系统时间戳
		long nowTime = System.currentTimeMillis();
		//2.3是否超时的时间差
		long XTime =nowTime - earlyCreTimeLong;
		UserWork userWorkBegin = new UserWork();
		if(XTime>(1000*60*30)){
			//2.3.1超时了
			userWorkBegin.setUserworkId(userWorkId);
			userWorkBegin.setUserworkState("3");	//̬userwork_state	//0仅下载	1试玩中	2完成		3超时
			//int beginRes = userWorkService.updateByPrimaryKeySelective(userWorkBegin);
			userWorkService.updateByPrimaryKeySelectiveTransGiveUp(userWorkBegin);
			return Msg.fail().add("resMsg", "任务超时请重新领取");
		}else{
			long nowTimePlay = System.currentTimeMillis();
			String earlyPlayTime = userWorkOne.getUserworkStarttime();
			Long earlyPlayTimeLong = Long.valueOf(earlyPlayTime).longValue();
			long XTimePlay =nowTimePlay - earlyPlayTimeLong;
			if(XTimePlay>1000*60*1){
				//试玩超过2分钟
				//2.3.2准备参数开始更新试玩时间
				UserWork userWorkToFinallyReq = new UserWork();
				userWorkToFinallyReq.setUserworkId(userWorkId);
				userWorkToFinallyReq.setUserworkState("2");//̬userwork_state	//0仅下载	1试玩中	2完成		3超时
				userWorkToFinallyReq.setUserworkUdid(userworkUdid);
				userWorkToFinallyReq.setUserworkIdfa(userworkIdfa);
				String StartPlayTime = DateUtil.strTime14s();
				String Price = userWorkOne.getUserworkPrice();
				userWorkToFinallyReq.setUserworkPrice(Price);
				userWorkToFinallyReq.setUserworkReceivetime(StartPlayTime);
				int UpdateRes = userWorkService.updateByPrimaryKeySelectiveTrans(userWorkToFinallyReq);
				return Msg.success().add("resMsg", "奖励领取成功");
			}else{
				//试玩超过2分钟
				return Msg.fail().add("resMsg", "试玩不足一分钟");
			}
		}
	}
	 
	/**4.0	useOn
	 * 手动放弃任务
	 * @param idfa
	 * @return
	 */
	@RequestMapping(value="/appUserWorkGiveUp",method=RequestMethod.POST)
	@ResponseBody
	public Msg appUserWorkGiveUp(@RequestBody UserWork UserWorkRIn){
		String userworkUdid = UserWorkRIn.getUserworkUdid();
		String userworkIdfa = UserWorkRIn.getUserworkIdfa();
		Integer userworkGroupdisplayId = UserWorkRIn.getUserworkGroupdisplayId();
		//封装参数信息
		UserWork UserWork = new UserWork();
		UserWork.setUserworkUdid(userworkUdid);
		UserWork.setUserworkGroupdisplayId(userworkGroupdisplayId);
		UserWork.setUserworkIdfa(userworkIdfa);
		List<UserWork> userWorkResList = userWorkService.getUserWorkByConditions(UserWork);
		UserWork userWorkOne = userWorkResList.get(0);
		int userWorkId = userWorkOne.getUserworkId();
		UserWork UserWorkReq = new UserWork();
		UserWorkReq.setUserworkId(userWorkId);
		UserWorkReq.setUserworkGroupdisplayId(userworkGroupdisplayId);
		UserWorkReq.setUserworkState("3");	//̬userwork_state	//0仅下载	1试玩中	2完成		3超时
		//放弃本条任务
		int updateRes = userWorkService.updateByPrimaryKeySelectiveTransGiveUp(UserWorkReq);
		//�޸�groupDisplay
		return Msg.success().add("resMsg", "任务放弃成功");
	}
	
//	/**5.0	useOn
//	 * 放弃当前任务
//	 * @param idfa
//	 * @return
//	 */
//	@RequestMapping(value="/allOutTimeToGiveUp",method=RequestMethod.POST)
//	@ResponseBody
//	public Msg allOutTimeToGiveUp(@RequestBody UserWork UserWorkRIn
////			@RequestParam(value = "userworkUdid") String userworkUdid,
////			@RequestParam(value = "userworkIdfa") String userworkIdfa,
////			@RequestParam(value = "userworkGroupdisplayId") Integer userworkGroupdisplayId
//			){
//		String userworkUdid = UserWorkRIn.getUserworkUdid();
//		String userworkIdfa = UserWorkRIn.getUserworkIdfa();
//		Integer userworkGroupdisplayId = UserWorkRIn.getUserworkGroupdisplayId();
//		//��ѯUserwork�б�������,�޸ı��������״̬
//		UserWork UserWork = new UserWork();
//		UserWork.setUserworkUdid(userworkUdid);
//		UserWork.setUserworkGroupdisplayId(userworkGroupdisplayId);
//		UserWork.setUserworkIdfa(userworkIdfa);
//		List<UserWork> userWorkResList = userWorkService.getUserWorkByConditions(UserWork);
//		UserWork userWorkOne = userWorkResList.get(0);
//		int userWorkId = userWorkOne.getUserworkId();
//		UserWork UserWorkReq = new UserWork();
//		UserWorkReq.setUserworkId(userWorkId);
//		UserWorkReq.setUserworkGroupdisplayId(userworkGroupdisplayId);
//		UserWorkReq.setUserworkState("3");	//���״̬userwork_state	0��ȡ	1����	2���	3��ʱ/����
//		//�޸Ĵ�idfa�µı�����״̬
//		int updateRes = userWorkService.updateByPrimaryKeySelectiveTransGiveUp(UserWorkReq);
//		//�޸�groupDisplay���еı���������
//		return Msg.success().add("resMsg", "ȡ��ɹ�");
//	}
	
	/**5.0	useOn
	 * 查看完成的任务
	 * @param idfa
	 * @return
	 */
	@RequestMapping(value="/allEndTask",method=RequestMethod.POST)
	@ResponseBody
	public Msg allEndTask(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn
			,HttpSession session){
		//
		UserWork UserWork = new UserWork();
		UserWork.setUserworkState("2");
		List<UserWork> userWorkResList = userWorkService.getUserWorkByConditions(UserWork);
		if(!(userWorkResList.size()>0)){
			return Msg.fail().add("resMsg", "没有完成记录");
		}else{
			//分页返回
			int PagNum = 10;
			PageHelper.startPage(pn, PagNum);
//			List<GroupDisplay> groupDisplay = groupDisplayService.getGroupDisplayAll();
			PageInfo page = new PageInfo(userWorkResList, PagNum);
			return Msg.success().add("pageInfo", page);
		}
	}
	
	/**5.0	useOn
	 * 查看完成的任务
	 * @param idfa
	 * @return
	 */
	@RequestMapping(value="/udidEndTaskDetail",method=RequestMethod.POST)
	@ResponseBody
	public Msg udidEndTaskDetail(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "userworkUdid") String userworkUdid){
		//文件信息
		UserWork UserWork = new UserWork();
		UserWork.setUserworkState("2");
		UserWork.setUserworkUdid(userworkUdid);
		List<UserWork> userWorkResList = userWorkService.getUserWorkByConditions(UserWork);
		if(!(userWorkResList.size()>0)){
			return Msg.fail().add("resMsg", "没有完成记录");
		}else{
			//分页返回
			int PagNum = 10;
			PageHelper.startPage(pn, PagNum);
//			List<GroupDisplay> groupDisplay = groupDisplayService.getGroupDisplayAll();
			PageInfo page = new PageInfo(userWorkResList, PagNum);
			return Msg.success().add("pageInfo", page);
		}
	}
	
	
	
	/**5.0	useOn
	 * 查看完成的任务
	 * @param idfa
	 * @return
	 */
	@RequestMapping(value="/udidEndTaskDetailPage",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView udidEndTaskDetailPage(
			@RequestParam(value = "userworkUdid") String userworkUdid){
		//文件信息
		ModelAndView modelAndView= new ModelAndView();
		UserWork UserWork = new UserWork();
		UserWork.setUserworkState("2");
		UserWork.setUserworkUdid(userworkUdid);
		List<UserWork> userWorkResList = userWorkService.getUserWorkByConditions(UserWork);
		if(!(userWorkResList.size()>0)){
			modelAndView.setViewName("alludidEndTaskdetail");
		}else{
			//return Msg.success().add("pageInfo", page);
			modelAndView.setViewName("alludidEndTaskdetail");
			modelAndView.addObject("userworkUdid", userworkUdid);
		}
		return modelAndView;
	}
}
