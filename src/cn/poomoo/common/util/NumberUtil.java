package cn.poomoo.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.poomoo.exam.params.model.Params;
import cn.poomoo.exam.params.service.ParamsService;
import cn.poomoo.exam.params.service.impl.ParamsServiceImpl;

/**
 * 考生序号
 *
 * @author Yuan Jingshan
 * @date 2017-4-29
 * @version 1.0.0
 */
public class NumberUtil {
	
	// 存放序号
	public static List<String> serialNumberList = new ArrayList<String>();
	public static List<String> topic1List = new ArrayList<String>();
	public static List<String> topic2List = new ArrayList<String>();
	public static List<String> topic3List = new ArrayList<String>();
	public static List<String> topic4List = new ArrayList<String>();
	public static List<String> topic5List = new ArrayList<String>();
	public static List<String> topic6List = new ArrayList<String>();
	
	public static int serialNumberCount = 500;
	public static int topic1NumCount = 150;
	public static int topic2NumCount = 150;
	public static int topic3NumCount = 150;
	public static int topic4NumCount = 150;
	public static int topic5NumCount = 150;
	public static int topic6NumCount = 150;

	public static void init() {
		ParamsService paramsService = new ParamsServiceImpl();
		Params params = paramsService.queryParams();
		serialNumberCount = params.getSerialNumber();
		topic1NumCount = params.getTopic1();
		topic2NumCount = params.getTopic2();
		topic3NumCount = params.getTopic3();
		topic4NumCount = params.getTopic4();
		topic5NumCount = params.getTopic5();
		topic6NumCount = params.getTopic6();
		clear();
		generantSerialNumber();
		generantTopic(topic1NumCount, topic1List);
		generantTopic(topic2NumCount, topic2List);
		generantTopic(topic3NumCount, topic3List);
		generantTopic(topic4NumCount, topic4List);
		generantTopic(topic5NumCount, topic5List);
		generantTopic(topic6NumCount, topic6List);
	}
	
	// 清除序号
	private static void clear() {
		serialNumberList.clear();
		topic1List.clear();
		topic2List.clear();
		topic3List.clear();
		topic4List.clear();
		topic5List.clear();
		topic6List.clear();
	}
	
	// 生成序号
	public static void generantSerialNumber() {
		String item = null;
	    for (int i = 1; i <= serialNumberCount; i++){
        	if (i < 10) {
            	item = String.valueOf("00" + i);
			} else if (i < 100) {
				item = String.valueOf("0" + i);
			} else {
				item = String.valueOf(i);
			}
        	serialNumberList.add(item);
	    }  
	}
	
	// 生成题组号
	private static void generantTopic(int count, List<String> list) {
		Random rand = new Random(); 
		boolean bool[] = new boolean[count];
	    String topicNum = null;
	    int num = 0;
	    for (int i = 0; i< count; i++){
	    	do{  
	    		//如果产生的数相同继续循环  
	            num = rand.nextInt(count);
	            if (num != 0) {
	            	if (num < 10) {
	            		topicNum = String.valueOf("00" + num);
	    			} else if (num < 100) {
	    				topicNum = String.valueOf("0" + num);
	    			} else {
	    				topicNum = String.valueOf(num);
	    			}
				}
	        }while(bool[num]);  
	    	if (topicNum != null && !topicNum.isEmpty()) {
		        bool[num] =true;  
		        list.add(topicNum);  
	    	}
	    }  
	}
	
	// 获取序号
	public static String getSerialNumber() {
		if (serialNumberList.size() == 0) {
			generantSerialNumber();
		}
		String serialNumber = serialNumberList.get(0);
		serialNumberList.remove(0);
		return serialNumber;
	}
	
	// 获取题组号
	public static String getTopicNum(int station) {
		String topicNum = null;
		
		switch (station) {
		case 1:
			if (topic1List.size() == 0) {
				generantTopic(topic1NumCount, topic1List);
			}
			topicNum = topic1List.get(0);
			topic1List.remove(0);
			break;
		case 2:
			if (topic2List.size() == 0) {
				generantTopic(topic2NumCount, topic2List);
			}
			topicNum = topic2List.get(0);
			topic2List.remove(0);
			break;
		case 3:
			if (topic3List.size() == 0) {
				generantTopic(topic3NumCount, topic3List);
			}
			topicNum = topic3List.get(0);
			topic3List.remove(0);
			break;
		case 4:
			if (topic4List.size() == 0) {
				generantTopic(topic1NumCount, topic4List);
			}
			topicNum = topic4List.get(0);
			topic4List.remove(0);
			break;
		case 5:
			if (topic5List.size() == 0) {
				generantTopic(topic1NumCount, topic5List);
			}
			topicNum = topic5List.get(0);
			topic5List.remove(0);
			break;
		case 6:
			if (topic6List.size() == 0) {
				generantTopic(topic1NumCount, topic6List);
			}
			topicNum = topic6List.get(0);
			topic6List.remove(0);
			break;
		}
		
		return topicNum;
	}
	
	
	
