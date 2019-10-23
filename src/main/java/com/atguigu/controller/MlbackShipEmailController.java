package com.atguigu.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.atguigu.bean.MlbackAdmin;
import com.atguigu.bean.MlbackShipEmail;
import com.atguigu.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.MlbackAdminService;
import com.atguigu.service.MlbackShipEmailService;
import com.atguigu.utils.DateUtil;


@Controller
@RequestMapping("/MlbackShipEmail")
public class MlbackShipEmailController {
		
	@Autowired
	MlbackShipEmailService mlbackShipEmailService;
	
	@Autowired
	MlbackAdminService mlbackAdminService;
	
	/**
	 * 1.0	useOn	0505
	 * to_MlbackShipEmail列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackShipEmailPage")
	public String toMlbackShipEmailPage() throws Exception{
	
		return "back/mlbackShipEmailPage";
	}
	
	/**2.0	useOn	0505
	 * 分类MlbackShipEmail列表分页list数据
	 * @param pn
	 * @return
	 */
	@RequestMapping(value="/getMlbackShipEmailListByPage")
	@ResponseBody
	public Msg getMlbackShipEmailListByPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn,HttpSession session) {
		MlbackAdmin mlbackAdmin =(MlbackAdmin) session.getAttribute("adminuser");
//		if(mlbackAdmin==null){
//			//SysUsers对象为空
//			return Msg.fail().add("resMsg", "session中adminuser对象为空");
//		}else{
		int PagNum = 20;
			PageHelper.startPage(pn, PagNum);
			List<MlbackShipEmail> mlbackShipEmailList = mlbackShipEmailService.selectMlbackShipEmailAll();
			PageInfo page = new PageInfo(mlbackShipEmailList, PagNum);
			return Msg.success().add("pageInfo", page);
//		}
	}
	
	/**3.0	useOn	0505
	 * MlbackShipEmail	insert
	 * @param MlbackShipEmail
	 */
	@RequestMapping(value="/save",method=RequestMethod.POST)
	@ResponseBody
	public Msg saveSelective(HttpServletResponse rep,HttpServletRequest res,@RequestBody MlbackShipEmail mlbackShipEmail){
		//接受参数信息
		System.out.println("mlbackShipEmail:"+mlbackShipEmail);
		//取出id
		System.out.println(1);
		Integer showareaIdId = mlbackShipEmail.getShipemailId();
		Integer shipemailNameth = mlbackShipEmail.getShipemailNameth();
		String shipemailName ="";
		if(shipemailNameth==1){
			shipemailName="UPS";
		}else if(shipemailNameth==2){
			shipemailName="FEDEX";
		}else if(shipemailNameth==3){
			shipemailName="4PX";
		}else if(shipemailNameth==4){
			shipemailName="DHL";
		}else if(shipemailNameth==5){
			shipemailName="Aramex";
		}else if(shipemailNameth==6){
			shipemailName="TNT";
		}else if(shipemailNameth==7){
			shipemailName="DPEX";
		}else if(shipemailNameth==8){
			shipemailName="华磊";
		}else if(shipemailNameth==9){
			shipemailName="更多";
		}
		mlbackShipEmail.setShipemailName(shipemailName);
		String nowTime = DateUtil.strTime14s();
		mlbackShipEmail.setShipemailMotifytime(nowTime);
		if(showareaIdId==null){
			//无id，insert
			mlbackShipEmail.setShipemailCreatetime(nowTime);
			int intResult = mlbackShipEmailService.insertSelective(mlbackShipEmail);
			System.out.println(intResult);
			return Msg.success().add("resMsg", "插入成功");
		}else{
			//有id，update
			int intResult = mlbackShipEmailService.updateByPrimaryKeySelective(mlbackShipEmail);
			System.out.println(intResult);
			return Msg.success().add("resMsg", "更新成功");
		}		
	}
	
	/**4.0	useOn	0505
	 * MlbackShipEmail	delete
	 * @param id
	 */
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	@ResponseBody
	public Msg delete(@RequestBody MlbackShipEmail mlbackShipEmail){
		//接收id信息
		int showareaIdId = mlbackShipEmail.getShipemailId();
		int intResult = mlbackShipEmailService.deleteByPrimaryKey(showareaIdId);
		return Msg.success().add("resMsg", "delete success");
	}
	
	/**
	 * 5.0	useOn	0505
	 * 查看单条详情
	 * @param getOneMlbackShipEmailDetail
	 * @return 
	 */
	@RequestMapping(value="/getOneMlbackShipEmailDetail",method=RequestMethod.POST)
	@ResponseBody
	public Msg getOneMlbackShipEmailDetail(@RequestParam(value = "shipemailId") Integer shipemailId){
		
		//接受showareaId
		MlbackShipEmail mlbackShipEmailReq = new MlbackShipEmail();
		mlbackShipEmailReq.setShipemailId(shipemailId);
		//查询本条
		List<MlbackShipEmail> mlbackShipEmailResList =mlbackShipEmailService.selectMlbackShipEmailById(mlbackShipEmailReq);
		MlbackShipEmail mlbackShipEmailOne = new MlbackShipEmail();
		if(mlbackShipEmailResList.size()>0){
			mlbackShipEmailOne =mlbackShipEmailResList.get(0);
		}else{
			mlbackShipEmailOne = null;
		}
		return Msg.success().add("resMsg", "查看单条mlbackShipEmailOne的详情细节完毕")
					.add("mlbackShipEmailOne", mlbackShipEmailOne);
	}
	
	/**
	 * 6.0	useOn	0505
	 * 查看单条详情
	 * @param getOnemlbackShipEmailDetail
	 * @return 
	 */
//	@RequestMapping(value="/getmlbackShipEmailOne",method=RequestMethod.POST)
//	@ResponseBody
//	public Msg getmlbackShipEmailOne(@RequestParam(value = "showareaNumth") Integer showareaNumth){
//		
//		//接受showareaId
//		mlbackShipEmail mlbackShipEmailReq = new mlbackShipEmail();
//		mlbackShipEmailReq.setShowareaNumth(showareaNumth);
//		mlbackShipEmailReq.setShowareaStatus(1);//使用中
//		//查询本条
//		List<mlbackShipEmail> mlbackShipEmailResList =mlbackShipEmailService.selectmlbackShipEmailByNumthAndStatus(mlbackShipEmailReq);
//		mlbackShipEmail mlbackShipEmailOne = new mlbackShipEmail();
//		if(mlbackShipEmailResList.size()>0){
//			mlbackShipEmailOne =mlbackShipEmailResList.get(0);
//		}else{
//			mlbackShipEmailOne = null;
//		}
//		return Msg.success().add("resMsg", "查看单条mlbackShipEmailOne的详情细节完毕")
//					.add("mlbackShipEmailOne", mlbackShipEmailOne);
//	}
	
}
