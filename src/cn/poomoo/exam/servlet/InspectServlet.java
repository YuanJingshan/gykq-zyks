/**
 * @file InspectDoctorServlet.java
 * @author yuanjingshan
 * @date 2015-6-21
 */
package cn.poomoo.exam.servlet;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.poomoo.common.Constant;
import cn.poomoo.common.util.DateUtil;
import cn.poomoo.common.util.JsonUtil;
import cn.poomoo.common.util.NumberUtil;
import cn.poomoo.exam.medol.InspectDoctor;
import cn.poomoo.exam.medol.StationDoctor;
import cn.poomoo.exam.service.InspectService;
import cn.poomoo.exam.service.StationDoctorService;
import cn.poomoo.exam.serviceImpl.InspectServiceImpl;
import cn.poomoo.exam.serviceImpl.StationDoctorServiceImpl;

/**
 * @class InspectDoctorServlet
 * @description 检录-Servlet
 */
public class InspectServlet extends BaseServlet {

	//
	private static final long serialVersionUID = -2276496985854798845L;
	//检录服务
	private InspectService inspectService = new InspectServiceImpl();
	//考站医生服务
	private StationDoctorService stationDoctorService = new StationDoctorServiceImpl();
	
	public void doctorInspect(HttpServletRequest request, HttpServletResponse response) {
		int iRetCode = Constant.INSPECTFAIL;
		String id = request.getParameter("id");
		if (!id.isEmpty()) {
			InspectDoctor inspectDoctor = inspectService.queryInspectById(Integer.parseInt(id));
			if (inspectDoctor == null) { // 未检录
				String serialNumber = NumberUtil.getSerialNumber();
				if (serialNumber == "" || serialNumber.isEmpty()) {
					serialNumber = NumberUtil.getSerialNumber();
				}
				String topic1 = NumberUtil.getTopicNum(1);
				if (topic1 == "" || topic1.isEmpty()) {
					topic1 = NumberUtil.getTopicNum(1);
				}
				String topic2 = NumberUtil.getTopicNum(2);
				if (topic2 == "" || topic2.isEmpty()) {
					topic2 = NumberUtil.getTopicNum(2);
				}
				String topic3 = NumberUtil.getTopicNum(3);
				if (topic3 == "" || topic3.isEmpty()) {
					topic3 = NumberUtil.getTopicNum(3);
				}
				String topic4 = NumberUtil.getTopicNum(4);
				if (topic4 == "" || topic4.isEmpty()) {
					topic4 = NumberUtil.getTopicNum(4);
				}
				String topic5 = NumberUtil.getTopicNum(5);
				if (topic5 == "" || topic5.isEmpty()) {
					topic5 = NumberUtil.getTopicNum(5);
				}
				String topic6 = NumberUtil.getTopicNum(6);
				if (topic6 == "" || topic6.isEmpty()) {
					topic6 = NumberUtil.getTopicNum(6);
				}
				
				Map<String, String> map = new LinkedHashMap<String, String>();
				map.put("int_id", id);
				map.put("byte_flag", "0");
				map.put("string_topic1", topic1);
				map.put("string_topic2", topic2);
				map.put("string_topic3", topic3);
				map.put("string_topic4", topic4);
				map.put("string_topic5", topic5);
				map.put("string_topic6", topic6);
				map.put("string_serialNum", serialNumber);
				map.put("date_yyyy-MM-dd HH:mm:ss", DateUtil.dateToString(new Date()));
				iRetCode = inspectService.insertInspect(map);
			} else {
				iRetCode = Constant.INSPECTENTRYYES;
			}
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}",response);
	}
	
