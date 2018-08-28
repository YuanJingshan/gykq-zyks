/**
 * @fileName StationScoreServlet.java
 * @author YuanJingshan
 * @date 2015-6-13
 */
package cn.poomoo.exam.station.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import cn.poomoo.common.Constant;
import cn.poomoo.common.ExportExcel;
import cn.poomoo.common.util.DateUtil;
import cn.poomoo.common.util.JsonUtil;
import cn.poomoo.exam.medol.StationScoreExcel;
import cn.poomoo.exam.service.ExamScoreService;
import cn.poomoo.exam.serviceImpl.ExamScoreServiceImpl;
import cn.poomoo.exam.servlet.BaseServlet;
import cn.poomoo.exam.station.model.StationInfo;
import cn.poomoo.exam.station.model.StationScoreEx;
import cn.poomoo.exam.station.service.StationInfoService;
import cn.poomoo.exam.station.service.StationScoreExService;
import cn.poomoo.exam.station.service.impl.StationInfoServiceImpl;
import cn.poomoo.exam.station.service.impl.StationScoreExServiceImpl;

/**
 * @className StationScoreServlet
 * @description 考站成绩Servlet
 * @author YuanJingshan
 */
public class StationScoreExtServlet extends BaseServlet {

	//
	private static final long serialVersionUID = 1258038069180360190L;
	
	private ExamScoreService examScoreService = new ExamScoreServiceImpl();
	private StationInfoService stationInfoService = new StationInfoServiceImpl();
	private StationScoreExService stationScoreExService = new StationScoreExServiceImpl();
	
