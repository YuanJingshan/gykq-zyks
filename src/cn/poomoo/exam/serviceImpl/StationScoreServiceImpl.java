/**
 * @fileName StationScoreServiceImpl.java
 * @author YuanJingshan
 * @date 2015-6-13
 */
package cn.poomoo.exam.serviceImpl;

import java.util.List;
import java.util.Map;

import cn.poomoo.exam.dao.StationScoreDao;
import cn.poomoo.exam.dao.StationScoreExcelDao;
import cn.poomoo.exam.medol.StationScore;
import cn.poomoo.exam.medol.StationScoreExcel;
import cn.poomoo.exam.service.StationScoreService;

/**
 * @className StationScoreServiceImpl
 * @description 考站成绩服务-实现
 * @author YuanJingshan
 */
public class StationScoreServiceImpl implements StationScoreService {

	//
	private StationScoreDao stationScoreDao = new StationScoreDao();
	//
	private StationScoreExcelDao stationScoreExcelDao = new StationScoreExcelDao();
	
	public StationScoreServiceImpl() {
		
	}

	public int queryCountFirst() {
		String sqlString = "select count(*) from v_station_1_score";
		return stationScoreDao.executeCountSql(sqlString);
	}
	
	public List<StationScore> queryPageDateFirst(int pageNum, int pageSize) {
		String sqlString = "select * from v_station_1_score order by score desc limit " + (pageNum-1)*pageSize + ", " + pageSize;
		return stationScoreDao.getList(sqlString);
	}
	
	public List<StationScore> queryDateByConditionFirst(String condition) {
		String sqlString = "select * from v_station_1_score where " + condition + " order by insert_dt desc";
		return stationScoreDao.getList(sqlString);
	}

	public int deleteFirst(String idStr) {
		String sqlString = "delete from t_station_1_score where id in (" + idStr + ")";
		return stationScoreDao.executeSql(sqlString);
	}
	
	public int queryCountSecond() {
		String sqlString = "select count(*) from v_station_2_score";
		return stationScoreDao.executeCountSql(sqlString);
	}
	
	public List<StationScore> queryPageDateSecond(int pageNum, int pageSize) {
		String sqlString = "select * from v_station_2_score order by score desc limit " + (pageNum-1)*pageSize + ", " + pageSize;
		return stationScoreDao.getList(sqlString);
	}
	
	public List<StationScore> queryDateByConditionSecond(String condition) {
		String sqlString = "select * from v_station_2_score where " + condition + " order by insert_dt desc";
		return stationScoreDao.getList(sqlString);
	}

	public int deleteSecond(String idStr) {
		String sqlString = "delete from t_station_2_score where id in (" + idStr + ")";
		return stationScoreDao.executeSql(sqlString);
	}
	
	public int queryCountThree() {
		String sqlString = "select count(*) from v_station_3_score";
		return stationScoreDao.executeCountSql(sqlString);
	}
	
	public List<StationScore> queryPageDateThree(int pageNum, int pageSize) {
		String sqlString = "select * from v_station_3_score order by score desc limit " + (pageNum-1)*pageSize + ", " + pageSize;
		return stationScoreDao.getList(sqlString);
	}
	
	public List<StationScore> queryDateByConditionThree(String condition) {
		String sqlString = "select * from v_station_3_score where " + condition + " order by insert_dt desc";
		return stationScoreDao.getList(sqlString);
	}

	public int deleteThree(String idStr) {
		String sqlString = "delete from t_station_3_score where id in (" + idStr + ")";
		return stationScoreDao.executeSql(sqlString);
	}

	public int insertStation1Score(Map<String, String> map) {
		String sqlString = "insert into t_station_1_score values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return stationScoreDao.executeSql(sqlString, map);
	}

	public int insertStation2Score(Map<String, String> map) {
			String sqlString = "insert into t_station_2_score values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			return stationScoreDao.executeSql(sqlString, map);
	}
	
