package com.onlinetest.service;

import com.onlinetest.dao.QuestionDao;
import com.onlinetest.domain.Question;
import com.onlinetest.factory.MyFactory;

public class QuestionServiceImp implements QuestionService{

	private QuestionDao dao;
	
	public QuestionServiceImp(){
		dao=MyFactory.getFactory().getInstance(QuestionDao.class);
	}
	@Override
	public boolean addQuestion(Question question) {
		return dao.add(question);
	}

}
