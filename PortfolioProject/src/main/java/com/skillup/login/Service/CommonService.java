package com.skillup.login.Service;

import java.util.HashMap;
import java.util.List;

import com.skillup.Vo.vo.loginVo;

public interface CommonService {
	
	List GetList() throws Exception;
	
	int idCheck(loginVo vo) throws Exception;
	
	int emailCheck(loginVo vo) throws Exception;
	
	int JoinPage(loginVo vo) throws Exception;
	
	List GetUserInfo(loginVo vo) throws Exception;
	
	int InsertLogin(loginVo vo,int msg) throws Exception;
	
}
