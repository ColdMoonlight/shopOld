package com.atguigu.dao;

import com.atguigu.bean.AppuserInfo;
import com.atguigu.bean.AppuserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppuserInfoMapper {
    long countByExample(AppuserInfoExample example);

    int deleteByExample(AppuserInfoExample example);

    int insert(AppuserInfo record);

    List<AppuserInfo> selectByExample(AppuserInfoExample example);

    AppuserInfo selectByPrimaryKey(Integer appuserId);

    int updateByExampleSelective(@Param("record") AppuserInfo record, @Param("example") AppuserInfoExample example);

    int updateByExample(@Param("record") AppuserInfo record, @Param("example") AppuserInfoExample example);


    int updateByPrimaryKey(AppuserInfo record);
    
    //插入appUser
    int insertSelective(AppuserInfo record);
    //更新
    int updateByPrimaryKeySelective(AppuserInfo record);
    //删除
    int deleteByPrimaryKey(Integer appuserId);
    //查询全部
    List<AppuserInfo> getAppuserInfoAll();
    //条件查询信息
	List<AppuserInfo> getAppuserInfoByConditions(AppuserInfo appuserInfo);
}