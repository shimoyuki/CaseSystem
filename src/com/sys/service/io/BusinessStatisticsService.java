package com.sys.service.io;

import java.util.List;

import com.sys.entity.CaseStatistics;
import com.sys.entity.SuspectStatistics;

public interface BusinessStatisticsService {
	//根据警员ID查询出，作为干警和组长的案件（案件类型和对应的数量）
	List<CaseStatistics> getCaseAndNum(int id);
	//根据警员ID查询出，（入区原因和对应的数量）
	List<SuspectStatistics> getSuspectAndNum(String code);

}
