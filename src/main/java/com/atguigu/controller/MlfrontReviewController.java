package com.atguigu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlfrontReview;
import com.atguigu.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlfrontReviewService;
import com.atguigu.utils.DateUtil;
import com.atguigu.utils.ExcelUtils;
import com.atguigu.utils.HttpUtil;


@Controller
@RequestMapping("/MlfrontReview")
public class MlfrontReviewController {
		
	@Autowired
	MlfrontReviewService mlfrontReviewService;
	
	@Autowired
	MlbackAdminService mlbackAdminService;
	
	/**
	 * 1.0	useOn	0505
	 * 后台MlfrontReview列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlfrontReviewPage")
	public String tologin() throws Exception{
	
		return "back/mlbackReviewPage";
	}
	
	
	/**2.0	useOn	0505
	 * 分类MlbackCoupon列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getMlfrontReviewByPage")
	@ResponseBody
	public Msg getMlfrontReviewWithJson(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
			int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlfrontReview> mlfrontReviewList = mlfrontReviewService.selectMlfrontReviewGetAll();
			PageInfo page = new PageInfo(mlfrontReviewList, PagNum);
			return Msg.success().add("pageInfo", page);
//		}
	}
	
	/**3.0	useOn	0505
	 * MlfrontReview	insert
	 * @param MlfrontReview
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveSelective(HttpServletResponse rep,HttpServletRequest res,@RequestBody MlfrontReview mlfrontReview){
		//接受参数信息
		System.out.println("mlfrontReview:"+mlfrontReview);
		//取出id
		System.out.println(1);
		Integer reviewId = mlfrontReview.getReviewId();
		String nowTime = DateUtil.strTime14s();
		mlfrontReview.setReviewMotifytime(nowTime);
		if(reviewId==null){
			//无id，insert
			mlfrontReview.setReviewCreatetime(nowTime);
			int intResult = mlfrontReviewService.insertSelective(mlfrontReview);
			System.out.println(intResult);
			return Msg.success().add("resMsg", "插入成功");
		}else{
			//有id，update
			int intResult = mlfrontReviewService.updateByPrimaryKeySelective(mlfrontReview);
			System.out.println(intResult);
			return Msg.success().add("resMsg", "更新成功");
			
		}		
	}
	
	/**4.0	useOn	0505
	 * MlfrontReview	delete
	 * @param id
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(@RequestBody MlfrontReview mlfrontReview){
		//接收id信息
		Integer reviewId = mlfrontReview.getReviewId();
		int intResult = mlfrontReviewService.deleteByPrimaryKey(reviewId);
		System.out.println(intResult);
		return Msg.success().add("resMsg", "delete success");
	}
	
	/**
	 * 5.0	useOn	0505
	 * 查看单条MlfrontReview的详情细节
	 * @param MlfrontReview
	 * @return 
	 */
	@RequestMapping(value="/getOneMlfrontReviewDetailById",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneMlfrontReviewDetailById(@RequestParam(value = "reviewId") Integer reviewId){
		//接受信息
		MlfrontReview mlfrontReviewReq = new MlfrontReview();
		mlfrontReviewReq.setReviewId(reviewId);
		List<MlfrontReview> mlfrontReviewResList =mlfrontReviewService.selectMlfrontReviewById(mlfrontReviewReq);
		MlfrontReview mlfrontReviewOne =mlfrontReviewResList.get(0);
		return Msg.success().add("resMsg", "查看单条优惠券的详情细节完毕")
					.add("mlfrontReviewOne", mlfrontReviewOne);
	}
	
}
