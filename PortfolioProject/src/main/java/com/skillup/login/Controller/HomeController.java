package com.skillup.login.Controller;


import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.codehaus.jackson.map.ObjectMapper;
import com.google.gson.Gson;
import com.skillup.Vo.vo.ResponseVO;
import com.skillup.Vo.vo.loginVo;
import com.skillup.common.CommonUtil;
import com.skillup.common.GetWeather;
import com.skillup.common.SMTPController;
import com.skillup.common.SecurityUtil;
import com.skillup.login.ServiceImp.CommonImp;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Resource(name = "commonService")
	CommonImp service;
	
	
	@Autowired
	private HttpSession session;
   
	Map<String, Object> map = null; 
	loginVo vo ;
	
	ModelAndView mav; 
	
	/** 메인페이지
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		mav = new ModelAndView();
		try {
			SMTPController.RegisterUser();
			if((String)session.getAttribute("ID") != null ){
				mav.setViewName("portal/mainPortal/mainPage");
				return mav;
			}else{
				mav.setViewName("portal/common/commonLogin");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return mav;
	}
	
	/** 회원가입창 이동
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/portal/common/joinAction.do",method =RequestMethod.GET)
	public String commonJoin(Model model) throws Exception{
		 List data = service.GetList();
		 
		 model.addAttribute("Data", data);
		
		return "portal/common/commonJoin";
	}
	
	/** 아이디체크
	 * @param loginVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/portal/common/idCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String commonIdCheck(@RequestBody loginVo loginVo) throws Exception {
		ResponseVO ResponseVO = new ResponseVO();
		Gson gson = new Gson();
		int result = 0;
	    HashMap<String,Object> map = new HashMap<String, Object>();
        if(result == 1) {
           ResponseVO.setSuccess(true);  
           ResponseVO.setMsg("Available ID");
        }else {
           ResponseVO.setSuccess(false);  
           ResponseVO.setMsg("Existing ID");
        }                    
		return gson.toJson(ResponseVO);
	}
	
	/** 이메일체크
	 * @param loginVo
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/portal/common/emailCheck.do", method = RequestMethod.POST)
	@ResponseBody
	public String emailCheck(@RequestBody loginVo loginVo) throws Exception {
		ResponseVO ResponseVO = new ResponseVO();
		Gson gson = new Gson();
		int result = 0;
	    HashMap<String,Object> map = new HashMap<String, Object>();
        if(result == 1) {
           ResponseVO.setSuccess(true);  
           ResponseVO.setMsg("Available Email");
        }else {
           ResponseVO.setSuccess(false);  
           ResponseVO.setMsg("Existing Email");
        }                    
		return gson.toJson(ResponseVO);
	}
	
	/** 회원가입
	 * @param vo
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/portal/common/joinSite.do", method = RequestMethod.POST)	
	public @ResponseBody String join(loginVo vo,HttpServletRequest request) throws Exception{
		ResponseVO ResponseVO = new ResponseVO();
		Gson gson = new Gson();
		SecurityUtil util = new SecurityUtil();
		if(CommonUtil.isNumeric(vo.getId())) {
			ResponseVO.setSuccess(false);
			ResponseVO.setMsg("Plz Write Id Only Number");
			return gson.toJson(ResponseVO);
		}
		
		String pwd = util.encryptSHA256(request.getParameter("pwd"));
		if(!CommonUtil.NullCheck(pwd)) {
			ResponseVO.setSuccess(false);
			ResponseVO.setMsg("Error Create PWD");
			return gson.toJson(ResponseVO);
		}
		vo.setPwd(pwd);
		int a = service.JoinPage(vo);
		if(a == 1) {			
			 ResponseVO.setSuccess(true);  
	         ResponseVO.setMsg("Success Creating Id");
		}else {
			ResponseVO.setSuccess(true);  
			ResponseVO.setMsg("Error Creating Id");
		}
		return gson.toJson(ResponseVO);
	}
	
	
	/** 로그인 
	 * @param vo
	 * @param model
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/portal/common/LogOnSite.do", method = RequestMethod.POST)
	public String login(loginVo vo, Model model,HttpServletRequest request) throws Exception{
		ResponseVO ResponseVO = new ResponseVO();
		Gson gson = new Gson();
		SecurityUtil util = new SecurityUtil();
		String rawpassword = request.getParameter("pwd");
		String p1 = util.encryptSHA256(rawpassword);
		vo.setPwd(p1);
		List result = service.GetUserInfo(vo);
		boolean isEmpty = result.isEmpty();
		if(isEmpty == false){
			 HashMap<String, String> userInfo = (HashMap<String,String>)result.get(0);
			 if(userInfo.get("valid").equals("X")) {
				 
				 SimpleDateFormat fmt=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
			     
				    String sDate=fmt.format(userInfo.get("user_join_dt")); 
					String USERTYPE = (String) userInfo.get("code"); //부서
					String ID = (String) userInfo.get("user_id"); //id 
					String EMAIL = (String) userInfo.get("user_email"); //email
					String NAME = (String) userInfo.get("user_name"); //NAME
					String Level = (String) userInfo.get("level"); //NAME
					session.setAttribute("joinDate",sDate);  //가입날짜
					session.setAttribute("dpCode",USERTYPE);
					session.setAttribute("ID",ID);
					session.setAttribute("EMAIL",EMAIL);
					session.setAttribute("NAME",NAME);
					session.setAttribute("level",Level);
					
					InetAddress local = InetAddress.getLocalHost();
					String ip = local.getHostAddress();			
					Date date = new Date();			 

					vo.setUserIp(ip);
					vo.setDate(date);
					vo.setId(ID);
					int Type = 0;
					int a = service.InsertLogin(vo,Type);
					
					
			 }else {
				 model.addAttribute("error", "재직 중이지 않는 사원");
				 return "portal/common/commonLogin"; 
			 }
		}else {
			model.addAttribute("error", "아이디 체크 바람");
			 return "portal/common/commonLogin";
		}
		return "portal/mainPortal/mainPage";
	}
	
	/**
	 * 로그 아웃 
	 * @param vo
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/portal/common/logoutAction.do", method = RequestMethod.POST)
	public ModelAndView logtOut(loginVo vo,HttpServletRequest request,ModelAndView model) throws Exception{
		try{
			Date date = new Date();			
			vo.setDate(date);
			vo.setId((String)session.getAttribute("ID"));
			int Type = 1;
			int a = service.InsertLogin(vo,Type);
	        session.invalidate();    
	        mav = new ModelAndView("redirect:/");
		}catch(Exception e ){
			logger.error("logtOut -> logtOut"+e);
		}
			return mav;
	}
	
	@RequestMapping(value = "/portal/common/GetWeather.do", method = RequestMethod.POST)	
	public @ResponseBody String GetWeather() throws Exception {
		String weather = GetWeather.GetWeather("강남구");
		ResponseVO ResponseVO = new ResponseVO();
		Gson gson = new Gson();
		HashMap<String,Object> jsonObject = new ObjectMapper().readValue(weather, HashMap.class);
		boolean result = jsonObject.isEmpty();
		if( result == false) {
			ArrayList results = (ArrayList) jsonObject.get("list");
			System.out.println(results);
			HashMap<String,Object> metadata = (HashMap<String, Object>) results.get(0);
			ResponseVO.setSuccess(true);  
			ResponseVO.setMsg("Weather Update Good");
			ResponseVO.setData(metadata);
		}else {
			ResponseVO.setSuccess(false);  
			ResponseVO.setMsg("Weather Update Fail");
		}
		return gson.toJson(ResponseVO);
	}
}
