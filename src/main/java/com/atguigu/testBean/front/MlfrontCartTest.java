package com.atguigu.testBean.front;

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
import com.atguigu.bean.MlfrontUser;
import com.atguigu.bean.MlfrontUserTemporary;
import com.atguigu.dao.AppuserInfoMapper;
import com.atguigu.dao.GroupDisplayMapper;
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
public class MlfrontCartTest {
	
	@Autowired
	MlfrontCartMapper mlfrontCartMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	
	
	
	/**
	 * mlfrontUserTemporaryMapper新增
	 */
	@Test
	public void testInsert(){
		
		//2、新增appUser信息
		MlfrontCart mlfrontCart = new MlfrontCart();
		/*
		`cart_id` INT(8) AUTO_INCREMENT primary key,
   		`cart_uid` INT(8),
   		`cart_ip` varchar(512),
   		`cartItem_idStr` varchar(512),
   		`cart_createTime`	varchar(512),
   		`cart_motifyTime`	varchar(512)
		 * */
//		appuserInfo.setAppuserId(null);						//用户IDappuser_id
		mlfrontCart.setCartId(null);
		mlfrontCart.setCartUid(6);
		mlfrontCart.setCartIp("192.168.1.111");
		mlfrontCart.setCartitemIdstr("10,20,21");
		String nowTime = DateUtil.strTime14s();
		mlfrontCart.setCartCreatetime(nowTime);
		mlfrontCart.setCartMotifytime(nowTime);
		
		mlfrontCartMapper.insertSelective(mlfrontCart);
		
	}
	/**
	 * mlfrontCartMapper删除
	 */
	@Test
	public void testDelete(){
		
		//2、生成员工数据，测试员工删除
		mlfrontCartMapper.deleteByPrimaryKey(2);

		System.out.println("删除完成");
	}
	
	
	/**
	 * mlfrontCartMapper更新
	 */
	@Test
	public void testUpdate(){
		
		MlfrontCart mlfrontCart = new MlfrontCart();
		//设置UserID
		mlfrontCart.setCartId(2);
		mlfrontCart.setCartUid(5);
		mlfrontCart.setCartIp("192.168.1.100");
		mlfrontCart.setCartitemIdstr("10,20,21");
		String nowTime = DateUtil.strTime14s();
		mlfrontCart.setCartMotifytime(nowTime);
		//更新时间
		
		//2、更新任务信息
		mlfrontCartMapper.updateByPrimaryKeySelective(mlfrontCart);

		System.out.println("更新完成");
	}
	
	/**
	 * mlfrontCartMapper查询全部
	 */
	@Test
	public void testSearchAll(){
		
		//查询全部信息
		List<MlfrontCart> mlfrontCartList = mlfrontCartMapper.selectMlfrontCartGetAll();
		System.out.println(mlfrontCartList);
		System.out.println("mlfrontCartList.size:"+mlfrontCartList.size());
		System.out.println("查询全部完成");
	}
	
}
