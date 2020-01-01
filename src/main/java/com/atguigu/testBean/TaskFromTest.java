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

import com.atguigu.bean.TaskFrom;
import com.atguigu.bean.TaskFromExample;
import com.atguigu.dao.TaskFromMapper;
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
public class TaskFromTest {
	
	@Autowired
	TaskFromMapper taskFromMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	
	
	
	@Test
	public void testSearch(){
		
		TaskFrom taskFrom = new TaskFrom();
		taskFrom.setTaskId(1);
		
		
		List<TaskFrom> taskFromListOne = taskFromMapper.getTaskFromByConditions(taskFrom);
		System.out.println(taskFromListOne);
		
		List<TaskFrom> taskFromListALl = taskFromMapper.getTaskFromAll();
		System.out.println(taskFromListALl);
		
		//sysUserMapper.insertSelective(new SysUser(null,"admin2","admin123456"));
		
		System.out.println("批量完成");
		
	}
	
	
	/**
	 * 测试DepartmentMapper
	 */
	@Test
	public void testInsert(){
		
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
		String createTime =sdf.format(date);
		String updateTime =sdf.format(date);
		
		//2、生成员工数据，测试员工插入
		for(int i=0;i<20;i++){
			String Name1=""+i+"测试平台";
			String Name2=""+i+"创世九州";
			taskFromMapper.insertSelective(new TaskFrom(null, Name1, Name2, "应用名01","13652478", createTime, updateTime, 1, 1, 1));
		}

		System.out.println("批量完成");
		
	}
	
	/**
	 * taskFromMapper删除
	 */
	@Test
	public void testDelete(){
		
		//2、生成员工数据，测试员工删除
		taskFromMapper.deleteByPrimaryKey(6);

		System.out.println("删除完成");
	}
	
	/**
	 * taskFromMapper删除
	 */
	@Test
	public void testUpdate(){
		
		TaskFrom TaskFrom = new TaskFrom();
		TaskFrom.setTaskId(4);
		
		Date date =new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("yyyyMMddHHmmss");
		String updateTime =sdf.format(date);
		TaskFrom.setTaskUpdatetime(updateTime);
		
		
		//2、生成员工数据，测试员工删除
		taskFromMapper.updateByPrimaryKeySelective(TaskFrom);

		System.out.println("删除完成");
	}


}
