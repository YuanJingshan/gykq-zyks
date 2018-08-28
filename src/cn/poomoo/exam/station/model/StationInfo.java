/**
 * @fileName StationDoctor.java
 * @author YuanJingshan
 * @date 2018-04-11 新增
 */
package cn.poomoo.exam.station.model;

import java.util.Date;

/**
 * @className StationDoctor
 * @description 考站医生信息
 * @author YuanJingshan
 */
public class StationInfo {
	// id
	private int id;
	// 姓名
	private String name;
	// 性别
	private String sex;
	// 民族
	private String nation;
	// 出生日期
	private String birthday;
	// 身份证号
	private String card;
	// 准考证号
	private String ksh;
	// 报考类别
	private int examType;
	// 一站题组号 
	private String topic;
	// 序号
	private String serialNumber;
	// --检录标志 0:检录 1：入站 2：考完
	private byte flag;
	// 考组
	private String examGroup;
	//考站1-6考站
	private int station;
	// 信息写入时间
	private Date insertDt;
	
	public StationInfo() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getKsh() {
		return ksh;
	}

	public void setKsh(String ksh) {
		this.ksh = ksh;
	}

	public int getExamType() {
		return examType;
	}

	public void setExamType(int examType) {
		this.examType = examType;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getExamGroup() {
		return examGroup;
	}

	public void setExamGroup(String examGroup) {
		this.examGroup = examGroup;
	}

	public byte getFlag() {
		return flag;
	}

	public void setFlag(byte flag) {
		this.flag = flag;
	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

	public Date getInsertDt() {
		return insertDt;
	}

	public void setInsertDt(Date insertDt) {
		this.insertDt = insertDt;
	}
}
