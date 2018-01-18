package com.distribution.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 心跳接口
 * @author Administrator
 *
 */
@Controller
@RequestMapping("heartBeat")
public class HeartBeatController {
	@ResponseBody
	@RequestMapping(value="/live")
  public String live(){
	  return "ok";
  }
}
