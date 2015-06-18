package com.onlinetest.service;

import com.onlinetest.dao.RecordDao;
import com.onlinetest.domain.Record;
import com.onlinetest.factory.MyFactory;

public class RecordServiceImp implements RecordService {

	private RecordDao dao;
	
	public RecordServiceImp(){
		dao=MyFactory.getFactory().getInstance(RecordDao.class);
	}
	@Override
	public void addRecord(Record record) {
		dao.addRecord(record);
	}

}
