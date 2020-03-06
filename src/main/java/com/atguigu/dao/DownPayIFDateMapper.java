package com.atguigu.dao;

import com.atguigu.bean.DownPayIFDate;
import java.util.List;

public interface DownPayIFDateMapper {

	List<DownPayIFDate> selectHighPayIFList(DownPayIFDate downPayIFDateReq);
    
}