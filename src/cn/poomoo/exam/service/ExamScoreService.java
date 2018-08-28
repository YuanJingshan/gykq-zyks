/**
 * @fileName ExamScoreService.java
 * @author YuanJingshan
 * @date 2015-6-13
 */
package cn.poomoo.exam.service;

import java.util.List;
import java.util.Map;

import cn.poomoo.exam.medol.ExamScore;

/**
 * @className ExamScoreService
 * @description 考试成绩服务-接口
 * @author YuanJingshan
 */
public interface ExamScoreService {

	/**
	 * 查询总数
	 * @return String
	 */
	int queryCount();

	/**
	 * 根据页码查询-分页
	 * @param pageNum
	 * @param pageSize
	 * @return List<Doctor>
	 */
	List<ExamScore> queryPageDate(int pageNum, int pageSize);

	/**
	 * 根据条件查询
	 * @param condition
	 * @return List<Doctor>
	 */
	List<ExamScore> queryDateByCondition(String condition);

	/**
	 * 删除
	 * @param idStr
	 * @return int
	 */
	int deleteDoctor(String idStr);

	/**
	 * 更新考试成绩
	 * @param map
	 * @return int
	 */
	int updateExamScore(Map<String, String> map);

	/**
	 * 查询所有的考场成绩
	 * @return List<ExamScore>
	 */
	List<ExamScore> queryExamScoreAll();

	/**
	 * 查询考试成绩记录数量-根据条件
	 * @param condition
	 * @return int
	 */
	int queryCountByCondition(String condition);

	/**
	 * 查询成绩记录-根据条件和页面参数
	 * @param condition
	 * @param pageNum
	 * @param pageSize
	 * @return List<ExamScore>
	 */
	List<ExamScore> queryExamScoreByDateByCondition(String condition, int pageNum, int pageSize);

	/**
	 * 通过人数
	 * @return int
	 */
	int queryThrouCount();

	/**
	 * 根据条件查询-通过人数
	 * @param condition
	 * @return int
	 */
	int queryThrouCountByCondition(String condition);

}
