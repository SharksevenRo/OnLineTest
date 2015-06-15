package com.onlinetest.handler;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.onlinetest.domain.User;
import com.onlinetest.factory.MyFactory;
import com.onlinetest.service.UserService;

/**
 * 管与用户的请求的控制器
 * 
 * @author Administrator
 * 
 */

@Controller
@SessionAttributes(value = "user")
public class UserProcess {

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
		UserService service = MyFactory.getFactory().getInstance(UserService.class);

		dist = "index";

		if (service.isExit(user)) {

			map.put("msg", "该账号已被注册");
			dist = "register1";

		} else {
			if (service.add(user)) {
				map.put("user", user);
			} else {
				dist = "error";
			}
		}
		return dist;
	}

	public String login(User user, Map<String, Object> map) {
		
		UserService service = MyFactory.getFactory().getInstance(UserService.class);
		user=service.login(user);
		
		if(user!=null){
			
			dist="index";
			map.put("user", user);
		}else{
			dist="error";
		}
		return dist;
	}

}
