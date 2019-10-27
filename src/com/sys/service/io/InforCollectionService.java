package com.sys.service.io;


import java.util.List;

import com.sys.entity.EntryDutypolice;
import com.sys.entity.EntryPolicemen;
import com.sys.entity.InforCollection;

public interface InforCollectionService {
	void saveInforCollection(InforCollection inforCollection);
	
	List<EntryPolicemen> getEntryPolice(String recordNumber);
	
	EntryDutypolice getEntryDutyPolice(String recordNumber);
	
}
