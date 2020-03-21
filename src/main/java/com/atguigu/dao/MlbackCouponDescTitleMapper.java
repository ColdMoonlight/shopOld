package com.atguigu.dao;

import com.atguigu.bean.MlbackCouponDescTitle;
import com.atguigu.bean.MlbackCouponDescTitleExample;
import com.atguigu.bean.MlbackSlide;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlbackCouponDescTitleMapper {
    long countByExample(MlbackCouponDescTitleExample example);

    int deleteByExample(MlbackCouponDescTitleExample example);

    int insert(MlbackCouponDescTitle record);

    List<MlbackCouponDescTitle> selectByExample(MlbackCouponDescTitleExample example);

    MlbackCouponDescTitle selectByPrimaryKey(Integer coupondesctieleId);

    int updateByExampleSelective(@Param("record") MlbackCouponDescTitle record, @Param("example") MlbackCouponDescTitleExample example);

    int updateByExample(@Param("record") MlbackCouponDescTitle record, @Param("example") MlbackCouponDescTitleExample example);

    int updateByPrimaryKey(MlbackCouponDescTitle record);
    
    
    //插入新类目
    int insertSelective(MlbackCouponDescTitle record);
    //删除本条
    int deleteByPrimaryKey(Integer coupondesctieleId);
    //更新本条
    int updateByPrimaryKeySelective(MlbackCouponDescTitle record);
    //通过id查询本条
    MlbackCouponDescTitle selectMlbackCouponDescTitleById(MlbackCouponDescTitle example);
    //查询全部
	List<MlbackCouponDescTitle> selectMlbackCouponDescTitleGetAll();

	List<MlbackCouponDescTitle> selectMlbackCouponDescTitlewapListByArea(MlbackCouponDescTitle mlbackCouponDescTitle);
	
	List<MlbackCouponDescTitle> selectMlbackCouponDescTitlepcListByArea(MlbackCouponDescTitle mlbackCouponDescTitle);
    
}