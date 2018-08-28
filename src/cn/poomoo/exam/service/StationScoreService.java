/**
 * @fileName StationScoreService.java
 * @author YuanJingshan
 * @date 2015-6-13
 */
package cn.poomoo.exam.service;

import java.util.List;
import java.util.Map;

import cn.poomoo.exam.medol.StationScore;
import cn.poomoo.exam.medol.StationScoreExcel;

/**
 * @className StationScoreService
 * @description 考站成绩服务-接口
 * @author YuanJingshan
 */
public interface StationScoreService {

	/**
	 * 查询总数
	 * @return int
	 */
	int queryCountFirst();

	/**
	 * 根据页码查询
	 * @param pageNum
	 * @param pageSize
	 * @return List<StationScore>
	 */
	List<StationScore> queryPageDateFirst(int pageNum, int pageSize);

	/**
	 * 根据条件查询
	 * @param condition
	 * @return List<StationScore>
	 */
	List<StationScore> queryDateByConditionFirst(String condition);

	/**
	 * 删除
	 * @param idStr
	 * @return int
	 */
	int deleteFirst(String idStr);
	
	/**
	 * 查询总数
	 * @return int
	 */
	int queryCountSecond();

	/**
	 * 根据页码查询
	 * @param pageNum
	 * @param pageSize
	 * @return List<StationScore>
	 */
	List<StationScore> queryPageDateSecond(int pageNum, int pageSize);

	/**
	 * 根据条件查询
	 * @param condition
	 * @return List<StationScore>
	 */
	List<StationScore> queryDateByConditionSecond(String condition);

	/**
	 * 删除
	 * @param idStr
	 * @return int
	 */
	int deleteSecond(String idStr);
	
	/**
	 * 查询总数
	 * @return int
	 */
	int queryCountThree();

	/**
	 * 根据页码查询
	 * @param pageNum
	 * @param pageSize
	 * @return List<StationScore>
	 */
	List<StationScore> queryPageDateThree(int pageNum, int pageSize);

	/**
	 * 根据条件查询
	 * @param condition
	 * @return List<StationScore>
	 */
	List<StationScore> queryDateByConditionThree(String condition);

	/**
	 * 删除
	 * @param idStr
	 * @return int
	 */
	int deleteThree(String idStr);

	/**
	 * 插入第一考站成绩
	 * @param map
	 * @return int
	 */
	int insertStation1Score(Map<String, String> map);

	/**
	 * 插入第二考站成绩
	 * @param map
	 * @return int
	 */
	int insertStation2Score(Map<String, String> map);

	/**
	 * 插入第三考站成绩
	 * @param map
	 * @return int
	 */
	int insertStation3Score(Map<String, String> map);

	/**
	 * 查询考生第一站成绩-根据id
	 * @param parseInt
	 * @return StationScore
	 */
	StationScore queryStation1ScoreById(int id);
	
	/**
	 * 查询考生第二站成绩-根据id
	 * @param parseInt
	 * @return StationScore
	 */
	StationScore queryStation2ScoreById(int id);
	
	/**
	 * 查询考生第三站成绩-根据id
	 * @param parseInt
	 * @return StationScore
	 */
	StationScore queryStation3ScoreById(int id);

	/**
	 * 更新第一考站成绩
	 * @param map
	 * @return int
	 */
	int updateStation1Score(Map<String, String> map);
	
	/**
	 * 更新第二考站成绩
	 * @param map
	 * @return int
	 */
	int updateStation2Score(Map<String, String> map);

	/**
	 * 更新第三考站成绩
	 * @param map
	 * @return int
	 */
	int updateStation3Score(Map<String, String> map);

	/**
	 * 根据时间来查询
	 * @param startDt
	 * @param endDt
	 * @return List<StationScore>
	 */
	List<StationScore> queryStation1ScoreByDate(String startDt, String endDt);

	/**
	 * 根据时间来查询
	 * @param startDt
	 * @param endDt
	 * @return List<StationScore>
	 */
	List<StationScore> queryStation2ScoreByDate(String startDt, String endDt);

