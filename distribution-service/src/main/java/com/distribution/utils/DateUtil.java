package com.distribution.utils;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

public class DateUtil {
	/**
	 * 一天中一共的毫秒数
	 */
	public static long millionSecondsOfDay = 86400000;
	private static final String FORMAT_DATE_STR = "yyyy-MM-dd";

	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * 日期格式化
	 * 
	 * @param pattern
	 * @param date
	 * @return
	 */
	public static String getParseDate(String pattern, Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern(pattern);
		return sdf.format(date);
	}

	/**
	 * 格式化日期为Date型(yyyy-MM-dd)
	 * 
	 * @param date
	 * @param formater
	 * @return
	 */
	public static Date parse(String date) {
		return parse(date, FORMAT_DATE_STR);
	}

	/**
	 * 根据指定日期格式格式化日期为Date型
	 * 
	 * @param date
	 * @param formater
	 * @return
	 */
	public static Date parse(String date, String formater) {
		SimpleDateFormat sdf = new SimpleDateFormat(formater);
		Date result = null;
		try {
			result = sdf.parse(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 得到两个日期之间相差的天数,两头不算,取出数据后，可以根据需要再加
	 * 
	 * @deprecated 此方法在计算相邻两天的日期时结果为1
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDifferDay(Date date1, Date date2) {
		Long d1 = date1.getTime();
		Long d2 = date2.getTime();
		return (int) (Math.abs(d2 - d1) / millionSecondsOfDay);
	}

	/**
	 * 计算日期加天数
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static String addDay(Date date, int days) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.add(Calendar.DAY_OF_MONTH, days);
		return getParseDate(FORMAT_DATE_STR, c.getTime());
	}

	/**
	 * 计算日期减天数
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static String minusDay(Date date, int days) {
		Calendar c = new GregorianCalendar();
		c.setTime(date);
		c.set(Calendar.DATE, c.get(Calendar.DATE) - days);
		return getParseDate(FORMAT_DATE_STR, c.getTime());
	}

	/**
	 * 描述 ： 获取系统时间，格式yyyyMMddHHmmss
	 * <p>
	 * 创建人：hezhanling , 2015年1月22日 上午10:21:24
	 * </p>
	 * <p>
	 * 修改人：
	 * </p>
	 */
	public static String getDateTimeString() {

		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMddHHmmss");
		return fm.format(new Date());
	}

	/**
	 * 描述 ： 获取系统日期，格式yyyyMMdd
	 * <p>
	 * 创建人：hezhanling , 2015年1月22日 下午1:18:38
	 * </p>
	 * <p>
	 * 修改人：
	 * </p>
	 */
	public static String getDateString() {
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd");
		return fm.format(new Date());
	}

	/**
	 * 描述 ： 获取当前系统时间，格式：yyyyMMddHHmmssSSS，可作为订单号使用
	 * <p>
	 * 创建人：hezhanling , 2015年1月23日 下午2:38:09
	 * </p>
	 * <p>
	 * 修改人：
	 * </p>
	 */
	public static String getDateTimeForOrderString() {

		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		return fm.format(new Date());
	}

	/**
	 * 描述 ： 给当前时间加上一些天数
	 * 
	 * @param date
	 * @param num
	 * @return <p>
	 *         创建人：hezhanling , 2015年2月2日 下午5:33:31
	 *         </p>
	 *         <p>
	 *         修改人：
	 *         </p>
	 */
	public static String getCurrentTimeAddNumDay(int num) {
		SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd");
		java.util.Calendar Cal = java.util.Calendar.getInstance();
		Cal.setTime(new Date());
		Cal.add(java.util.Calendar.DATE, num);
		return fm.format(Cal.getTime());
	}

	/**
	 * 将fromFormat 格式的字符串格式的日期，转换成toFormat 格式的日期
	 * 
	 * @Title: praseDateType
	 * @Description:
	 * @param @param dateStr 要转型的日期str
	 * @param @param fromFormat 转型前的日期格式
	 * @param @param toFormat 转型后的日期格式
	 * @param @return
	 * @return String
	 * @throws
	 */
	public static String praseDateType(String dateStr, String fromFormat,
			String toFormat) {
		Date d = DateUtil.parse(dateStr, fromFormat);
		SimpleDateFormat fm = new SimpleDateFormat(toFormat);
		return fm.format(d);
	}

	public static String getCurrentTime(int num, String format) {
		SimpleDateFormat fm = new SimpleDateFormat(format);
		java.util.Calendar Cal = java.util.Calendar.getInstance();
		Cal.setTime(new Date());
		Cal.add(java.util.Calendar.DATE, num);
		return fm.format(Cal.getTime());
	}

	public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
			"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
			"t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
			"J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
			"W", "X", "Y", "Z" };

	/**
	 * @Title : generateShortUuid
	 * @Description : 生成短8位UUID
	 * @author : hezhanling
	 * @return
	 * @return String
	 * @throws
	 */
	public static String generateShortUuid() {
		StringBuffer shortBuffer = new StringBuffer();
		String uuid = UUID.randomUUID().toString().replace("-", "");
		for (int i = 0; i < 8; i++) {
			String str = uuid.substring(i * 4, i * 4 + 4);
			int x = Integer.parseInt(str, 16);
			shortBuffer.append(chars[x % 0x3E]);
		}
		return shortBuffer.toString();

	}

	public static String getUniquenString() {

		return getDateTimeString() + generateShortUuid();
	}

	public static void main(String[] args) {
		// System.out.println(getDifferDay(parse("2014-05-07"),parse("2014-05-06")));
		// System.out.println(getCurrentTimeAddNumDay(-1));
		// System.out.println(new Random().nextInt(999999));
		// System.out.println(UUID.randomUUID());
		// String pattern="000000";
		// java.text.DecimalFormat df = new java.text.DecimalFormat(pattern);
		// int i = 10,j=6;
		// System.out.println("i="+df.format(i)+"\nj="+df.format(j));
		// getParseDate("yyyy-MM-dd HH:mm:ss", )
		Date d = DateUtil.parse("20151228", "yyyyMMdd");
		SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String aa = fm.format(d);

		System.out.println(aa);
	}
}
