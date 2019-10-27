package com.sys.service.Impl.ioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.io.ActivityRecordDao;
import com.sys.entity.ActivityRecord;
import com.sys.service.io.ActivityRecordService;
@Service("activityRecordService")
public class ActivityRecordServiceImpl implements ActivityRecordService {
	@Autowired
	@Qualifier("activityRecordDao")
	private ActivityRecordDao activityRecordDao;
	
	@Override
	public void saveActivityrecord(List<ActivityRecord> activityRecord) {
		for(ActivityRecord e:activityRecord){
			activityRecordDao.saveActivityrecord(e);
		}
	}

}
