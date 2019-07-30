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
import com.atguigu.bean.Msg;
import com.atguigu.bean.SysUser;
import com.atguigu.bean.UserWork;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.GroupDisplayService;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackCategoryService;
import com.atguigu.service.MlbackProductService;
import com.atguigu.service.SysUserService;
import com.atguigu.service.UserWorkService;
import com.atguigu.utils.DateUtil;
import com.atguigu.utils.ExcelUtils;
import com.atguigu.utils.HttpUtil;


@Controller
@RequestMapping("/MlbackProduct")
public class MlbackProductController {
		
	@Autowired
	MlbackProductService mlbackProductService;
	
	@Autowired
	MlbackCategoryService mlbackCategoryService;
	
	@Autowired
	MlbackAdminService mlbackAdminService;
	
	/**
	 * 1.0	UseNow	0505
	 * to分类MlbackProduct列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackProductPage")
	public String toMlbackProductPage() throws Exception{
	
		return "back/mlbackProductPage";
	}
	
	/**
	 * 1.1	UseOff	0505
	 * to分类MlbackProduct列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackProductSearchPage")
	public String toMlbackProductSearchPage() throws Exception{
	
		return "back/mlbackProductSearchPage";
	}
	
	/**
	 * 1.1	UseNow	0505
	 * 前台移动端获取详情页面mfront/productDetails
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping(value="/tomProductDetailPage",method=RequestMethod.GET)
	public String tomProductDetailPage(HttpServletResponse rep,HttpServletRequest res,@RequestParam(value = "productId") Integer productId) throws Exception{
		//接收传递进来的参数
		Integer productIdReq = productId;
		//放回响应域中
		res.setAttribute("productId", productIdReq);
		//返回视图
		return "mfront/productDetails";
	}
	
	/**
	 * 1.2	useOn	0505
	 * 前台PC端获取详情页面front/PCproductDetails
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping(value="/tomProductDetailPagePC",method=RequestMethod.GET)
	public String tomProductDetailPagePC(HttpServletResponse rep,HttpServletRequest res,@RequestParam(value = "productId") Integer productId) throws Exception{
		//接收传递进来的参数
		Integer productIdReq = productId;
		//放回响应域中
		res.setAttribute("productId", productIdReq);
		//返回视图
		return "front/pcproductDetails";
	}
	
	/**2.0	UseNow	0505
	 * 分类MlbackProduct列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getMlbackProductByPage")
	@ResponseBody
	public Msg getMlbackProductWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn
			,HttpSession session) {
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
			int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlbackProduct> mlbackProductList = mlbackProductService.selectMlbackProductGetAll();
			PageInfo page = new PageInfo(mlbackProductList, PagNum);
			return Msg.success().add("pageInfo", page);
//		}
	}
	
	/**3.0	UseNow	0505
	 * MlbackProduct	insert
	 * @param MlbackProduct
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveSelective(HttpServletResponse rep,HttpServletRequest res,@RequestBody MlbackProduct mlbackProduct){
		//接受参数信息
		//取出id
		Integer productId = mlbackProduct.getProductId();
		String productName = mlbackProduct.getProductName();
		Integer  CategoryId = mlbackProduct.getProductCategoryid();
		
		MlbackCategory MlbackCategoryParentNameReq = new MlbackCategory();
		MlbackCategoryParentNameReq.setCategoryId(CategoryId);
		
		List<MlbackCategory> MlbackCategoryList = mlbackCategoryService.selectMlbackCategory(MlbackCategoryParentNameReq);
		MlbackCategory MlbackCategory0 = MlbackCategoryList.get(0);
		String MlbackCategoryName =  MlbackCategory0.getCategoryDesc();
		
		mlbackProduct.setproductCategoryname(MlbackCategoryName);
		//获取折扣id
		Integer Actoffid = mlbackProduct.getProductActoffid();
		if(Actoffid==null){
			Actoffid = 10;
		}
		System.out.println("Actoffid:"+Actoffid);
		Integer Actoffoff= Actoffid*10;
		//获取折扣力度
		System.out.println("Actoffoff:"+Actoffoff);
		mlbackProduct.setProductActoffoff(Actoffoff);
		if(productId==null){
			//无id，insert
			int intResult = mlbackProductService.insertSelective(mlbackProduct);
			System.out.println(intResult);
			return Msg.success().add("resMsg", "插入成功");
		}else{
			//先对这个产品选择的一些类，进行productIdStr的清理,
			//有id，update
			System.out.println(4);
			//1.0从中读取categoryIdsStr,切割得到每一个categoryId,遍历，把productId,填充再每个查回来的categort中的proidStr拼上
			String categoryIdsStr = mlbackProduct.getProductCategoryIdsStr();
			UpdateCategoryProductIdStr(categoryIdsStr,productId,productName);
			//更新本条product的新数据
			int intResult = mlbackProductService.updateByPrimaryKeySelective(mlbackProduct);
			
			System.out.println(intResult);
			return Msg.success().add("resMsg", "更新成功");
			
		}		
	}
	
	
	/**
	 * 3.1
	 * //从中读取categoryIdsStr,切割得到每一个categoryId,
	 * 遍历categoryId查询，把productId,填充再每个查回来的category中的proidStr拼上
	 * */
	private void UpdateCategoryProductIdStr(String categoryIdsStr, Integer productId,String productName) {
		
		String nowtime = DateUtil.strTime14s();
		String inproductIdStr=productId+"";
		
		if(categoryIdsStr==""){
			System.out.println("categoryIdsStr为空");
			//把该productId下的
			ProductCategoryIdsStrUpdateOld(productId,categoryIdsStr);
			//清理掉，该产品下的类
			MlbackProduct mlbackProductReq = new MlbackProduct();
			mlbackProductReq.setProductId(productId);
			mlbackProductReq.setProductCategoryIdsStr("");
			mlbackProductReq.setProductCategoryNamesStr("");
			mlbackProductService.updateByPrimaryKeySelective(mlbackProductReq);
			
		}else{
			
			//先清理老的数据
			ProductCategoryIdsStrUpdateOld(productId,categoryIdsStr);
			
			//从中读取categoryIdsStr,切割得到每一个categoryId,
			String categoryIdsStrArr [] = categoryIdsStr.split(",");
			String categoryIdStr = "";
			Integer categoryIdInt = 0;
			MlbackCategory mlbackCategoryReq = new MlbackCategory();
			MlbackCategory mlbackCategoryRes = new MlbackCategory();
			
			MlbackCategory mlbackCategoryReqUpdate = new MlbackCategory();
			List<MlbackCategory> mlbackCategoryList = new ArrayList<MlbackCategory>();
			String categoryProductIdsStr = "";
			String categoryproductNamesStr = "";
			
			for(int i=0;i<categoryIdsStrArr.length;i++){
				categoryIdStr=categoryIdsStrArr[i];
				categoryIdInt = Integer.parseInt(categoryIdStr);
				//遍历categoryId查询
				mlbackCategoryReq.setCategoryId(categoryIdInt);
				mlbackCategoryList = mlbackCategoryService.selectMlbackCategory(mlbackCategoryReq);
				mlbackCategoryRes = mlbackCategoryList.get(0);
				categoryProductIdsStr = mlbackCategoryRes.getCategoryProductIds();
				categoryproductNamesStr = mlbackCategoryRes.getCategoryProductNames();
				//把productId,填充再每个查回来的categort中的proidStr拼上
				if(categoryProductIdsStr==null||categoryProductIdsStr.length()==0){
					//如果当前没有,属于第一次填充，直接替代就好
					categoryProductIdsStr =inproductIdStr;
					categoryproductNamesStr=productName;
				}else{
					//如果产品类下已经有数据
					//先判断是否包含本次
					int ifHave = categoryProductIdsStr.indexOf(inproductIdStr);
					if(ifHave!=-1){
						//只要test.indexOf('This')返回的值不是-1说明test字符串中包含字符串'This',相反如果包含返回的值必定是-1"
						//如果包含，跳过
						continue;
					}else{
						//如果不包含，拼接
						categoryProductIdsStr = categoryProductIdsStr +","+ inproductIdStr;
						categoryproductNamesStr = categoryproductNamesStr+","+productName;
					}
				}
				//操作完，执行更新
				mlbackCategoryReqUpdate.setCategoryId(categoryIdInt);
				mlbackCategoryReqUpdate.setCategoryProductIds(categoryProductIdsStr);
				mlbackCategoryReqUpdate.setCategoryProductNames(categoryproductNamesStr);
				mlbackCategoryService.updateByPrimaryKeySelective(mlbackCategoryReqUpdate);
			}
		}
	}

	
	//清理每条的新产品信息
	private void ProductCategoryIdsStrUpdateOld(Integer productId,String categoryIdsStrNew) {
		// TODO Auto-generated method stub
		MlbackProduct mlbackProductReq = new MlbackProduct();
		MlbackProduct mlbackProductRes = new MlbackProduct();
		mlbackProductReq.setProductId(productId);
		List<MlbackProduct> mlbackProductListOld =  mlbackProductService.selectMlbackProduct(mlbackProductReq);
		mlbackProductRes = mlbackProductListOld.get(0);
		String productCategoryIdsStr = mlbackProductRes.getProductCategoryIdsStr();
		MlbackCategory mlbackCategoryReq = new MlbackCategory();
		MlbackCategory mlbackCategoryRes = new MlbackCategory();
		List<MlbackCategory> MlbackCategoryList = new ArrayList<MlbackCategory>();
		if(productCategoryIdsStr==null||productCategoryIdsStr.length()==0){
			//没有被类管理绑定过
			System.out.println("产品的这个字段下,没有被类管理绑定过,不需要进行移除操作");
		}else{
			//被类管理绑定过
			String productCategoryIdsStrArr [] =  productCategoryIdsStr.split(",");
			for(int i=0;i<productCategoryIdsStrArr.length;i++){
				//遍历categoryIdsStr
				String  categoryIdsStr = productCategoryIdsStrArr[i];
				Integer categoryIdsInt = Integer.parseInt(categoryIdsStr);
				mlbackCategoryReq.setCategoryId(categoryIdsInt);
				MlbackCategoryList = mlbackCategoryService.selectMlbackCategory(mlbackCategoryReq);
				mlbackCategoryRes = MlbackCategoryList.get(0);
				
				//从该中取的老的产品串串
				String categoryProductIds = "";
				String categoryProductNames = "";
				categoryProductIds = mlbackCategoryRes.getCategoryProductIds();
				categoryProductNames = mlbackCategoryRes.getCategoryProductNames();
				
				String categoryProductIdsArr [] = categoryProductIds.split(",");
				String categoryProductNamesArr [] = categoryProductNames.split(",");
				
				List<String> categoryProductIdsStrNewList = new ArrayList<String>();
				List<String> categoryProductNamesStrNewList = new ArrayList<String>();
				
				String categoryProductIdsStrNew="";
				String categoryProductNamesStrNew="";
				//对来的产品串进行遍历
				String productIdnow = productId+"";
				//该类的产品串进行
				for(int j =0;j<categoryProductIdsArr.length;j++){
					//
					String productOldIdOneStr = categoryProductIdsArr[j];
					String productOldNamesStr = categoryProductNamesArr[j];
					
					if(productOldIdOneStr.equals(productIdnow)){
						System.out.println("一致就不存了");
					}else{
						//移除本个后的该类下全部产品
						categoryProductIdsStrNewList.add(productOldIdOneStr);
						categoryProductIdsStrNew+=productOldIdOneStr+",";
						
						categoryProductNamesStrNewList.add(productOldNamesStr);
						categoryProductNamesStrNew+=productOldNamesStr+",";
					}
				}
				//判断是不是空了，空了的话，不移除最后一个字符","
				if(categoryProductIdsStrNew.length()>0){
					categoryProductIdsStrNew=categoryProductIdsStrNew.substring(0,categoryProductIdsStrNew.length()-1);
					categoryProductNamesStrNew=categoryProductNamesStrNew.substring(0,categoryProductNamesStrNew.length()-1);
				}
				//封装参数			
				MlbackCategory mlbackCategoryRemoveOld = new MlbackCategory();
				mlbackCategoryRemoveOld.setCategoryId(categoryIdsInt);
				mlbackCategoryRemoveOld.setCategoryProductIds(categoryProductIdsStrNew);
				mlbackCategoryRemoveOld.setCategoryProductNames(categoryProductNamesStrNew);
				//执行更新
				mlbackCategoryService.updateByPrimaryKeySelective(mlbackCategoryRemoveOld);
			}
		}
	}

