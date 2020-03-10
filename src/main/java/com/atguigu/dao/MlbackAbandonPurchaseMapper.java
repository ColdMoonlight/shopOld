package com.atguigu.dao;

import com.atguigu.bean.MlbackAbandonPurchase;
import com.atguigu.bean.MlbackAbandonPurchaseExample;
import com.atguigu.bean.MlbackSlide;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlbackAbandonPurchaseMapper {
    long countByExample(MlbackAbandonPurchaseExample example);

    int deleteByExample(MlbackAbandonPurchaseExample example);

    int insert(MlbackAbandonPurchase record);

    List<MlbackAbandonPurchase> selectByExample(MlbackAbandonPurchaseExample example);

    MlbackAbandonPurchase selectByPrimaryKey(Integer abandonpurchaseId);

    int updateByExampleSelective(@Param("record") MlbackAbandonPurchase record, @Param("example") MlbackAbandonPurchaseExample example);

    int updateByExample(@Param("record") MlbackAbandonPurchase record, @Param("example") MlbackAbandonPurchaseExample example);

    int updateByPrimaryKey(MlbackAbandonPurchase record);
    
    
    //插入新类目
    int insertSelective(MlbackAbandonPurchase record);
    //删除本条
    int deleteByPrimaryKey(Integer abandonpurchaseId);
    //更新本条
    int updateByPrimaryKeySelective(MlbackAbandonPurchase record);
    //通过id查询本条
    List<MlbackAbandonPurchase> selectMlbackAbandonPurchaseById(MlbackAbandonPurchase example);
    //查询全部
	List<MlbackAbandonPurchase> selectMlbackAbandonPurchaseGetAll();
	//通过id查询本条
	List<MlbackAbandonPurchase> selectMlbackAbandonPurchaseByStatus(MlbackAbandonPurchase mlbackAbandonPurchase);
	
}