	public int insertStation3Score(Map<String, String> map) {
			String sqlString = "insert into t_station_3_score values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
				"?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			return stationScoreDao.executeSql(sqlString, map);
	}

	public StationScore queryStation1ScoreById(int id) {
		String sqlString = "select * from v_station_1_score where id=" + id;
		return stationScoreDao.getObj(sqlString);
	}
	
	public StationScore queryStation2ScoreById(int id) {
		String sqlString = "select * from v_station_2_score where id=" + id;
		return stationScoreDao.getObj(sqlString);
	}
	
	public StationScore queryStation3ScoreById(int id) {
		String sqlString = "select * from v_station_3_score where id=" + id;
		return stationScoreDao.getObj(sqlString);
	}

	public int updateStation1Score(Map<String, String> map) {
		String sqlString = "update t_station_1_score set score=?,count_1=?,topic_1_1=?,topic_1_2=?,topic_1_3=?,topic_1_4=?,topic_1_5=?,topic_1_6=?,topic_1_7=?,topic_1_8=?,count_2=?,topic_2_1=?," +
			"topic_2_2=?,topic_2_3=?,topic_2_4=?,topic_2_5=?,topic_2_6=?,topic_2_7=?,topic_2_8=?,count_3=?,topic_3_1=?,topic_3_2=?,topic_3_3=?,topic_3_4=?,topic_3_5=?,topic_3_6=?," +
			"topic_3_7=?,topic_3_8=?,count_4=?,topic_4_1=?,topic_4_2=?,topic_4_3=?,topic_4_4=?,topic_4_5=?,topic_4_6=?,topic_4_7=?,topic_4_8=?,count_5=?,topic_5_1=?,topic_5_2=?," +
			"topic_5_3=?,topic_5_4=?,topic_5_5=?,topic_5_6=?,topic_5_7=?,topic_5_8=?,count_6=?,topic_6_1=?,topic_6_2=?,topic_6_3=?,topic_6_4=?,topic_6_5=?,topic_6_6=?,topic_6_7=?," +
			"topic_6_8=? where id=?";
		return stationScoreDao.executeSql(sqlString, map);
	}
	
	public int updateStation2Score(Map<String, String> map) {
		String sqlString = "update t_station_2_score set score=?,count_1=?,topic_1_1=?,topic_1_2=?,topic_1_3=?,topic_1_4=?,topic_1_5=?,topic_1_6=?,topic_1_7=?,topic_1_8=?,count_2=?,topic_2_1=?," +
			"topic_2_2=?,topic_2_3=?,topic_2_4=?,topic_2_5=?,topic_2_6=?,topic_2_7=?,topic_2_8=?,count_3=?,topic_3_1=?,topic_3_2=?,topic_3_3=?,topic_3_4=?,topic_3_5=?,topic_3_6=?," +
			"topic_3_7=?,topic_3_8=?,count_4=?,topic_4_1=?,topic_4_2=?,topic_4_3=?,topic_4_4=?,topic_4_5=?,topic_4_6=?,topic_4_7=?,topic_4_8=?,count_5=?,topic_5_1=?,topic_5_2=?," +
			"topic_5_3=?,topic_5_4=?,topic_5_5=?,topic_5_6=?,topic_5_7=?,topic_5_8=?,count_6=?,topic_6_1=?,topic_6_2=?,topic_6_3=?,topic_6_4=?,topic_6_5=?,topic_6_6=?,topic_6_7=?," +
			"topic_6_8=? where id=?";
		return stationScoreDao.executeSql(sqlString, map);
	}
	
