package com.distribution.utils;



import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;



public class StringUtil {
	/**
	 * map值映射到父类和子类属性上
	 * @param paraMap
	 * @param obj
	 * @param className
	 */
	public static void parseMapToObjsup(Map<String, Object> paraMap,Object obj,Class<?> className){
		// 请求参数
				Map<String, Object> params = new HashMap<String, Object>();
				// 遍历
				Iterator<Entry<String, Object>> pmEsIter = paraMap.entrySet()
						.iterator();
				while (pmEsIter.hasNext()) {
					Entry<String, Object> entry = pmEsIter.next();
					String key = entry.getKey();
					Object value = entry.getValue();
					if (org.springframework.util.ObjectUtils.isEmpty(value)) {
						continue;
					}
					params.put(key, value);
				}
				// 反射
				Field[] fds = className.getSuperclass().getDeclaredFields();//父类属性
				Field[] fdc = className.getDeclaredFields();//子类属性
				for (int i = 0; i < fds.length; i++) {
					Field field = fds[i];
					field.setAccessible(true);
					String key = field.getName();
					Object value = params.get(key);
					if (!org.springframework.util.ObjectUtils.isEmpty(value)) {
						try {
							field.set(obj, value);
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
				for (int i = 0; i < fdc.length; i++) {
					Field field = fdc[i];
					field.setAccessible(true);
					String key = field.getName();
					Object value = params.get(key);
					if (!org.springframework.util.ObjectUtils.isEmpty(value)) {
						try {
							field.set(obj, value);
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
		
	}
	
	/**
	 * map值映射到父类和子类属性上
	 * @param paraMap
	 * @param obj
	 * @param className
	 */
	public static void parseMapToObj(Map<String, Object> paraMap,Object obj,Class<?> className){
		// 请求参数
				Map<String, Object> params = new HashMap<String, Object>();
				// 遍历
				Iterator<Entry<String, Object>> pmEsIter = paraMap.entrySet()
						.iterator();
				while (pmEsIter.hasNext()) {
					Entry<String, Object> entry = pmEsIter.next();
					String key = entry.getKey();
					Object value = entry.getValue();
					if (org.springframework.util.ObjectUtils.isEmpty(value)) {
						continue;
					}
					params.put(key, value);
				}
				// 反射
				Field[] fds = className.getDeclaredFields();//
				for (int i = 0; i < fds.length; i++) {
					Field field = fds[i];
					field.setAccessible(true);
					String key = field.getName();
					Object value = params.get(key);
					if (!org.springframework.util.ObjectUtils.isEmpty(value)) {
						try {
							field.set(obj, value);
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
		
	}
	/**
	 * 产生随机字符串
	 * 
	 * @param length
	 * @return
	 */
	public static final String randomString(int length) {
		if (length < 1) {
			return null;
		}
		Random randGen = new Random();
		char[] numbersAndLetters = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
				.toCharArray();
		int len = numbersAndLetters.length - 1;
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(len)];
		}
		return new String(randBuffer);
	}

	/**
	 * 产生随机字符串
	 * 
	 * @param length
	 * @return
	 */
	public static final String randomNumber(int length) {
		if (length < 1) {
			return null;
		}
		Random randGen = new Random();
		char[] numbersAndLetters = ("0123456789").toCharArray();
		int len = numbersAndLetters.length - 1;
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(len)];
		}
		return new String(randBuffer);
	}

	/**
	 * 对象属性转换成map存储
	 * 
	 * @param obj
	 * @param classPath
	 * @return
	 */
	public static Map<String, String> objParseMap(Object obj, String classPath,
			Boolean flag) {
		Map<String, String> result = new HashMap<String, String>();
		try {
			// 获取类属性
			Field[] fds = Class.forName(classPath).getDeclaredFields();
			for (int i = 0; i < fds.length; i++) {
				Field field = fds[i];
				field.setAccessible(true);
				String v = (String) field.get(obj);
				if (!StringUtils.isEmpty(v)) {
					String name = field.getName();
					if (flag) {
						String firstStr = name.substring(0, 1).toUpperCase();
						name = new StringBuffer(firstStr).append(
								name.substring(1)).toString();
					}
					result.put(name, v);
				}
			}
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 对象和父类属性转换成map存储
	 * 
	 * @param obj
	 * @param classPath
	 * @param flag
	 * @return
	 */
	public static Map<String, String> objParseMap2(Object obj,
			String classPath, Boolean flag) {
		Map<String, String> result = objParseMap(obj, classPath, flag);
		try {
			// 获取父类属性
			Field[] pFds = obj.getClass().getSuperclass().getDeclaredFields();
			for (int j = 0; j < pFds.length; j++) {
				Field field = pFds[j];
				field.setAccessible(true);
				String v = (String) field.get(obj);
				if (!StringUtils.isEmpty(v)) {
					String name = field.getName();
					if (flag) {
						String firstStr = name.substring(0, 1).toUpperCase();
						name = new StringBuffer(firstStr).append(
								name.substring(1)).toString();
					}
					result.put(name, v);
				}
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static String parseStrCode(String str, String source, String pattern) {
		if (StringUtils.isEmpty(str)) {
			return "";
		}
		try {
			str = new String(str.getBytes(source), pattern);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}

	
	/**
	 * 判断字符串为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotNull(String str) {
		if (str == null || str == "") {
			return false;
		} else {
			if (str.equals("") || str.equals("null"))
				return false;
		}
		return true;
	}

	/**
	 * 拼接字符串
	 * 
	 * @param cs
	 * @param value
	 */
	public static void createCs(StringBuffer cs, String value) {
		// 判判断是否为空
		if (!StringUtils.isEmpty(value)) {
			// 去掉空格
			String parseValue = value.trim();
			cs.append(parseValue);
		}
	}


	/**
	 * @Title : getFixLenth
	 * @Description : 生成6位的字符，不够左补0
	 * @author : hezhanling
	 * @param strLength
	 * @return
	 * @return String
	 * @throws
	 */
	public static String getFixLenth(int param) {
		String pattern = "000000";
		java.text.DecimalFormat df = new java.text.DecimalFormat(pattern);
		return df.format(param);
	}

	/**
	 * 校验手机号是否合法
	 * 
	 * @Title: isMobile
	 * @Description: 
	 * @param @param mobile 需要校验的手机号
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	public static boolean isMobile(String mobile) {
		boolean flag = false;
		Pattern p = null;
		Matcher m = null;
		p = Pattern.compile("^[1][0-9]{10}$"); // 验证手机号
		m = p.matcher(mobile);
		flag = m.matches();
		return flag;
	}
}
