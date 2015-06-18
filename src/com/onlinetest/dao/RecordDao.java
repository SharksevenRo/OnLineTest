package com.onlinetest.dao;

import com.onlinetest.domain.Record;

public interface RecordDao {

	/**
	 * 添加一条测试记录
	 * @param record
	 */
	void addRecord(Record record);

}
