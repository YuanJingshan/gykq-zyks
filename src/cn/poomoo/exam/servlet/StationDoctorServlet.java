/**
 * @file StationDoctorServlet.java
 * @author yuanjingshan
 * @date 2015-6-18
 */
package cn.poomoo.exam.servlet;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.poomoo.common.Constant;
import cn.poomoo.common.util.JsonUtil;
import cn.poomoo.exam.medol.StationDoctor;
import cn.poomoo.exam.service.InspectService;
import cn.poomoo.exam.service.StationDoctorService;
import cn.poomoo.exam.serviceImpl.InspectServiceImpl;
import cn.poomoo.exam.serviceImpl.StationDoctorServiceImpl;

/**
 * @class StationDoctorServlet
 * @description 考站考生-Servlet
 */
public class StationDoctorServlet extends BaseServlet {

	//
	private static final long serialVersionUID = -39238995007526550L;
	//
	private StationDoctorService stationDoctorService = new StationDoctorServiceImpl();
	// 
	private InspectService inspectService = new InspectServiceImpl();
	
	//delete by yjs at 2016-06-25 begin 
	/** 
	 * 第一考站：查询医生信息-根据身份证信息
	 *  void
	 */
	/*public void getStation1DoctorInfo(HttpServletRequest request, HttpServletResponse response) {
		String card = request.getParameter("card");
		StationDoctor station1Doctor= stationDoctorService.queryStation1DoctorByCardNum(card);
		StringBuffer stringBuffer = new StringBuffer();
		if (station1Doctor == null) {
			stringBuffer.append("{\"result\":0}"); // 不存在医生信息,医生未检录
		} else {
			stringBuffer.append("{\"result\":1,\"info\":[").append(getJsonString(station1Doctor)).append("]}");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}*/
	//delete by yjs at 2016-06-25 end
	
	/**
	 * <p>MethodName: station1DoctorInspect</p>
	 * <p>Description: 第一考站：医生检录</p>
	 * <p>Company: www.jingshan.com</p>
	 * <p>Parameter: request,response</P>
	 * <p>Return Type: void</P>
	 * @author  yjs
	 * @date    2016-6-25
	 * @vession 1.0.0
	 */
	public void station1DoctorInspect(HttpServletRequest request, HttpServletResponse response) {
		int iRetCode = Constant.INSPECTFAIL;
		String id = request.getParameter("id");
		if (!id.isEmpty()) {
			Map<String, String> map = new LinkedHashMap<String, String>();
			map.put("int_id", id);
			int result = inspectService.station1Inspect(map);
			if (result == 0){
				//检录成功
				iRetCode = Constant.INSPECTSUCCESS;
			} else if (result == -101) {
				//入口未检录
				iRetCode = Constant.INSPECTENTRYNOT;
			} else if (result == -102) {
				//已检录
				iRetCode = Constant.INSPECTENTRYYES;
			} else if (result == -103) {
				//其他考站未结束
				iRetCode = Constant.INSPECTOTHEREXAMNOTEXIT;
			}
		} 
		writeJosnToJsp("{\"result\":" + iRetCode + "}",response);
	}
	
