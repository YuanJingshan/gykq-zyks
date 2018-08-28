/**
 * @fileName ExamScore.java
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
import cn.poomoo.exam.medol.ExamScore;

/**
 * @className ExamScore
 * @description 考试成绩Dao
 * @author YuanJingshan
 */
public class ExamScoreDao extends BaseDao {

	public ExamScoreDao() {
		
	}
	
	public List<ExamScore> getList(String sqlString) {
		List<ExamScore> list = new ArrayList<ExamScore>();
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			//modified by yjs 2015-10-12
			//pStatement = DBConnection.getInstance().getConnection().prepareStatement(sqlString);
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					ExamScore examScore = getUserByResultSet(resultSet);
					list.add(examScore);
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
	
	public ExamScore getObj(String sqlString) {
		ExamScore examScore = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			//modified by yjs 2015-10-12
			//pStatement = DBConnection.getInstance().getConnection().prepareStatement(sqlString);
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				examScore = getUserByResultSet(resultSet);
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
		return examScore;
	}
	
	public ExamScore getUserByResultSet(ResultSet resultSet) {
		ExamScore examScore = new ExamScore();
		try {
			examScore.setId(resultSet.getInt("id"));
			examScore.setName(resultSet.getString("name"));
			examScore.setSex(resultSet.getString("sex"));
			examScore.setNation(resultSet.getString("nation"));
			examScore.setBirthday(resultSet.getString("birthday"));
			examScore.setCard(resultSet.getString("card"));
			examScore.setKsh(resultSet.getString("ksh"));
			examScore.setSerialNumber(resultSet.getString("serial_number"));
			examScore.setExamType(resultSet.getInt("exam_type"));
			examScore.setScore_1(resultSet.getDouble("score_1"));
			examScore.setScore_2(resultSet.getDouble("score_2"));
			examScore.setScore_3(resultSet.getDouble("score_3"));
			examScore.setScore_count(resultSet.getDouble("score_count"));
			examScore.setEntryDt(resultSet.getTimestamp("entry_dt"));
			examScore.setInsertDt(resultSet.getTimestamp("insert_dt"));
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("从resultSet取值失败......");
		}
		return examScore;
	}
}
