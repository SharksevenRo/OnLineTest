package com.onlinetest.service;

import com.onlinetest.domain.User;

/**
 * 用户业务服务接口
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * 向系统添加一个用户
	 * @param user 要添加的用户对象
	 * @return
	 */
	boolean add(User user);

}
