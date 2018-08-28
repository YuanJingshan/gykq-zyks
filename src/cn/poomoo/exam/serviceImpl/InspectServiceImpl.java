/**
 * @file InspectServiceImpl.java
 * @author yuanjingshan
 * @date 2015-6-21
 */
package cn.poomoo.exam.serviceImpl;

import java.util.List;
import java.util.Map;

import cn.poomoo.exam.dao.InspectDao;
import cn.poomoo.exam.medol.InspectDoctor;
import cn.poomoo.exam.service.InspectService;

/**
 * @class InspectServiceImpl
 * @description 检录-实现
 */
public class InspectServiceImpl implements InspectService {
	
	//
	private InspectDao inspectDao = new InspectDao();
	
	public InspectServiceImpl() {
	}

	public InspectDoctor queryInspectById(int id) {
		String sqlString = "select * from v_inspect where id=" + id;
		return inspectDao.getObj(sqlString);
	}

	public int insertInspect(Map<String, String> map) {
		String sqlString = "insert into t_inspect value(?,?,?,?,?,?,?,?,?,?)";
		return inspectDao.executeSql(sqlString, map);
	}

	public int queryInspectCount() {
		String sqlString = "select count(*) from v_inspect";
		return inspectDao.executeCountSql(sqlString);
	}

	public List<InspectDoctor> queryInspectNotEntry() {
		String sqlString = "select * from v_inspect where flag=0 order by insert_dt desc";
		return inspectDao.getList(sqlString);
	}

	public List<InspectDoctor> queryInspectEntring() {
		String sqlString = "select * from v_inspect where flag=1 order by insert_dt desc";
		return inspectDao.getList(sqlString);
	}
	
	public List<InspectDoctor> queryInspectEntried() {
		//mofified by yjs at 2016-06-25 feom (2,3) to (1,2)
		String sqlString = "select * from v_inspect where flag in (1,2) order by insert_dt desc";
		return inspectDao.getList(sqlString);
	}

	public List<InspectDoctor> queryInspectAll() {
		String sqlString = "select * from v_inspect";
		return inspectDao.getList(sqlString);
	}

	//mofified by yjs at 2016-06-25 feom byte to int
	public int updateInspectFlagById(int id, int i) {
		String sqlString = "update t_inspect set flag=" + i + " where id=" + id;
		return inspectDao.executeSql(sqlString);
	}

	public int queryEntriedCount() {
		//mofified by yjs at 2016-06-25 feom (2,3) to (1,2)
		String sqlString = "select count(*) from v_inspect where flag in (1,2)";
		return inspectDao.executeCountSql(sqlString);
	}

	public int station1Inspect(Map<String, String> map) {
		String sqlString = "call pr_station1_inspect(?,?)";
		return inspectDao.executePro(sqlString, map);
	}
 
	//mofified by yjs at 2016-06-25 feom byte to int
	public int queryInspectCountByFlag(int flag) {
		String sqlString = "select count(*) from v_inspect where flag=" + flag;
		return inspectDao.executeCountSql(sqlString);
	}

	public int queryInspectTopicCount(String topic) {
		String sqlString = "select count(*) from v_inspect where topic='" + topic + "'";
		return inspectDao.executeCountSql(sqlString);
	}

	//added by yjs at 2016-06-25 begin
	public int station3Inspect(Map<String, String> map) {
		String sqlString = "call pr_station3_inspect(?,?)";
		return inspectDao.executePro(sqlString, map);
	}

	public int station2Inspect(Map<String, String> map) {
		String sqlString = "call pr_station2_inspect(?,?)";
		return inspectDao.executePro(sqlString, map);
	}
	//added by yjs at 2016-06-25 end

	public int stationInspect(Map<String, String> map) {
		String sql = "call pr_station_inspect(?,?,?)";
		return inspectDao.executePro(sql, map);
	}
}