	public void addPoints(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String station = request.getParameter("station");
		int iRetCode = 0;
		if (!id.isEmpty() && !"".equals(id) && !station.isEmpty() && !"".equals(station)) {
			Map<String, String> map = new LinkedHashMap<String, String>();
			StationInfo doctor = stationInfoService.getByID(Integer.parseInt(station), Integer.parseInt(id));
			
			if (doctor != null) { // 录入分数
				map.put("int_id", id);
				map.put("string_topic", doctor.getTopic());
				map.put("string_serialNumber", doctor.getSerialNumber());
				map.put("float_score", request.getParameter("count"));
				for (int i=1; i<=6; i++) {
					map.put("float_count_" + i, request.getParameter("count-"+i));
					for (int j=1; j<=8; j++) {
						map.put("float_topic_" + i + "_" + j, request.getParameter("tipic-" + i + "-" + j));
					}
				}
				map.put("date_entryDt", DateUtil.dateToString(doctor.getInsertDt()));
				map.put("date_insertDt", DateUtil.dateToString(new Date()));
				map.put("int_station", station);
			}
			if (stationScoreExService.add(map) == 1) { // 更新状态-出站
				map.clear();
				map.put("int_id", id);
				map.put("int_station", station);
				iRetCode = stationInfoService.updateStatus(Integer.parseInt(station), Integer.parseInt(id), Constant.INSPECTFLAGYESEXAMOVER);
//				if (stationInfoService.exit(map) == 0) {
//					iRetCode = 1;
//				}
			}
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
	
	//查询通总数和通过率
	public void count(HttpServletRequest request, HttpServletResponse response) {
		String station = request.getParameter("station");
		double dThrou = 0;
		int iCount = stationScoreExService.getCount(Integer.parseInt(station));
		if (iCount > 0) {
			int iThrouCount = stationScoreExService.getThrou(Integer.parseInt(station), null);
			dThrou = (double)iThrouCount/iCount;
		}
		String sThrou = String.format("%.4f", dThrou);
		dThrou = Double.parseDouble(new BigDecimal(Double.parseDouble(sThrou)*100).setScale(2, BigDecimal.ROUND_HALF_UP).toString());;
		writeJosnToJsp("{\"totalCount\":" + iCount + ",\"othersRcord\":" + dThrou + "}", response);
	}
	
	//获取页面数据返回jsp页面
	public void getPageData(HttpServletRequest request, HttpServletResponse response) {
		String station = request.getParameter("station");
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		List<StationScoreEx> scores = stationScoreExService.getPageData(Integer.parseInt(station), pageNum, pageSize);
		writeJosnToJsp(JsonUtil.jsonToString(scores), response);
	}
	
	//删除医生考站成绩
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String station = request.getParameter("station");
		String idStr = request.getParameter("idStr");
		int result = stationScoreExService.delete(Integer.parseInt(station), idStr);
		writeJosnToJsp("{\"result\":" + result + "}", response);
	}
	
	//获取第二站考试成绩详细
	public void score(HttpServletRequest request, HttpServletResponse response) {
		String station = request.getParameter("station");
		String id = request.getParameter("id");
		StationScoreEx score = stationScoreExService.getScoreDetail(Integer.parseInt(station), Integer.parseInt(id));
		JSONArray jsonArray = JSONArray.fromObject(score);
		writeJosnToJsp(jsonArray.toString(), response);
	}
	
	//修改考生成绩
	public void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String station = request.getParameter("station");
		String id = request.getParameter("id");
		int iRetCode = 0;
		Map<String, String> map = new LinkedHashMap<String, String>();
		StationScoreEx stationScore = stationScoreExService.getScoreDetail(Integer.parseInt(station), Integer.parseInt(id));
		if (stationScore != null) { // 录入分数
			map.put("float_score", request.getParameter("count"));
			for (int i=1; i<=6; i++) {
				map.put("float_count_" + i, request.getParameter("count-"+i));
				for (int j=1; j<=8; j++) {
					map.put("float_topic_" + i + "_" + j, request.getParameter("tipic-" + i + "-" + j));
				}
			}
			map.put("int_id", id);
			map.put("int_station", station);
			if (stationScoreExService.update(map) == 1) {
				map.clear();
				map.put("int_id", id);
				iRetCode = examScoreService.updateExamScore(map);
			}
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
	
	//查询成绩记录总数，根据条件
	public void countBycon(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition").replace("mhcx", "%").replace("/", "-");
		String station = request.getParameter("station");
		int iCount = stationScoreExService.getConutByCon(Integer.parseInt(station), condition);
		double dThrou = 0;
		if (iCount > 0) {
			int iThrouCount = stationScoreExService.getThrou(Integer.parseInt(station), condition);
			dThrou = (double)iThrouCount/iCount;
		}
		String sThrou = String.format("%.4f", dThrou);
		dThrou = Double.parseDouble(new BigDecimal(Double.parseDouble(sThrou)*100).setScale(2, BigDecimal.ROUND_HALF_UP).toString());;
		writeJosnToJsp("{\"totalCount\":" + iCount + ",\"othersRcord\":" + dThrou + "}", response);
	}
	
	//查询成绩页面数据，根据条件
	public void getPageDataStation1ByCondition(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition").replace("mhcx", "%").replace("/", "-");
		String station = request.getParameter("station");
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		List<StationScoreEx> scores = stationScoreExService.getPageDataByCon(Integer.parseInt(station), condition, pageNum, pageSize);
		writeJosnToJsp(JsonUtil.jsonToString(scores),response);
	}
	
	//excel表格导出
	public void exportScore(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition");
		String station = request.getParameter("station");
		
		List<StationScoreExcel> stationScores = new ArrayList<StationScoreExcel>();
		if (condition.equals("all")) {
			stationScores = stationScoreExService.getScore(Integer.parseInt(station), "1=1");
		} else {
			stationScores = stationScoreExService.getScore(Integer.parseInt(station), condition);
		}
		ExportExcel<StationScoreExcel> ex = new ExportExcel<StationScoreExcel>();
        String[] headers = { "数据库编号", "姓名", "性别", "名族", "出生日期", "身份证", "准考证号", "考试类别", "题组号", "成绩", "进站时间", "出站时间" };
		try {
			// 输出到页面前端
			String fileStr = "score_" + station + "_" + DateUtil.dateToString(new Date(), "yyyyMMdd-HHmmss") + ".xls";
			String responseHeader = "attachment;filename=" + fileStr;
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition", responseHeader);
		      
			OutputStream out = response.getOutputStream();
			ex.exportExcel(headers, stationScores, out);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
