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
import com.atguigu.bean.MlbackAddPayinfoViewDetail;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackCoupon;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlbackProductViewDetail;
import com.atguigu.bean.MlfrontOrderItem;
import com.atguigu.bean.MlfrontPayInfo;
import com.atguigu.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.MlbackActShowProService;
import com.atguigu.service.MlbackAddCartViewDetailService;
import com.atguigu.service.MlbackAddOrderViewDetailService;
import com.atguigu.service.MlbackAddPayinfoViewDetailService;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackCategoryService;
import com.atguigu.service.MlbackProductService;
import com.atguigu.service.MlbackProductViewDetailService;
import com.atguigu.service.MlfrontPayInfoService;
import com.atguigu.utils.DateUtil;


@Controller
@RequestMapping("/MlbackAddPayinfoViewDetail")
public class MlbackAddPayinfoViewDetailController {
	
	@Autowired
	MlbackAddPayinfoViewDetailService mlbackAddPayinfoViewDetailService;
	
	@Autowired
	MlfrontPayInfoService mlfrontPayInfoService;
		
	/**
	 * 1.0	UseNow	0505
	 * toMlbackAddPayinfoViewDetailPage列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackAddPayinfoViewDetailPage")
	public String tologin(HttpSession session) throws Exception{
	
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("AdminUser");
		if(mlbackAdmin==null){
			//SysUsers对象为空
			return "back/mlbackAdminLogin";
		}else{
			return "back/mlbackAddPayInfoViewDetail";
		}
	}
	
	/**2.0	UseNow	0505
	 * 分类MlbackActShowPro列表分页list数据
	 * @param pn
	 * @return
	 */
//	@RequestMapping(value="/getMlbackAddOrderViewDetailPage")
//	@ResponseBody
//	public Msg getMlbackAddOrderViewDetailPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session,String starttime,String endtime) {
//		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
////		if(mlbackAdmin==null){
////			//SysUsers对象为空
////			return Msg.fail().add("resMsg", "session中adminuser对象为空");
////		}else{
//			MlbackAddOrderViewDetail mlbackAddOrderViewDetailreq = new MlbackAddOrderViewDetail();
//			mlbackAddOrderViewDetailreq.setAddorderviewdetailStarttime(starttime);
//			mlbackAddOrderViewDetailreq.setAddorderviewdetailEndtime(endtime);
//			int PagNum = 20;
//			PageHelper.startPage(pn, PagNum);
//			List<MlbackAddOrderViewDetail> mlbackAddCartList = mlbackAddOrderViewDetailService.selectMlbackAddOrderViewDetailByTime(mlbackAddOrderViewDetailreq);
//			PageInfo page = new PageInfo(mlbackAddCartList, PagNum);
//			return Msg.success().add("pageInfo", page);
////		}
//	}
	
	
//	/**3.0	UseNow	0505
//	 * 分类MlbackActShowPro列表分页list数据
//	 * @param pn
//	 * @return
//	 */
//	@RequestMapping(value="/getAddPayinfoViewDetailSuccessNum",method=RequestMethod.POST)
//	@ResponseBody
//	public Msg getAddPayinfoViewDetailSuccessNum(HttpSession session,@RequestBody MlbackAddPayinfoViewDetail mlbackAddPayinfoViewDetail) {
//		
//		String starttime = mlbackAddPayinfoViewDetail.getAddpayinfoviewdetailStarttime();
//		String endtime = mlbackAddPayinfoViewDetail.getAddpayinfoviewdetailEndtime();
//		MlbackAddPayinfoViewDetail mlbackAddPayinfoViewDetailreq = new MlbackAddPayinfoViewDetail();
//		mlbackAddPayinfoViewDetailreq.setAddpayinfoviewdetailStarttime(starttime);
//		mlbackAddPayinfoViewDetailreq.setAddpayinfoviewdetailEndtime(endtime);
//		List<MlbackAddPayinfoViewDetail> mlbackAddPayinfoViewDetailList = mlbackAddPayinfoViewDetailService.selectMlbackAddPayinfoViewDetailByTime(mlbackAddPayinfoViewDetailreq);
//		Integer toDayNum=mlbackAddPayinfoViewDetailList.size();
//		return Msg.success().add("mlbackAddPayinfoViewDetailList", mlbackAddPayinfoViewDetailList).add("toDayNum", toDayNum);
//	}
//	
	
//	/**4.0	UseNow	0505
//	 * 分类MlbackProductViewDetail列表list数据
//	 * @param
//	 * @return
//	 */
//	@RequestMapping(value="/getAddPayinfoViewDetailList",method=RequestMethod.POST)
//	@ResponseBody
//	public Msg getAddPayinfoViewDetailList(HttpSession session,@RequestBody MlbackAddPayinfoViewDetail mlbackAddPayinfoViewDetail) {
//		
//		String starttime = mlbackAddPayinfoViewDetail.getAddpayinfoviewdetailStarttime();
//		String endtime = mlbackAddPayinfoViewDetail.getAddpayinfoviewdetailEndtime();
//		MlbackAddOrderViewDetail mlbackAddOrderViewDetailreq = new MlbackAddOrderViewDetail();
//		mlbackAddOrderViewDetailreq.setAddorderviewdetailStarttime(starttime);
//		mlbackAddOrderViewDetailreq.setAddorderviewdetailEndtime(endtime);
//		int PagNum = 20;
//		List<MlbackAddOrderViewDetail> mlbackAddOrderViewDetailList = mlbackAddOrderViewDetailService.selectMlbackAddOrderViewDetailByTime(mlbackAddOrderViewDetailreq);
//		
//		String  proSeo = "";
//		Integer proSeoNum = 0;
//		Integer k=0;
//		List<Integer> numList = new ArrayList<Integer>();
//		List<String> SeoStringList = new ArrayList<String>();
//		
//		for(int i=0;i<mlbackAddOrderViewDetailList.size();i++){
//			k++;
//			MlbackAddOrderViewDetail mlbackAddOrderViewDetailOne = mlbackAddOrderViewDetailList.get(i);
//			if(proSeo.isEmpty()){
//				System.out.println("第一次来，都不记录");
//				//proSeo = mlbackAddOrderViewDetailOne.getAddorderviewdetailSeoname();
//				proSeo = mlbackAddOrderViewDetailOne.getAddorderviewdetailProname();
//				SeoStringList.add(proSeo);
//			}else{
//				proSeo = mlbackAddOrderViewDetailOne.getAddorderviewdetailProname();
//				MlbackAddOrderViewDetail mlbackAddOrderViewDetailOneLast =mlbackAddOrderViewDetailList.get(i-1);
//				//String lastSeo = mlbackAddOrderViewDetailOneLast.getAddorderviewdetailSeoname();
//				String lastSeo = mlbackAddOrderViewDetailOneLast.getAddorderviewdetailProname();
//				Integer nowPronum = mlbackAddOrderViewDetailOneLast.getAddorderviewdetailActnum();
//				if(proSeo.equals(lastSeo)){
//					proSeoNum=proSeoNum+nowPronum;
//				}else{
//					SeoStringList.add(proSeo);
//					proSeoNum = k-1;
//					numList.add(proSeoNum);
//					k=1;
//				}
//			}
//		}
//		numList.add(k);
//		return Msg.success().add("SeoStringList", SeoStringList).add("numList", numList);
//	}
//	
//	/**3.0	UseNow	0505
//	 * 分类MlbackActShowPro列表分页list数据
//	 * @param pn
//	 * @return
//	 */
//	@RequestMapping(value="/getAddOrderViewDetailBuyNowNum",method=RequestMethod.POST)
//	@ResponseBody
//	public Msg getAddOrderViewDetailBuyNowNum(HttpSession session,@RequestBody MlbackAddOrderViewDetail mlbackAddOrderViewDetail) {
//		
//		String starttime = mlbackAddOrderViewDetail.getAddorderviewdetailStarttime();
//		String endtime = mlbackAddOrderViewDetail.getAddorderviewdetailEndtime();
//		MlbackAddOrderViewDetail mlbackAddOrderViewDetailreq = new MlbackAddOrderViewDetail();
//		mlbackAddOrderViewDetailreq.setAddorderviewdetailStarttime(starttime);
//		mlbackAddOrderViewDetailreq.setAddorderviewdetailEndtime(endtime);
//		mlbackAddOrderViewDetailreq.setAddorderviewdetailActnum(1);
//		List<MlbackAddOrderViewDetail> mlbackAddOrderViewDetailList = mlbackAddOrderViewDetailService.selectMlbackAddOrderViewDetailByTime(mlbackAddOrderViewDetailreq);
//		Integer toDayNum = mlbackAddOrderViewDetailList.size();
//		return Msg.success().add("mlbackAddOrderViewDetailList", mlbackAddOrderViewDetailList).add("toDayNum", toDayNum);
//	}
//	
//	
//	/**4.0	UseNow	0505
//	 * 分类MlbackProductViewDetail列表list数据
//	 * @param
//	 * @return
//	 */
//	@RequestMapping(value="/getAddOrderViewDetailBuyNowList",method=RequestMethod.POST)
//	@ResponseBody
//	public Msg getAddOrderViewDetailBuyNowList(HttpSession session,@RequestBody MlbackAddOrderViewDetail mlbackAddOrderViewDetail) {
//		
//		String starttime = mlbackAddOrderViewDetail.getAddorderviewdetailStarttime();
//		String endtime = mlbackAddOrderViewDetail.getAddorderviewdetailEndtime();
//		MlbackAddOrderViewDetail mlbackAddOrderViewDetailreq = new MlbackAddOrderViewDetail();
//		mlbackAddOrderViewDetailreq.setAddorderviewdetailStarttime(starttime);
//		mlbackAddOrderViewDetailreq.setAddorderviewdetailEndtime(endtime);
//		mlbackAddOrderViewDetailreq.setAddorderviewdetailActnum(1);	//用户行为，0纯加购	1点buyNow附带的加购
//		int PagNum = 20;
//		List<MlbackAddOrderViewDetail> mlbackAddOrderViewDetailList = mlbackAddOrderViewDetailService.selectMlbackAddOrderViewDetailByTime(mlbackAddOrderViewDetailreq);
//		
//		String  proSeo = "";
//		Integer proSeoNum = 0;
//		Integer k=0;
//		List<Integer> numList = new ArrayList<Integer>();
//		List<String> SeoStringList = new ArrayList<String>();
//		
//		for(int i=0;i<mlbackAddOrderViewDetailList.size();i++){
//			k++;
//			MlbackAddOrderViewDetail mlbackAddOrderViewDetailOne = mlbackAddOrderViewDetailList.get(i);
//			if(proSeo.isEmpty()){
//				System.out.println("第一次来，都不记录");
//				proSeo = mlbackAddOrderViewDetailOne.getAddorderviewdetailSeoname();
//				SeoStringList.add(proSeo);
//			}else{
//				proSeo = mlbackAddOrderViewDetailOne.getAddorderviewdetailSeoname();
//				MlbackAddOrderViewDetail mlbackAddOrderViewDetailOneLast =mlbackAddOrderViewDetailList.get(i-1);
//				String lastSeo = mlbackAddOrderViewDetailOneLast.getAddorderviewdetailSeoname();
//				if(proSeo.equals(lastSeo)){
//					proSeoNum++;
//				}else{
//					SeoStringList.add(proSeo);
//					proSeoNum = k-1;
//					numList.add(proSeoNum);
//					k=1;
//				}
//			}
//		}
//		numList.add(k);
//		return Msg.success().add("SeoStringList", SeoStringList).add("numList", numList);
//	}
	
