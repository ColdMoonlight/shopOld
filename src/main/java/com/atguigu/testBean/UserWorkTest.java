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
import com.atguigu.bean.UserWork;
import com.atguigu.dao.GroupDisplayMapper;
import com.atguigu.dao.UserWorkMapper;
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
public class UserWorkTest {
	
	@Autowired
	GroupDisplayMapper groupDisplayMapper;
	
	@Autowired
	UserWorkMapper userWorkMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * userWorkMapper条件查询
	 */
	@Test
	public void testSearchByConditions(){
		
		UserWork userWork = new UserWork();
		//userWork.setUserworkUdid("udid");
		//userWork.setUserworkState("0");
//		userWork.setUserworkIdfa("GJS14D52F63JKh");
		userWork.setUserworkUdid("200809121451");
		userWork.setUserworkGroupdisplayId(14);
		//userworkUdid=200809121451&userworkIdfa=GJS14D52F63JKh&userworkGroupdisplayId=14
		
		//查询全部信息
		List<UserWork> userWorkListOne = userWorkMapper.getUserWorkByConditions(userWork);
		System.out.println(userWorkListOne);
		System.out.println("userWorkListOne:"+userWorkListOne.size());
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
	 * userWorkMapper新增
	 * 任务IDuserwork_id
	 * 发布任务IDuserwork_groupdisplay_id
	 * 任务持有者IDuserwork_udid
	 * 任务持有者设备userwork_idfa
	 * 任务开始时间userwork_createtime
	 * 提交任务时间userwork_uploadtime
	 * 完成状态userwork_state
	 * 任务金额userwork_price
	 * 备用字段1userwork_spareone
	 * 备用字段2userwork_sparetwo
	 * 备用字段3userwork_sparethree
	 * 备用字段4userwork_sparefour
	 */
	@Test
	public void testInsert(){
		String nowTime = DateUtil.strTime14s();
		//2、用户接任务,入表
		UserWork userWork = new UserWork();
//		groupDisplay.setGroupId(null);						//任务IDuserwork_id
		userWork.setUserworkGroupdisplayId(33);			//发布任务IDuserwork_groupdisplay_id
		userWork.setUserworkUdid("udid");			//任务持有者IDuserwork_udid
		userWork.setUserworkIdfa("idfa");					//任务持有者设备userwork_idfa
		userWork.setUserworkCreatetime(nowTime);				//任务开始时间userwork_createtime
		userWork.setUserworkUploadtime("");//提交任务时间userwork_uploadtime
		userWork.setUserworkState("0");			//完成状态userwork_state
		userWork.setUserworkPrice("2.50");		//任务金额userwork_price
		userWorkMapper.insertSelective(userWork);
	}
	
	/**
	 * groupDisplayMapper更新
	 */
	@Test
	public void testUpdate(){
		
		UserWork userWork = new UserWork();
		
		String nowTime = DateUtil.strTime14s();
		userWork.setUserworkId(1);
		userWork.setUserworkUploadtime(nowTime);
		int updateResult = userWorkMapper.updateByPrimaryKeySelective(userWork);
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
