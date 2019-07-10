package com.atguigu.dao;

import com.atguigu.bean.MoneyOut;
import com.atguigu.bean.MoneyOutExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MoneyOutMapper {
    long countByExample(MoneyOutExample example);

    int deleteByExample(MoneyOutExample example);

    int deleteByPrimaryKey(Integer moneyoutId);

    int insert(MoneyOut record);

    List<MoneyOut> selectByExample(MoneyOutExample example);

    MoneyOut selectByPrimaryKey(Integer moneyoutId);

    int updateByExampleSelective(@Param("record") MoneyOut record, @Param("example") MoneyOutExample example);

    int updateByExample(@Param("record") MoneyOut record, @Param("example") MoneyOutExample example);


    int updateByPrimaryKey(MoneyOut record);
    //新增
    int insertSelective(MoneyOut record);
    //条件查询
    List<MoneyOut> getMoneyOutByConditions(MoneyOut record);
    //根据主键更新
    int updateByPrimaryKeySelective(MoneyOut record);
}