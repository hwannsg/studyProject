package com.skillup.login.ServiceImp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.skillup.Vo.vo.loginVo;
import com.skillup.commonDao.LoginDao;
import com.skillup.login.Controller.HomeController;
import com.skillup.login.Service.CommonService;
@Service("commonService")
public class CommonImp implements CommonService {
	List<Map<String, String>> list;
	HashMap<String, String> data;
	private static final Logger logger = LoggerFactory.getLogger(CommonImp.class);
	@Resource(name = "dashboardDAO")
	LoginDao dao;
	
	
	@Override
	public List GetList() throws Exception {
		list = new ArrayList<Map<String, String>>();
		try {
			list = dao.GetList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public int idCheck(loginVo vo) throws Exception {
		int resultType = 0;
		try {
			resultType = dao.idCheck(vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultType;
	}


	@Override
	public int emailCheck(loginVo vo) throws Exception {
		int resultType = 0;
		try {
			resultType = dao.emailCheck(vo);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return resultType;
	}


	@Override
	public int JoinPage(loginVo vo) throws Exception {
		int resultType = 0;
		try {
			resultType = dao.JoinPage(vo);
		}catch(Exception e) {
				logger.error("JoinPage ->"+e);
		}
		return resultType;
	}


	@Override
	public List GetUserInfo(loginVo vo) throws Exception {
		try {
			list = new ArrayList<Map<String, String>>();
			list.add(dao.GetUserInfo(vo));
		}catch(Exception e) {
				logger.error("JoinPage ->"+e);
		}
		return list;
	}


	@Override
	public int InsertLogin(loginVo vo,int msg) throws Exception {
		int resultType = 0;
		try {
			if(msg == 0) {
				logger.info("loginVo->InsertLogin");
				resultType = dao.InsertLogin(vo);
			}else {
				logger.info("loginVo->InsertLogout");
				resultType = dao.InsertLogout(vo);
			}
		}catch (Exception e) {
			logger.error("JoinPage ->"+e);
		}
		return resultType;
	}

}
