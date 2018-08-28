/**
 * @file StationDoctorServiceImpl.java
 * @author yuanjingshan
 * @date 2015-6-18
 */
package cn.poomoo.exam.station.service.impl;

import java.util.List;
import java.util.Map;

import cn.poomoo.exam.station.dao.StationInfoDao;
import cn.poomoo.exam.station.model.StationInfo;
import cn.poomoo.exam.station.service.StationInfoService;

/**
 * @class StationDoctorServiceImpl
 * @description 考站考生-服务实现
 */
public class StationInfoServiceImpl implements StationInfoService {
	
	public StationInfoServiceImpl() {
		
	}
	
	private StationInfoDao  stationInfoDAO = new StationInfoDao();
	
	public int exit(Map<String, String> map) {
		// TODO 出站
		String sql = "call pr_station_exit(?,?,?)";
		return stationInfoDAO.executePro(sql, map);
	}

	public List<StationInfo> getByStatus(int flag, int station) {
		// TODO 查询考站考生信息
		String sql = "select * from v_station_info where flag=" + flag + " and station=" + station + " order by insert_dt desc";
		return stationInfoDAO.getList(sql);
	}

	public int updateStatus(int station, int id, int flag) {
		// TODO 更新考站考生状态
		String sql = "update t_station_info set flag=" + flag + " where id=" + id + " and station=" + station;
		return stationInfoDAO.executeSql(sql);
	}

	public StationInfo getByID(int station, int ID) {
		// TODO 查询开始信息
		String sql = "select * from v_station_info where station=" + station + " and id=" + ID;
		return stationInfoDAO.getObj(sql);
	}
	
}