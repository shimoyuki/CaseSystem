package com.sys.dao.io;

import java.util.List;

import com.sys.entity.Entry;
import com.sys.entity.EntryPolicemen;
import com.sys.entity.IdentityCard;

public interface EntryDao {
	void saveIdentityCard(IdentityCard idcard);
	
	List<IdentityCard> getIdentityCardByID(String IDCode);
	
	void saveEntry(Entry entry);
	
	void saveEntryPolicemen(EntryPolicemen entryPolicemen);
	
	String getNewRecordNumber(String recordNumber);
}