	/**2.0	UseNow	0505
	 * 分类MlbackActShowPro列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getAddPayinfoViewDetailSuccessNum",method=RequestMethod.POST)
	@ResponseBody
	public Msg getAddPayinfoViewDetailSuccessNum(HttpSession session,@RequestBody MlbackAddPayinfoViewDetail mlbackAddPayinfoViewDetail) {
		
		String starttime = mlbackAddPayinfoViewDetail.getAddpayinfoviewdetailStarttime();
		String endtime = mlbackAddPayinfoViewDetail.getAddpayinfoviewdetailEndtime();
		
		MlfrontPayInfo mlfrontPayInfoReq = new MlfrontPayInfo();
		mlfrontPayInfoReq.setPayinfoCreatetime(starttime);
		mlfrontPayInfoReq.setPayinfoMotifytime(endtime);
		List<MlfrontPayInfo> mlfrontPayInfoList = mlfrontPayInfoService.selectMlfrontPayInfoByMotifyTime(mlfrontPayInfoReq);
		
		Integer toDayNum=mlfrontPayInfoList.size();
		return Msg.success().add("toDayNum", toDayNum);
	}
	
	/**4.0	UseNow	0505
	 * 分类MlbackProductViewDetail列表list数据
	 * @param
	 * @return
	 */
//	@RequestMapping(value="/getAddPayinfoViewDetailList",method=RequestMethod.POST)
//	@ResponseBody
//	public Msg getAddPayinfoViewDetailList(HttpSession session,@RequestBody MlbackAddPayinfoViewDetail mlbackAddPayinfoViewDetail) {
//		
//		String starttime = mlbackAddPayinfoViewDetail.getAddpayinfoviewdetailStarttime();
//		String endtime = mlbackAddPayinfoViewDetail.getAddpayinfoviewdetailEndtime();
//		
//		MlfrontPayInfo mlfrontPayInfoReq = new MlfrontPayInfo();
//		mlfrontPayInfoReq.setPayinfoCreatetime(starttime);
//		mlfrontPayInfoReq.setPayinfoMotifytime(endtime);
//		List<MlfrontPayInfo> mlfrontPayInfoList = mlfrontPayInfoService.selectMlfrontPayInfoByMotifyTime(mlfrontPayInfoReq);
//		
//		String  proSeo = "";
//		Integer proSeoNum = 0;
//		Integer k=0;
//		List<Integer> numList = new ArrayList<Integer>();
//		List<String> SeoStringList = new ArrayList<String>();
//		
//		for(int i=0;i<mlbackAddOrderViewDetailList.size();i++){
//			k++;
//			MlbackAddOrderViewDetail mlbackAddOrderViewDetailOne = mlbackAddOrderViewDetailList.get(i);
//			if(proSeo.isEmpty()){
//				System.out.println("第一次来，都不记录");
//				//proSeo = mlbackAddOrderViewDetailOne.getAddorderviewdetailSeoname();
//				proSeo = mlbackAddOrderViewDetailOne.getAddorderviewdetailProname();
//				SeoStringList.add(proSeo);
//			}else{
//				proSeo = mlbackAddOrderViewDetailOne.getAddorderviewdetailProname();
//				MlbackAddOrderViewDetail mlbackAddOrderViewDetailOneLast =mlbackAddOrderViewDetailList.get(i-1);
//				//String lastSeo = mlbackAddOrderViewDetailOneLast.getAddorderviewdetailSeoname();
//				String lastSeo = mlbackAddOrderViewDetailOneLast.getAddorderviewdetailProname();
//				Integer nowPronum = mlbackAddOrderViewDetailOneLast.getAddorderviewdetailActnum();
//				if(proSeo.equals(lastSeo)){
//					proSeoNum=proSeoNum+nowPronum;
//				}else{
//					SeoStringList.add(proSeo);
//					proSeoNum = k-1;
//					numList.add(proSeoNum);
//					k=1;
//				}
//			}
//		}
//		numList.add(k);
//		return Msg.success().add("SeoStringList", SeoStringList).add("numList", numList);
//	}

}
