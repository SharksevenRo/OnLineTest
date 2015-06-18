package com.onlinetest.controller;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.onlinetest.domain.Message;
import com.onlinetest.domain.User;
import com.onlinetest.factory.MyFactory;
import com.onlinetest.service.MessageService;
import com.onlinetest.util.TimeStringUtils;

/**
 * 消息控制器
 * @author shark
 *
 */
@Controller
public class MessageController {

	private String dist;
	private MessageService service;
	
	@RequestMapping("/leaveMessage")
	public String addMessage(@RequestParam(value="teacherId") String toUser,@RequestParam(value="content") String content,HttpSession session,Map<String, Object> map){
		
		service=MyFactory.getFactory().getInstance(MessageService.class);
		User user=(User) session.getAttribute("user");
		
		String fromUser=user.getUserName();
		
		Message  message=new Message(TimeStringUtils.getTimeString(), content, fromUser, toUser,new Timestamp(System.currentTimeMillis()));
		if(service.addMessage(message)){
			dist="index";
		}else{
			
			map.put("errorMsg", "留言失败");
			dist="error";
		}
		
		return dist;
	}
}
