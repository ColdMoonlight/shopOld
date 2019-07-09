package com.atguigu.dao;

import com.atguigu.bean.AppuserInfo;
import com.atguigu.bean.UserWork;
import com.atguigu.bean.UserWorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserWorkMapper {
    long countByExample(UserWorkExample example);

    int deleteByExample(UserWorkExample example);


    int insert(UserWork record);

    List<UserWork> selectByExample(UserWorkExample example);

    UserWork selectByPrimaryKey(Integer userworkId);

    int updateByExampleSelective(@Param("record") UserWork record, @Param("example") UserWorkExample example);

    int updateByExample(@Param("record") UserWork record, @Param("example") UserWorkExample example);

    int updateByPrimaryKey(UserWork record);
    //插入信息
    int insertSelective(UserWork record);
    //通过主键更新
    int updateByPrimaryKeySelective(UserWork record);
    //条件查询
	List<UserWork> getUserWorkByConditions(UserWork userWork);
	//删除本条
	int deleteByPrimaryKey(Integer userworkId);
}