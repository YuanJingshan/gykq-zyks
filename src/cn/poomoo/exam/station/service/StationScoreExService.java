/**
 * @fileName StationScoreService.java
 * @author YuanJingshan
 * @date 2015-6-13
 */
package cn.poomoo.exam.station.service;

import java.util.List;
import java.util.Map;

import cn.poomoo.exam.medol.StationScoreExcel;
import cn.poomoo.exam.station.model.StationScoreEx;

/**
 * @className StationScoreService
 * @description 考站成绩服务-接口
 * @author YuanJingshan
 */
public interface StationScoreExService {
	//添加成绩
	int add(Map<String, String> map);
	//查选考站成绩记录数量
	int getCount(int station);
	//查选考站成绩记录
	List<StationScoreEx> getPageData(int station, int pageNum, int pageSize);
	//查选考站成绩记录数量,根据传入的条件
	int getConutByCon(int station, String condition);
	//查选考站成绩记录数量,根据传入的条件
	List<StationScoreEx> getPageDataByCon(int station, String condition, int pageNum, int pageSize);
	//查选考站成绩及格率
	int getThrou(int station, String condition);
	//删除
	int delete(int station, String idStr);
	//成绩详细
	StationScoreEx getScoreDetail(int station, int id);
	//更新考站成绩
	int update(Map<String, String> map);
	//查询考站成绩
	List<StationScoreExcel> getScore(int station, String condition);
}
