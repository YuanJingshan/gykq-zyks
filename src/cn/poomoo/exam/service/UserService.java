/**
 * @fileName UserService.java
 * @author YuanJingshan
 * @date 2014-12-3
 */
package cn.poomoo.exam.service;

import java.util.List;
import java.util.Map;

import cn.poomoo.exam.medol.User;


/**
 * @className UserService
 * @description 用户服务接口
 * @author YuanJingshan
 */
public interface UserService {

	/**
	 * 根据用户名和密码查询
	 * @param userName
	 * @param password
	 * @return User
	 */
	User queryUserbyNameAndPsw(String userName, String password);

	/**
	 * 插入
	 * @param map
	 * @return int
	 */
	int insertUser(Map<String, String> map);

	/**
	 * 根据id获取
	 * @param userId
	 * @return User
	 */
	User getUserById(int userId);

	/**
	 * 更新
	 * @param map
	 * @return int
	 */
	int updateUser(Map<String, String> map);
	
	/**
	 * 删除
	 * @param userIdString
	 * @return int
	 */
	int deleteUser(String userIdString);

	/**
	 * 查询用户总数
	 * @return String
	 */
	int queryUserCount();

	/**
	 * 根据页面和每页显示的条数查询
	 * @param pageNum
	 * @param pageSize
	 * @return List<User>
	 */
	List<User> queryPageDate(int pageNum, int pageSize);

	/**
	 * 系统初始化
	 * @return int
	 */
	int sysInit();

}
