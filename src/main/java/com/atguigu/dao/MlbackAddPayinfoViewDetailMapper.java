package com.atguigu.dao;

import com.atguigu.bean.MlbackAddPayinfoViewDetail;
import com.atguigu.bean.MlbackAddPayinfoViewDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlbackAddPayinfoViewDetailMapper {
    long countByExample(MlbackAddPayinfoViewDetailExample example);

    int deleteByExample(MlbackAddPayinfoViewDetailExample example);

    int insert(MlbackAddPayinfoViewDetail record);

    List<MlbackAddPayinfoViewDetail> selectByExample(MlbackAddPayinfoViewDetailExample example);

    MlbackAddPayinfoViewDetail selectByPrimaryKey(Integer addpayinfoviewdetailId);

    int updateByExampleSelective(@Param("record") MlbackAddPayinfoViewDetail record, @Param("example") MlbackAddPayinfoViewDetailExample example);

    int updateByExample(@Param("record") MlbackAddPayinfoViewDetail record, @Param("example") MlbackAddPayinfoViewDetailExample example);

    int updateByPrimaryKeySelective(MlbackAddPayinfoViewDetail record);

    int updateByPrimaryKey(MlbackAddPayinfoViewDetail record);
    
    //增
    int insertSelective(MlbackAddPayinfoViewDetail record);
    //删
    int deleteByPrimaryKey(Integer addpayinfoviewdetailId);
    //查询相关时间段内的
	List<MlbackAddPayinfoViewDetail> selectMlbackAddPayinfoViewDetailByTime(MlbackAddPayinfoViewDetail example);
	//用Payinfoid查询该条插入记录
	List<MlbackAddPayinfoViewDetail> selectMlbackAddPayinfoViewDetailByPayinfoid(MlbackAddPayinfoViewDetail mlbackAddPayinfoViewDetailReq);
}