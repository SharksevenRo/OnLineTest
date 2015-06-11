package com.onlinetest.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 学生留言信息表对应的Java bean
 * @author Administrator
 *
 */
public class Message implements Serializable{

	
	private  String messageId;//留言编号
	private String content;	//留言内容
	private String fromUser;//留言者
	private String toUser;//收件者
	private Timestamp time;//留言时间
	
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFromUser() {
		return fromUser;
	}
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Message(String messageId, String content, String fromUser,
			String toUser, Timestamp time) {
		super();
		this.messageId = messageId;
		this.content = content;
		this.fromUser = fromUser;
		this.toUser = toUser;
		this.time = time;
	}
	
	public Message(){}
}
