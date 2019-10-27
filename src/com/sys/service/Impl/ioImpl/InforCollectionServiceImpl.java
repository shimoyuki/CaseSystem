package com.sys.service.Impl.ioImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.sys.dao.io.InforCollectionDao;
import com.sys.entity.EntryDutypolice;
import com.sys.entity.EntryPolicemen;
import com.sys.entity.InforCollection;
import com.sys.service.io.InforCollectionService;
@Service("inforCollectionService")
public class InforCollectionServiceImpl implements InforCollectionService {
	
	@Autowired
	@Qualifier("inforCollectionDao")
	private InforCollectionDao inforCollectionDao;
	
	
	@Override
	public void saveInforCollection(InforCollection inforCollection) {
		inforCollectionDao.saveInforCollection(inforCollection);
		
	}


	@Override
	public List<EntryPolicemen> getEntryPolice(String recordNumber) {
		return inforCollectionDao.getEntryPolice(recordNumber);
	}


	@Override
	public EntryDutypolice getEntryDutyPolice(String recordNumber) {
		
		return inforCollectionDao.getEntryDutyPolice(recordNumber);
	}

}
