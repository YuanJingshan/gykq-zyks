/**
 * @fileName StationScore.java
 * @author YuanJingshan
 * @date 2015-6-5
 */
package cn.poomoo.exam.medol;

import java.util.Date;

/**
 * @className StationScore
 * @description 考站成绩
 * @author YuanJingshan
 */
public class StationScore {
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
	// 
	private float count_1;
	//
	private float topic_1_1;
	//
	private float topic_1_2;
	//
	private float topic_1_3;
	//
	private float topic_1_4;
	//
	private float topic_1_5;
	//
	private float topic_1_6;
	//
	private float topic_1_7;
	//
	private float topic_1_8;
	//
	private float count_2;
	//
	private float topic_2_1;
	//
	private float topic_2_2;
	//
	private float topic_2_3;
	//
	private float topic_2_4;
	//
	private float topic_2_5;
	//
	private float topic_2_6;
	//
	private float topic_2_7;
	//
	private float topic_2_8;
	//
	private float count_3;
	//
	private float topic_3_1;
	//
	private float topic_3_2;
	//
	private float topic_3_3;
	//
	private float topic_3_4;
	//
	private float topic_3_5;
	//
	private float topic_3_6;
	//
	private float topic_3_7;
	//
	private float topic_3_8;
	//
	private float count_4;
	//
	private float topic_4_1;
	//
	private float topic_4_2;
	//
	private float topic_4_3;
	//
	private float topic_4_4;
	//
	private float topic_4_5;
	//
	private float topic_4_6;
	//
	private float topic_4_7;
	//
	private float topic_4_8;
	//
	private float count_5;
	//
	private float topic_5_1;
	//
	private float topic_5_2;
	//
	private float topic_5_3;
	//
	private float topic_5_4;
	//
	private float topic_5_5;
	//
	private float topic_5_6;
	//
	private float topic_5_7;
	//
	private float topic_5_8;
	//
	private float count_6;
	//
	private float topic_6_1;
	//
	private float topic_6_2;
	//
	private float topic_6_3;
	//
	private float topic_6_4;
	//
	private float topic_6_5;
	//
	private float topic_6_6;
	//
	private float topic_6_7;
	//
	private float topic_6_8;
	// 进站时间
	private Date entryDt;
	// 信息写入时间
	private Date insertDt;
	
