package com.onlinetest.dao;

import com.onlinetest.domain.Question;

public interface QuestionDao {

	/**
	 * 向数据库插入一条题目的数据
	 * @param question
	 * @return
	 */
	boolean add(Question question);

}
