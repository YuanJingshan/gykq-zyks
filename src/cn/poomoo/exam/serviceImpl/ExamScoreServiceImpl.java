/**
 * @fileName ExamScoreServiceImpl.java
 * @author YuanJingshan
 * @date 2015-6-13
 */
package cn.poomoo.exam.serviceImpl;

import java.util.List;
import java.util.Map;

import cn.poomoo.exam.dao.ExamScoreDao;
import cn.poomoo.exam.medol.ExamScore;
import cn.poomoo.exam.service.ExamScoreService;

/**
 * @className ExamScoreServiceImpl
 * @description 考生成绩服务-实现
 * @author YuanJingshan
 */
public class ExamScoreServiceImpl implements ExamScoreService {

	//
	ExamScoreDao examScoreDao = new ExamScoreDao();
	
	public ExamScoreServiceImpl() {
	}

	public int queryCount() {
		String sqlString = "select count(*) from v_doctor_score";
		return examScoreDao.executeCountSql(sqlString);
	}

	public List<ExamScore> queryPageDate(int pageNum, int pageSize) {
		String sqlString = "select * from v_doctor_score order by score_count desc limit " + (pageNum-1)*pageSize + ", " + pageSize;
		return examScoreDao.getList(sqlString);
	}

	public List<ExamScore> queryDateByCondition(String condition) {
		String sqlString = "select * from v_doctor_score where " + condition + " order by score_count desc";
		return examScoreDao.getList(sqlString);
	}

	public int deleteDoctor(String idStr) {
		String sqlString = "delete from t_doctor_score where id in (" + idStr + ")";
		return examScoreDao.executeSql(sqlString);
	}

	public int updateExamScore(Map<String, String> map) {
		String sqlString = "call pr_exam_score_update(?,?)";
		return examScoreDao.executePro(sqlString, map);
	}

	public List<ExamScore> queryExamScoreAll() {
		String sqlString = "select * from v_doctor_score order by score_count desc";
		return examScoreDao.getList(sqlString);
	}

	// added by yjs at 2015-07-04 begin 原因：精确查询改模糊查询
	public int queryCountByCondition(String condition) {
		//added by yjs at 2016-07-03 begin
//		String sqlString = "select count(*) from v_doctor_score where " + condition;
		String sql = null;
		if (condition == null || condition.isEmpty()) {
			sql = "select count(*) from v_doctor_score";
		} else {
			sql = "select count(*) from v_doctor_score where " + condition;
		}
		//added by yjs at 2016-07-03 end
		return examScoreDao.executeCountSql(sql);
	}

	public List<ExamScore> queryExamScoreByDateByCondition(String condition, int pageNum, int pageSize) {
		String sqlString = "select * from v_doctor_score where " + condition + " order by score_count desc limit " + (pageNum-1)*pageSize + ", " + pageSize;
		return examScoreDao.getList(sqlString);
	}
	// added by yjs at 2015-07-04 end

	// added by yjs at 2015-07-05 begin
	public int queryThrouCount() {
		String sqlString = "select count(*) from v_doctor_score where score_count >=60";
		return examScoreDao.executeCountSql(sqlString);
	}

	public int queryThrouCountByCondition(String condition) {
		String sql = null;
		if (condition == null || condition.isEmpty()) {
			sql = "select count(*) from v_doctor_score where score_count>=60";
		} else {
			sql = "select count(*) from v_doctor_score where " + condition + " and score_count>=60";
		}
		return examScoreDao.executeCountSql(sql);
	}
	// added by yjs at 2015-07-05 end
}
