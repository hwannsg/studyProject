package com.skillup.P1.ServiceImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.skillup.P1.Service.P1Service;
import com.skillup.Vo.vo.loginVo;
import com.skillup.commonDao.P1Dao;

@Service("P1ServiceImp")
public class P1ServiceImp implements P1Service{
	List list;
	private static final Logger logger = LoggerFactory.getLogger(P1ServiceImp.class);
	@Resource(name = "P1Dao")
	P1Dao dao;
	
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

}
