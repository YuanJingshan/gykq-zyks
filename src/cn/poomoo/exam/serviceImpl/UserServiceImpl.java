/**
 * @fileName UserServiceImpl.java
 * @author YuanJingshan
 * @date 2014-12-3
 */
package cn.poomoo.exam.serviceImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.poomoo.common.util.MD5Util;
import cn.poomoo.exam.dao.UserDao;
import cn.poomoo.exam.medol.User;
import cn.poomoo.exam.service.UserService;

/**
 * @className UserServiceImpl
 * @description 用户服务类
 * @author YuanJingshan
 */
public class UserServiceImpl implements UserService {
	//
	private UserDao userDao = new UserDao();

	public UserServiceImpl() {
		
	}
	
	public User queryUserbyNameAndPsw(String userName, String password) {
		String sqlString ="select * from t_admin_info where user_name='" + userName + "' and password='" + MD5Util.string2MD5(password) + "'";
		return userDao.getObj(sqlString);
	}

	public int insertUser(Map<String, String> map) {
		String sqlString = "insert into t_admin_info(user_name,real_name,password,tel,address,authority,insert_dt) values(?,?,?,?,?,?,?)";
		return userDao.executeSql(sqlString, map);
	}
	
	public int deleteUser(String userIdString) {
		String sqlString = "delete from t_admin_info where id in (" + userIdString + ")";
		return userDao.executeSql(sqlString);
	}

	public User getUserById(int userId) {
		String sqlString = "select * from t_admin_info where id=" + userId;
		return userDao.getObj(sqlString);
	}

	public int updateUser(Map<String, String> map) {
		String sqlString =  "update t_admin_info set user_name=?,real_name=?,password=?,tel=?,address=?,authority=? where id=?"; 
		return userDao.executeSql(sqlString, map);
	}

	public int queryUserCount() {
		String sqlString = "select count(*) from t_admin_info";
		return userDao.executeCountSql(sqlString);
	}

	public List<User> queryPageDate(int pageNum, int pageSize) {
		String sqlString = "select * from t_admin_info order by insert_dt desc limit " + (pageNum - 1) * pageSize + ", " + pageSize;
		return userDao.getList(sqlString);
	}

	public int sysInit() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		String sqlString = "call pr_sys_init(?)";
		return userDao.executePro(sqlString, map);
	}

}
