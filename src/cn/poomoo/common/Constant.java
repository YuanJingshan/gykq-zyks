package cn.poomoo.common;

/**
 * <p>ClassName: Constant</p>
 * <p>Description: 常量</p>
 * <p>Company: www.shuiguoyizhan.com</p>
 * @author  yjs
 * @date    2016-6-25
 * @vession 1.0.0
 */
public class Constant {
	//检录
	public static final int INSPECTFAIL = 0; //检录失败
	public static final int INSPECT_FAIL = -1; //检录失败  added by yjs at 2018-04-16
	public static final int INSPECTSUCCESS = 1; //检录成功
	public static final int INSPECTTOPICISEXIT = 2;//检录题组号重复
	public static final int INSPECTENTRYNOT = 3; //入口未检录
	public static final int INSPECTENTRYYES = 4; //已检录
	public static final int INSPECTOTHEREXAMNOTEXIT = 5; //其他考站未结束
	public static final int INSPECTNOTEXIST = 6; //考生信息不存在
	public static final int INSPECTOTHER = 7; //其他错误
	//检录标志
	public static final int INSPECTFLAGYES = 0; //检录
	public static final int INSPECTFLAGYESENTRYSTATION = 1; //进入考站
	public static final int INSPECTFLAGYESEXAMOVER = 2; //已考完
	public static final int STATION_VERIFY = 3; // 审核
	
	public static final int VERIFY_SCCUESS = 1; //已审核成功
	
	//入站
	public static final int ENTRYSTATION_FAIL = -1; //进入考站失败
	public static final int ENTRYSTATION_SUCCESS = 1; //进入考站成功
	
	//取消入站
	public static final int CANCELENTRYSTATIONFAIL = -1; //取消进入考站失败
	public static final int CANCELENTRYSTATIONSUCCESS = 1; //取消进入考站成功
	
	public static final String DATE_FORMAT_HHMMDDHHMMSS = "yyyy-MM-dd hh:mm:ss";
	
	//请求
	public static final int REQUEST_SUCCESS = 1;
	public static final int REQUEST_FAILED = 0;
}
