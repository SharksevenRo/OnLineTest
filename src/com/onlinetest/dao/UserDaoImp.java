package com.onlinetest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.onlinetest.domain.User;
import com.onlinetest.util.MyDBCUtils;
import com.onlinetest.util.ParamsUtil;

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
			ps=ParamsUtil.injectParams(ps, user);
			int count=ps.executeUpdate();
			
			//根据受影响的行数返回布尔值
			return count>0;
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyDBCUtils.close(ps, conn);
		}
		return false;
	}
	@Override
	public boolean isExit(User user) {
		
		boolean isExit = false;
		try{
			conn = MyDBCUtils.getConnection();
			ps=conn.prepareStatement("select * from user where userId=?");
			//设置参数
			ps.setString(1, user.getUserId());
			rs = ps.executeQuery();
			
			//打包结果集的数据，获取存有所有结果对象的集合
			List<User> users = ParamsUtil.setParams(rs, user);
			
			isExit=users.size()>0;
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			MyDBCUtils.close(ps, conn);
			return isExit;
		}
		
	}
	@Override
	public User login(User user) {
		
		try {
			
			conn = MyDBCUtils.getConnection();
			ps=conn.prepareStatement("select * from user where userId=? and password=?");
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getPassword());
			
			rs=ps.executeQuery();
			//打包结果集的数据，获取存有所有结果对象的集合
			List<User> users = ParamsUtil.setParams(rs, user);
			
			return users.get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyDBCUtils.close(ps, conn);
		}
		return null;
	}

}
