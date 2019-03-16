package com.skillup.P2.Service;

import java.util.List;

import com.skillup.Vo.vo.ScheduleVo;
import com.skillup.Vo.vo.loginVo;

public interface P2Service {
	List selectCalendarList(loginVo vo) throws Exception;
	
	int InsertSaveList(ScheduleVo vo)throws Exception;
}
