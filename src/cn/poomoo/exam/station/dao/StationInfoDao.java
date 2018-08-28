/**
 * @fileName DoctorDao.java
 * @author YuanJingshan
 * @date 2018-04-11 新增
 */
package cn.poomoo.exam.station.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.poomoo.common.util.LogUtil;
import cn.poomoo.exam.dao.BaseDao;
import cn.poomoo.exam.station.model.StationInfo;

/**
 * @className StationInfoDao
 * @description 考站信息DAO
 * @author YuanJingshan
 */
public class StationInfoDao extends BaseDao {
	
	public StationInfoDao() {
		
	}

	public List<StationInfo> getList(String sqlString) {
		
		LogUtil.getInstance().getLogger().info("sql: " + sqlString);
		
		List<StationInfo> list = new ArrayList<StationInfo>();
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					StationInfo stationDoctor = getUserByResultSet(resultSet);
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
	
	public StationInfo getObj(String sqlString) {
		StationInfo stationDoctor = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
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
	
	public StationInfo getUserByResultSet(ResultSet resultSet) {
		StationInfo stationDoctor = new StationInfo();
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
			stationDoctor.setStation(resultSet.getInt("station"));
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("从resultSet取值失败......");
		}
		return stationDoctor;
	}
	
}