	/**
	 * 进入第一考站。
	 * 如果没有进入第一站，则进入第一站，如果已经进入则不再处理
	 * @param request
	 * @param response void
	 */
	public void entryStation1(HttpServletRequest request, HttpServletResponse response) {
		int iRetcode = 0;
		int id = Integer.parseInt(request.getParameter("id"));
		InspectDoctor inspectDoctor = inspectService.queryInspectById(id);
		//判断是否检录
		if (inspectDoctor != null) {
			StationDoctor stationDoctor = stationDoctorService.queryStation1DoctorById(id);
			if (stationDoctor == null) { //未入第一站
				Map<String, String> map = new LinkedHashMap<String, String>();
				map.put("int_id", id + "");
				map.put("byte_flag", inspectDoctor.getFlag()+"");
				map.put("string_serialnumber",inspectDoctor.getSerialNumber());
				map.put("date_yyyy-MM-dd HH:mm:ss", DateUtil.dateToString(new Date()));
				iRetcode = stationDoctorService.insertStation1(map);
				if (iRetcode == 1) {
					inspectService.updateInspectFlagById(id, 2);
				}
			} else {
				iRetcode = 1;
			}
		}
		writeJosnToJsp("{\"result\":" + iRetcode + "}", response);
	}
	
	//added by yjs at 2016-06-25 begin
	/**
	 * <p>MethodName: entrySation</p>
	 * <p>Description: 进入考站，更新考生检录状态</p>
	 * <p>Company: www.jingshan.com</p>
	 * <p>Parameter: request，response</P>
	 * <p>Return Type: void</P>
	 * @author  yjs
	 * @date    2016-6-25
	 * @vession 1.0.0
	 */
	public void entrySation(HttpServletRequest request, HttpServletResponse response) {
		int iRetCode = Constant.ENTRYSTATION_FAIL;
		String id = request.getParameter("id");
		if (!id.isEmpty()) {
			InspectDoctor inspectDoctor = inspectService.queryInspectById(Integer.parseInt(id));
			//判断是否检录
			if (inspectDoctor != null && inspectDoctor.getFlag() == 0) {//未入站，进入考场，更新检录标志
				iRetCode = inspectService.updateInspectFlagById(Integer.parseInt(id),Constant.INSPECTFLAGYESENTRYSTATION);
			}
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
	//added by yjs at 2016-06-25 end

	/**
	 * <p>MethodName: cancalInspectEntrying</p>
	 * <p>Description: 取消进入考站的考生</p>
	 * <p>Company: www.jingshan.com</p>
	 * <p>Parameter: request, response</P>
	 * <p>Return Type: void</P>
	 * @author  yjs
	 * @date    2016-6-25
	 * @vession 1.0.0
	 */
	public void cancalInspectEntrying(HttpServletRequest request, HttpServletResponse response) {
		int iRetCode = Constant.CANCELENTRYSTATIONFAIL;
		String id = request.getParameter("id");
		if (!id.isEmpty()) {
			//更新为检录状态
			iRetCode = inspectService.updateInspectFlagById(Integer.parseInt(id),Constant.INSPECTFLAGYES);
		}
		writeJosnToJsp("{\"result\":" + iRetCode + "}", response);
	}
	
	//added by yjs at 2016-06-25 begin
	/**
	 * <p>MethodName: getInspectDoctorByCard</p>
	 * <p>Description: 根据身份证信息-查询入口已检录考生</p>
	 * <p>Company: www.jingshan.com</p>
	 * <p>Parameter: request，response</P>
	 * <p>Return Type: void</P>
	 * @author  yjs
	 * @date    2016-6-25
	 * @vession 1.0.0
	 */
	public void getInspectDoctorByCard(HttpServletRequest request, HttpServletResponse response) {
		String card = request.getParameter("card");
		InspectDoctor inspectDoctor = stationDoctorService.queryInspectDoctorByCardNum(card);
		StringBuffer stringBuffer = new StringBuffer();
		if (inspectDoctor == null) {
			// 不存在医生信息,医生未检录
			stringBuffer.append("{\"result\":0}"); 
		} else {
			stringBuffer.append("{\"result\":1,\"info\":").append(JsonUtil.jsonToString(inspectDoctor)).append("}");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	//added by yjs at 2016-06-25 end
	
	/**
	 * 获取检录医生-所有
	 * @param request
	 * @param response void
	 */
	public void getInspectAll(HttpServletRequest request, HttpServletResponse response) {
		List<InspectDoctor> allInspectDoctors = inspectService.queryInspectAll();
		StringBuffer stringBuffer = new StringBuffer();
		String allString = "\"all\":{\"count\":0,\"info\":[]}";
		String notEntryString = "\"notEntry\":{\"count\":0,\"info\":[]}";
		String entriedString = "\"entried\":{\"count\":0,\"info\":[]}";
		
		if (!allInspectDoctors.isEmpty()) {
			allString = "\"all\":{\"count\":" + allInspectDoctors.size() + ",\"info\":";
			allString = allString + JsonUtil.jsonToString(allInspectDoctors) + "}";
			
			List<InspectDoctor> notEntryInspectDoctors = inspectService.queryInspectNotEntry();
			if (!notEntryInspectDoctors.isEmpty()) {
				notEntryString = "\"notEntry\":{\"count\":" + notEntryInspectDoctors.size() + ",\"info\":";
				notEntryString = notEntryString + JsonUtil.jsonToString(notEntryInspectDoctors) + "}";
			}
			
			List<InspectDoctor> entriedInspectDoctors = inspectService.queryInspectEntried();
			if (!entriedInspectDoctors.isEmpty()) {
				entriedString = "\"entried\":{\"count\":" + entriedInspectDoctors.size() + ",\"info\":";
				entriedString = entriedString + JsonUtil.jsonToString(entriedInspectDoctors) + "}";
			}
		}
		stringBuffer.append("{" + allString + "," + notEntryString + "," + entriedString + "}");
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	/**
	 * 获取检录医生-未入站信息
	 * @param request
	 * @param response void
	 */
	public void getInspectNotEntry(HttpServletRequest request, HttpServletResponse response) {
		int iInspectNum = inspectService.queryInspectCount();
		//modified by yjs at 2016-06-25 begin
		//int iEntried = inspectService.queryInspectCountByFlag(2);
		int iEntried = inspectService.queryEntriedCount();
		//modified by yjs at 2016-06-25 end
		List<InspectDoctor> inspectDoctors = inspectService.queryInspectNotEntry();
		StringBuffer stringBuffer = new StringBuffer();
		if (inspectDoctors.isEmpty()) {
			stringBuffer.append("{\"inspectNum\":" + iInspectNum + ",\"notEntryNum\":" + inspectDoctors.size() + ",\"entriedNum\":" + iEntried + ",\"info\":[]}");
		} else {
			stringBuffer.append("{\"inspectNum\":" + iInspectNum + ",\"notEntryNum\":" + inspectDoctors.size() + ",\"entriedNum\":" + iEntried + ",\"info\":");
			stringBuffer.append(JsonUtil.jsonToString(inspectDoctors)).append("}");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	/**
	 * 获取检录医生-正在入站信息
	 * @param request
	 * @param response void
	 */
	public void getInspectEntrying(HttpServletRequest request, HttpServletResponse response) {
		int iInspectNum = inspectService.queryInspectCount();
		//modified by at 2016-06-25 begin
		//int iNotEntryNum = inspectService.queryInspectCountByFlag(1);
		int iNotEntryNum = inspectService.queryInspectCountByFlag(Constant.INSPECTFLAGYES);
		//modified by at 2016-06-25 end
		List<InspectDoctor> inspectDoctors = inspectService.queryInspectEntring();
		StringBuffer stringBuffer = new StringBuffer();
		if (inspectDoctors.isEmpty()) {
			stringBuffer.append("{\"inspectNum\":" + iInspectNum + ",\"notEntryNum\":" + iNotEntryNum + ",\"entriedNum\":" + inspectDoctors.size() + ",\"info\":[]}");
		} else {
			stringBuffer.append("{\"inspectNum\":" + iInspectNum + ",\"notEntryNum\":" + iNotEntryNum + ",\"entriedNum\":" + inspectDoctors.size() + ",\"info\":");
			stringBuffer.append(JsonUtil.jsonToString(inspectDoctors)).append("}");
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
}
