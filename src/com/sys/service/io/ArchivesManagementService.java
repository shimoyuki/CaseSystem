package com.sys.service.io;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.sys.entity.CurrentSuspectsList;
import com.sys.entity.Infoheader;

public interface ArchivesManagementService {
	
	//获取当前在区嫌疑人
	List<Infoheader> getCurrentSuspects(String curentTime);
	//获取当前嫌疑人列表
	List<CurrentSuspectsList> getCurrentSuspectsList(Map<String, Object> recordFilter, int intPage, int number);
	//获取嫌疑人列表总数
	int getCurrentSuspectsTotal(Map<String, Object> recordFilter);
	//根据policeID获取警员编号
	String getCodeByPoliceID(int id);
	//档案报告
	Model showReport(String recordNumber,Model model);

}
