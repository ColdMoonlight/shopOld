package com.atguigu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackAreafreight;
import com.atguigu.bean.MlbackCategory;
import com.atguigu.bean.MlbackCoupon;
import com.atguigu.bean.MlfrontAddress;
import com.atguigu.bean.MlfrontOrder;
import com.atguigu.bean.MlfrontOrderItem;
import com.atguigu.bean.MlfrontPayInfo;
import com.atguigu.bean.MlfrontUser;
import com.atguigu.bean.Msg;
import com.atguigu.bean.PageTimeVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackAreafreightService;
import com.atguigu.service.MlbackCategoryService;
import com.atguigu.service.MlfrontAddressService;
import com.atguigu.service.MlfrontOrderItemService;
import com.atguigu.service.MlfrontOrderService;
import com.atguigu.service.MlfrontPayInfoService;
import com.atguigu.service.MlfrontUserService;
import com.atguigu.utils.DateUtil;


@Controller
@RequestMapping("/MlfrontPayInfo")
public class MlfrontPayInfoController {
		
	@Autowired
	MlfrontPayInfoService mlfrontPayInfoService;
	
	@Autowired
	MlfrontOrderService mlfrontOrderService;
	
	@Autowired
	MlfrontOrderItemService mlfrontOrderItemService;
	
	@Autowired
	MlfrontUserService mlfrontUserService;
	
	@Autowired
	MlbackAreafreightService mlbackAreafreightService;
	
	@Autowired
	MlfrontAddressService mlfrontAddressService;
	
	@Autowired
	MlbackAdminService mlbackAdminService;
	
