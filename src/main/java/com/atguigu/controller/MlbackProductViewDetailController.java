package com.atguigu.controller;

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

import com.atguigu.bean.MlbackActShowPro;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlbackProductViewDetail;
import com.atguigu.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.MlbackActShowProService;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackCategoryService;
import com.atguigu.service.MlbackProductService;
import com.atguigu.service.MlbackProductViewDetailService;
import com.atguigu.utils.DateUtil;


@Controller
@RequestMapping("/MlbackProductViewDetail")
public class MlbackProductViewDetailController {
	
	@Autowired
	MlbackProductViewDetailService mlbackProductViewDetailService;
		
	/**
	 * 1.0	UseNow	0505
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
	
	/**2.0	UseNow	0505
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
	
	
	/**2.0	UseNow	0505
	 * 分类MlbackActShowPro列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getProductViewDetailNum",method=RequestMethod.GET)
	@ResponseBody
	public Msg getProductViewDetailNum(HttpSession session,String starttime,String endtime) {
		
		MlbackProductViewDetail mlbackProductViewDetailreq = new MlbackProductViewDetail();
		mlbackProductViewDetailreq.setProviewdetailStarttime(starttime);
		mlbackProductViewDetailreq.setProviewdetailEndtime(endtime);
		List<MlbackProductViewDetail> mlbackActShowProList = mlbackProductViewDetailService.selectMlbackProductViewDetailByTime(mlbackProductViewDetailreq);
		return Msg.success().add("mlbackActShowProList", mlbackActShowProList);
	}
	
	
	
/*	@RequestMapping(value="/getProductViewDetailNum",method=RequestMethod.GET)
	@ResponseBody
	public Msg getProductViewDetailNum(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session,String starttime,String endtime) {
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
	}*/

}
