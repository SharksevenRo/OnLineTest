package com.onlinetest.service;

import com.onlinetest.domain.Question;

public interface QuestionService {

	/**
	 * 老师出题目
	 * @param question
	 * @return
	 */
	boolean addQuestion(Question question);

}
