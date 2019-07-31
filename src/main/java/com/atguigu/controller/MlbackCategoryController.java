package com.atguigu.controller;

import java.util.ArrayList;
import java.util.Date;
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
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackCategoryService;
import com.atguigu.service.MlbackProductService;
import com.atguigu.utils.DateUtil;


@Controller
@RequestMapping("/MlbackCategory")
public class MlbackCategoryController {
		
	@Autowired
	MlbackCategoryService mlbackCategoryService;
	
	@Autowired
	MlbackProductService mlbackProductService;
	
	@Autowired
	MlbackAdminService mlbackAdminService;
	
	/**
	 * 1.0	UseNow	0505
	 * to分类MlbackCategory列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackCategoryPage")
	public String tologin() throws Exception{
	
		return "back/mlbackCategoryPage";
	}
	
	/**
	 * 1.1	UseNow	0505
	 * 前台移动端获取详情页面mfront/Categorylists
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping(value="/toproductlist",method=RequestMethod.GET)
	public String tomProductDetailPage(HttpServletResponse rep,HttpServletRequest res,@RequestParam(value = "categoryId") Integer categoryId) throws Exception{
		//接收传递进来的参数
		Integer categoryIdReq = categoryId;
		//放回响应域中
		res.setAttribute("categoryId", categoryIdReq);
		//返回视图
		return "mfront/productlist";
	}
	
	
	/**2.0	UseNow	0505
	 * 分类MlbackCategory列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getMlbackCategoryByPage")
	@ResponseBody
	public Msg getGroupDisplayWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn
			,HttpSession session) {
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
			int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlbackCategory> mlbackCategoryList = mlbackCategoryService.selectMlbackCategoryGetAll();
			PageInfo page = new PageInfo(mlbackCategoryList, PagNum);
			return Msg.success().add("pageInfo", page);
//		}
	}
	
	
	/**3.0	UseNow	0505
	 * MlbackCategory	insert
	 * @param MlbackCategory
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveSelective(HttpServletResponse rep,HttpServletRequest res,@RequestBody MlbackCategory mlbackCategory){
		//接受参数信息
		//获取类名
		String categoryName = mlbackCategory.getCategoryName();
		//获取归属类名
		
		Integer categoryParentId = mlbackCategory.getCategoryParentId();
		
		MlbackCategory MlbackCategoryParentNameReq = new MlbackCategory();
		MlbackCategoryParentNameReq.setCategoryId(categoryParentId);
		
		List<MlbackCategory> MlbackCategoryList = mlbackCategoryService.selectMlbackCategory(MlbackCategoryParentNameReq);
		
		String categoryParentName="";
		String categoryDesc="";
		
		if(MlbackCategoryList.size()>0){
			MlbackCategory MlbackCategoryParentNameRes = MlbackCategoryList.get(0);
			
			categoryParentName = MlbackCategoryParentNameRes.getCategoryName();
			categoryDesc = MlbackCategoryParentNameRes.getCategoryDesc();
			
		}else{
			categoryParentName ="---none---";
		}
		
		
		//判断归属是否为none
		if(categoryParentName.equals("---none---")){
			mlbackCategory.setCategoryDesc(categoryName);
		}else{
			mlbackCategory.setCategoryDesc(categoryDesc+">"+categoryName);
			//mlbackCategory.setCategoryDesc(categoryParentName+">"+categoryName);
		}
		//取出id
		System.out.println(1);
		Integer categoryId = mlbackCategory.getCategoryId();
		mlbackCategory.setCategoryMotifytime(new Date());
		mlbackCategory.setCategoryParentName(categoryParentName);
		if(categoryId==null){
			//无id，insert
			System.out.println(3);
			int intResult = mlbackCategoryService.insertSelective(mlbackCategory);
			System.out.println(intResult);
			return Msg.success().add("resMsg", "插入成功");
		}else{
			//有id，update
			System.out.println(4);
			int intResult = mlbackCategoryService.updateByPrimaryKeySelective(mlbackCategory);
			System.out.println(intResult);
			return Msg.success().add("resMsg", "更新成功");
			
		}		
	}
	
	/**3.0	UseNow	0505
	 * MlbackCategory	insert
	 * @param MlbackCategory
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@ResponseBody
	public Msg insertSelective(HttpServletResponse rep,HttpServletRequest res,@RequestBody MlbackCategory mlbackCategory){
		//接受参数信息
		//获取类名
		String categoryName = mlbackCategory.getCategoryName();
		//获取归属类名
		String categoryParentName = mlbackCategory.getCategoryParentName();
		//判断归属是否为none
		if(categoryParentName=="none"){
			mlbackCategory.setCategoryDesc(categoryName);
		}else{
			mlbackCategory.setCategoryDesc(categoryParentName+">"+categoryName);
		}
		String nowTime = DateUtil.strTime14s();
		mlbackCategory.setCategoryMotifytime(new Date());
		int intResult = mlbackCategoryService.insertSelective(mlbackCategory);
		System.out.println(intResult);
		return Msg.success().add("resMsg", "插入成功");
	}
	
	/**4.0	UseNow	0505
	 * MlbackCategory	delete
	 * @param id
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(@RequestBody MlbackCategory mlbackCategory){
		//接收id信息
		int categoryIdInt = mlbackCategory.getCategoryId();
		int intResult = mlbackCategoryService.deleteByPrimaryKey(categoryIdInt);
		System.out.println(intResult);
		return Msg.success().add("resMsg", "delete success");
	}
	
	/**5.0	UseNow	0505
	 * MlbackCategory	update
	 * @param id MlbackCategory
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public Msg update(@RequestBody MlbackCategory mlbackCategory){
		//接受信息
		String nowtime = DateUtil.strTime14s();
		//更新本条状态
		int intResult = mlbackCategoryService.updateByPrimaryKeySelective(mlbackCategory);
		System.out.println(intResult);
		return Msg.success().add("resMsg", "更新成功");
	}
	
	/**
	 * 6.0	UseNow	0505
	 * 查看单条类目的详情细节
	 * @param MlbackCategory
	 * @return 
	 */
	@RequestMapping(value="/getOneMlbackCategoryDetail",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneMlbackCategoryDetail(@RequestParam(value = "categoryId") Integer categoryId){
		
		//接受categoryId
		MlbackCategory mlbackCategoryReq = new MlbackCategory();
		mlbackCategoryReq.setCategoryId(categoryId);
		//查询本条
		List<MlbackCategory> mlbackCategoryResList =mlbackCategoryService.selectMlbackCategory(mlbackCategoryReq);
		MlbackCategory mlbackCategoryOne =mlbackCategoryResList.get(0);
//		if(mlbackCategoryOne!=null){
//			String productIdsStr = mlbackCategoryOne.getCategoryProductIds();
//		}
		return Msg.success().add("resMsg", "查看单条类目的详情细节完毕")
					.add("mlbackCategoryOne", mlbackCategoryOne);
	}
	
	/**
	 * 7.0	UseNow	0505
	 * 传进Cid查询所有的类下的产品list
	 * @param MlbackCategory
	 * @return 
	 */
	@RequestMapping(value="/getMlFrontCategoryAllProductByCid",method=RequestMethod.POST)
	@ResponseBody
	public Msg getMlFrontCategoryAllProductByPid(@RequestParam(value = "categoryId") Integer categoryId){
		
		//接受categoryId
		MlbackCategory mlbackCategoryReq = new MlbackCategory();
		mlbackCategoryReq.setCategoryId(categoryId);
		//查询本条
		List<MlbackCategory> mlbackCategoryResList =mlbackCategoryService.selectMlbackCategory(mlbackCategoryReq);
		MlbackCategory mlbackCategoryOne =mlbackCategoryResList.get(0);
		String productidsStr = mlbackCategoryOne.getCategoryProductIds();
		
		String productidsStrArr [] =productidsStr.split(",");
		String productidStr ="";
		Integer productidInt =0;
		List<MlbackProduct> mlbackProductReqList = new ArrayList<MlbackProduct>();
		List<MlbackProduct> mlbackProductResList = new ArrayList<MlbackProduct>();
		MlbackProduct mlbackProductResOne = new MlbackProduct();
		for(int i=0;i<productidsStrArr.length;i++){
			productidStr = productidsStrArr[i];
			productidInt = Integer.parseInt(productidStr);
			//查询白pid的产品详情
			MlbackProduct mlbackProductReq = new MlbackProduct();
			mlbackProductReq.setProductId(productidInt);
			mlbackProductReqList =mlbackProductService.selectMlbackProduct(mlbackProductReq);
			mlbackProductResOne = mlbackProductReqList.get(0);
			mlbackProductResList.add(mlbackProductResOne);
		}
//		if(mlbackCategoryOne!=null){
//			String productIdsStr = mlbackCategoryOne.getCategoryProductIds();
//		}
		return Msg.success().add("resMsg", "传进Cid查询所有的类下的产品list完毕")
					.add("mlbackProductResList", mlbackProductResList);
	}
	
	/**
	 * 8.0	UseNow	0522
	 * 获取全部类目，以便于下拉选择
	 * @param MlbackCategory
	 * @return 
	 */
	@SuppressWarnings("null")
	@RequestMapping(value="/getOneMlbackCategoryParentDetail",method=RequestMethod.GET)
	@ResponseBody
	public Msg getOneMlbackCategoryParentDetail(HttpServletResponse rep,HttpServletRequest res){
		
		//查询全部的category信息，便于下拉选择
		List<MlbackCategory> mlbackCategorydownList = mlbackCategoryService.selectMlbackCategoryGetAllByParentId();
		System.out.println(mlbackCategorydownList);
		
		List<MlbackCategory> mlbackCategorydownEr =new ArrayList<MlbackCategory>();
		for(MlbackCategory mlbackCategoryOne :mlbackCategorydownList){
			Integer categoryParentId = mlbackCategoryOne.getCategoryParentId();
			if(categoryParentId>0){
				mlbackCategorydownEr.add(mlbackCategoryOne);
			}
		}
		
		return Msg.success().add("resMsg", "查看单条类目的详情细节完毕")
					.add("mlbackCategorydownList", mlbackCategorydownList).add("mlbackCategorydownEr", mlbackCategorydownEr);
	}
	
	
}
