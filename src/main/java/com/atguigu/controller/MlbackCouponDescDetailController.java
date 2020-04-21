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

import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackCouponDescDetail;
import com.atguigu.bean.Msg;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackCouponDescDetailService;
import com.atguigu.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/MlbackCouponDescDetail")
public class MlbackCouponDescDetailController {
		
	@Autowired
	MlbackCouponDescDetailService mlbackCouponDescDetailService;
	
	@Autowired
	MlbackAdminService mlbackAdminService;
	
	
	/**
	 * 1.0	onuse	200104
	 * toMlbackCouponDescDetailPage列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackCouponDescDetailPage")
	public String toMlbackCouponDescDetailPage() throws Exception{
	
		return "back/mlbackCouponDescDetailPage";
	}
	
	/**2.0	onuse	200104
	 * 分类mlbackCouponDescDetail列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getMlbackCouponDescDetailByPage")
	@ResponseBody
	public Msg getMlbackCouponDescDetailByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
			int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlbackCouponDescDetail> mlbackCouponDescDetailList = mlbackCouponDescDetailService.selectMlbackCouponDescDetailAll();
			System.out.println("mlbackCouponDescDetailList.size:"+mlbackCouponDescDetailList.size());
			PageInfo page = new PageInfo(mlbackCouponDescDetailList, PagNum);
			return Msg.success().add("pageInfo", page);
//		}
	}
	
	
	/**3.0	onuse	200104
	 * MlbackCouponDescDetail	add/update
	 * @param MlbackCouponDescDetail
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveSelective(HttpServletResponse rep,HttpServletRequest res,@RequestBody MlbackCouponDescDetail mlbackCouponDescDetail){
		//接受参数
		Integer coupondescdetailId = mlbackCouponDescDetail.getCoupondescdetailId();
		String nowTime = DateUtil.strTime14s();
		mlbackCouponDescDetail.setCoupondescdetailMotifytime(nowTime);
		if(coupondescdetailId==null){
			//无id，insert
			mlbackCouponDescDetail.setCoupondescdetailCreatetime(nowTime);
			mlbackCouponDescDetailService.insertSelective(mlbackCouponDescDetail);
			return Msg.success().add("resMsg", "插入成功");
		}else{
			//有id，update
			mlbackCouponDescDetailService.updateByPrimaryKeySelective(mlbackCouponDescDetail);
			return Msg.success().add("resMsg", "更新成功");
		}		
	}
	
	/**4.0	onuse	200104
	 * MlbackShowArea	delete
	 * @param id
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(@RequestBody MlbackCouponDescDetail mlbackCouponDescDetail){
		//接收id信息
		int coupondescdetailId = mlbackCouponDescDetail.getCoupondescdetailId();
		mlbackCouponDescDetailService.deleteByPrimaryKey(coupondescdetailId);
		return Msg.success().add("resMsg", "delete success");
	}
	
	/**
	 * 5.0	onuse	200104
	 * 查看单产品的全部sku
	 * @param coupondescdetailId
	 * @return 
	 */
	@RequestMapping(value="/getCouponDescDetailById",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneMlbackProductDetail(@RequestParam(value = "coupondescdetailId") Integer coupondescdetailId){
		
		//接受信息
		MlbackCouponDescDetail mlbackCouponDescDetailReq = new MlbackCouponDescDetail();
		mlbackCouponDescDetailReq.setCoupondescdetailId(coupondescdetailId);
		List<MlbackCouponDescDetail> mlbackCouponDescDetailResList =mlbackCouponDescDetailService.selectMlbackCouponDescDetailById(mlbackCouponDescDetailReq);
		MlbackCouponDescDetail mlbackCouponDescDetailOne = mlbackCouponDescDetailResList.get(0);
		return Msg.success().add("resMsg", "查看本coupondescdetailId的详情信息")
					.add("mlbackCouponDescDetailOne", mlbackCouponDescDetailOne);
	}
	
	/**
	 * 6.0	UseNow	0505
	 * 查看单条类目的详情细节
	 * @param MlbackProduct
	 * @return 
	 */
	@RequestMapping(value="/getCouponDescDetailByStatus",method=RequestMethod.POST)
	@ResponseBody
	public Msg getCouponDescDetailByStatus(@RequestParam(value = "coupondescdetailStatus") Integer coupondescdetailStatus){
		
		//接受信息
		MlbackCouponDescDetail mlbackCouponDescDetailReq = new MlbackCouponDescDetail();
		mlbackCouponDescDetailReq.setCoupondescdetailStatus(coupondescdetailStatus);//0	NO	1	Yes
		List<MlbackCouponDescDetail> mlbackCouponDescDetailResList =mlbackCouponDescDetailService.selectMlbackCouponDescDetailByStatus(mlbackCouponDescDetailReq);
		return Msg.success().add("resMsg", "查看本productid的全部sku详情信息")
					.add("mlbackCouponDescDetailResList", mlbackCouponDescDetailResList);
	}
	
}
