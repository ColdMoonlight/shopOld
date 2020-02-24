package com.atguigu.controller.high;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.atguigu.bean.DownPayEcppDate;
import com.atguigu.bean.DownPayIFDate;
import com.atguigu.bean.MlfrontPayInfo;
import com.atguigu.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.atguigu.service.DownPayEcppDateService;
import com.atguigu.service.DownPayIFDateService;
import com.atguigu.service.MlfrontPayInfoService;
import com.atguigu.utils.DateUtil;

@Controller
@RequestMapping("/HighPayInfo")
public class HighPayInfoController {
		
	@Autowired
	MlfrontPayInfoService mlfrontPayInfoService;
	
	
	@Autowired
	DownPayIFDateService downPayIFDateService;
	
	@Autowired
	DownPayEcppDateService downPayEcppDateService;
	
	/**
	 * 1.0	UseNow	0505
	 * toMlfrontPayInfoSuccess列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlfrontPayInfoSuccess")
	public String toMlfrontPayInfoSuccess() throws Exception{
	
		return "mfront/paySuccess";
	}
	
	/**
	 * 2.0	UseNow	0505
	 * toMlfrontPayInfofail列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlfrontPayInfofail")
	public String toMlfrontPayInfofail() throws Exception{
	
		return "mfront/payFail";
	}
	
	/**
	 * 3.0	UseNow	0505
	 * toMlfrontPayInfoList列表页面
	 * @param jsp
	 * @return 
	 * */
	@RequestMapping("/toMlbackPayInfoList")
	public String toMlbackPayInfoList() throws Exception{
	
		return "back/mlbackPayInfoPage";
	}
	
	/**
	   * 3.0  UseNow  0505
	   * toMlfrontPayInfoList列表页面
	   * @param jsp
	   * @return 
	   * */
	  @RequestMapping("/toMlbackPayInfohighList")
	  public String toMlbackPayInfohighList() throws Exception{
	  
	    return "back/high/mlbackPayInfohighPage";
	  }
	
	/**11.0	useOn	0505
	 * 分类MlfrontReview列表分页list数据
	 * @param pn,
	 * Integer payinfoStatus;
	 * String payinfoCreatetime;
	 * String payinfoMotifytime;
	 * @return
	 */
	@RequestMapping(value="/selectHighPayInfoListBySearch",method=RequestMethod.POST)
	@ResponseBody
	public Msg selectHighPayInfoListBySearch(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			@RequestParam(value = "payinfoStatus") Integer payinfoStatus,
			@RequestParam(value = "payinfoCreatetime") String payinfoCreatetime,
			@RequestParam(value = "payinfoMotifytime") String payinfoMotifytime,
			HttpSession session) {
		
		//初始化请求参数
		MlfrontPayInfo mlfrontPayInfoReq = new MlfrontPayInfo();
		//初始化请求参数
		if(payinfoStatus==999){
			mlfrontPayInfoReq.setPayinfoStatus(null);
		}else{
			mlfrontPayInfoReq.setPayinfoStatus(payinfoStatus);
		}
		mlfrontPayInfoReq.setPayinfoCreatetime(payinfoCreatetime);
		mlfrontPayInfoReq.setPayinfoMotifytime(payinfoMotifytime);
		int PagNum = 20;
		PageHelper.startPage(pn, PagNum);
		List<MlfrontPayInfo> mlfrontPayInfoList = mlfrontPayInfoService.selectHighPayInfoListBySearch(mlfrontPayInfoReq);
		
		DownPayIFDate downPayIFDateReq = new DownPayIFDate();
		
		downPayIFDateReq.setPayinfoCreatetime(payinfoCreatetime);
		downPayIFDateReq.setPayinfoMotifytime(payinfoMotifytime);
		
		List<DownPayIFDate> highPayIFList= downPayIFDateService.selectHighPayIFList(downPayIFDateReq);
		
		PageInfo page = new PageInfo(mlfrontPayInfoList, PagNum);
		return Msg.success().add("pageInfo", page).add("highPayIFList", highPayIFList);
		
	}
	
