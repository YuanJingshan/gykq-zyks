/**
 * @file StationDoctorServlet.java
 * @author yuanjingshan
 * @date 2015-6-18
 */
package cn.poomoo.exam.station.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.poomoo.common.Constant;
import cn.poomoo.common.util.JsonUtil;
import cn.poomoo.exam.service.InspectService;
import cn.poomoo.exam.serviceImpl.InspectServiceImpl;
import cn.poomoo.exam.servlet.BaseServlet;
import cn.poomoo.exam.station.model.StationInfo;
import cn.poomoo.exam.station.service.StationInfoService;
import cn.poomoo.exam.station.service.impl.StationInfoServiceImpl;

/**
 * @class StationDoctorServlet
 * @description 考站考生-Servlet
 */
public class StationInfoServlet extends BaseServlet {

	private static final long serialVersionUID = -39238995007526550L;
	private InspectService inspectService = new InspectServiceImpl();
	private StationInfoService stationInfoService = new StationInfoServiceImpl();
	
	//考生检录
	public void inspect(HttpServletRequest request, HttpServletResponse response) {
		int iRetCode = Constant.INSPECT_FAIL;
		String id = request.getParameter("id");
		String station = request.getParameter("station");
		if (!id.isEmpty() && !station.isEmpty()) {
			Map<String, String> map = new LinkedHashMap<String, String>();
			map.put("int_id", id);
			map.put("int_station", station);
			iRetCode = inspectService.stationInspect(map);
		} 
		writeJosnToJsp("{\"result\":" + iRetCode + "}",response);
	}
	
	//查询候考区考生信息
	public void wait(HttpServletRequest request, HttpServletResponse response) {
		String station = request.getParameter("station");
		StringBuffer stringBuffer = new StringBuffer();
		List<StationInfo> waits = new ArrayList<StationInfo>();
		if (!station.isEmpty() && !"".equals(station)) {
			waits = stationInfoService.getByStatus(Constant.INSPECTFLAGYES, Integer.parseInt(station));
		}
		stringBuffer.append("{\"wait\":" + waits.size() + ",\"info\":")
					.append(JsonUtil.jsonToString(waits)).append("}");
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	//查询正在考试考生信息
	public void exam(HttpServletRequest request, HttpServletResponse response) {
		String station = request.getParameter("station");
		StringBuffer stringBuffer = new StringBuffer();
		List<StationInfo> exams = new ArrayList<StationInfo>();
		if (!station.isEmpty() && !"".equals(station)) {
			exams = stationInfoService.getByStatus(Constant.INSPECTFLAGYESENTRYSTATION, Integer.parseInt(station));
		}
		stringBuffer.append("{\"exam\":" + exams.size() + ",\"info\":")
					.append(JsonUtil.jsonToString(exams)).append("}");
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	//查询已登分的考试
	public void exit(HttpServletRequest request, HttpServletResponse response) {
		String station = request.getParameter("station");
		StringBuffer stringBuffer = new StringBuffer();
		List<StationInfo> exits = new ArrayList<StationInfo>();
		if (!station.isEmpty() && !"".equals(station)) {
			exits = stationInfoService.getByStatus(Constant.INSPECTFLAGYESEXAMOVER, Integer.parseInt(station));
		}
		stringBuffer.append("{\"exit\":" + exits.size() + ",\"info\":")
					.append(JsonUtil.jsonToString(exits)).append("}");
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	//查询已审核的考试
	public void verify(HttpServletRequest request, HttpServletResponse response) {
		String station = request.getParameter("station");
		StringBuffer stringBuffer = new StringBuffer();
		List<StationInfo> exits = new ArrayList<StationInfo>();
		if (!station.isEmpty() && !"".equals(station)) {
			exits = stationInfoService.getByStatus(Constant.STATION_VERIFY, Integer.parseInt(station));
		}
		stringBuffer.append("{\"verify\":" + exits.size() + ",\"info\":")
					.append(JsonUtil.jsonToString(exits)).append("}");
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	//进入考场
	public void entryExam(HttpServletRequest request, HttpServletResponse response) {
		int iRetcode = Constant.ENTRYSTATION_FAIL;
		String id = request.getParameter("id");
		String station = request.getParameter("station");
		if (!id.isEmpty() && !"".equals(id) && !station.isEmpty() && !"".equals(station)) {
			iRetcode = stationInfoService.updateStatus(Integer.parseInt(station), Integer.parseInt(id), Constant.INSPECTFLAGYESENTRYSTATION);
		}
		writeJosnToJsp("{\"result\":" + iRetcode + "}", response);
	}
	
	//返回等待
	public void cancalExam(HttpServletRequest request, HttpServletResponse response) {
		int iRetcode = Constant.CANCELENTRYSTATIONFAIL;
		String id = request.getParameter("id");
		String station = request.getParameter("station");
		if (!id.isEmpty() && !"".equals(id) && !station.isEmpty() && !"".equals(station)) {
			iRetcode = stationInfoService.updateStatus(Integer.parseInt(station), Integer.parseInt(id), Constant.INSPECTFLAGYES);
		}
		writeJosnToJsp("{\"result\":" + iRetcode + "}", response);
	}
	
	//审核退出
	public void exitVerify(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String station = request.getParameter("station");
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("int_id", id);
		map.put("int_station", station);
		int iRetCode = stationInfoService.exit(map);
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
	
	//考站情况
	public void info(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer stringBuffer = new StringBuffer();
		String wait = "\"wait\":{\"count\":0,\"info\":[]}";
		String exam = "\"exam\":{\"count\":0,\"info\":[]}";
		List<StationInfo> waits = new ArrayList<StationInfo>();
		List<StationInfo> exams = new ArrayList<StationInfo>();
		String station = request.getParameter("station");
		if (!station.isEmpty() && !"".equals(station)) {
			waits = stationInfoService.getByStatus(Constant.INSPECTFLAGYES, Integer.parseInt(station));
			exams = stationInfoService.getByStatus(Constant.INSPECTFLAGYESENTRYSTATION, Integer.parseInt(station));
		}
		wait = "\"wait\":{\"count\":" + waits.size() + ",\"info\":" + JsonUtil.jsonToString(waits) + "}";
		exam = "\"exam\":{\"count\":" + exams.size() + ",\"info\":" + JsonUtil.jsonToString(exams) + "}";
		stringBuffer.append("{").append(wait).append(",").append(exam).append("}");
		writeJosnToJsp(stringBuffer.toString(),response);
	}
}