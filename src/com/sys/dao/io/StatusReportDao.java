package com.sys.dao.io;

import java.util.List;

import com.sys.entity.Infoheader;

public interface StatusReportDao {
	String getNowEntryCriminalNum(String identification);
	
	String getNowLeaveCriminalNum(String identification);
	
	String getEntryCriminalTotal(String identification);
	
	String getEntryNotCriminalTotal(String identification);
	
	String getLeaveCriminalTotal(String identification);
	
	String getLawCaselTotal(String policeStation);
	
	Infoheader getNowSafetyCheckPerson(String policeStation);
	
	Infoheader getNowInforCollectionPerson(String policeStation);
	
	Infoheader getNowInquiryPerson(String policeStation);
	
	Infoheader getNowInterrogatePerson(String policeStation);
	
	List<Integer> getHouAskPeronNum(String policeStation);
}
