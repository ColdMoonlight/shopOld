package com.atguigu.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackCategory;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlbackProductSku;
import com.atguigu.bean.MlbackProductViewDetail;
import com.atguigu.bean.Msg;
import com.atguigu.bean.SysUser;
import com.atguigu.bean.UserWork;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.GroupDisplayService;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackCategoryService;
import com.atguigu.service.MlbackProductService;
import com.atguigu.service.MlbackProductSkuService;
import com.atguigu.service.MlbackProductViewDetailService;
import com.atguigu.service.SysUserService;
import com.atguigu.service.UserWorkService;
import com.atguigu.utils.DateUtil;
import com.atguigu.utils.ExcelUtils;
import com.atguigu.utils.HttpUtil;
import com.atguigu.utils.IfMobileUtils;


@Controller
@RequestMapping("/MlbackProductAdmin")
public class MlbackProductAdminController {
		
	@Autowired
	MlbackProductService mlbackProductService;
	
	@Autowired
	MlbackCategoryService mlbackCategoryService;
	
	@Autowired
	MlbackAdminService mlbackAdminService;
	
	@Autowired
	MlbackProductViewDetailService mlbackProductViewDetailService;
	
	@Autowired
	MlbackProductSkuService mlbackProductSkuService;
	
	 
	 /**
	  * 1.0 UseNow 0505
	  * 通过管理模式下快速新增chanpi产品名查看单条产品的详情
	  * @param productId
	  * @return 
	  */
	 @RequestMapping(value="/copyProduct",method=RequestMethod.GET)
	 @ResponseBody
	 public Msg copyProduct(HttpServletResponse rep,HttpServletRequest res,HttpSession session,@RequestParam(value = "productId") Integer productId){
		
		//1.0封装参数接受信息
		MlbackProduct mlbackProductReq = new MlbackProduct();
		mlbackProductReq.setProductId(productId);
		List<MlbackProduct> mlbackProductResList = mlbackProductService.selectMlbackProduct(mlbackProductReq);
		MlbackProduct mlbackProductRes = mlbackProductResList.get(0);
		String productName = mlbackProductRes.getProductName();
		String proSeo = mlbackProductRes.getProductSeo();
		MlbackProduct mlbackProductIn =  mlbackProductRes;
		mlbackProductIn.setProductId(null);
		mlbackProductIn.setProductName(productName+"COPY");
		mlbackProductIn.setProductSeo(proSeo+"COPY");
		mlbackProductIn.setProductStatus(0);//0,不上架1,上架	刚复制完
		int insertResult = mlbackProductService.insertSelective(mlbackProductIn);
		//拿回插入后的产品id
		List<MlbackProduct> mlbackProductResListRes = mlbackProductService.selectMlbackProductlast();
		MlbackProduct mlbackProductInafter = mlbackProductResListRes.get(0);
		Integer productIdIn = mlbackProductInafter.getProductId();
		
		//查原产品skuList
		MlbackProductSku mlbackProductSkuReq = new MlbackProductSku();
		mlbackProductSkuReq.setProductId(productId);
		List<MlbackProductSku> mlbackProductSkuResList = mlbackProductSkuService.selectMlbackProductSku(mlbackProductSkuReq);
		//
		//
		MlbackProductSku mlbackProductSkuInReq = new MlbackProductSku();
		String nowTime = DateUtil.strTime14s();
		for(MlbackProductSku mlbackProductSku:mlbackProductSkuResList){
			mlbackProductSkuInReq = mlbackProductSku;
			mlbackProductSkuInReq.setProductskuId(null);
			mlbackProductSkuInReq.setProductId(productIdIn);
			mlbackProductSkuInReq.setProductskuCreatetime(nowTime);
			mlbackProductSkuInReq.setProductskuMotifytime(nowTime);
			
			mlbackProductSkuService.insertSelective(mlbackProductSkuInReq);
		}
		
		
		return Msg.success().add("resMsg", "查看单条类目的详情细节完毕")
				.add("insertResult", insertResult);
		  
	}
	
}