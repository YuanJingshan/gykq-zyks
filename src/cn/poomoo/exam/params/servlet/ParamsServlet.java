/**
 * @fileName UserServlet.java
 * @author YuanJingshan
 * @date 2014-12-3
 */
package cn.poomoo.exam.params.servlet;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.poomoo.common.Constant;
import cn.poomoo.common.util.JsonUtil;
import cn.poomoo.common.util.MD5Util;
import cn.poomoo.common.util.NumberUtil;
import cn.poomoo.exam.medol.User;
import cn.poomoo.exam.params.model.Params;
import cn.poomoo.exam.params.service.ParamsService;
import cn.poomoo.exam.params.service.impl.ParamsServiceImpl;
import cn.poomoo.exam.servlet.BaseServlet;

/**
 * 考试参数
 *
 * @author Yuan Jingshan
 * @date 2017-4-30
 * @version 1.0.0
 */
public class ParamsServlet extends BaseServlet {

	//
	private static final long serialVersionUID = -4624757176476386446L;
	//
	private ParamsService paramsService = new ParamsServiceImpl();

	public ParamsServlet() {

	}

	public void getParams(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Params params = paramsService.queryParams();
		writeJosnToJsp(JsonUtil.jsonToString(params), response);
	}
	
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("float_station1jgx", request.getParameter("station1jgx"));
		map.put("float_station2jgx", request.getParameter("station2jgx"));
		map.put("float_station3jgx", request.getParameter("station3jgx"));
		map.put("float_station4jgx", request.getParameter("station4jgx"));
		map.put("float_station5jgx", request.getParameter("station5jgx"));
		map.put("float_station6jgx", request.getParameter("station6jgx"));
		map.put("int_topic1", request.getParameter("topic1"));
		map.put("int_topic2", request.getParameter("topic2"));
		map.put("int_topic3", request.getParameter("topic3"));
		map.put("int_topic4", request.getParameter("topic4"));
		map.put("int_topic5", request.getParameter("topic5"));
		map.put("int_topic6", request.getParameter("topic6"));
		map.put("int_serialNumber", request.getParameter("serialNumber"));
		map.put("int_id", request.getParameter("id"));
		int result = paramsService.updateParams(map);
		writeJosnToJsp("{\"result\":" + result + "}", response);
	}
	
	public void sysInit(HttpServletRequest request, HttpServletResponse response){
		int iRetCode = Constant.REQUEST_FAILED;
		User user = (User)request.getSession().getAttribute("user");
		String password = request.getParameter("password");
		if (user.getPassword().equals(MD5Util.string2MD5(password))) {
			// 清除序号，从新开始计算
			NumberUtil.init();
			iRetCode = paramsService.sysInit();
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
}
