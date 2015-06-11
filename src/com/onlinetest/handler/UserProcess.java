package com.onlinetest.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
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
@SessionAttributes(value="user")
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
	public String register2(User user,Map<String, Object> map){
		
		
		//实例化业务服务对象
		service=MyFactory.getFactory().getInstance(UserService.class);
		
		
		String dist="index";
		
		if(service.add(user)){
			
			map.put("user", user);
		}else{
			dist="error";
		}
		
		return dist;
	}

}
