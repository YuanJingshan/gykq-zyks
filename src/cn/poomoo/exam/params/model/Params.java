package cn.poomoo.exam.params.model;

import java.util.Date;

public class Params {
	// id
	private int id;
	// 第一考站及格线
	private float sta1jgx;
	// 第二考站及格线
	private float sta2jgx;
	// 第三考站及格线
	private float sta3jgx;
	// 第一考站及格线
	private float sta4jgx;
	// 第二考站及格线
	private float sta5jgx;
	// 第三考站及格线
	private float sta6jgx;
	// 第一考站题组号总数
	private int topic1;
	// 第二考站题组号总数
	private int topic2;
	// 第三考站题组号总数
	private int topic3;
	// 第一考站题组号总数
	private int topic4;
	// 第二考站题组号总数
	private int topic5;
	// 第三考站题组号总数
	private int topic6;
	// 序号数量
	private int serialNumber;
	// 修改时间
	private Date insertDt;
	
	public Params() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSta1jgx() {
		return sta1jgx;
	}

	public void setSta1jgx(float sta1jgx) {
		this.sta1jgx = sta1jgx;
	}

	public float getSta2jgx() {
		return sta2jgx;
	}

	public void setSta2jgx(float sta2jgx) {
		this.sta2jgx = sta2jgx;
	}

	public float getSta3jgx() {
		return sta3jgx;
	}

	public void setSta3jgx(float sta3jgx) {
		this.sta3jgx = sta3jgx;
	}

	public int getTopic1() {
		return topic1;
	}

	public void setTopic1(int topic1) {
		this.topic1 = topic1;
	}

	public int getTopic2() {
		return topic2;
	}

	public void setTopic2(int topic2) {
		this.topic2 = topic2;
	}

	public int getTopic3() {
		return topic3;
	}

	public void setTopic3(int topic3) {
		this.topic3 = topic3;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public float getSta4jgx() {
		return sta4jgx;
	}

	public void setSta4jgx(float sta4jgx) {
		this.sta4jgx = sta4jgx;
	}

	public float getSta5jgx() {
		return sta5jgx;
	}

	public void setSta5jgx(float sta5jgx) {
		this.sta5jgx = sta5jgx;
	}

	public float getSta6jgx() {
		return sta6jgx;
	}

	public void setSta6jgx(float sta6jgx) {
		this.sta6jgx = sta6jgx;
	}

	public int getTopic4() {
		return topic4;
	}

	public void setTopic4(int topic4) {
		this.topic4 = topic4;
	}

	public int getTopic5() {
		return topic5;
	}

	public void setTopic5(int topic5) {
		this.topic5 = topic5;
	}

	public int getTopic6() {
		return topic6;
	}

	public void setTopic6(int topic6) {
		this.topic6 = topic6;
	}

	public Date getInsertDt() {
		return insertDt;
	}

	public void setInsertDt(Date insertDt) {
		this.insertDt = insertDt;
	}
	
}
