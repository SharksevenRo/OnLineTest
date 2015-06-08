package com.onlinetest.domain;

import java.io.Serializable;
/**
 * 对应数据库用户表的bean
 * @author Administrator
 *
 */
public class User implements Serializable{
	
	private String userId;
	private String userName;
	private String password;
	private String type;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User(String userId, String userName, String password, String type) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.type = type;
	}
	public User(){}
}
