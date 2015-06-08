package com.onlinetest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
			//获得数据库连接
			conn = MyDBCUtils.getConnection();
			ps=conn.prepareStatement("insert into user values(?,?,?,?)");
			//设置参数
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getType());
			
			int count=ps.executeUpdate();
			
			//根据受影响的行数返回布尔值
			return count>0;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