	/**
	 * 第一考站：获取已经检录，未考试的考生信息
	 * @param request
	 * @param response void
	 */
	public void getStation1NotEntry(HttpServletRequest request, HttpServletResponse response) {
		// 查询候考区人数
		// modified by yjs at 2016-06-25 from (byte)2 to Constant.INSPECTFLAGYESENTRYSTATION
		int iEntriedCount = stationDoctorService.queryStation1CountByFlag(Constant.INSPECTFLAGYESENTRYSTATION);
		
		List<StationDoctor> stationDoctors = stationDoctorService.queryStation1NotEntry();
		StringBuffer stringBuffer = new StringBuffer();
		
		if (stationDoctors.isEmpty()) {
			stringBuffer.append("{\"notEntryNum\":" + stationDoctors.size() + ",\"entriedNum\":" + iEntriedCount + ",\"info\":[]}");
		} else {
			stringBuffer.append("{\"notEntryNum\":" + stationDoctors.size() + ",\"entriedNum\":" + iEntriedCount + ",\"info\":");
			stringBuffer.append(JsonUtil.jsonToString(stationDoctors)).append("}");
		}
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	/**
	 * 第一考站：获取正在考试的考生
	 * @param request
	 * @param response void
	 */
	public void getStation1Entried(HttpServletRequest request, HttpServletResponse response) {
		// 查询候考区人数
		// modified by yjs at 2016-06-25 from (byte)1 to Constant.Constant.INSPECTFLAGYES
		int iNotEntryCount = stationDoctorService.queryStation1CountByFlag(Constant.INSPECTFLAGYES);
		
		List<StationDoctor> stationDoctors = stationDoctorService.queryStation1Entried();
		StringBuffer stringBuffer = new StringBuffer();
		
		if (stationDoctors.isEmpty()) {
			stringBuffer.append("{\"notEntryNum\":" + iNotEntryCount + ",\"entriedNum\":" + stationDoctors.size() + ",\"info\":[]}");
		} else {
			stringBuffer.append("{\"notEntryNum\":" + iNotEntryCount + ",\"entriedNum\":" + stationDoctors.size() + ",\"info\":");
			stringBuffer.append(JsonUtil.jsonToString(stationDoctors)).append("}");
		}
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	/**
	 * 第一考站：已考完出站的考生
	 * @param request
	 * @param response void
	 */
	public void getStation1Exit(HttpServletRequest request, HttpServletResponse response) {
		List<StationDoctor> stationDoctors = stationDoctorService.queryStation1Exit();
		StringBuffer stringBuffer = new StringBuffer();
		
		if (stationDoctors.isEmpty()) {
			stringBuffer.append("{\"exitNum\":" + stationDoctors.size() + ",\"info\":[]}");
		} else {
			stringBuffer.append("{\"exitNum\":" + stationDoctors.size() + ",\"info\":");
			stringBuffer.append(JsonUtil.jsonToString(stationDoctors)).append("}");
		}
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	// TODO added by 2018
	public void getStation1Verify(HttpServletRequest request, HttpServletResponse response) {
		List<StationDoctor> doctors = stationDoctorService.getStation1ByStatus(Constant.STATION_VERIFY);
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\"num\":").append(doctors.size()).append(",")
		            .append("\"info\":").append(JsonUtil.jsonToString(doctors)).append("}");
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	//TODO added by 2018
	public void station1Verify(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Map<String, String> map = new HashMap<String, String>();
		map.put("int_id", id);
		int iRetCode = stationDoctorService.station1Exit(map);
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
	
	/**
	 * 第一考站：获取检录医生（所有）
	 * @param request
	 * @param response void
	 */
	public void getStation1Info(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer stringBuffer = new StringBuffer();
		String notEntryString = "\"notEntry\":{\"count\":0,\"info\":[]}";
		String entriedString = "\"entried\":{\"count\":0,\"info\":[]}";
			
		List<StationDoctor> notEntrysStationDoctors = stationDoctorService.queryStation1NotEntry();
		if (!notEntrysStationDoctors.isEmpty()) {
			notEntryString = "\"notEntry\":{\"count\":" + notEntrysStationDoctors.size() + ",\"info\":";
			notEntryString = notEntryString + JsonUtil.jsonToString(notEntrysStationDoctors) + "}";
		}
			
		List<StationDoctor> entryingStationDoctors = stationDoctorService.queryStation1Entried();
		if (!entryingStationDoctors.isEmpty()) {
			entriedString = "\"entried\":{\"count\":" + entryingStationDoctors.size() + ",\"info\":";
			entriedString = entriedString + JsonUtil.jsonToString(entryingStationDoctors) + "}";
		}
		
		stringBuffer.append("{" + notEntryString + "," + entriedString + "}");
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	/**
	 * 第一考站：获取检录医生（所有-监控）
	 * @param request
	 * @param response void
	 */
	public void getStation1InfoByJk(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer stringBuffer = new StringBuffer();
		List<StationDoctor> notEntrysStationDoctors = stationDoctorService.queryStation1NotEntry();
		List<StationDoctor> entryingStationDoctors = stationDoctorService.queryStation1Entried();
		stringBuffer.append("{\"notEntryNum\":" + notEntrysStationDoctors.size() + ",\"entriedNum\":" + entryingStationDoctors.size() + ",\"info\":[");
		if (!notEntrysStationDoctors.isEmpty()) {
			for (StationDoctor item : notEntrysStationDoctors) {
				stringBuffer.append(JsonUtil.jsonToString(item)).append(",");
			}
			if (!entryingStationDoctors.isEmpty()) {
				for (StationDoctor item : entryingStationDoctors) {
					stringBuffer.append(JsonUtil.jsonToString(item)).append(",");
				}
				stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
				stringBuffer.append("]}");
			} else {
				stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
				stringBuffer.append("]}");
			}
		} else {
			if (!entryingStationDoctors.isEmpty()) {
				for (StationDoctor item : entryingStationDoctors) {
					stringBuffer.append(JsonUtil.jsonToString(item)).append(",");
				}
				stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
				stringBuffer.append("]}");
			} else {
				stringBuffer.append("]}");
			}
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	/**
	 * 第一考站：点击提示进入考场考试
	 * @param request
	 * @param response void
	 */
	public void entryStation1Exam(HttpServletRequest request, HttpServletResponse response) {
		int iRetcode = Constant.ENTRYSTATION_FAIL;
		String id = request.getParameter("id");
		if (!id.isEmpty()) {
			iRetcode = stationDoctorService.updateStation1DoctorFlag(Integer.parseInt(id), Constant.INSPECTFLAGYESENTRYSTATION);
		}
		writeJosnToJsp("{\"result\":" + iRetcode + "}", response);
	}
	
	/**
	 * 第一考站：取消正在进入考场
	 * @param request
	 * @param response void
	 */
	public void cancalEntryingExam(HttpServletRequest request, HttpServletResponse response) {
		//modified by yjs at 2016-06-25 begin
		/*int id = Integer.parseInt(request.getParameter("id"));
		int iRetcode = stationDoctorService.updateStation1DoctorFlag(id, (byte)1);*/
		int iRetcode = Constant.CANCELENTRYSTATIONFAIL;
		String id = request.getParameter("id");
		if (!id.isEmpty()) {
			iRetcode = stationDoctorService.updateStation1DoctorFlag(Integer.parseInt(id), Constant.INSPECTFLAGYES);
		}
		//modified by yjs at 2016-06-25 end
		writeJosnToJsp("{\"result\":" + iRetcode + "}", response);
	}
	
	//deleted by yjs at 2016-06-25 begin
	/** 
	 * 第二考站：查询医生信息-根据身份证信息
	 *  void
	 */
	/*public void getStation2DoctorInfo(HttpServletRequest request, HttpServletResponse response) {
		String card = request.getParameter("card");
		StationDoctor station1Doctor= stationDoctorService.queryStation2DoctorByCardNum(card);
		StringBuffer stringBuffer = new StringBuffer();
		if (station1Doctor == null) {
			stringBuffer.append("{\"result\":0}"); // 不存在医生信息,医生未检录
		} else {
			stringBuffer.append("{\"result\":1,\"info\":[").append(getJsonString(station1Doctor)).append("]}");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}*/
	//deleted by yjs at 2016-06-25 end
	
	/**
	 * 第二考站：医生检录
	 * @param request
	 * @param response void
	 */
	public void station2DoctorInspect(HttpServletRequest request, HttpServletResponse response) {
		//modified by yjs at 2016-06-25 begin
		/*int iRetCode = 1;
		int id = Integer.parseInt(request.getParameter("id"));
		StationDoctor station1Doctor= stationDoctorService.queryStation2DoctorById(id);
		
		if (station1Doctor == null) { // 不存在，第一站未出站
			iRetCode = 0;
		} else if (station1Doctor != null && station1Doctor.getFlag() == 0) {
			iRetCode = stationDoctorService.updateStation2DoctorFlag(id, (byte)1);
		}*/
		int iRetCode = Constant.INSPECTFAIL;
		String id = request.getParameter("id");
		if (!id.isEmpty()) {
			Map<String, String> map = new LinkedHashMap<String, String>();
			map.put("int_id", id);
			int result = inspectService.station2Inspect(map);
			if (result == 0){
				//检录成功
				iRetCode = Constant.INSPECTSUCCESS;
			} else if (result == -101) {
				//入口未检录
				iRetCode = Constant.INSPECTENTRYNOT;
			} else if (result == -102) {
				//已检录
				iRetCode = Constant.INSPECTENTRYYES;
			} else if (result == -103) {
				//其他考站未结束
				iRetCode = Constant.INSPECTOTHEREXAMNOTEXIT;
			}
		} 
		//modified by yjs at 2016-06-25 end
		writeJosnToJsp("{\"result\":" + iRetCode + "}",response);
	}
	
	/**
	 * 第二考站：获取已经检录，未考试的考生信息
	 * @param request
	 * @param response void
	 */
	public void getStation2NotEntry(HttpServletRequest request, HttpServletResponse response) {
		int iEntriedCount = stationDoctorService.queryStation2CountByFlag(Constant.INSPECTFLAGYESENTRYSTATION);
		List<StationDoctor> stationDoctors = stationDoctorService.queryStation2NotEntry();
		StringBuffer stringBuffer = new StringBuffer();
		
		if (stationDoctors.isEmpty()) {
			stringBuffer.append("{\"notEntryNum\":" + stationDoctors.size() + ",\"entriedNum\":" + iEntriedCount + ",\"info\":[]}");
		} else {
			stringBuffer.append("{\"notEntryNum\":" + stationDoctors.size() + ",\"entriedNum\":" + iEntriedCount + ",\"info\":");
			stringBuffer.append(JsonUtil.jsonToString(stationDoctors)).append("}");
		}
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	/**
	 * 第二考站：获取正在考试的考生
	 * @param request
	 * @param response void
	 */
	public void getStation2Entried(HttpServletRequest request, HttpServletResponse response) {
		int iNotEntryCount = stationDoctorService.queryStation2CountByFlag(Constant.INSPECTFLAGYES);
		
		List<StationDoctor> stationDoctors = stationDoctorService.queryStation2Entried();
		StringBuffer stringBuffer = new StringBuffer();
		
		if (stationDoctors.isEmpty()) {
			stringBuffer.append("{\"notEntryNum\":" + iNotEntryCount + ",\"entriedNum\":" + stationDoctors.size() + ",\"info\":[]}");
		} else {
			stringBuffer.append("{\"notEntryNum\":" + iNotEntryCount + ",\"entriedNum\":" + stationDoctors.size() + ",\"info\":");
			stringBuffer.append(JsonUtil.jsonToString(stationDoctors)).append("}");
		}
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	/**
	 * 第二考站：已考完出站的考生
	 * @param request
	 * @param response void
	 */
	public void getStation2Exit(HttpServletRequest request, HttpServletResponse response) {
		List<StationDoctor> stationDoctors = stationDoctorService.queryStation2Exit();
		StringBuffer stringBuffer = new StringBuffer();
		
		if (stationDoctors.isEmpty()) {
			stringBuffer.append("{\"exitNum\":" + stationDoctors.size() + ",\"info\":[]}");
		} else {
			stringBuffer.append("{\"exitNum\":" + stationDoctors.size() + ",\"info\":");
			stringBuffer.append(JsonUtil.jsonToString(stationDoctors)).append("}");
		}
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	// TODO added by 2018
	public void getStation2Verify(HttpServletRequest request, HttpServletResponse response) {
		List<StationDoctor> doctors = stationDoctorService.getStation2ByStatus(Constant.STATION_VERIFY);
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\"num\":").append(doctors.size()).append(",")
		            .append("\"info\":").append(JsonUtil.jsonToString(doctors)).append("}");
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	//TODO added by 2018
	public void station2Verify(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Map<String, String> map = new HashMap<String, String>();
		map.put("int_id", id);
		int iRetCode = stationDoctorService.station2Exit(map);
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
	
	/**
	 * 第二考站：获取检录医生（所有）
	 * @param request
	 * @param response void
	 */
	public void getStation2Info(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer stringBuffer = new StringBuffer();
		String notEntryString = "\"notEntry\":{\"count\":0,\"info\":[]}";
		String entriedString = "\"entried\":{\"count\":0,\"info\":[]}";
		List<StationDoctor> notEntrysStationDoctors = stationDoctorService.queryStation2NotEntry();
		if (!notEntrysStationDoctors.isEmpty()) {
			notEntryString = "\"notEntry\":{\"count\":" + notEntrysStationDoctors.size() + ",\"info\":";
			notEntryString = notEntryString + JsonUtil.jsonToString(notEntrysStationDoctors) + "}";
		}
			
		List<StationDoctor> entryingStationDoctors = stationDoctorService.queryStation2Entried();
		if (!entryingStationDoctors.isEmpty()) {
			entriedString = "\"entried\":{\"count\":" + entryingStationDoctors.size() + ",\"info\":";
			entriedString = entriedString + JsonUtil.jsonToString(entryingStationDoctors) + "}";
		}
		stringBuffer.append("{" + notEntryString + "," + entriedString + "}");
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	/**
	 * 第二考站：获取检录医生（所有-监控）
	 * @param request
	 * @param response void
	 */
	public void getStation2InfoByJk(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer stringBuffer = new StringBuffer();
		List<StationDoctor> notEntrysStationDoctors = stationDoctorService.queryStation2NotEntry();
		List<StationDoctor> entryingStationDoctors = stationDoctorService.queryStation2Entried();
		stringBuffer.append("{\"notEntryNum\":" + notEntrysStationDoctors.size() + ",\"entriedNum\":" + entryingStationDoctors.size() + ",\"info\":[");
		if (!notEntrysStationDoctors.isEmpty()) {
			for (StationDoctor item : notEntrysStationDoctors) {
				stringBuffer.append(JsonUtil.jsonToString(item)).append(",");
			}
			if (!entryingStationDoctors.isEmpty()) {
				for (StationDoctor item : entryingStationDoctors) {
					stringBuffer.append(JsonUtil.jsonToString(item)).append(",");
				}
				stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
				stringBuffer.append("]}");
			} else {
				stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
				stringBuffer.append("]}");
			}
		} else {
			if (!entryingStationDoctors.isEmpty()) {
				for (StationDoctor item : entryingStationDoctors) {
					stringBuffer.append(JsonUtil.jsonToString(item)).append(",");
				}
				stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
				stringBuffer.append("]}");
			} else {
				stringBuffer.append("]}");
			}
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	
	/**
	 * 第二考站：点击提示进入考场考试
	 * @param request
	 * @param response void
	 */
	public void entryStation2Exam(HttpServletRequest request, HttpServletResponse response) {
		//modified by yjs at 2016-06-25 begin
		/*int id = Integer.parseInt(request.getParameter("id"));
		int iRetcode = stationDoctorService.updateStation2DoctorFlag(id, (byte)2);*/
		int iRectCode = Constant.ENTRYSTATION_FAIL;
		String id = request.getParameter("id");
		if (!id.isEmpty()) {
			iRectCode = stationDoctorService.updateStation2DoctorFlag(Integer.parseInt(id), Constant.INSPECTFLAGYESENTRYSTATION);
		}
		//modified by yjs at 2016-06-25 end
		writeJosnToJsp("{\"result\":" + iRectCode + "}", response);
	}
	
	/**
	 * 第二考站：取消正在进入考场
	 * @param request
	 * @param response void
	 */
	public void cancalStation2ExamEntry(HttpServletRequest request, HttpServletResponse response) {
		//modified by yjs at 2016-06-25 begin
		/*int id = Integer.parseInt(request.getParameter("id"));
		int iRetcode = stationDoctorService.updateStation2DoctorFlag(id, (byte)1);*/
		int iRectCode = Constant.CANCELENTRYSTATIONFAIL;
		String id = request.getParameter("id");
		if (!id.isEmpty()) {
			iRectCode = stationDoctorService.updateStation2DoctorFlag(Integer.parseInt(id), Constant.INSPECTFLAGYES);
		}
		//modified by yjs at 2016-06-25 end
		writeJosnToJsp("{\"result\":" + iRectCode + "}", response);
	}
	
	//delete by yjs at 2016-06-25 begin
	/** 
	 * 第三考站：查询医生信息-根据身份证信息
	 *  void
	 */
	/*public void getStation3DoctorInfo(HttpServletRequest request, HttpServletResponse response) {
		String card = request.getParameter("card");
		StationDoctor station3Doctor= stationDoctorService.queryStation3DoctorByCardNum(card);
		StringBuffer stringBuffer = new StringBuffer();
		if (station3Doctor == null) {
			stringBuffer.append("{\"result\":0}"); // 不存在医生信息,医生未检录
		} else {
			stringBuffer.append("{\"result\":1,\"info\":[").append(getJsonString(station3Doctor)).append("]}");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}*/
	//delete by yjs at 2016-06-25 end
	
	/**
	 * 第三考站：医生检录
	 * @param request
	 * @param response void
	 */
	public void station3DoctorInspect(HttpServletRequest request, HttpServletResponse response) {
		//modified by yjs at 2016-06-25 begin
		/*int iRetCode = 1;
		int id = Integer.parseInt(request.getParameter("id"));
		StationDoctor station3Doctor= stationDoctorService.queryStation3DoctorById(id);
		
		if (station3Doctor == null) { // 不存在，第二站未出站
			iRetCode = 0;
		} else if (station3Doctor != null && station3Doctor.getFlag() == 0) {
			iRetCode = stationDoctorService.updateStation3DoctorFlag(id, (byte)1);
		}*/
		int iRetCode = Constant.INSPECTFAIL;
		String id = request.getParameter("id");
		if (!id.isEmpty()) {
			Map<String, String> map = new LinkedHashMap<String, String>();
			map.put("int_id", id);
			int result = inspectService.station3Inspect(map);
			if (result == 0){
				//检录成功
				iRetCode = Constant.INSPECTSUCCESS;
			} else if (result == -101) {
				//入口未检录
				iRetCode = Constant.INSPECTENTRYNOT;
			} else if (result == -102) {
				//已检录
				iRetCode = Constant.INSPECTENTRYYES;
			} else if (result == -103) {
				//其他考站未结束
				iRetCode = Constant.INSPECTOTHEREXAMNOTEXIT;
			}
		} 
		writeJosnToJsp("{\"result\":" + iRetCode + "}",response);
	}
	
	/**
	 * 第三考站：获取已经检录，未考试的考生信息
	 * @param request
	 * @param response void
	 */
	public void getStation3NotEntry(HttpServletRequest request, HttpServletResponse response) {
		// 查询候考区人数
		//modified by yjs at 2016-06-25 begin 
		//int iEntriedCount = stationDoctorService.queryStation3CountByFlag((byte)2);
		int iEntriedCount = stationDoctorService.queryStation3CountByFlag(Constant.INSPECTFLAGYESENTRYSTATION);
		//modified by yjs at 2016-06-25 end
		List<StationDoctor> stationDoctors = stationDoctorService.queryStation3NotEntry();
		StringBuffer stringBuffer = new StringBuffer();
		
		if (stationDoctors.isEmpty()) {
			stringBuffer.append("{\"notEntryNum\":" + stationDoctors.size() + ",\"entriedNum\":" + iEntriedCount + ",\"info\":[]}");
		} else {
			stringBuffer.append("{\"notEntryNum\":" + stationDoctors.size() + ",\"entriedNum\":" + iEntriedCount + ",\"info\":");
			stringBuffer.append(JsonUtil.jsonToString(stationDoctors)).append("}");
		}
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	/**
	 * 第三考站：获取考区考生
	 * @param request
	 * @param response void
	 */
	public void getStation3Entried(HttpServletRequest request, HttpServletResponse response) {
		// 查询候考区人数
		//modified by yjs at 2016-06-25 begin
		//int iNotEntryCount = stationDoctorService.queryStation3CountByFlag((byte)1);
		int iNotEntryCount = stationDoctorService.queryStation3CountByFlag(Constant.INSPECTFLAGYES);
		//modified by yjs at 2016-06-25 end
		List<StationDoctor> stationDoctors = stationDoctorService.queryStation3Entried();
		StringBuffer stringBuffer = new StringBuffer();
		
		if (stationDoctors.isEmpty()) {
			stringBuffer.append("{\"notEntryNum\":" + iNotEntryCount + ",\"entriedNum\":" + stationDoctors.size() + ",\"info\":[]}");
		} else {
			stringBuffer.append("{\"notEntryNum\":" + iNotEntryCount + ",\"entriedNum\":" + stationDoctors.size() + ",\"info\":");
			stringBuffer.append(JsonUtil.jsonToString(stationDoctors)).append("}");
		}
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	/**
	 * 第三考站：已考完出站的考生
	 * @param request
	 * @param response void
	 */
	public void getStation3Exit(HttpServletRequest request, HttpServletResponse response) {
		List<StationDoctor> stationDoctors = stationDoctorService.queryStation3Exit();
		StringBuffer stringBuffer = new StringBuffer();
		
		if (stationDoctors.isEmpty()) {
			stringBuffer.append("{\"exitNum\":" + stationDoctors.size() + ",\"info\":[]}");
		} else {
			stringBuffer.append("{\"exitNum\":" + stationDoctors.size() + ",\"info\":");
			stringBuffer.append(JsonUtil.jsonToString(stationDoctors)).append("}");
		}
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	// TODO added by 2018
	public void getStation3Verify(HttpServletRequest request, HttpServletResponse response) {
		List<StationDoctor> doctors = stationDoctorService.getStation3ByStatus(Constant.STATION_VERIFY);
		
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\"num\":").append(doctors.size()).append(",")
		            .append("\"info\":").append(JsonUtil.jsonToString(doctors)).append("}");
		writeJosnToJsp(stringBuffer.toString(), response);
	}
	
	//TODO added by 2018
	public void station3Verify(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		Map<String, String> map = new HashMap<String, String>();
		map.put("int_id", id);
		int iRetCode = stationDoctorService.station3Exit(map);
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
	/**
	 * 第三考站：获取此战医生（所有）
	 * @param request
	 * @param response void
	 */
	public void getStation3Info(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer stringBuffer = new StringBuffer();
		String notEntryString = "\"notEntry\":{\"count\":0,\"info\":[]}";
		String entriedString = "\"entried\":{\"count\":0,\"info\":[]}";
			
		List<StationDoctor> notEntrysStationDoctors = stationDoctorService.queryStation3NotEntry();
		if (!notEntrysStationDoctors.isEmpty()) {
			notEntryString = "\"notEntry\":{\"count\":" + notEntrysStationDoctors.size() + ",\"info\":";
			notEntryString = notEntryString + JsonUtil.jsonToString(notEntrysStationDoctors) + "}";
		}
			
		List<StationDoctor> entryingStationDoctors = stationDoctorService.queryStation3Entried();
		if (!entryingStationDoctors.isEmpty()) {
			entriedString = "\"entried\":{\"count\":" + entryingStationDoctors.size() + ",\"info\":";
			entriedString = entriedString + JsonUtil.jsonToString(entryingStationDoctors) + "}";
		}
		stringBuffer.append("{" + notEntryString + "," + entriedString + "}");
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	/**
	 * 第三考站：获取检录医生（所有-监控）
	 * @param request
	 * @param response void
	 */
	public void getStation3InfoByJk(HttpServletRequest request, HttpServletResponse response) {
		StringBuffer stringBuffer = new StringBuffer();
		List<StationDoctor> notEntrysStationDoctors = stationDoctorService.queryStation3NotEntry();
		List<StationDoctor> entryingStationDoctors = stationDoctorService.queryStation3Entried();
		stringBuffer.append("{\"notEntryNum\":" + notEntrysStationDoctors.size() + ",\"entriedNum\":" + entryingStationDoctors.size() + ",\"info\":[");
		if (!notEntrysStationDoctors.isEmpty()) {
			for (StationDoctor item : notEntrysStationDoctors) {
				stringBuffer.append(JsonUtil.jsonToString(item)).append(",");
			}
			if (!entryingStationDoctors.isEmpty()) {
				for (StationDoctor item : entryingStationDoctors) {
					stringBuffer.append(JsonUtil.jsonToString(item)).append(",");
				}
				stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
				stringBuffer.append("]}");
			} else {
				stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
				stringBuffer.append("]}");
			}
		} else {
			if (!entryingStationDoctors.isEmpty()) {
				for (StationDoctor item : entryingStationDoctors) {
					stringBuffer.append(JsonUtil.jsonToString(item)).append(",");
				}
				stringBuffer.deleteCharAt(stringBuffer.lastIndexOf(","));
				stringBuffer.append("]}");
			} else {
				stringBuffer.append("]}");
			}
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	/**
	 * 第三考站：点击提示进入考场考试
	 * @param request
	 * @param response void
	 */
	public void entryStation3Exam(HttpServletRequest request, HttpServletResponse response) {
		//modified by yjs at 2016-06-25 begin
		/*int id = Integer.parseInt(request.getParameter("id"));
		int iRetcode = stationDoctorService.updateStation3DoctorFlag(id, (byte)2);*/
		int iRetcode = Constant.ENTRYSTATION_FAIL;
		String id = request.getParameter("id");
		if(!id.isEmpty()){
			iRetcode = stationDoctorService.updateStation3DoctorFlag(Integer.parseInt(id), Constant.INSPECTFLAGYESENTRYSTATION);
		}
		//modified by yjs at 2016-06-25 end
		writeJosnToJsp("{\"result\":" + iRetcode + "}", response);
	}
	
	/**
	 * 第三考站：取消正在进入考场
	 * @param request
	 * @param response void
	 */
	public void cancalStation3ExamEntry(HttpServletRequest request, HttpServletResponse response) {
		//modified by yjs at 2016-06-25 begin
		/*int id = Integer.parseInt(request.getParameter("id"));
		int iRetcode = stationDoctorService.updateStation3DoctorFlag(id, (byte)1);*/
		int iRetCode = Constant.CANCELENTRYSTATIONFAIL;
		String id = request.getParameter("id");
		if(!id.isEmpty()) {
			iRetCode = stationDoctorService.updateStation3DoctorFlag(Integer.parseInt(id), Constant.INSPECTFLAGYES);
		}
		//modified by yjs at 2016-06-25 end
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
	
}