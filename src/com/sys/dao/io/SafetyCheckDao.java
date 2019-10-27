package com.sys.dao.io;

import java.util.List;

import org.springframework.stereotype.Repository;

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
@Repository("safetyCheckDao")
public interface SafetyCheckDao {

	void saveSafetyCheckInfo(PersonScrutiny personScrutiny);

	void saveHisBelongings(CheckGoods checkGoods);

	void saveScarTreatment(ScarDetail scarDetail);

	List<CheckGoods> getGoodsList(String recordNumber);

	List<ScarDetail> getScarExplainList(String recordNumber);

	int getScarExplainTotal(String recordNumber);

	int getGoodsTotal(String recordNumber);

	void savePolicemenSignature(ScarInspectPolice scarInspectPolice);

	void saveReviewedSignature(ScarInspectParty scarInspectParty);

	void deleteHisBelongings(CheckGoods id);

	void saveGoodsinspect_party(Goodsinspect_party goodsinspect_party);

	void saveGoodsinspect_police(Goodsinspect_police goodsinspect_police);

	void saveGoodsinspect_dutypolice(Goodsinspect_dutypolice goodsinspect_dutypolice);
	
	List<EntryPolicemen> getEntryPolice(String recordNumber);
	
	EntryDutypolice getEntryDutyPolice(String recordNumber);

}
