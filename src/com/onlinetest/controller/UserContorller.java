package com.onlinetest.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.onlinetest.domain.Message;
import com.onlinetest.domain.User;
import com.onlinetest.factory.MyFactory;
import com.onlinetest.service.MessageService;
import com.onlinetest.service.UserService;

/**
 * 管与用户的请求的控制器
 * 
 * @author Administrator
 * 
 */

@Controller
@SessionAttributes(value = {"user","users","messages"})
public class UserContorller {

	private String dist;

	/**
	 * 从主页到注册的跳转
	 * 
	 * @return
	 */
	@RequestMapping("/register1")
	// 用注解设置处理请求的url
	public String register1() {

		System.out.println("login");
		return "register";
	}

	/**
	 * 从主页到登录页面的跳转
	 * 
	 * @return
	 */
	@RequestMapping("/loginPage")
	public String login() {

		System.out.println("login");
		return "login";
	}

	/**
	 * 用户注册
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("/register2")
	// 用注解设置处理请求的url
	public String register2(User user, Map<String, Object> map) {

		// 实例化业务服务对象
		UserService service = MyFactory.getFactory().getInstance(
				UserService.class);

		dist = "index";

		if (service.isExit(user)) {

			map.put("msg", "该账号已被注册");
			dist = "register1";

		} else {
			if (service.add(user)) {

				if (user.getType().endsWith("学生")) {

					List<User> teachers = service.getUsersByType(user);
					map.put("users", teachers);
				}
				map.put("user", user);
			} else {
				dist = "error";
			}
		}
		return dist;
	}

	/**
	 * 用户登录校验
	 * 
	 * @param user
	 * @param map
	 * @return
	 */
	@RequestMapping("/login")
	public String userLogin(User user, Map<String, Object> map) {

		UserService service = MyFactory.getFactory().getInstance(
				UserService.class);
		String userId = user.getUserId();
		user = service.login(user);

		if (user != null) {

			dist = "index";
			map.put("user", user);
			if (user.getType().equals("学生")) {

				List<User> teachers = service.getUsersByType(user);
				map.put("users", teachers);
			}
			if(user.getType().equals("老师")){
				
				MessageService mService=MyFactory.getFactory().getInstance(MessageService.class);
				List<Message> messages=mService.getMessagesById(user.getUserId());
				map.put("messages", messages);
			}
		} else {

			map.put("msg", "密码或账号错误");
			map.put("userId", userId);
			dist = "login";
		}
		return dist;
	}

	/**
	 * 用户注销登录
	 * 
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request,
			HttpServletResponse response) {

		if (request.getSession(false) != null) {
			request.getSession().invalidate();
			try {
				request.getRequestDispatcher("/index.jsp").forward(request,
						response);
				return null;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@RequestMapping("/back")
	public String backMain(){
		
		dist="index";
		return dist;
	}
}
