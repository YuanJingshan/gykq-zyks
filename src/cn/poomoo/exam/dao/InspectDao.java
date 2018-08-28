/**
 * @file InspectDoctorDao.java
 * @author yuanjingshan
 * @date 2015-6-21
 */
package cn.poomoo.exam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.poomoo.common.util.LogUtil;
import cn.poomoo.exam.medol.InspectDoctor;

/**
 * @class InspectDoctorDao
 * @description 入口检录Dao
 */
public class InspectDao extends BaseDao {

	public InspectDao() {
	}
	
	public List<InspectDoctor> getList(String sqlString) {
		List<InspectDoctor> list = new ArrayList<InspectDoctor>();
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			//modified by yjs 2015-10-12
			//pStatement = DBConnection.getInstance().getConnection().prepareStatement(sqlString);
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					InspectDoctor doctor = getUserByResultSet(resultSet);
					list.add(doctor);
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
	
	public InspectDoctor getObj(String sqlString) {
		InspectDoctor doctor = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			//modified by yjs 2015-10-12
			//pStatement = DBConnection.getInstance().getConnection().prepareStatement(sqlString);
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				doctor = getUserByResultSet(resultSet);
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
		return doctor;
	}
	
	public InspectDoctor getUserByResultSet(ResultSet resultSet) {
		InspectDoctor doctor = new InspectDoctor();
		try {
			doctor.setId(resultSet.getInt("id"));
			doctor.setName(resultSet.getString("name"));
			doctor.setSex(resultSet.getString("sex"));
			doctor.setNation(resultSet.getString("nation"));
			doctor.setBirthday(resultSet.getString("birthday"));
			doctor.setCard(resultSet.getString("card"));
			doctor.setKsh(resultSet.getString("ksh"));
			doctor.setExamType(resultSet.getInt("exam_type"));
			doctor.setTopic1(resultSet.getString("topic1"));
			doctor.setTopic2(resultSet.getString("topic2"));
			doctor.setTopic3(resultSet.getString("topic3"));
			doctor.setTopic4(resultSet.getString("topic4"));
			doctor.setTopic5(resultSet.getString("topic5"));
			doctor.setTopic6(resultSet.getString("topic6"));
			doctor.setSerialNumber(resultSet.getString("serial_number"));
			doctor.setInsertDt(resultSet.getTimestamp("insert_dt"));
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("从resultSet取值失败......");
		}
		return doctor;
	}
	
}