	/*// 生成第二站题组号
	public static void generantTopic2Num() {
		Random rand = new Random(); 
		boolean bool[] = new boolean[topic2NumCount];
	    String topicNum = null;
	    int num = 0;
	    for (int i = 0; i< topic2NumCount; i++){
	    	do{  
	    		//如果产生的数相同继续循环  
	            num = rand.nextInt(topic2NumCount);
	            if (num != 0) {
	            	if (num < 10) {
	            		topicNum = String.valueOf("00" + num);
	    			} else if (num < 100) {
	    				topicNum = String.valueOf("0" + num);
	    			} else {
	    				topicNum = String.valueOf(num);
	    			}
				}
	        }while(bool[num]);  
	    	if (topicNum != null && !topicNum.isEmpty()) {
		        bool[num] =true;  
		        topic2List.add(topicNum);  
	    	}
	    }  
	}
	
	// 生成第三站题组号
	public static void generantTopic3Num() {
		Random rand = new Random(); 
		boolean bool[] = new boolean[topic3NumCount];
	    String topicNum = null;
	    int num = 0;
	    for (int i = 0; i< topic3NumCount; i++){
	    	do{  
	    		//如果产生的数相同继续循环  
	            num = rand.nextInt(topic3NumCount);
	            if (num != 0) {
	            	if (num < 10) {
	            		topicNum = String.valueOf("00" + num);
	    			} else if (num < 100) {
	    				topicNum = String.valueOf("0" + num);
	    			} else {
	    				topicNum = String.valueOf(num);
	    			}
				}
	        }while(bool[num]);  
	    	if (topicNum != null && !topicNum.isEmpty()) {
		        bool[num] =true;  
		        topic3List.add(topicNum);  
	    	}
	    }  
	}
	
	// 获取题组号
	public static String getTopic1Num() {
		if (topic1List.size() == 0) {
			generantTopic1Num();
		}
		String topicNum = topic1List.get(0);
		topic1List.remove(0);
		return topicNum;
	}
	
	// 清除题组号
	public static void clearTopic1Num() {
		topic1List.clear();
	}
	
	// 获取题组号
	public static String getTopic2Num() {
		if (topic2List.size() == 0) {
			generantTopic2Num();
		}
		String topicNum = topic2List.get(0);
		topic2List.remove(0);
		return topicNum;
	}
	
	// 清除题组号
	public static void clearTopic2Num() {
		topic2List.clear();
	}
	
	// 获取题组号
	public static String getTopic3Num() {
		if (topic3List.size() == 0) {
			generantTopic3Num();
		}
		String topicNum = topic3List.get(0);
		topic3List.remove(0);
		return topicNum;
	}
	
	// 清除题组号
	public static void clearTopic3Num() {
		topic3List.clear();
	}
	
	// 获取题组号
	public static String getTopic3Num() {
		if (topic3List.size() == 0) {
			generantTopic3Num();
		}
		String topicNum = topic3List.get(0);
		topic3List.remove(0);
		return topicNum;
	}
	
	// 清除题组号
	public static void clearTopic3Num() {
		topic3List.clear();
	}
	
	// 获取题组号
	public static String getTopic3Num() {
		if (topic3List.size() == 0) {
			generantTopic3Num();
		}
		String topicNum = topic3List.get(0);
		topic3List.remove(0);
		return topicNum;
	}
	
	// 清除题组号
	public static void clearTopic3Num() {
		topic3List.clear();
	}
	
	// 获取题组号
	public static String getTopic3Num() {
		if (topic3List.size() == 0) {
			generantTopic3Num();
		}
		String topicNum = topic3List.get(0);
		topic3List.remove(0);
		return topicNum;
	}
	
	// 清除题组号
	public static void clearTopic3Num() {
		topic3List.clear();
	}*/
	
}
