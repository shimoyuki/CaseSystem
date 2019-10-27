package com.sys.service.io;

import java.util.List;

import com.sys.entity.Entry;
import com.sys.entity.EntryPolicemen;
import com.sys.entity.IdentityCard;

public interface EntryService {
	
	void saveIdentityCard(IdentityCard idcard);
	
	List<IdentityCard> getIdentityCardByID(String IDCode);
	
	void saveEntry(Entry entry);
	
	void saveEntryPolicemen(List<EntryPolicemen> entryPolicemen);
	
	String createRecordNumber(String personType,String identification);
}
