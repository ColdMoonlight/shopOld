package com.atguigu.testBean.back;

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
import com.atguigu.bean.MlbackCoupon;
import com.atguigu.bean.MlfrontUser;
import com.atguigu.dao.AppuserInfoMapper;
import com.atguigu.dao.GroupDisplayMapper;
import com.atguigu.dao.MlbackCouponMapper;
import com.atguigu.dao.MlfrontUserMapper;
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
public class MlbackCouponTest {
	
	@Autowired
	MlbackCouponMapper mlbackCouponMapper;
	
	@Autowired
	AppuserInfoMapper appuserInfoMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * mlbackCouponMapper新增
	 */
	@Test
	public void testInsert(){
		
		//2、新增appUser信息
		MlbackCoupon mlbackCoupon = new MlbackCoupon();
		/*
		   `coupon_id` INT(8) AUTO_INCREMENT primary key,
		   `coupon_name` VARCHAR(512) NOT NULL,
		   `coupon_price` decimal(8,2),
		   `coupon_price_baseline` decimal(8,2),
		   `coupon_status` int(8) NOT NULL,
		   `coupon_code` VARCHAR(512),
		   `coupon_admin_id` INT(8),
		   `coupon_admin_operatorName` VARCHAR(512),
		   `coupon_createTime` VARCHAR(512) ,
		   `coupon_motifyTime` VARCHAR(512) 
		 * */
		mlbackCoupon.setCouponId(null);
		mlbackCoupon.setCouponName("coupon_name");
		mlbackCoupon.setCouponPrice(new BigDecimal(5.00));
		mlbackCoupon.setCouponPriceBaseline(new BigDecimal(99.00));
		mlbackCoupon.setCouponStatus(0);
		mlbackCoupon.setCouponCode("coupon_code");
		String nowTime = DateUtil.strTime14s();
		mlbackCoupon.setCouponCreatetime(nowTime);
		mlbackCoupon.setCouponMotifytime(nowTime);
		
		mlbackCouponMapper.insertSelective(mlbackCoupon);
		
		System.out.println("新增完成");
		
	}
	/**
	 * mlbackCouponMapper删除
	 */
	@Test
	public void testDelete(){
		
		//2、生成员工数据，测试员工删除
		mlbackCouponMapper.deleteByPrimaryKey(2);

		System.out.println("删除完成");
	}
	
	
	/**
	 * mlbackCouponMapper更新
	 */
	@Test
	public void testUpdate(){
		
		MlbackCoupon mlbackCoupon = new MlbackCoupon();
		//设置UserID
		mlbackCoupon.setCouponId(3);
		mlbackCoupon.setCouponName("$10 off over $99");
		mlbackCoupon.setCouponPrice(new BigDecimal(5.00));
		mlbackCoupon.setCouponPriceBaseline(new BigDecimal(99.00));
		mlbackCoupon.setCouponStatus(0);
		mlbackCoupon.setCouponCode("coupon_code");
		String nowTime = DateUtil.strTime14s();
		mlbackCoupon.setCouponMotifytime(nowTime);
		//更新时间
		
		//2、更新任务信息
		mlbackCouponMapper.updateByPrimaryKeySelective(mlbackCoupon);

		System.out.println("更新完成");
	}
	
	
	/**
	 * mlbackCouponMapper条件查询
	 */
	@Test
	public void testSearchByConditions(){
		
		MlbackCoupon mlbackCoupon = new MlbackCoupon();
		//设置UserID
		mlbackCoupon.setCouponId(3);
		//查询全部信息
		List<MlbackCoupon> mlbackCouponListOne = mlbackCouponMapper.selectMlbackCouponByConditionS(mlbackCoupon);
		System.out.println(mlbackCouponListOne);
		System.out.println("mlbackCouponListOne:"+mlbackCouponListOne.size());
		System.out.println("条件查询完成");
	}
	
	/**
	 * mlbackCouponMapper查询全部
	 */
	@Test
	public void testSearchAll(){
		
		//查询全部信息
		List<MlbackCoupon> mlbackCouponList = mlbackCouponMapper.selectMlbackCouponGetAll();
		System.out.println(mlbackCouponList);
		System.out.println("mlbackCouponList:"+mlbackCouponList.size());
		System.out.println("查询全部完成");
	}
}
