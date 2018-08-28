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
import cn.poomoo.exam.medol.Doctor;

/**
 * @className DoctorDao
 * @description 医生信息Dao
 * @author YuanJingshan
 */
public class DoctorDao extends BaseDao {
	
	public DoctorDao() {
		
	}

	public List<Doctor> getList(String sqlString) {
		List<Doctor> list = new ArrayList<Doctor>();
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					Doctor doctor = getUserByResultSet(resultSet);
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
	
	public Doctor getObj(String sqlString) {
		Doctor doctor = null;
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
	
	public Doctor getUserByResultSet(ResultSet resultSet) {
		Doctor doctor = new Doctor();
		try {
			doctor.setId(resultSet.getInt("id"));
			doctor.setName(resultSet.getString("name"));
			doctor.setSex(resultSet.getString("sex"));
			doctor.setNation(resultSet.getString("nation"));
			doctor.setBirthday(resultSet.getString("birthday"));
			doctor.setCard(resultSet.getString("card"));
			doctor.setKsh(resultSet.getString("ksh"));
			doctor.setExamType(resultSet.getInt("exam_type"));
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("从resultSet取值失败......");
		}
		return doctor;
	}
}
