package cn.poomoo.exam.init.servlet;
/**
 * @fileName BaseServlet.java
 * @author YuanJingshan
 * @date 2014-12-2
 */


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import cn.poomoo.common.util.NumberUtil;

/**
 * @className BaseServlet
 * @description
 * @author YuanJingshan
 */
public class InitServlet extends HttpServlet {
	
	private static final long serialVersionUID = -1617866107735356663L;

	@Override
	public void init() throws ServletException {
		NumberUtil.init();
	}
	
}