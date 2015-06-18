package com.onlinetest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.onlinetest.domain.Record;
import com.onlinetest.util.MyDBCUtils;
import com.onlinetest.util.ParamsUtil;

public class RecordDaoImp implements RecordDao{

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public void addRecord(Record record) {
		
		try {
			
			conn=MyDBCUtils.getConnection();
			ps=conn.prepareStatement("insert into Record values(?,?,?,?)");
			ps=ParamsUtil.injectParams(ps, record);
			
			ps.executeUpdate();
		} catch (Exception e) {

			e.printStackTrace();
		}finally{
			
			MyDBCUtils.close(ps, conn);
		}
	}

}
