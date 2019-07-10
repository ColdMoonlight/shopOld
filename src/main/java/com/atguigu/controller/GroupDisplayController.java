package com.atguigu.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.Msg;
import com.atguigu.bean.SysUser;
import com.atguigu.bean.UserWork;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.GroupDisplayService;
import com.atguigu.service.SysUserService;
import com.atguigu.service.UserWorkService;
import com.atguigu.utils.DateUtil;
import com.atguigu.utils.ExcelUtils;
import com.atguigu.utils.HttpUtil;


@Controller
@RequestMapping("/groupDisplay")
public class GroupDisplayController {
	
	
	
	@Autowired
	GroupDisplayService groupDisplayService;
	
	@Autowired
	SysUserService sysUserService;
	
	@Autowired
	UserWorkService userWorkService;
	
	/**
	 * 1.0	useOn
	 * to任务发布页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toGroupDisplayPage")
	public String tologin() throws Exception{
	
		return "groupDisplay";
	}
	
	
	/**2.0	useOn
	 * 任务发布分页的页面
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getGroupDisplayByPage")
	@ResponseBody
	public Msg getGroupDisplayWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn
			,HttpSession session) {
		SysUser SysUser =(SysUser) session.getAttribute("user");
		if(SysUser==null){
			//SysUsers对象为空
			return Msg.fail().add("resMsg", "session中ysUsers对象为空");
		}else{
			int PagNum = 10;
			PageHelper.startPage(pn, PagNum);
			List<GroupDisplay> groupDisplay = groupDisplayService.getGroupDisplayAll();
			PageInfo page = new PageInfo(groupDisplay, PagNum);
			return Msg.success().add("pageInfo", page);
		}
	}
	
	/**1.0	useOn
	 * GroupDisplay	insert
	 * @param GroupDisplay
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@ResponseBody
	public Msg insertSelective(GroupDisplay groupDisplay){
		//接受参数信息
		System.out.println("groupDisplay:"+groupDisplay);
		System.out.println("00000000000:"+groupDisplay.getGroupAppIdTh());
		String nowTime = DateUtil.strTime14s();
		groupDisplay.setGroupCreatetime(nowTime);
		groupDisplay.setGroupUpdatetime(nowTime);
		groupDisplay.setGroupStarttime(nowTime);
		groupDisplay.setGroupNownum(groupDisplay.getGroupAllnum());
		groupDisplay.setGroupState(0);//0仅发布(未上架) 0仅发布	1上架	0完成	2下架
		
		Map<String, String> resMap= new HashMap<String, String>();
		resMap = HttpGetPImgUrl(groupDisplay.getGroupAppstoreid());
		String groupPimageurlHTTPReturn = resMap.get("artworkUrl100");
//		String groupTaskNameHTTPReturn = resMap.get("trackName");
		String stringbundleId = resMap.get("bundleId");
//		if(groupTaskNameHTTPReturn.length()>4){
//			groupTaskNameHTTPReturn = groupTaskNameHTTPReturn.substring(0, 4);
//		}
		groupDisplay.setGroupPimageurl(groupPimageurlHTTPReturn);
//		groupDisplay.setGroupTaskName(groupTaskNameHTTPReturn);
		groupDisplay.setGroupBundleId(stringbundleId);
		
		int intResult =groupDisplayService.insertSelective(groupDisplay);
		System.out.println(intResult);
		return Msg.success().add("resMsg", "插入成功");
	}
	
	/**1.1	useOn
	 * 远程调用url,name,pimageUrl
	 * @return Map
	 */
	private Map<String, String> HttpGetPImgUrl(String id) {
		HttpUtil httpUtil = new HttpUtil();
		String urls="https://itunes.apple.com/cn/lookup";
		String idParm = "id="+id;
		String result = null;
		Map<String, String> iosNeedMap= new HashMap<String, String>();
		try {
			result = httpUtil.sendPostUrl(urls,idParm,"utf-8");
			JSONObject JSONObject = new JSONObject(result);
			String resStr = JSONObject.get("results").toString();
			String resStr2 =resStr.substring(1, resStr.length()-1);
			System.out.println(resStr2);
			JSONObject JSONObjectStr2 = new JSONObject(resStr2);
			iosNeedMap.put("artworkUrl100", (String) JSONObjectStr2.get("artworkUrl100"));
//			iosNeedMap.put("trackName", (String) JSONObjectStr2.get("trackName"));
			iosNeedMap.put("bundleId", (String) JSONObjectStr2.get("bundleId"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iosNeedMap;
	}

	/**2.0	useOn
	 * groupDisplay	delete
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(GroupDisplay groupDisplay){
		//接收id信息
		int groupIdInt = groupDisplay.getGroupId();
		int intResult = groupDisplayService.deleteByPrimaryKey(groupIdInt);
		System.out.println(intResult);
		return Msg.success().add("resMsg", "delete");
	}
	
	/** 3.0
	 * GroupDisplay	update
	 * @param id GroupDisplay
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public Msg update(GroupDisplay groupDisplay){
		//接受信息
		String nowtime = DateUtil.strTime14s();
		groupDisplay.setGroupUpdatetime(nowtime);
		groupDisplay.setGroupNownum(groupDisplay.getGroupAllnum());
		//获取HttpURl信息
		Map<String, String> resMap= new HashMap<String, String>();
		resMap = HttpGetPImgUrl(groupDisplay.getGroupAppstoreid());
		String groupPimageurlHTTPReturn = resMap.get("artworkUrl100");
//		String groupTaskNameHTTPReturn = resMap.get("trackName");
		String stringbundleId = resMap.get("bundleId");
//		if(groupTaskNameHTTPReturn.length()>4){
//			groupTaskNameHTTPReturn = groupTaskNameHTTPReturn.substring(0, 4);
//		}
		groupDisplay.setGroupPimageurl(groupPimageurlHTTPReturn);
//		groupDisplay.setGroupTaskName(groupTaskNameHTTPReturn);
		groupDisplay.setGroupBundleId(stringbundleId);
		//更新本条状态
		int intResult = groupDisplayService.updateByPrimaryKeySelective(groupDisplay);
		System.out.println(intResult);
		return Msg.success().add("resMsg", "更新成功");
	}
	
	/** 3.1
	 * 手机端可见任务(appLook)
	 * @param id GroupDisplay
	 * @return
	 */
	@RequestMapping(value="/appLook",method=RequestMethod.POST)
	@ResponseBody
	public Msg appLook(GroupDisplay groupDisplay){
		//接受信息
		String nowtime = DateUtil.strTime14s();
		groupDisplay.setGroupUpdatetime(nowtime);
		groupDisplay.setGroupState(1);//0仅发布(未上架) 0仅发布	1上架	0完成	2下架
		//更新成发布状态
		int intResult = groupDisplayService.updateByPrimaryKeySelective(groupDisplay);
		System.out.println(intResult);
		return Msg.success().add("resMsg", "app上架成功");
	}
	
	/** 3.2
	 * 手机端不可见任务(appLookNo)
	 * @param id GroupDisplay
	 * @return
	 */
	@RequestMapping(value="/appLookNo",method=RequestMethod.POST)
	@ResponseBody
	public Msg appLookNo(GroupDisplay groupDisplay){
		//接受信息
		String nowtime = DateUtil.strTime14s();
		groupDisplay.setGroupUpdatetime(nowtime);
		groupDisplay.setGroupState(2);//0仅发布(未上架) 0仅发布	1上架	0完成	2下架
		//更新成下架状态
		int intResult = groupDisplayService.updateByPrimaryKeySelective(groupDisplay);
		System.out.println(intResult);
		return Msg.success().add("resMsg", "app下架");
	}
	
	/** 3.3
	 * 查看信息完成(appLookEnd)
	 * @param id GroupDisplay
	 * @return
	 */
	@RequestMapping(value="/appLookEnd",method=RequestMethod.POST)
	@ResponseBody
	public Msg appLookEnd(GroupDisplay groupDisplay){
		//接受信息
		String nowtime = DateUtil.strTime14s();
		groupDisplay.setGroupUpdatetime(nowtime);
		groupDisplay.setGroupState(3);//0仅发布(未上架) 0仅发布	1上架	2下架	3任务完成
		//更新成完成状态
		int intResult = groupDisplayService.updateByPrimaryKeySelective(groupDisplay);
		System.out.println(intResult);
		return Msg.success().add("resMsg", "app任务结束");
	}
	
	/**
	 * 4.0	useOn
	 * 查看单条任务的详情细节
	 * @param GroupDisplay
	 * @return 
	 */
	@RequestMapping(value="/getOneGroupDisplayDetail",method=RequestMethod.POST)
	@ResponseBody
//	public Msg getOneDetail(GroupDisplay groupDisplay){
	public Msg getOneGroupDisplayDetail(@RequestParam(value = "groupId") Integer groupId){
		
		//接受信息
		GroupDisplay groupDisplayReq = new GroupDisplay();
		groupDisplayReq.setGroupId(groupId);
		List<GroupDisplay> groupDisplayResList =groupDisplayService.getGroupDisplayByConditions(groupDisplayReq);
		GroupDisplay groupDisplayOne =groupDisplayResList.get(0);
		return Msg.success().add("resMsg", "查询文件本条信息完毕")
					.add("groupDisplayOne", groupDisplayOne);
	}
	
	/**
	 * @author Shinelon
	 * @exception 导出单一发布任务执行明细
	 * @param GroupDisplay
	 * @return 
	 * */
	@ResponseBody
	@RequestMapping("/exportFile")
	public String exportFile(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.reset(); 
		// 接收请求相应
	    //准备请求头参数
		String authstatus =request.getParameter("authStatus");
		String userworkGroupdisplayId =request.getParameter("userworkGroupdisplayId");
		int authStatus =Integer.parseInt(authstatus);
		int userworkGroupdisplayIdId =Integer.parseInt(userworkGroupdisplayId);
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
		String time =sdf.format(date);
		response.setHeader("Content-Disposition", "attachment;filename=File" + time +".xlsx");
		response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
	    XSSFWorkbook workbook = null;
	    try {
	    	UserWork userWork= new UserWork();
	    	userWork.setUserworkGroupdisplayId(userworkGroupdisplayIdId);
	    	if(authStatus==1) {	    		
	    		List<UserWork> UserWorkList = userWorkService.getUserWorkByConditions(userWork);
	            workbook = ExcelUtils.exportContactsGroupDisplay(UserWorkList);
	        }
	        OutputStream output;
	        try {
	        	output = response.getOutputStream();
	            BufferedOutputStream bufferedOutPut = new BufferedOutputStream(output);
	            bufferedOutPut.flush();
	            workbook.write(bufferedOutPut);
	            bufferedOutPut.close();
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        } catch (Exception e1) {
	            e1.printStackTrace();
	        }
	        return null;
	}
	
	
}
