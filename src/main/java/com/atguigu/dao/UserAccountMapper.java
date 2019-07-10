package com.atguigu.dao;

import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.UserAccount;
import com.atguigu.bean.UserAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAccountMapper {
    long countByExample(UserAccountExample example);

    int deleteByExample(UserAccountExample example);

    int deleteByPrimaryKey(Integer userAccountid);

    int insert(UserAccount record);

    List<UserAccount> selectByExample(UserAccountExample example);

    UserAccount selectByPrimaryKey(Integer userAccountid);

    int updateByExampleSelective(@Param("record") UserAccount record, @Param("example") UserAccountExample example);

    int updateByExample(@Param("record") UserAccount record, @Param("example") UserAccountExample example);

    int updateByPrimaryKey(UserAccount record);
    
    
    //部分插入	useOn
    int insertSelective(UserAccount record);
    //多条件查询	useOn
  	List<UserAccount> getUserAccountByConditions(UserAccount userAccount);
  	//主键更新多字段
  	int updateByPrimaryKeySelective(UserAccount record);
  	//获取全部UserAccount		useOn
  	List<UserAccount> getAllUserAccount();
}