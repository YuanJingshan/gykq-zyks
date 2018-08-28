/**
 * @file StationDoctorService.java
 * @author yuanjingshan
 * @date 2015-6-18
 */
package cn.poomoo.exam.service;

import java.util.List;
import java.util.Map;

import cn.poomoo.exam.medol.InspectDoctor;
import cn.poomoo.exam.medol.StationDoctor;

/**
 * @class StationDoctorService
 * @description 考站考生-服务接口
 */
public interface StationDoctorService {

	/**
	 * 入站
	 * @param map
	 * @return int
	 */
	int insertStation1(Map<String, String> map);

	/**
	 * 第一考站：等候考生
	 * @return List<StationDoctor>
	 */
	List<StationDoctor> queryStation1NotEntry();

	/**
	 * 第一考站:正在考试的考生
	 * @return List<StationDoctor>
	 */
	List<StationDoctor> queryStation1Entried();
	
	/**
	 * 第一考站：更新医生状态
	 * @param id
	 * @param flag 
	 * @return int
	 */
	int updateStation1DoctorFlag(int id, int flag);

	/**
	 * 第一考站：通过id来查询考生信息
	 * @param id
	 * @return StationDoctor
	 */
	StationDoctor queryStation1DoctorById(int id);

	/**
	 * 第一考站：通过身份证来查询考生信息
	 * @param card
	 * @return StationDoctor
	 */
	StationDoctor queryStation1DoctorByCardNum(String card);

	/**
	 * 第一考站：查询检录总数
	 * @return int
	 */
	int queryStation1InspectCount();

	/**
	 * 第一考站：查询第一考站所有的考生
	 * @return List<StationDoctor>
	 */
	List<StationDoctor> queryStation1All();

	/**
	 * 第一考站：登分出站的考生
	 * @return List<StationDoctor>
	 */
	List<StationDoctor> queryStation1Exit();
	
	//TODO 根据状态查询考生信息
	List<StationDoctor> getStation1ByStatus(int status);

	/**
	 * 第一考站：根据状态标识查询改状态人数
	 * @param b
	 * @return int
	 */
	//modified by yjs at 2016-06-25 from byte to int
	int queryStation1CountByFlag(int flag);

	/**
	 * 第一考站：出站
	 * @param map
	 * @return int
	 */
	int station1Exit(Map<String, String> map);

	/**
	 * 第二考站：通过身份证来查询考生信息
	 * @param card
	 * @return StationDoctor
	 */
	StationDoctor queryStation2DoctorByCardNum(String card);

	/**
	 * 第二考站：通过id来查询考生信息
	 * @param id
	 * @return StationDoctor
	 */
	StationDoctor queryStation2DoctorById(int id);

	/**
	 * 第二考站：更新医生状态
	 * @param id
	 * @param b
	 * @return int
	 */
	int updateStation2DoctorFlag(int id, int flag);

	/**
	 * 第二考站：根据状态标识查询该状态人数
	 * @param b
	 * @return int
	 */
	int queryStation2CountByFlag(int flag);

	/**
	 * 第二考站：等候考生
	 * @return List<StationDoctor>
	 */
	List<StationDoctor> queryStation2NotEntry();

	/**
	 * 第二考站：考区考生
	 * @return List<StationDoctor>
	 */
	List<StationDoctor> queryStation2Entried();

	/**
	 * 第二考站：考完出站考生
	 * @return List<StationDoctor>
	 */
	List<StationDoctor> queryStation2Exit();
	
	//TODO 根据状态查询考生信息
	List<StationDoctor> getStation2ByStatus(int status);

	/**
	 * 第二考站：出站
	 * @param map
	 * @return int
	 */
	int station2Exit(Map<String, String> map);

	/**
	 * 第三考站：根据身份证查询考生信息
	 * @param card
	 * @return StationDoctor
	 */
	//deleted by yjs at 2016-06-25
	//StationDoctor queryStation3DoctorByCardNum(String card);

	/**
	 * 第三考站：根据id查询考生信息
	 * @param id
	 * @return StationDoctor
	 */
	StationDoctor queryStation3DoctorById(int id);

	/**
	 * 第三考站：根据状态查询考生人数
	 * @param flag
	 * @return int
	 */
	int queryStation3CountByFlag(int flag);

	/**
	 * 第三考站：更新医生状态
	 * @param id
	 * @param b
	 * @return int
	 */
	int updateStation3DoctorFlag(int id, int flag);
	
	/**
	 * 第三考站：等候考生
	 * @return List<StationDoctor>
	 */
	List<StationDoctor> queryStation3NotEntry();

	/**
	 * 第三考站：考区考生
	 * @return List<StationDoctor>
	 */
	List<StationDoctor> queryStation3Entried();

	/**
	 * 第三考站：出站考生
	 * @return List<StationDoctor>
	 */
	List<StationDoctor> queryStation3Exit();
	
	//TODO 根据状态查询考生信息
	List<StationDoctor> getStation3ByStatus(int status);

	/**
	 * 第三考站：出站
	 * @param map
	 * @return int
	 */
	int station3Exit(Map<String, String> map);

	/**
	 * @return List<StationDoctor>
	 */
	List<StationDoctor> queryStation1NotInspect();
	
	/**
	 * @return List<StationDoctor>
	 */
	List<StationDoctor> queryStation2NotInspect();
	
	/**
	 * @return List<StationDoctor>
	 */
	List<StationDoctor> queryStation3NotInspect();

	/**
	 * <p>MethodName: queryInspectDoctorByCardNum</p>
	 * <p>Description: 查询检录医生</p>
	 * <p>Company: www.jingshan.com</p>
	 * <p>Parameter: </P>
	 * <p>Return Type: StationDoctor</P>
	 * @author  yjs
	 * @date    2016-6-25
	 * @vession 1.0.0
	 */
	InspectDoctor queryInspectDoctorByCardNum(String card);
	
}
