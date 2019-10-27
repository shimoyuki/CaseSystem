package com.sys.service.Impl.emImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.em.LockerDao;
import com.sys.entity.Locker;
import com.sys.service.em.LockerService;
@Service("lockerService")
public class LockerServiceImpl implements LockerService{
	@Autowired
	@Qualifier("lockerDao")
	private LockerDao lockerDao;
	@Override
	public void addLocker(Locker locker) {
		lockerDao.addLocker(locker);
		
	}
	@Override
	public void updateLocker(Locker locker) {
		lockerDao.updateLocker(locker);
		
	}
	@Override
	public void deleteLocker(Locker locker) {
		lockerDao.deleteLocker(locker);
		
	}

}
