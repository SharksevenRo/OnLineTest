package com.onlinetest.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.onlinetest.domain.User;
import com.onlinetest.factory.MyFactory;
import com.onlinetest.service.UserService;

/**
 * 管与用户的请求的控制器
 * @author Administrator
 *
 */
@Controller
public class UserProcess {
	
	private UserService service;
	@RequestMapping("/login")
	public String login(){
		
		System.out.println("login");
		return "login";
	}
	
	/**
	 * 用户注册
	 * @param request
	 * @return
	 */
	@RequestMapping("/register")
	public ModelAndView register(HttpServletRequest request){
		
		//实例化业务服务对象
		service=MyFactory.getFactory().getInstance(UserService.class);
		
		//获取表单参数
		String userId=request.getParameter("userId");
		String userName=request.getParameter("userName");
		String type=request.getParameter("type");
		String password=request.getParameter("password");
		
		User user=new User(userId, userName, password, type);
		
		service.add(user);
		
		return null;
	}

}
