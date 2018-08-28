/**
 * @fileName DoctorServlet.java
 * @author YuanJingshan
 * @date 2015-6-12
 */
package cn.poomoo.exam.servlet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.poomoo.common.ExcelReader;
import cn.poomoo.exam.medol.Doctor;
import cn.poomoo.exam.service.DoctorService;
import cn.poomoo.exam.serviceImpl.DoctorServiceImpl;

/**
 * @className DoctorServlet
 * @description 医生信息Servlet
 * @author YuanJingshan
 */
public class DoctorServlet extends FileBaseServlet {

	//
	private static final long serialVersionUID = 6936446120339735124L;
	//
	private DoctorService doctorService = new DoctorServiceImpl();

	/**
	 *  获取后台账户数量返回jsp页面
	 *  void
	 */
	public void getCount(HttpServletRequest request, HttpServletResponse response) {
		writeJosnToJsp("{\"totalCount\":" + doctorService.queryCount() +"}", response);
	}
	
	/** 
	 *  获取页面数据返回jsp页面
	 *  void
	 */
	public void getPageData(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		
		List<Doctor> doctors = doctorService.queryPageDate(pageNum,pageSize);
		StringBuffer stringBuffer = new StringBuffer();
		if (doctors.isEmpty()) {
			stringBuffer.append("{}");
		} else {
			stringBuffer.append("[");
			for (Doctor item : doctors) {
				stringBuffer.append(getJsonString(item)).append(",");
			}
			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
			stringBuffer.append("]");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	/**
	 *  获取缺考医生总数
	 *  void
	 */
	public void getNotCount(HttpServletRequest request, HttpServletResponse response) {
		writeJosnToJsp("{\"totalCount\":" + doctorService.queryNotCount() +"}", response);
	}
	
	/** 
	 *  获取缺考医生数据
	 *  void
	 */
	public void getPageNotData(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		
		List<Doctor> doctors = doctorService.queryPageNotDate(pageNum,pageSize);
		StringBuffer stringBuffer = new StringBuffer();
		if (doctors.isEmpty()) {
			stringBuffer.append("{}");
		} else {
			stringBuffer.append("[");
			for (Doctor item : doctors) {
				stringBuffer.append(getJsonString(item)).append(",");
			}
			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
			stringBuffer.append("]");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	/**
	 *  获取缺考医生总数
	 *  void
	 */
	public void getErrorCount(HttpServletRequest request, HttpServletResponse response) {
		writeJosnToJsp("{\"totalCount\":" + doctorService.queryErrorCount() +"}", response);
	}
	
	/** 
	 *  获取缺考医生数据
	 *  void
	 */
	public void getPageErrorData(HttpServletRequest request, HttpServletResponse response) {
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		
		List<Doctor> doctors = doctorService.queryPageErrorDate(pageNum,pageSize);
		StringBuffer stringBuffer = new StringBuffer();
		if (doctors.isEmpty()) {
			stringBuffer.append("{}");
		} else {
			stringBuffer.append("[");
			for (Doctor item : doctors) {
				stringBuffer.append(getJsonString(item)).append(",");
			}
			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
			stringBuffer.append("]");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	// added by yjs at 2015-07-04  原因：精确查询改为模糊查询
	/**
	 *  查选考生记录总数-根据条件
	 *  void
	 */
	public void getCountByCondition(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition").replace("mhcx", "%");
		int iCount= doctorService.queryCountByCondition(condition);
		writeJosnToJsp("{\"totalCount\":" + iCount +"}", response);
	}
	
	/** 
	 *  查选考生记录数据-根据条件
	 *  void
	 */
	public void getPageDataByCondition(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition").replace("mhcx", "%");
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		
		List<Doctor> doctors = doctorService.queryPageDateByCondition(condition, pageNum, pageSize);
		StringBuffer stringBuffer = new StringBuffer();
		if (doctors.isEmpty()) {
			stringBuffer.append("{}");
		} else {
			stringBuffer.append("[");
			for (Doctor item : doctors) {
				stringBuffer.append(getJsonString(item)).append(",");
			}
			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
			stringBuffer.append("]");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	/**
	 *  查选考生记录总数-根据条件
	 *  void
	 */
	public void getCountNotByCondition(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition").replace("mhcx", "%");
		int iCount= doctorService.queryCountNotByCondition(condition);
		writeJosnToJsp("{\"totalCount\":" + iCount +"}", response);
	}
	
	/** 
	 *  查选考生记录数据-根据条件
	 *  void
	 */
	public void getPageDataNotByCondition(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition").replace("mhcx", "%");
		int pageNum = Integer.parseInt(request.getParameter("pageNum")); // 页码
		int pageSize = Integer.parseInt(request.getParameter("pageSize")); // 每页数量
		
		List<Doctor> doctors = doctorService.queryPageDateNotByCondition(condition, pageNum, pageSize);
		StringBuffer stringBuffer = new StringBuffer();
		if (doctors.isEmpty()) {
			stringBuffer.append("{}");
		} else {
			stringBuffer.append("[");
			for (Doctor item : doctors) {
				stringBuffer.append(getJsonString(item)).append(",");
			}
			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
			stringBuffer.append("]");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	/** 
	 *  查询医生信息，根据身份证信息
	 *  void
	 */
	public void getDoctorInfo(HttpServletRequest request, HttpServletResponse response) {
		String condition = request.getParameter("condition");
		
		List<Doctor> doctors = doctorService.queryDateByCondition(condition);
		StringBuffer stringBuffer = new StringBuffer();
		if (doctors.isEmpty()) {
			stringBuffer.append("{\"result\":0}"); // 不存在医生信息
		} else {
			stringBuffer.append("{\"result\":1,\"info\":[");
			for (Doctor item : doctors) {
				stringBuffer.append(getJsonString(item)).append(",");
			}
			stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
			stringBuffer.append("]}");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	

	/**
	 * 删除医生信息
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idStr = request.getParameter("idStr");
		int result = doctorService.deleteDoctor(idStr);
		writeJosnToJsp("{\"result\":" + result + "}", response);
	}
	
	// added by yjs at 2015-07-06 begin 
	/**
	 * 导入考试医生信息
	 * @param request
	 * @param response void
	 */
	public void importDoctorInfo(HttpServletRequest request, HttpServletResponse response) {
		int iRetCode = 0;
		this.uploadFile(request);
		if (this.uploadFile != null && this.uploadFile != "") {
			// 阅读excel文件表格内容，然后插入数据库
            InputStream isExcelFile;
			try {
				isExcelFile = new FileInputStream(this.filePath + "\\" + this.uploadFile);
				Map<Integer, String> map = ExcelReader.getInstance().readExcelContent(isExcelFile);
				// 将读出的内容拼接成一个插入语句
				String strExcel = "";
	            for (int i = 1; i <= map.size(); i++) {
	            	String itemStr = "";
	            	if (!map.get(i).isEmpty()) {
	            		itemStr = map.get(i);
	            	}
	            	strExcel = strExcel + itemStr + ",";
	            }
	            strExcel = strExcel.substring(0, strExcel.length()-1) + ";";
	            // 插入数据库
	            iRetCode = doctorService.insertDoctorByStr(strExcel);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
	// added by yjs at 2015-07-06 end
	
	/**
	 * 给异常考生赋值0分
	 * @param request
	 * @param response void
	 */
	public void addErrorDoctorScore(HttpServletRequest request, HttpServletResponse response) {
		String doctorIdStr = request.getParameter("doctorId");
		int iRetCode = doctorService.updateExamScore(Integer.parseInt(doctorIdStr));
		if (iRetCode == 0) { // 成功
			iRetCode =1;
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
	/**
	 * 拼接Json字符串
	 * @param user
	 * @return String
	 */
	public String getJsonString(Doctor doctor) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\"doctorId\":" + doctor.getId()
				+ ",\"name\":\"" + doctor.getName()
				+ "\",\"sex\":\"" + doctor.getSex()
				+ "\",\"nation\":\"" + doctor.getNation()		
				+ "\",\"birthday\":\"" + doctor.getBirthday()		
				+ "\",\"card\":\"" + doctor.getCard()
				+ "\",\"ksh\":\"" + doctor.getKsh()
				+ "\",\"examType\":" + doctor.getExamType() + "}");
		return stringBuffer.toString();
	}
}
