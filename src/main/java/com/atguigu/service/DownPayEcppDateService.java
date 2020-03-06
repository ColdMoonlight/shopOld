package com.atguigu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.bean.DownPayEcppDate;
import com.atguigu.dao.DownPayEcppDateMapper;

@Service
public class DownPayEcppDateService {
	
	@Autowired
	DownPayEcppDateMapper downPayEcppDateMapper;
	
	public List<DownPayEcppDate> selectHighPayEcppList(DownPayEcppDate downPayEcppDateReq) {
		List<DownPayEcppDate>  mlfrontPayInfoList = downPayEcppDateMapper.selectHighPayEcppList(downPayEcppDateReq);
		return mlfrontPayInfoList;
	}
	
}
