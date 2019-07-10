package com.atguigu.testBean;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.bean.SysUser;
import com.atguigu.dao.SysUserMapper;

/**
 * 测试dao层的工作
 * @author lfy
 *推荐Spring的项目就可以使用Spring的单元测试，
 *1、导入SpringTest模块
 *2、@ContextConfiguration指定Spring配置文件的位
 *3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class SysUserTest {
	
	@Autowired
	SysUserMapper sysUserMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCRUD(){
		
//		生成员工数据，测试员工插入insert接口
		sysUserMapper.insertSelective(new SysUser(null,"admin3","admin123456"));
		
		
//		生成员工数据，测试员工查询select接口		
//		SysUser sysUser = new SysUser();
//		sysUser.setUserName("admin");
//		sysUser.setUserPwd("admin123456");
//		
//		List<SysUser>  SysUserList = sysUserMapper.selectSysUser(sysUser);
//		System.out.println(SysUserList);
		
		System.out.println("批量完成");
		
	}

}
