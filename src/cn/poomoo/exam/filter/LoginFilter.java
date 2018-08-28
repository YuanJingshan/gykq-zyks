/**
 * @fileName LoginFilter.java
 * @author YuanJingshan
 * @date 2014-12-25
 */
package cn.poomoo.exam.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.poomoo.exam.medol.User;
import cn.poomoo.exam.service.UserService;
import cn.poomoo.exam.serviceImpl.UserServiceImpl;

/**
 * @className LoginFilter
 * @description
 * @author YuanJingshan
 */
public class LoginFilter implements Filter {
	// 用户接口
	UserService userService = new UserServiceImpl();
	
	public void init(FilterConfig arg0) throws ServletException {

	}

	/**
	 * 网站后台用户登录过滤
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// 获得在下面代码中要用的request,response,session对象
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();

		// 获得用户请求的URI
		String path = servletRequest.getRequestURI();
		// System.out.println(path);

		// 从session里取员工工号信息
		User user = (User) session.getAttribute("user");
		
		/*
		 * 创建类Constants.java，里面写的是无需过滤的页面 
		 * for (int i = 0; i < Constants.NoFilter_Pages.length; i++) {
		 * 		if (path.indexOf(Constants.NoFilter_Pages[i]) > -1) {
		 * 			chain.doFilter(servletRequest, servletResponse); 
		 * 		} 
		 * }
		 */
		
		// 登陆页面无需过滤
		if (path.indexOf("bpage/page/login.jsp") > -1) {
			chain.doFilter(servletRequest, servletResponse);
			return;
		}

		// 判断如果没有取到员工信息,就跳转到登陆页面
		if (user == null || "".equals(user)) {
			// 判断cookie 中是否存在
			Cookie[] cookies = ((HttpServletRequest) request).getCookies();
	        String userName = null;
	        String password = null;
	        try {
	        	 if (cookies != null) {     
	 	            for (Cookie c : cookies) {   
	 	                if (c.getName().equals("user-name")) {     
	 	                	userName = URLDecoder.decode(c.getValue(), "utf-8");   
	 	                } 
	 	                if (c.getName().equals("password")) {
	 	                	password = URLDecoder.decode(c.getValue(), "utf-8");
	 					}
	 	             }     
	 	        }
			} catch (Exception e) {
				e.printStackTrace();
			}
	        if (userName != null && password != null) {
				user = userService.queryUserbyNameAndPsw(userName, password);
			}
	        if (user != null) {
	        	servletRequest.getSession().setAttribute("user", user);
	        	// 已经登陆,继续此次请求
				chain.doFilter(request, response);
			} else {
				// 跳转到登陆页面
				request.getRequestDispatcher("/bpage/page/login.jsp").forward(servletRequest, servletResponse);
			}
		} else {
			// 已经登陆,继续此次请求
			chain.doFilter(request, response);
		}
	}
	
	public void destroy() {
		
	}
}
