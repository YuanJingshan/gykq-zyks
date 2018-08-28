/**
 * @file ExitVerifyServiceImpl.java
 * @author yuanjingshan
 * @date 2015-6-24
 */
package cn.poomoo.exam.serviceImpl;

import java.util.List;
import java.util.Map;

import cn.poomoo.exam.dao.ExitVerifyDao;
import cn.poomoo.exam.medol.ExitVerify;
import cn.poomoo.exam.service.ExitVerifyService;

/**
 * @class ExitVerifyServiceImpl
 * @description 出口审核-实现
 */
public class ExitVerifyServiceImpl implements ExitVerifyService {
	//
	private ExitVerifyDao exitVerifyDao = new ExitVerifyDao();

	public ExitVerifyServiceImpl() {
	}

	public ExitVerify queryExitVerifyDoctorByCard(String card) {
		String sqlString = "select * from v_exit_verify where card='" + card + "'";
		return exitVerifyDao.getObj(sqlString);
	}

	public Map<String, String> exitVerifyInfo(int ID) {
		String sql = "call pr_exit_verify(?,?,?,?,?,?,?,?)";
		return exitVerifyDao.verify(sql, ID);
	}

	public ExitVerify queryExitVerifyDoctorById(int id) {
		String sqlString = "select * from v_exit_verify where id='" + id + "'";
		return exitVerifyDao.getObj(sqlString);
	}

	public List<ExitVerify> queryExitVerifyIsOver() {
		//modified by yjs at 2016-06-26 from flag=1 to flag=2
		String sqlString = "select * from v_exit_verify where flag=1";
		return exitVerifyDao.getList(sqlString);
	}
	
	//modified by yjs at 2016-06-26 from byte to int
	public int queryExitVerifyCountByFlag(int flag) {
		String sqlString = "select count(*) from v_exit_verify where flag=" + flag;
		return exitVerifyDao.executeCountSql(sqlString);
	}

	//added by yjs at 2016-06-26 begin
	/*public int exitVerifyInspect(Map<String, String> map) {
		String sqlString = "call pr_exit_inspect(?,?)";
		return exitVerifyDao.executePro(sqlString, map);
	}*/
	//added by yjs at 2016-06-26 end
}
