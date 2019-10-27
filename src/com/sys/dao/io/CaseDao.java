package com.sys.dao.io;

import java.util.List;
import java.util.Map;

import com.sys.entity.Case;
import com.sys.entity.CaseCriminal;
import com.sys.entity.CasePoliceman;
import com.sys.entity.CaseVictim;
import com.sys.entity.CaseWitness;
import com.sys.entity.Infoheader;
import com.sys.entity.PoliceMan;

public interface CaseDao {
	List<Infoheader> getEntryPerson(String policeStation);
	
	List<PoliceMan> getpoliceman(String policeStation);
	
	void saveCase(Case Case);
	
	void saveCaseCriminal(CaseCriminal caseCriminal);
	
	void saveCaseWitness(CaseWitness caseWitness);
	
	void saveCaseVictim(CaseVictim caseVictim);
	
	void saveCasePoliceman(CasePoliceman casePoliceman);
	
	List<Case> findCaseBycondition(Map caseFilter);
	
	Case findCaseByID(int id);
	
	int getCaseNumberBycondition(Map caseFilter);
	
	void deleteCasePoliceByid(String[] ids);
	
	void deleteCaseCriminalByid(String[] ids);
	
	void deleteCaseVictimByid(String[] ids);
	
	void deleteCaseWitnessByid(String[] ids);
	
	void deleteCaseByid(String[] ids);
	
	void modifyCase(Case Case);
	
}
