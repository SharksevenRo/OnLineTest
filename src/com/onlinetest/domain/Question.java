package com.onlinetest.domain;

import java.io.Serializable;

/**
 * 数据库Question表对应的Java bean
 * @author Administrator
 *
 */
public class Question implements Serializable{

	
	private String questionId;//题目编号
	private String userId;	//出题老师编号
	private String content;  //题目内容
	private String type;  //题目类型
	private String answer; //答案
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	public String getQuestionId() {
		return questionId;
	}
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Question(String questionId, String userId, String content,
			String type, String answer) {
		super();
		this.questionId = questionId;
		this.userId = userId;
		this.content = content;
		this.type = type;
		this.answer = answer;
	}
	public Question(){}
}
