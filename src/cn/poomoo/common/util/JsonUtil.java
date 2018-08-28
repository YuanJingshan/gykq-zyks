package cn.poomoo.common.util;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import cn.poomoo.common.Constant;
import cn.poomoo.common.DateJsonValueProcessor;

/**
 * json工具
 *
 * @author Yuan Jingshan
 * @date 2017-5-1
 * @version 1.0.0
 */
public class JsonUtil {

	public static String jsonToString(Object object) {
		JSONObject jsonObject = new JSONObject();
		try {
			JsonConfig jsonConfig = new JsonConfig();  
			jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor(Constant.DATE_FORMAT_HHMMDDHHMMSS));  
			jsonObject = JSONObject.fromObject(object, jsonConfig);
			return jsonObject.toString();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("list转json失败！");
			return "{}";
		}
	}
	
	public static String jsonToString(List list) {
		JSONArray jsonArray = new JSONArray();
		try {
			JsonConfig jsonConfig = new JsonConfig();  
			jsonConfig.registerJsonValueProcessor(Date.class, new DateJsonValueProcessor(Constant.DATE_FORMAT_HHMMDDHHMMSS));  
			jsonArray = JSONArray.fromObject(list, jsonConfig);
			return jsonArray.toString();
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("list转json失败！");
			return "[]";
		}
	}
}
