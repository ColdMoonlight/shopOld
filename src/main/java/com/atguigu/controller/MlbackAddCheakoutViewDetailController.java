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
import com.atguigu.bean.MlbackAddCheakoutViewDetail;
import com.atguigu.bean.MlbackAddOrderViewDetail;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackCoupon;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlbackProductViewDetail;
import com.atguigu.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.MlbackActShowProService;
import com.atguigu.service.MlbackAddCartViewDetailService;
import com.atguigu.service.MlbackAddCheakoutViewDetailService;
import com.atguigu.service.MlbackAddOrderViewDetailService;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackCategoryService;
import com.atguigu.service.MlbackProductService;
import com.atguigu.service.MlbackProductViewDetailService;
import com.atguigu.utils.DateUtil;


@Controller
@RequestMapping("/MlbackAddCheakoutViewDetail")
public class MlbackAddCheakoutViewDetailController {
	
	@Autowired
	MlbackAddCheakoutViewDetailService mlbackAddCheakoutViewDetailService;
		
	/**
	 * 1.0	UseNow	0505
	 * toMlbackActShowPro列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackAddCheakoutViewDetailPage")
	public String tologin(HttpSession session) throws Exception{
	
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("AdminUser");
		if(mlbackAdmin==null){
			//SysUsers对象为空
			return "back/mlbackAdminLogin";
		}else{
			return "back/mlbackAddCheakoutViewDetailPage";
		}
	}
	
	/**
	 * 1.1	UseNow	0505
	 * MlbackAddCheakoutViewDetail列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackAddCheakoutBuyNowViewDetailPage")
	public String toMlbackAddCheakoutBuyNowViewDetailPage(HttpSession session) throws Exception{
	
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("AdminUser");
		if(mlbackAdmin==null){
			//SysUsers对象为空
			return "back/mlbackAdminLogin";
		}else{
			return "back/mlbackAddCheakoutViewbuynowDetailPage";
		}
	}
	
	
	/**2.0	UseNow	0505
	 * 分类MlbackActShowPro列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getMlbackAddCheakoutViewDetailPage")
	@ResponseBody
	public Msg getMlbackAddCheakoutViewDetailPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session,String starttime,String endtime) {
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
			MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetailreq = new MlbackAddCheakoutViewDetail();
			mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailStarttime(starttime);
			mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailEndtime(endtime);
			int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlbackAddCheakoutViewDetail> mlbackAddCartList = mlbackAddCheakoutViewDetailService.selectMlbackAddCheakoutViewDetailByTime(mlbackAddCheakoutViewDetailreq);
			PageInfo page = new PageInfo(mlbackAddCartList, PagNum);
			return Msg.success().add("pageInfo", page);
//		}
	}
	
	
	/**3.0	UseNow	0505
	 * 分类MlbackActShowPro列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getAddCheakoutViewDetailNum",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAddCheakoutViewDetailNum(HttpSession session,@RequestBody MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetail) {
		
		String starttime = mlbackAddCheakoutViewDetail.getAddcheakoutviewdetailStarttime();
		String endtime = mlbackAddCheakoutViewDetail.getAddcheakoutviewdetailEndtime();
		MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetailreq = new MlbackAddCheakoutViewDetail();
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailStarttime(starttime);
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailEndtime(endtime);
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailActnum(0);
		List<MlbackAddCheakoutViewDetail> mlbackAddCheakoutViewDetailList = mlbackAddCheakoutViewDetailService.selectMlbackAddCheakoutViewDetailByTime(mlbackAddCheakoutViewDetailreq);
		Integer toDayNum = mlbackAddCheakoutViewDetailList.size();
		return Msg.success().add("mlbackAddCheakoutViewDetailList", mlbackAddCheakoutViewDetailList).add("toDayNum", toDayNum);
	}
	
	
	/**4.0	UseNow	0505
	 * 分类MlbackProductViewDetail列表list数据
	 * @param
	 * @return
	 */
	@RequestMapping(value="/getAddCheakoutViewDetailList",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAddCheakoutViewDetailList(HttpSession session,@RequestBody MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetail) {
		
		String starttime = mlbackAddCheakoutViewDetail.getAddcheakoutviewdetailStarttime();
		String endtime = mlbackAddCheakoutViewDetail.getAddcheakoutviewdetailEndtime();
		MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetailreq = new MlbackAddCheakoutViewDetail();
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailStarttime(starttime);
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailEndtime(endtime);
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailActnum(0);	//用户行为，0纯加购	1点buyNow附带的加购
		int PagNum = 20;
		List<MlbackAddCheakoutViewDetail> mlbackAddCheakoutViewDetailList = mlbackAddCheakoutViewDetailService.selectMlbackAddCheakoutViewDetailByTime(mlbackAddCheakoutViewDetailreq);
		
		String  proSeo = "";
		Integer proSeoNum = 0;
		Integer k=0;
		List<Integer> numList = new ArrayList<Integer>();
		List<String> SeoStringList = new ArrayList<String>();
		
		for(int i=0;i<mlbackAddCheakoutViewDetailList.size();i++){
			k++;
			MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetailOne = mlbackAddCheakoutViewDetailList.get(i);
			if(proSeo.isEmpty()){
				System.out.println("第一次来，都不记录");
				proSeo = mlbackAddCheakoutViewDetailOne.getAddcheakoutviewdetailSeoname();
				SeoStringList.add(proSeo);
			}else{
				proSeo = mlbackAddCheakoutViewDetailOne.getAddcheakoutviewdetailStarttime();
				MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetailOneLast =mlbackAddCheakoutViewDetailList.get(i-1);
				String lastSeo = mlbackAddCheakoutViewDetailOneLast.getAddcheakoutviewdetailSeoname();
				if(proSeo.equals(lastSeo)){
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
	
	/**5.0	UseNow	0505
	 * 分类MlbackActShowPro列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getAddCheakoutViewDetailBuyNowNum",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAddCheakoutViewDetailBuyNowNum(HttpSession session,@RequestBody MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetail) {
		
		String starttime = mlbackAddCheakoutViewDetail.getAddcheakoutviewdetailStarttime();
		String endtime = mlbackAddCheakoutViewDetail.getAddcheakoutviewdetailEndtime();
		MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetailreq = new MlbackAddCheakoutViewDetail();
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailStarttime(starttime);
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailEndtime(endtime);
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailActnum(1);
		List<MlbackAddCheakoutViewDetail> mlbackAddCheakoutViewDetailList = mlbackAddCheakoutViewDetailService.selectMlbackAddCheakoutViewDetailByTime(mlbackAddCheakoutViewDetailreq);
		Integer toDayNum = mlbackAddCheakoutViewDetailList.size();
		return Msg.success().add("mlbackAddCheakoutViewDetailList", mlbackAddCheakoutViewDetailList).add("toDayNum", toDayNum);
	}
	
	
	/**6.0	UseNow	0505
	 * 分类MlbackProductViewDetail列表list数据
	 * @param
	 * @return
	 */
	@RequestMapping(value="/getAddOrderViewDetailBuyNowList",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAddOrderViewDetailBuyNowList(HttpSession session,@RequestBody MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetail) {
		
		String starttime = mlbackAddCheakoutViewDetail.getAddcheakoutviewdetailStarttime();
		String endtime = mlbackAddCheakoutViewDetail.getAddcheakoutviewdetailEndtime();
		MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetailreq = new MlbackAddCheakoutViewDetail();
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailStarttime(starttime);
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailEndtime(endtime);
		mlbackAddCheakoutViewDetailreq.setAddcheakoutviewdetailActnum(1);	//用户行为，0纯加购	1点buyNow附带的加购
		int PagNum = 20;
		List<MlbackAddCheakoutViewDetail> mlbackAddCheakoutViewDetailList = mlbackAddCheakoutViewDetailService.selectMlbackAddCheakoutViewDetailByTime(mlbackAddCheakoutViewDetailreq);
		
		String  proSeo = "";
		Integer proSeoNum = 0;
		Integer k=0;
		List<Integer> numList = new ArrayList<Integer>();
		List<String> SeoStringList = new ArrayList<String>();
		
		for(int i=0;i<mlbackAddCheakoutViewDetailList.size();i++){
			k++;
			MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetailOne = mlbackAddCheakoutViewDetailList.get(i);
			if(proSeo.isEmpty()){
				System.out.println("第一次来，都不记录");
				proSeo = mlbackAddCheakoutViewDetailOne.getAddcheakoutviewdetailSeoname();
				SeoStringList.add(proSeo);
			}else{
				proSeo = mlbackAddCheakoutViewDetailOne.getAddcheakoutviewdetailSeoname();
				MlbackAddCheakoutViewDetail mlbackAddCheakoutViewDetailOneLast =mlbackAddCheakoutViewDetailList.get(i-1);
				String lastSeo = mlbackAddCheakoutViewDetailOneLast.getAddcheakoutviewdetailSeoname();
				if(proSeo.equals(lastSeo)){
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
