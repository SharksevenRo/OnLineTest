package com.onlinetest.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.onlinetest.domain.Question;
import com.onlinetest.domain.Record;
import com.onlinetest.domain.User;
import com.onlinetest.factory.MyFactory;
import com.onlinetest.service.QuestionService;
import com.onlinetest.service.RecordService;
import com.onlinetest.util.TimeStringUtils;

@SessionAttributes(value="questions")
@Controller
public class TestController {

	private String dist;
	private QuestionService qService;
	private RecordService rService;
	
	@RequestMapping("/test")
	public String getQuestions(@RequestParam(value="teacherId") String userId,Map<String, Object> map){
		
		qService=MyFactory.getFactory().getInstance(QuestionService.class);
		
		List<Question> questions=qService.getQuestionsByUserId(userId);
		
		if(questions!=null&&questions.size()>0){
			
			map.put("questions", questions);
			
			dist="testPage";
		}
		return dist;
	}
	
	@RequestMapping("/submitTest")
	public String getScore(HttpServletRequest request,HttpSession session,Map<String,Object> map){
		
		float score=0;
		
		List<Question> questions = (List<Question>) session.getAttribute("questions");
		double step=((double)100)/questions.size();
		for (Question question : questions) {
			
			String userAnswer = request.getParameter(question.getQuestionId());
			if(userAnswer.contains(question.getAnswer())){
				score+=step;
			}
		}
		User user =(User) session.getAttribute("user");
		String  userId=user.getUserId();
		String recordId=TimeStringUtils.getTimeString();
		
		
		Record record=new Record(recordId, userId, String.valueOf(score).substring(0,4), new Timestamp(System.currentTimeMillis()));
		
		rService=MyFactory.getFactory().getInstance(RecordService.class);
		rService.addRecord(record);
		map.put("score", score+"");
		map.put("teacherId", questions.get(0).getUserId());
		dist="scorePage";
		return dist;
	}
}
