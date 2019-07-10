package com.atguigu.testBean.front;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.bean.AppuserInfo;
import com.atguigu.bean.GroupDisplay;
import com.atguigu.bean.MlfrontCart;
import com.atguigu.bean.MlfrontCartItem;
import com.atguigu.bean.MlfrontUser;
import com.atguigu.bean.MlfrontUserTemporary;
import com.atguigu.dao.AppuserInfoMapper;
import com.atguigu.dao.GroupDisplayMapper;
import com.atguigu.dao.MlfrontCartItemMapper;
import com.atguigu.dao.MlfrontCartMapper;
import com.atguigu.dao.MlfrontUserMapper;
import com.atguigu.dao.MlfrontUserTemporaryMapper;
import com.atguigu.utils.DateUtil;
import com.atguigu.utils.UUIDUtils;

/**
 * 测试dao层的工作
 * @author lfy
 *推荐Spring的项目就可以使用Spring的单元测试，
 *1、导入SpringTest模块
 *2、@ContextConfiguration指定Spring配置文件的位
 *3、直接autowired要使用的组件即可
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MlfrontCartItemTest {
	
	@Autowired
	MlfrontCartItemMapper mlfrontCartItemMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	
	
	
	/**
	 * mlfrontUserTemporaryMapper新增
	 */
	@Test
	public void testInsert(){
		
		//2、新增appUser信息
		MlfrontCartItem mlfrontCartItem = new MlfrontCartItem();
		/*
		`cart_id` INT(8) AUTO_INCREMENT primary key,
   		`cart_uid` INT(8),
   		`cart_ip` varchar(512),
   		`cartItem_idStr` varchar(512),
   		`cart_createTime`	varchar(512),
   		`cart_motifyTime`	varchar(512)
		 * */
//		appuserInfo.setAppuserId(null);						//用户IDappuser_id
		mlfrontCartItem.setCartitemId(null);
		mlfrontCartItem.setCartitemUid(222);
		mlfrontCartItem.setCartitemCartId(25);
		mlfrontCartItem.setCartitemProductId(1);
		mlfrontCartItem.setCartitemProductName("CartitemProductName");
		mlfrontCartItem.setCartitemProductOriginalprice(new BigDecimal(330.45));
		mlfrontCartItem.setCartitemProductNumber(3);
		mlfrontCartItem.setCartitemProductskuIdstr("23,24,25");
		mlfrontCartItem.setCartitemProductskuIdnamestr("length,haiestyle");
		mlfrontCartItem.setCartitemProductskuNamestr("12inch,44组合");
		mlfrontCartItem.setCartitemProductskuMoneystr("36.20,20.00");
		String nowTime = DateUtil.strTime14s();
		mlfrontCartItem.setCartitemCreatetime(nowTime);
		mlfrontCartItem.setCartitemMotifytime(nowTime);
		
		Integer resId =  mlfrontCartItemMapper.insertSelective(mlfrontCartItem); 
		System.out.println(resId);
		
	}
	/**
	 * mlfrontCartMapper删除
	 */
	@Test
	public void testDelete(){
		
		//2、生成员工数据，测试员工删除
		mlfrontCartItemMapper.deleteByPrimaryKey(2);

		System.out.println("删除完成");
	}
	
	
	/**
	 * mlfrontCartMapper更新
	 */
	@Test
	public void testUpdate(){
		
		MlfrontCartItem mlfrontCartItem = new MlfrontCartItem();
		//设置UserID
		mlfrontCartItem.setCartitemId(2);
		mlfrontCartItem.setCartitemUid(236);
		mlfrontCartItem.setCartitemCartId(25);
		mlfrontCartItem.setCartitemProductId(1);
		mlfrontCartItem.setCartitemProductName("CartitemProductName");
		mlfrontCartItem.setCartitemProductOriginalprice(new BigDecimal(330.45));
		mlfrontCartItem.setCartitemProductNumber(3);
		mlfrontCartItem.setCartitemProductskuIdstr("23,24,25");
		mlfrontCartItem.setCartitemProductskuIdnamestr("length,haiestyle");
		mlfrontCartItem.setCartitemProductskuNamestr("12inch,44组合");
		mlfrontCartItem.setCartitemProductskuMoneystr("36.20,20.00");
		String nowTime = DateUtil.strTime14s();
		mlfrontCartItem.setCartitemMotifytime(nowTime);
	
		//更新时间
		
		//2、更新任务信息
		mlfrontCartItemMapper.updateByPrimaryKeySelective(mlfrontCartItem);

		System.out.println("更新完成");
	}
	
	/**
	 * mlfrontCartMapper查询全部
	 */
	@Test
	public void testSearchAll(){
		
		//查询全部信息
		List<MlfrontCartItem> mlfrontCartItemList = mlfrontCartItemMapper.selectMlfrontCartItemGetAll();
		System.out.println(mlfrontCartItemList);
		System.out.println("mlfrontCartItemList.size:"+mlfrontCartItemList.size());
		System.out.println("查询全部完成");
	}
	
}