	public int updateStation3Score(Map<String, String> map) {
		String sqlString = "update t_station_3_score set score=?,count_1=?,topic_1_1=?,topic_1_2=?,topic_1_3=?,topic_1_4=?,topic_1_5=?,topic_1_6=?,topic_1_7=?,topic_1_8=?,count_2=?,topic_2_1=?," +
			"topic_2_2=?,topic_2_3=?,topic_2_4=?,topic_2_5=?,topic_2_6=?,topic_2_7=?,topic_2_8=?,count_3=?,topic_3_1=?,topic_3_2=?,topic_3_3=?,topic_3_4=?,topic_3_5=?,topic_3_6=?," +
			"topic_3_7=?,topic_3_8=?,count_4=?,topic_4_1=?,topic_4_2=?,topic_4_3=?,topic_4_4=?,topic_4_5=?,topic_4_6=?,topic_4_7=?,topic_4_8=?,count_5=?,topic_5_1=?,topic_5_2=?," +
			"topic_5_3=?,topic_5_4=?,topic_5_5=?,topic_5_6=?,topic_5_7=?,topic_5_8=?,count_6=?,topic_6_1=?,topic_6_2=?,topic_6_3=?,topic_6_4=?,topic_6_5=?,topic_6_6=?,topic_6_7=?," +
			"topic_6_8=? where id=?";
		return stationScoreDao.executeSql(sqlString, map);
	}

	public List<StationScore> queryStation1ScoreByDate(String startDt, String endDt) {
		String sqlString = "select * from v_station_1_score where insert_dt>'" + startDt + "' and insert_dt<'" + endDt + "' order by score desc";
		return stationScoreDao.getList(sqlString);
	}

	public List<StationScore> queryStation2ScoreByDate(String startDt, String endDt) {
		String sqlString = "select * from v_station_2_score where insert_dt>'" + startDt + "' and insert_dt<'" + endDt + "' order by score desc";
		return stationScoreDao.getList(sqlString);
	}

	public List<StationScore> queryStation3ScoreByDate(String startDt, String endDt) {
		String sqlString = "select * from v_station_3_score where insert_dt>'" + startDt + "' and insert_dt<'" + endDt + "' order by score desc";
		return stationScoreDao.getList(sqlString);
	}

	public List<StationScore> queryStation1ScoreAll() {
		String sqlString = "select * from v_station_1_score order by score desc";
		return stationScoreDao.getList(sqlString);
	}

	public List<StationScoreExcel> queryStation1ScoreExcelByDate(
			String startDt, String endDt) {
		String sqlString = "select * from v_station_1_score where insert_dt>'" + startDt + "' and insert_dt<'" + endDt + "' order by score desc";
		return stationScoreExcelDao.getList(sqlString);
	}

	public List<StationScoreExcel> queryStation1ExcelScoreAll() {
		String sqlString = "select * from v_station_1_score order by score desc";
		return stationScoreExcelDao.getList(sqlString);
	}

	public List<StationScoreExcel> queryStation1ScoreExcelByCondition(
			String condition) {
		String sqlString = "select * from v_station_1_score where " + condition + " order by insert_dt desc";
		return stationScoreExcelDao.getList(sqlString);
	}
	
	public List<StationScoreExcel> queryStation2ScoreExcelByDate(
			String startDt, String endDt) {
		String sqlString = "select * from v_station_2_score where insert_dt>'" + startDt + "' and insert_dt<'" + endDt + "' order by score desc";
		return stationScoreExcelDao.getList(sqlString);
	}

	public List<StationScoreExcel> queryStation2ExcelScoreAll() {
		String sqlString = "select * from v_station_2_score order by score desc";
		return stationScoreExcelDao.getList(sqlString);
	}

	public List<StationScoreExcel> queryStation2ScoreExcelByCondition(
			String condition) {
		String sqlString = "select * from v_station_2_score where " + condition + " order by insert_dt desc";
		return stationScoreExcelDao.getList(sqlString);
	}
	
	public List<StationScoreExcel> queryStation3ScoreExcelByDate(
			String startDt, String endDt) {
		String sqlString = "select * from v_station_3_score where insert_dt>'" + startDt + "' and insert_dt<'" + endDt + "' order by score desc";
		return stationScoreExcelDao.getList(sqlString);
	}

