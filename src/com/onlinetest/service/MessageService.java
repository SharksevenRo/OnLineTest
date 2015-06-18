package com.onlinetest.service;

import java.util.List;

import com.onlinetest.domain.Message;

public interface MessageService {

	/**
	 * 学生给老师留言
	 * @param message 
	 * @return
	 */
	boolean addMessage(Message message);

	/**
	 * 通过userId查找留言信息
	 * @param userId
	 * @return
	 */
	List<Message> getMessagesById(String userId);

}
