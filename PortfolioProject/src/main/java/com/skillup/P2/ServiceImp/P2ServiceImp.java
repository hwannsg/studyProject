package com.skillup.P2.ServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.skillup.P2.Service.P2Service;
import com.skillup.Vo.vo.ScheduleVo;
import com.skillup.Vo.vo.loginVo;
import com.skillup.commonDao.P2Dao;
@Service("P2ServiceImp")
public class P2ServiceImp implements P2Service  {
	
	@Resource(name = "P2DAO")
	P2Dao dao;
	
	List list;
	private static final Logger logger = LoggerFactory.getLogger(P2ServiceImp.class);
	@Override
	public List selectCalendarList(loginVo vo) throws Exception {
		try {
			list = new ArrayList<Map<String, String>>();
			list = dao.selectCalendarList(vo);
		}catch(Exception e) {
				logger.error("selectCalendarList ->"+e);
		}
		return list;
	}
	@Override
	public int InsertSaveList(ScheduleVo vo) throws Exception {
		int a = 0;
		try {
			a = dao.saveList(vo);
		}catch(Exception e) {
				logger.error("selectCalendarList ->"+e);
		}
		return a;
	}
}
