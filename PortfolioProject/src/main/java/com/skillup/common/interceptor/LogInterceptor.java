package com.skillup.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LogInterceptor extends HandlerInterceptorAdapter{

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    static final String[] EXCLUDE_URL_LIST = {
            "/portal/common/joinAction.do",
            "/portal/common/joinCreate.do",
            "/portal/common/joinPage.do"
            /* "/index.do",
            "/LoginAction.do",
            "/RuleAction.do", 
            "/ajaxDeviceControl.do",
            "/error"*/
        };

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {     
    	HttpSession session = request.getSession();
        String reqUrl = request.getServletPath().toString();    
        logger.debug("-------------------{}",reqUrl);
        for( String target : EXCLUDE_URL_LIST ){        
            if(reqUrl.indexOf(target) == 0){

                return true;    
            }            
        }        

        String userId = (String)session.getAttribute("ID");
        if(userId==null || userId.trim().equals("")){
            logger.info(">> interceptor catch!!! userId is null.. ");      	      
            session.invalidate();            
            response.sendRedirect("/");
            System.out.println("ssss"+request.getContextPath());
            return false;            
        }
        
        return true;        
    }
    
    
    

}

