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

import com.atguigu.bean.GroupDisplay;
import com.atguigu.dao.GroupDisplayMapper;
import com.atguigu.utils.DateUtil;

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
public class GroupDisplayTest {
	
	@Autowired
	GroupDisplayMapper groupDisplayMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * groupDisplayMapper条件查询
	 */
	@Test
	public void testSearchByConditions(){
		
		GroupDisplay groupDisplay = new GroupDisplay();
		groupDisplay.setGroupPeople("商务小熊");;
		
		//查询全部信息
		List<GroupDisplay> groupDisplayListOne = groupDisplayMapper.getGroupDisplayByConditions(groupDisplay);
		System.out.println(groupDisplayListOne);
		System.out.println("groupDisplayListOne:"+groupDisplayListOne.size());
		System.out.println("条件查询完成");
	}
	
	/**
	 * groupDisplayMapper查询全部
	 */
	@Test
	public void testSearchAll(){
		
		GroupDisplay groupDisplay = new GroupDisplay();
		groupDisplay.setGroupId(2);
		
		//查询全部信息
		List<GroupDisplay> groupDisplayListALl = groupDisplayMapper.getGroupDisplayAll();
		System.out.println(groupDisplayListALl);
		System.out.println("groupDisplayListALl:"+groupDisplayListALl.size());
		
		System.out.println("查询全部完成");
		
	}
	
	
	/**
	 * groupDisplayMapper新增
	 */
	@Test
	public void testInsert(){
		
		String nowTime = DateUtil.strTime14s();
		
		//2、新增任务信息
		GroupDisplay groupDisplay = new GroupDisplay();
		/*
		 * 任务组IDgroup_id
		 * 来源group_source
		 * 任务名group_task_name
		 * 任务量group_num
		 * 任务图片group_pimage
		 * 任务优先级group_priority
		 * 开始时间group_createtime
		 * 修改时间group_updatetime
		 * 商务接入人group_prople
		 * 商户价group_inprice
		 * 用户价group_outprice
		 * 
		 * 
		 * 
		 * group_id INT(16) NOT NULL auto_increment primary key, 
			group_source VARCHAR(32) NOT NULL,
			group_task_name VARCHAR(32) NOT NULL,
			group_allnum INT(16) NOT NULL,
			group_nownum INT(16) NOT NULL,
			group_appstoreid VARCHAR(32) NOT NULL,
			group_pimageurl VARCHAR(255) NOT NULL,
			group_priority INT(16) NOT NULL,
			group_howdownload VARCHAR(32) NOT NULL,
			group_downloadurl VARCHAR(255) NOT NULL,
			group_createtime VARCHAR(64) NOT NULL,
			group_updatetime VARCHAR(64) NOT NULL,
			group_people VARCHAR(32) NOT NULL,
			group_inprice INT(8) NOT NULL,
			group_outprice INT(8) NOT NULL,
			group_state INT(8) NOT NULL
		 * */
//		groupDisplay.setGroupId(null);						//任务组IDgroup_id
		groupDisplay.setGroupSource("测试平台平台");			//来源group_source
		groupDisplay.setGroupTaskName("创世九州");		//任务名group_task_name
		groupDisplay.setGroupAllnum(2000);					//任务总量group_Allnum
		groupDisplay.setGroupNownum(500);					//任务余量group_Nownum
		groupDisplay.setGroupAppstoreid("100020003000");
		groupDisplay.setGroupPimageurl("product/1/dsadsadsa");			//任务图片group_pimage
		groupDisplay.setGroupPrioritys(5);		//任务优先级group_priority
		groupDisplay.setGroupHowdownload("1");	//1链接，2关键词
		groupDisplay.setGroupDownloadurl("www.baidu.com");
		groupDisplay.setGroupCreatetime(nowTime);	//开始时间group_createtime
		groupDisplay.setGroupStarttime(nowTime);
		groupDisplay.setGroupUpdatetime(nowTime);	//修改时间group_updatetime
		groupDisplay.setGroupPeople("商务小薛");			//商务接入人group_prople
		groupDisplay.setGroupInprice("20");			//商户价group_inprice
		groupDisplay.setGroupOutprice("5");		//用户价group_outprice
		groupDisplay.setGroupState(1);     		//1,2,3,4,5
		groupDisplayMapper.insertSelective(groupDisplay);
		
	}
	
	
	
	/**
	 * groupDisplayMapper更新
	 */
	@Test
	public void testUpdate(){
		
		GroupDisplay groupDisplay = new GroupDisplay();
		groupDisplay.setGroupId(1);
		
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
		String updateTime =sdf.format(date);
		groupDisplay.setGroupUpdatetime(updateTime);
		
		
		//2、更新任务信息
		groupDisplayMapper.updateByPrimaryKeySelective(groupDisplay);

		System.out.println("更新完成");
	}
	
	/**
	 * groupDisplayMapper删除
	 */
	@Test
	public void testDelete(){
		
		//2、生成员工数据，测试员工删除
		groupDisplayMapper.deleteByPrimaryKey(1);

		System.out.println("删除完成");
	}


}
