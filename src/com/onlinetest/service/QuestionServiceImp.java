package com.onlinetest.service;

import java.util.List;

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
	@Override
	public List<Question> getQuestionsByUserId(String userId) {
		return dao.getQuestionsByUserId(userId);
	}

}
