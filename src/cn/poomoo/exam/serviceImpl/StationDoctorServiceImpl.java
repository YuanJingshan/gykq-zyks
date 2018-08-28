/**
 * @file StationDoctorServiceImpl.java
 * @author yuanjingshan
 * @date 2015-6-18
 */
package cn.poomoo.exam.serviceImpl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.poomoo.common.util.DateUtil;
import cn.poomoo.exam.dao.InspectDao;
import cn.poomoo.exam.dao.StationDoctorDao;
import cn.poomoo.exam.medol.InspectDoctor;
import cn.poomoo.exam.medol.StationDoctor;
import cn.poomoo.exam.service.StationDoctorService;

/**
 * @class StationDoctorServiceImpl
 * @description 考站考生-服务实现
 */
public class StationDoctorServiceImpl implements StationDoctorService {
	
	//入口检录dao added by yjs at 2016-06-25
	private InspectDao inspectDao = new InspectDao();
	
	//考站考生dao
	private StationDoctorDao stationDoctorDao = new StationDoctorDao();
	
	public StationDoctorServiceImpl() {
	}

	public int insertStation1(Map<String, String> map) {
		String sqlString = "insert into t_station_1(id,flag,topic,insert_dt) values(?,?,?,?)";
		return stationDoctorDao.executeSql(sqlString,map);
	}

	public List<StationDoctor> queryStation1NotEntry() {
		//mdified by yjs at 2016-06-25 from 1 to 0
		String sqlString = "select * from v_station_1 where flag=0 order by insert_dt desc";
		return stationDoctorDao.getList(sqlString);
	}

	public int updateStation1DoctorFlag(int id, int flag) {
		String sqlString = "update t_station_1 set flag=" + flag + " where id=" + id;
		return stationDoctorDao.executeSql(sqlString);
	}

	public List<StationDoctor> queryStation1Entried() {
		//mdified by yjs at 2016-06-25 from 2 to 1
		String sqlString = "select * from v_station_1 where flag=1 order by insert_dt desc";
		return stationDoctorDao.getList(sqlString);
	}

	public StationDoctor queryStation1DoctorById(int id) {
		String sqlString = "select * from v_station_1 where id=" + id;
		return stationDoctorDao.getObj(sqlString);
	}

	public StationDoctor queryStation1DoctorByCardNum(String card) {
		String sqlString = "select * from v_station_1 where card='" + card + "'"; 
		return stationDoctorDao.getObj(sqlString);
	}

	public int queryStation1InspectCount() {
		//mdified by yjs at 2016-06-25 from 1,2,3 to 0,1,2
		String sqlString = "select count(*) from v_station_1 where flag in (0,1,2)"; 
		return stationDoctorDao.executeCountSql(sqlString);
	}

	public List<StationDoctor> queryStation1All() {
		String sqlString = "select * from v_station_1 order by insert_dt desc"; 
		return stationDoctorDao.getList(sqlString);
	}

	public List<StationDoctor> queryStation1Exit() {
		//mdified by yjs at 2016-06-25 from 3 to 2
		String sqlString = "select * from v_station_1 where flag=2 order by insert_dt desc";
		return stationDoctorDao.getList(sqlString);
	}
	
	public List<StationDoctor> getStation1ByStatus(int status) {
		// TODO 根据状态查询考生信息
		String sql = "select * from v_station_1 where flag=" + status + " order by insert_dt desc";
		return stationDoctorDao.getList(sql);
	}

	//modified by yjs at 2016-06-25 from byte to int
	public int queryStation1CountByFlag(int flag) {
		String sqlString = "select count(*) from v_station_1 where flag=" + flag;
		return stationDoctorDao.executeCountSql(sqlString);
	}

	public int station1Exit(Map<String, String> map) {
		String sqlString = "call pr_station1_exit(?,?)";
		return stationDoctorDao.executePro(sqlString, map);
	}

	public StationDoctor queryStation2DoctorByCardNum(String card) {
		String sqlString = "select * from v_station_2 where card='" + card + "'"; 
		return stationDoctorDao.getObj(sqlString);
	}

	public StationDoctor queryStation2DoctorById(int id) {
		String sqlString = "select * from v_station_2 where id=" + id;
		return stationDoctorDao.getObj(sqlString);
	}

	public int updateStation2DoctorFlag(int id, int flag) {
		String sqlString = "update t_station_2 set flag=" + flag + " where id=" + id;
		return stationDoctorDao.executeSql(sqlString);
	}

	public int queryStation2CountByFlag(int flag) {
		String sqlString = "select count(*) from v_station_2 where flag=" + flag;
		return stationDoctorDao.executeCountSql(sqlString);
	}

