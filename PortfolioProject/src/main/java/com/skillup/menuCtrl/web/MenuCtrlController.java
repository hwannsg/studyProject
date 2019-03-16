/**
 * 
 */
package com.skillup.menuCtrl.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skillup.common.QweMap;

/**
 * 1. 클래스	: MenuCtrlController.java
 * 2. 작성자	: rnjde
 * 3. 작성시간	: 2019. 3. 10.
 *
 * <pre>
 * 설명			:
 * </pre>
 */
@Controller
@RequestMapping(value = "menu/ctrl/")
public class MenuCtrlController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	
	@RequestMapping(value = "list.do", method = RequestMethod.POST)
	public String selectMenuList (QweMap qweMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
		logger.debug(">>>>>>>>>>>>>selectMenuList {}", qweMap.getMap());
		
		
		return "portal/ctrlMenu/menuList";
	}
	
}
