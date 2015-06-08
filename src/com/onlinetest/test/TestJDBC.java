package com.onlinetest.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.onlinetest.util.MyDBCUtils;

public class TestJDBC {

	@Test
	public void test() throws SQLException{
		
		Connection connection = MyDBCUtils.getConnection();
		PreparedStatement ps = connection.prepareStatement("select * from user");
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			
			String string = rs.getString(2);
			System.out.println(string);
		}
	}
}
