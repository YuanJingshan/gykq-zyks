/**
 * @fileName DoctorService.java
 * @author YuanJingshan
 * @date 2015-6-12
 */
package cn.poomoo.exam.service;

import java.util.List;

import cn.poomoo.exam.medol.Doctor;

/**
 * @className DoctorService
 * @description 医生信息服务-接口
 * @author YuanJingshan
 */
public interface DoctorService {

	/**
	 * 查询医生总数
	 * @return String
	 */
	int queryCount();

	/**
	 * 根据页码来查询页面数据
	 * @param pageNum
	 * @param pageSize
	 * @return List<Doctor>
	 */
	List<Doctor> queryPageDate(int pageNum, int pageSize);

	/**
	 * 删除医生信息
	 * @param idStr
	 * @return int
	 */
	int deleteDoctor(String idStr);

	/**
	 * 根据条件查询
	 * @param condition
	 * @return List<Doctor>
	 */
	List<Doctor> queryDateByCondition(String condition);

	/**
	 * 查询缺考人员总数
	 * @return String
	 */
	int queryNotCount();

	/**
	 * 查询缺考人员数据-根据页面参数
	 * @param pageNum
	 * @param pageSize
	 * @return List<Doctor>
	 */
	List<Doctor> queryPageNotDate(int pageNum, int pageSize);

	/**
	 * 查询缺考人员数据-根据输入的条件
	 * @param condition
	 * @return List<Doctor>
	 */
	List<Doctor> queryDateNotByCondition(String condition);

	/**
	 * 查询考生信息-根据条件
	 * @param condition
	 * @return int
	 */
	int queryCountByCondition(String condition);

	/**
	 * 查询页面考生信息-根据条件和页面参数
	 * @param condition
	 * @param pageNum
	 * @param pageSize
	 * @return List<Doctor>
	 */
	List<Doctor> queryPageDateByCondition(String condition, int pageNum, int pageSize);

	/**
	 * 查询缺考考生信息-根据条件
	 * @param condition
	 * @return int
	 */
	int queryCountNotByCondition(String condition);

	/**
	 * 查询页面缺考考生信息-根据条件和页面参数
	 * @param condition
	 * @param pageNum
	 * @param pageSize
	 * @return List<Doctor>
	 */
	List<Doctor> queryPageDateNotByCondition(String condition, int pageNum, int pageSize);

	/**
	 * 插入医生信息-根据传入的字符串信息
	 * @param strExcel
	 * @return int
	 */
	int insertDoctorByStr(String strExcel);

	/**
	 * 查询异常考生总数
	 * @return String
	 */
	int queryErrorCount();

	/**
	 * 查询异常考生信息-根据页面参数
	 * @param pageNum
	 * @param pageSize
	 * @return List<Doctor>
	 */
	List<Doctor> queryPageErrorDate(int pageNum, int pageSize);

	/**
	 * 更新异常考生成绩
	 * @param parseInt
	 * @return int
	 */
	int updateExamScore(int doctorId);

}
