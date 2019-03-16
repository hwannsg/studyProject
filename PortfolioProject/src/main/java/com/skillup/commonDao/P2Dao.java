package com.skillup.commonDao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.skillup.Vo.vo.ScheduleVo;
import com.skillup.Vo.vo.loginVo;

/**
 * @author ssmic
 *
 */
@Repository("P2DAO")
public class P2Dao {
	@Autowired
	private SqlSessionTemplate  sqlsession;

	public List selectCalendarList(loginVo loginVo) throws Exception{
		return sqlsession.selectList("P2DAO.selectCalendarList", loginVo);
	}
	
	public int saveList(ScheduleVo vo) throws Exception{
		return sqlsession.insert("P2DAO.saveList", vo);
	}
}
