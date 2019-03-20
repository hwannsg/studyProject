package com.skillup.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * @author ssmic
 *
 */
public class CommonUtil {


    private static Logger logger = LoggerFactory.getLogger(CommonUtil.class);
	/**
	 * 숫자여부 판단
	 *
	 */
	public static boolean isNumeric(String arg) {
		// TODO: 숫자여부 판단 
		boolean isNumeric = false;
		return isNumeric;
	}
	/**
	 * null 값 check
	 *
	 */
	public static Boolean NullCheck(String text){
		try {
			Assert.notNull(text,"Error while Null check Logic");
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public static String checkNull(Object object){
        String rtn = "";
        
        try{
            if(object != null){
                rtn = String.valueOf(object) ;
            }
        }catch (NullPointerException ne){
            if(logger.isDebugEnabled())
                logger.error(ne.getMessage());
        }catch (Exception e){
            if(logger.isDebugEnabled())
                logger.error(e.getMessage());
        }
        
        return rtn;
    }
}
