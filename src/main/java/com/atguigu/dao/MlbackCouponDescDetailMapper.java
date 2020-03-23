package com.atguigu.dao;

import com.atguigu.bean.MlbackCouponDescDetail;
import com.atguigu.bean.MlbackCouponDescDetailExample;
import com.atguigu.bean.MlbackFootNav;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlbackCouponDescDetailMapper {
    long countByExample(MlbackCouponDescDetailExample example);

    int deleteByExample(MlbackCouponDescDetailExample example);

    int insert(MlbackCouponDescDetail record);

    List<MlbackCouponDescDetail> selectByExample(MlbackCouponDescDetailExample example);

    MlbackCouponDescDetail selectByPrimaryKey(Integer coupondescdetailId);

    int updateByExampleSelective(@Param("record") MlbackCouponDescDetail record, @Param("example") MlbackCouponDescDetailExample example);

    int updateByExample(@Param("record") MlbackCouponDescDetail record, @Param("example") MlbackCouponDescDetailExample example);

    int updateByPrimaryKey(MlbackCouponDescDetail record);
    
    
    
    //插入新类目00
    int insertSelective(MlbackCouponDescDetail record);
    //删除本条00
    int deleteByPrimaryKey(Integer coupondescdetailId);
    //更新本条00
    int updateByPrimaryKeySelective(MlbackCouponDescDetail record);
    //查询后台登陆用户00
    List<MlbackCouponDescDetail> selectMlbackCouponDescDetailById(MlbackCouponDescDetail record);
    //查询全部登陆用户00
	List<MlbackCouponDescDetail> selectMlbackCouponDescDetailGetAll();

	//简单查询底部导航
	List<MlbackCouponDescDetail> selectMlbackCouponDescDetailByStatus(MlbackCouponDescDetail record);
    
}