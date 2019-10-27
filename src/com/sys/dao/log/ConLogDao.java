package com.sys.dao.log;

import com.sys.entity.ConLog;

public interface ConLogDao {
	
	int deleteByPrimaryKey(String id);
	 
	int insert(ConLog record);
	
	int insertSelective(ConLog record);
	
	ConLog selectByPrimaryKey(String id);
	 
	int updateByPrimaryKeySelective(ConLog record);
	
	int updateByPrimaryKey(ConLog record);

}
