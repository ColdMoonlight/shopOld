package com.atguigu.testBean.back;

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
import com.atguigu.bean.MlbackProductSku;
import com.atguigu.bean.MlfrontUser;
import com.atguigu.dao.AppuserInfoMapper;
import com.atguigu.dao.GroupDisplayMapper;
import com.atguigu.dao.MlbackProductSkuMapper;
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
public class MlbackProductSkuTest {
	
	@Autowired
	MlbackProductSkuMapper mlbackProductSkuMapper;
	
	@Autowired
	AppuserInfoMapper appuserInfoMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	
	
	
	/**
	 * appuserInfoMapper新增
	 */
	@Test
	public void testInsert(){
		
		//2、新增appUser信息
		MlbackProductSku mlbackProductSku = new MlbackProductSku();
		/*
		   `productSku_id` INT(8) AUTO_INCREMENT primary key,
		   `productSku_name` VARCHAR(512) NOT NULL,
		   `productSku_name_details` VARCHAR(512),
		   `productSku_money_details` VARCHAR(512),
		   `productSku_stock_details` VARCHAR(512),
		   `productSku_imageurl_details` VARCHAR(2000),
		   `product_id` INT(8) NOT NULL,
		   `productSku_status` INT(8),
		   `productSku_admin_id` INT(8),
		   `productSku_admin_operatorName` VARCHAR(512),
		   `productSku_createTime` VARCHAR(512),
		   `productSku_motifyTime` VARCHAR(512)
		 * */
//		appuserInfo.setAppuserId(null);						//用户IDappuser_id
		mlbackProductSku.setProductskuId(null);
		mlbackProductSku.setProductskuName("productSku_name");
		mlbackProductSku.setProductskuNameDetails("14inch,16inch,18inch");
		mlbackProductSku.setProductskuMoneyDetails("4,8,12");
		mlbackProductSku.setProductskuStockDetails("99,88,77");
		mlbackProductSku.setProductskuImageurlDetails("productSku_imageurl_details");
		mlbackProductSku.setProductId(8);
		mlbackProductSku.setProductskuStatus(0);
		String nowTime = DateUtil.strTime14s();
		mlbackProductSku.setProductskuCreatetime(nowTime);
		mlbackProductSku.setProductskuMotifytime(nowTime);
		
		mlbackProductSkuMapper.insertSelective(mlbackProductSku);
		
	}
	/**
	 * mlfrontUserMapper删除
	 */
	@Test
	public void testDelete(){
		
		//2、生成员工数据，测试员工删除
		mlbackProductSkuMapper.deleteByPrimaryKey(3);

		System.out.println("删除完成");
	}
	
	
	/**
	 * mlfrontUserMapper更新
	 */
	@Test
	public void testUpdate(){
		
		MlbackProductSku mlbackProductSku = new MlbackProductSku();
		//设置UserID
		mlbackProductSku.setProductskuId(3);
		mlbackProductSku.setProductskuName("productSku_name");
		mlbackProductSku.setProductskuNameDetails("14inch,16inch,18inch");
		mlbackProductSku.setProductskuMoneyDetails("4,8,12");
		mlbackProductSku.setProductskuStockDetails("99,88,77");
		mlbackProductSku.setProductskuImageurlDetails("productSku_imageurl_details");
		mlbackProductSku.setProductId(8);
		mlbackProductSku.setProductskuStatus(0);
		String nowTime = DateUtil.strTime14s();
		mlbackProductSku.setProductskuMotifytime(nowTime);
		//更新时间
		
		//2、更新任务信息
		mlbackProductSkuMapper.updateByPrimaryKeySelective(mlbackProductSku);

		System.out.println("更新完成");
	}
	
	
	/**
	 * mlfrontUserMapper条件查询
	 */
	@Test
	public void testSearchByConditions(){
		
		MlbackProductSku mlbackProductSku = new MlbackProductSku();
		//设置UserID
		mlbackProductSku.setProductskuId(8);
		//查询全部信息
		List<MlbackProductSku> mlbackProductSkuListOne = mlbackProductSkuMapper.selectMlbackProductSkuByProductId(mlbackProductSku);
		System.out.println(mlbackProductSkuListOne);
		System.out.println("mlfrontUserListOne:"+mlbackProductSkuListOne.size());
		System.out.println("条件查询完成");
	}
	
	/**
	 * groupDisplayMapper查询全部
	 */
	@Test
	public void testSearchAll(){
		
		MlfrontUser mlfrontUser = new MlfrontUser();
		//查询全部信息
		List<MlbackProductSku> mlbackProductSkuList = mlbackProductSkuMapper.selectMlbackProductGetAll();
		System.out.println(mlbackProductSkuList);
		System.out.println("mlbackProductSkuList:"+mlbackProductSkuList.size());
		System.out.println("查询全部完成");
		
	}
	


}
