/**
 * @fileName StationScoreServlet.java
 * @author YuanJingshan
 * @date 2015-6-13
 */
package cn.poomoo.exam.servlet;

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

import cn.poomoo.common.Constant;
import cn.poomoo.common.ExportExcel;
import cn.poomoo.common.util.DateUtil;
import cn.poomoo.common.util.JsonUtil;
import cn.poomoo.exam.medol.StationDoctor;
import cn.poomoo.exam.medol.StationScore;
import cn.poomoo.exam.medol.StationScoreExcel;
import cn.poomoo.exam.service.ExamScoreService;
import cn.poomoo.exam.service.StationDoctorService;
import cn.poomoo.exam.service.StationScoreService;
import cn.poomoo.exam.serviceImpl.ExamScoreServiceImpl;
import cn.poomoo.exam.serviceImpl.StationDoctorServiceImpl;
import cn.poomoo.exam.serviceImpl.StationScoreServiceImpl;

/**
 * @className StationScoreServlet
 * @description 考站成绩Servlet
 * @author YuanJingshan
 */
public class StationScoreServlet extends BaseServlet {

	//
	private static final long serialVersionUID = 1258038069180360190L;
	//
	private StationScoreService stationScoreService = new StationScoreServiceImpl();
	//
	private StationDoctorService stationDoctorService = new StationDoctorServiceImpl();
	//
	private ExamScoreService examScoreService = new ExamScoreServiceImpl();
	
	/**
	 *  获取后台账户数量返回jsp页面
	 *  void
	 */
	public void getCountFirst(HttpServletRequest request, HttpServletResponse response) {
		int iCount = stationScoreService.queryCountFirst();
		//added yjs at 2015-07-02 begin
		double dThrou = 0;
		if (iCount > 0) {
			int iThrouCount = stationScoreService.queryThrouCountFirst(null);
			dThrou = (double)iThrouCount/iCount;
		}
		String sThrou = String.format("%.4f", dThrou);
		dThrou = Double.parseDouble(new BigDecimal(Double.parseDouble(sThrou)*100).setScale(2, BigDecimal.ROUND_HALF_UP).toString());;
		writeJosnToJsp("{\"totalCount\":" + iCount + ",\"othersRcord\":" + dThrou + "}", response);
		//added yjs at 2015-07-02 end
	}
	
