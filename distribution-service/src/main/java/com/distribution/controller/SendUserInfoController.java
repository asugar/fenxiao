package com.distribution.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.distribution.service.impl.FraudServiceImpl;


/**
 * 
 * Description:服务测试入口controller
 *
 * @author oyyf
 *
 * @date 2017年12月19日 下午6:45:16
 */
@Controller
@RequestMapping("sendUserInfo")
public class SendUserInfoController {
	private final static Logger logger = Logger
			.getLogger(SendUserInfoController.class);
	/**
	 * 注入服务 
	 */
	@Autowired
	FraudServiceImpl fraudServiceImpl;
	/**
	 * 测试方法
	 * @return 返回入库结果
	 */
	@ResponseBody
	@RequestMapping(value="/test")
	public String test(){
		Map<String, Object> map =new HashMap<String,Object>();
		Map<String, Object> map1 =new HashMap<String,Object>();
		Map<String, Object> map2 =new HashMap<String,Object>();
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> list1 = new  ArrayList<Map<String,Object>>();
		map2.put("operaDataProject", "province");
		map2.put("operaData", "北京市");
		
		list1.add(map2);
		map1.put("operaStatus", "1");
		map1.put("subDataCode", "D_RM_01_04");
		map1.put("dbReason", null);
		map1.put("amountItems",list1 );
		list.add(map1);
		map.put("dealFraudInfo", list);
		String name = JSONObject.toJSONString(map);
//		String name="{'dealFraudInfo': [{'operaStatus': '1','subDataCode': 'D_RM_01_01','dbReason': null,'itemResList': [{'operaDataProject': 'phoneNo','operaData':'15902222555'},{'operaDataProject': 'equipmentNid','operaData': '33333'},]}]}";
		return fraudServiceImpl.insertFraudinfo(name);
	}


}
