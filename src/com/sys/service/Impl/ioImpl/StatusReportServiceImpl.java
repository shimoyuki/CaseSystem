package com.sys.service.Impl.ioImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.io.StatusReportDao;
import com.sys.service.io.StatusResportService;
@Service("statusResportService")
public class StatusReportServiceImpl implements StatusResportService {
	@Autowired
	@Qualifier("statusReportDao")
	private StatusReportDao statusReportDao;

	@Override
	public Map<String, Object> getStatisticsNumber(String policeStation, String identification) {
		Map<String, Object> statisticsMap=new HashMap<String, Object>();
		statisticsMap.put("NECN", statusReportDao.getNowEntryCriminalNum(identification));//今日入区嫌疑人
		statisticsMap.put("ENCT", statusReportDao.getEntryNotCriminalTotal(identification));//今日入区非嫌疑人
		statisticsMap.put("NLCN", statusReportDao.getNowLeaveCriminalNum(identification));//今日离区嫌疑人
		statisticsMap.put("ECT", statusReportDao.getEntryCriminalTotal(identification));//历史入区嫌疑人
		statisticsMap.put("caseTotal", statusReportDao.getLawCaselTotal(policeStation));//历史案件数
		int district=Integer.parseInt(statusReportDao.getEntryCriminalTotal(identification))-Integer.parseInt(statusReportDao.getLeaveCriminalTotal(identification));
		statisticsMap.put("district", String.valueOf(district));//在区人数
		
		statisticsMap.put("safetyCheck", statusReportDao.getNowSafetyCheckPerson(policeStation));//人数安全检查室
		statisticsMap.put("inforCollection", statusReportDao.getNowInforCollectionPerson(policeStation));//信息采集室室
		statisticsMap.put("inquiry", statusReportDao.getNowInquiryPerson(policeStation));//询问室
		statisticsMap.put("interrogate", statusReportDao.getNowInterrogatePerson(policeStation));//迅问室
		List<Integer> personNum=statusReportDao.getHouAskPeronNum(policeStation);
		for(int i=0;i<personNum.size();i++){
			statisticsMap.put("interrogate"+(i+1), String.valueOf(personNum.get(i)));//迅问室
		}
		
		
		return statisticsMap;
	}
}