	/**
	 * 1.0	UseNow	0505
	 * toMlfrontPayInfoSuccess列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlfrontPayInfoSuccess")
	public String toMlfrontPayInfoSuccess() throws Exception{
	
		return "mfront/paySuccess";
	}
	
	/**
	 * 2.0	UseNow	0505
	 * toMlfrontPayInfofail列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlfrontPayInfofail")
	public String toMlfrontPayInfofail() throws Exception{
	
		return "mfront/payFail";
	}
	
	/**
	 * 3.0	UseNow	0505
	 * toMlfrontPayInfoList列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackPayInfoList")
	public String toMlbackPayInfoList() throws Exception{
	
		return "back/mlbackPayInfoPage";
	}
	
	/**
	 * 4.0	UseNow	0505
	 * to	MlfrontOrder列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping(value="/getMlfrontPayInfoByDate",method=RequestMethod.POST)
	@ResponseBody
	public Msg getMlfrontPayInfoByDate(HttpServletResponse rep,HttpServletRequest res,HttpSession session ,@RequestBody PageTimeVo pageTime){
	
		Integer pn = pageTime.getPn();
		if(pn==null){
			pn=1;
		}
		String beginTime = pageTime.getBeginTime();
		String endTime = pageTime.getEndTime();
		MlfrontPayInfo mlfrontPayInfoReq = new MlfrontPayInfo();
		mlfrontPayInfoReq.setPayinfoCreatetime(beginTime);
		mlfrontPayInfoReq.setPayinfoMotifytime(endTime);
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
			int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlfrontPayInfo> mlfrontPayInfoReqList = mlfrontPayInfoService.selectMlfrontPayInfoByDate(mlfrontPayInfoReq);
			Integer countNumber =mlfrontPayInfoReqList.size();
			PageInfo page = new PageInfo(mlfrontPayInfoReqList, PagNum);
			return Msg.success().add("pageInfo", page).add("countNumber", countNumber).add("resMsg", "付款单数查询成功");
	}
	
	/**5.0	useOn	0505
	 * 分类MlfrontPayInfo列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getMlfrontPayInfoByPage")
	@ResponseBody
	public Msg getMlfrontPayInfoWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
		int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlfrontPayInfo> mlfrontPayInfoList = mlfrontPayInfoService.selectMlfrontPayInfoAll();
			PageInfo page = new PageInfo(mlfrontPayInfoList, PagNum);
			return Msg.success().add("pageInfo", page);
//		}
	}
	
	/**6.0	useOn	0505
	 * MlfrontPayInfo	insert
	 * @param MlfrontPayInfo
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveSelective(HttpServletResponse rep,HttpServletRequest res,@RequestBody MlfrontPayInfo mlfrontPayInfo){
		//接受参数信息
		System.out.println("mlfrontPayInfo:"+mlfrontPayInfo);
		//取出id
		System.out.println(1);
		Integer payinfoIdId = mlfrontPayInfo.getPayinfoId();
		String nowTime = DateUtil.strTime14s();
		mlfrontPayInfo.setPayinfoMotifytime(nowTime);;
		if(payinfoIdId==null){
			//无id，insert
			mlfrontPayInfo.setPayinfoCreatetime(nowTime);;
			int intResult = mlfrontPayInfoService.insertSelective(mlfrontPayInfo);
			System.out.println(intResult);
			return Msg.success().add("resMsg", "插入成功");
		}else{
			//有id，update
			int intResult = mlfrontPayInfoService.updateByPrimaryKeySelective(mlfrontPayInfo);
			System.out.println(intResult);
			return Msg.success().add("resMsg", "更新成功");
			
		}		
	}
	
	/**7.0	useOn	0505
	 * MlfrontPayInfo	delete
	 * @param id
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(@RequestBody MlfrontPayInfo mlfrontPayInfo){
		//接收id信息
		Integer payinfoIdId = mlfrontPayInfo.getPayinfoId();
		int intResult = mlfrontPayInfoService.deleteByPrimaryKey(payinfoIdId);
		return Msg.success().add("resMsg", "delete success");
	}
	
	
	/**
	 * 8.0	useOn	0505
	 * 查看单条类目的详情细节
	 * @param MlfrontPayInfo
	 * @return 
	 */
	@RequestMapping(value="/getOneMlfrontPayInfoDetail",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneMlfrontPayInfoDetail(@RequestParam(value = "payinfoId") Integer payinfoId){
		
		//接受payinfoId
		MlfrontPayInfo mlfrontPayInfoReq = new MlfrontPayInfo();
		mlfrontPayInfoReq.setPayinfoId(payinfoId);
		//1.查询本条pay支付单
		List<MlfrontPayInfo> mlfrontPayInfoResList =mlfrontPayInfoService.selectMlfrontPayInfoById(mlfrontPayInfoReq);
		MlfrontPayInfo mlfrontPayInfoOne = new MlfrontPayInfo();
		if(mlfrontPayInfoResList.size()>0){
			mlfrontPayInfoOne =mlfrontPayInfoResList.get(0);
		}else{
			mlfrontPayInfoOne = null;
		}
		//2.获取本条单子的orderId，2.1查询本条的order详情;2.2从详情中拿到addressid;2.3orderItemIDStr;2.4uid信息，历史购买次数;
		//2.1查询本条的order详情;
		Integer payinfoOid = mlfrontPayInfoOne.getPayinfoOid();
		MlfrontOrder mlfrontOrderPay = new MlfrontOrder();
		mlfrontOrderPay.setOrderId(payinfoOid);
		List<MlfrontOrder> mlfrontOrderPayResList= mlfrontOrderService.selectMlfrontOrderById(mlfrontOrderPay);
		MlfrontOrder mlfrontOrderPayOneRes = mlfrontOrderPayResList.get(0);
		//2.2从详情中拿到addressid;
		Integer addressinfoId = mlfrontOrderPayOneRes.getAddressinfoId();
		MlfrontAddress MlfrontAddressReq = new MlfrontAddress();
		MlfrontAddressReq.setAddressId(addressinfoId);
		List<MlfrontAddress> MlfrontAddressList = mlfrontAddressService.selectMlfrontAddressById(MlfrontAddressReq);
		MlfrontAddress mlfrontAddressOne = MlfrontAddressList.get(0);
		//2.3从详情中拿到orderItemIDStr;
		String orderItemIdsStr = mlfrontOrderPayOneRes.getOrderOrderitemidstr();
		List<MlfrontOrderItem>  mlfrontOrderItemList = new ArrayList<MlfrontOrderItem>();
		MlfrontOrderItem mlfrontOrderItemOne = new MlfrontOrderItem();
		MlfrontOrderItem mlfrontOrderItemOneReq = new MlfrontOrderItem();
		String orderItemIdStrArr [] = orderItemIdsStr.split(",");
		String orderItemIdStr = "";
		Integer orderItemIdInt = 0;
		for(int i =0;i<orderItemIdStrArr.length;i++){
			orderItemIdStr = orderItemIdStrArr[i];
			orderItemIdInt = Integer.parseInt(orderItemIdStr);
			mlfrontOrderItemOneReq.setOrderitemId(orderItemIdInt);
			List<MlfrontOrderItem> mlfrontOrderItemResList = mlfrontOrderItemService.selectMlfrontOrderItemById(mlfrontOrderItemOneReq);
			mlfrontOrderItemOne = mlfrontOrderItemResList.get(0);
			mlfrontOrderItemList.add(mlfrontOrderItemOne);
		}
		//2.4uid信息
		Integer uid = mlfrontOrderPayOneRes.getOrderUid();
		MlfrontUser mlfrontUserOne = new MlfrontUser();
		if(uid==null){
			mlfrontUserOne = null;
		}else{
			MlfrontUser mlfrontUserReq = new MlfrontUser();
			mlfrontUserReq.setUserId(uid);
			List<MlfrontUser> mlfrontUserList = mlfrontUserService.selectMlfrontUser(mlfrontUserReq);
			mlfrontUserOne = mlfrontUserList.get(0);
		}
		return Msg.success().add("resMsg", "查看单条mlfrontPayInfoOne的详情细节完毕")
					.add("mlfrontPayInfoOne", mlfrontPayInfoOne).add("mlfrontOrderPayOneRes", mlfrontOrderPayOneRes)
					.add("mlfrontAddressOne", mlfrontAddressOne).add("mlfrontOrderItemList", mlfrontOrderItemList)
					.add("mlfrontUserOne", mlfrontUserOne);
	}
	
	
	
	/**7.0
	 * @author Shinelon
	 * @exception 导出单一发布任务执行明细
	 * @param MlbackAreafreight
	 * @return 
	 * */
//	@ResponseBody
//	@RequestMapping("/exportFile")
//	public String exportFile(HttpServletRequest request,HttpServletResponse response) throws IOException {
//		response.reset(); 
//		// 接收请求相应
//	    //准备请求头参数
//		String authstatus =request.getParameter("authStatus");
//		String userworkGroupdisplayId =request.getParameter("userworkGroupdisplayId");
//		int authStatus =Integer.parseInt(authstatus);
//		int userworkGroupdisplayIdId =Integer.parseInt(userworkGroupdisplayId);
//		Date date =new Date();
//		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
//		String time =sdf.format(date);
//		response.setHeader("Content-Disposition", "attachment;filename=File" + time +".xlsx");
//		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
//		response.setHeader("Pragma", "no-cache");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setDateHeader("Expires", 0);
//	    XSSFWorkbook workbook = null;
//	    try {
//	    	UserWork userWork= new UserWork();
//	    	userWork.setUserworkGroupdisplayId(userworkGroupdisplayIdId);
//	    	if(authStatus==1) {	    		
//	    		List<UserWork> UserWorkList = userWorkService.getUserWorkByConditions(userWork);
//	            workbook = ExcelUtils.exportContactsGroupDisplay(UserWorkList);
//	        }
//	        OutputStream output;
//	        try {
//	        	output = response.getOutputStream();
//	            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
//	            bufferedOutPut.flush();
//	            workbook.write(bufferedOutPut);
//	            bufferedOutPut.close();
//	            } catch (Exception e) {
//	                e.printStackTrace();
//	            }
//	        } catch (Exception e1) {
//	            e1.printStackTrace();
//	        }
//	        return null;
//	}
	
	/**1.1	useOn
	 * 远程调用url,name,pimageUrl
	 * @return Map
	 */
//	private Map<String, String> HttpGetPImgUrl(String id) {
//		HttpUtil httpUtil = new HttpUtil();
//		String urls="https://itunes.apple.com/cn/lookup";
//		String idParm = "id="+id;
//		String result = null;
//		Map<String, String> iosNeedMap= new HashMap<String, String>();
//		try {
//			result = httpUtil.sendPostUrl(urls,idParm,"utf-8");
//			JSONObject JSONObject = new JSONObject(result);
//			String resStr = JSONObject.get("results").toString();
//			String resStr2 =resStr.substring(1, resStr.length()-1);
//			System.out.println(resStr2);
//			JSONObject JSONObjectStr2 = new JSONObject(resStr2);
//			iosNeedMap.put("artworkUrl100", (String) JSONObjectStr2.get("artworkUrl100"));
////			iosNeedMap.put("trackName", (String) JSONObjectStr2.get("trackName"));
//			iosNeedMap.put("bundleId", (String) JSONObjectStr2.get("bundleId"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return iosNeedMap;
//	}
	
}
