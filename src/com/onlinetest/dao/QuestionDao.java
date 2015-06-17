package com.onlinetest.dao;

import java.util.List;

import com.onlinetest.domain.Question;

public interface QuestionDao {

	/**
	 * 向数据库插入一条题目的数据
	 * @param question
	 * @return
	 */
	boolean add(Question question);

	/**
	 * 根据出题人的编号查询题目记录
	 * @param userId 
	 * @return
	 */
	List<Question> getQuestionsByUserId(String userId);

}
