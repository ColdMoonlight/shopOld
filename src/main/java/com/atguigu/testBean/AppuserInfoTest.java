package com.atguigu.testBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.bean.AppuserInfo;
import com.atguigu.bean.GroupDisplay;
import com.atguigu.dao.AppuserInfoMapper;
import com.atguigu.dao.GroupDisplayMapper;
import com.atguigu.utils.DateUtil;
import com.atguigu.utils.UUIDUtils;

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
public class AppuserInfoTest {
	
	@Autowired
	GroupDisplayMapper groupDisplayMapper;
	
	
	@Autowired
	AppuserInfoMapper appuserInfoMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * groupDisplayMapper条件查询
	 */
	@Test
	public void testSearchByConditions(){
		
		AppuserInfo appuserInfo = new AppuserInfo();
		appuserInfo.setAppuserIdfa("GHDGSHGDHSGDJH");//GJS14D52F63H5J
//		appuserInfo.setAppuserIdfa("idfa");//
		appuserInfo.setAppuserUdid("200809071813");
		appuserInfo.setAppuserMobile("1452145236");
		
		//查询全部信息
		List<AppuserInfo> appuserInfoListOne = appuserInfoMapper.getAppuserInfoByConditions(appuserInfo);
		System.out.println(appuserInfoListOne);
		System.out.println("appuserInfoListOne:"+appuserInfoListOne.size());
		System.out.println("条件查询完成");
	}
	
	/**
	 * groupDisplayMapper查询全部
	 */
	@Test
	public void testSearchAll(){
		
		AppuserInfo appuserInfo = new AppuserInfo();
		appuserInfo.setAppuserId(1);
		
		//查询全部信息
		List<AppuserInfo> appuserInfoListALl = appuserInfoMapper.getAppuserInfoAll();
		System.out.println(appuserInfoListALl);
		System.out.println("appuserInfoListALl:"+appuserInfoListALl.size());
		
		System.out.println("查询全部完成");
		
	}
	
	
	/**
	 * appuserInfoMapper新增
	 */
	@Test
	public void testInsert(){
		
		//2、新增appUser信息
		AppuserInfo appuserInfo = new AppuserInfo();
		/*
		 *用户IDappuser_id	INT(16) NOT NULL
		 *用户IPappuser_ip	VARCHAR(64)
		 *用户手机号appuser_mobile	VARCHAR(64)
		 *用户昵称appuser_name	VARCHAR(64) NOT NULL
		 *用户设备唯一标示appuser_udid		VARCHAR(128)
		 *用户设备机型appuser_idfa		VARCHAR(128) NOT NULL
		 *激活时间appuser_createtime		VARCHAR(128) NOT NULL
		 *最后登陆时间appuser_lasttime	VARCHAR(128) NOT NULL
		 *备用字段1appuser_spareone		INT(16)
		 *备用字段2appuser_sparetwo		INT(16)
		 *备用字段3appuser_sparethree		VARCHAR(128)
		 *备用字段4appuser_sparefour		VARCHAR(128)
		 * */
//		appuserInfo.setAppuserId(null);						//用户IDappuser_id
		appuserInfo.setAppuserIp("");;			//用户IPappuser_ip	VARCHAR(64)
		appuserInfo.setAppuserMobile("");		//用户手机号appuser_mobile	VARCHAR(64)
		String appuserName = UUIDUtils.getId();
		appuserName= appuserName.substring(0,12);
		appuserInfo.setAppuserName(appuserName);;					//用户昵称appuser_name	VARCHAR(64) NOT NULL
		appuserInfo.setAppuserUdid("");;					//用户设备唯一标示appuser_udid		VARCHAR(128)
		appuserInfo.setAppuserIdfa("idfaidfa");;	//用户设备机型appuser_idfa		VARCHAR(128) NOT NULL
		String nowTime = DateUtil.strTime14s();
		appuserInfo.setAppuserCreatetime(nowTime);;			//激活时间appuser_createtime		VARCHAR(128) NOT NULL
		appuserInfo.setAppuserLasttime(nowTime);;		//最后登陆时间appuser_lasttime	VARCHAR(128) NOT NULL
		appuserInfo.setAppuserSpareone(0);;	//备用字段1appuser_spareone		INT(16)
		appuserInfo.setAppuserSparetwo(0);//备用字段2appuser_sparetwo		INT(16)
		appuserInfo.setAppuserSparethree("0");	//备用字段3appuser_sparethree		VARCHAR(128)
		appuserInfo.setAppuserSparefour("0");;	//备用字段4appuser_sparefour		VARCHAR(128)
		appuserInfoMapper.insertSelective(appuserInfo);
		
	}
	
	
	
	/**
	 * appuserInfoMapper更新
	 */
	@Test
	public void testUpdate(){
		
		AppuserInfo appuserInfo = new AppuserInfo();
		//设置UserID
		appuserInfo.setAppuserId(1);
		//更新时间
		String nowTime = DateUtil.strTime14s();
		appuserInfo.setAppuserLasttime(nowTime);;
		
		//2、更新任务信息
		appuserInfoMapper.updateByPrimaryKeySelective(appuserInfo);

		System.out.println("更新完成");
	}
	
	/**
	 * groupDisplayMapper删除
	 */
	@Test
	public void testDelete(){
		
		//2、生成员工数据，测试员工删除
		appuserInfoMapper.deleteByPrimaryKey(2);

		System.out.println("删除完成");
	}


}
