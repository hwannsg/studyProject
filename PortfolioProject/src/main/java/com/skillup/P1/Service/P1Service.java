package com.skillup.P1.Service;

import java.util.List;

import com.skillup.Vo.vo.loginVo;

public interface P1Service {
	List selectCalendarList(loginVo vo) throws Exception;
}
