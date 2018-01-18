package com.distribution.form;



import java.util.HashMap;
import java.util.Map;


/**
 * 返回结果工具类
 * @author oyyf
 *
 */
public class ResponseData {
	
	/**
	 * 自定义返回结果
	 * @param code 返回码
	 * @param retmag 自定义返回描述
	 * @return 通用返回参数map对象
	 */
	public static Map<String,Object> getResponseStr(String code,String retmag){
		Map<String,Object> retMap = new HashMap<String, Object>();
		retMap.put(ResponseData.STATUS, code);
		retMap.put(ResponseData.MSG, retmag);
		return retMap;
	}
	/**
	 * 返回状态
	 */
	public static String STATUS ="status";//返回状态
	/**
	 * 状态描述
	 */
	public static String MSG="msg";//状态描述
	

}
