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
import com.atguigu.service.MlbackAddOrderViewDetailService;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackCategoryService;
import com.atguigu.service.MlbackProductService;
import com.atguigu.service.MlbackProductViewDetailService;
import com.atguigu.utils.DateUtil;


@Controller
@RequestMapping("/MlbackAddOrderViewDetail")
public class MlbackAddOrderViewDetailController {
	
	@Autowired
	MlbackAddOrderViewDetailService mlbackAddOrderViewDetailService;
		
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
	
	
	/**3.0	UseNow	0505
	 * 分类MlbackActShowPro列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getAddOrderViewDetailNum",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAddOrderViewDetailNum(HttpSession session,@RequestBody MlbackAddOrderViewDetail mlbackAddOrderViewDetail) {
		
		String starttime = mlbackAddOrderViewDetail.getAddorderviewdetailStarttime();
		String endtime = mlbackAddOrderViewDetail.getAddorderviewdetailEndtime();
		MlbackAddOrderViewDetail mlbackAddOrderViewDetailreq = new MlbackAddOrderViewDetail();
		mlbackAddOrderViewDetailreq.setAddorderviewdetailStarttime(starttime);
		mlbackAddOrderViewDetailreq.setAddorderviewdetailEndtime(endtime);
		mlbackAddOrderViewDetailreq.setAddorderviewdetailActnum(0);
		List<MlbackAddOrderViewDetail> mlbackAddOrderViewDetailList = mlbackAddOrderViewDetailService.selectMlbackAddOrderViewDetailByTime(mlbackAddOrderViewDetailreq);
		Integer toDayNum = mlbackAddOrderViewDetailList.size();
		return Msg.success().add("mlbackAddOrderViewDetailList", mlbackAddOrderViewDetailList).add("toDayNum", toDayNum);
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
		MlbackAddOrderViewDetail mlbackAddOrderViewDetailreq = new MlbackAddOrderViewDetail();
		mlbackAddOrderViewDetailreq.setAddorderviewdetailStarttime(starttime);
		mlbackAddOrderViewDetailreq.setAddorderviewdetailEndtime(endtime);
		mlbackAddOrderViewDetailreq.setAddorderviewdetailActnum(0);	//用户行为，0纯加购	1点buyNow附带的加购
		int PagNum = 20;
		List<MlbackAddOrderViewDetail> mlbackAddOrderViewDetailList = mlbackAddOrderViewDetailService.selectMlbackAddOrderViewDetailByTime(mlbackAddOrderViewDetailreq);
		
		String  proSeo = "";
		Integer proSeoNum = 0;
		Integer k=0;
		List<Integer> numList = new ArrayList<Integer>();
		List<String> SeoStringList = new ArrayList<String>();
		
		for(int i=0;i<mlbackAddOrderViewDetailList.size();i++){
			k++;
			MlbackAddOrderViewDetail mlbackAddOrderViewDetailOne = mlbackAddOrderViewDetailList.get(i);
			if(proSeo.isEmpty()){
				System.out.println("第一次来，都不记录");
				proSeo = mlbackAddOrderViewDetailOne.getAddorderviewdetailSeoname();
				SeoStringList.add(proSeo);
			}else{
				proSeo = mlbackAddOrderViewDetailOne.getAddorderviewdetailStarttime();
				MlbackAddOrderViewDetail mlbackAddOrderViewDetailOneLast =mlbackAddOrderViewDetailList.get(i-1);
				String lastSeo = mlbackAddOrderViewDetailOneLast.getAddorderviewdetailSeoname();
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
	
	/**3.0	UseNow	0505
	 * 分类MlbackActShowPro列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getAddOrderViewDetailBuyNowNum",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAddOrderViewDetailBuyNowNum(HttpSession session,@RequestBody MlbackAddOrderViewDetail mlbackAddOrderViewDetail) {
		
		String starttime = mlbackAddOrderViewDetail.getAddorderviewdetailStarttime();
		String endtime = mlbackAddOrderViewDetail.getAddorderviewdetailEndtime();
		MlbackAddOrderViewDetail mlbackAddOrderViewDetailreq = new MlbackAddOrderViewDetail();
		mlbackAddOrderViewDetailreq.setAddorderviewdetailStarttime(starttime);
		mlbackAddOrderViewDetailreq.setAddorderviewdetailEndtime(endtime);
		mlbackAddOrderViewDetailreq.setAddorderviewdetailActnum(1);
		List<MlbackAddOrderViewDetail> mlbackAddOrderViewDetailList = mlbackAddOrderViewDetailService.selectMlbackAddOrderViewDetailByTime(mlbackAddOrderViewDetailreq);
		Integer toDayNum = mlbackAddOrderViewDetailList.size();
		return Msg.success().add("mlbackAddOrderViewDetailList", mlbackAddOrderViewDetailList).add("toDayNum", toDayNum);
	}
	
	
	/**4.0	UseNow	0505
	 * 分类MlbackProductViewDetail列表list数据
	 * @param
	 * @return
	 */
	@RequestMapping(value="/getAddOrderViewDetailBuyNowList",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAddOrderViewDetailBuyNowList(HttpSession session,@RequestBody MlbackAddOrderViewDetail mlbackAddOrderViewDetail) {
		
		String starttime = mlbackAddOrderViewDetail.getAddorderviewdetailStarttime();
		String endtime = mlbackAddOrderViewDetail.getAddorderviewdetailEndtime();
		MlbackAddOrderViewDetail mlbackAddOrderViewDetailreq = new MlbackAddOrderViewDetail();
		mlbackAddOrderViewDetailreq.setAddorderviewdetailStarttime(starttime);
		mlbackAddOrderViewDetailreq.setAddorderviewdetailEndtime(endtime);
		mlbackAddOrderViewDetailreq.setAddorderviewdetailActnum(1);	//用户行为，0纯加购	1点buyNow附带的加购
		int PagNum = 20;
		List<MlbackAddOrderViewDetail> mlbackAddOrderViewDetailList = mlbackAddOrderViewDetailService.selectMlbackAddOrderViewDetailByTime(mlbackAddOrderViewDetailreq);
		
		String  proSeo = "";
		Integer proSeoNum = 0;
		Integer k=0;
		List<Integer> numList = new ArrayList<Integer>();
		List<String> SeoStringList = new ArrayList<String>();
		
		for(int i=0;i<mlbackAddOrderViewDetailList.size();i++){
			k++;
			MlbackAddOrderViewDetail mlbackAddOrderViewDetailOne = mlbackAddOrderViewDetailList.get(i);
			if(proSeo.isEmpty()){
				System.out.println("第一次来，都不记录");
				proSeo = mlbackAddOrderViewDetailOne.getAddorderviewdetailSeoname();
				SeoStringList.add(proSeo);
			}else{
				proSeo = mlbackAddOrderViewDetailOne.getAddorderviewdetailSeoname();
				MlbackAddOrderViewDetail mlbackAddOrderViewDetailOneLast =mlbackAddOrderViewDetailList.get(i-1);
				String lastSeo = mlbackAddOrderViewDetailOneLast.getAddorderviewdetailSeoname();
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
