package com.sys.service.Impl.ioImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.io.FinallyLeaveDao;
import com.sys.entity.FinallyLeave;
import com.sys.service.io.FinallyLeaveService;
@Service("finallyLeaveService")
public class FinallyLeaveServiceImpl implements FinallyLeaveService {
	@Autowired
	@Qualifier("finallyLeaveDao")
	private FinallyLeaveDao finallyLeaveDao;
	
	
	@Override
	public void saveFinallyLeave(FinallyLeave finallyLeave) {
		finallyLeaveDao.saveFinallyLeave(finallyLeave);
	}
	
}
