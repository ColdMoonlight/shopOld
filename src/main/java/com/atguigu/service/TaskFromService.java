package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.TaskFrom;
import com.atguigu.dao.TaskFromMapper;

@Service
public class TaskFromService {
	
	
	@Autowired
	TaskFromMapper taskFromMapper;
	
	/**
	 * @author Shinelon
	 * @param SysUser
	 * @exception 多条件查询商务信息
	 * */
	public List<TaskFrom> getTaskFromByConditions(TaskFrom taskFrom) {
		// TODO Auto-generated method stub
		List<TaskFrom>  taskFromListByConditions = taskFromMapper.getTaskFromByConditions(taskFrom);
		return taskFromListByConditions;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询所有的商务任务记录
	 * */
	public List<TaskFrom> getTaskFromAll() {
		List<TaskFrom>  taskFromListALl = taskFromMapper.getTaskFromAll();
		return taskFromListALl;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 插入新的一条商务任务
	 * */
	public int insertSelective(TaskFrom taskFrom) {
		// TODO Auto-generated method stub
		int  intReslut = taskFromMapper.insertSelective(taskFrom);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception	删除一条商务任务
	 * 
	 * */
	public int deleteByPrimaryKey(int taskId) {
		// TODO Auto-generated method stub
		int  intReslut = taskFromMapper.deleteByPrimaryKey(taskId);
		return intReslut;
	}

	/**
	 * @author Shinelon
	 * @param 
	 * @exception	更新本条商务任务
	 * 
	 * */
	public int updateByPrimaryKeySelective(TaskFrom taskFrom) {
		// TODO Auto-generated method stub
		int  intReslut = taskFromMapper.updateByPrimaryKeySelective(taskFrom);
		return intReslut;
	}
}
