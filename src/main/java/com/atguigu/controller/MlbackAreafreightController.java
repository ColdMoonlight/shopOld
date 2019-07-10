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
import com.atguigu.bean.MlbackAreafreight;
import com.atguigu.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackAreafreightService;
import com.atguigu.utils.DateUtil;


@Controller
@RequestMapping("/MlbackAreafreight")
public class MlbackAreafreightController {
		
	@Autowired
	MlbackAreafreightService mlbackAreafreightService;
	
	@Autowired
	MlbackAdminService mlbackAdminService;
	
	/**
	 * 1.0	useOn	0505
	 * to分类MlbackCategory列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackAreafreightPage")
	public String toMlbackAreafreightPage() throws Exception{
	
		return "back/mlbackAreafreightPage";
	}
	
	
	/**2.0	useOn	0505
	 * 分类MlbackCategory列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getMlbackAreafreightByPage")
	@ResponseBody
	public Msg getMlbackAreafreightWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn
			,HttpSession session) {
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
		int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlbackAreafreight> mlbackAreafreightList = mlbackAreafreightService.selectMlbackAreafreightAll();
			PageInfo page = new PageInfo(mlbackAreafreightList, PagNum);
			return Msg.success().add("pageInfo", page);
//		}
	}
	
	/**3.0	useOn	0505
	 * MlbackAreafreight	insert
	 * @param MlbackAreafreight
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveSelective(HttpServletResponse rep,HttpServletRequest res,@RequestBody MlbackAreafreight mlbackAreafreight){
		//接受参数信息
		System.out.println("mlbackAreafreight:"+mlbackAreafreight);
		//取出id
		System.out.println(1);
		Integer areafreightId = mlbackAreafreight.getAreafreightId();
		String nowTime = DateUtil.strTime14s();
		mlbackAreafreight.setAreafreightMotifytime(nowTime);
		if(areafreightId==null){
			//无id，insert
			mlbackAreafreight.setAreafreightCreatetime(nowTime);
			int intResult = mlbackAreafreightService.insertSelective(mlbackAreafreight);
			System.out.println(intResult);
			return Msg.success().add("resMsg", "插入成功");
		}else{
			//有id，update
			int intResult = mlbackAreafreightService.updateByPrimaryKeySelective(mlbackAreafreight);
			System.out.println(intResult);
			return Msg.success().add("resMsg", "更新成功");
			
		}		
	}
	
	/**4.0	useOn	0505
	 * MlbackAreafreight	delete
	 * @param id
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(@RequestBody MlbackAreafreight mlbackAreafreight){
		//接收id信息
		int areafreightIdInt = mlbackAreafreight.getAreafreightId();
		int intResult = mlbackAreafreightService.deleteByPrimaryKey(areafreightIdInt);
		return Msg.success().add("resMsg", "delete success");
	}
	
	
	/**
	 * 5.0	useOn	0505
	 * 查看单条类目的详情细节
	 * @param MlbackAreafreight
	 * @return 
	 */
	@RequestMapping(value="/getOneMlbackAreafreightDetail",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneMlbackAreafreightDetail(@RequestParam(value = "areafreightId") Integer areafreightId){
		
		//接受categoryId
		MlbackAreafreight mlbackAreafreightReq = new MlbackAreafreight();
		mlbackAreafreightReq.setAreafreightId(areafreightId);
		//查询本条
		List<MlbackAreafreight> mlbackAreafreightResList =mlbackAreafreightService.selectMlbackAreafreightById(mlbackAreafreightReq);
		MlbackAreafreight mlbackAreafreightOne = new MlbackAreafreight();
		if(mlbackAreafreightResList.size()>0){
			mlbackAreafreightOne =mlbackAreafreightResList.get(0);
		}else{
			mlbackAreafreightOne = null;
		}
		return Msg.success().add("resMsg", "查看单条mlbackAreafreight的详情细节完毕")
					.add("mlbackAreafreightOne", mlbackAreafreightOne);
	}
	
	/**
	 * 6.0	useOn	0505
	 * 查看单条类目的详情细节
	 * @param MlbackAreafreight
	 * @return 
	 */
	@RequestMapping(value="/getOneMlbackAreafreightDetailByAreafreightEng",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneMlbackAreafreightDetailByAreafreightEng(@RequestParam(value = "areafreightCountryEnglish") String areafreightCountryEnglish){
		
		//接受categoryId
		MlbackAreafreight mlbackAreafreightReq = new MlbackAreafreight();
		mlbackAreafreightReq.setAreafreightCountryEnglish(areafreightCountryEnglish);
		//查询本条
		List<MlbackAreafreight> mlbackAreafreightResList =mlbackAreafreightService.selectMlbackAreafreightByEng(mlbackAreafreightReq);
		MlbackAreafreight mlbackAreafreightOne = new MlbackAreafreight();
		if(mlbackAreafreightResList.size()>0){
			mlbackAreafreightOne =mlbackAreafreightResList.get(0);
		}else{
			mlbackAreafreightOne = null;
		}
		return Msg.success().add("resMsg", "查看单条mlbackAreafreight的详情细节完毕")
					.add("mlbackAreafreightOne", mlbackAreafreightOne);
	}
	
	/**7.0
	 * @author Shinelon
	 * @exception 导出单一发布任务执行明细
	 * @param MlbackAreafreight
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
