package com.onlinetest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinetest.domain.Question;
import com.onlinetest.factory.MyFactory;
import com.onlinetest.service.QuestionService;

@Controller
public class TestController {

	private String dist;
	private QuestionService qService;
	
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
}
