/**
 * @fileName ExamScore.java
 * @author YuanJingshan
 * @date 2015-6-5
 */
package cn.poomoo.exam.medol;

import java.util.Date;

/**
 * @className ExamScore
 * @description 考试成绩
 * @author YuanJingshan
 */
public class ExamScore {
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
	// 报考职位
	private int examType;
	// 题组号 
	private String serialNumber;
	// 第一考站成绩
	private double score_1;
	// 第二考站信息
	private double score_2;
	// 第三考站信息
	private double score_3;
	// 考试总成绩
	private double score_count;
	// 检录时间
	private Date entryDt;
	// 信息写入时间
	private Date insertDt;
	
	public ExamScore() {
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

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public double getScore_1() {
		return score_1;
	}

	public void setScore_1(double score_1) {
		this.score_1 = score_1;
	}

	public double getScore_2() {
		return score_2;
	}

	public void setScore_2(double score_2) {
		this.score_2 = score_2;
	}

	public double getScore_3() {
		return score_3;
	}

	public void setScore_3(double score_3) {
		this.score_3 = score_3;
	}

	public double getScore_count() {
		return score_count;
	}

	public void setScore_count(double scoreCount) {
		score_count = scoreCount;
	}

	public void setScore_count(int scoreCount) {
		score_count = scoreCount;
	}
	
	public Date getEntryDt() {
		return entryDt;
	}

	public void setEntryDt(Date entryDt) {
		this.entryDt = entryDt;
	}

	public Date getInsertDt() {
		return insertDt;
	}

	public void setInsertDt(Date insertDt) {
		this.insertDt = insertDt;
	}
}