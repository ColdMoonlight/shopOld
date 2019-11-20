package com.atguigu.dao;

import com.atguigu.bean.MlbackAddOrderViewDetail;
import com.atguigu.bean.MlbackAddOrderViewDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlbackAddOrderViewDetailMapper {
    long countByExample(MlbackAddOrderViewDetailExample example);

    int deleteByExample(MlbackAddOrderViewDetailExample example);

    int insert(MlbackAddOrderViewDetail record);

    List<MlbackAddOrderViewDetail> selectByExample(MlbackAddOrderViewDetailExample example);

    MlbackAddOrderViewDetail selectByPrimaryKey(Integer addorderviewdetailId);

    int updateByExampleSelective(@Param("record") MlbackAddOrderViewDetail record, @Param("example") MlbackAddOrderViewDetailExample example);

    int updateByExample(@Param("record") MlbackAddOrderViewDetail record, @Param("example") MlbackAddOrderViewDetailExample example);

    int updateByPrimaryKeySelective(MlbackAddOrderViewDetail record);

    int updateByPrimaryKey(MlbackAddOrderViewDetail record);
    
    
    //插入新类目
    int insertSelective(MlbackAddOrderViewDetail record);
    //删除本条
    int deleteByPrimaryKey(Integer addorderviewdetailId);
    //按照时间查询全部登陆用户
	List<MlbackAddOrderViewDetail> selectMlbackAddOrderViewDetailByTime(MlbackAddOrderViewDetail example);
	//通过oitemid查询是否本条已经被添加了
	List<MlbackAddOrderViewDetail> selectMlbackAddOrderViewDetailByoItemid(MlbackAddOrderViewDetail mlbackAddOrderViewDetailReq);
    
}