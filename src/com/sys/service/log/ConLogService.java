package com.sys.service.log;

import com.sys.entity.ConLog;

public interface ConLogService {
	
	int deleteConLog(String id);
	
	int insert(ConLog record);
	
	int insertTest(ConLog record);
	
	ConLog selectConLog(String id);
	
	int updateConLog(ConLog record);

}
