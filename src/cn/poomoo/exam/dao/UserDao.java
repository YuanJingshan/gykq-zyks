/**
 * @fileName UserDao.java
 * @author YuanJingshan
 * @date 2014-12-2
 */
package cn.poomoo.exam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.poomoo.common.util.LogUtil;
import cn.poomoo.exam.medol.User;

/**
 * @className UserDao
 * @description 账户访问数据库
 * @author YuanJingshan
 */
public class UserDao extends BaseDao{

	public UserDao() {
		
	}
	
	public List<User> getList(String sqlString) {
		List<User> list = new ArrayList<User>();
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			//modified by yjs 2015-10-12
			//pStatement = DBConnection.getInstance().getConnection().prepareStatement(sqlString);
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					User user = getUserByResultSet(resultSet);
					list.add(user);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("执行查询失败：" + sqlString);
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
		return list;
	}
	
	public User getObj(String sqlString) {
		User user = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			//modified by yjs 2015-10-12
			//pStatement = DBConnection.getInstance().getConnection().prepareStatement(sqlString);
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet !=null && resultSet.next()) {
				user = getUserByResultSet(resultSet);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("执行查询失败：" + sqlString);
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
		return user;
	}
	
	public User getUserByResultSet(ResultSet resultSet) {
		User user = new User();
		try {
			user.setId(resultSet.getInt("id"));
			user.setUserName(resultSet.getString("user_name"));
			user.setRealName(resultSet.getString("real_name"));
			user.setPassword(resultSet.getString("password"));
			user.setTel(resultSet.getString("tel"));
			user.setAddress(resultSet.getString("address"));
			user.setAuthority(resultSet.getByte("authority"));
			user.setInsertDt(resultSet.getTimestamp("insert_dt"));	
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("从resultSet取值失败......");
		}
		return user;
	}
}
