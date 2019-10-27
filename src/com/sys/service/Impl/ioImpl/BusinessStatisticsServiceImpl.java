package com.sys.service.Impl.ioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.io.BusinessStatisticsDao;
import com.sys.entity.CaseStatistics;
import com.sys.entity.SuspectStatistics;
import com.sys.service.io.BusinessStatisticsService;
@Service("businessStatisticsService")
public class BusinessStatisticsServiceImpl implements BusinessStatisticsService {
	
	@Autowired
	@Qualifier("businessStatisticsDao")
	private BusinessStatisticsDao businessStatisticsDao;

	@Override
	public List<CaseStatistics>  getCaseAndNum(int id) {
	    return businessStatisticsDao.getCaseAndNum(id);
	}

	@Override
	public List<SuspectStatistics> getSuspectAndNum(String code) {
		// TODO Auto-generated method stub
		return businessStatisticsDao.getSuspectAndNum(code);
	}
}
