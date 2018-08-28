/**
 * @fileName StationScore.java
 * @author YuanJingshan
 * @date 2015-6-5
 */
package cn.poomoo.exam.medol;

import java.util.Date;

/**
 * @className StationScore
 * @description 考站成绩 - excel
 * @author YuanJingshan
 */
public class StationScoreExcel {
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
	private String topic;
	// 成绩
	private float score;
	// 进站时间
	private Date entryDt;
	// 信息写入时间
	private Date insertDt;
	
	public StationScoreExcel() {
	}

	public StationScoreExcel(int id, String name, String sex, String nation,
			String birthday, String card, String ksh, int examType,
			String topic, float score, Date entryDt, Date insertDt) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.nation = nation;
		this.birthday = birthday;
		this.card = card;
		this.ksh = ksh;
		this.examType = examType;
		this.topic = topic;
		this.score = score;
		this.entryDt = entryDt;
		this.insertDt = insertDt;
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

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
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

	public int getExamType() {
		return examType;
	}

	public void setExamType(int examType) {
		this.examType = examType;
	}
	
}