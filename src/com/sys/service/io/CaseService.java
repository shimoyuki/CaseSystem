package com.sys.service.io;

import java.util.List;
import java.util.Map;

import com.sys.entity.Case;
import com.sys.entity.CaseCriminal;
import com.sys.entity.CasePoliceman;
import com.sys.entity.CaseVictim;
import com.sys.entity.CaseWitness;
import com.sys.entity.Infoheader;
import com.sys.entity.PoliceMan;

public interface CaseService {
	List<Infoheader> getEntryPerson(String policeStation);
	
	List<PoliceMan> getpoliceman(String policeStation);
	
	void saveCase(Case Case);
	
	void saveCaseCriminal(List<CaseCriminal>caseCriminal);
	
	void saveCaseWitness(List<CaseWitness> caseWitness);
	
	void saveCaseVictim(List<CaseVictim> caseVictim);
	
	void saveCasePoliceman(List<CasePoliceman> casePoliceman);
	
	List<Case> findCaseBycondition(Map caseFilter,int intPage,int intSize);
	
	Case findCaseByID(int id);
	
	int getCaseNumberBycondition(Map caseFilter);
	
	void deleteCaseByid(String[] ids);
	
	void modifyCase(Case Case);
}
