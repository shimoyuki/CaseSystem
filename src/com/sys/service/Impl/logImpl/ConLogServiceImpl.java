package com.sys.service.Impl.logImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.log.ConLogDao;
import com.sys.entity.ConLog;
import com.sys.service.log.ConLogService;

@Service("conLogService")
public class ConLogServiceImpl implements ConLogService {
	
	
	@Autowired
	@Qualifier("conLogDao")
	private ConLogDao conLogDao;

	@Override
	public int deleteConLog(String id) {
		// TODO Auto-generated method stub
		return conLogDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ConLog record) {
		// TODO Auto-generated method stub
		return conLogDao.insertSelective(record);
	}
	@Override
	public int insertTest(ConLog record) {
		// TODO Auto-generated method stub
		return conLogDao.insert(record);
	}

	@Override
	public ConLog selectConLog(String id) {
		// TODO Auto-generated method stub
		return conLogDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateConLog(ConLog record) {
		// TODO Auto-generated method stub
		return conLogDao.updateByPrimaryKeySelective(record);
	}

}
