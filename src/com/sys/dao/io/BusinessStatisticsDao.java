package com.sys.dao.io;

import java.util.List;

import com.sys.entity.CaseStatistics;
import com.sys.entity.SuspectStatistics;

public interface BusinessStatisticsDao {

	List<CaseStatistics> getCaseAndNum(int id);

	List<SuspectStatistics> getSuspectAndNum(String code);

}
