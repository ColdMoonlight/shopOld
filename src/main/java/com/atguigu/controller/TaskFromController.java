package com.atguigu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.atguigu.bean.Msg;
import com.atguigu.bean.SysUser;
import com.atguigu.bean.TaskFrom;
import com.atguigu.service.TaskFromService;
import com.atguigu.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/taskfrom")
public class TaskFromController {
	
	
	@Autowired
	TaskFromService taskFromService;
	
	/**1.0	userOn
	 * to商务页面
	 * @return
	 * */
	@RequestMapping(value="/toProPage")
	public String toProPage(HttpSession session){
		//判断session中user对象
		SysUser SysUser =(SysUser) session.getAttribute("user");
		if(SysUser==null){
			//SysUser中user对象为空
			return "login";
		}else{
			//SysUser中user对象不为空
			return "taskList";
		}
	}

	/**2.0	userOn
	 * 查看商务信息列表
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getTaskByPage")
	@ResponseBody
	public Msg getTaskWithJson(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		int PagNum = 10;
		PageHelper.startPage(pn, PagNum);
		List<TaskFrom> taskFrom = taskFromService.getTaskFromAll();
		PageInfo page = new PageInfo(taskFrom, PagNum);
		return Msg.success().add("pageInfo", page);
	}
	
	/**2.x userOff
	 * 查看全部商务信息
	 * @return
	 */
	@RequestMapping("/taskFromAll")
	@ResponseBody
	public Msg getTaskFromAll(){
		//无条件查询所有信息
		List<TaskFrom> getTaskFromAll = taskFromService.getTaskFromAll();
		return Msg.success().add("taskAllList", getTaskFromAll);
	}
	
	/**2.x userOff
	 * 查看某个商务活动的信息
	 * @return 
	 */
	@RequestMapping("/getTaskFromOne")
	@ResponseBody
	public Msg getTaskFromOne(TaskFrom taskFrom){
		//查看某个商务活动的信息
		List<TaskFrom> getTaskFromByConditions = taskFromService.getTaskFromByConditions(taskFrom);
		System.out.println(getTaskFromByConditions);
		return Msg.success().add("taskOneList", getTaskFromByConditions);
	}
	
	/**3.0 userOn
	 * 商务任务录入
	 * @return 
	 */
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	@ResponseBody
	public Msg insertSelective(TaskFrom taskFrom,HttpSession session){
		//查看session中的user对象
		SysUser SysUser =(SysUser) session.getAttribute("user");
		if(SysUser==null){
			//SysUser信息为空
			return Msg.fail().add("resMsg", "session中SysUser信息为空");
		}else{
			//SysUser信息不为空
			System.out.println("taskFrom:"+taskFrom);
			String nowtime = DateUtil.strTime14s();
			taskFrom.setTaskCreatime(nowtime);
			taskFrom.setTaskUpdatetime(nowtime);
			int intResult = taskFromService.insertSelective(taskFrom);
			System.out.println(intResult);
			return Msg.success().add("resMsg", "录入成功");
		}
	}

	/**4.0 userOn
	 * 删除本条记录delete
	 * @param	TaskFrom
	 * @return
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(TaskFrom taskFrom,HttpSession session){
		//查看session中的user对象
		SysUser SysUser =(SysUser) session.getAttribute("user");
		if(SysUser==null){
			//SysUser信息为空
			return Msg.fail().add("resMsg", "session中SysUser信息为空");
		}else{
			//SysUser信息为不空
			int taskIdInt = taskFrom.getTaskId();
			int intResult = taskFromService.deleteByPrimaryKey(taskIdInt);
			System.out.println(intResult);
			return Msg.success().add("resMsg", "删除成功");
		}
	}
	
	/**5.0 userOn
	 * 本条记录update
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/update",method=RequestMethod.POST)
	@ResponseBody
	public Msg update(TaskFrom taskFrom,HttpSession session){
		//查看session中的user对象
		SysUser SysUser =(SysUser) session.getAttribute("user");
		if(SysUser==null){
			//SysUser信息为空
			return Msg.fail().add("resMsg", "session中SysUser信息为空");
		}else{
			String taskNowtime = DateUtil.strTime14();
			taskFrom.setTaskUpdatetime(taskNowtime);
			//确认更新
			int intResult = taskFromService.updateByPrimaryKeySelective(taskFrom);
			System.out.println(intResult);
			return Msg.success().add("resMsg", "更新成功");
		}
	}
}
