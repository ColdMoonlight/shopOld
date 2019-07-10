package com.atguigu.testBean.back;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.bean.MlbackCategory;

import com.atguigu.dao.MlbackCategoryMapper;


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
public class MlbackCategoryTest {
	
	@Autowired
	MlbackCategoryMapper mlbackCategoryMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 测试DepartmentMapper
	 */
	@Test
	public void testCRUD(){
		
//		生成员工数据，测试员工插入insert接口
//		MlbackCategory MlbackCategory = new MlbackCategory();
//		MlbackCategory.setCategoryName("Lace Frontal Wig");//必填
//		MlbackCategory.setCategoryParentId(1);
//		MlbackCategory.setCategoryParentName("Wigs");
//		MlbackCategory.setCategoryDesc("Wigs>Lace Frontal Wig");
//		MlbackCategory.setCategoryStatus(0);//前台不展示
//		mlbackCategoryMapper.insertSelective(MlbackCategory);
		
		
//		生成员工数据，测试员工查询select接口		
//		MlbackCategory MlbackCategory = new MlbackCategory();
//		MlbackCategory.setCategoryId(2);
////		List<MlbackCategory>  MlbackCategoryList = mlbackCategoryMapper.selectMlbackCategory(MlbackCategory);
//		List<MlbackCategory>  MlbackCategoryList = mlbackCategoryMapper.selectMlbackCategoryGetAll();
//		for(MlbackCategory mlbackCategory:MlbackCategoryList){
//			System.out.println(mlbackCategory);
//		}
//		System.out.println(MlbackCategoryList.size());
		
		
//		MlbackCategory MlbackCategory = new MlbackCategory();
//		MlbackCategory.setCategoryId(2);
//		MlbackCategory.setCategoryName("2_Lace Frontal Wig");//必填
//		MlbackCategory.setCategoryParentId(0);
//		MlbackCategory.setCategoryParentName("2_Wigs");
//		MlbackCategory.setCategoryDesc("2_Wigs>2_Lace Frontal Wig");
//		MlbackCategory.setCategoryStatus(0);//前台不展示
////		List<MlbackCategory>  MlbackCategoryList = mlbackCategoryMapper.selectMlbackCategory(MlbackCategory);
//		int knum = mlbackCategoryMapper.updateByPrimaryKeySelective(MlbackCategory);
//		System.out.println(knum);
		
		MlbackCategory MlbackCategory = new MlbackCategory();
		MlbackCategory.setCategoryId(6);
		int knum = mlbackCategoryMapper.deleteByPrimaryKey(MlbackCategory.getCategoryId());
		System.out.println(knum);
	}
}
