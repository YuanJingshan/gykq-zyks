/**
 * @fileName LogUtil.java
 * @author YuanJingshan
 * @date 2014-11-17
 */
package cn.poomoo.common.util;

import org.apache.log4j.Logger;

/**
 * @className LogUtil
 * @description 日志工具类
 * @author YuanJingshan
 */
public class LogUtil {
	// 记录器
	private Logger log = Logger.getLogger(LogUtil.class);
	// 实例
	private static LogUtil instance;

	public LogUtil() {
		
	}

	// 获取记录器
	public Logger getLogger() {
		return log;
	}
	
	// 获取实例
	public static LogUtil getInstance() {
		if (instance == null) {
			instance = new LogUtil();
		}
		return instance;
	}
}
