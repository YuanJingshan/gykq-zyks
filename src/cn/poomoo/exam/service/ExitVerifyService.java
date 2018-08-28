/**
 * @file ExitVerifyService.java
 * @author yuanjingshan
 * @date 2015-6-24
 */
package cn.poomoo.exam.service;

import java.util.List;
import java.util.Map;

import cn.poomoo.exam.medol.ExitVerify;

/**
 * @class ExitVerifyService
 * @description 出口审核-接口
 */
public interface ExitVerifyService {

	/**
	 * 出口审核：根据身份证信息查询考生信息
	 * @param card
	 * @return ExitVerify
	 */
	ExitVerify queryExitVerifyDoctorByCard(String card);

	/**
	 * 出口审核：出口检录信息
	 * @param map
	 * @return int
	 */
	Map<String, String> exitVerifyInfo(int ID);

	/**
	 * 出口审核：根据id信息查询考生信息
	 * @param parseInt
	 * @return ExitVerify
	 */
	ExitVerify queryExitVerifyDoctorById(int id);

	/**
	 * 出口审核：查询已经审核的考生信息
	 * @return List<ExitVerify>
	 */
	List<ExitVerify> queryExitVerifyIsOver();

	/**
	 * 出口审核：根据flag来查询总数
	 * @param flag
	 * @return int
	 */
	//modified by yjs at 2016-06-26 from byte to int
	int queryExitVerifyCountByFlag(int flag);

	//added by yjs at 2016-06-25 begin
	/**
	 * 出口审核检录
	 * @param map
	 * @return
	 */
	//int exitVerifyInspect(Map<String, String> map);
	//added by yjs at 2016-06-25 end

}
