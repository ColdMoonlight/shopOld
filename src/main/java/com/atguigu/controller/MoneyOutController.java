package com.atguigu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atguigu.bean.MoneyOut;
import com.atguigu.bean.Msg;
import com.atguigu.bean.UserAccount;
import com.atguigu.service.MoneyOutService;
import com.atguigu.service.UserAccountService;
import com.atguigu.utils.AmountUtil;
import com.atguigu.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/moneyOut")
public class MoneyOutController {
	
	@Autowired
	MoneyOutService moneyOutService;
	
	@Autowired
	UserAccountService userAccountService;

	/**
	 * 1.0	useOn
	 * 去提现页面
	 * @param udid
	 * @return
	 */
	@RequestMapping(value="/getToMoneyOutPageDetail",method=RequestMethod.POST)
	//@ResponseBody
	public Msg getToMoneyOutPageDetail(@RequestBody UserAccount userAccount){
//		//读取id
		String userAccountUserid = userAccount.getUserAccountUserid();
		//用udid查询本UserAccount信息
		UserAccount UserAccountReq = new UserAccount();
		UserAccountReq.setUserAccountUserid(userAccountUserid);
		List<UserAccount> userAccountResList = userAccountService.getUserAccountByConditions(UserAccountReq);
		UserAccount userAccountOne =userAccountResList.get(0);
		String nowMoney = userAccountOne.getUserAccNowmoney();
		String outIng = userAccountOne.getUserAccOuting();
		return Msg.success().add("resMsg", "资金账户查询成功")
				.add("userAccountOne", userAccountOne);
	}
	
	/**2.0	useOn
	 * 申请体现
	 * @param udid
	 * @param price
	 * @return
	 */
	@RequestMapping(value="/applyMoneyOut",method=RequestMethod.POST)
	//@ResponseBody
	public Msg toApplyMoneyOut(@RequestBody UserAccount userAccount) {
		
		String userAccountUserid = userAccount.getUserAccountUserid();
		
		String priceOutOnce = userAccount.getUserAccOuting();
		String priceOutOnceCent = AmountUtil.DollarToCent(priceOutOnce);//250 str
		int priceOutOnceCentInt = Integer.parseInt(priceOutOnceCent);//250 int
		
		UserAccount UserAccountReq = new UserAccount();
		UserAccountReq.setUserAccountUserid(userAccountUserid);
		List<UserAccount> userAccountResList = userAccountService.getUserAccountByConditions(UserAccountReq);
		//此udid的资金账户信息
		UserAccount userAccountOne =userAccountResList.get(0);
		
		String userAlipayname = userAccountOne.getUserAlipayname();
		String userAlipaypeople = userAccountOne.getUserAlipaypeople();
		
		//查看今日提现次数
		Integer outTodayIf = userAccountOne.getUserAccOutTodayIf();
		if(outTodayIf!=0){
			return Msg.fail().add("resMsg", "每日只能发起一次提现申请");
		}
		
		//历史提现次数
		Integer accOutTimes = userAccountOne.getUserAccOutTimes();
		accOutTimes++;
		//余额转Int类型
		String nowRest = userAccountOne.getUserAccNowmoney();
		String UserAccountUsername = userAccountOne.getUserAccountUsername();
		String nowRestCent = AmountUtil.DollarToCent(nowRest);//250 str
		int nowRestCentInt = Integer.parseInt(nowRestCent);//250 int
		//是否满足提现余额
		if(nowRestCentInt>=priceOutOnceCentInt){
			//可以提现
			MoneyOut moneyOut = new MoneyOut();
			moneyOut.setMoneyoutPriceOnce(priceOutOnce);
			moneyOut.setMoneyoutUdid(userAccountUserid);
			moneyOut.setMoneyoutAdminName(UserAccountUsername);
			moneyOut.setMoneyoutSparetwo(accOutTimes);
			moneyOut.setMoneyoutAlipayname(userAlipayname);
			moneyOut.setMoneyoutAlipaypeople(userAlipaypeople);
			moneyOutService.insertSelectiveTrans(moneyOut);
			return Msg.success().add("resMsg", "提现申请成功");
		}else{
			return Msg.fail().add("resMsg", "提现申请失败");
		}
	}
	
	/**3.0	useOn
	 * 该udid用户提现记录
	 * @param udid
	 * @param price
	 * @return
	 */
	@RequestMapping(value="/getMoneyOutDetail",method=RequestMethod.POST)
//	@ResponseBody
	public Msg getMoneyOutDetail(@RequestBody UserAccount userAccount){
		//接收udid(userAccountUserid)
		String userAccountUserid = userAccount.getUserAccountUserid();
		MoneyOut moneyOut = new MoneyOut();
		moneyOut.setMoneyoutUdid(userAccountUserid);
		List<MoneyOut> moneyOutResList = moneyOutService.getMoneyOutByConditions(moneyOut);
		
		return Msg.success().add("resMsg", "提现记录查询成功")
				.add("moneyOutResList", moneyOutResList);
	}
	
	/**4.0	useOn
	 * 绑定提现账户
	 * @param udid	People Name
	 * @return
	 */
	@RequestMapping(value="/insertMoneyPeople",method=RequestMethod.POST)
//	@ResponseBody
	public Msg insertMoneyPeople(@RequestBody UserAccount userAccountIn){
		//此udid获取
		String userAccountUserid = userAccountIn.getUserAccountUserid();
		String alipayAccount = userAccountIn.getUserAlipayname();
		String alipayAccUseName =userAccountIn.getUserAlipaypeople();
		if(userAccountUserid==null||userAccountUserid.isEmpty()){
			return Msg.fail().add("resMsg", "udid不能为空֧");
		}else{
			UserAccount userAccount = new UserAccount();
			userAccount.setUserAccountUserid(userAccountUserid);
			List<UserAccount> userAccountList = userAccountService.getUserAccountByConditions(userAccount);
			UserAccount userAccountOne = userAccountList.get(0);
			Integer accId = userAccountOne.getUserAccountid();
			//封装参数信息
			UserAccount userAccountReq = new UserAccount();
			userAccountReq.setUserAccountid(accId);
			userAccountReq.setUserAlipayname(alipayAccount);
			userAccountReq.setUserAlipaypeople(alipayAccUseName);
			userAccountReq.setUserAccIfalipay("1");
			//绑定用户信息
			userAccountService.updateByPrimaryKeySelective(userAccountReq);
			return Msg.success().add("resMsg", "绑定提现账户成功");
		}
	}
	
