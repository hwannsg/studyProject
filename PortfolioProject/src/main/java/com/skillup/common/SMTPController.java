package com.skillup.common;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.gson.Gson;
import com.skillup.Vo.vo.EmailDataVO;
import com.skillup.Vo.vo.ResponseVO;
import com.skillup.Vo.vo.SendEMailRequestVO;
import com.skillup.Vo.vo.SendEMailRequestVO.EMAIL_TYPE;
import com.skillup.Vo.vo.ServiceInfoVO;


/**
 * Handles requests for the application home page.
 */
public class SMTPController {

	@Autowired
	private SqlSessionTemplate  sqlsession;
	
	private static final Logger logger = LoggerFactory.getLogger(SMTPController.class);

	public static String RegisterUser() {
        HashMap<String,Object> map = new HashMap<String, Object>();
        Gson gson = new Gson();
        ResponseVO ResponseVO = new ResponseVO();
        

		SendEMailRequestVO requesta = new SendEMailRequestVO();
        requesta.setSnderEmail(new EmailDataVO("support@atnsgroup.com", "Clair Support"));
        
        requesta.addRcvEmailList(new EmailDataVO(
                "skidha72@gmail.com",
                "황승국") );
		/*
		 * requesta.addRcvEmailList(new EmailDataVO( "baekong@atnsgroup.com", "배성웅") );
		 */
        
        requesta.setMailSubject("SMTP Test");
        requesta.setEmailType(EMAIL_TYPE.HTML);
        requesta.setContents("Smtp Test입니다."+" DeviceId: testest data: test Type: testest"); 
        //requesta.setAttachFile(param.getAttachFile());
        ServiceInfoVO serviceInfo = new ServiceInfoVO();
        //serviceInfo.setSvrId(21.6);
        serviceInfo.setPortNo("465");
        //naver -> 465
        HashMap<String,Object> result2aa = OutBoundSmtpSender.sendRequest(serviceInfo,requesta,HashMap.class);

        
        
        //map.put("accesstoken", accesstoken);
        ResponseVO.setSuccess(true);
        ResponseVO.setData(map);
		return gson.toJson(ResponseVO);
	}
}
	