	public List<StationDoctor> queryStation2NotEntry() {
		//modified by yjs at 2016-06-25 from flag=1 to flag=0
		String sqlString = "select * from v_station_2 where flag=0 order by insert_dt desc";
		return stationDoctorDao.getList(sqlString);
	}

	public List<StationDoctor> queryStation2Entried() {
		//modified by yjs at 2016-06-25 from flag=2 to flag=1
		String sqlString = "select * from v_station_2 where flag=1 order by insert_dt desc";
		return stationDoctorDao.getList(sqlString);
	}

	public List<StationDoctor> queryStation2Exit() {
		//modified by yjs at 2016-06-25 from flag=3 to flag=2
		String sqlString = "select * from v_station_2 where flag=2 order by insert_dt desc";
		return stationDoctorDao.getList(sqlString);
	}
	
	public List<StationDoctor> getStation2ByStatus(int status) {
		// TODO 根据状态查询考生信息
		String sql = "select * from v_station_2 where flag=" + status + " order by insert_dt desc";
		return stationDoctorDao.getList(sql);
	}

	public int station2Exit(Map<String, String> map) {
		String sqlString = "call pr_station2_exit(?,?)";
		return stationDoctorDao.executePro(sqlString, map);
	}

	//deleted by yjs at 2016-06-25 begin
	/*public StationDoctor queryStation3DoctorByCardNum(String card) {
		String sqlString = "select * from v_station_3 where card='" + card + "'"; 
		return stationDoctorDao.getObj(sqlString);
	}*/
	//deleted by yjs at 2016-06-25 end

	public StationDoctor queryStation3DoctorById(int id) {
		String sqlString = "select * from v_station_3 where id=" + id;
		return stationDoctorDao.getObj(sqlString);
	}

	public int queryStation3CountByFlag(int flag) {
		String sqlString = "select count(*) from v_station_3 where flag=" + flag;
		return stationDoctorDao.executeCountSql(sqlString);
	}

	public int updateStation3DoctorFlag(int id, int flag) {
		String sqlString = "update t_station_3 set flag=" + flag + " where id=" + id;
		return stationDoctorDao.executeSql(sqlString);
	}
	
	public List<StationDoctor> queryStation3NotEntry() {
		//modified by yjs at 2016-06-25 from 1 to 0 
		String sqlString = "select * from v_station_3 where flag=0 order by insert_dt desc";
		return stationDoctorDao.getList(sqlString);
	}

	public List<StationDoctor> queryStation3Entried() {
		//modified by yjs at 2016-06-25 from 2 to 1 
		String sqlString = "select * from v_station_3 where flag=1 order by insert_dt desc";
		return stationDoctorDao.getList(sqlString);
	}

	public List<StationDoctor> queryStation3Exit() {
		//modified by yjs at 2016-06-25 from 3 to 2
		String sqlString = "select * from v_station_3 where flag=2 order by insert_dt desc";
		return stationDoctorDao.getList(sqlString);
	}
	
	public List<StationDoctor> getStation3ByStatus(int status) {
		// TODO 根据状态查询考生信息
		String sql = "select * from v_station_3 where flag=" + status + " order by insert_dt desc";
		return stationDoctorDao.getList(sql);
	}

	public int station3Exit(Map<String, String> map) {
		String sqlString = "call pr_station3_exit(?,?)";
		return stationDoctorDao.executePro(sqlString, map);
	}

	public List<StationDoctor> queryStation1NotInspect() {
		//modified by yjs at 2016-06-25 from 1 to 0 
		String sqlString = "select * from v_station_1 where flag=0 order by insert_dt desc";
		return stationDoctorDao.getList(sqlString);
	}

	public List<StationDoctor> queryStation2NotInspect() {
		//modified by yjs at 2016-06-25 from 1 to 0 
		String sqlString = "select * from v_station_2 where flag=0 order by insert_dt desc";
		return stationDoctorDao.getList(sqlString);
	}

	public List<StationDoctor> queryStation3NotInspect() {
		//modified by yjs at 2016-06-25 from 1 to 0 
		String sqlString = "select * from v_station_3 where flag=0 order by insert_dt desc";
		return stationDoctorDao.getList(sqlString);
	}

	//added by yjs at 2016-06-25 begin
	public InspectDoctor queryInspectDoctorByCardNum(String card) {
		String currentYear = DateUtil.dateToString(new Date(), "yyyy");
		String sqlString = "select * from v_inspect vp where vp.card='" + card + "' and vp.insert_dt like '" + currentYear + "%'";
		return inspectDao.getObj(sqlString);
	}
	//added by yjs at 2016-06-25 end
}