	/**4.0	UseNow	0505
	 * MlbackProduct	delete
	 * @param id
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(@RequestBody MlbackProduct mlbackProduct){
		//接收id信息
		Integer productIdInt = mlbackProduct.getProductId();
		int intResult = mlbackProductService.deleteByPrimaryKey(productIdInt);
		System.out.println(intResult);
		return Msg.success().add("resMsg", "delete success");
	}
	
	
	/**
	 * 5.0	UseNow	0505
	 * 查看单个产品的详情
	 * @param productId
	 * @return 
	 */
	@RequestMapping(value="/getOneMlbackProductDetail",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneMlbackProductDetail(@RequestParam(value = "productId") Integer productId){
		//接受信息
		MlbackProduct mlbackProductReq = new MlbackProduct();
		mlbackProductReq.setProductId(productId);
		List<MlbackProduct> mlbackProductResList =mlbackProductService.selectMlbackProduct(mlbackProductReq);
		MlbackProduct mlbackProductOne =mlbackProductResList.get(0);
		return Msg.success().add("resMsg", "查看单个类目的详情细节完毕")
					.add("mlbackProductOne", mlbackProductOne);
	}
	
	/**
	 * 6.0	UseNow	0505
	 * 通过产品名查看单条产品的详情
	 * @param productId
	 * @return 
	 */
	@RequestMapping(value="/getOneMlbackProductDetailByPName",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneMlbackProductDetailByPName(@RequestParam(value = "productName") String productName){
		//接受信息
		MlbackProduct mlbackProductReq = new MlbackProduct();
		mlbackProductReq.setProductName(productName);
		List<MlbackProduct> mlbackProductResList =mlbackProductService.selectMlbackProductByPName(mlbackProductReq);
		MlbackProduct mlbackProductOne = new MlbackProduct();
		if(mlbackProductResList.size()>0){
			mlbackProductOne =mlbackProductResList.get(0);
		}
		return Msg.success().add("resMsg", "查看单条类目的详情细节完毕")
					.add("mlbackProductOne", mlbackProductOne);
	}
	
	/**
	 * 7.0	useOn	0505
	 * 推荐//热销//爆款
	 * @param MlbackProduct
	 * @return 
	 */
	@RequestMapping(value="/getMlbackProductLableList",method=RequestMethod.POST)
	@ResponseBody
	public Msg getMlbackProductLableList(@RequestParam(value = "productLable") Integer productLable){
		
		//接受信息
		MlbackProduct mlbackProductReq = new MlbackProduct();
		mlbackProductReq.setProductLable(productLable);
		//mlbackProductReq.setProductStatus(productStatus);
		List<MlbackProduct> mlbackProductResList  = new ArrayList<MlbackProduct>();
		List<MlbackProduct> mlbackProductResLimitList =mlbackProductService.selectMlbackProductByLable(mlbackProductReq);
		if(mlbackProductResLimitList.size()>19){
			for(int i=0;i<20;i++){
				mlbackProductResList.add(mlbackProductResLimitList.get(i));
			}
		}else{
			mlbackProductResList = mlbackProductResLimitList;
		}
		return Msg.success().add("resMsg", "查看单条类目的详情细节完毕")
					.add("mlbackProductResList", mlbackProductResList);
	}
	
	/**
	 * 8.0	UseNow	0505
	 * 通过，类id查询，该类下的全部产品
	 * @param MlbackProduct
	 * @return 
	 */
	@RequestMapping(value="/getMlbackProductByparentCategoryIdList",method=RequestMethod.POST)
	@ResponseBody
	public Msg getMlbackProductByparentCategoryIdList(HttpServletResponse rep,HttpServletRequest res,@RequestBody MlbackProduct mlbackProduct){
		
		Integer productCategoryid = mlbackProduct.getProductCategoryid();
		//接受信息
		MlbackProduct mlbackProductReq = new MlbackProduct();
		mlbackProductReq.setProductCategoryid(productCategoryid);
		List<MlbackProduct> mlbackProductResList =mlbackProductService.selectMlbackProductByProductCategoryid(mlbackProductReq);
		return Msg.success().add("resMsg", "查看该母category下的全部产品")
					.add("mlbackProductResList", mlbackProductResList);
	}
	
	
	/**
	 * 8.1	UseNow	0505
	 * 通过，类id查询，该类下的全部产品
	 * @param MlbackProduct
	 * @return 
	 */
	@RequestMapping(value="/getMlbackProductByparentCategoryIdListNew",method=RequestMethod.POST)
	@ResponseBody
	public Msg getMlbackProductByparentCategoryIdListNew(HttpServletResponse rep,HttpServletRequest res,@RequestBody MlbackProduct mlbackProduct){
		
		Integer categoryid = mlbackProduct.getProductCategoryid();
		
		MlbackCategory mlbackCategory = new MlbackCategory();
		
		MlbackCategory mlbackCategoryOne = new MlbackCategory();
		
		mlbackCategory.setCategoryId(categoryid);
		
	 	List<MlbackCategory> mlbackCategoryList = mlbackCategoryService.selectMlbackCategory(mlbackCategory);
	 	
	 	mlbackCategoryOne = mlbackCategoryList.get(0);
	 	
	 	String categoryProductIds = mlbackCategoryOne.getCategoryProductIds();
	 	
	 	
	 	List<MlbackProduct> mlbackProductResList = new ArrayList<MlbackProduct>();
	 	
	 	if(categoryProductIds==null||categoryProductIds.length()==0){
	 		System.out.println("mlbackProductResList的长度："+mlbackProductResList.size());
	 	}else{
	 		String categoryProductIdsArr [] = categoryProductIds.split(",");
	 		//遍历查询product产品
	 		String proIdStr = "";
	 		Integer proIdInt = 0;
	 		
	 		MlbackProduct mlbackProductReq = new MlbackProduct();
	 		MlbackProduct mlbackProductResOne = new MlbackProduct();
	 		List<MlbackProduct> mlbackProductList = new ArrayList<MlbackProduct>();
	 		for(int i=0;i<categoryProductIdsArr.length;i++){
	 			proIdStr = categoryProductIdsArr[i];
	 			proIdInt = Integer.parseInt(proIdStr);
	 		 	mlbackProductReq.setProductId(proIdInt);
	 		 	mlbackProductList = mlbackProductService.selectMlbackProduct(mlbackProductReq);
	 		 	if(mlbackProductList.size()>0){
	 		 		mlbackProductResOne = mlbackProductList.get(0);
	 		 		mlbackProductResList.add(mlbackProductResOne);
	 		 	}
	 		}
	 	}
		return Msg.success().add("resMsg", "查看该母category下的全部产品")
					.add("mlbackProductResList", mlbackProductResList);
	}
	
	/**
	 * 9.0	UseNow	0527
	 * 通过，类id,productColor,查询满足条件的全部产品
	 * @param productCategoryid,productColor
	 * @return 
	 */
	@RequestMapping(value="/getMlbackProductByproductColorAndCategoryIdList",method=RequestMethod.POST)
	@ResponseBody
	public Msg getMlbackProductByproductColorList(HttpServletResponse rep,HttpServletRequest res,@RequestBody MlbackProduct mlbackProduct){
		
		Integer productCategoryid = mlbackProduct.getProductCategoryid();
		
		String productColor = mlbackProduct.getProductColor();
		
		MlbackProduct mlbackProductReq = new MlbackProduct();
		//接受信息
		List<MlbackProduct> mlbackProductResList = new ArrayList<MlbackProduct>();
		if(productCategoryid>0){
			mlbackProductReq.setProductCategoryid(productCategoryid);
			if(productColor!=null) {
				System.out.println(productColor.length());
				if(productColor.length()>0){
					mlbackProductReq.setProductColor(productColor);
				}
			}
			mlbackProductResList =mlbackProductService.selectMlbackProductByProductCategoryid(mlbackProductReq);
			return Msg.success().add("resMsg", "查看该母category下的全部产品")
					.add("mlbackProductResList", mlbackProductResList);
		}else{
			return Msg.success().add("resMsg", "查看该母category下的没有产品")
					.add("mlbackProductResList", mlbackProductResList);
		}
	} 
	
	/**
	 * 9.0	UseNow	0527
	 * 通过，类id,productColor,查询满足条件的全部产品
	 * @param productCategoryid,productColor
	 * @return 
	 */
	@RequestMapping(value="/getMlbackProductAllList",method=RequestMethod.GET)
	@ResponseBody
	public Msg getMlbackProductAllList(HttpServletResponse rep,HttpServletRequest res){
		
		MlbackProduct mlbackProductReq = new MlbackProduct();
		
		mlbackProductReq.setProductStatus(1);//'已上架' : '未上架'
		//接受信息
		List<MlbackProduct> mlbackProductResList = new ArrayList<MlbackProduct>();
		
		mlbackProductResList =mlbackProductService.selectMlbackProductByStatus(mlbackProductReq);
		return Msg.success().add("resMsg", "查看上架状态的下的全部产品")
					.add("mlbackProductResList", mlbackProductResList);
		
	} 
	
	
	/**7.0
	 * @author Shinelon
	 * @exception 导出单一发布任务执行明细
	 * @param MlbackCategory
	 * @return 
	 * */
//	@ResponseBody
//	@RequestMapping("/exportFile")
//	public String exportFile(HttpServletRequest request,HttpServletResponse response) throws IOException {
//		response.reset(); 
//		// 接收请求相应
//	    //准备请求头参数
//		String authstatus =request.getParameter("authStatus");
//		String userworkGroupdisplayId =request.getParameter("userworkGroupdisplayId");
//		int authStatus =Integer.parseInt(authstatus);
//		int userworkGroupdisplayIdId =Integer.parseInt(userworkGroupdisplayId);
//		Date date =new Date();
//		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
//		String time =sdf.format(date);
//		response.setHeader("Content-Disposition", "attachment;filename=File" + time +".xlsx");
//		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
//		response.setHeader("Pragma", "no-cache");
//		response.setHeader("Cache-Control", "no-cache");
//		response.setDateHeader("Expires", 0);
//	    XSSFWorkbook workbook = null;
//	    try {
//	    	UserWork userWork= new UserWork();
//	    	userWork.setUserworkGroupdisplayId(userworkGroupdisplayIdId);
//	    	if(authStatus==1) {	    		
//	    		List<UserWork> UserWorkList = userWorkService.getUserWorkByConditions(userWork);
//	            workbook = ExcelUtils.exportContactsGroupDisplay(UserWorkList);
//	        }
//	        OutputStream output;
//	        try {
//	        	output = response.getOutputStream();
//	            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
//	            bufferedOutPut.flush();
//	            workbook.write(bufferedOutPut);
//	            bufferedOutPut.close();
//	            } catch (Exception e) {
//	                e.printStackTrace();
//	            }
//	        } catch (Exception e1) {
//	            e1.printStackTrace();
//	        }
//	        return null;
//	}
	
	/**1.1	useOn
	 * 远程调用url,name,pimageUrl
	 * @return Map
	 */
//	private Map<String, String> HttpGetPImgUrl(String id) {
//		HttpUtil httpUtil = new HttpUtil();
//		String urls="https://itunes.apple.com/cn/lookup";
//		String idParm = "id="+id;
//		String result = null;
//		Map<String, String> iosNeedMap= new HashMap<String, String>();
//		try {
//			result = httpUtil.sendPostUrl(urls,idParm,"utf-8");
//			JSONObject JSONObject = new JSONObject(result);
//			String resStr = JSONObject.get("results").toString();
//			String resStr2 =resStr.substring(1, resStr.length()-1);
//			System.out.println(resStr2);
//			JSONObject JSONObjectStr2 = new JSONObject(resStr2);
//			iosNeedMap.put("artworkUrl100", (String) JSONObjectStr2.get("artworkUrl100"));
////			iosNeedMap.put("trackName", (String) JSONObjectStr2.get("trackName"));
//			iosNeedMap.put("bundleId", (String) JSONObjectStr2.get("bundleId"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return iosNeedMap;
//	}
	
}