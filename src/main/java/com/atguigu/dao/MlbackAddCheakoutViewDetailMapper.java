package com.atguigu.dao;

import com.atguigu.bean.MlbackAddCheakoutViewDetail;
import com.atguigu.bean.MlbackAddCheakoutViewDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlbackAddCheakoutViewDetailMapper {
    long countByExample(MlbackAddCheakoutViewDetailExample example);

    int deleteByExample(MlbackAddCheakoutViewDetailExample example);

    int insert(MlbackAddCheakoutViewDetail record);

    List<MlbackAddCheakoutViewDetail> selectByExample(MlbackAddCheakoutViewDetailExample example);

    MlbackAddCheakoutViewDetail selectByPrimaryKey(Integer addcheakoutviewdetailId);

    int updateByExampleSelective(@Param("record") MlbackAddCheakoutViewDetail record, @Param("example") MlbackAddCheakoutViewDetailExample example);

    int updateByExample(@Param("record") MlbackAddCheakoutViewDetail record, @Param("example") MlbackAddCheakoutViewDetailExample example);

    int updateByPrimaryKeySelective(MlbackAddCheakoutViewDetail record);

    int updateByPrimaryKey(MlbackAddCheakoutViewDetail record);
    
    
    //插入新类目
    int insertSelective(MlbackAddCheakoutViewDetail record);
    //删除本条
    int deleteByPrimaryKey(Integer addorderviewdetailId);
    //按照时间查询全部登陆用户
	List<MlbackAddCheakoutViewDetail> selectMlbackAddCheakoutViewDetailByTime(MlbackAddCheakoutViewDetail example);
}