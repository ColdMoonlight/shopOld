package com.atguigu.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.MlbackActShowPro;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackCategory;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.bean.MlbackProductImg;
import com.atguigu.bean.MlbackShowArea;
import com.atguigu.bean.Msg;
import com.atguigu.bean.SysUser;
import com.atguigu.bean.UserWork;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.GroupDisplayService;
import com.atguigu.service.MlbackActShowProService;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackCategoryService;
import com.atguigu.service.MlbackProductImgService;
import com.atguigu.service.MlbackProductService;
import com.atguigu.service.MlbackShowAreaService;
import com.atguigu.service.SysUserService;
import com.atguigu.service.UserWorkService;
import com.atguigu.utils.DateUtil;
import com.atguigu.utils.ExcelUtils;
import com.atguigu.utils.HttpUtil;
import com.atguigu.utils.UpImgUtils;


@Controller
@RequestMapping("/UpImg")
public class UPloadController {
		
	@Autowired
	MlbackProductService mlbackProductService;
	
	@Autowired
	MlbackProductImgService mlbackProductImgService;
	
	@Autowired
	MlbackCategoryService MlbackCategoryService;
	
	@Autowired
	MlbackShowAreaService mlbackShowAreaService;
	
	@Autowired
	MlbackAdminService mlbackAdminService;
	
	@Autowired
	MlbackActShowProService mlbackActShowProService;
	
