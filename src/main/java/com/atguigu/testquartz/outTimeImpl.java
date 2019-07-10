package com.atguigu.testquartz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.atguigu.bean.UserWork;
import com.atguigu.dao.UserAccountMapper;
import com.atguigu.dao.UserWorkMapper;
import com.atguigu.dao.quartz.outTime;
import com.atguigu.service.UserWorkService;
@Component
public class outTimeImpl implements outTime {
	
	
	@Autowired
	UserAccountMapper userAccountMapper;
	
	@Autowired
	UserWorkMapper userWorkMapper;
	
	@Autowired
	UserWorkService userWorkService;
	
	
	//@Scheduled(cron="0 */30 *  * * ? ")   //每30分钟执行一次
	@Override
	public void outTime() {
		System.out.println("outTime开始");
		//查询全部userWork状态为0,1
		
		UserWork userWorkReq0 = new UserWork();
		userWorkReq0.setUserworkState("0");
		
		List<UserWork> userWork0List = userWorkMapper.getUserWorkByConditions(userWorkReq0);
		
		
		//如果有文件信息
		if(userWork0List.size()>0){
			//准备遍历
			for(UserWork userWork0:userWork0List){
				//System.out.println(userWork0);
				Integer userWorkId = userWork0.getUserworkId();
				Integer userworkGroupdisplayId = userWork0.getUserworkGroupdisplayId();
				String userworkCreatetime = userWork0.getUserworkCreatetime();
				Long userworkCreatetimeLong = Long.valueOf(userworkCreatetime).longValue();
				Long nowTimeLong = System.currentTimeMillis();
				Long Xtimes = nowTimeLong - userworkCreatetimeLong;
				if(Xtimes>1000*60*30){
					//1.0超时
					//1.1准备更新
					UserWork UserWorkReq = new UserWork();
					UserWorkReq.setUserworkId(userWorkId);
					UserWorkReq.setUserworkGroupdisplayId(userworkGroupdisplayId);
					UserWorkReq.setUserworkState("3");
					//放弃任务
					userWorkService.updateByPrimaryKeySelectiveTransGiveUp(UserWorkReq);
					System.out.println("0:userWorkId:"+userWorkId);
				}
			}
		}
		
		UserWork userWorkReq1 = new UserWork();
		userWorkReq1.setUserworkState("1");
		
		List<UserWork> userWork1List = userWorkMapper.getUserWorkByConditions(userWorkReq1);
		//如果有文件信息
		if(userWork1List.size()>0){
			//准备遍历
			for(UserWork userWork1:userWork1List){
				//System.out.println(userWork1);
				Integer userWorkId = userWork1.getUserworkId();
				Integer userworkGroupdisplayId = userWork1.getUserworkGroupdisplayId();
				String userworkCreatetime = userWork1.getUserworkCreatetime();
				Long userworkCreatetimeLong = Long.valueOf(userworkCreatetime).longValue();
				Long nowTimeLong = System.currentTimeMillis();
				Long Xtimes = nowTimeLong - userworkCreatetimeLong;
				if(Xtimes>1000*60*30){
					//1.0超时
					//1.1准备更新
					UserWork UserWorkReq = new UserWork();
					UserWorkReq.setUserworkId(userWorkId);
					UserWorkReq.setUserworkGroupdisplayId(userworkGroupdisplayId);
					UserWorkReq.setUserworkState("3");
					//放弃任务
					userWorkService.updateByPrimaryKeySelectiveTransGiveUp(UserWorkReq);
					System.out.println("1:userWorkId:"+userWorkId);
				}
			}
		}
	}
}
