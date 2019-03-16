package com.skillup.P1.Controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
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

import com.skillup.P1.ServiceImp.P1ServiceImp;
import com.skillup.Vo.vo.loginVo;
import com.skillup.commonDao.P1Dao;
import com.skillup.login.Controller.HomeController;

@Controller
public class P1Controller {
private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@Resource(name = "P1ServiceImp")
	P1ServiceImp service;
	

	
	@Autowired
	private HttpSession session;
   
	Map<String, Object> map = null; 
	loginVo vo ;
	
	ModelAndView mav; 
	
	@RequestMapping(value = "/portal/P1/P1Action.do", method = RequestMethod.POST)
	public ModelAndView P1home(Model model) throws Exception{
		mav = new ModelAndView();
		mav.setViewName("portal/P1/P1_V1.only");
		return mav;
	}
	@RequestMapping(value = "/portal/P1/P1AjaxList.do",method = RequestMethod.POST)
	@ResponseBody
	public Object p2001ListAjax(ModelAndView model,loginVo vo,@RequestBody String  date1) throws Exception {			
		Object data = null;
		try{
			vo.setId((String)session.getAttribute("ID"));
			List  a = service.selectCalendarList(vo);
			if(a.isEmpty() ==false){
				data = a;	
			}
			mav.addObject("data", a);
		}catch(Exception e){
			logger.error("P2001Controller -> p2001Page" + e);
		}
		return data;
	}
}
