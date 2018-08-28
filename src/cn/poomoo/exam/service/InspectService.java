/**
 * @file InspectService.java
 * @author yuanjingshan
 * @date 2015-6-21
 */
package cn.poomoo.exam.service;

import java.util.List;
import java.util.Map;

import cn.poomoo.exam.medol.InspectDoctor;

/**
 * @class InspectService
 * @description 检录-接口
 */
public interface InspectService {

	/**
	 * 根据id查询检录信息
	 * @param id
	 * @return int
	 */
	InspectDoctor queryInspectById(int id);

	/**
	 * 插入检录考生信息
	 * @param map
	 * @return int
	 */
	int insertInspect(Map<String, String> map);

	/**
	 * 查询检录考生人数
	 * @return int
	 */
	int queryInspectCount();

	/**
	 * 查询已检录但未入站的考生
	 * @return List<InspectDoctor>
	 */
	List<InspectDoctor> queryInspectNotEntry();
	
	/**
	 * 查询已检录正在入站的考生
	 * @return List<InspectDoctor>
	 */
	List<InspectDoctor> queryInspectEntring();
	
	/**
	 * 查询已检录已入站的考生
	 * @return List<InspectDoctor>
	 */
	List<InspectDoctor> queryInspectEntried();

	/**
	 * 查询所有在检录站的考生
	 * @return List<InspectDoctor>
	 */
	List<InspectDoctor> queryInspectAll();

	/**
	 * 根据id来更新检录状态
	 * @param id
	 * @param i void
	 */
	//mofified by yjs at 2016-06-25 feom byte to int
	int updateInspectFlagById(int id, int i);

	/**
	 * @return int
	 */
	int queryEntriedCount();

	/**
	 * 第一站入口检录
	 * @param map
	 * @return int
	 */
	int station1Inspect(Map<String, String> map);

	/**
	 * 查询人数-根据相应的状态
	 * @param i
	 * @return int
	 */
	//mofified by yjs at 2016-06-25 feom byte to int
	int queryInspectCountByFlag(int i);

	/**
	 * 查询题组号是否存在
	 * @param topic
	 * @return int
	 */
	int queryInspectTopicCount(String topic);

	/**
	 * 第三考站检录
	 * @param map
	 * @return
	 */
	int station3Inspect(Map<String, String> map);

	/**
	 * 第二考站检录
	 * @param map
	 * @return
	 */
	int station2Inspect(Map<String, String> map);
	
	/**
	 * 考站检录
	 * @param map
	 * @return
	 */
	int stationInspect(Map<String, String> map);
	
}
