/**
 * @file StationInfoService.java
 * @author yuanjingshan
 * @date 2018-04-11 新增
 */
package cn.poomoo.exam.station.service;

import java.util.List;
import java.util.Map;

import cn.poomoo.exam.station.model.StationInfo;

/**
 * @class StationInfoService
 * @description 考站考生-服务接口
 */
public interface StationInfoService {
	
	int exit(Map<String, String> map);
	
	List<StationInfo> getByStatus(int flag, int station);
	
	int updateStatus(int station, int id, int flag);
	
	StationInfo getByID(int station, int ID);
	
}
