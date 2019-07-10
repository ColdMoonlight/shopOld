package com.atguigu.dao;

import com.atguigu.bean.MlfrontReview;
import com.atguigu.bean.MlfrontReviewExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MlfrontReviewMapper {
    long countByExample(MlfrontReviewExample example);

    int deleteByExample(MlfrontReviewExample example);

    int insert(MlfrontReview record);

    List<MlfrontReview> selectByExample(MlfrontReviewExample example);

    MlfrontReview selectByPrimaryKey(Integer reviewId);

    int updateByExampleSelective(@Param("record") MlfrontReview record, @Param("example") MlfrontReviewExample example);

    int updateByExample(@Param("record") MlfrontReview record, @Param("example") MlfrontReviewExample example);

    int updateByPrimaryKey(MlfrontReview record);
    
    //插入新类目00
    int insertSelective(MlfrontReview record);
    //删除本条00
    int deleteByPrimaryKey(Integer couponId);
    //更新本条00
    int updateByPrimaryKeySelective(MlfrontReview record);
    //查询后台登陆用户00
    List<MlfrontReview> selectMlfrontReviewById(MlfrontReview example);
    //查询全部登陆用户00
	List<MlfrontReview> selectMlfrontReviewGetAll();
    
}