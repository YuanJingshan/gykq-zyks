/**
 * @file InspectDoctorDao.java
 * @author yuanjingshan
 * @date 2015-6-21
 */
package cn.poomoo.exam.dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.poomoo.common.util.LogUtil;
import cn.poomoo.exam.medol.ExitVerify;

/**
 * @class InspectDoctorDao
 * @description 出口审核-Dao
 */
public class ExitVerifyDao extends BaseDao {

	public ExitVerifyDao() {
	}
	
	public List<ExitVerify> getList(String sqlString) {
		List<ExitVerify> list = new ArrayList<ExitVerify>();
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			//modified by yjs 2015-10-12
			//pStatement = DBConnection.getInstance().getConnection().prepareStatement(sqlString);
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					ExitVerify doctor = getDataByResultSet(resultSet);
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
	
	public ExitVerify getObj(String sqlString) {
		ExitVerify doctor = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			//modified by yjs 2015-10-12
			//pStatement = DBConnection.getInstance().getConnection().prepareStatement(sqlString);
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				doctor = getDataByResultSet(resultSet);
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
	
	public Map<String, String> verify(String sql, int ID) {
		Map<String, String> map = new HashMap<String, String>();
		
		LogUtil.getInstance().getLogger().info("sql：" + sql + ", params: " + ID);
		CallableStatement callStatement = null;
		try {
			connection.setAutoCommit(false); // 开启手动提交
			
			callStatement = connection.prepareCall(sql);
			callStatement.registerOutParameter(1, java.sql.Types.INTEGER);
			callStatement.registerOutParameter(2, java.sql.Types.INTEGER);
			callStatement.registerOutParameter(3, java.sql.Types.INTEGER);
			callStatement.registerOutParameter(4, java.sql.Types.INTEGER);
			callStatement.registerOutParameter(5, java.sql.Types.INTEGER);
			callStatement.registerOutParameter(6, java.sql.Types.INTEGER);
			callStatement.registerOutParameter(7, java.sql.Types.INTEGER);
			callStatement.setInt(8, ID);
			
			callStatement.execute();
			map.put("result", String.valueOf(callStatement.getInt(1)));
			map.put("station_1", String.valueOf(callStatement.getInt(2)));
			map.put("station_2", String.valueOf(callStatement.getInt(3)));
			map.put("station_3", String.valueOf(callStatement.getInt(4)));
			map.put("station_4", String.valueOf(callStatement.getInt(5)));
			map.put("station_5", String.valueOf(callStatement.getInt(6)));
			map.put("station_6", String.valueOf(callStatement.getInt(7)));
			
			connection.commit(); // 提交
			connection.setAutoCommit(true); // 关闭手动提交
		} catch (Exception e) {
			e.printStackTrace(); 
			LogUtil.getInstance().getLogger().error("执行sql语句失败：" + sql);
			try {
				connection.rollback(); // 错误回滚
				connection.setAutoCommit(true); // 关闭手动提交
			} catch (SQLException e1) {
				e1.printStackTrace();
				LogUtil.getInstance().getLogger().error("数据库错误回滚/关闭手动提交失败！");
			} 
		} finally {
			try {
				if (callStatement != null) {
					callStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				LogUtil.getInstance().getLogger().error("数据库错误回滚/关闭callStatement失败！");
			}
		}
		return map;
	}
	
	public ExitVerify getDataByResultSet(ResultSet resultSet) {
		ExitVerify doctor = new ExitVerify();
		try {
			doctor.setId(resultSet.getInt("id"));
			doctor.setName(resultSet.getString("name"));
			doctor.setSex(resultSet.getString("sex"));
			doctor.setNation(resultSet.getString("nation"));
			doctor.setBirthday(resultSet.getString("birthday"));
			doctor.setCard(resultSet.getString("card"));
			doctor.setKsh(resultSet.getString("ksh"));
			doctor.setExamType(resultSet.getInt("exam_type"));
			doctor.setSerialNumber(resultSet.getString("serial_number"));
			doctor.setInsertDt(resultSet.getTimestamp("insert_dt"));
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("从resultSet取值失败......");
		}
		return doctor;
	}
	
}
