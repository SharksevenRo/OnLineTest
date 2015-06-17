package com.onlinetest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.OPTIONS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.onlinetest.domain.Question;
import com.onlinetest.domain.User;
import com.onlinetest.factory.MyFactory;
import com.onlinetest.service.QuestionService;
import com.onlinetest.util.TimeStringUtils;

@Controller
public class QuestionController {
	
	private String dist;
	private QuestionService service;
	
	@RequestMapping("/addQuestion")
	public String question_add(){
		
		dist="addQuestion";
		return dist;
	}
	
	/**
	 * 添加题目 因为有拼接参数，所以自己获取参数
	 * @return
	 */
	@RequestMapping("question_add")
	public String add(HttpServletRequest request,HttpServletResponse respose){
		
		service=MyFactory.getFactory().getInstance(QuestionService.class);
		
		//组织和获取题目的信息
		String content=request.getParameter("content");
		String answer=request.getParameter("answer");
		//获取出题老师的信息
		User user=(User)request.getSession().getAttribute("user");
		String userId=user.getUserId();
		//从表单获取题目的选项
		String[] lebels = request.getParameterValues("optionLabel");
		String[] values = request.getParameterValues("optionValue");
		String options="";
		
		//拼接选项。将所有的选项拼成一个字符串
		for(int i=0;i<lebels.length;i++){
			options+=lebels[i]+":"+values[i]+",";
		}
		options=options.substring(0, options.length()-1);
		
		//因为只涉及选择题，所以直接默认选择题
		String type="选择题";
		//根据出题的时间设置题目编号
		String questionId=TimeStringUtils.getTimeString();
		
		Question question=new Question(questionId, userId, content, type, answer, options);
		//添加新的题目
		if(service.addQuestion(question)){
			
		}
		if(request.getParameter("complete").endsWith("true")){
			dist="index";
		}else{
			dist="addQuestion";
		}
		return dist;
	}

}