	/**
	 * 1.0	useOn	0505
	 * uploadCategoryImg
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/uploadCategoryImg")
	@ResponseBody
	public Msg toUploadCategoryImg(HttpServletResponse rep,HttpServletRequest res) throws Exception{
		
		
		String contextPathStr = res.getContextPath();    
        System.out.println("contextPathStr:"+contextPathStr);
        String realPathStr = res.getSession().
                        getServletContext().getRealPath("/");    
        System.out.println("realPathStr:"+realPathStr);
        String basePathStr = res.getScheme()+"://"+res.getServerName()+":"+
        		res.getServerPort()+contextPathStr+"/";
        
        System.out.println("basePathStr:"+basePathStr);
		
		
		String pathBig = basePathStr;
		
		String path="static/img/category/";
		//存储图片
		String returnUrl = UpImgUtils.keepCategoryFile(res);
		
		String[] aa = returnUrl.split("%");
		String returnReaUrl =aa[0];
		String CategoryIdstr = aa[1];
		
		int CategoryIdInt = Integer.parseInt(CategoryIdstr);
		
		System.out.println("CategoryIdstr:"+CategoryIdstr);
		
		String returnReaUrlAll = pathBig+path+returnReaUrl;
		
		MlbackCategory mlbackCategory = new MlbackCategory();
		
		mlbackCategory.setCategoryId(CategoryIdInt);
		//win环境下
		mlbackCategory.setCategoryImgurl(returnReaUrlAll);
		//linux环境下
		//mlbackCategory.setCategoryImgurl(returnReaUrl);
		
		MlbackCategoryService.updateByPrimaryKeySelective(mlbackCategory);
		
		System.out.println("returnReaUrl:"+returnReaUrl);
		
		//把文件存储的url存到数据库中
		return Msg.success().add("resMsg", "插入成功").add("uploadUrl", returnReaUrl);
	}
	
	/**
	 * 1.1	useOn	0505
	 * uploadCategoryPcImg
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/uploadCategoryPcImg")
	@ResponseBody
	public Msg uploadCategoryPcImg(HttpServletResponse rep,HttpServletRequest res) throws Exception{
		
		
		String contextPathStr = res.getContextPath();    
        System.out.println("contextPathStr:"+contextPathStr);
        String realPathStr = res.getSession().
                        getServletContext().getRealPath("/");    
        System.out.println("realPathStr:"+realPathStr);
        String basePathStr = res.getScheme()+"://"+res.getServerName()+":"+
        		res.getServerPort()+contextPathStr+"/";
        
        System.out.println("basePathStr:"+basePathStr);
		
		
		String pathBig = basePathStr;
		
		String path="static/img/category/";
		//存储图片
		String returnUrl = UpImgUtils.keepCategoryFile(res);
		
		String[] aa = returnUrl.split("%");
		String returnReaUrl =aa[0];
		String CategoryIdstr = aa[1];
		
		int CategoryIdInt = Integer.parseInt(CategoryIdstr);
		
		System.out.println("CategoryIdstr:"+CategoryIdstr);
		
		String returnReaUrlAll = pathBig+path+returnReaUrl;
		
		MlbackCategory mlbackCategory = new MlbackCategory();
		
		mlbackCategory.setCategoryId(CategoryIdInt);
		//win环境下
		mlbackCategory.setCategoryImgPcurl(returnReaUrlAll);
		//linux环境下
		//mlbackCategory.setCategoryImgurl(returnReaUrl);
		
		MlbackCategoryService.updateByPrimaryKeySelective(mlbackCategory);
		
		System.out.println("returnReaUrl:"+returnReaUrl);
		
		//把文件存储的url存到数据库中
		return Msg.success().add("resMsg", "插入成功").add("uploadUrl", returnReaUrl);
	}
	
	
	/**
	 * 2.0	useOn	0505
	 * to分类MlbackProduct列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/uploadProductImg")
	@ResponseBody
	public Msg toUploadProductImg(HttpServletResponse rep,HttpServletRequest res) throws Exception{
		
		
		String contextPathStr = res.getContextPath();    
        System.out.println("contextPathStr:"+contextPathStr);
        String realPathStr = res.getSession().
                        getServletContext().getRealPath("/");    
        System.out.println("realPathStr:"+realPathStr);
        String basePathStr = res.getScheme()+"://"+res.getServerName()+":"+
        		res.getServerPort()+contextPathStr+"/";
        
        System.out.println("basePathStr:"+basePathStr);
		
		
		String pathBig = basePathStr;
		
		String path="static/img/product/";
		//存储图片
		String returnUrl = UpImgUtils.keepProductFile(res);
		
		String[] aa = returnUrl.split("%");
		String returnReaUrl =aa[0];
		String ProductIdstr = aa[1];
		
		int ProductIdInt = Integer.parseInt(ProductIdstr);
		
		System.out.println("ProductIdstr:"+ProductIdstr);
		
		String returnReaUrlAll = pathBig+path+returnReaUrl;
		
		MlbackProduct mlbackProduct = new MlbackProduct();
		
		mlbackProduct.setProductId(ProductIdInt);
		
		mlbackProduct.setProductMainimgurl(returnReaUrlAll);
		
//		MlbackCategory mlbackCategory = new MlbackCategory();
//		
//		mlbackCategory.setCategoryId(CategoryIdInt);
//		//win环境下
//		mlbackCategory.setCategoryImgurl(returnReaUrlAll);
		//linux环境下
		//mlbackCategory.setCategoryImgurl(returnReaUrl);
		
		mlbackProductService.updateByPrimaryKeySelective(mlbackProduct);
		
		System.out.println("returnReaUrl:"+returnReaUrl);
		
		//把文件存储的url存到数据库中
		return Msg.success().add("resMsg", "插入成功").add("uploadUrl", returnReaUrl);
	}
	
	
	
	/**
	 * 2.1	useOn	0505
	 * to分类MlbackProduct列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toUploadProductFuImg")
	@ResponseBody
	public Msg toUploadProductFuImg(HttpServletResponse rep,HttpServletRequest res) throws Exception{
		
		
		String contextPathStr = res.getContextPath();    
        System.out.println("contextPathStr:"+contextPathStr);
        String realPathStr = res.getSession().
                        getServletContext().getRealPath("/");    
        System.out.println("realPathStr:"+realPathStr);
        String basePathStr = res.getScheme()+"://"+res.getServerName()+":"+
        		res.getServerPort()+contextPathStr+"/";
        
        System.out.println("basePathStr:"+basePathStr);
		
		
		String pathBig = basePathStr;
		
		String path="static/img/product/";
		//存储图片
		String returnUrl = UpImgUtils.keepProductFile(res);
		
		String[] aa = returnUrl.split("%");
		String returnReaUrl =aa[0];
		String ProductIdstr = aa[1];
		
		int ProductIdInt = Integer.parseInt(ProductIdstr);
		
		System.out.println("ProductIdstr:"+ProductIdstr);
		
		String returnReaUrlAll = pathBig+path+returnReaUrl;
		
		MlbackProduct mlbackProduct = new MlbackProduct();
		
		mlbackProduct.setProductId(ProductIdInt);
		
		mlbackProduct.setproductMainFuimgurl(returnReaUrlAll);
		
//		MlbackCategory mlbackCategory = new MlbackCategory();
//		
//		mlbackCategory.setCategoryId(CategoryIdInt);
//		//win环境下
//		mlbackCategory.setCategoryImgurl(returnReaUrlAll);
		//linux环境下
		//mlbackCategory.setCategoryImgurl(returnReaUrl);
		
		mlbackProductService.updateMainFuImgById(mlbackProduct);
		
		System.out.println("returnReaUrl:"+returnReaUrl);
		
		//把文件存储的url存到数据库中
		return Msg.success().add("resMsg", "插入成功").add("uploadUrl", returnReaUrl);
	}
	
	
	/**
	 * 3.0	useOn	0522
	 * 上传，产品的6张图，存入图片详情表
	 * @param url
	 * @return 
	 * */
	@RequestMapping("/uploadProductAllImg")
	@ResponseBody
	public Msg toUploadProductAllImg(HttpServletResponse rep,HttpServletRequest res) throws Exception{
		
		String contextPathStr = res.getContextPath();    
        System.out.println("contextPathStr:"+contextPathStr);
        
        String realPathStr = res.getSession().getServletContext().getRealPath("/");    
        System.out.println("realPathStr:"+realPathStr);
        
        String basePathStr = res.getScheme()+"://"+res.getServerName()+":"+res.getServerPort()+contextPathStr+"/";
        System.out.println("basePathStr:"+basePathStr);
		
		String pathBig = basePathStr;
		
		String path="static/img/productAll/";
		//存储图片
		String returnUrl = UpImgUtils.keepProductImgAllFile(res);
		
		String[] aa = returnUrl.split("%");
		String returnReaUrl =aa[0];
		String ProductIdstr = aa[1];
		String productimgSortIdstr = aa[2];
		
		int ProductIdInt = Integer.parseInt(ProductIdstr);
		
		int productimgSortInt = Integer.parseInt(productimgSortIdstr);
		
		System.out.println("ProductIdstr:"+ProductIdstr);
		
		String returnReaUrlAll = pathBig+path+returnReaUrl;
		
		
		//查询文件是否在
		MlbackProductImg mlbackProductImgIf = new MlbackProductImg();
		
		mlbackProductImgIf.setProductId(ProductIdInt);
		mlbackProductImgIf.setProductimgSortOrder(productimgSortInt);
		
		List<MlbackProductImg> mlbackProductImgIfList = mlbackProductImgService.selectMlbackProductImgByPIdAndImgSort(mlbackProductImgIf);
		MlbackProductImg mlbackProductImg = new MlbackProductImg();
		
		mlbackProductImg.setProductId(ProductIdInt);
		
		mlbackProductImg.setProductimgUrl(returnReaUrlAll);
		
		mlbackProductImg.setProductimgSortOrder(productimgSortInt);
		
		mlbackProductImg.setProductimgName(returnReaUrl);
		
		String nowTime = DateUtil.strTime14s();
		mlbackProductImg.setProductimgMotifytime(nowTime);
		
		if(mlbackProductImgIfList.size()>0){
			//取出id
			int pImgId = mlbackProductImgIfList.get(0).getProductimgId();
			
			mlbackProductImg.setProductimgId(pImgId);
			
			mlbackProductImgService.updateByPrimaryKeySelective(mlbackProductImg);
			
			//存在update
		}else{
			mlbackProductImg.setProductimgCreatetime(nowTime);
			//存在insert
			mlbackProductImgService.insertSelective(mlbackProductImg);
		}
		System.out.println("returnReaUrl:"+returnReaUrl);
		
		//把文件存储的url存到数据库中
		return Msg.success().add("resMsg", "插入成功").add("uploadUrl", returnReaUrl);
	}
	
	
	/**
	 * 1.0	useOn	0505
	 * toUploadShowAreaImg
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toUploadShowAreaImg")
	@ResponseBody
	public Msg toUploadShowAreaImg(HttpServletResponse rep,HttpServletRequest res) throws Exception{
		
		
		String contextPathStr = res.getContextPath();    
        System.out.println("contextPathStr:"+contextPathStr);
        String realPathStr = res.getSession().
                        getServletContext().getRealPath("/");    
        System.out.println("realPathStr:"+realPathStr);
        String basePathStr = res.getScheme()+"://"+res.getServerName()+":"+
        		res.getServerPort()+contextPathStr+"/";
        
        System.out.println("basePathStr:"+basePathStr);
		
		
		String pathBig = basePathStr;
		
		String path="static/img/showArea/";
		//存储图片
		String returnUrl = UpImgUtils.keepShowAreaFile(res);
		
		String[] aa = returnUrl.split("%");
		String returnReaUrl =aa[0];
		String ShowareaIdstr = aa[1];
		
		int ShowareaIdInt = Integer.parseInt(ShowareaIdstr);
		
		System.out.println("ShowareaIdstr:"+ShowareaIdstr);
		
		String returnReaUrlAll = pathBig+path+returnReaUrl;
		
		MlbackShowArea mlbackShowArea = new MlbackShowArea();
		
		mlbackShowArea.setShowareaId(ShowareaIdInt);
		//win环境下
		mlbackShowArea.setShowareaImgurl(returnReaUrlAll);
		//linux环境下
		//mlbackCategory.setCategoryImgurl(returnReaUrl);
		
		mlbackShowAreaService.updateByPrimaryKeySelective(mlbackShowArea);
		
		System.out.println("returnReaUrl:"+returnReaUrl);
		
		//把文件存储的url存到数据库中
		return Msg.success().add("resMsg", "插入成功").add("uploadUrl", returnReaUrl);
	}
	
	/**
	 * 1.1	useOn	0505
	 * uploadShowAreaPcImg
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/uploadShowAreaPcImg")
	@ResponseBody
	public Msg uploadShowAreaPcImg(HttpServletResponse rep,HttpServletRequest res) throws Exception{
		
		
		String contextPathStr = res.getContextPath();    
        System.out.println("contextPathStr:"+contextPathStr);
        String realPathStr = res.getSession().
                        getServletContext().getRealPath("/");    
        System.out.println("realPathStr:"+realPathStr);
        String basePathStr = res.getScheme()+"://"+res.getServerName()+":"+
        		res.getServerPort()+contextPathStr+"/";
        
        System.out.println("basePathStr:"+basePathStr);
		
		
		String pathBig = basePathStr;
		
		String path="static/img/showArea/";
		//存储图片
		String returnUrl = UpImgUtils.keepShowAreaFile(res);
		
		String[] aa = returnUrl.split("%");
		String returnReaUrl =aa[0];
		String ShowareaIdstr = aa[1];
		
		int ShowareaIdsInt = Integer.parseInt(ShowareaIdstr);
		
		System.out.println("ShowareaIdstr:"+ShowareaIdstr);
		
		String returnReaUrlAll = pathBig+path+returnReaUrl;
		
		MlbackShowArea mlbackShowArea = new MlbackShowArea();
		
		mlbackShowArea.setShowareaId(ShowareaIdsInt);
		//win环境下
		mlbackShowArea.setShowareaImgpcurl(returnReaUrlAll);
		//linux环境下
		//mlbackCategory.setCategoryImgurl(returnReaUrl);
		
		mlbackShowAreaService.updateByPrimaryKeySelective(mlbackShowArea);
		
		System.out.println("returnReaUrl:"+returnReaUrl);
		
		//把文件存储的url存到数据库中
		return Msg.success().add("resMsg", "插入成功").add("uploadUrl", returnReaUrl);
	}
	
	
	/**
	 * 1.1	useOn	0505
	 * uploadShowAreaPcImg
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/uploadActShowProWapImg")
	@ResponseBody
	public Msg uploadActShowProWapImg(HttpServletResponse rep,HttpServletRequest res) throws Exception{
		
		
		String contextPathStr = res.getContextPath();    
        System.out.println("contextPathStr:"+contextPathStr);
        String realPathStr = res.getSession().
                        getServletContext().getRealPath("/");    
        System.out.println("realPathStr:"+realPathStr);
        String basePathStr = res.getScheme()+"://"+res.getServerName()+":"+
        		res.getServerPort()+contextPathStr+"/";
        
        System.out.println("basePathStr:"+basePathStr);
		
		
		String pathBig = basePathStr;
		
		String path="static/img/actShowPro/";
		//存储图片
		String returnUrl = UpImgUtils.keepActShowProWapFile(res);
		
		String[] aa = returnUrl.split("%");
		String returnReaUrl =aa[0];
		String ActshowproIdstr = aa[1];
		
		int ActshowproIdsInt = Integer.parseInt(ActshowproIdstr);
		
		System.out.println("ActshowproIdstr:"+ActshowproIdstr);
		
		String returnReaUrlAll = pathBig+path+returnReaUrl;
		
		MlbackActShowPro mlbackActShowPro = new MlbackActShowPro();
		
		mlbackActShowPro.setActshowproId(ActshowproIdsInt);
		//win环境下
		mlbackActShowPro.setActshowproImgwapurl(returnReaUrlAll);
		//linux环境下
		//mlbackCategory.setCategoryImgurl(returnReaUrl);
		
		mlbackActShowProService.updateByPrimaryKeySelective(mlbackActShowPro);
		
		System.out.println("returnReaUrl:"+returnReaUrl);
		
		//把文件存储的url存到数据库中
		return Msg.success().add("resMsg", "插入成功").add("uploadUrl", returnReaUrl);
	}
	
	/**
	 * 1.1	useOn	0505
	 * uploadShowAreaPcImg
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/uploadActShowProPcImg")
	@ResponseBody
	public Msg uploadActShowProPcImg(HttpServletResponse rep,HttpServletRequest res) throws Exception{
		
		
		String contextPathStr = res.getContextPath();    
        System.out.println("contextPathStr:"+contextPathStr);
        String realPathStr = res.getSession().
                        getServletContext().getRealPath("/");    
        System.out.println("realPathStr:"+realPathStr);
        String basePathStr = res.getScheme()+"://"+res.getServerName()+":"+
        		res.getServerPort()+contextPathStr+"/";
        
        System.out.println("basePathStr:"+basePathStr);
		
		
		String pathBig = basePathStr;
		
		String path="static/img/actShowPro/";
		//存储图片
		String returnUrl = UpImgUtils.keepActShowProPcFile(res);
		
		String[] aa = returnUrl.split("%");
		String returnReaUrl =aa[0];
		String ActshowproIdstr = aa[1];
		
		int ActshowproIdsInt = Integer.parseInt(ActshowproIdstr);
		
		System.out.println("ActshowproIdstr:"+ActshowproIdstr);
		
		String returnReaUrlAll = pathBig+path+returnReaUrl;
		
		MlbackActShowPro mlbackActShowPro = new MlbackActShowPro();
		
		mlbackActShowPro.setActshowproId(ActshowproIdsInt);
		//win环境下
		mlbackActShowPro.setActshowproImgpcurl(returnReaUrlAll);
		
		mlbackActShowProService.updateByPrimaryKeySelective(mlbackActShowPro);
		
		System.out.println("returnReaUrl:"+returnReaUrl);
		
		//把文件存储的url存到数据库中
		return Msg.success().add("resMsg", "插入成功").add("uploadUrl", returnReaUrl);
	}
	
}
