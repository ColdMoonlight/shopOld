package com.atguigu.testBean.back;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.bean.MlbackProductImg;
import com.atguigu.dao.MlbackProductImgMapper;
import com.atguigu.utils.DateUtil;

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
public class MlbackProductImgTest {
	
	@Autowired
	MlbackProductImgMapper mlbackProductImgMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * MlbackProductImgMapper新增
	 */
	@Test
	public void testInsert(){
		
		//2、新增MlbackProductImg信息
		MlbackProductImg mlbackProductImg = new MlbackProductImg();
		/*
		     `productImg_id` INT(8) AUTO_INCREMENT primary key,
			 `productImg_name` VARCHAR(512) NOT NULL,
			 `productImg_url` VARCHAR(512),
			 `product_id` INT(8),
			 `productImg_sort_order` INT(8),
			 `productImg_createTime` VARCHAR(512),
			 `productImg_motifyTime` VARCHAR(512)
		 * */
		mlbackProductImg.setProductimgId(null);
		mlbackProductImg.setProductimgName("productImg_name");
		mlbackProductImg.setProductimgUrl("productImg_url");
		mlbackProductImg.setProductId(13);
		mlbackProductImg.setProductimgSortOrder(3);
		String nowTime = DateUtil.strTime14s();
		mlbackProductImg.setProductimgCreatetime(nowTime);
		mlbackProductImg.setProductimgMotifytime(nowTime);
		
		mlbackProductImgMapper.insertSelective(mlbackProductImg);
		
		System.out.println("新增完成");
		
	}
	/**
	 * MlbackProductImgMapper删除
	 */
	@Test
	public void testDelete(){
		
		//2、生成员工数据，测试员工删除
		mlbackProductImgMapper.deleteByPrimaryKey(2);

		System.out.println("删除完成");
	}
	
	
	/**
	 * MlbackProductImgMapper更新
	 */
	@Test
	public void testUpdate(){
		
		MlbackProductImg mlbackProductImg = new MlbackProductImg();
		//设置UserID
		mlbackProductImg.setProductimgId(3);
		mlbackProductImg.setProductimgName("productImg_name");
		mlbackProductImg.setProductimgUrl("productImg_url");
		mlbackProductImg.setProductId(13);
		mlbackProductImg.setProductimgSortOrder(2);
		String nowTime = DateUtil.strTime14s();
		mlbackProductImg.setProductimgMotifytime(nowTime);
		//更新时间
		//2、更新任务信息
		mlbackProductImgMapper.updateByPrimaryKeySelective(mlbackProductImg);
		System.out.println("更新完成");
	}
	
	/**
	 * MlbackProductImgMapper条件查询
	 */
	@Test
	public void testSearchByConditions(){
		
		MlbackProductImg mlbackProductImg = new MlbackProductImg();
		//设置UserID
		mlbackProductImg.setProductimgId(3);
		//查询全部信息
		List<MlbackProductImg> mlbackProductImgListOne = mlbackProductImgMapper.selectMlbackProductImgByConditionS(mlbackProductImg);
		System.out.println(mlbackProductImgListOne);
		System.out.println("mlbackProductImgListOne:"+mlbackProductImgListOne.size());
		System.out.println("条件查询完成");
	}
	
	/**
	 * MlbackProductImgMapper查询全部
	 */
	@Test
	public void testSearchAll(){
		
		//查询全部信息
		List<MlbackProductImg> mlbackProductImgList = mlbackProductImgMapper.selectMlbackProductImgGetAll();
		System.out.println(mlbackProductImgList);
		System.out.println("mlbackProductImgList:"+mlbackProductImgList.size());
		System.out.println("查询全部完成");
	}
	
	/**
	 * MlbackProductImgMapper查询全部
	 */
	@Test
	public void testSearchByProductId(){
		
		Integer productId =13;
		//查询全部信息
		List<MlbackProductImg> mlbackProductImgList = mlbackProductImgMapper.selectMlbackProductImgByProductId(productId);
		System.out.println(mlbackProductImgList);
		System.out.println("mlbackProductImgList:"+mlbackProductImgList.size());
		System.out.println("查询全部完成");
	}
	
	
}
