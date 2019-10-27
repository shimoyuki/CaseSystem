package com.sys.service.Impl.ioImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sys.dao.io.SafetyCheckDao;
import com.sys.entity.CheckGoods;
import com.sys.entity.EntryDutypolice;
import com.sys.entity.EntryPolicemen;
import com.sys.entity.Goodsinspect_dutypolice;
import com.sys.entity.Goodsinspect_party;
import com.sys.entity.Goodsinspect_police;
import com.sys.entity.IdentityCard;
import com.sys.entity.PersonScrutiny;
import com.sys.entity.ScarDetail;
import com.sys.entity.ScarInspectParty;
import com.sys.entity.ScarInspectPolice;
import com.sys.service.io.SafetyCheckService;
@Service("safetyCheckservice")
public class SafetyCheckServiceImpl implements SafetyCheckService{
	
	@Autowired
	@Qualifier("safetyCheckDao")
	private SafetyCheckDao safetyCheckDao;


	@Override
	public void saveSafetyCheckInfo(PersonScrutiny personScrutiny) {
		safetyCheckDao.saveSafetyCheckInfo(personScrutiny);
	}

	@Override
	public void saveHisBelongings(CheckGoods checkGoods) {
		safetyCheckDao.saveHisBelongings(checkGoods);
		
	}

	@Override
	public void saveScarTreatment(ScarDetail scarDetail) {
			safetyCheckDao.saveScarTreatment(scarDetail);
	}

	@Override
	public List<ScarDetail> getScarExplainList(String recordNumber, int intPage, int number) {
		PageHelper.startPage(intPage, number);
		return safetyCheckDao.getScarExplainList(recordNumber);
	}

	@Override
	public int getScarExplainTotal(String recordNumber) {
		return safetyCheckDao.getScarExplainTotal(recordNumber);
	}

	@Override
	public List<CheckGoods> getGoodsList(String recordNumber, int intPage, int number) {
		PageHelper.startPage(intPage, number);
		return safetyCheckDao.getGoodsList(recordNumber);
	}

	@Override
	public int getGoodsTotal(String recordNumber) {
		return safetyCheckDao.getGoodsTotal(recordNumber);
	}

	@Override
	public void savePolicemenSignature(List<ScarInspectPolice> tpList) {
		for (ScarInspectPolice scarInspectPolice2 : tpList) {
			safetyCheckDao.savePolicemenSignature(scarInspectPolice2);
		}
	}

	@Override
	public void saveReviewedSignature(ScarInspectParty scarInspectParty) {
		safetyCheckDao.saveReviewedSignature(scarInspectParty);
		
	}

	@Override
	public void deleteHisBelongings(List<CheckGoods> idList) {
		for (CheckGoods id : idList) {
			safetyCheckDao.deleteHisBelongings(id);
		}
		
	}

	@Override
	public void saveGoodsinspect_police(List<Goodsinspect_police> gpList) {
		for (Goodsinspect_police goodsinspect_police : gpList) {
			safetyCheckDao.saveGoodsinspect_police(goodsinspect_police);
		}
		
	}

	@Override
	public void saveGoodsinspect_dutypolice(List<Goodsinspect_dutypolice> gdpList) {
		for (Goodsinspect_dutypolice goodsinspect_dutypolice : gdpList) {
			safetyCheckDao.saveGoodsinspect_dutypolice(goodsinspect_dutypolice);
		}
		
	}

	@Override
	public void saveGoodsinspect_party(Goodsinspect_party goodsinspect_party) {
		safetyCheckDao.saveGoodsinspect_party(goodsinspect_party);
		
	}

	@Override
	public List<EntryPolicemen> getEntryPolice(String recordNumber) {
		
		return safetyCheckDao.getEntryPolice(recordNumber);
	}

	@Override
	public EntryDutypolice getEntryDutyPolice(String recordNumber) {
		
		return safetyCheckDao.getEntryDutyPolice(recordNumber);
	}


}
