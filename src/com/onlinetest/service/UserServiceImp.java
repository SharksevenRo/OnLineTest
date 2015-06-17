package com.onlinetest.service;

import java.util.List;

import com.onlinetest.dao.UserDao;
import com.onlinetest.domain.User;
import com.onlinetest.factory.MyFactory;

/**
 * 用户服务实现类
 * @author Administrator
 *
 */
public class UserServiceImp implements UserService{
	
	private UserDao dao;
	
	public UserServiceImp(){
		
		dao=MyFactory.getFactory().getInstance(UserDao.class);
	}
	@Override
	public boolean add(User user) {
		
		//调用数据库操作对象向数据库插入用户信息
		return dao.add(user);
	}
	@Override
	public boolean isExit(User user) {
		
		return dao.isExit(user);
	}
	@Override
	public User login(User user) {
		
		return dao.login(user);
	}
	@Override
	public List<User> getUsersByType(User user) {

		return dao.getUsersByType(user);
	}

}
