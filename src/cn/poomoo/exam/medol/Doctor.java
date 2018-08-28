/**
 * @fileName Doctor.java
 * @author YuanJingshan
 * @date 2015-6-5
 */
package cn.poomoo.exam.medol;

/**
 * @className Doctor
 * @description 考试医生信息
 * @author YuanJingshan
 */
public class Doctor {
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
	
	public Doctor() {
	}

	public Doctor(int id, String name, String sex, String nation,
			String birthday, String card, String ksh, int examType) {
		super();
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.nation = nation;
		this.birthday = birthday;
		this.card = card;
		this.ksh = ksh;
		this.examType = examType;
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
}
