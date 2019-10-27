package com.sys.dao.io;

import java.util.List;
import java.util.Map;

import com.sys.entity.ActivityRecord;
import com.sys.entity.CheckGoods;
import com.sys.entity.CurrentSuspectsList;
import com.sys.entity.EntryDutypolice;
import com.sys.entity.EntryPolicemen;
import com.sys.entity.FinallyLeave;
import com.sys.entity.Goodsinspect_dutypolice;
import com.sys.entity.Goodsinspect_party;
import com.sys.entity.Goodsinspect_police;
import com.sys.entity.Infoheader;
import com.sys.entity.InforCollection;
import com.sys.entity.PersonScrutiny;
import com.sys.entity.ScarDetail;
import com.sys.entity.ScarInspectParty;
import com.sys.entity.ScarInspectPolice;
import com.sys.entity.TempOut;

public interface ArchivesManagementDao {

	List<Infoheader> getCurrentSuspects(String curentTime);

	List<CurrentSuspectsList> getCurrentSuspectsList(Map<String, Object> recordFilter);

	int getCurrentSuspectsTotal(Map<String, Object> recordFilter);

	String getCodeByPoliceID(int id);
	
	Infoheader showEntry(String recordNumber); 
	
	List<EntryPolicemen> showEntryPolice(String recordNumber); 
	
	EntryDutypolice showEntryDutyPolice(String recordNumber); 
	
	PersonScrutiny showPersonscrutiny(String recordNumber); 
	
	List<ScarDetail> showScarDetail(String recordNumber); 
	
	List<ScarInspectPolice> showScarPolice(String recordNumber); 
	
	ScarInspectParty showScarParty(String recordNumber); 
	
	List<CheckGoods> showGoods(String recordNumber); 
	
	List<Goodsinspect_police> showGoodsPolice(String recordNumber); 
	
	Goodsinspect_dutypolice showGoodsDutyPolice(String recordNumber); 
	
	Goodsinspect_party showGoodsParty(String recordNumber); 
	
	InforCollection showInforCollection(String recordNumber);
	
	List<ActivityRecord> showActivityrecord(String recordNumber); 
	
	List<TempOut> showTempOut(String recordNumber); 
	
	FinallyLeave showFinalLeave(String recordNumber); 
	
	List<CheckGoods> showReturnGoods(String recordNumber); 

}
