package com.atguigu.dao;

import com.atguigu.bean.MlbackAddCartViewDetail;
import com.atguigu.bean.MlbackAddCartViewDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlbackAddCartViewDetailMapper {
    long countByExample(MlbackAddCartViewDetailExample example);

    int deleteByExample(MlbackAddCartViewDetailExample example);

    int insert(MlbackAddCartViewDetail record);

    List<MlbackAddCartViewDetail> selectByExample(MlbackAddCartViewDetailExample example);

    MlbackAddCartViewDetail selectByPrimaryKey(Integer addcartviewdetailId);

    int updateByExampleSelective(@Param("record") MlbackAddCartViewDetail record, @Param("example") MlbackAddCartViewDetailExample example);

    int updateByExample(@Param("record") MlbackAddCartViewDetail record, @Param("example") MlbackAddCartViewDetailExample example);

    int updateByPrimaryKeySelective(MlbackAddCartViewDetail record);

    int updateByPrimaryKey(MlbackAddCartViewDetail record);
    
    
    
    
    //插入新类目
    int insertSelective(MlbackAddCartViewDetail record);
    //删除本条
    int deleteByPrimaryKey(Integer addcartviewdetailId);
    //按照时间查询全部登陆用户
	List<MlbackAddCartViewDetail> selectMlbackAddCartViewDetailByTime(MlbackAddCartViewDetail example);
	
	
}