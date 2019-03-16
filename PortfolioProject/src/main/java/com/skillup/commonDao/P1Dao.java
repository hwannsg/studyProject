package com.skillup.commonDao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skillup.Vo.vo.loginVo;

/**
 * @author ssmic
 *
 */
@Repository("P1Dao")
public class P1Dao {
	@Autowired
	private SqlSessionTemplate  sqlsession;

	public List selectCalendarList(loginVo loginVo) throws Exception{
		return sqlsession.selectList("P1DAO.selectCalendarList", loginVo);
	}
	
}
