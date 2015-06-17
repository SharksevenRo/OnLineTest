package com.onlinetest.service;

import java.util.List;

import com.onlinetest.domain.Question;

public interface QuestionService {

	/**
	 * 老师出题目
	 * @param question
	 * @return
	 */
	boolean addQuestion(Question question);

	/**
	 * 获取当前登录的老师的所有的出题信息
	 * @param userId
	 * @return
	 */
	List<Question> getQuestionsByUserId(String userId);

}
