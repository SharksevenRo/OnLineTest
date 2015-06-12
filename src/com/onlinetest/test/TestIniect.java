package com.onlinetest.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.onlinetest.domain.User;
import com.onlinetest.util.MyDBCUtils;
import com.onlinetest.util.ParamsUtil;

public class TestIniect {
	
	@Test
	public void testInject() throws SQLException, Exception{
		
		Connection conn=MyDBCUtils.getConnection();
		User user=new User("123","asd", "sdas", "sdas");
		
		PreparedStatement ps=conn.prepareStatement("insert into user values(?,?,?,?)");
		
		ParamsUtil.injectParams(ps, user);
		System.out.println(ps.execute());
		MyDBCUtils.close(ps, conn);
	}
	
	@Test
	public void testset() throws SQLException, Exception{
		
		Connection conn=MyDBCUtils.getConnection();
		User user=new User();
		
		PreparedStatement ps=conn.prepareStatement("select * from user");
		ResultSet rs = ps.executeQuery();
		List<User> list = ParamsUtil.setParams(rs, new User());
		MyDBCUtils.close(ps, conn);
	}

}
