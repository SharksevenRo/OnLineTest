package com.onlinetest.dao;

import com.onlinetest.domain.User;

/**
 * 用户数据库操作接口
 * @author Administrator
 *
 */
public interface UserDao {

	/**
	 * 向数据库插入一条用户数据
	 * @param user 保存用户数据的user对象
	 * @return
	 */
	boolean add(User user);

	/**
	 * 查询是否存在该用户编号的记录
	 * @param user
	 * @return
	 */
	boolean isExit(User user);

	/**
	 * 根据的用户信息校验用户，即查询数据库
	 * @param user
	 * @return
	 */
	boolean login(User user);

}
