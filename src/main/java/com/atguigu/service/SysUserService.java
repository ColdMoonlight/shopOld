package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.SysUser;
import com.atguigu.dao.SysUserMapper;


@Service
public class SysUserService {
	
	
	@Autowired
	SysUserMapper sysUserMapper;

	/**
	 * @author Shinelon
	 * @param SysUser
	 * @exception 查看用户信息是否存在
	 * 
	 * */
	public List<SysUser> selectSysUser(SysUser sysUser) {
		List<SysUser>  SysUserList = sysUserMapper.selectSysUser(sysUser);
		return SysUserList;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查看全部用户信息
	 * 
	 * */
	public List<SysUser> selectSysUserGetAll() {
		List<SysUser>  SysUserList = sysUserMapper.selectSysUserGetAll();
		return SysUserList;
	}

}
