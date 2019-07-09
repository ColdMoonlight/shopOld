package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.dao.GroupDisplayMapper;


@Service
public class GroupDisplayService {
	
	
	@Autowired
	GroupDisplayMapper groupDisplayMapper;

	
	/**1.0	useOn
	 * @author Shinelon
	 * @param 
	 * @exception 多条件查询所有可发布任务信息
	 * 
	 * */
	public List<GroupDisplay> getGroupDisplayByConditions(GroupDisplay groupDisplay) {
		// TODO Auto-generated method stub
		List<GroupDisplay> groupDisplayListOne = groupDisplayMapper.getGroupDisplayByConditions(groupDisplay);
		return groupDisplayListOne;
	}
	
	/**1.0	useOn
	 * @author Shinelon
	 * @param 
	 * @exception 多条件查询所有可发布任务信息
	 * 
	 * */
	public List<GroupDisplay> getGroupDisplayByConditionsORderBy(GroupDisplay groupDisplay) {
		// TODO Auto-generated method stub
		List<GroupDisplay> groupDisplayListOne = groupDisplayMapper.getGroupDisplayByConditionsORderBy(groupDisplay);
		return groupDisplayListOne;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 查询所有可发布任务信息
	 * 
	 * */
	public List<GroupDisplay> getGroupDisplayAll() {
		// TODO Auto-generated method stub
		List<GroupDisplay>  groupDisplayListALl = groupDisplayMapper.getGroupDisplayAll();
		return groupDisplayListALl;
	}
	
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 插入问题一条信息
	 * 
	 * */
	public int insertSelective(GroupDisplay groupDisplay) {
		// TODO Auto-generated method stub
		int  intReslut = groupDisplayMapper.insertSelective(groupDisplay);
		return intReslut;
	}
	
	/**
	 * @author Shinelon
	 * @param 
	 * @exception 删除本条信息
	 * 
	 * */
	public int deleteByPrimaryKey(int taskId) {
		// TODO Auto-generated method stub
		int  intReslut = groupDisplayMapper.deleteByPrimaryKey(taskId);
		return intReslut;
	}


	public int updateByPrimaryKeySelective(GroupDisplay groupDisplay) {
		// TODO Auto-generated method stub
		int  intReslut = groupDisplayMapper.updateByPrimaryKeySelective(groupDisplay);
		return intReslut;
	}

}
