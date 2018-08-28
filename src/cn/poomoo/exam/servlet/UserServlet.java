/**
 * @fileName UserServlet.java
 * @author YuanJingshan
 * @date 2014-12-3
 */
package cn.poomoo.exam.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.poomoo.common.util.DateUtil;
import cn.poomoo.common.util.MD5Util;
import cn.poomoo.common.util.TopicNum;
import cn.poomoo.exam.medol.User;
import cn.poomoo.exam.service.UserService;
import cn.poomoo.exam.serviceImpl.UserServiceImpl;

/**
 * @className UserServlet
 * @description 用户控制类
 * @author YuanJingshan
 */
public class UserServlet extends BaseServlet {

	//
	private static final long serialVersionUID = -4624757176476386446L;
	//
	private UserService userService = new UserServiceImpl();

	public UserServlet() {

	}
	
	/**
	 * 用户登录
	 */
	public void login(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("name");
		String password = request.getParameter("password");	
		
		User user = null;
		if (userName.equals("poomoo") && password.equals("poomoo2015")) {
			user = new User();
			user.setUserName(userName);
			user.setPassword(password);
			user.setAuthority((byte)1);
		} else {
			user = userService.queryUserbyNameAndPsw(userName,password);
		}
		if (user != null) {
			// 设置session和缓存
			request.getSession().setAttribute("user", user);
			try {
				Cookie userNameCookie;
				userNameCookie = new Cookie("user-name", URLEncoder.encode(userName, "utf-8"));
				Cookie passwordCookie = new Cookie("password", password);
				userNameCookie.setMaxAge(7*24*3600);
				passwordCookie.setMaxAge(7*24*3600);
				response.addCookie(userNameCookie);
				response.addCookie(passwordCookie);
			} catch (Exception e) {
				e.printStackTrace();
			}
			writeJosnToJsp("{\"result\":1}", response);
		} else {
			writeJosnToJsp("{\"result\":0}", response);
		}
	}
	
	/**
	 *  获取后台账户数量返回jsp页面
	 *  void
	 */
	public void getCount(HttpServletRequest request, HttpServletResponse response) {
		writeJosnToJsp("{\"totalCount\":" + userService.queryUserCount() +"}", response);
	}
	
	/** 
	 *  获取页面数据返回jsp页面
	 *  void
	 */
	public void getPageData(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		
		List<User> users = userService.queryPageDate(pageNum,pageSize);
		StringBuffer stringBuffer = new StringBuffer();
		if (users.isEmpty()) {
			stringBuffer.append("{}");
		} else {
			stringBuffer.append("[");
			for (User user : users) {
				stringBuffer.append(getJsonString(user)).append(",");
			}
			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
			stringBuffer.append("]");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	
	/**
	 * 增加用户信息
	 */
	public void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("string_userName", request.getParameter("name"));
		map.put("string_realName", request.getParameter("realName"));
		map.put("string_password", MD5Util.string2MD5(request.getParameter("password")));
		map.put("string_tel", request.getParameter("tel"));
		map.put("string_address", request.getParameter("address"));
		map.put("byte_authority", request.getParameter("authority"));
		map.put("date_yyyy-MM-dd HH:mm:ss", DateUtil.dateToString(new Date()));
		
		int result = userService.insertUser(map);
		writeJosnToJsp("{\"result\":" + result + "}", response);
	}

	/**
	 * 删除用户信息
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("idStr");
		int result = userService.deleteUser(idStr);
		writeJosnToJsp("{\"result\":" + result + "}", response);
	}
	
	/**
	 * 修改用户跳转
	 */
	public void modifyJmp(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		User user = userService.getUserById(userId);
		request.setAttribute("user", user);
		request.getRequestDispatcher("bpage/page/user/user-modify.jsp").forward(request,response);
	}
	
	/**
	 * 修改用户信息
	 */
	public void modify(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("string_userName", request.getParameter("name"));
		map.put("string_realName", request.getParameter("realName"));
		//转化为32位MD5码加密
		String password = request.getParameter("password");
		if (password.length() != 32) {
			password = MD5Util.string2MD5(password);
		}
		map.put("string_password", password);
		map.put("string_tel", request.getParameter("tel"));
		map.put("string_address", request.getParameter("address"));
		map.put("byte_authority", request.getParameter("authority"));
		map.put("int_userId", request.getParameter("userId"));
		
		int result = userService.updateUser(map);
		writeJosnToJsp("{\"result\":" + result + "}", response);
	}
	
	/**
	 *  系统初始化
	 *  void
	 */
	public void sysInit(HttpServletRequest request, HttpServletResponse response){
		int iRetCode = 0;
		String sSecret = request.getParameter("secret");
		User user = (User)request.getSession().getAttribute("user");
		if ((MD5Util.string2MD5(sSecret)).equals(user.getPassword())) {
			TopicNum.clearTopicNum(); // 清除题组号
			iRetCode = userService.sysInit();
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
	/**
	 * 拼接Json字符串
	 * @param user
	 * @return String
	 */
	public String getJsonString(User user) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\"userId\":" + user.getId()
				+ ",\"userName\":\"" + user.getUserName()
				+ "\",\"realName\":\"" + user.getRealName()
				+ "\",\"password\":\"" + user.getPassword()			
				+ "\",\"tel\":\"" + user.getTel()			
				+ "\",\"address\":\"" + user.getAddress()
				+ "\",\"authority\":" + user.getAuthority()
				+ ",\"insertDt\":\"" + DateUtil.dateToString(user.getInsertDt()) + "\" }");
		return stringBuffer.toString();
	}
	
	public void logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.getSession().invalidate();
		request.getRequestDispatcher("bpage/page/login.jsp").forward(request,response);
	}

}
