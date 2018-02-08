package com.distribution.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登陆、登出相关
* @ClassName: IndexController  
* @Description: 
* @author Administrator  
* @date 2018年2月5日  
*
 */
@Controller
public class IndexController {
	/**
	 * 
	* @Title: login  
	* @Description: 登陆
	* @param @param userName 登陆名
	* @param @param passwd ，密码
	* @param @param accessToken accessToken
	* @param @return   
	* @return String   
	* @throws
	 */
	@RequestMapping
	@ResponseBody
	public String login(String userName,String passwd,String accessToken){
		
		
		return null;
	}

}
