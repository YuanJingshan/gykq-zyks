/**
 * @fileName StationScoreDao.java
 * @author YuanJingshan
 * @date 2015-6-13
 */
package cn.poomoo.exam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.poomoo.common.util.LogUtil;
import cn.poomoo.exam.medol.StationScoreExcel;

/**
 * @className StationScoreDao
 * @description 考站学生成绩Excel导出Dao
 * @author YuanJingshan
 */
public class StationScoreExcelDao extends BaseDao {

	public StationScoreExcelDao() {
		
	}
	
	public List<StationScoreExcel> getList(String sqlString) {
		List<StationScoreExcel> list = new ArrayList<StationScoreExcel>();
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			//modified by yjs 2015-10-12
			//pStatement = DBConnection.getInstance().getConnection().prepareStatement(sqlString);
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					StationScoreExcel stationScore = getUserByResultSet(resultSet);
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
	
	public StationScoreExcel getObj(String sqlString) {
		StationScoreExcel stationScore = null;
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
	
	public StationScoreExcel getUserByResultSet(ResultSet resultSet) {
		StationScoreExcel stationScore = new StationScoreExcel();
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
			stationScore.setEntryDt(resultSet.getTimestamp("entry_dt"));
			stationScore.setInsertDt(resultSet.getTimestamp("insert_dt"));
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("从resultSet取值失败......");
		}
		return stationScore;
	}
}
