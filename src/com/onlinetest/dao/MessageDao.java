package com.onlinetest.dao;

import java.util.List;

import com.onlinetest.domain.Message;

public interface MessageDao {

	/**
	 * 向数据库添加留言记录
	 * @param message 
	 * @return
	 */
	boolean addMessage(Message message);

	/**
	 * 通过用户id查找留言记录
	 * @param userId
	 * @return
	 */
	List<Message> getMessagesbyId(String userId);

}
