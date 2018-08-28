package cn.poomoo.exam.servlet;
/**
 * @fileName BaseServlet.java
 * @author YuanJingshan
 * @date 2014-12-2
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.poomoo.common.util.LogUtil;

/**
 * @className BaseServlet
 * @description
 * @author YuanJingshan
 */
public class BaseServlet extends HttpServlet {
	//
	private static final long serialVersionUID = 1L;

	public BaseServlet() {
	}
	
	@Override
	public void init() throws ServletException {
	}
	
	@Override
	public void destroy() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		this.process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		this.process(request, response);
	}
	
	/**
	 * 向页面输出jso字符串
	 *
	 * @param jsonString void
	 */
	public void writeJosnToJsp(String jsonString, HttpServletResponse response) {
		// 需要设置ContentType "Content-type: text/html; charset=utf8" 解决中文乱码
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			// 向客户端输出JSONObject字符串
			out.println(jsonString);
		} catch (IOException e) {
			LogUtil.getInstance().getLogger().error("向页面输出json数据异常...");
		}
		out.flush();
		out.close();
	}
	
	/**
	 * 方法映射-根据页面提交的地址映射servlet内容
	 *
	 * @param request
	 * @param response
	 * @throws ServletException void
	 */
	private void process(HttpServletRequest request, HttpServletResponse response) {
		String methodFlag = request.getParameter("method");
		Class<?> clz = this.getClass();
		Method method = null;
		try {
			method = clz.getDeclaredMethod(methodFlag,HttpServletRequest.class,HttpServletResponse.class);
			method.invoke(this, request, response);
		}catch(Exception e) {
			LogUtil.getInstance().getLogger().error("方法映射异常...");
			e.printStackTrace();
		}
	}
	
}
