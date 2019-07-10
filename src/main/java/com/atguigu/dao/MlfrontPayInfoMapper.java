package com.atguigu.dao;

import com.atguigu.bean.MlfrontCart;
import com.atguigu.bean.MlfrontPayInfo;
import com.atguigu.bean.MlfrontPayInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlfrontPayInfoMapper {
    long countByExample(MlfrontPayInfoExample example);

    int deleteByExample(MlfrontPayInfoExample example);

    int insert(MlfrontPayInfo record);

    List<MlfrontPayInfo> selectByExample(MlfrontPayInfoExample example);

    MlfrontPayInfo selectByPrimaryKey(Integer payinfoId);

    int updateByExampleSelective(@Param("record") MlfrontPayInfo record, @Param("example") MlfrontPayInfoExample example);

    int updateByExample(@Param("record") MlfrontPayInfo record, @Param("example") MlfrontPayInfoExample example);

    int updateByPrimaryKey(MlfrontPayInfo record);
    
    
    //插入新类目00
    int insertSelective(MlfrontPayInfo record);
    //删除本条00
    int deleteByPrimaryKey(Integer payinfoId);
    //更新本条00
    int updateByPrimaryKeySelective(MlfrontPayInfo record);
    //查询后台登陆用户00
    List<MlfrontPayInfo> selectMlfrontPayInfoById(MlfrontPayInfo record);
    //查询全部登陆用户00
	List<MlfrontPayInfo> selectMlfrontPayInfoGetAll();
	//通过时间查询全部登陆用户00
	List<MlfrontPayInfo> selectMlfrontPayInfoByDate(MlfrontPayInfo mlfrontPayInfo);
    
}