	/** 
	 *  获取页面数据返回jsp页面
	 *  void
	 */
	public void getPageDataFirst(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		
		List<StationScore> stationScores = stationScoreService.queryPageDateFirst(pageNum,pageSize);
		StringBuffer stringBuffer = new StringBuffer();
		if (stationScores.isEmpty()) {
			stringBuffer.append("{}");
		} else {
			stringBuffer.append("[");
			for (StationScore item : stationScores) {
				stringBuffer.append(getJsonString(item)).append(",");
			}
			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
			stringBuffer.append("]");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	// added by yjs at 2015-07-04 begin
	/**
	 *  第一考站：查询成绩记录总数，根据条件
	 *  void
	 */
	public void getCountStation1ByCondition(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition").replace("mhcx", "%").replace("/", "-");
		int iCount = stationScoreService.queryCountStation1Condition(condition);
		// added by yjs at 2016-07-02 begin
		double dThrou = 0;
		if (iCount > 0) {
			int iThrouCount = stationScoreService.queryThrouCountFirst(condition);
			dThrou = (double)iThrouCount/iCount;
		}
		String sThrou = String.format("%.4f", dThrou);
		dThrou = Double.parseDouble(new BigDecimal(Double.parseDouble(sThrou)*100).setScale(2, BigDecimal.ROUND_HALF_UP).toString());;
		//writeJosnToJsp("{\"totalCount\":" + iCount +"}", response);
		writeJosnToJsp("{\"totalCount\":" + iCount + ",\"othersRcord\":" + dThrou + "}", response);
		// added by yjs at 2016-07-02 begin
	}

	/** 
	 *  第一考站：查询成绩页面数据，根据条件
	 *  void
	 */
	public void getPageDataStation1ByCondition(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition").replace("mhcx", "%").replace("/", "-");
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		
		List<StationScore> stationScores = stationScoreService.queryPageDateStation1Condition(condition, pageNum, pageSize);
		StringBuffer stringBuffer = new StringBuffer();
		if (stationScores.isEmpty()) {
			stringBuffer.append("{}");
		} else {
			stringBuffer.append("[");
			for (StationScore item : stationScores) {
				stringBuffer.append(getJsonString(item)).append(",");
			}
			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
			stringBuffer.append("]");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	// added by yjs at 2015-07-04 end
	
	/**
	 * 删除医生第一站成绩
	 */
	public void deleteFirst(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("idStr");
		int result = stationScoreService.deleteFirst(idStr);
		writeJosnToJsp("{\"result\":" + result + "}", response);
	}
	
	/**
	 * 第一考站：录入医生成绩并出站
	 */
	public void addStation1Score(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		int iRetCode = 0;
		if (!id.isEmpty()) {
			Map<String, String> map = new LinkedHashMap<String, String>();
			StationDoctor stationDoctor = stationDoctorService.queryStation1DoctorById(Integer.parseInt(id));
			
			if (stationDoctor != null) { // 录入分数
				map.put("int_id", id);
				map.put("string_topic", stationDoctor.getTopic());
				map.put("string_serialNumber", stationDoctor.getSerialNumber());
				map.put("float_score", request.getParameter("count"));
				for (int i=1; i<=6; i++) {
					map.put("float_count_" + i, request.getParameter("count-"+i));
					for (int j=1; j<=8; j++) {
						map.put("float_topic_" + i + "_" + j, request.getParameter("tipic-" + i + "-" + j));
					}
				}
				map.put("date_entryDt", DateUtil.dateToString(stationDoctor.getInsertDt()));
				map.put("date_insertDt", DateUtil.dateToString(new Date()));
			}
			if (stationScoreService.insertStation1Score(map) == 1) { // 更新状态-出站
				map.clear();
				map.put("int_id", id);
				iRetCode = stationDoctorService.updateStation1DoctorFlag(Integer.parseInt(id), Constant.INSPECTFLAGYESEXAMOVER);
//				if (stationDoctorService.station1Exit(map) == 0) {
//					iRetCode = 1;
//				}
			}
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	} 
	
	/**
	 * 获取第一站考试成绩详细
	 * @param request
	 * @param response void
	 */
	public void getStation1ScoreDetail(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		StationScore stationScore = null;
		StringBuffer stringBuffer = new StringBuffer();
		if (id != null) {
			stationScore = stationScoreService.queryStation1ScoreById(Integer.parseInt(id));
			stringBuffer.append("[").append(getJsonDetailString(stationScore)).append("]");
		} else {
			stringBuffer.append("[]");
		}
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	

	/**
	 * 第一考站：修改考生成绩
	 */
	public void modifyStation1Score(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		int iRetCode = 0;
		Map<String, String> map = new LinkedHashMap<String, String>();
		// modified by yjs at 2015-07-04 begin 原因：修改成绩出错
		//StationDoctor stationDoctor = stationDoctorService.queryStation1DoctorById(Integer.parseInt(id));
		StationScore stationScore = stationScoreService.queryStation1ScoreById(Integer.parseInt(id));
		// modified by yjs at 2015-07-04 end
		
		if (stationScore != null) { // 录入分数
			map.put("float_score", request.getParameter("count"));
			for (int i=1; i<=6; i++) {
				map.put("float_count_" + i, request.getParameter("count-"+i));
				for (int j=1; j<=8; j++) {
					map.put("float_topic_" + i + "_" + j, request.getParameter("tipic-" + i + "-" + j));
				}
			}
			map.put("int_id", id);
			if (stationScoreService.updateStation1Score(map) == 1) {
				map.clear();
				map.put("int_id", id);
				iRetCode = examScoreService.updateExamScore(map);
			}
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	} 
	
	/**
	 * excel表格导出
	 * @param request
	 * @param response void
	 */
	public void exportStation1Excel(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition");
		
		List<StationScoreExcel> stationScores = new ArrayList<StationScoreExcel>();
		if (condition.equals("all")) {
			stationScores = stationScoreService.queryStation1ExcelScoreAll();
		} else {
			stationScores = stationScoreService.queryStation1ScoreExcelByCondition(condition);
		}
		
		ExportExcel<StationScoreExcel> ex = new ExportExcel<StationScoreExcel>();
        String[] headers = { "数据库编号", "姓名", "性别", "名族", "出生日期", "身份证", "准考证号", "考试类别", "题组号", "成绩", "进站时间", "出站时间" };
		try {
			/*
			String excelPath = "C://examSysExport//" + DateUtil.dateToString(new Date(), "yyyy-MM-dd") + "//"; 
			String fileStr = excelPath + new Date().getTime() + ".xls";
			
			File excelDir = new File(excelPath);
			if (!excelDir.exists() && !excelDir.isDirectory()) {
				excelDir.mkdir();
			}
			
			OutputStream out = new FileOutputStream(fileStr); -- 输出到服务器
			result = ex.exportExcel(headers, stationScores, out);
		  	out.close();
			*/
			
			// 输出到页面前端
			String fileStr = "score_1_" + DateUtil.dateToString(new Date(), "yyyyMMdd-HHmmss") + ".xls";
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
	
	/**
	 *  获取后台账户数量返回jsp页面
	 *  void
	 */
	public void getCountSecond(HttpServletRequest request, HttpServletResponse response) {
		// added by yjs at 2016-07-02 begin
		//writeJosnToJsp("{\"totalCount\":" + stationScoreService.queryCountSecond() +"}", response);
		int iCount = stationScoreService.queryCountSecond();
		double dThrou = 0;
		if (iCount > 0) {
			int iThrouCount = stationScoreService.queryThrouCountSecond(null);
			dThrou = (double)iThrouCount/iCount;
		}
		String sThrou = String.format("%.4f", dThrou);
		dThrou = Double.parseDouble(new BigDecimal(Double.parseDouble(sThrou)*100).setScale(2, BigDecimal.ROUND_HALF_UP).toString());;
		writeJosnToJsp("{\"totalCount\":" + iCount + ",\"othersRcord\":" + dThrou + "}", response);
		//added by yjs at 2016-07-02 end
	}
	
	/** 
	 *  获取页面数据返回jsp页面
	 *  void
	 */
	public void getPageDataSecond(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		
		List<StationScore> stationScores = stationScoreService.queryPageDateSecond(pageNum,pageSize);
		
//		StringBuffer stringBuffer = new StringBuffer();
//		if (stationScores.isEmpty()) {
//			stringBuffer.append("{}");
//		} else {
//			stringBuffer.append("[");
//			for (StationScore item : stationScores) {
//				stringBuffer.append(getJsonString(item)).append(",");
//			}
//			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
//			stringBuffer.append("]");
//		}
		writeJosnToJsp(JsonUtil.jsonToString(stationScores),response);
	}
	
//deleted by yjs at 2016-07-02 begin
//	
//	/**
//	 *  第二考站：查询成绩记录总数，根据时间段
//	 *  void
//	 */
//	public void getCountStation2ByDate(HttpServletRequest request, HttpServletResponse response) {
//		String dateCondition = request.getParameter("date");
//		int iCount = stationScoreService.queryCountStation2Condition(dateCondition);
//		writeJosnToJsp("{\"totalCount\":" + iCount +"}", response);
//	}
//
//	/** 
//	 *  第二考站：查询成绩页面数据，根据时间段
//	 *  void
//	 */
//	public void getPageDataStation2ByDate(HttpServletRequest request, HttpServletResponse response) {
//		String dateCondition = request.getParameter("date");
//		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
//		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
//		
//		List<StationScore> stationScores = stationScoreService.queryPageDateStation2Condition(dateCondition, pageNum,pageSize);
//		StringBuffer stringBuffer = new StringBuffer();
//		if (stationScores.isEmpty()) {
//			stringBuffer.append("{}");
//		} else {
//			stringBuffer.append("[");
//			for (StationScore item : stationScores) {
//				stringBuffer.append(getJsonString(item)).append(",");
//			}
//			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
//			stringBuffer.append("]");
//		}
//		writeJosnToJsp(stringBuffer.toString(),response);
//	}
//	
//	/**
//	 *  第二考站：查询成绩记录总数，根据分数段
//	 *  void
//	 */
//	public void getCountStation2ByScore(HttpServletRequest request, HttpServletResponse response) {
//		String scoreCondition = request.getParameter("score");
//		int iCount = stationScoreService.queryCountStation2Condition(scoreCondition);
//		writeJosnToJsp("{\"totalCount\":" + iCount +"}", response);
//	}
//
//	/** 
//	 *  第二考站：查询成绩页面数据，根据分数段
//	 *  void
//	 */
//	public void getPageDataStation2ByScore(HttpServletRequest request, HttpServletResponse response) {
//		String scoreCondition = request.getParameter("score");
//		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
//		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
//		
//		List<StationScore> stationScores = stationScoreService.queryPageDateStation2Condition(scoreCondition, pageNum,pageSize);
//		StringBuffer stringBuffer = new StringBuffer();
//		if (stationScores.isEmpty()) {
//			stringBuffer.append("{}");
//		} else {
//			stringBuffer.append("[");
//			for (StationScore item : stationScores) {
//				stringBuffer.append(getJsonString(item)).append(",");
//			}
//			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
//			stringBuffer.append("]");
//		}
//		writeJosnToJsp(stringBuffer.toString(),response);
//	}
//deleted by yjs at 2016-07-02 end
	
	// added by yjs at 2015-07-04 begin
	/**
	 *  第二考站：查询成绩记录总数，根据条件
	 *  void 
	 */
	public void getCountStation2Condition(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition").replace("mhcx", "%").replace("/", "-");
		int iCount = stationScoreService.queryCountStation2Condition(condition);
		// added by yjs at 2016-07-02 begin
		double dThrou = 0;
		if (iCount > 0) {
			int iThrouCount = stationScoreService.queryThrouCountSecond(condition);
			dThrou = (double)iThrouCount/iCount;
		}
		String sThrou = String.format("%.4f", dThrou);
		dThrou = Double.parseDouble(new BigDecimal(Double.parseDouble(sThrou)*100).setScale(2, BigDecimal.ROUND_HALF_UP).toString());
		//writeJosnToJsp("{\"totalCount\":" + iCount +"}", response);
		writeJosnToJsp("{\"totalCount\":" + iCount + ",\"othersRcord\":" + dThrou + "}", response);
	}

	/** 
	 *  第一考站：查询成绩页面数据，根据条件
	 *  void
	 */
	public void getPageDataStation2ByCondition(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition").replace("mhcx", "%").replace("/", "-");
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		
		List<StationScore> stationScores = stationScoreService.queryPageDateStation2Condition(condition, pageNum,pageSize);
		StringBuffer stringBuffer = new StringBuffer();
		if (stationScores.isEmpty()) {
			stringBuffer.append("{}");
		} else {
			stringBuffer.append("[");
			for (StationScore item : stationScores) {
				stringBuffer.append(getJsonString(item)).append(",");
			}
			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
			stringBuffer.append("]");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	// added by yjs at 2015-07-04 end

	/**
	 * 删除医生信息
	 */
	public void deleteSecond(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("idStr");
		int result = stationScoreService.deleteSecond(idStr);
		writeJosnToJsp("{\"result\":" + result + "}", response);
	}
	
	/**
	 * 第二考站：录入医生成绩并出站
	 */
	public void addStation2Score(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		int iRetCode = 0;
		
		if (!id.isEmpty()) {
			Map<String, String> map = new LinkedHashMap<String, String>();
			if (stationScoreService.queryStation1FenshuById(Integer.parseInt(id))+ Float.parseFloat(request.getParameter("count")) > 100) { // 分数大于100
				iRetCode = 2;
			} else {
				StationDoctor stationDoctor = stationDoctorService.queryStation2DoctorById(Integer.parseInt(id));
				
				if (stationDoctor != null) { // 录入分数
					map.put("int_id", id);
					map.put("string_topic", stationDoctor.getTopic());
					map.put("string_serialNumber", stationDoctor.getSerialNumber());
					map.put("float_score", request.getParameter("count"));
					for (int i=1; i<=6; i++) {
						map.put("float_count_" + i, request.getParameter("count-"+i));
						for (int j=1; j<=8; j++) {
							map.put("float_topic_" + i + "_" + j, request.getParameter("tipic-" + i + "-" + j));
						}
					}
					map.put("date_entryDt", DateUtil.dateToString(stationDoctor.getInsertDt()));
					map.put("date_insertDt", DateUtil.dateToString(new Date()));
				}
				if (stationScoreService.insertStation2Score(map) == 1) { // 更新状态-出站
					map.clear();
					map.put("int_id", id);
					iRetCode = stationDoctorService.updateStation2DoctorFlag(Integer.parseInt(id), Constant.INSPECTFLAGYESEXAMOVER);
					/*if (stationDoctorService.station2Exit(map) == 0) {
						iRetCode = 1;
					}*/
				}
			}
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	} 
	
	/**
	 * 获取第二站考试成绩详细
	 * @param request
	 * @param response void
	 */
	public void getStation2ScoreDetail(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		StationScore stationScore = null;
		StringBuffer stringBuffer = new StringBuffer();
		if (id != null) {
			stationScore = stationScoreService.queryStation2ScoreById(Integer.parseInt(id));
			stringBuffer.append("[").append(getJsonDetailString(stationScore)).append("]");
		} else {
			stringBuffer.append("[]");
		}
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	/**
	 * 第二考站：修改考生成绩
	 */
	public void modifyStation2Score(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		int iRetCode = 0;
		Map<String, String> map = new LinkedHashMap<String, String>();
		// modified by yjs at 2015-07-04 begin 原因：修改分数出错
		//StationDoctor stationDoctor = stationDoctorService.queryStation2DoctorById(Integer.parseInt(id));
		StationScore stationScore = stationScoreService.queryStation2ScoreById(Integer.parseInt(id));
		// modified by yjs at 2015-07-04 end
		
		if (stationScore != null) { // 录入分数
			map.put("float_score", request.getParameter("count"));
			for (int i=1; i<=6; i++) {
				map.put("float_count_" + i, request.getParameter("count-"+i));
				for (int j=1; j<=8; j++) {
					map.put("float_topic_" + i + "_" + j, request.getParameter("tipic-" + i + "-" + j));
				}
			}
			map.put("int_id", id);
			if (stationScoreService.updateStation2Score(map) == 1) {
				map.clear();
				map.put("int_id", id);
				iRetCode = examScoreService.updateExamScore(map);
			}
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
	
	/**
	 * excel表格导出
	 * @param request
	 * @param response void
	 */
	public void exportStation2Excel(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition");
		
		List<StationScoreExcel> stationScores = new ArrayList<StationScoreExcel>();
		if (condition.equals("all")) {
			stationScores = stationScoreService.queryStation2ExcelScoreAll();
		} else {
			stationScores = stationScoreService.queryStation2ScoreExcelByCondition(condition);
		}
		
		ExportExcel<StationScoreExcel> ex = new ExportExcel<StationScoreExcel>();
        String[] headers = { "数据库编号", "姓名", "性别", "名族", "出生日期", "身份证", "准考证号", "题组号", "考试类别", "成绩", "进站时间", "出站时间" };
		try {
//			String fileStr = "E://examSysExport//" + new Date().getTime() + ".xls";
//			OutputStream out = new FileOutputStream(fileStr);
//			result = ex.exportExcel(headers, stationScores, out);
//		    out.close();
		    
		    // 输出到页面前端
			String fileStr = "score_2_" + DateUtil.dateToString(new Date(), "yyyyMMdd-HHmmss") + ".xls";
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
	
	// added by yjs at 2015-07-04 begin
	/**
	 *  获取后台账户数量返回jsp页面
	 *  void
	 */
	public void getCountThree(HttpServletRequest request, HttpServletResponse response) {
		//added by yjs at 2016-07-02 begin
		//writeJosnToJsp("{\"totalCount\":" + stationScoreService.queryCountThree() +"}", response);
		int iCount = stationScoreService.queryCountThree();
		double dThrou = 0;
		if (iCount > 0) {
			int iThrouCount = stationScoreService.queryThrouCountThree(null);
			dThrou = (double)iThrouCount/iCount;
		}
		String sThrou = String.format("%.4f", dThrou);
		dThrou = Double.parseDouble(new BigDecimal(Double.parseDouble(sThrou)*100).setScale(2, BigDecimal.ROUND_HALF_UP).toString());;
		writeJosnToJsp("{\"totalCount\":" + iCount + ",\"othersRcord\":" + dThrou + "}", response);
		//added by yjs at 2016-07-02 end
	}
	
	/** 
	 *  获取页面数据返回jsp页面
	 *  void
	 */
	public void getPageDataThree(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		
		List<StationScore> stationScores = stationScoreService.queryPageDateThree(pageNum,pageSize);
		StringBuffer stringBuffer = new StringBuffer();
		if (stationScores.isEmpty()) {
			stringBuffer.append("{}");
		} else {
			stringBuffer.append("[");
			for (StationScore item : stationScores) {
				stringBuffer.append(getJsonString(item)).append(",");
			}
			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
			stringBuffer.append("]");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	// added by yjs at 2015-07-04 end

//deleted by yjs at 2016-07-02 begin
//	/**
//	 *  第一考站：查询成绩记录总数，根据时间段
//	 *  void
//	 */
//	public void getCountStation3ByDate(HttpServletRequest request, HttpServletResponse response) {
//		String dateCondition = request.getParameter("date");
//		int iCount = stationScoreService.queryCountStation3Condition(dateCondition);
//		writeJosnToJsp("{\"totalCount\":" + iCount +"}", response);
//	}
//
//	/** 
//	 *  第一考站：查询成绩页面数据，根据时间段
//	 *  void
//	 */
//	public void getPageDataStation3ByDate(HttpServletRequest request, HttpServletResponse response) {
//		String dateCondition = request.getParameter("date");
//		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
//		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
//		
//		List<StationScore> stationScores = stationScoreService.queryPageDateStation3Condition(dateCondition, pageNum,pageSize);
//		StringBuffer stringBuffer = new StringBuffer();
//		if (stationScores.isEmpty()) {
//			stringBuffer.append("{}");
//		} else {
//			stringBuffer.append("[");
//			for (StationScore item : stationScores) {
//				stringBuffer.append(getJsonString(item)).append(",");
//			}
//			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
//			stringBuffer.append("]");
//		}
//		writeJosnToJsp(stringBuffer.toString(),response);
//	}
//	
//	/**
//	 *  第一考站：查询成绩记录总数，根据分数段
//	 *  void
//	 */
//	public void getCountStation3ByScore(HttpServletRequest request, HttpServletResponse response) {
//		String scoreCondition = request.getParameter("score");
//		int iCount = stationScoreService.queryCountStation3Condition(scoreCondition);
//		writeJosnToJsp("{\"totalCount\":" + iCount +"}", response);
//	}
//
//	/** 
//	 *  第一考站：查询成绩页面数据，根据分数段
//	 *  void
//	 */
//	public void getPageDataStation3ByScore(HttpServletRequest request, HttpServletResponse response) {
//		String scoreCondition = request.getParameter("score");
//		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
//		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
//		
//		List<StationScore> stationScores = stationScoreService.queryPageDateStation3Condition(scoreCondition, pageNum,pageSize);
//		StringBuffer stringBuffer = new StringBuffer();
//		if (stationScores.isEmpty()) {
//			stringBuffer.append("{}");
//		} else {
//			stringBuffer.append("[");
//			for (StationScore item : stationScores) {
//				stringBuffer.append(getJsonString(item)).append(",");
//			}
//			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
//			stringBuffer.append("]");
//		}
//		writeJosnToJsp(stringBuffer.toString(),response);
//	}
//deleted by yjs at 2016-07-02 end
	
	/**
	 *  第一考站：查询成绩记录总数，根据条件
	 *  void
	 */
	public void getCountStation3Condition(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition").replace("mhcx", "%").replace("/", "-");
		int iCount = stationScoreService.queryCountStation3Condition(condition);
		//added by yjs at 2016-07-02 begin
		//writeJosnToJsp("{\"totalCount\":" + iCount +"}", response);
		double dThrou = 0;
		if (iCount > 0) {
			int iThrouCount = stationScoreService.queryThrouCountThree(condition);
			dThrou = (double)iThrouCount/iCount;
		}
		String sThrou = String.format("%.4f", dThrou);
		dThrou = Double.parseDouble(new BigDecimal(Double.parseDouble(sThrou)*100).setScale(2, BigDecimal.ROUND_HALF_UP).toString());;
		writeJosnToJsp("{\"totalCount\":" + iCount + ",\"othersRcord\":" + dThrou + "}", response);
		//added by yjs at 2016-07-02 end
	}

	/** 
	 *  第一考站：查询成绩页面数据，根据条件
	 *  void
	 */
	public void getPageDataStation3ByCondition(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition").replace("mhcx", "%").replace("/", "-");
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		
		List<StationScore> stationScores = stationScoreService.queryPageDateStation3Condition(condition, pageNum,pageSize);
		StringBuffer stringBuffer = new StringBuffer();
		if (stationScores.isEmpty()) {
			stringBuffer.append("{}");
		} else {
			stringBuffer.append("[");
			for (StationScore item : stationScores) {
				stringBuffer.append(getJsonString(item)).append(",");
			}
			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
			stringBuffer.append("]");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}

	/**
	 * 删除医生信息
	 */
	public void deleteThree(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("idStr");
		int result = stationScoreService.deleteThree(idStr);
		writeJosnToJsp("{\"result\":" + result + "}", response);
	}
	
	/**
	 * 第三考站：录入医生成绩并出站
	 */
	public void addStation3Score(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		int iRetCode = 0;
		
		if (!id.isEmpty()) {
			Map<String, String> map = new LinkedHashMap<String, String>();
			
			if ((stationScoreService.queryStation1FenshuById(Integer.parseInt(id))
					+ stationScoreService.queryStation2FenshuById(Integer.parseInt(id)) + Float.parseFloat(request.getParameter("count"))) > 100) { // 分数大于100
				iRetCode = 2;
			} else {
				StationDoctor stationDoctor = stationDoctorService.queryStation3DoctorById(Integer.parseInt(id));
				
				if (stationDoctor != null) { // 录入分数
					map.put("int_id", id);
					map.put("string_topic", stationDoctor.getTopic());
					map.put("string_serialNumber", stationDoctor.getSerialNumber());
					map.put("float_score", request.getParameter("count"));
					for (int i=1; i<=6; i++) {
						map.put("float_count_" + i, request.getParameter("count-"+i));
						for (int j=1; j<=8; j++) {
							map.put("float_topic_" + i + "_" + j, request.getParameter("tipic-" + i + "-" + j));
						}
					}
					map.put("date_entryDt", DateUtil.dateToString(stationDoctor.getInsertDt()));
					map.put("date_insertDt", DateUtil.dateToString(new Date()));
				}
				if (stationScoreService.insertStation3Score(map) == 1) { // 更新状态-出站
					map.clear();
					map.put("int_id", id);
					iRetCode = stationDoctorService.updateStation3DoctorFlag(Integer.parseInt(id), Constant.INSPECTFLAGYESEXAMOVER);
					/*if (stationDoctorService.station3Exit(map) == 0) {
						iRetCode = 1;
					}*/
				}
			}
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	} 
	
	/**
	 * 获取第二站考试成绩详细
	 * @param request
	 * @param response void
	 */
	public void getStation3ScoreDetail(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		StationScore stationScore = null;
		StringBuffer stringBuffer = new StringBuffer();
		if (id != null) {
			stationScore = stationScoreService.queryStation3ScoreById(Integer.parseInt(id));
			stringBuffer.append("[").append(getJsonDetailString(stationScore)).append("]");
		} else {
			stringBuffer.append("[]");
		}
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	/**
	 * 第三考站：修改考生成绩
	 */
	public void modifyStation3Score(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		int iRetCode = 0;
		Map<String, String> map = new LinkedHashMap<String, String>();
		// modified by yjs at 2015-07-04 begin 原因：修改分数出错
		//StationDoctor stationDoctor = stationDoctorService.queryStation3DoctorById(Integer.parseInt(id));
		StationScore stationScore = stationScoreService.queryStation3ScoreById(Integer.parseInt(id));
		// modified by yjs at 2015-07-04 end
		
		if (stationScore != null) { // 录入分数
			map.put("float_score", request.getParameter("count"));
			for (int i=1; i<=6; i++) {
				map.put("float_count_" + i, request.getParameter("count-"+i));
				for (int j=1; j<=8; j++) {
					map.put("float_topic_" + i + "_" + j, request.getParameter("tipic-" + i + "-" + j));
				}
			}
			map.put("int_id", id);
			if (stationScoreService.updateStation3Score(map) == 1) {
				map.clear();
				map.put("int_id", id);
				iRetCode = examScoreService.updateExamScore(map);
			}
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
	
	/**
	 * excel表格导出
	 * @param request
	 * @param response void
	 */
	public void exportStation3Excel(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition");
		
		List<StationScoreExcel> stationScores = new ArrayList<StationScoreExcel>();
		if (condition.equals("all")) {
			stationScores = stationScoreService.queryStation3ExcelScoreAll();
		} else {
			stationScores = stationScoreService.queryStation3ScoreExcelByCondition(condition);
		}
		
		ExportExcel<StationScoreExcel> ex = new ExportExcel<StationScoreExcel>();
        String[] headers = { "数据库编号", "姓名", "性别", "名族", "出生日期", "身份证", "准考证号", "题组号", "考试类别", "成绩", "进站时间", "出站时间" };
		try {
//			String fileStr = "E://examSysExport//" + new Date().getTime() + ".xls";
//			OutputStream out = new FileOutputStream(fileStr);
//			result = ex.exportExcel(headers, stationScores, out);
//		    out.close();
			
			// 输出到页面前端
			String fileStr = "score_3_" + DateUtil.dateToString(new Date(), "yyyyMMdd-HHmmss") + ".xls";
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
	
	/**
	 * 拼接Json字符串
	 * @param user
	 * @return String
	 */
	public String getJsonString(StationScore stationScore) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\"doctorId\":" + stationScore.getId()
				+ ",\"name\":\"" + stationScore.getName()
				+ "\",\"sex\":\"" + stationScore.getSex()
				+ "\",\"nation\":\"" + stationScore.getNation()		
				+ "\",\"birthday\":\"" + stationScore.getBirthday()		
				+ "\",\"card\":\"" + stationScore.getCard()
				+ "\",\"ksh\":\"" + stationScore.getKsh()
				+ "\",\"topic\":\"" + stationScore.getTopic()
				+ "\",\"examType\":" + stationScore.getExamType()
				+ ",\"score\":" + stationScore.getScore()
				+ ",\"entryDt\":\"" + DateUtil.dateToString(stationScore.getEntryDt())
				+ "\",\"insertDt\":\"" + DateUtil.dateToString(stationScore.getInsertDt()) + "\" }");
		return stringBuffer.toString();
	}
	
	/**
	 * 拼接Json字符串
	 * @param user
	 * @return String
	 */
	public String getJsonDetailString(StationScore stationScore) {
		StringBuffer stringBuffer = new StringBuffer();
		if (stationScore != null) {
			stringBuffer.append("{\"doctorId\":" + stationScore.getId()
					+ ",\"name\":\"" + stationScore.getName()
					+ "\",\"sex\":\"" + stationScore.getSex()
					+ "\",\"nation\":\"" + stationScore.getNation()		
					+ "\",\"birthday\":\"" + stationScore.getBirthday()		
					+ "\",\"card\":\"" + stationScore.getCard()
					+ "\",\"ksh\":\"" + stationScore.getKsh()
					+ "\",\"topic\":\"" + stationScore.getTopic()
					+ "\",\"examType\":" + stationScore.getExamType()
					+ ",\"score\":" + stationScore.getScore()
					+ ",\"count_1\":" + stationScore.getCount_1()
					+ ",\"topic_1_1\":" + stationScore.getTopic_1_1()
					+ ",\"topic_1_2\":" + stationScore.getTopic_1_2()
					+ ",\"topic_1_3\":" + stationScore.getTopic_1_3()
					+ ",\"topic_1_4\":" + stationScore.getTopic_1_4()
					+ ",\"topic_1_5\":" + stationScore.getTopic_1_5()
					+ ",\"topic_1_6\":" + stationScore.getTopic_1_6()
					+ ",\"topic_1_7\":" + stationScore.getTopic_1_7()
					+ ",\"topic_1_8\":" + stationScore.getTopic_1_8()
					+ ",\"count_2\":" + stationScore.getCount_2()
					+ ",\"topic_2_1\":" + stationScore.getTopic_2_1()
					+ ",\"topic_2_2\":" + stationScore.getTopic_2_2()
					+ ",\"topic_2_3\":" + stationScore.getTopic_2_3()
					+ ",\"topic_2_4\":" + stationScore.getTopic_2_4()
					+ ",\"topic_2_5\":" + stationScore.getTopic_2_5()
					+ ",\"topic_2_6\":" + stationScore.getTopic_2_6()
					+ ",\"topic_2_7\":" + stationScore.getTopic_2_7()
					+ ",\"topic_2_8\":" + stationScore.getTopic_2_8()
					+ ",\"count_3\":" + stationScore.getCount_3()
					+ ",\"topic_3_1\":" + stationScore.getTopic_3_1()
					+ ",\"topic_3_2\":" + stationScore.getTopic_3_2()
					+ ",\"topic_3_3\":" + stationScore.getTopic_3_3()
					+ ",\"topic_3_4\":" + stationScore.getTopic_3_4()
					+ ",\"topic_3_5\":" + stationScore.getTopic_3_5()
					+ ",\"topic_3_6\":" + stationScore.getTopic_3_6()
					+ ",\"topic_3_7\":" + stationScore.getTopic_3_7()
					+ ",\"topic_3_8\":" + stationScore.getTopic_3_8()
					+ ",\"count_4\":" + stationScore.getCount_4()
					+ ",\"topic_4_1\":" + stationScore.getTopic_4_1()
					+ ",\"topic_4_2\":" + stationScore.getTopic_4_2()
					+ ",\"topic_4_3\":" + stationScore.getTopic_4_3()
					+ ",\"topic_4_4\":" + stationScore.getTopic_4_4()
					+ ",\"topic_4_5\":" + stationScore.getTopic_4_5()
					+ ",\"topic_4_6\":" + stationScore.getTopic_4_6()
					+ ",\"topic_4_7\":" + stationScore.getTopic_4_7()
					+ ",\"topic_4_8\":" + stationScore.getTopic_4_8()
					+ ",\"count_5\":" + stationScore.getCount_5()
					+ ",\"topic_5_1\":" + stationScore.getTopic_5_1()
					+ ",\"topic_5_2\":" + stationScore.getTopic_5_2()
					+ ",\"topic_5_3\":" + stationScore.getTopic_5_3()
					+ ",\"topic_5_4\":" + stationScore.getTopic_5_4()
					+ ",\"topic_5_5\":" + stationScore.getTopic_5_5()
					+ ",\"topic_5_6\":" + stationScore.getTopic_5_6()
					+ ",\"topic_5_7\":" + stationScore.getTopic_5_7()
					+ ",\"topic_5_8\":" + stationScore.getTopic_5_8()
					+ ",\"count_6\":" + stationScore.getCount_6()
					+ ",\"topic_6_1\":" + stationScore.getTopic_6_1()
					+ ",\"topic_6_2\":" + stationScore.getTopic_6_2()
					+ ",\"topic_6_3\":" + stationScore.getTopic_6_3()
					+ ",\"topic_6_4\":" + stationScore.getTopic_6_4()
					+ ",\"topic_6_5\":" + stationScore.getTopic_6_5()
					+ ",\"topic_6_6\":" + stationScore.getTopic_6_6()
					+ ",\"topic_6_7\":" + stationScore.getTopic_6_7()
					+ ",\"topic_6_8\":" + stationScore.getTopic_6_8()
					+ ",\"entryDt\":\"" + DateUtil.dateToString(stationScore.getEntryDt())
					+ "\",\"insertDt\":\"" + DateUtil.dateToString(stationScore.getInsertDt()) + "\" }");
		} else {
			stringBuffer.append("{}");
		}
		return stringBuffer.toString();
	}
}
