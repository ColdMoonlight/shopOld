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

import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackCategory;
import com.atguigu.bean.MlbackCouponDescDetail;
import com.atguigu.bean.MlbackCouponDescTitle;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlbackSlide;
import com.atguigu.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackCategoryService;
import com.atguigu.service.MlbackCouponDescDetailService;
import com.atguigu.service.MlbackCouponDescTitleService;
import com.atguigu.service.MlbackProductService;
import com.atguigu.service.MlbackSlideService;
import com.atguigu.utils.DateUtil;


@Controller
@RequestMapping("/MlbackCouponDescTitle")
public class MlbackCouponDescTitleController {
	
	@Autowired
	MlbackCouponDescTitleService mlbackCouponDescTitleService;
		
	@Autowired
	MlbackCouponDescDetailService mlbackCouponDescDetailService;
	
	@Autowired
	MlbackAdminService mlbackAdminService;
	
	/**
	 * 1.0	onuse	200104
	 * toMlbackCouponDescTitlePage列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackCouponDescTitlePage")
	public String toMlbackCouponDescTitlePage() throws Exception{
	
		return "back/mlbackCouponDescTitlePage";
	}
	
	/**2.0	onuse	200104
	 * 分类mlbackCouponDescTitle列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getMlbackCouponDescTitleByPage")
	@ResponseBody
	public Msg getMlbackCouponDescTitleByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
			int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlbackCouponDescTitle> mlbackCouponDescTitleList = mlbackCouponDescTitleService.selectMlbackCouponDescTitleGetAll();
			System.out.println("mlbackCouponDescTitleList.size:"+mlbackCouponDescTitleList.size());
			PageInfo page = new PageInfo(mlbackCouponDescTitleList, PagNum);
			return Msg.success().add("pageInfo", page);
//		}
	}
	
	
	/**3.0	onuse	200104
	 * mlbackCouponDescTitle	save
	 * @param mlbackCouponDescTitle
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveSelective(HttpServletResponse rep,HttpServletRequest res,@RequestBody MlbackCouponDescTitle mlbackCouponDescTitle){
		//接受参数信息
		//获取类名
		Integer coupondesctieleId = mlbackCouponDescTitle.getCoupondesctieleId();
		
		String nowtime = DateUtil.strTime14s();
		mlbackCouponDescTitle.setCoupondesctieleMotifytime(nowtime);
		
		if(coupondesctieleId==null){
			mlbackCouponDescTitle.setCoupondesctieleCreatetime(nowtime);
			//无id，insert
			mlbackCouponDescTitleService.insertSelective(mlbackCouponDescTitle);
			return Msg.success().add("resMsg", "插入成功");
		}else{
			//有id，update
			mlbackCouponDescTitleService.updateByPrimaryKeySelective(mlbackCouponDescTitle);
			return Msg.success().add("resMsg", "更新成功");
		}		
	}
	
	/**4.0	UseNow	190905
	 * MlbackCouponDescTitle	delete
	 * @param id
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(@RequestBody MlbackCouponDescTitle mlbackCouponDescTitle){
		//接收id信息
		Integer coupondesctieleId = mlbackCouponDescTitle.getCoupondesctieleId();
		mlbackCouponDescTitleService.deleteByPrimaryKey(coupondesctieleId);
		return Msg.success().add("resMsg", "delete success");
	}
	
	/**
	 * 5.0	UseNow	190905
	 * 查看单条的详情细节
	 * @param MlbackSlide
	 * @return 
	 */
	@RequestMapping(value="/getOneMlbackCouponDescTitleDetail",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneMlbackCouponDescTitleDetail(@RequestParam(value = "coupondesctieleId") Integer coupondesctieleId){
		//接受actshowproId
		MlbackCouponDescTitle mlbackCouponDescTitleReq = new MlbackCouponDescTitle();
		mlbackCouponDescTitleReq.setCoupondesctieleId(coupondesctieleId);
		//查询本条
		MlbackCouponDescTitle mlbackCouponDescTitleOne =mlbackCouponDescTitleService.selectMlbackCouponDescTitleById(mlbackCouponDescTitleReq);
		
		
		return Msg.success().add("resMsg", "查看单条类目的详情细节完毕")
					.add("mlbackCouponDescTitleOne", mlbackCouponDescTitleOne);
	}
	
	/**
	 * 6.0	UseNow	190905
	 * 查询wap不同位置的图片
	 * @param MlbackSlide
	 * @return 
	 */
	@RequestMapping(value="/getMlbackSlidewapListByArea",method=RequestMethod.POST)
	@ResponseBody
	public Msg getMlbackSlidewapListByArea(HttpServletResponse rep,HttpServletRequest res,@RequestBody MlbackCouponDescTitle mlbackCouponDescTitle){
		//接受slideArea
		
		MlbackCouponDescTitle mlbackCouponDescTitleReq = new MlbackCouponDescTitle();
		mlbackCouponDescTitleReq.setCoupondesctieleWapstatus(1);
		//查询本条
		List<MlbackCouponDescTitle> mlbackCouponDescTitleList =mlbackCouponDescTitleService.selectMlbackCouponDescTitlewapListByArea(mlbackCouponDescTitleReq);
		
		MlbackCouponDescDetail mlbackCouponDescDetailReq = new MlbackCouponDescDetail();
		
		mlbackCouponDescDetailReq.setCoupondescdetailStatus(1);
		List<MlbackCouponDescDetail> mlbackCouponDescDetailList =   mlbackCouponDescDetailService.selectMlbackCouponDescDetailByStatus(mlbackCouponDescDetailReq);
		
		return Msg.success().add("resMsg", "查看该位置的轮播完毕").add("mlbackCouponDescTitleList", mlbackCouponDescTitleList).add("mlbackCouponDescDetailList", mlbackCouponDescDetailList);
	}
	
	/**
	 * 7.0	UseNow	190905
	 * 查询pc不同位置的图片
	 * @param MlbackSlide
	 * @return 
	 */
	@RequestMapping(value="/getMlbackSlidepcListByArea",method=RequestMethod.POST)
	@ResponseBody
	public Msg getMlbackSlidepcListByArea(HttpServletResponse rep,HttpServletRequest res,@RequestBody MlbackCouponDescTitle mlbackCouponDescTitle){
		//接受slideArea
		MlbackCouponDescTitle mlbackCouponDescTitleReq = new MlbackCouponDescTitle();
		mlbackCouponDescTitleReq.setCoupondesctielePcstatus(1);
		//查询本条
		List<MlbackCouponDescTitle> mlbackCouponDescTitleList =mlbackCouponDescTitleService.selectMlbackCouponDescTitlepcListByArea(mlbackCouponDescTitleReq);
		
		return Msg.success().add("resMsg", "查看该位置的轮播完毕").add("mlbackCouponDescTitleList", mlbackCouponDescTitleList);
	}

}
