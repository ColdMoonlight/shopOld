package com.atguigu.testBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.bean.Department;
import com.atguigu.bean.Employee;
import com.atguigu.bean.MoneyOut;
import com.atguigu.bean.TaskFrom;
import com.atguigu.bean.TaskFromExample;
import com.atguigu.dao.DepartmentMapper;
import com.atguigu.dao.EmployeeMapper;
import com.atguigu.dao.MoneyOutMapper;
import com.atguigu.dao.TaskFromMapper;
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
public class MoneyOutTest {
	
	@Autowired
	TaskFromMapper taskFromMapper;
	
	@Autowired
	MoneyOutMapper moneyOutMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	
	
	
	@Test
	public void testSearch(){
		
		MoneyOut moneyOut = new MoneyOut();
		//moneyOut.setMoneyoutId(1);
		moneyOut.setMoneyoutUdid("201809141351");
		
		
		List<MoneyOut> moneyOutListOne = moneyOutMapper.getMoneyOutByConditions(moneyOut);
		for(MoneyOut moneyOutOne:moneyOutListOne){
			
			System.out.println(moneyOutOne);
		}
		
		//sysUserMapper.insertSelective(new SysUser(null,"admin2","admin123456"));
		
		System.out.println("批量完成");
		
	}
	
	
	/**
	 * 测试moneyOutMapper
	 */
	@Test
	public void testInsert(){
		/**
		 * 提现记录IDmoneyout_id
		 * 账户IDmoneyout_accountid
		 * 账户持有人ID(udid)moneyout_udid
		 * 提现金额moneyout_price_once
		 * 申请提现时间moneyout_applybegintime
		 * 提现到账时间moneyout_applyendtime
		 * 提现状态moneyout_apply_state
		 * 备用字段1moneyout_spareone
		 * 备用字段2moneyout_sparetwo
		 * 备用字段3moneyout_sparethree
		 * 备用字段4moneyout_sparefour
		 * */
		MoneyOut moneyOut = new MoneyOut();
		moneyOut.setMoneyoutId(null);
		moneyOut.setMoneyoutAccountid(123456);
		moneyOut.setMoneyoutUdid("udid");
		moneyOut.setMoneyoutPriceOnce("3.50");
		String nowTime = DateUtil.strTime14s();
		moneyOut.setMoneyoutApplybegintime(nowTime);
		moneyOut.setMoneyoutApplyState("1");
		
		int insertRes = moneyOutMapper.insertSelective(moneyOut);
		
		System.out.println("提现申请完毕");
		
	}
	
	/**
	 * taskFromMapper删除
	 */
	@Test
	public void testDelete(){
		
		//2、生成员工数据，测试员工删除
		taskFromMapper.deleteByPrimaryKey(6);

		System.out.println("删除完成");
	}
	
	/**
	 * moneyOutMapper更新
	 */
	@Test
	public void testUpdate(){
		
		MoneyOut moneyOut = new MoneyOut();
		moneyOut.setMoneyoutId(8);
		moneyOut.setMoneyoutUdid("201809141351");
		moneyOut.setMoneyoutApplyState("1");
		String nowTime = DateUtil.strTime14s();
		
		
		//2、生成员工数据，测试员工删除
		moneyOutMapper.updateByPrimaryKeySelective(moneyOut);

		System.out.println("更新完成");
	}


}
