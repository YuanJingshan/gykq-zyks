/**
 * @fileName BaseDao.java
 * @author YuanJingshan
 * @date 2014-12-2
 */
package cn.poomoo.exam.dao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import cn.poomoo.common.util.DateUtil;
import cn.poomoo.common.util.LogUtil;
import cn.poomoo.db.DBConnection;


/**
 * @className BaseDao
 * @description 数据库访问BaseDao
 * @author YuanJingshan
 */
public class BaseDao {
	// connection
	protected Connection connection = null;
//	// statement
//	protected PreparedStatement pStatement = null;
//	// resultSet
//	protected ResultSet resultSet = null;
//	// CallableStatement 
//	protected CallableStatement callStatement = null;
	
	//modified by yjs at 2015-10-12 构造函数注入连接
	public BaseDao() {
		connection = DBConnection.getInstance().getConnection();
	}
	
	/**
	 * 执行sql语句， 可增加、删除、修改
	 *
	 * @param sqlString
	 * @return int
	 * @throws SQLException 
	 */
	public int executeSql(String sqlString) {
		int iRetCode = 0;
		PreparedStatement pStatement = null;
		
		LogUtil.getInstance().getLogger().info("sql: " + sqlString);
		
		try {
			//connection = DBConnection.getInstance().getConnection(); //deleted by yjs at 2015-10-12 
			connection.setAutoCommit(false); // 开启手动提交
			pStatement = connection.prepareStatement(sqlString);
			iRetCode = pStatement.executeUpdate();
			connection.commit(); // 提交
			connection.setAutoCommit(true); // 关闭手动提交
		} catch (Exception e) {
			iRetCode = -1;
			e.printStackTrace(); 
			LogUtil.getInstance().getLogger().error("执行sql语句失败：" + sqlString);
			try {
				connection.rollback(); // 错误回滚
				connection.setAutoCommit(true); // 关闭手动提交
			} catch (SQLException e1) {
				e1.printStackTrace();
				LogUtil.getInstance().getLogger().error("数据库错误回滚/关闭手动提交失败！");
			} 
		} finally {
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				LogUtil.getInstance().getLogger().error("数据库错误回滚/pStatement失败！");
			}
		}
		return iRetCode;
	}
	
	/**
	 * 执行sql语句， 可增加、删除、修改
	 *
	 * @param sqlString
	 * @return int
	 * @throws SQLException 
	 */
	public int executeSql(String sqlString, Map<String, String> map) {
		int iRetCode = 0;
		PreparedStatement pStatement = null;
		LogUtil.getInstance().getLogger().info("sql: " + sqlString + "\nparams:" + map.toString());
		
		try {
			//connection = DBConnection.getInstance().getConnection();
			connection.setAutoCommit(false); // 开启手动提交
			pStatement = connection.prepareStatement(sqlString);
			
			int i = 1;
			for (Map.Entry<String, String> entry : map.entrySet()) {
				String keyType = entry.getKey().substring(0, entry.getKey().indexOf("_"));
				if (keyType.equals("byte")) {	
					pStatement.setByte(i, Byte.parseByte(entry.getValue()));
				} else if (keyType.equals("int")) {
					pStatement.setInt(i, Integer.parseInt(entry.getValue()));
				} else if (keyType.equals("double")) {
					pStatement.setDouble(i, Double.parseDouble(entry.getValue()));
				} else if (keyType.equals("float")) {
					pStatement.setFloat(i, Float.parseFloat(entry.getValue()));
				} else if (keyType.equals("string")) {
					pStatement.setString(i, entry.getValue());
				} else if (keyType.equals("date")) {
					pStatement.setTimestamp(i, DateUtil.utilDateToTimestamp(DateUtil.stringToDate(entry.getValue(),"yyyy-MM-dd HH:mm:ss")));
				}
				i++;
			}		
			iRetCode = pStatement.executeUpdate();
			connection.commit(); // 提交
			connection.setAutoCommit(true); // 关闭手动提交
		} catch (Exception e) {
			iRetCode = -1;
			e.printStackTrace(); 
			LogUtil.getInstance().getLogger().error("执行sql语句失败：" + sqlString);
			try {
				connection.rollback(); // 错误回滚
				connection.setAutoCommit(true); // 关闭手动提交
			} catch (SQLException e1) {
				e1.printStackTrace();
				LogUtil.getInstance().getLogger().error("数据库错误回滚/关闭手动提交失败！");
			} 
		} finally {
			try {
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				LogUtil.getInstance().getLogger().error("数据库错误回滚/pStatement失败！");
			}
		}
		return iRetCode;
	}
	
	/**
	 * 执行存储
	 *
	 * @param sqlString
	 * @return int
	 * @throws SQLException 
	 */
	public int executePro(String sqlString, Map<String, String> map) {
		int iRetCode = 0;
		CallableStatement callStatement = null;
		LogUtil.getInstance().getLogger().info("sql: " + sqlString + "\nparams:" + map.toString());
		try {
			//connection = DBConnection.getInstance().getConnection();
			connection.setAutoCommit(false); // 开启手动提交
			
			callStatement = connection.prepareCall(sqlString);
			callStatement.registerOutParameter(1,java.sql.Types.INTEGER);
			int i = 2;
			for (Map.Entry<String, String> entry : map.entrySet()) {
				String keyType = entry.getKey().substring(0,entry.getKey().indexOf("_"));
				if (keyType.equals("byte")) {
					callStatement.setByte(i, Byte.parseByte(entry.getValue()));
				} else if (keyType.equals("int")) {
					callStatement.setInt(i, Integer.parseInt(entry.getValue()));
				} else if (keyType.equals("double")) {
					callStatement.setDouble(i, Double.parseDouble(entry.getValue()));
				} else if (keyType.equals("float")) {
					callStatement.setFloat(i, Float.parseFloat(entry.getValue()));
				} else if (keyType.equals("string")) {
					callStatement.setString(i, entry.getValue());
				} else if (keyType.equals("date")) {
					callStatement.setTimestamp(i, DateUtil.utilDateToTimestamp(DateUtil.stringToDate(entry.getValue(),"yyyy-MM-dd HH:mm:ss")));
				}
				i++;
			}
			callStatement.execute();
			iRetCode = callStatement.getInt(1);
			
			connection.commit(); // 提交
			connection.setAutoCommit(true); // 关闭手动提交
		} catch (Exception e) {
			iRetCode = -1;
			e.printStackTrace(); 
			LogUtil.getInstance().getLogger().error("执行sql语句失败：" + sqlString);
			try {
				connection.rollback(); // 错误回滚
				connection.setAutoCommit(true); // 关闭手动提交
			} catch (SQLException e1) {
				e1.printStackTrace();
				LogUtil.getInstance().getLogger().error("数据库错误回滚/关闭手动提交失败！");
			} 
		} finally {
			try {
				if (callStatement != null) {
					callStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				LogUtil.getInstance().getLogger().error("数据库错误回滚/关闭callStatement失败！");
			}
		}
		return iRetCode;
	}
	
	/**
	 * 执行count(*)语句
	 * @param sqlString
	 * @return int
	 */
	public int executeCountSql(String sqlString) {
		
		LogUtil.getInstance().getLogger().info("sql: " + sqlString);
		
		int iRetCode = 0;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			//connection = DBConnection.getInstance().getConnection();
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet.next()) {
				iRetCode = resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("执行sql语句失败：" + sqlString);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				LogUtil.getInstance().getLogger().error("数据库错误回滚/关闭pStatement、resultSet失败！");
			}
		}
		return iRetCode;
	}
	
//	/**
//	 * 关闭Statement、ResultSet
//	 * void
//	 */
//	public void close() {
//		try {
//			if (resultSet != null && !resultSet.isClosed()) {
//				resultSet.close();
//			}
//			if (pStatement != null && !pStatement.isClosed()) {
//				pStatement.close();
//			}
//			if (callStatement != null && !callStatement.isClosed()) {
//				callStatement.close();
//			}
//		} catch (Exception e) {
//			LogUtil.getInstance().getLogger().error("关闭Connection、Statement、ResultSet失败...");
//			e.printStackTrace();
//		}
//	}
	
}