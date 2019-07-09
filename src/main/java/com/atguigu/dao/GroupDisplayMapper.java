package com.atguigu.dao;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.GroupDisplayExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GroupDisplayMapper {
    long countByExample(GroupDisplayExample example);

    int deleteByExample(GroupDisplayExample example);

    int insert(GroupDisplay record);

    List<GroupDisplay> selectByExample(GroupDisplayExample example);

    GroupDisplay selectByPrimaryKey(Integer groupId);

    int updateByExampleSelective(@Param("record") GroupDisplay record, @Param("example") GroupDisplayExample example);

    int updateByExample(@Param("record") GroupDisplay record, @Param("example") GroupDisplayExample example);

    int updateByPrimaryKey(GroupDisplay record);
    
    //插入文件信息
    int insertSelective(GroupDisplay record);
    //更新本条
    int updateByPrimaryKeySelective(GroupDisplay record);
    //删除本条
    int deleteByPrimaryKey(Integer groupId);
    //查询全部
    List<GroupDisplay> getGroupDisplayAll();
    //多条件查询	useOn
	List<GroupDisplay> getGroupDisplayByConditions(GroupDisplay groupDisplay);
	//多条件查询 带排序
	List<GroupDisplay> getGroupDisplayByConditionsORderBy(GroupDisplay groupDisplay);
}