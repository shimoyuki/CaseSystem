package com.sys.dao.em;

import com.sys.entity.Locker;

public interface LockerDao {
	void addLocker(Locker locker);
	
	void updateLocker(Locker locker);
	
	void deleteLocker(Locker locker);
}
