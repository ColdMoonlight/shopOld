package com.atguigu.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.Vo.SortNumTh;
import com.atguigu.bean.MlbackAddOrderViewDetail;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlfrontOrderItem;
import com.atguigu.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.MlbackAddOrderViewDetailService;
import com.atguigu.service.MlfrontOrderItemService;


@Controller
@RequestMapping("/MlbackAddOrderViewDetail")
public class MlbackAddOrderViewDetailController {
	
	@Autowired
	MlbackAddOrderViewDetailService mlbackAddOrderViewDetailService;
	
	@Autowired
	MlfrontOrderItemService mlfrontOrderItemService;
		
	/**
	 * 1.0	UseNow	0505
	 * toMlbackActShowPro列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackAddOrderViewDetailPage")
	public String tologin(HttpSession session) throws Exception{
	
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("AdminUser");
		if(mlbackAdmin==null){
			//SysUsers对象为空
			return "back/mlbackAdminLogin";
		}else{
			return "back/mlbackAddOrderViewDetailPage";
		}
	}
	
	/**2.0	UseNow	0505
	 * 分类MlbackActShowPro列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getMlbackAddOrderViewDetailPage")
	@ResponseBody
	public Msg getMlbackAddOrderViewDetailPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session,String starttime,String endtime) {
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
			MlbackAddOrderViewDetail mlbackAddOrderViewDetailreq = new MlbackAddOrderViewDetail();
			mlbackAddOrderViewDetailreq.setAddorderviewdetailStarttime(starttime);
			mlbackAddOrderViewDetailreq.setAddorderviewdetailEndtime(endtime);
			int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlbackAddOrderViewDetail> mlbackAddCartList = mlbackAddOrderViewDetailService.selectMlbackAddOrderViewDetailByTime(mlbackAddOrderViewDetailreq);
			PageInfo page = new PageInfo(mlbackAddCartList, PagNum);
			return Msg.success().add("pageInfo", page);
//		}
	}
	
	/**3.0	UseOn	200327 
	 * 分类getAddOrderViewDetailNum列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getAddOrderViewDetailNum",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAddOrderViewDetailNum(HttpSession session,@RequestBody MlbackAddOrderViewDetail mlbackAddOrderViewDetail) {
		
		String starttime = mlbackAddOrderViewDetail.getAddorderviewdetailStarttime();
		String endtime = mlbackAddOrderViewDetail.getAddorderviewdetailEndtime();
		
		MlfrontOrderItem mlfrontOrderItemreq = new MlfrontOrderItem();
		mlfrontOrderItemreq.setOrderitemCreatetime(starttime);
		mlfrontOrderItemreq.setOrderitemMotifytime(endtime);
		List<MlfrontOrderItem> mlfrontOrderItemList = mlfrontOrderItemService.selectMlfrontOrderItemByMotifyTime(mlfrontOrderItemreq);
		Integer toDayNum=0;
		if(mlfrontOrderItemList.size()>0){
			toDayNum = mlfrontOrderItemList.size();
		}
		return Msg.success().add("toDayNum", toDayNum);
	}
	
	/**4.0	UseNow	0505
	 * 分类MlbackProductViewDetail列表list数据
	 * @param
	 * @return
	 */
	@RequestMapping(value="/getAddOrderViewDetailList",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAddOrderViewDetailList(HttpSession session,@RequestBody MlbackAddOrderViewDetail mlbackAddOrderViewDetail) {
		
		String starttime = mlbackAddOrderViewDetail.getAddorderviewdetailStarttime();
		String endtime = mlbackAddOrderViewDetail.getAddorderviewdetailEndtime();
		
		MlfrontOrderItem mlfrontOrderItemreq = new MlfrontOrderItem();
		mlfrontOrderItemreq.setOrderitemCreatetime(starttime);
		mlfrontOrderItemreq.setOrderitemMotifytime(endtime);
		List<MlfrontOrderItem> mlfrontOrderItemList = mlfrontOrderItemService.selectMlfrontOrderItemByMotifyTime(mlfrontOrderItemreq);
		
		String  proSeo = "";
		Integer proSeoNum = 0;
		Integer k=0;
		List<Integer> numList = new ArrayList<Integer>();
		List<String> SeoStringList = new ArrayList<String>();
		
		for(int i=0;i<mlfrontOrderItemList.size();i++){
			k++;
			MlfrontOrderItem mlfrontOrderItemOne = mlfrontOrderItemList.get(i);
			if(proSeo.isEmpty()){
				//System.out.println("第一次来，都不记录");
				proSeo = mlfrontOrderItemOne.getOrderitemPname();
				SeoStringList.add(proSeo);
			}else{
				proSeo = mlfrontOrderItemOne.getOrderitemPname();
				MlfrontOrderItem mlfrontOrderItemOneLast =mlfrontOrderItemList.get(i-1);
				String lastSeo = mlfrontOrderItemOneLast.getOrderitemPname();
				Integer nowPronum = mlfrontOrderItemOneLast.getOrderitemPskuNumber();
				if(proSeo.equals(lastSeo)){
					proSeoNum=proSeoNum+nowPronum;
				}else{
					SeoStringList.add(proSeo);
					proSeoNum = k-1;
					numList.add(proSeoNum);
					k=1;
				}
			}
		}
		numList.add(k);
		List<SortNumTh> SortNumThList = new ArrayList<SortNumTh>();
		Integer lenth = SeoStringList.size();
		SortNumTh[] arrayA = new SortNumTh[lenth];
		for(int x=0;x<lenth;x++){
			SortNumTh sortNumThOne = new SortNumTh();
			String SeoString = SeoStringList.get(x);
			Integer numCount = numList.get(x);
			sortNumThOne.setSeoString(SeoString);
			sortNumThOne.setSeoStringCount(numCount);
			SortNumThList.add(sortNumThOne);
			arrayA[x] = sortNumThOne;
		}
		//排序
		for (int m = 0; m < arrayA.length - 1; m++) {				//外循环只需要比较arr.length-1次就可以了
			for (int n = 0; n < arrayA.length - 1 - m; n++) {		//-1为了防止索引越界,-i为了提高效率
				if(arrayA[n].getSeoStringCount() < arrayA[n+1].getSeoStringCount()) {
					SortNumTh temp = arrayA[n];
					arrayA[n] = arrayA[n + 1];
					arrayA[n+1] = temp;
				}
			}
		}
		return Msg.success().add("SeoStringList", SeoStringList).add("numList", numList).add("arrayA", arrayA);
	}

}
