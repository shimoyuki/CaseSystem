package com.sys.dao.io;

import java.util.List;

import com.sys.entity.CollectionProject;
import com.sys.entity.EntryDutypolice;
import com.sys.entity.EntryPolicemen;
import com.sys.entity.InforCollection;

public interface InforCollectionDao {
	void saveInforCollection(InforCollection inforCollection);
	
	void saveCollection(CollectionProject collection);
	
	List<EntryPolicemen> getEntryPolice(String recordNumber);
	
	EntryDutypolice getEntryDutyPolice(String recordNumber);
}