	public List<StationScoreExcel> queryStation3ExcelScoreAll() {
		String sqlString = "select * from v_station_3_score order by score desc";
		return stationScoreExcelDao.getList(sqlString);
	}

	public List<StationScoreExcel> queryStation3ScoreExcelByCondition(
			String condition) {
		String sqlString = "select * from v_station_3_score where " + condition + " order by insert_dt desc";
		return stationScoreExcelDao.getList(sqlString);
	}
	
	public int queryStation1FenshuById(int id) {
		String sqlString = "select score from v_station_1_score where id=" + id;
		return stationScoreExcelDao.executeCountSql(sqlString);
	}

	public int queryStation2FenshuById(int id) {
		String sqlString = "select score from v_station_2_score where id=" + id;
		return stationScoreExcelDao.executeCountSql(sqlString);
	}

	public int queryCountStation1Condition(String condition) {
		String sqlString = "select count(*) from v_station_1_score where " + condition;
		return stationScoreDao.executeCountSql(sqlString);
	}

	public List<StationScore> queryPageDateStation1Condition(String condition, int pageNum, int pageSize) {
		String sqlString = "select * from v_station_1_score where " + condition + " order by score desc limit " + (pageNum-1)*pageSize + ", " + pageSize;
		return stationScoreDao.getList(sqlString);
	}

	public int queryCountStation2Condition(String condition) {
		String sqlString = "select count(*) from v_station_2_score where " + condition;
		return stationScoreDao.executeCountSql(sqlString);
	}

	public int queryCountStation3Condition(String condition) {
		String sqlString = "select count(*) from v_station_3_score where " + condition;
		return stationScoreDao.executeCountSql(sqlString);
	}

	public List<StationScore> queryPageDateStation2Condition(String condition, int pageNum, int pageSize) {
		String sqlString = "select * from v_station_2_score where " + condition + " order by score desc limit " + (pageNum-1)*pageSize + ", " + pageSize;
		return stationScoreDao.getList(sqlString);
	}

	public List<StationScore> queryPageDateStation3Condition(String condition, int pageNum, int pageSize) {
		String sqlString = "select * from v_station_3_score where " + condition + " order by score desc limit " + (pageNum-1)*pageSize + ", " + pageSize;
		return stationScoreDao.getList(sqlString);
	}
	
	//added by yjs at 2016-07-02 begin
//	public int queryThrouCountFirst() {
//		String sql = "select count(*) from v_station_1_score where score >= (select sta_1_jg from t_station_jgx)";
//		return stationScoreDao.executeCountSql(sql);
//	}

	public int queryThrouCountFirst(String condition) {
		String sql = null;
		if (condition == null || condition.isEmpty()) {
			sql = "select count(*) from v_station_1_score where score >= (select sta_1_jg from t_station_jgx)";
		} else {
			sql = "select count(*) from v_station_1_score where " + condition + " and score >= (select sta_1_jg from t_station_jgx)";
		}
		return stationScoreDao.executeCountSql(sql);
	}

	public int queryThrouCountSecond(String condition) {
		String sql = null;
		if (condition == null || condition.isEmpty()) {
			sql = "select count(*) from v_station_2_score where score >= (select sta_2_jg from t_station_jgx)";
		} else {
			sql = "select count(*) from v_station_2_score where " + condition + " and score >= (select sta_2_jg from t_station_jgx)";
		}
		return stationScoreDao.executeCountSql(sql);
	}

	public int queryThrouCountThree(String condition) {
		String sql = null;
		if (condition == null || condition.isEmpty()) {
			sql = "select count(*) from v_station_3_score where score >= (select sta_3_jg from t_station_jgx)";
		} else {
			sql = "select count(*) from v_station_3_score where " + condition + " and score >= (select sta_3_jg from t_station_jgx)";
		}
		return stationScoreDao.executeCountSql(sql);
	}
	//added by yjs at 2016-07-02 end

}
