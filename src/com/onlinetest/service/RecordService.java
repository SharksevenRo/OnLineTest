package com.onlinetest.service;

import com.onlinetest.domain.Record;

public interface RecordService {

	/**
	 * 生成测试记录
	 * @param record
	 */
	void addRecord(Record record);

}
