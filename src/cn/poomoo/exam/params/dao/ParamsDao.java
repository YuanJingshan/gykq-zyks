package cn.poomoo.exam.params.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.poomoo.common.util.LogUtil;
import cn.poomoo.exam.dao.BaseDao;
import cn.poomoo.exam.params.model.Params;

public class ParamsDao extends BaseDao {
	public List<Params> getList(String sqlString) {
		List<Params> list = new ArrayList<Params>();
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					Params jgx = getJGXByResultSet(resultSet);
					list.add(jgx);
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
	
	public Params getObj(String sqlString) {
		Params params = null;
		PreparedStatement pStatement = null;
		ResultSet resultSet = null;
		
		try {
			pStatement = connection.prepareStatement(sqlString);
			resultSet = pStatement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				params = getJGXByResultSet(resultSet);
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
		return params;
	}
	
	public Params getJGXByResultSet(ResultSet resultSet) {
		Params params = new Params();
		try {
			params.setId(resultSet.getInt("id"));
			params.setSta1jgx(resultSet.getFloat("sta_1_jg"));
			params.setSta2jgx(resultSet.getFloat("sta_2_jg"));
			params.setSta3jgx(resultSet.getFloat("sta_3_jg"));
			params.setSta4jgx(resultSet.getFloat("sta_4_jg"));
			params.setSta5jgx(resultSet.getFloat("sta_5_jg"));
			params.setSta6jgx(resultSet.getFloat("sta_6_jg"));
			params.setTopic1(resultSet.getInt("topic1"));
			params.setTopic2(resultSet.getInt("topic2"));
			params.setTopic3(resultSet.getInt("topic3"));
			params.setTopic4(resultSet.getInt("topic4"));
			params.setTopic5(resultSet.getInt("topic5"));
			params.setTopic6(resultSet.getInt("topic6"));
			params.setSerialNumber(resultSet.getInt("serial_number"));
			params.setInsertDt(resultSet.getTimestamp("insert_dt"));
		} catch (SQLException e) {
			e.printStackTrace();
			LogUtil.getInstance().getLogger().error("从resultSet取值失败......");
		}
		return params;
	}
}
