package com.onlinetest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.onlinetest.domain.Question;
import com.onlinetest.util.MyDBCUtils;
import com.onlinetest.util.ParamsUtil;

public class QuestionDaoImp implements QuestionDao{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public boolean add(Question question) {
		
		boolean isSuccess=false;
		try {
			
			conn=MyDBCUtils.getConnection();
			ps=conn.prepareStatement("insert into Question values(?,?,?,?,?,?)");
			ParamsUtil.injectParams(ps, question);
			
			int count = ps.executeUpdate();
			isSuccess=count>0;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	@Override
	public List<Question> getQuestionsByUserId(String userId) {
		
		List<Question> questions = null;
		try {
			conn=MyDBCUtils.getConnection();
			ps=conn.prepareStatement("select * from question where userId=?");
			ps.setString(1,userId);
			
			rs=ps.executeQuery();
			questions = ParamsUtil.setParams(rs, new Question());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return questions;
	}

}
