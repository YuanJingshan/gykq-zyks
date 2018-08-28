/**
 * @fileName Admin.java
 * @author YuanJingshan
 * @date 2014-12-2
 */
package cn.poomoo.exam.medol;

import java.util.Date;

/**
 * @className Admin
 * @description 网站后台用户
 * @author YuanJingshan
 */
public class User {

	// 用户id
	private int id;
	// 用户名
	private String userName;
	// 真实姓名
	private String realName;
	// 密码
	private String password;
	// 电话
	private String tel;
	// 地址
	private String address;
	// 权限 1：普通管理员 2：超级管理员
	private byte authority;
	// 增加时间
	private Date insertDt;
	
	public User() {
		
	}

	public User(int id, String userName, String realName, String password,
			String tel, String address, byte authority, Date insertDt) {
		super();
		this.id = id;
		this.userName = userName;
		this.realName = realName;
		this.password = password;
		this.tel = tel;
		this.address = address;
		this.authority = authority;
		this.insertDt = insertDt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getRealName() {
		return realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public byte getAuthority() {
		return authority;
	}

	public void setAuthority(byte authority) {
		this.authority = authority;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getInsertDt() {
		return insertDt;
	}

	public void setInsertDt(Date insertDt) {
		this.insertDt = insertDt;
	}
	
}