	/**5.0	useOn
	 * 总体现记录
	 * @param udid	People Name
	 * @return
	 */
	@RequestMapping(value="/moneyOutApplyList",method=RequestMethod.POST)
//	@ResponseBody
	public Msg moneyOutApplyList(@RequestParam(value = "pn", defaultValue = "1") Integer pn
			,HttpSession session) {
		MoneyOut moneyOutReq = new MoneyOut();
		moneyOutReq.setMoneyoutApplyState("0");
		List<MoneyOut> moneyOutList = moneyOutService.getMoneyOutByConditions(moneyOutReq);
		int PagNum = 20;
		PageHelper.startPage(pn, PagNum);
		PageInfo page = new PageInfo(moneyOutList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
	/**5.0	useOn
	 * 总体现记录
	 * @param udid	People Name	moneyOutApplySuccess.jsp
	 * @return
	 */
	@RequestMapping(value="/moneyOutApplySuccessList",method=RequestMethod.POST)
//	@ResponseBody
	public Msg moneyOutApplySuccessList(@RequestParam(value = "pn", defaultValue = "1") Integer pn
			,HttpSession session) {
		MoneyOut moneyOutReq = new MoneyOut();
		moneyOutReq.setMoneyoutApplyState("1");
		List<MoneyOut> moneyOutList = moneyOutService.getMoneyOutByConditions(moneyOutReq);
		int PagNum = 20;
		PageHelper.startPage(pn, PagNum);
		PageInfo page = new PageInfo(moneyOutList, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
	
	/**6.0	useOn
	 * 打款成功
	 * @param udid
	 * @param price
	 * @return
	 */
	@RequestMapping(value="/applyMoneyOutSuccess",method=RequestMethod.POST)
	//@ResponseBody
	public Msg applyMoneyOutSuccess(@RequestBody MoneyOut moneyOut) {
		//1.0接收udid信息
		Integer moneyoutId = moneyOut.getMoneyoutId();
		String moneyoutUdid = moneyOut.getMoneyoutUdid();
		String moneyoutOperater= moneyOut.getMoneyoutOperater();
		//2.0查询本条体现记录
		MoneyOut moneyOutReq = new MoneyOut();
		moneyOutReq.setMoneyoutId(moneyoutId);
		moneyOutReq.setMoneyoutUdid(moneyoutUdid);
		List<MoneyOut> MoneyOutList = moneyOutService.getMoneyOutByConditions(moneyOutReq);
		MoneyOut moneyOutOne = MoneyOutList.get(0);
		//更新本条记录提现状态
		moneyOutReq.setMoneyoutApplyState("1");
		moneyOutReq.setMoneyoutOperater(moneyoutOperater);
		String nowTime = DateUtil.strTime14s();
		moneyOutReq.setMoneyoutApplyendtime(nowTime);
		moneyOutService.updateByPrimaryKeySelective(moneyOutReq);
		
		String outIngOnce = moneyOutOne.getMoneyoutPriceOnce();
		String outIngOnceCent = AmountUtil.DollarToCent(outIngOnce);//250 str
		int outIngOnceCentInt = Integer.parseInt(outIngOnceCent);//250 int
		
		//3.0查询账户
		UserAccount userAccountRe = new UserAccount();
		userAccountRe.setUserAccountUserid(moneyoutUdid);
		List<UserAccount> userAccountResList = userAccountService.getUserAccountByConditions(userAccountRe);
		UserAccount userAccountOne =userAccountResList.get(0);
		//3.1历史总提现额度 +本次提现
		String allout = userAccountOne.getUserAccAllout();
		String alloutCent = AmountUtil.DollarToCent(allout);//250 str
		int alloutCentInt = Integer.parseInt(alloutCent);//250 int
		alloutCentInt = alloutCentInt +outIngOnceCentInt;
		String alloutCentIntStr = alloutCentInt+"";
		String alloutAfter = AmountUtil.Cent2Dollar(alloutCentIntStr);
		//3.2正在体现中的额度 - 本次提现
		String alloutIng = userAccountOne.getUserAccOuting();
		String alloutIngCent = AmountUtil.DollarToCent(alloutIng);//250 str
		int alloutIngCentInt = Integer.parseInt(alloutIngCent);//250 int
		alloutIngCentInt = alloutIngCentInt -outIngOnceCentInt;
		String alloutIngCentIntStr = alloutIngCentInt+"";
		String alloutIngAfter = AmountUtil.Cent2Dollar(alloutIngCentIntStr);
		
		//用户账号id提现
		int accId = userAccountOne.getUserAccountid();
		
		UserAccount UserAccountReq = new UserAccount();
		UserAccountReq.setUserAccountid(accId);
		UserAccountReq.setUserAccountUserid(moneyoutUdid);
		UserAccountReq.setUserAccAllout(alloutAfter);
		UserAccountReq.setUserAccOuting(alloutIngAfter);
		//
		userAccountService.updateByPrimaryKeySelective(UserAccountReq);
		return Msg.success().add("resMsg", "提现完毕");
	}
}
