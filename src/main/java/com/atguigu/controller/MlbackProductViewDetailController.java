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

import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackProductViewDetail;
import com.atguigu.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.MlbackProductViewDetailService;

@Controller
@RequestMapping("/MlbackProductViewDetail")
public class MlbackProductViewDetailController {
	
	@Autowired
	MlbackProductViewDetailService mlbackProductViewDetailService;
		
	/**
	 * 1.0	onuse	200104
	 * toMlbackActShowPro列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackProductViewDetailPage")
	public String tologin(HttpSession session) throws Exception{
	
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("AdminUser");
		if(mlbackAdmin==null){
			//SysUsers对象为空
			return "back/mlbackAdminLogin";
		}else{
			return "back/mlbackProductViewDetailPage";
		}
	}
	
	/**2.0	onuse	200104
	 * 分类MlbackActShowPro列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getProductViewDetailPage")
	@ResponseBody
	public Msg getMlbackProductViewDetailByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session,String starttime,String endtime) {
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
			MlbackProductViewDetail mlbackProductViewDetailreq = new MlbackProductViewDetail();
			mlbackProductViewDetailreq.setProviewdetailStarttime(starttime);
			mlbackProductViewDetailreq.setProviewdetailEndtime(endtime);
			int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlbackProductViewDetail> mlbackActShowProList = mlbackProductViewDetailService.selectMlbackProductViewDetailByTime(mlbackProductViewDetailreq);
			PageInfo page = new PageInfo(mlbackActShowProList, PagNum);
			return Msg.success().add("pageInfo", page);
//		}
	}
	
	
	/**3.0	onuse	200104
	 * 分类MlbackActShowPro列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getProductViewDetailNum",method=RequestMethod.POST)
	@ResponseBody
	public Msg getProductViewDetailNum(HttpSession session,@RequestBody MlbackProductViewDetail mlbackProductViewDetail) {
		
		String starttime = mlbackProductViewDetail.getProviewdetailStarttime();
		String endtime = mlbackProductViewDetail.getProviewdetailEndtime();
		MlbackProductViewDetail mlbackProductViewDetailreq = new MlbackProductViewDetail();
		mlbackProductViewDetailreq.setProviewdetailStarttime(starttime);
		mlbackProductViewDetailreq.setProviewdetailEndtime(endtime);
		List<MlbackProductViewDetail> mlbackActShowProList = mlbackProductViewDetailService.selectMlbackProductViewDetailByTime(mlbackProductViewDetailreq);
		Integer toDayNum = mlbackActShowProList.size();
		return Msg.success().add("mlbackActShowProList", mlbackActShowProList).add("toDayNum", toDayNum);
	}
	
	
	/**4.0	onuse	200104
	 * 分类MlbackProductViewDetail列表list数据
	 * @param
	 * @return
	 */
	@RequestMapping(value="/getProductViewDetailList",method=RequestMethod.POST)
	@ResponseBody
	public Msg getProductViewDetailList(HttpSession session,@RequestBody MlbackProductViewDetail mlbackProductViewDetail) {
		
		String starttime = mlbackProductViewDetail.getProviewdetailStarttime();
		String endtime = mlbackProductViewDetail.getProviewdetailEndtime();
		MlbackProductViewDetail mlbackProductViewDetailreq = new MlbackProductViewDetail();
		mlbackProductViewDetailreq.setProviewdetailStarttime(starttime);
		mlbackProductViewDetailreq.setProviewdetailEndtime(endtime);
		int PagNum = 20;
		List<MlbackProductViewDetail> mlbackActShowProList = mlbackProductViewDetailService.selectMlbackProductViewDetailByTime(mlbackProductViewDetailreq);
		
		String  proSeo = "";
		Integer proSeoNum = 0;
		Integer k=0;
		List<Integer> numList = new ArrayList<Integer>();
		List<String> SeoStringList = new ArrayList<String>();
		
		for(int i=0;i<mlbackActShowProList.size();i++){
			k++;
			MlbackProductViewDetail mlbackProductViewDetailOne = mlbackActShowProList.get(i);
			if(proSeo.isEmpty()){
				System.out.println("第一次来，都不记录");
				proSeo = mlbackProductViewDetailOne.getProviewdetailSeoname();
				SeoStringList.add(proSeo);
			}else{
				proSeo = mlbackProductViewDetailOne.getProviewdetailSeoname();
				if(proSeo.equals(mlbackActShowProList.get(i-1).getProviewdetailSeoname())){
					proSeoNum++;
				}else{
					SeoStringList.add(proSeo);
					proSeoNum = k-1;
					numList.add(proSeoNum);
					k=1;
				}
			}
		}
		numList.add(k);
		return Msg.success().add("SeoStringList", SeoStringList).add("numList", numList);
	}

}
