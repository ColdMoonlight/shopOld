package com.atguigu.controller;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.Msg;
import com.atguigu.bean.SysUser;
import com.atguigu.service.SysUserService;
import com.atguigu.utils.ExcelUtils;


@Controller
@RequestMapping("/SysUser")
public class SysUserController {
	
	@Autowired
	SysUserService sysUserService;
	
	
	@RequestMapping("/toSysLogin")
	public String tologin() throws Exception{
		System.out.println("进入toLogin");
	
		return "sysLogin";
	}
	
	
	/**
	 * 帐号注销
	 * */
	@RequestMapping("/exitIndex")
	public String exitindex(HttpSession session) throws Exception{
		session.removeAttribute("user");
		session.invalidate();
		return "sysLogin";
	}
	
	/**
	 * 登陆֤
	 * */
	@RequestMapping(value="/toCheakUser",method=RequestMethod.POST)
	@ResponseBody
	public Msg checkuser(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody SysUser SysUser){
		//接收参数信息
		SysUser sysUserGet = new SysUser();
		sysUserGet.setUserName(SysUser.getUserName());
		List<SysUser> SysUserListName = sysUserService.selectSysUser(sysUserGet);
		if(!(SysUserListName.size()>0)){
			//return Msg.fail().add("resMsg", "账号不存在");
			return Msg.fail().add("resMsg", "000000000000");
		}
		sysUserGet.setUserPwd(SysUser.getUserPwd());
		List<SysUser> SysUserListNameAndPwd = sysUserService.selectSysUser(sysUserGet);
		if(SysUserListNameAndPwd.size()>0){
			//将登陆状态放入session对象
			session.setAttribute("user", SysUser);
			//return Msg.success().add("resMsg", "登陆成功");
			return Msg.success().add("resMsg", "111111111");
		}else{
			//return Msg.fail().add("resMsg", "登录失败");
			return Msg.fail().add("resMsg", "22222222222");
		}
	}
	
	
//	/**
//	 * @author Shinelon
//	 * @exception ����excle�ļ�
//	 * 
//	 * */
//	@ResponseBody
//	@RequestMapping("/exportFile")
//	public String exportFile(HttpServletRequest request,HttpServletResponse response) throws IOException {
//		response.reset(); // ���buffer����
//	    // ָ�����ص��ļ���
//		String authstatus =request.getParameter("authStatus");
//		int authStatus =Integer.parseInt(authstatus);
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
//	    	if(authStatus==1) {
//	        //��ѯ����֤�û���Ϣ
//	        List<SysUser> list=sysUserService.selectSysUserGetAll();
//	            workbook = ExcelUtils.exportContacts(list);
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
}
