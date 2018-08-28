/**
 * @file InspectDoctorServlet.java
 * @author yuanjingshan
 * @date 2015-6-21
 */
package cn.poomoo.exam.servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.poomoo.common.Constant;
import cn.poomoo.common.util.JsonUtil;
import cn.poomoo.exam.medol.ExitVerify;
import cn.poomoo.exam.medol.InspectDoctor;
import cn.poomoo.exam.service.ExitVerifyService;
import cn.poomoo.exam.service.StationDoctorService;
import cn.poomoo.exam.serviceImpl.ExitVerifyServiceImpl;
import cn.poomoo.exam.serviceImpl.StationDoctorServiceImpl;

/**
 * @class InspectDoctorServlet
 * @description 出口审核-Servlet
 */
public class ExitVerifyServlet extends BaseServlet {

	//
	private static final long serialVersionUID = -2276496985854798845L;
	// 出口审核service
	private ExitVerifyService exitVerifyService = new ExitVerifyServiceImpl();
	// 
	private StationDoctorService stationDoctorService = new StationDoctorServiceImpl();
	
	//modified by yjs at 2016-06-26 begin
	/**
	 * 出站审核：查询医生信息并检录-根据身份证信息
	 * @param request
	 * @param response void
	 */
	public void getExitVerifyDoctorInfo(HttpServletRequest request, HttpServletResponse response) {
		
		String card = request.getParameter("card");
		InspectDoctor inspectDoctor = stationDoctorService.queryInspectDoctorByCardNum(card);
		ExitVerify exitVerifyDoctor = null;
		StringBuffer stringBuffer = new StringBuffer();
		Map<String, String> map = new HashMap<String, String>();
		if(inspectDoctor!=null){
			map = exitVerifyService.exitVerifyInfo(inspectDoctor.getId());
			int verifiy_num = exitVerifyService.queryExitVerifyCountByFlag(Constant.VERIFY_SCCUESS);
			exitVerifyDoctor = exitVerifyService.queryExitVerifyDoctorById(inspectDoctor.getId());
			
			stringBuffer.append("{\"result\":" + JsonUtil.jsonToString(map))
						.append(",\"verifiy_num\":" + verifiy_num)
						.append(",\"info\":").append(JsonUtil.jsonToString(exitVerifyDoctor)).append("}");
		} else {
			map.put("result", "3"); // 不存在医生信息
		}
		writeJosnToJsp(stringBuffer.toString(),response);
	}
	
	/**
	 * <p>MethodName: exitVerifyDoctorInspect</p>
	 * <p>Description: 取消进入考站的考生</p>
	 * <p>Company: www.jingshan.com</p>
	 * <p>Parameter: request, response</P>
	 * <p>Return Type: void</P>
	 * @author  yjs
	 * @date    2016-6-25
	 * @vession 1.0.0
	 */
	/*public void exitVerifyDoctorInspect(HttpServletRequest request, HttpServletResponse response) {
		int iRetCode = Constant.INSPECTFAIL;
		String id = request.getParameter("id");
		if (!id.isEmpty()) {
			Map<String, String> map = new LinkedHashMap<String, String>();
			map.put("int_id", id);
			int result = exitVerifyService.exitVerifyInspect(map);
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
	}*/
	//modified by yjs at 2016-06-26 end
	
	/**
	 * 出口审核-审核情况
	 * @param request
	 * @param response void
	 */
	public void getExitVerifyInfo(HttpServletRequest request, HttpServletResponse response) {
		List<ExitVerify> exitVerifyDoctors = exitVerifyService.queryExitVerifyIsOver();
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("{\"count\":").append(exitVerifyDoctors.size())
					.append(",\"info\":").append(JsonUtil.jsonToString(exitVerifyDoctors)).append("}");
		/*if (exitVerifyDoctors.isEmpty()) {
			stringBuffer.append("{\"count\":" + exitVerifyDoctors.size() + ",\"info\":[]}");
		} else {
			stringBuffer.append("{\"count\":" + exitVerifyDoctors.size() + ",\"info\":");
			stringBuffer.append(JsonUtil.jsonToString(exitVerifyDoctors)).append("}");
		}*/
		writeJosnToJsp(stringBuffer.toString(),response);
	}
}
