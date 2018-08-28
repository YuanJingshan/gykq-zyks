/**
 * @fileName ExamScoreServlet.java
 * @author YuanJingshan
 * @date 2015-6-13
 */
package cn.poomoo.exam.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.poomoo.common.ExportExcel;
import cn.poomoo.common.util.DateUtil;
import cn.poomoo.common.util.JsonUtil;
import cn.poomoo.exam.medol.ExamScore;
import cn.poomoo.exam.service.ExamScoreService;
import cn.poomoo.exam.serviceImpl.ExamScoreServiceImpl;

/**
 * @className ExamScoreServlet
 * @description 考试成绩Servlet
 * @author YuanJingshan
 */
public class ExamScoreServlet extends BaseServlet {

	//
	private static final long serialVersionUID = -7637032035328616750L;
	//
	private ExamScoreService examScoreService = new ExamScoreServiceImpl();
	
	/**
	 *  获取后台账户数量返回jsp页面
	 *  void
	 */
	public void getCount(HttpServletRequest request, HttpServletResponse response) {
		int iCount = examScoreService.queryCount();
		double dThrou = 0;
		if (iCount > 0) {
			int iThrouCount = examScoreService.queryThrouCount();
			dThrou = (double)iThrouCount/iCount;
		}
		String sThrou = String.format("%.4f", dThrou);
		dThrou = Double.parseDouble(new BigDecimal(Double.parseDouble(sThrou)*100).setScale(2, BigDecimal.ROUND_HALF_UP).toString());;
		
		writeJosnToJsp("{\"totalCount\":" + examScoreService.queryCount() + ",\"othersRcord\":" + dThrou + "}", response);
	}
	
	/** 
	 *  获取页面数据返回jsp页面
	 *  void
	 */
	public void getPageData(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		
		List<ExamScore> examScores = examScoreService.queryPageDate(pageNum,pageSize);
		StringBuffer stringBuffer = new StringBuffer();
		if (examScores.isEmpty()) {
			stringBuffer.append("{}");
		} else {
			stringBuffer.append(JsonUtil.jsonToString(examScores));
		}
		
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	/**
	 *  查选成绩记录数-根据条件
	 *  void
	 */
	public void getCountByCondition(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition").replace("mhcx", "%").replace("/", "-");
		int iCount= examScoreService.queryCountByCondition(condition);
		double dThrou = 0;
		if (iCount > 0) {
			int iThrouCount = examScoreService.queryThrouCountByCondition(condition);
			dThrou = (double)iThrouCount/iCount;
		}
		String sThrou = String.format("%.4f", dThrou);
		dThrou = Double.parseDouble(new BigDecimal(Double.parseDouble(sThrou)*100).setScale(2, BigDecimal.ROUND_HALF_UP).toString());;
		writeJosnToJsp("{\"totalCount\":" + iCount + ",\"othersRcord\":" + dThrou + "}", response);
	}
	
	/** 
	 *  查询页面数据-根据页面参数以及条件
	 *  void
	 */
	public void getPageDataByCondition(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition").replace("mhcx", "%").replace("/", "-");
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		
		List<ExamScore> examScores = examScoreService.queryExamScoreByDateByCondition(condition, pageNum, pageSize);
		StringBuffer stringBuffer = new StringBuffer();
		if (examScores.isEmpty()) {
			stringBuffer.append("{}");
		} else {
			stringBuffer.append(JsonUtil.jsonToString(examScores));
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}

	/**
	 * 删除医生信息
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("idStr");
		int result = examScoreService.deleteDoctor(idStr);
		writeJosnToJsp("{\"result\":" + result + "}", response);
	}
	
	/**
	 * excel表格导出
	 * @param request
	 * @param response void
	 */
	public void exportExamExcel(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition");
		List<ExamScore> examScores = new ArrayList<ExamScore>();
		if (condition.equals("all")) {
			examScores = examScoreService.queryExamScoreAll();
		} else {
			examScores = examScoreService.queryDateByCondition(condition);
		}
		
		ExportExcel<ExamScore> ex = new ExportExcel<ExamScore>();
        String[] headers = { "数据库编号", "姓名", "性别", "名族", "出生日期", "身份证", "准考证号", "考试类别", "题组号", "第一考站成绩", "第二考站成绩", "第三考站成绩", "总成绩", "检录时间", "出口时间" };
		try {
			// 输出到页面前端
			String fileStr = "score_" + DateUtil.dateToString(new Date(), "yyyyMMdd-HHmmss") + ".xls";
			String responseHeader = "attachment;filename=" + fileStr;
			response.setContentType("octets/stream");
			response.addHeader("Content-Disposition", responseHeader);
		      
			OutputStream out = response.getOutputStream();
			ex.exportExcel(headers, examScores, out);
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
