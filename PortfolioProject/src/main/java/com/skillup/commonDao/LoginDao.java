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
@Repository("dashboardDAO")
public class LoginDao {
	@Autowired
	private SqlSessionTemplate  sqlsession;

	
	public List GetList() throws Exception{
		return sqlsession.selectList("commonLogin.GetList");
	}
	
	/**
	 * idCheck
	 * @param vo
	 * @return int
	 * @throws Exception
	 */
	public int idCheck(loginVo vo) throws Exception{
		return sqlsession.insert("commonLogin.JoinPage", vo);
	}
	
	/**
	 * emailCheck
	 * @param vo
	 * @return int
	 * @throws Exception
	 */
	public int emailCheck(loginVo vo) throws Exception{
		return sqlsession.insert("commonLogin.JoinPage", vo);
	}
	
	/**
	 * 회원 가입 
	 * @param vo
	 * @return int
	 * @throws Exception
	 */
	public int JoinPage(loginVo vo) throws Exception{
		return sqlsession.insert("commonLogin.JoinPage", vo);
	}
	
	/**
	 * 로그인 유저 인포
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	public Map<String, String> GetUserInfo(loginVo vo) throws Exception{
		return sqlsession.selectOne("commonLogin.GetUserInfo", vo);
	}
	
	public int InsertLogin(loginVo vo) throws Exception{
		return sqlsession.insert("commonLogin.InsertLogin",vo);
	}
	
	public int InsertLogout(loginVo vo) throws Exception{
		return sqlsession.update("commonLogin.InsertLogout", vo);
	}
}
