package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.DownPayIFDate;
import com.atguigu.bean.MlfrontPayInfo;
import com.atguigu.dao.DownPayIFDateMapper;

@Service
public class DownPayIFDateService {
	
	@Autowired
	DownPayIFDateMapper downPayIFDateMapper;
	
	public List<DownPayIFDate> selectHighPayIFList(DownPayIFDate downPayIFDateReq) {
		List<DownPayIFDate>  mlfrontPayInfoList = downPayIFDateMapper.selectHighPayIFList(downPayIFDateReq);
		return mlfrontPayInfoList;
	}
	
}
