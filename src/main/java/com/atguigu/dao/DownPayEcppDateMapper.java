package com.atguigu.dao;

import com.atguigu.bean.DownPayEcppDate;
import java.util.List;

public interface DownPayEcppDateMapper {

	List<DownPayEcppDate> selectHighPayEcppList(DownPayEcppDate downPayEcppDateReq);
    
	
}