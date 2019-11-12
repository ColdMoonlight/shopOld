package com.atguigu.dao;

import com.atguigu.bean.MlPaypalStateprovince;
import com.atguigu.bean.MlPaypalStateprovinceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlPaypalStateprovinceMapper {
    long countByExample(MlPaypalStateprovinceExample example);

    int deleteByExample(MlPaypalStateprovinceExample example);

    int deleteByPrimaryKey(Integer stateprovinceId);

    int insert(MlPaypalStateprovince record);

    int insertSelective(MlPaypalStateprovince record);

    List<MlPaypalStateprovince> selectByExample(MlPaypalStateprovinceExample example);

    MlPaypalStateprovince selectByPrimaryKey(Integer stateprovinceId);

    int updateByExampleSelective(@Param("record") MlPaypalStateprovince record, @Param("example") MlPaypalStateprovinceExample example);

    int updateByExample(@Param("record") MlPaypalStateprovince record, @Param("example") MlPaypalStateprovinceExample example);

    int updateByPrimaryKeySelective(MlPaypalStateprovince record);

    int updateByPrimaryKey(MlPaypalStateprovince record);
}