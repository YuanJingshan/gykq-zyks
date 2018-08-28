/**
 * @file InspectDoctor.java
 * @author yuanjingshan
 * @date 2015-6-21
 */
package cn.poomoo.exam.medol;

import java.util.Date;

/**
 * @class InspectDoctor
 * @description 入口检录
 */
//@Table(t_inspect)
public class InspectDoctor {
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
	private String topic1;
	// 二站题组号 
	private String topic2;
	// 三站题组号 
	private String topic3;
	// 四站题组号 
	private String topic4;
	// 五站题组号 
	private String topic5;
	// 六站题组号 
	private String topic6;
	// 序号
	private String serialNumber;
	// --检录标志 0:检录  1：入站/进入考站考试  2：考完/进入考站（针对入口检录）
	private byte flag;
	// 信息写入时间
	private Date insertDt;
	
	public InspectDoctor() {
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

	public String getTopic1() {
		return topic1;
	}

	public void setTopic1(String topic1) {
		this.topic1 = topic1;
	}

	public String getTopic2() {
		return topic2;
	}

	public void setTopic2(String topic2) {
		this.topic2 = topic2;
	}

	public String getTopic3() {
		return topic3;
	}

	public void setTopic3(String topic3) {
		this.topic3 = topic3;
	}
	
	public String getTopic4() {
		return topic4;
	}

	public void setTopic4(String topic4) {
		this.topic4 = topic4;
	}

	public String getTopic5() {
		return topic5;
	}

	public void setTopic5(String topic5) {
		this.topic5 = topic5;
	}

	public String getTopic6() {
		return topic6;
	}

	public void setTopic6(String topic6) {
		this.topic6 = topic6;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public byte getFlag() {
		return flag;
	}

	public void setFlag(byte flag) {
		this.flag = flag;
	}

	public Date getInsertDt() {
		return insertDt;
	}

	public void setInsertDt(Date insertDt) {
		this.insertDt = insertDt;
	}
}
