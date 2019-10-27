package com.sys.service.Impl.ioImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.sys.dao.io.CaseDao;
import com.sys.entity.Case;
import com.sys.entity.CaseCriminal;
import com.sys.entity.CasePoliceman;
import com.sys.entity.CaseVictim;
import com.sys.entity.CaseWitness;
import com.sys.entity.Infoheader;
import com.sys.entity.PoliceMan;
import com.sys.service.io.CaseService;
@Service("caseService")
public class CaseServiceImpl implements CaseService {
	@Autowired
	@Qualifier("caseDao")
	private CaseDao caseDao;
	@Override
	public List<Infoheader> getEntryPerson(String policeStation) {
		
		return caseDao.getEntryPerson(policeStation);
	}

	@Override
	public List<PoliceMan> getpoliceman(String policeStation) {
		return caseDao.getpoliceman(policeStation);
	}

	@Override
	public void saveCase(Case Case) {
		caseDao.saveCase(Case);
		
	}

	@Override
	public void saveCaseCriminal(List<CaseCriminal> caseCriminal) {
		for(CaseCriminal cc:caseCriminal){
			caseDao.saveCaseCriminal(cc);
		}
		
	}

	@Override
	public void saveCaseWitness(List<CaseWitness> caseWitness) {
		for(CaseWitness cw:caseWitness){
			caseDao.saveCaseWitness(cw);
		}
		
	}

	@Override
	public void saveCaseVictim(List<CaseVictim> caseVictim) {
		for(CaseVictim cv:caseVictim){
			caseDao.saveCaseVictim(cv);
		}
		
	}

	@Override
	public void saveCasePoliceman(List<CasePoliceman> casePoliceman) {
		for(CasePoliceman cp:casePoliceman){
			caseDao.saveCasePoliceman(cp);
		}
		
	}

	@Override
	public List<Case> findCaseBycondition(Map caseFilter ,int intPage,int intSize) {
		PageHelper.startPage(intPage, intSize);//分页
		return caseDao.findCaseBycondition(caseFilter);
	}
	@Override
	public Case findCaseByID(int id) {
		return caseDao.findCaseByID(id);
	}

	@Override
	public int getCaseNumberBycondition(Map caseFilter) {
		
		return caseDao.getCaseNumberBycondition(caseFilter);
	}
	@Transactional
	@Override
	public void deleteCaseByid(String[] ids) {
		caseDao.deleteCasePoliceByid(ids);
		caseDao.deleteCaseVictimByid(ids);
		caseDao.deleteCaseWitnessByid(ids);
		caseDao.deleteCaseCriminalByid(ids);
		caseDao.deleteCaseByid(ids);
		
	}

	@Override
	public void modifyCase(Case Case) {
		caseDao.modifyCase(Case);
		String [] ids={String.valueOf(Case.getID())};
		caseDao.deleteCasePoliceByid(ids);
		caseDao.deleteCaseVictimByid(ids);
		caseDao.deleteCaseWitnessByid(ids);
		caseDao.deleteCaseCriminalByid(ids);
		
	}

	

}