	/**
	 * @param startDt
	 * @param endDt
	 * @return List<StationScore>
	 */
	List<StationScore> queryStation3ScoreByDate(String startDt, String endDt);

	/**
	 * 查询所有的第一站成绩
	 * @return List<StationScore>
	 */
	List<StationScore> queryStation1ScoreAll();

	/**
	 * 
	 * @param startDt
	 * @param endDt
	 * @return List<StationScoreExcel>
	 */
	List<StationScoreExcel> queryStation1ScoreExcelByDate(String startDt,
			String endDt);

	/**
	 * @return List<StationScoreExcel>
	 */
	List<StationScoreExcel> queryStation1ExcelScoreAll();

	/**
	 * @param condition
	 * @return List<StationScoreExcel>
	 */
	List<StationScoreExcel> queryStation1ScoreExcelByCondition(String condition);

	/**
	 * @param startDt
	 * @param endDt
	 * @return List<StationScoreExcel>
	 */
	List<StationScoreExcel> queryStation2ScoreExcelByDate(String startDt,
			String endDt);

	/**
	 * @return List<StationScoreExcel>
	 */
	List<StationScoreExcel> queryStation2ExcelScoreAll();

	/**
	 * @param condition
	 * @return List<StationScoreExcel>
	 */
	List<StationScoreExcel> queryStation2ScoreExcelByCondition(String condition);

	/**
	 * @param startDt
	 * @param endDt
	 * @return List<StationScoreExcel>
	 */
	List<StationScoreExcel> queryStation3ScoreExcelByDate(String startDt,
			String endDt);

	/**
	 * @return List<StationScoreExcel>
	 */
	List<StationScoreExcel> queryStation3ExcelScoreAll();

	/**
	 * @param condition
	 * @return List<StationScoreExcel>
	 */
	List<StationScoreExcel> queryStation3ScoreExcelByCondition(String condition);
	
	/**
	 * 查询第一站的分数
	 * @param id
	 * @return int
	 */
	int queryStation1FenshuById(int id);
	
	/**
	 * 查询第二站的分数
	 * @param id
	 * @return int
	 */
	int queryStation2FenshuById(int id);

	/**
	 * 第一考站：查选第一站成绩记录数量,根据传入的条件
	 * @param dateCondition
	 * @return int
	 */
	int queryCountStation1Condition(String condition);

	/**
	 * 第一考站：查选第一站成绩记录数据，根据传入的条件
	 * @param dateCondition
	 * @param pageNum
	 * @param pageSize
	 * @return List<StationScore>
	 */
	List<StationScore> queryPageDateStation1Condition(String condition, int pageNum, int pageSize);

	/**
	 * 第二考站：查选第一站成绩记录数量,根据传入的条件
	 * @param dateCondition
	 * @return int
	 */
	int queryCountStation2Condition(String dateCondition);

	/**
	 * 第二考站：查选第一站成绩记录数据，根据传入的条件
	 * @param dateCondition
	 * @param pageNum
	 * @param pageSize
	 * @return List<StationScore>
	 */
	List<StationScore> queryPageDateStation2Condition(String dateCondition, int pageNum, int pageSize);

	/**
	 * 第三考站：查选第一站成绩记录数量,根据传入的条件
	 * @param dateCondition
	 * @return int
	 */
	int queryCountStation3Condition(String dateCondition);

	/**
	 * 第三考站：查选第一站成绩记录数据，根据传入的条件
	 * @param dateCondition
	 * @param pageNum
	 * @param pageSize
	 * @return List<StationScore>
	 */
	List<StationScore> queryPageDateStation3Condition(String dateCondition, int pageNum, int pageSize);
	
	//added by yjs at 2016-07-02 begin
	//int queryThrouCountFirst();

	int queryThrouCountFirst(String condition);

	int queryThrouCountSecond(String condition);

	int queryThrouCountThree(String condition);
	//added by yjs at 2016-07-02 end
	
}
