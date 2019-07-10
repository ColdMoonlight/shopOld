package com.atguigu.testBean.back;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.bean.MlbackCategory;
import com.atguigu.bean.MlbackProduct;
import com.atguigu.dao.MlbackCategoryMapper;
import com.atguigu.dao.MlbackProductMapper;


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
public class MlbackProductTest {
	
	@Autowired
	MlbackProductMapper mlbackProductMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 测试MlbackProductMapper
	 */
	@Test
	public void testCRUD(){
		
		
//		product_name,product_categoryId,
//		product_mainimgurl,product_desc,product_originalPrice,product_haveSaleNum,
//		product_status,product_admin_id,product_admin_operatorName,
//		product_lable,product_actoffId,product_actoffOff,product_reviewNum
		
//		生成员工数据，测试员工插入insert接口
//		MlbackProduct mlbackProduct = new MlbackProduct();
//		mlbackProduct.setProductName("xxxxxxxxx");
//		mlbackProduct.setProductMainimgurl("Mainimgurl");
//		mlbackProduct.setProductCategoryid(3);
//		mlbackProduct.setProductDesc("miaoshu");
//		mlbackProduct.setProductOriginalprice(new BigDecimal(150.45));
//		mlbackProduct.setProductHavesalenum(998);
//		mlbackProduct.setProductStatus(0);//前台不展示	0不上架
//		mlbackProduct.setProductLable(0);//热销
//		mlbackProduct.setProductActoffid(2);//采用2号折扣
//		mlbackProduct.setProductActoffoff(60);
//		mlbackProduct.setProductReviewnum(300);//300条评论
//		int knum =  mlbackProductMapper.insertSelective(mlbackProduct);
//		System.out.println(knum);
		
		
//		生成员工数据，测试员工查询select接口		
//		MlbackProduct MlbackProduct = new MlbackProduct();
//		MlbackProduct.setProductId(2);
//		List<MlbackProduct>  mlbackProductList = mlbackProductMapper.selectMlbackProduct(MlbackProduct);
//		List<MlbackProduct>  mlbackProductList = mlbackProductMapper.selectMlbackProductGetAll();
//		for(MlbackProduct mlbackProduct:mlbackProductList){
//			System.out.println(mlbackProduct.toString());
//		}
//		System.out.println(mlbackProductList.size());
		
		
//		MlbackProduct mlbackProduct = new MlbackProduct();
//		mlbackProduct.setProductId(3);
//		mlbackProduct.setProductName("333333333333333");
//		mlbackProduct.setProductMainimgurl("Mainimgurl");
//		mlbackProduct.setProductCategoryid(3);
//		mlbackProduct.setProductDesc("miaoshu");
//		mlbackProduct.setProductOriginalprice(new BigDecimal(330.45));
//		mlbackProduct.setProductHavesalenum(998);
//		mlbackProduct.setProductStatus(0);//前台不展示	0不上架
//		mlbackProduct.setProductLable(0);//热销
//		mlbackProduct.setProductActoffid(2);//采用2号折扣
//		mlbackProduct.setProductActoffoff(60);
//		mlbackProduct.setProductReviewnum(399);//300条评论
////		List<MlbackCategory>  MlbackCategoryList = mlbackCategoryMapper.selectMlbackCategory(MlbackCategory);
//		int knum = mlbackProductMapper.updateByPrimaryKeySelective(mlbackProduct);
//		System.out.println(knum);
//		
		MlbackProduct mlbackProduct = new MlbackProduct();
		mlbackProduct.setProductId(3);
		int knum = mlbackProductMapper.deleteByPrimaryKey(mlbackProduct.getProductId());
		System.out.println(knum);
		List<MlbackProduct>  mlbackProductList = mlbackProductMapper.selectMlbackProductGetAll();
		System.out.println(mlbackProductList.size());
	}
}
