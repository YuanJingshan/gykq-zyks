/**
 * @file DateUtil.java
 * @author yuanjingshan
 * @date 2015-02-27
 */
package cn.poomoo.common.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 * @className DateUtil
 * @description 时间工具
 * @author YuanJingshan
 */
public class DateUtil {

	public DateUtil() {
	}
	
	/**
	 * 将util时间转化未字符串，格式：yyyy-MM-dd HH:mm:ss
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
	
	/**
	 * 将util时间转化未字符串，传入指定格式
	 */
	public static String dateToString(Date date, String string) {
		SimpleDateFormat sdf = new SimpleDateFormat(string);
		return sdf.format(date);	
	}
	
	/**
	 * 将字符串转化为时间，格式：yyyy-MM-dd HH:mm:ss
	 */
	public static Date stringToDate(String string) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("字符串转时间错误");
		}
		return date;
	}
	
	/**
	 * 将字符串转化为时间，传入指定的时间的格式
	 */
	public static Date stringToDate(String string, String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = null;
		try {
			date = sdf.parse(string);
		} catch (ParseException e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("字符串转时间错误");
		}
		return date;
	}
	
	/**
	 * sql.date转util.date
	 */
	public static Date sqlDateToUtilDate(java.sql.Date date) {
		return new Date(date.getTime()); 
	}
	
	/**
	 * util.date转sql.date
	 */
	public static java.sql.Date utilDateToSqlDate(Date date) {
		return new java.sql.Date(date.getTime());
	}
	
	/**
	 * @param date
	 * @return java.sql.Timestamp
	 */
	public static java.sql.Timestamp utilDateToTimestamp(Date date) {
		return new java.sql.Timestamp(date.getTime());
	}
	
	/**
	 * timestamp 转 Date
	 * @param date
	 * @return Date
	 */
	public static Date timestampToDate(Date date) {
		return stringToDate(dateToString(date));
	}
}