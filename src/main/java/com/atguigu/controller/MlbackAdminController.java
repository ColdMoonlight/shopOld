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

import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.Msg;
import com.atguigu.bean.SysUser;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.SysUserService;
import com.atguigu.utils.ExcelUtils;


@Controller
@RequestMapping("/MlbackAdmin")
public class MlbackAdminController {
	
	@Autowired
	MlbackAdminService mlbackAdminService;
	
	
	@RequestMapping("/toindex")
	public String toindex() throws Exception{
		System.out.println("进入toindex");
		System.out.println("toindex");
	
		return "back/toMlbackAdminLogin";
	}
	
	/**
	 * 帐号注销
	 * */
	@RequestMapping("/exitIndex")
	public String exitindex(HttpSession session) throws Exception{
		session.removeAttribute("AdminUser");
		session.invalidate();
		return "sysLogin";
	}
	
	/**
	 * 登陆֤
	 * */
	@RequestMapping(value="/toCheakAdminUser",method=RequestMethod.POST)
	@ResponseBody
	public Msg checkuser(HttpServletResponse rep,HttpServletRequest res,HttpSession session,
			@RequestBody MlbackAdmin MlbackAdminReq){
		//接收参数信息 
		MlbackAdmin mlbackAdminGet = new MlbackAdmin();
		mlbackAdminGet.setAdminAccname(MlbackAdminReq.getAdminAccname());
		List<MlbackAdmin> mlbackAdminGetresList = mlbackAdminService.selectMlbackAdmin(mlbackAdminGet);
		if(!(mlbackAdminGetresList.size()>0)){
			return Msg.fail().add("resMsg", "账号不存在");
			//return Msg.fail().add("resMsg", "000000000000");
		}
		mlbackAdminGet.setAdminPassword(MlbackAdminReq.getAdminPassword());
		List<MlbackAdmin> MlbackAdminListNameAndPwd = mlbackAdminService.selectMlbackAdmin(mlbackAdminGet);
		if(MlbackAdminListNameAndPwd.size()>0){
			//将登陆状态放入session对象
			session.setAttribute("AdminUser", mlbackAdminGet);
			return Msg.success().add("resMsg", "登陆成功");
			//return Msg.success().add("resMsg", "111111111");
		}else{
			return Msg.fail().add("resMsg", "密码错误登录失败");
			//return Msg.fail().add("resMsg", "22222222222");
		}
	}
	
}
