package com.onlinetest.service;

import java.util.List;

import com.onlinetest.dao.MessageDao;
import com.onlinetest.domain.Message;
import com.onlinetest.factory.MyFactory;

public class MessageServiceImp implements MessageService{

	private MessageDao dao;
	
	public MessageServiceImp(){
		
		dao=MyFactory.getFactory().getInstance(MessageDao.class);
	}
	@Override
	public boolean addMessage(Message message) {
		return dao.addMessage(message);
	}
	@Override
	public List<Message> getMessagesById(String userId) {
		
		return dao.getMessagesbyId(userId);
	}

}
