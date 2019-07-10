package com.atguigu.dao;

import com.atguigu.bean.TaskFrom;
import com.atguigu.bean.TaskFromExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskFromMapper {
    long countByExample(TaskFromExample example);

    int deleteByExample(TaskFromExample example);

    int insertSelective(TaskFrom record);

    List<TaskFrom> selectByExample(TaskFromExample example);

    TaskFrom selectByPrimaryKey(Integer taskId);

    int updateByExampleSelective(@Param("record") TaskFrom record, @Param("example") TaskFromExample example);

    int updateByExample(@Param("record") TaskFrom record, @Param("example") TaskFromExample example);

    int updateByPrimaryKey(TaskFrom record);
    
    //查询全部商务任务
	List<TaskFrom> getTaskFromAll();
	//多条件查询商务任务
	List<TaskFrom> getTaskFromByConditions(TaskFrom taskFrom);
	//插入一条新的商务任务
	int insert(TaskFrom record);
	//删除一条新的商务任务
	int deleteByPrimaryKey(Integer taskId);
	//更新本条商务任务
	int updateByPrimaryKeySelective(TaskFrom record);
}