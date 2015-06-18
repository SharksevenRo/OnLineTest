package com.onlinetest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.onlinetest.domain.Message;
import com.onlinetest.util.MyDBCUtils;
import com.onlinetest.util.ParamsUtil;

public class MessageDaoImp implements MessageDao{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public boolean addMessage(Message message) {
		
		boolean isSuccess=false;
		try {
			
			conn=MyDBCUtils.getConnection();
			ps=conn.prepareStatement("insert into Message values(?,?,?,?,?)");
			
			ps=ParamsUtil.injectParams(ps, message);
			int count = ps.executeUpdate();
			isSuccess=count>0;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			MyDBCUtils.close(ps, conn);
		}
		return isSuccess;
	}

	@Override
	public List<Message> getMessagesbyId(String userId) {
		
		List<Message> messages=null;
		try {
			conn=MyDBCUtils.getConnection();
			ps=conn.prepareStatement("select * from message where toUser=?");
			ps.setString(1, userId);
			
			rs=ps.executeQuery();
			
			messages = ParamsUtil.setParams(rs, new Message());
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			MyDBCUtils.close(ps, conn);
		}
		return messages;
	}

}
