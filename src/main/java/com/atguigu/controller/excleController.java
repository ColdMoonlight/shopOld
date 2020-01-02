package com.atguigu.controller;

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

import com.atguigu.bean.MlfrontPayInfo;
import com.atguigu.service.MlfrontPayInfoService;
import com.atguigu.utils.DateUtil;

@Controller
@RequestMapping("/excle")
public class excleController {
	
	@Autowired
	MlfrontPayInfoService mlfrontPayInfoService;
	
	
	@RequestMapping(value="/exportPayInfo",method=RequestMethod.GET)
	public void export(HttpServletResponse rep,HttpServletRequest res,HttpSession session){
		rep.setContentType("application/octet-stream");
		
		//String nowTime = DateUtil.strTime8();
		String nowTime = DateUtil.strDate8();
		//rep.setHeader("Content-Disposition", "attachment;filename=export.xls");
		rep.setHeader("Content-Disposition", "attachment;filename="+nowTime+"payinfo.xls");
		
		
		HSSFWorkbook wb = new HSSFWorkbook();
		
		HSSFSheet sheet = wb.createSheet("sheet0");
		
		HSSFRow row = sheet.createRow(0);
		
		HSSFCell cell = row.createCell(0);
		
//		List<MLbackEcppVO> EcppVOList = new ArrayList<MLbackEcppVO>();
//		String starttime="";
//		String endtime="";
//		EcppVOList = getEcppVOList(starttime,endtime);
		List<MlfrontPayInfo> list = mlfrontPayInfoService.selectMlfrontPayInfoAll();
		
		cell.setCellValue("number");
        cell = row.createCell(1);
        cell.setCellValue("PayinfoId");
        cell = row.createCell(2);
        cell.setCellValue("PayinfoOid");
        cell = row.createCell(3);
        cell.setCellValue("PayinfoMoney");
        cell = row.createCell(4);
        for (int i = 0; i < list.size(); i++) {
            row = sheet.createRow(i+1);
            row.createCell(0).setCellValue(i+1);
            row.createCell(1).setCellValue(list.get(i).getPayinfoId());
            row.createCell(2).setCellValue(list.get(i).getPayinfoOid());
            row.createCell(3).setCellValue(list.get(i).getPayinfoMoney()+"");
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


//	private List<MLbackEcppVO> getEcppVOList(String starttime, String endtime) {
//		List<MLbackEcppVO> EcppVOList = new ArrayList<MLbackEcppVO>();
//		
//		
//		//封装参数String starttime, String endtime
//		return EcppVOList;
//	}
//	

}
