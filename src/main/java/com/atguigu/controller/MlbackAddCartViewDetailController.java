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

import com.atguigu.bean.MlbackActShowPro;
import com.atguigu.bean.MlbackAddCartViewDetail;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackCoupon;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlbackProductViewDetail;
import com.atguigu.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.MlbackActShowProService;
import com.atguigu.service.MlbackAddCartViewDetailService;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackCategoryService;
import com.atguigu.service.MlbackProductService;
import com.atguigu.service.MlbackProductViewDetailService;
import com.atguigu.utils.DateUtil;


@Controller
@RequestMapping("/MlbackAddCartViewDetail")
public class MlbackAddCartViewDetailController {
	
	@Autowired
	MlbackAddCartViewDetailService mlbackAddCartViewDetailService;
		
	/**
	 * 1.0	UseNow	0505
	 * toMlbackActShowPro列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackAddCartViewDetailPage")
	public String tologin(HttpSession session) throws Exception{
	
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("AdminUser");
		if(mlbackAdmin==null){
			//SysUsers对象为空
			return "back/mlbackAdminLogin";
		}else{
			return "back/mlbackAddCartViewDetailPage";
		}
	}
	
	/**2.0	UseNow	0505
	 * 分类MlbackActShowPro列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getMlbackAddCartViewDetailPage")
	@ResponseBody
	public Msg getMlbackAddCartViewDetailPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session,String starttime,String endtime) {
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
			MlbackAddCartViewDetail mlbackAddCartViewDetailreq = new MlbackAddCartViewDetail();
			mlbackAddCartViewDetailreq.setAddcartviewdetailStarttime(starttime);
			mlbackAddCartViewDetailreq.setAddcartviewdetailEndtime(endtime);
			int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlbackAddCartViewDetail> mlbackAddCartList = mlbackAddCartViewDetailService.selectMlbackAddCartViewDetailByTime(mlbackAddCartViewDetailreq);
			PageInfo page = new PageInfo(mlbackAddCartList, PagNum);
			return Msg.success().add("pageInfo", page);
//		}
	}
	
	
	/**3.0	UseNow	0505
	 * 分类MlbackActShowPro列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getAddCartViewDetailNum",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAddCartViewDetailNum(HttpSession session,@RequestBody MlbackAddCartViewDetail mlbackAddCartViewDetail) {
		
		String starttime = mlbackAddCartViewDetail.getAddcartviewdetailStarttime();
		String endtime = mlbackAddCartViewDetail.getAddcartviewdetailEndtime();
		MlbackAddCartViewDetail mlbackAddCartViewDetailreq = new MlbackAddCartViewDetail();
		mlbackAddCartViewDetailreq.setAddcartviewdetailStarttime(starttime);
		mlbackAddCartViewDetailreq.setAddcartviewdetailEndtime(endtime);
		List<MlbackAddCartViewDetail> mlbackAddCartViewDetailList = mlbackAddCartViewDetailService.selectMlbackAddCartViewDetailByTime(mlbackAddCartViewDetailreq);
		Integer toDayNum = mlbackAddCartViewDetailList.size();
		return Msg.success().add("mlbackAddCartViewDetailList", mlbackAddCartViewDetailList).add("toDayNum", toDayNum);
	}
	
	
	/**4.0	UseNow	0505
	 * 分类MlbackProductViewDetail列表list数据
	 * @param
	 * @return
	 */
	@RequestMapping(value="/getAddCartViewDetailList",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAddCartViewDetailList(HttpSession session,@RequestBody MlbackAddCartViewDetail mlbackAddCartViewDetail) {
		
		String starttime = mlbackAddCartViewDetail.getAddcartviewdetailStarttime();
		String endtime = mlbackAddCartViewDetail.getAddcartviewdetailEndtime();
		MlbackAddCartViewDetail mlbackAddCartViewDetailreq = new MlbackAddCartViewDetail();
		mlbackAddCartViewDetailreq.setAddcartviewdetailStarttime(starttime);
		mlbackAddCartViewDetailreq.setAddcartviewdetailEndtime(endtime);
		int PagNum = 20;
		List<MlbackAddCartViewDetail> mlbackAddCartViewDetailList = mlbackAddCartViewDetailService.selectMlbackAddCartViewDetailByTime(mlbackAddCartViewDetailreq);
		
		String  proSeo = "";
		Integer proSeoNum = 0;
		Integer k=0;
		List<Integer> numList = new ArrayList<Integer>();
		List<String> SeoStringList = new ArrayList<String>();
		
		for(int i=0;i<mlbackAddCartViewDetailList.size();i++){
			k++;
			MlbackAddCartViewDetail mlbackAddCartViewDetailOne = mlbackAddCartViewDetailList.get(i);
			if(proSeo.isEmpty()){
				System.out.println("第一次来，都不记录");
				proSeo = mlbackAddCartViewDetailOne.getAddcartviewdetailSeoname();
				SeoStringList.add(proSeo);
			}else{
				proSeo = mlbackAddCartViewDetailOne.getAddcartviewdetailEndtime();
				if(proSeo.equals(mlbackAddCartViewDetailList.get(i-1).getAddcartviewdetailSeoname())){
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
