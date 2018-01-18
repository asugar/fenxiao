package com.distribution.form;


/**
 * 
 * Description: 内部公共参数属性（数据库公用字段）
 *
 * @author oyyf
 *
 * @date 2017年12月21日 下午2:48:11
 */
public class CommonProperties {
	/**
	 * 公共参数属性
	 */
	public static final String PID = "pid";//主键
	public static final String PLATFORM = "platform";//平台编码
	public static final String SOURCR = "source";//数据来源
	public static final String DEL_FLAG = "del_flag";//删除标记
	public static final String CRE_TIME = "cre_time"; //创建时间
	public static final String CRE_USER = "cre_user";//创建用户
	public static final String LAST_UP_TIME = "last_up_time";//最后更新
	public static final String LAST_UP_USER = "last_up_user";//最后更新用户
	public static final String DB_REASON = "in_reason";//入库原因
	
	
	/**
	 * 系统公共状态
	 */
	/**
	 * 成功状态
	 */
	public static final String STATUS_SUCCESS="0";//成功
	/**
	 * 失败状态
	 */
	public static final String STATUS_FAIL="2";//失败
	/**
	 * 初始化状态
	 */
	public static final String STATUS_INIT="1";//初始化
	/**
	 * 异常状态
	 */
	public static final String STATUS_EXCEPTION="3";//异常
	
	

}
