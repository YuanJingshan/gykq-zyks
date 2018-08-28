/**
 * @fileName TopicNum.java
 * @author YuanJingshan
 * @date 2015-6-5
 */
package cn.poomoo.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @className TopicNum
 * @description 生成、分配、清除题组号
 * @author YuanJingshan
 */
public class TopicNum {
	// 存放题组号
	public static List<String> topicNumList = new ArrayList<String>();
	
	/**
	 *  产生001-150题组号
	 *  void
	 */
	public static void generantTopicNum() {
	    Random rand = new Random();  
	    boolean[] bool = new boolean[150];  
	    int num =0;  
	    String item = null;
	    for (int i = 0; i<150; i++){
	    	do{  
	    		//如果产生的数相同继续循环  
	            num = rand.nextInt(150);
	            if (num != 0) {
	            	if (num < 10) {
	 	            	item = "00" + num;
	 				} else if (num < 100) {
	 					item = "0" + num;
	 				} else {
	 					item = "" + num;
	 				}
				}
	        }while(bool[num]);  
	    	if (item != null && !item.isEmpty()) {
		        bool[num] =true;  
		        topicNumList.add(item);  
	    	}
	    }  
	}
	
	/**
	 * 用户拿取题组号
	 * @return int
	 */
	public static String getTopicNum() {
		if (topicNumList.size() == 0) {
			generantTopicNum();
		}
		String topicNum = topicNumList.get(0);
		topicNumList.remove(0);
		return topicNum;
	}
	
	/**
	 *  清除题组号
	 *  void
	 */
	public static void clearTopicNum() {
		topicNumList.clear();
	}
	
}
