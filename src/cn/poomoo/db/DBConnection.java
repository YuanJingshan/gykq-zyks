/**
 * @fileName DBConnection.java
 * @auther YuanJingshan
 * @date 2014-11-4
 */
package cn.poomoo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import cn.poomoo.common.util.LogUtil;

/**
 * @className DBConnection
 * @description 数据库基础类
 */
public class DBConnection {
	private Properties properties;
	private String url;
	private String user;
	private String pwd;
	private Connection connection;
	private static DBConnection instance = null;
	
	//modified by yjs at 2015-10-12 构造函数私有化
	private DBConnection() {
		initCreateConnection();
	}
	
	/**
	 * @function initCreateConnection
	 * @description 从配置文件获取数据库连接参数，创建连接
	 */
	public void initCreateConnection() {
		try {
			properties = new Properties();
			properties.load( this.getClass().getClassLoader().getResourceAsStream("jdbc.properties"));
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			pwd = properties.getProperty("password");
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			LogUtil.getInstance().getLogger().error("初始化连接异常...");
			e.printStackTrace();
		}
	}

	/**
	 * @function @return DBConnection
	 * @description
	 */
	public static DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	/**
	 * 关闭连接
	 * void
	 */
	public void close() {
		try {
			if (connection != null || !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			LogUtil.getInstance().getLogger().error("关闭连接异常...");
			e.printStackTrace();
		}	
	}

	/**
	 * 描述：关闭连接
	 * @return 
	 * Connection
	 */
	public Connection getConnection() {
		try {
			if (connection == null || connection.isClosed()) {
				initCreateConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("获取链接异常...");
		}
		return connection;
	}
	
}
