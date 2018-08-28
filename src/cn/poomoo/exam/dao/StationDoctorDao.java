/**
 * @fileName DoctorDao.java
 * @author YuanJingshan
 * @date 2015-6-12
 */
package cn.poomoo.exam.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.poomoo.common.util.LogUtil;
import cn.poomoo.exam.medol.StationDoctor;

/**
 * @className DoctorDao
 * @description 医生信息Dao
 * @author YuanJingshan
 */
public class StationDoctorDao extends BaseDao {
	
	public StationDoctorDao() {
		
	}

	public List<StationDoctor> getList(String sqlString) {
		List<StationDoctor> list = new ArrayList<StationDoctor>();
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			//modified by yjs 2015-10-12
			//pStatement = DBConnection.getInstance().getConnection().prepareStatement(sqlString);
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					StationDoctor stationDoctor = getUserByResultSet(resultSet);
					list.add(stationDoctor);
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
	
	public StationDoctor getObj(String sqlString) {
		StationDoctor stationDoctor = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			//modified by yjs 2015-10-12
			//pStatement = DBConnection.getInstance().getConnection().prepareStatement(sqlString);
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				stationDoctor = getUserByResultSet(resultSet);
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
		return stationDoctor;
	}
	
	public StationDoctor getUserByResultSet(ResultSet resultSet) {
		StationDoctor stationDoctor = new StationDoctor();
		try {
			stationDoctor.setId(resultSet.getInt("id"));
			stationDoctor.setName(resultSet.getString("name"));
			stationDoctor.setSex(resultSet.getString("sex"));
			stationDoctor.setNation(resultSet.getString("nation"));
			stationDoctor.setBirthday(resultSet.getString("birthday"));
			stationDoctor.setCard(resultSet.getString("card"));
			stationDoctor.setKsh(resultSet.getString("ksh"));
			stationDoctor.setExamType(resultSet.getInt("exam_type"));
			stationDoctor.setTopic(resultSet.getString("topic"));
			stationDoctor.setSerialNumber(resultSet.getString("serial_number"));
			stationDoctor.setFlag(resultSet.getByte("flag"));
			stationDoctor.setExamGroup(resultSet.getString("exam_group"));
			stationDoctor.setInsertDt(resultSet.getTimestamp("insert_dt"));
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("从resultSet取值失败......");
		}
		return stationDoctor;
	}
	
}
