package com.atguigu.controller.high;

import java.math.BigDecimal;
import java.text.DecimalFormat;
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

import com.atguigu.bean.DownPayIFDate;
import com.atguigu.bean.MlPaypalShipAddress;
import com.atguigu.bean.MlbackAddOrderViewDetail;
import com.atguigu.bean.MlbackAddPayinfoViewDetail;
import com.atguigu.bean.MlfrontAddress;
import com.atguigu.bean.MlfrontOrder;
import com.atguigu.bean.MlfrontOrderItem;
import com.atguigu.bean.MlfrontPayInfo;
import com.atguigu.bean.MlfrontReview;
import com.atguigu.bean.MlfrontUser;
import com.atguigu.bean.Msg;
import com.atguigu.bean.PageTimeVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.DownPayIFDateService;
import com.atguigu.service.MlPaypalShipAddressService;
import com.atguigu.service.MlbackAddOrderViewDetailService;
import com.atguigu.service.MlbackAddPayinfoViewDetailService;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackAreafreightService;
import com.atguigu.service.MlfrontAddressService;
import com.atguigu.service.MlfrontOrderItemService;
import com.atguigu.service.MlfrontOrderService;
import com.atguigu.service.MlfrontPayInfoService;
import com.atguigu.service.MlfrontUserService;
import com.atguigu.utils.DateUtil;

@Controller
@RequestMapping("/HighPayInfo")
public class HighPayInfoController {
		
	@Autowired
	MlfrontPayInfoService mlfrontPayInfoService;
	
	
	@Autowired
	DownPayIFDateService downPayIFDateService;
	
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
	   * 3.0  UseNow  0505
	   * toMlfrontPayInfoList列表页面
	   * @param jsp
	   * @return 
	   * */
	  @RequestMapping("/toMlbackPayInfohighList")
	  public String toMlbackPayInfohighList() throws Exception{
	  
	    return "back/high/mlbackPayInfohighPage";
	  }
	
	
	/**11.0	useOn	0505
	 * 分类MlfrontReview列表分页list数据
	 * @param pn,
	 * Integer payinfoStatus;
	 * String payinfoCreatetime;
	 * String payinfoMotifytime;
	 * @return
	 */
//	@RequestMapping(value="/selectHighPayInfoListBySearch",method=RequestMethod.POST)
//	@ResponseBody
//	public Msg selectHighPayInfoListBySearch(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
//			@RequestParam(value = "payinfoStatus") Integer payinfoStatus,
//			@RequestParam(value = "payinfoCreatetime") String payinfoCreatetime,
//			@RequestParam(value = "payinfoMotifytime") String payinfoMotifytime,
//			HttpSession session) {
//		
//		//初始化请求参数
//		MlfrontPayInfo mlfrontPayInfoReq = new MlfrontPayInfo();
//		//初始化请求参数
//		if(payinfoStatus!=9999){
//			mlfrontPayInfoReq.setPayinfoStatus(payinfoStatus);
//		}
//		mlfrontPayInfoReq.setPayinfoCreatetime(payinfoCreatetime);
//		mlfrontPayInfoReq.setPayinfoMotifytime(payinfoMotifytime);
//		int PagNum = 20;
//		PageHelper.startPage(pn, PagNum);
//		List<MlfrontPayInfo> mlfrontPayInfoList = mlfrontPayInfoService.selectHighPayInfoListBySearch(mlfrontPayInfoReq);
//		
//		PageInfo page = new PageInfo(mlfrontPayInfoList, PagNum);
//		return Msg.success().add("pageInfo", page);
//		
//	}
	
	/**11.0	useOn	0505
	 * 分类MlfrontReview列表分页list数据
	 * @param pn,
	 * Integer payinfoStatus;
	 * String payinfoCreatetime;
	 * String payinfoMotifytime;
	 * @return
	 */
	@RequestMapping(value="/selectHighPayInfoListBySearch",method=RequestMethod.POST)
	@ResponseBody
	public Msg selectHighPayInfoListBySearch(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "payinfoStatus") Integer payinfoStatus,
			@RequestParam(value = "payinfoCreatetime") String payinfoCreatetime,
			@RequestParam(value = "payinfoMotifytime") String payinfoMotifytime,
			HttpSession session) {
		
		//初始化请求参数
		MlfrontPayInfo mlfrontPayInfoReq = new MlfrontPayInfo();
		//初始化请求参数
		if(payinfoStatus!=9999){
			mlfrontPayInfoReq.setPayinfoStatus(payinfoStatus);
		}
		mlfrontPayInfoReq.setPayinfoCreatetime(payinfoCreatetime);
		mlfrontPayInfoReq.setPayinfoMotifytime(payinfoMotifytime);
		int PagNum = 20;
		PageHelper.startPage(pn, PagNum);
		List<MlfrontPayInfo> mlfrontPayInfoList = mlfrontPayInfoService.selectHighPayInfoListBySearch(mlfrontPayInfoReq);
		
		DownPayIFDate downPayIFDateReq = new DownPayIFDate();
		
		downPayIFDateReq.setPayinfoCreatetime(payinfoCreatetime);
		downPayIFDateReq.setPayinfoMotifytime(payinfoMotifytime);
		
		List<DownPayIFDate> highPayIFList= downPayIFDateService.selectHighPayIFList(downPayIFDateReq);
		
		PageInfo page = new PageInfo(mlfrontPayInfoList, PagNum);
		return Msg.success().add("pageInfo", page).add("highPayIFList", highPayIFList);
		
	}
	
}
