package com.skillup.P2.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

import com.google.gson.Gson;
import com.skillup.P2.ServiceImp.P2ServiceImp;
import com.skillup.Vo.vo.ResponseVO;
import com.skillup.Vo.vo.ScheduleVo;
import com.skillup.Vo.vo.loginVo;
import com.skillup.common.CommonUtil;

@Controller
public class P2Controller {
	private static final Logger logger = LoggerFactory.getLogger(P2Controller.class);
	@Autowired
	private HttpSession session;
   
	Map<String, Object> map = null; 
	loginVo vo ;
	
	ModelAndView mav; 
	
	@Resource(name = "P2ServiceImp")
	P2ServiceImp service;
	
	
	@RequestMapping(value = "/portal/P2/P2Action.do", method = RequestMethod.POST)
	public ModelAndView P1home(Model model) throws Exception{
		mav = new ModelAndView();
		mav.setViewName("portal/P2/P2_V1.only");
		return mav;
	}
	@RequestMapping(value = "/portal/P2/P2AjaxList.do",method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/portal/P2/P2SaveList.do",method = RequestMethod.POST)
	@ResponseBody
	public String P2SaveList(ModelAndView model,HttpServletRequest request) throws Exception {			
		ResponseVO ResponseVO = new ResponseVO();
		Gson gson = new Gson();
		try{
			ScheduleVo vo = new ScheduleVo();
			vo.setId((String)session.getAttribute("ID"));
			String from = request.getParameter("startDay")+" "+request.getParameter("startTime")+":00" ;
		

			SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

			Date startDay = transFormat.parse(from);
			
			vo.setStart_dt(startDay);
			
			String from1 = request.getParameter("endDay") +" " + request.getParameter("endTime") +":00";

			Date endDay = transFormat.parse(from1);
			
			vo.setEnd_dt(endDay);
			
			vo.setTitle(request.getParameter("title"));
			vo.setsType(Integer.parseInt(request.getParameter("sType")));
			
			if(request.getParameter("sType").equals("1")) {
				vo.setColor("#008000");
			}else if(request.getParameter("sType").equals("2")) {
				vo.setColor("#FF4500");
			}else if(request.getParameter("sType").equals("3")) {
				vo.setColor("#FF0000");
			}else {
				vo.setColor("#000000");
			}
			if(CommonUtil.NullCheck(request.getParameter("allDay"))) {
				vo.setAllDay(false);
			}else {
				vo.setAllDay(true);
			}
			vo.setUrl("https://www.naver.com/");
			vo.setA(from);
			vo.setB(from1);
			int a =  service.InsertSaveList(vo);
			if(a == 1) {			
				 ResponseVO.setSuccess(true);  
		         ResponseVO.setMsg("Success Creating Id");
		         loginVo vo2 = new loginVo();
		         vo2.setId((String)session.getAttribute("ID"));
		         List  resultList = service.selectCalendarList(vo2);
		         ResponseVO.setList(resultList);
			}else {
				ResponseVO.setSuccess(true);  
				ResponseVO.setMsg("Error Creating Id");
			}
		}catch(Exception e){
			logger.error("P2001Controller -> p2001Page" + e);
		}
		return gson.toJson(ResponseVO);
	}
}
