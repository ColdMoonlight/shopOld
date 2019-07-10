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
import com.atguigu.utils.EmailUtil;
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
public class emialTest {

	
	/**
	 * mlbackCouponMapper新增
	 */
//	@Test
//	public void testInsert(){
//		
//		try {
//			EmailUtil.readyEmail(sss);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		System.out.println("新增完成");
//		
//	}
	
}
