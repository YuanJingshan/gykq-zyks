/**
 * @fileName StationScoreDao.java
 * @author YuanJingshan
 * @date 2015-6-13
 */
package cn.poomoo.exam.station.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.poomoo.common.util.LogUtil;
import cn.poomoo.exam.dao.BaseDao;
import cn.poomoo.exam.station.model.StationScoreEx;

/**
 * @className StationScoreDao
 * @description 考站学生成绩Dao
 * @author YuanJingshan
 */
public class StationScoreExDao extends BaseDao {

	public StationScoreExDao() {
		
	}
	
	public List<StationScoreEx> getList(String sqlString) {
		
		LogUtil.getInstance().getLogger().info("sql: " + sqlString);
		
		List<StationScoreEx> list = new ArrayList<StationScoreEx>();
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			//modified by yjs 2015-10-12
			//pStatement = DBConnection.getInstance().getConnection().prepareStatement(sqlString);
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					StationScoreEx stationScore = getUserByResultSet(resultSet);
					list.add(stationScore);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("执行查询失败：" + sqlString);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				LogUtil.getInstance().getLogger().error("数据库错误回滚/关闭pStatement、resultSet失败！");
			}
		}
		return list;
	}
	
	public StationScoreEx getObj(String sqlString) {
		StationScoreEx stationScore = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			//modified by yjs 2015-10-12
			//pStatement = DBConnection.getInstance().getConnection().prepareStatement(sqlString);
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				stationScore = getUserByResultSet(resultSet);
			}
		} catch (Exception e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("执行查询失败：" + sqlString);
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (pStatement != null) {
					pStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				LogUtil.getInstance().getLogger().error("数据库错误回滚/关闭pStatement、resultSet失败！");
			}
		}
		return stationScore;
	}
	
	public StationScoreEx getUserByResultSet(ResultSet resultSet) {
		StationScoreEx stationScore = new StationScoreEx();
		try {
			stationScore.setId(resultSet.getInt("id"));
			stationScore.setName(resultSet.getString("name"));
			stationScore.setSex(resultSet.getString("sex"));
			stationScore.setNation(resultSet.getString("nation"));
			stationScore.setBirthday(resultSet.getString("birthday"));
			stationScore.setCard(resultSet.getString("card"));
			stationScore.setKsh(resultSet.getString("ksh"));
			stationScore.setExamType(resultSet.getInt("exam_type"));
			stationScore.setTopic(resultSet.getString("topic"));
			stationScore.setScore(resultSet.getFloat("score"));
			stationScore.setCount_1(resultSet.getFloat("count_1"));
			stationScore.setTopic_1_1(resultSet.getFloat("topic_1_1"));
			stationScore.setTopic_1_2(resultSet.getFloat("topic_1_2"));
			stationScore.setTopic_1_3(resultSet.getFloat("topic_1_3"));
			stationScore.setTopic_1_4(resultSet.getFloat("topic_1_4"));
			stationScore.setTopic_1_5(resultSet.getFloat("topic_1_5"));
			stationScore.setTopic_1_6(resultSet.getFloat("topic_1_6"));
			stationScore.setTopic_1_7(resultSet.getFloat("topic_1_7"));
			stationScore.setTopic_1_8(resultSet.getFloat("topic_1_8"));
			stationScore.setCount_2(resultSet.getFloat("count_2"));
			stationScore.setTopic_2_1(resultSet.getFloat("topic_2_1"));
			stationScore.setTopic_2_2(resultSet.getFloat("topic_2_2"));
			stationScore.setTopic_2_3(resultSet.getFloat("topic_2_3"));
			stationScore.setTopic_2_4(resultSet.getFloat("topic_2_4"));
			stationScore.setTopic_2_5(resultSet.getFloat("topic_2_5"));
			stationScore.setTopic_2_6(resultSet.getFloat("topic_2_6"));
			stationScore.setTopic_2_7(resultSet.getFloat("topic_2_7"));
			stationScore.setTopic_2_8(resultSet.getFloat("topic_2_8"));
			stationScore.setCount_3(resultSet.getFloat("count_3"));
			stationScore.setTopic_3_1(resultSet.getFloat("topic_3_1"));
			stationScore.setTopic_3_2(resultSet.getFloat("topic_3_2"));
			stationScore.setTopic_3_3(resultSet.getFloat("topic_3_3"));
			stationScore.setTopic_3_4(resultSet.getFloat("topic_3_4"));
			stationScore.setTopic_3_5(resultSet.getFloat("topic_3_5"));
			stationScore.setTopic_3_6(resultSet.getFloat("topic_3_6"));
			stationScore.setTopic_3_7(resultSet.getFloat("topic_3_7"));
			stationScore.setTopic_3_8(resultSet.getFloat("topic_3_8"));
			stationScore.setCount_4(resultSet.getFloat("count_4"));
			stationScore.setTopic_4_1(resultSet.getFloat("topic_4_1"));
			stationScore.setTopic_4_2(resultSet.getFloat("topic_4_2"));
			stationScore.setTopic_4_3(resultSet.getFloat("topic_4_3"));
			stationScore.setTopic_4_4(resultSet.getFloat("topic_4_4"));
			stationScore.setTopic_4_5(resultSet.getFloat("topic_4_5"));
			stationScore.setTopic_4_6(resultSet.getFloat("topic_4_6"));
			stationScore.setTopic_4_7(resultSet.getFloat("topic_4_7"));
			stationScore.setTopic_4_8(resultSet.getFloat("topic_4_8"));
			stationScore.setCount_5(resultSet.getFloat("count_5"));
			stationScore.setTopic_5_1(resultSet.getFloat("topic_5_1"));
			stationScore.setTopic_5_2(resultSet.getFloat("topic_5_2"));
			stationScore.setTopic_5_3(resultSet.getFloat("topic_5_3"));
			stationScore.setTopic_5_4(resultSet.getFloat("topic_5_4"));
			stationScore.setTopic_5_5(resultSet.getFloat("topic_5_5"));
			stationScore.setTopic_5_6(resultSet.getFloat("topic_5_6"));
			stationScore.setTopic_5_7(resultSet.getFloat("topic_5_7"));
			stationScore.setTopic_5_8(resultSet.getFloat("topic_5_8"));
			stationScore.setCount_6(resultSet.getFloat("count_6"));
			stationScore.setTopic_6_1(resultSet.getFloat("topic_6_1"));
			stationScore.setTopic_6_2(resultSet.getFloat("topic_6_2"));
			stationScore.setTopic_6_3(resultSet.getFloat("topic_6_3"));
			stationScore.setTopic_6_4(resultSet.getFloat("topic_6_4"));
			stationScore.setTopic_6_5(resultSet.getFloat("topic_6_5"));
			stationScore.setTopic_6_6(resultSet.getFloat("topic_6_6"));
			stationScore.setTopic_6_7(resultSet.getFloat("topic_6_7"));
			stationScore.setTopic_6_8(resultSet.getFloat("topic_6_8"));
			stationScore.setEntryDt(resultSet.getTimestamp("entry_dt"));
			stationScore.setInsertDt(resultSet.getTimestamp("insert_dt"));
			stationScore.setStation(resultSet.getInt("station"));
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("从resultSet取值失败......");
		}
		return stationScore;
	}
}
