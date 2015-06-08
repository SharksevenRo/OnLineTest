package com.onlinetest.dao;

import java.sql.Connection;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;
import com.onlinetest.domain.User;
import com.onlinetest.util.MyDBCUtils;

/**
 * 用户数据库操作实现类
 * @author Administrator
 *
 */
public class UserDaoImp  implements UserDao{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public boolean add(User user) {
		try {
			conn = MyDBCUtils.getConnection();
			String sql="insert into user values(?,?,?,?)";
		} catch (Exception e) {
			
		}
		return false;
	}

}