	public StationScore() {
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

	public float getCount_1() {
		return count_1;
	}

	public void setCount_1(float count_1) {
		this.count_1 = count_1;
	}

	public float getTopic_1_1() {
		return topic_1_1;
	}

	public void setTopic_1_1(float topic_1_1) {
		this.topic_1_1 = topic_1_1;
	}

	public float getTopic_1_2() {
		return topic_1_2;
	}

	public void setTopic_1_2(float topic_1_2) {
		this.topic_1_2 = topic_1_2;
	}

	public float getTopic_1_3() {
		return topic_1_3;
	}

	public void setTopic_1_3(float topic_1_3) {
		this.topic_1_3 = topic_1_3;
	}

	public float getTopic_1_4() {
		return topic_1_4;
	}

	public void setTopic_1_4(float topic_1_4) {
		this.topic_1_4 = topic_1_4;
	}

	public float getTopic_1_5() {
		return topic_1_5;
	}

	public void setTopic_1_5(float topic_1_5) {
		this.topic_1_5 = topic_1_5;
	}

	public float getTopic_1_6() {
		return topic_1_6;
	}

	public void setTopic_1_6(float topic_1_6) {
		this.topic_1_6 = topic_1_6;
	}

	public float getTopic_1_7() {
		return topic_1_7;
	}

	public void setTopic_1_7(float topic_1_7) {
		this.topic_1_7 = topic_1_7;
	}

	public float getTopic_1_8() {
		return topic_1_8;
	}

	public void setTopic_1_8(float topic_1_8) {
		this.topic_1_8 = topic_1_8;
	}

	public float getCount_2() {
		return count_2;
	}

	public void setCount_2(float count_2) {
		this.count_2 = count_2;
	}

	public float getTopic_2_1() {
		return topic_2_1;
	}

	public void setTopic_2_1(float topic_2_1) {
		this.topic_2_1 = topic_2_1;
	}

	public float getTopic_2_2() {
		return topic_2_2;
	}

	public void setTopic_2_2(float topic_2_2) {
		this.topic_2_2 = topic_2_2;
	}

	public float getTopic_2_3() {
		return topic_2_3;
	}

	public void setTopic_2_3(float topic_2_3) {
		this.topic_2_3 = topic_2_3;
	}

	public float getTopic_2_4() {
		return topic_2_4;
	}

	public void setTopic_2_4(float topic_2_4) {
		this.topic_2_4 = topic_2_4;
	}

	public float getTopic_2_5() {
		return topic_2_5;
	}

	public void setTopic_2_5(float topic_2_5) {
		this.topic_2_5 = topic_2_5;
	}

	public float getTopic_2_6() {
		return topic_2_6;
	}

	public void setTopic_2_6(float topic_2_6) {
		this.topic_2_6 = topic_2_6;
	}

	public float getTopic_2_7() {
		return topic_2_7;
	}

	public void setTopic_2_7(float topic_2_7) {
		this.topic_2_7 = topic_2_7;
	}

	public float getTopic_2_8() {
		return topic_2_8;
	}

	public void setTopic_2_8(float topic_2_8) {
		this.topic_2_8 = topic_2_8;
	}

	public float getCount_3() {
		return count_3;
	}

	public void setCount_3(float count_3) {
		this.count_3 = count_3;
	}

	public float getTopic_3_1() {
		return topic_3_1;
	}

	public void setTopic_3_1(float topic_3_1) {
		this.topic_3_1 = topic_3_1;
	}

	public float getTopic_3_2() {
		return topic_3_2;
	}

	public void setTopic_3_2(float topic_3_2) {
		this.topic_3_2 = topic_3_2;
	}

	public float getTopic_3_3() {
		return topic_3_3;
	}

	public void setTopic_3_3(float topic_3_3) {
		this.topic_3_3 = topic_3_3;
	}

	public float getTopic_3_4() {
		return topic_3_4;
	}

	public void setTopic_3_4(float topic_3_4) {
		this.topic_3_4 = topic_3_4;
	}

	public float getTopic_3_5() {
		return topic_3_5;
	}

	public void setTopic_3_5(float topic_3_5) {
		this.topic_3_5 = topic_3_5;
	}

	public float getTopic_3_6() {
		return topic_3_6;
	}

	public void setTopic_3_6(float topic_3_6) {
		this.topic_3_6 = topic_3_6;
	}

	public float getTopic_3_7() {
		return topic_3_7;
	}

	public void setTopic_3_7(float topic_3_7) {
		this.topic_3_7 = topic_3_7;
	}

	public float getTopic_3_8() {
		return topic_3_8;
	}

	public void setTopic_3_8(float topic_3_8) {
		this.topic_3_8 = topic_3_8;
	}

	public float getCount_4() {
		return count_4;
	}

	public void setCount_4(float count_4) {
		this.count_4 = count_4;
	}

	public float getTopic_4_1() {
		return topic_4_1;
	}

	public void setTopic_4_1(float topic_4_1) {
		this.topic_4_1 = topic_4_1;
	}

	public float getTopic_4_2() {
		return topic_4_2;
	}

	public void setTopic_4_2(float topic_4_2) {
		this.topic_4_2 = topic_4_2;
	}

	public float getTopic_4_3() {
		return topic_4_3;
	}

	public void setTopic_4_3(float topic_4_3) {
		this.topic_4_3 = topic_4_3;
	}

	public float getTopic_4_4() {
		return topic_4_4;
	}

	public void setTopic_4_4(float topic_4_4) {
		this.topic_4_4 = topic_4_4;
	}

	public float getTopic_4_5() {
		return topic_4_5;
	}

	public void setTopic_4_5(float topic_4_5) {
		this.topic_4_5 = topic_4_5;
	}

	public float getTopic_4_6() {
		return topic_4_6;
	}

	public void setTopic_4_6(float topic_4_6) {
		this.topic_4_6 = topic_4_6;
	}

	public float getTopic_4_7() {
		return topic_4_7;
	}

	public void setTopic_4_7(float topic_4_7) {
		this.topic_4_7 = topic_4_7;
	}

	public float getTopic_4_8() {
		return topic_4_8;
	}

	public void setTopic_4_8(float topic_4_8) {
		this.topic_4_8 = topic_4_8;
	}

	public float getCount_5() {
		return count_5;
	}

	public void setCount_5(float count_5) {
		this.count_5 = count_5;
	}

	public float getTopic_5_1() {
		return topic_5_1;
	}

	public void setTopic_5_1(float topic_5_1) {
		this.topic_5_1 = topic_5_1;
	}

	public float getTopic_5_2() {
		return topic_5_2;
	}

	public void setTopic_5_2(float topic_5_2) {
		this.topic_5_2 = topic_5_2;
	}

	public float getTopic_5_3() {
		return topic_5_3;
	}

	public void setTopic_5_3(float topic_5_3) {
		this.topic_5_3 = topic_5_3;
	}

	public float getTopic_5_4() {
		return topic_5_4;
	}

	public void setTopic_5_4(float topic_5_4) {
		this.topic_5_4 = topic_5_4;
	}

	public float getTopic_5_5() {
		return topic_5_5;
	}

	public void setTopic_5_5(float topic_5_5) {
		this.topic_5_5 = topic_5_5;
	}

	public float getTopic_5_6() {
		return topic_5_6;
	}

	public void setTopic_5_6(float topic_5_6) {
		this.topic_5_6 = topic_5_6;
	}

	public float getTopic_5_7() {
		return topic_5_7;
	}

	public void setTopic_5_7(float topic_5_7) {
		this.topic_5_7 = topic_5_7;
	}

	public float getTopic_5_8() {
		return topic_5_8;
	}

	public void setTopic_5_8(float topic_5_8) {
		this.topic_5_8 = topic_5_8;
	}

	public float getCount_6() {
		return count_6;
	}

	public void setCount_6(float count_6) {
		this.count_6 = count_6;
	}

	public float getTopic_6_1() {
		return topic_6_1;
	}

	public void setTopic_6_1(float topic_6_1) {
		this.topic_6_1 = topic_6_1;
	}

	public float getTopic_6_2() {
		return topic_6_2;
	}

	public void setTopic_6_2(float topic_6_2) {
		this.topic_6_2 = topic_6_2;
	}

	public float getTopic_6_3() {
		return topic_6_3;
	}

	public void setTopic_6_3(float topic_6_3) {
		this.topic_6_3 = topic_6_3;
	}

	public float getTopic_6_4() {
		return topic_6_4;
	}

	public void setTopic_6_4(float topic_6_4) {
		this.topic_6_4 = topic_6_4;
	}

	public float getTopic_6_5() {
		return topic_6_5;
	}

	public void setTopic_6_5(float topic_6_5) {
		this.topic_6_5 = topic_6_5;
	}

	public float getTopic_6_6() {
		return topic_6_6;
	}

	public void setTopic_6_6(float topic_6_6) {
		this.topic_6_6 = topic_6_6;
	}

	public float getTopic_6_7() {
		return topic_6_7;
	}

	public void setTopic_6_7(float topic_6_7) {
		this.topic_6_7 = topic_6_7;
	}

	public float getTopic_6_8() {
		return topic_6_8;
	}

	public void setTopic_6_8(float topic_6_8) {
		this.topic_6_8 = topic_6_8;
	}
	
}