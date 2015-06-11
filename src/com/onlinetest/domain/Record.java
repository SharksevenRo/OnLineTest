package com.onlinetest.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 数据库答题记录表对应的
 * @author Administrator
 *
 */
public class Record implements Serializable{

	private String recordId; //记录编号
	private String userId;	//答题学生编号
	private String questionId; //题目编号
	private String score;	//测试成绩
	
	public Record(String recordId, String userId, String questionId,
			String score, Timestamp time) {
		super();
		this.recordId = recordId;
		this.userId = userId;
		this.questionId = questionId;
		this.score = score;
		this.time = time;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}

	private Timestamp time; // 答题时间
	
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Record(){}
}
