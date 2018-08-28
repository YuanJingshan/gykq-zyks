/**
 * @fileName DoctorServiceImpl.java
 * @author YuanJingshan
 * @date 2015-6-12
 */
package cn.poomoo.exam.serviceImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cn.poomoo.exam.dao.DoctorDao;
import cn.poomoo.exam.medol.Doctor;
import cn.poomoo.exam.service.DoctorService;

/**
 * @className DoctorServiceImpl
 * @description 医生信息服务-实现
 * @author YuanJingshan
 */
public class DoctorServiceImpl implements DoctorService {
	
	//
	private DoctorDao doctorDao = new DoctorDao();
	
	public DoctorServiceImpl() {
	}

	public int queryCount() {
		String sqlString = "select count(*) from t_doctor_info";
		return doctorDao.executeCountSql(sqlString);
	}

	public int deleteDoctor(String idStr) {
		String sqlString = "delete from t_doctor_info where id in (" + idStr + ")";
		return doctorDao.executeSql(sqlString);
	}

	public List<Doctor> queryPageDate(int pageNum, int pageSize) {
		String sqlString = "select * from t_doctor_info limit " + (pageNum - 1) * pageSize + ", " + pageSize;
		return doctorDao.getList(sqlString);
	}

	public List<Doctor> queryDateByCondition(String condition) {
		String sqlString = "select * from t_doctor_info where " + condition;
		return doctorDao.getList(sqlString);
	}
	
	public int queryNotCount() {
		String sqlString = "select count(*) from t_doctor_info where id not in (select id from t_doctor_score)";
		return doctorDao.executeCountSql(sqlString);
	}

	public List<Doctor> queryPageNotDate(int pageNum, int pageSize) {
		String sqlString = "select * from t_doctor_info where id not in (select id from t_doctor_score) limit " + (pageNum - 1) * pageSize + ", " + pageSize;
		return doctorDao.getList(sqlString);
	}
	
	public List<Doctor> queryDateNotByCondition(String condition) {
		String sqlString = "select * from t_doctor_info where id not in (select id from t_doctor_score) and " + condition;
		return doctorDao.getList(sqlString);
	}

	public int queryCountByCondition(String condition) {
		String sqlString = "select count(*) from t_doctor_info where " + condition;
		return doctorDao.executeCountSql(sqlString);
	}

	public List<Doctor> queryPageDateByCondition(String condition, int pageNum, int pageSize) {
		String sqlString = "select * from t_doctor_info where " + condition + " limit " + (pageNum - 1) * pageSize + ", " + pageSize;
		return doctorDao.getList(sqlString);
	}

	public int queryCountNotByCondition(String condition) {
		String sqlString = "select count(*) from t_doctor_info where id not in (select id from t_doctor_score) and " + condition;
		return doctorDao.executeCountSql(sqlString);
	}

	public List<Doctor> queryPageDateNotByCondition(String condition, int pageNum, int pageSize) {
		String sqlString = "select * from t_doctor_info where id not in (select id from t_doctor_score) and " + condition + " limit " + (pageNum - 1) * pageSize + ", " + pageSize;
		return doctorDao.getList(sqlString);
	}

	public int insertDoctorByStr(String strExcel) {
			String  sqlString = "insert t_doctor_info(ksh, card, name, exam_area, exam_type, area, unit, graduate_school, graduate_major, graduate_date, education, education_type, assistant_dt, address, sex, birthday, nation, check_result, check_people, check_date, check_not_yy, check_bak, check_area_result, check_area_people, check_area_date, check_area_not_yy, check_area_bak, tel, home_tel, unit_tel) values " + strExcel;
			return doctorDao.executeSql(sqlString);
	}

	public int queryErrorCount() {
		String sqlString = "select count(*) from v_error_doctor";
		return doctorDao.executeCountSql(sqlString);
	}

	public List<Doctor> queryPageErrorDate(int pageNum, int pageSize) {
		String sqlString = "select * from v_error_doctor limit " + (pageNum - 1) * pageSize + ", " + pageSize;
		return doctorDao.getList(sqlString);
	}

	public int updateExamScore(int doctorId) {
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("int_doctorId", doctorId + "");
		String sqlString = "call pr_error_doctor_score(?,?)";
		return doctorDao.executePro(sqlString, map);
	}
	
}