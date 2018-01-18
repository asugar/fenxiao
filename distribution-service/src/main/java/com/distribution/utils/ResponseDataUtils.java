package com.distribution.utils;


import java.util.HashMap;
import java.util.Map;




import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSONObject;
import com.distribution.form.ResponseData;
/**
 * 公用返回结果描述
 * @author oyyf
 *
 */
public class ResponseDataUtils {
	
	public static final String STATUS_SUCCESS_CODE="0000";//成功返回码
	public static final String STATUS_FAIL_CODE="9999";//
	public static final String STATUS_NULL_REQDATA_CODE="0001";//参数为空
	public static final String STATUS_ANALYSIS_REQDATA_CODE="0002";//解析报文异常
	public static final String STATUS_DB_INSERT_CODE="0003";//入库异常
	
	
	
	public static  Map<String,String> mapData = new HashMap<String, String>();
	static {
		mapData.put(STATUS_SUCCESS_CODE, "操作成功");
		mapData.put(STATUS_FAIL_CODE, "操作失败");
		mapData.put(STATUS_NULL_REQDATA_CODE, "请求数据为空");
		mapData.put(STATUS_ANALYSIS_REQDATA_CODE, "解析报文异常");
	}
	/**
	 * 成功返回结果
	 * @return
	 */
	public static String getSuccessResponseStr(){
		return JSONObject.toJSONString(ResponseData.getResponseStr(STATUS_SUCCESS_CODE,mapData.get(STATUS_SUCCESS_CODE)));
	}
	/**
	 * 失败返回结果
	 * @return
	 */
	public static String getFailResponseStr(){
		return JSONObject.toJSONString(ResponseData.getResponseStr(STATUS_FAIL_CODE,mapData.get(STATUS_FAIL_CODE)));
	}
	/**
	 * 返回自定义结果
	 * @param code 自定义code
	 * @param msg 自定义描述
	 */
	public static String ownDefinedResponseStr(String code,String msg){
		return JSONObject.toJSONString(ResponseData.getResponseStr(code,StringUtils.isEmpty(msg)?mapData.get(code):msg)) ;
	}
	

}