	@RequestMapping(value="/exportPayInfoIF",method=RequestMethod.GET)
	public void exportPayInfoIF(HttpServletResponse rep,HttpServletRequest res,
			@RequestParam(value = "payinfoStatus") Integer payinfoStatus,
			@RequestParam(value = "payinfoCreatetime") String payinfoCreatetime,
			@RequestParam(value = "payinfoMotifytime") String payinfoMotifytime,
			HttpSession session){
		
		rep.setContentType("application/octet-stream");
		
		String nowTime = DateUtil.strTime14();
		rep.setHeader("Content-Disposition", "attachment;filename="+nowTime+"payinfoIf.xls");
		
		HSSFWorkbook wb = new HSSFWorkbook();
		
		HSSFSheet sheet = wb.createSheet("sheet0");
		
		HSSFRow row = sheet.createRow(0);
		
		HSSFCell cell = row.createCell(0);
		
		DownPayIFDate downPayIFDateReq = new DownPayIFDate();
		
		downPayIFDateReq.setPayinfoCreatetime(payinfoCreatetime);
		downPayIFDateReq.setPayinfoMotifytime(payinfoMotifytime);
		
		if(payinfoStatus ==999){
			downPayIFDateReq.setPayinfoStatus(null);
		}else{
			downPayIFDateReq.setPayinfoStatus(payinfoStatus);
		}
		
		List<DownPayIFDate> highPayIFList= downPayIFDateService.selectHighPayIFList(downPayIFDateReq);
		
		cell.setCellValue("num");
	    cell = row.createCell(1);
		cell.setCellValue("payInfo_id");
	    cell = row.createCell(2);
	    cell.setCellValue("payInfo_oid");
	    cell = row.createCell(3);
	    cell.setCellValue("payInfo_money");
	    cell = row.createCell(4);
	    cell.setCellValue("payInfo_status");
	    cell = row.createCell(5);
	    cell.setCellValue("order_id");
	    cell = row.createCell(6);
	    cell.setCellValue("addressinfo_id");
	    cell = row.createCell(7);
	    cell.setCellValue("address_email");
	    cell = row.createCell(8);
	    cell.setCellValue("payInfo_createTime");
	    cell = row.createCell(9);
	      
	    DownPayIFDate downPayIFDateOne = new DownPayIFDate();
	    for (int i = 0; i < highPayIFList.size(); i++) {
	    	downPayIFDateOne = highPayIFList.get(i);
	        row = sheet.createRow(i+1);
	        row.createCell(0).setCellValue(i+1);
	        row.createCell(1).setCellValue(downPayIFDateOne.getPayinfoId());
	        row.createCell(2).setCellValue(downPayIFDateOne.getPayinfoOid());
	        row.createCell(3).setCellValue(downPayIFDateOne.getPayinfoMoney()+"");
	        row.createCell(4).setCellValue(downPayIFDateOne.getPayinfoStatus());
	        row.createCell(5).setCellValue(downPayIFDateOne.getMlfrontOrder().getOrderId());
	        row.createCell(6).setCellValue(downPayIFDateOne.getMlfrontOrder().getAddressinfoId());
	        row.createCell(7).setCellValue(downPayIFDateOne.getMlfrontAddress().getAddressEmail());
	        row.createCell(8).setCellValue(downPayIFDateOne.getPayinfoCreatetime());
	    }
		try {
			OutputStream out =rep.getOutputStream();
			wb.write(out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping(value="/exportPayInfoEcpp",method=RequestMethod.GET)
	public void exportPayInfoEcpp(HttpServletResponse rep,HttpServletRequest res,
			@RequestParam(value = "payinfoStatus") Integer payinfoStatus,
			@RequestParam(value = "payinfoCreatetime") String payinfoCreatetime,
			@RequestParam(value = "payinfoMotifytime") String payinfoMotifytime,
			HttpSession session){
		
		rep.setContentType("application/octet-stream");
		
		String nowTime = DateUtil.strTime14();
		rep.setHeader("Content-Disposition", "attachment;filename="+nowTime+"payinfoEcpp.xls");
		
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("sheet0");
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		
		DownPayEcppDate downPayEcppDateReq = new DownPayEcppDate();
		downPayEcppDateReq.setPayinfoCreatetime(payinfoCreatetime);
		downPayEcppDateReq.setPayinfoMotifytime(payinfoMotifytime);
		if(payinfoStatus==999){
			downPayEcppDateReq.setPayinfoStatus(null);
		}else{
			downPayEcppDateReq.setPayinfoStatus(payinfoStatus);
		}
		
		List<DownPayEcppDate> highPayEcppList = downPayEcppDateService.selectHighPayEcppList(downPayEcppDateReq);
		
		cell.setCellValue("num");
	    cell = row.createCell(1);
		cell.setCellValue("payInfo_id");
	    cell = row.createCell(2);
	    cell.setCellValue("payInfo_createTime");
	    cell = row.createCell(3);
	    cell.setCellValue("payInfo_plateNum");
	    cell = row.createCell(4);
	    cell.setCellValue("payInfo_status");
	    cell = row.createCell(5);
	    cell.setCellValue("address_userFirstName");
	    cell = row.createCell(6);
	    cell.setCellValue("address_userLastName");
	    cell = row.createCell(7);
	    cell.setCellValue("address_email");
	    cell = row.createCell(8);
	    cell.setCellValue("address_detail");
	    cell = row.createCell(9);
	    cell.setCellValue("address_province");
	    cell = row.createCell(10);
	    cell.setCellValue("address_city");
	    cell = row.createCell(11);
	    cell.setCellValue("address_post");
	    cell = row.createCell(12);
	    cell.setCellValue("address_countryAll");
	    cell = row.createCell(13);
	    cell.setCellValue("address_country");
	    cell = row.createCell(14);
	    
	    cell.setCellValue("address_telephone");
	    cell = row.createCell(15);
	    cell.setCellValue("orderItem_pSku_nameStr");
	    cell = row.createCell(16);
	    cell.setCellValue("product_seo");
	    cell = row.createCell(17);
	    cell.setCellValue("orderItem_pSku_number");
	    cell = row.createCell(18);
	    cell.setCellValue("payInfo_money");
	    cell = row.createCell(19);
	    cell.setCellValue("order_buy_mess");
	    cell = row.createCell(20);
	    
	    DownPayEcppDate downPayEcppDateOne = new DownPayEcppDate();
	    for (int i = 0; i < highPayEcppList.size(); i++) {
	    	downPayEcppDateOne = highPayEcppList.get(i);
	        row = sheet.createRow(i+1);
	        row.createCell(0).setCellValue(i+1);
	        row.createCell(1).setCellValue(downPayEcppDateOne.getPayinfoId());
	        row.createCell(2).setCellValue(downPayEcppDateOne.getPayinfoCreatetime());
	        row.createCell(4).setCellValue(downPayEcppDateOne.getPayinfoPlateNum());
	        row.createCell(3).setCellValue(downPayEcppDateOne.getPayinfoStatus()+"");
	        row.createCell(5).setCellValue(downPayEcppDateOne.getMlfrontAddress().getAddressUserfirstname());
	        row.createCell(6).setCellValue(downPayEcppDateOne.getMlfrontAddress().getAddressUserlastname());
	        row.createCell(7).setCellValue(downPayEcppDateOne.getMlfrontAddress().getAddressEmail());
	        row.createCell(8).setCellValue(downPayEcppDateOne.getMlfrontAddress().getAddressDetail());
	        row.createCell(9).setCellValue(downPayEcppDateOne.getMlfrontAddress().getAddressProvince());
	        row.createCell(10).setCellValue(downPayEcppDateOne.getMlfrontAddress().getAddressCity());
	        row.createCell(11).setCellValue(downPayEcppDateOne.getMlfrontAddress().getAddressPost());
	        row.createCell(12).setCellValue(downPayEcppDateOne.getMlfrontAddress().getAddressCountryAll());
	        row.createCell(13).setCellValue(downPayEcppDateOne.getMlfrontAddress().getAddressCity());
	        row.createCell(14).setCellValue(downPayEcppDateOne.getMlfrontAddress().getAddressTelephone());
	        row.createCell(15).setCellValue(downPayEcppDateOne.getMlfrontOrderItem().getOrderitemPskuNamestr());
	        row.createCell(16).setCellValue(downPayEcppDateOne.getMlbackProduct().getProductSeo());
	        row.createCell(17).setCellValue(downPayEcppDateOne.getMlfrontOrderItem().getOrderitemPskuNumber());
	        row.createCell(18).setCellValue(downPayEcppDateOne.getPayinfoMoney()+"");
	        row.createCell(19).setCellValue(downPayEcppDateOne.getMlfrontOrder().getOrderBuyMess());
	        
	    }
		try {
			OutputStream out =rep.getOutputStream();
			wb.write(out);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
