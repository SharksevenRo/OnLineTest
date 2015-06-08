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
	
	@RequestMapping("/register1")//用注解设置处理请求的url
	public String register1(){
		
		System.out.println("login");
		return "register";
	}
	public String login(){
		
		System.out.println("login");
		return "login";
	}
	
	/**
	 * 用户注册
	 * @param request
	 * @return
	 */
	@RequestMapping("/register2")//用注解设置处理请求的url
	public ModelAndView register2(HttpServletRequest request){
		
		//实例化业务服务对象
		service=MyFactory.getFactory().getInstance(UserService.class);
		
		//获取表单参数
		String userId=request.getParameter("userId");
		String userName=request.getParameter("userName");
		String type=request.getParameter("type");
		String password=request.getParameter("password");
		
		User user=new User(userId, userName, password, type);
		ModelAndView model;
		
		if(service.add(user)){
			
			model=new ModelAndView();
			request.getSession().setAttribute("user", user);
			model.setViewName("index");
		}else{
			model=new ModelAndView();
			model.setViewName("error");
			model.addObject("errorMsg", "注册失败");
		}
		
		return model;
	}

}
