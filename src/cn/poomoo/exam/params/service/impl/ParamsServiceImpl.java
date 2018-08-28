package cn.poomoo.exam.params.service.impl;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.poomoo.exam.params.dao.ParamsDao;
import cn.poomoo.exam.params.model.Params;
import cn.poomoo.exam.params.service.ParamsService;

public class ParamsServiceImpl implements ParamsService {
	
	private ParamsDao stationJgxDao = new ParamsDao();
	
	public ParamsServiceImpl() {
	}

	public Params queryParams() {
		String sql = "select * from t_station_jgx limit 0, 1";
		return stationJgxDao.getObj(sql);
	}

	public int updateParams(Map<String, String> map) {
		String sql = "update t_station_jgx set sta_1_jg=?,sta_2_jg=?,sta_3_jg=?, sta_4_jg=?, sta_5_jg=?, sta_6_jg=?, " +
				"topic1=?, topic2=?, topic3=?, topic4=?, topic5=?, topic6=?, serial_number=? where id=?"; 
		return stationJgxDao.executeSql(sql, map);
	}
	
	public int sysInit() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		String sqlString = "call pr_sys_init(?)";
		return stationJgxDao.executePro(sqlString, map);
	}

}
